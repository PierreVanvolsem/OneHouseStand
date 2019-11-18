package com.example.demo.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author Fabian
 * @version 1.0
 * @created 15-Mar-2019 18:40:44
 */
@Entity
@Table(name = "REVIEWS")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;

    @NotBlank(message = "Titel mag niet leeg zijn")
    private String titel;

    @NotBlank(message = "Content mag niet leeg zijn")
    private String content;

    @Pattern(regexp = "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$", message = "Vul een geldige datum in")
    private String datum;

    @ManyToOne
    private User gebruiker;

    @Column
    private String status = "Onverwerkt";

	public String getTitel()
	{
		return titel;
	}
    public String getContent()
    {
        return content;
    }
    public String getDatum()
    {
        return datum;
    }
    public User getGebruiker()
    {
        return gebruiker;
    }
    public Pand getPand()
    {
        return pand;
    }
    public int getRating()
    {
        return rating;
    }
    public String getStatus() { return status; }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void setGebruiker(User gebruiker) {
        this.gebruiker = gebruiker;
    }

    public void setPand(Pand pand) {
        this.pand = pand;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setStatus(String status) { this.status = status; }

    @ManyToOne
    @JsonBackReference
    private Pand pand;

    @Range(min = 0L, max = 5L, message = "Min 0 sterren, max 5")
    private int rating;

}