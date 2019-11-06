package com.example.demo.controllers;


import com.example.demo.domain.Mat;
import com.example.demo.domain.Pand;
import com.example.demo.service.OhsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RequestMapping("/screener")
@Controller
@PostAuthorize("#model.get('role').user.username == authentication.principal.username")
@Secured({"SCREENER"})
public class ScreenerController {

    @Autowired
    private OhsService ohsService;

    @GetMapping("/editPand")
    public String EditPandForm(Model model, @RequestParam("id") long id) {

        Pand pand = ohsService.geefPand((int) id);
        Iterable<Mat> matten = pand.getMatten();

        model.addAttribute("id", pand.getId());
        model.addAttribute("pand", pand);
        model.addAttribute("mat", new Mat());
        model.addAttribute("lijstMatten", matten);

        return "editPand";
    }

    @PostMapping(path = "/editPand")
    public String processWijzigenPand(@Valid Pand pand, Errors errors, Model model, @RequestParam("id") long id) {
        if (errors.hasErrors()) {
            model.addAttribute("id", id);
            return "editPand";
        }

        ohsService.editPand(pand, id);
        Iterable<Pand> panden = ohsService.geefAllePanden();
        model.addAttribute("lijstPanden", panden);
        return "panden";
    }

    @PostMapping(path = "/goedkeurenPand")
    public String processGoedkeurenPand(Model model, @RequestParam("id") long id) {

        Pand pand = ohsService.geefPand((int) id);

        assert pand != null;
        pand.setStatus("goedgekeurd");

        ohsService.editPand(pand, id);

        Iterable<Pand> panden = ohsService.geefAllePanden();
        model.addAttribute("lijstPanden", panden);
        return "panden";
    }

    @PostMapping(path = "/afkeurenPand")
    public String processAfkeurenPand(Model model, @RequestParam("id") long id) {

        Pand pand = ohsService.geefPand((int) id);

        assert pand != null;
        pand.setStatus("afgekeurd");
        System.out.println(pand);

        ohsService.editPand(pand, id);

        Iterable<Pand> panden = ohsService.geefAllePanden();
        model.addAttribute("lijstPanden", panden);
        return "panden";
    }

    @PostMapping("/deletePand")
    public String deletePand(@RequestParam("id") long id, Model model) {
        ohsService.deletePand(id);
        Iterable<Pand> panden = ohsService.geefAllePanden();
        model.addAttribute("lijstPanden", panden);
        return "panden";
    }

    @GetMapping("/panden")
    public String pandenLijstTonenScreener(Model model) {
        Iterable<Pand> panden = ohsService.geefAllePanden();
        model.addAttribute("lijstPanden", panden);
        return "panden";
    }

    private RestTemplate rt = new RestTemplate();
    private Mat[] matten;

    @PostMapping("/bestellenMat")
    public String processBestellenMat(Model model, @RequestParam("id") long id) {
        {
            matten = rt.getForObject("http://localhost:8090/matBestellen", Mat[].class);
            Pand pand = ohsService.geefPand((int) id);

            for (Mat m : matten) {
                ohsService.addMat(m);
                System.out.println(m.getStatus());
                pand.matToevoegen(m);
                ohsService.editPand(pand, id);
            }

            model.addAttribute("id", pand.getId());
            model.addAttribute("pand", pand);
            return "editPand";
        }
    }
}
