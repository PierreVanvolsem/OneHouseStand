package com.example.demo.domain;

import javassist.expr.Cast;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name = "MATTEN")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Mat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;

    @Column
    @Range(min = 0L, message = "Prijs moet een positief getal zijn.")
    private double aankoopPrijs;

    @Column
    private Date laatstGecheckt;

    @Column
    private int productNummer;

    @Column
    private String status;


    public void herstel() {
        status = "goed";
        resetLaatstChect();
    }

    public void markeerAlsVersleten() {
        status = "versleten";
        resetLaatstChect();
    }

    public long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getProductNummer() {
        return productNummer;
    }

    private void resetLaatstChect() {
        laatstGecheckt = java.sql.Date.valueOf(LocalDate.now());
    }

    public void setProductNummer(int productNummer) {
        this.productNummer = productNummer;
    }

    public Date getLaatstGecheckt() {
        return laatstGecheckt;
    }

    public void setLaatstGecheckt(Date laatstGecheckt) {
        this.laatstGecheckt = laatstGecheckt;
    }

    public double getAankoopPrijs() {
        return aankoopPrijs;
    }

    public void setAankoopPrijs(double aankoopPrijs) {
        this.aankoopPrijs = aankoopPrijs;
    }

}


