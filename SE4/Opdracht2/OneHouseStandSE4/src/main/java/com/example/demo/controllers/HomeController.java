package com.example.demo.controllers;

import com.example.demo.domain.Pand;
import com.example.demo.domain.Reservatie;
import com.example.demo.domain.Review;
import com.example.demo.domain.User;
import com.example.demo.service.OhsService;
import com.example.demo.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

@Controller
public class HomeController {

    @Autowired
    private UserDetailsServiceImpl service;

    @Autowired
    private OhsService ohsService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login-error")
    public String loginerror(Model model) {
        model.addAttribute("error", true);
        return "login";
    }

    @GetMapping("/403")
    public String accessDeinied(Model model) {
        return "403";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/registreer")
    public String registreer(Model model) {
        User u = new User();
        model.addAttribute("user", u);
        return "registreer";
    }

    @PostMapping(path = "/registreer")
    public String registreerUitvoeren(@Valid User u, Errors err, Model model) {
        if (err.hasErrors())
            return "registreer";

        service.verwerkRegistratie(u);
        return "login";
    }

    @GetMapping("/aanbod")
    public String aanbod(Model model) {
        RestTemplate rt = new RestTemplate();
        Pand[] circuspanden = rt.getForObject("http://localhost:8080/circusapi/circuspanden", Pand[].class);
        assert circuspanden != null;

        Iterable<Pand> panden = ohsService.geefAlleGoedgekeurdePanden();
        ArrayList<Pand> mergedPanden = new ArrayList<>(Arrays.asList(circuspanden));
        for (Pand pand : panden) {
            mergedPanden.add(pand);
        }

        model.addAttribute("lijstPanden", mergedPanden);
        return "aanbod";
    }

    @GetMapping("/pand")
    public String pandDetailForm(Model model, @RequestParam("id") long id) {
        if (id == 0) {
            return "startupcircuspand";
        } else {
            Pand pand = ohsService.geefPand((int) id);
            model.addAttribute("reviews", ohsService.getReviewsPandById(id));
            model.addAttribute("reservatie", new Reservatie());
            model.addAttribute("pand", pand);
            model.addAttribute("review", new Review());
            return "pand";
        }
    }

    @GetMapping("/byebye")
    public String uitloggen() {
        return "byebye";
    }
}

