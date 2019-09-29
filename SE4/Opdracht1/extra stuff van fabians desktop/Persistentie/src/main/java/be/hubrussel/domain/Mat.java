package be.hubrussel.domain;


import javax.persistence.*;
import java.util.Date;

/**
 * @author Fabian
 * @version 1.0
 * @created 05-mars-2019 10:10:02
 */
@Entity
@Table(name = "matten")
public class Mat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private double aankoopPrijs;

    @Column
    private Date laatstGecheckt;

    @Column
    private String status;

    @Column
    private int productNummer;

    public Mat() {

    }

    public Mat(double aankoopPrijs, Date laatstGecheckt, String status, int productNummer) {
        this.aankoopPrijs = aankoopPrijs;
        this.laatstGecheckt = laatstGecheckt;
        this.status = status;
        this.productNummer = productNummer;
    }

    public Mat(int id, double aankoopPrijs, Date laatstGecheckt, String status, int productNummer) {
        this.id = id;
        this.aankoopPrijs = aankoopPrijs;
        this.laatstGecheckt = laatstGecheckt;
        this.status = status;
        this.productNummer = productNummer;
    }

    public String getStatus() {
        return this.status;
    }
    public void herstel() {
        this.status = "Goed";
    }

    public void markeerAlsVersleten() {
        this.status = "Versleten";
    }
}//end Mat