package com.example.demo.controllers;

import com.example.demo.domain.Pand;
import com.example.demo.domain.Reservatie;
import com.example.demo.service.OhsService;
import com.example.demo.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@RequestMapping(path = "/api", produces = "application/json")
@RestController
@CrossOrigin(origins = "*")
public class ApiController {

    @Autowired
    private OhsService ohsService;

    @GetMapping("/pand")
    public @ResponseBody
    Pand apiPand(@RequestParam("id") int id) {
        return ohsService.geefPand(id);
    }

    @GetMapping("/panden")
    public @ResponseBody
    Iterable<Pand> apiPanden() {
        return ohsService.geefAlleGoedgekeurdePanden();
    }

    @RequestMapping(value = {"/reserveer"}, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    Reservatie reserveer(@RequestBody Reservatie reservatie, HttpServletResponse response, @RequestParam("pandId") long pandId) {
        Reservatie r = ohsService.processReservatie(reservatie, pandId);
        return reservatie;
    }


}
