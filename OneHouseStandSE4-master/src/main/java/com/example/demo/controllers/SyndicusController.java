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

@RequestMapping("/syndicus")
@Controller
@PostAuthorize("#model.get('role').user.username == authentication.principal.username")
@Secured({"SYNDICUS"})
public class SyndicusController {

    @Autowired
    private OhsService ohsService;

    private RestTemplate rt = new RestTemplate();

    @GetMapping(path = "/matToevoegen")
    public String matToevoegen(Model model, @RequestParam("id") long pandID) {

        Mat mat = new Mat();
        mat.setStatus("goed");
        Pand pand = ohsService.geefPand((int) pandID);

        model.addAttribute("mat", mat);
        model.addAttribute("pand", pand);
        return "matToevoegen";
    }

    /**
     * Voegt mat toe aan de api van verimpex, vervolgens wordt het pand opgeslagen in ohs zijn db.
     *
     * @param model
     * @param mat
     * @param id
     * @param errors
     * @return
     */
    @PostMapping(path = "/matToevoegen")
    public String processToevoegenMat(Model model, @Valid Mat mat, @RequestParam("id") long id, Errors errors) {
        Pand pand = ohsService.geefPand((int) id);
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

    /**
     * Haalt de mat op van verimpex en geeft ze weer op de editMat pagina
     * @param model
     * @param id
     * @return
     */
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

}
