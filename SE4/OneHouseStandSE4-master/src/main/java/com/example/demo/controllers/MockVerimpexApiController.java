package com.example.demo.controllers;

import com.example.demo.domain.Mat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.OhsService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/verimpexapi")
@RestController
@CrossOrigin(origins = "*")
public class MockVerimpexApiController {
    @RequestMapping(value={"/matBestellen"},method=RequestMethod.GET)
    public @ResponseBody Mat[] matBestellen(){
        Mat m1 = new Mat();
        m1.setStatus("goed");
        m1.setProductNummer(200);
        m1.setAankoopPrijs(40.3);
        m1.setLaatstGecheckt(java.sql.Date.valueOf(LocalDate.now()));
        Mat m2 = new Mat();
        m2.setStatus("goed");
        m2.setProductNummer(200);
        m2.setAankoopPrijs(40.3);
        m2.setLaatstGecheckt(java.sql.Date.valueOf(LocalDate.now()));
        Mat m3 = new Mat();
        m3.setStatus("goed");
        m3.setProductNummer(200);
        m3.setAankoopPrijs(40.3);
        m3.setLaatstGecheckt(java.sql.Date.valueOf(LocalDate.now()));
        return new Mat[]{m1,m2,m3};
    }
    @RequestMapping(value={"/matHerstellen"},method=RequestMethod.PUT)
    public @ResponseBody Mat matHerstellen(@RequestBody Mat mat){
        mat.setStatus("goed");
        return mat;
    }
}
