package com.example.demo.controllers;

import com.example.demo.domain.Pand;
import com.example.demo.domain.Reservatie;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.OhsService;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/circusapi")
@RestController
@CrossOrigin(origins = "*")
public class MockCircusApiController {

    @Autowired
    private OhsService ohsService;
    private List<Pand> fakeCircusDB = Arrays.asList(new Pand(), new Pand(), new Pand());

    @GetMapping("/pand")
    public @ResponseBody
    Pand apiPand(@RequestParam("id") int id) {
        Pand p = fakeCircusDB.get(id);
        return p;
    }
    @RequestMapping(value = {"/reserveerPand"}, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Reservatie reserveer(@RequestBody Reservatie reservatie, HttpServletResponse response, @RequestParam("pandId") long pandId) {

       Pand pand = fakeCircusDB.get((int)pandId);
       pand.reserveer(reservatie);
       return reservatie;
    }
    @GetMapping("/circuspanden")
    public @ResponseBody
    Pand[] circusapiPanden() {
        Pand pand1 = new Pand();
        pand1.setBron("Start Up Circus");
        pand1.setHuisNummer("99");
        pand1.setPrijsPerUur(15.9);
        pand1.setStatus("Goedgekeurd");
        pand1.setStraatNaam("H. Torleylaan");

        Pand pand2 = new Pand();
        pand2.setBron("Start Up Circus");
        pand2.setHuisNummer("99");
        pand2.setPrijsPerUur(15.9);
        pand2.setStatus("Goedgekeurd");
        pand2.setStraatNaam("H. Torleylaan");

        Pand pand3 = new Pand();
        pand3.setBron("Start Up Circus");
        pand3.setHuisNummer("99");
        pand3.setPrijsPerUur(15.9);
        pand3.setStatus("Goedgekeurd");
        pand3.setStraatNaam("H. Torleylaan");
        return new Pand[]{pand1,pand2,pand3};
    }
}
