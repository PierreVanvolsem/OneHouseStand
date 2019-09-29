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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RequestMapping("/syndicus")
@Controller
@PostAuthorize("#model.get('role').user.username == authentication.principal.username")
@Secured({"SYNDICUS"})
public class SyndicusController {

    @Autowired
    private OhsService ohsService;

    @GetMapping(path = "/matToevoegen")
    public String matToevoegen(Model model, @RequestParam("id") long pandID) {

        Mat mat = new Mat();
        mat.setStatus("goed");
        Pand pand = getPandById(pandID);

        model.addAttribute("mat", mat);
        model.addAttribute("pand", pand);
        return "matToevoegen";
    }

    @PostMapping(path = "/matToevoegen")
    public String processToevoegenMat(Model model, @Valid Mat mat, @RequestParam("id") long id, Errors errors) {
        Pand pand = getPandById(id);
//        mat.setLaatstGecheckt(new Date(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth()));
//        assert pand != null;
//        pand.voegMatToe(mat);

        Mat[] matten = rt.getForObject("http://localhost:8080/circusapi/circuspanden", Mat[].class);

        assert matten != null;
        for (Mat mat1 : matten) {
            ohsService.addMat(mat1);
            assert pand != null;
            pand.voegMatToe(mat1);
        }

        ohsService.editPand(pand, pand.getId());

        ohsService.verwerkMatToevoegen(mat, pand);

        return mattenTonenSyndicus(model);
    }

    @GetMapping("/matten")
    public String mattenTonenSyndicus(Model model) {
        Iterable<Mat> matten = ohsService.geefAlleMatten();
        Iterable<Pand> panden = ohsService.geefAllePanden();

        model.addAttribute("lijstMatten", matten);
        model.addAttribute("lijstPanden", panden);

        return "matten";
    }

    @GetMapping("/mat")
    public String editMatForm(Model model, @RequestParam("id") int id) {
        Mat m = ohsService.geefMat(id);
        model.addAttribute("mat", m);
        return "editMat";
    }

    RestTemplate rt = new RestTemplate();

    @PostMapping(path = "/herstelMat")
    public String processHerstelMat(Model model, @RequestParam("id") int id) {

        Mat m = ohsService.geefMat(id);

        rt.put("http://localhost:8090/matHerstellen", m, m);
        ohsService.herstelMat(m);

        model.addAttribute("mat", m);
        return "editMat";
    }

    @PostMapping(path = "/zetMatAlsVersleten")
    public String processVersletenMat(Model model, @RequestParam("id") int id) {
        Mat m = ohsService.geefMat(id);
        ohsService.zetMatAlsVersleten(m);
        model.addAttribute("mat", m);

        return "editMat";
    }

//    @GetMapping(path = "/editMat")
//    public String editMat(Model model, @RequestParam("id") long id) {
//        Mat mat = getMatById(id);
//
//        model.addAttribute("mat", mat);
//        return "editMat";
//    }

    private Pand getPandById(long id) {
        Iterable<Pand> panden = ohsService.geefAllePanden();

        for (Pand pand : panden) {
            if (pand.getId() == id) {
                return pand;
            }
        }
        return null;
    }

    private Mat getMatById(long id) {
        Iterable<Mat> matten = ohsService.geefAlleMatten();

        for (Mat mat : matten) {
            if (mat.getId() == id) {
                return mat;
            }
        }
        return null;
    }

}
