package com.example.demo.domain;


import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Fabian
 * @version 1.0
 * @created 15-Mar-2019 18:40:44
 */
@Entity
@Table(name = "RESERVATIES")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@XmlRootElement(name = "reservatie")
public class Reservatie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;

    @Column
    @Range(min = 1L, message = "Er moet minstens 1 persoon aanwezig zijn")
    private int aantalPersonen;

    @Column
    @Pattern(regexp = "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$", message = "Vul een geldige datum in")
    private String eindDatum;

    public void setEindDatum(String eindDatum) {
        this.eindDatum = eindDatum;
    }

    public void setAantalPersonen(int aantalPersonen) {
        this.aantalPersonen = aantalPersonen;
    }

    @XmlElement(name = "id")
    public long getId() {
        return id;
    }

    @XmlElement(name = "aantalpersonen")
    public int getAantalPersonen() {
        return aantalPersonen;
    }

    @XmlElement(name = "einddatum")
    public String getEindDatum() {
        return eindDatum;
    }

    //	private Huurder huurder;
//	private Pand pand;
//	private Double prijs;
//	private Date startDatum;
//	public Huurder m_Huurder;
//	public Pand m_Pand;


}//end Reservatie