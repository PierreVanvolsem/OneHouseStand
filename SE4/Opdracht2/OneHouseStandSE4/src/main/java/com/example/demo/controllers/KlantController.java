package com.example.demo.controllers;

import com.example.demo.domain.*;
import com.example.demo.service.OhsService;
import com.example.demo.service.OhsServiceImplementatie;
import com.example.demo.service.UserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Convert;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Map;

@RequestMapping("/klant")
@Controller
@PostAuthorize("#model.get('role').user.username == authentication.principal.username")
@Secured({"KLANT"})
public class KlantController {

    @Autowired
    private OhsService ohsService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping("/pandToevoegen")
    public String toevoegenPandForm(Model model) {
        model.addAttribute("pand", new Pand());
        return "pandToevoegen";
    }

    @PostMapping(path = "/pandToevoegen")
    public String processToevoegenPand(@Valid Pand pand, Errors errors, Model model) {
        if (errors.hasErrors())
            return "pandToevoegen";

        User user = userDetailsService.getUser();
        ohsService.addPand(pand, user);

        model.addAttribute("sucess", true);
        model.addAttribute("pand", new Pand());
        return "pandToevoegen";
    }

    @PostMapping(path = "/reserveerPand")
    public String processReserveerPand(@Valid Reservatie reservatie, Errors errors, Model model, @RequestParam("id") long pandId) {
        if (errors.hasErrors()) {
//            preparePandModel(model, ohsService.geefPand((int) pandId));
            model.addAttribute("pand", ohsService.geefPand((int) pandId));
            model.addAttribute("review", new Review());

            return "pand";
        }

        Reservatie r = ohsService.processReservatie(reservatie, pandId);
        Pand p = ohsService.geefPand((int) pandId);

        preparePandModel(model, p);
        return "pand";
    }

    @PostMapping(path = "/reviewPand")
    public String processReviewPand(@Valid Review r, Errors errors, Model model, @RequestParam("id") long pandId) {
        if (errors.hasErrors()) {
            Pand pand = ohsService.geefPand((int) pandId);

            model.addAttribute("reviews", ohsService.getReviewsPandById(pandId));
            model.addAttribute("pand", pand);
            model.addAttribute("review", new Review());
            model.addAttribute("reservatie", new Reservatie());
            model.addAttribute("pand", ohsService.geefPand((int) pandId));
            return "pand";
        }

        User u = userDetailsService.getUser();
        Review review = ohsService.processReview(r, pandId, u);
        Pand p = ohsService.geefPand((int) pandId);

        preparePandModel(model, p);
        model.addAttribute("reviewSuccess", true);
        Pand pand = ohsService.geefPand((int) pandId);
        model.addAttribute("reviews", ohsService.getReviewsPandById(pandId));
        model.addAttribute("reservatie", new Reservatie());
        model.addAttribute("pand", pand);
        model.addAttribute("review", new Review());

        return "pand";
    }

    private void preparePandModel(Model model, Pand p) {
        model.addAttribute("reservatie", new Reservatie());
        model.addAttribute("review", new Review());
        model.addAttribute("pand", p);
    }
}
