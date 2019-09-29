package com.example.demo.formdata;

import com.example.demo.domain.Mat;
import com.example.demo.domain.Reservatie;
import com.example.demo.domain.Verhuurder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class PandData {

    private long id=0;

    private String bron = "ohs";

    @NotBlank(message = "Huisnummer is vereist.")
    private String huisNummer;

    @Range(min = 0l, message = "Prijs per uur moet een positief getal zijn.")
    @NotNull(message = "Prijs per uur is vereist.")
    private Double prijsPerUur;

    private String status = "ongekeurd";

    @NotBlank(message = "Straatnaam is vereist.")
    private String straatNaam;

}
