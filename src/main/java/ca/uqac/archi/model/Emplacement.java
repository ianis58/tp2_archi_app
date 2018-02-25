package ca.uqac.archi.model;
// Generated 24 f�vr. 2018 20:23:59 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Emplacement generated by hbm2java
 */
@Entity
@Table(name="emplacement"
    ,catalog="aaetp"
)
public class Emplacement  implements java.io.Serializable {


     private Integer idEmplacement;
     private int stockIdStock;
     private String allee;
     private String rangee;
     private String etage;

    public Emplacement() {
    }

	
    public Emplacement(int stockIdStock) {
        this.stockIdStock = stockIdStock;
    }
    public Emplacement(int stockIdStock, String allee, String rangee, String etage) {
       this.stockIdStock = stockIdStock;
       this.allee = allee;
       this.rangee = rangee;
       this.etage = etage;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="IdEmplacement", unique=true, nullable=false)
    public Integer getIdEmplacement() {
        return this.idEmplacement;
    }
    
    public void setIdEmplacement(Integer idEmplacement) {
        this.idEmplacement = idEmplacement;
    }

    
    @Column(name="StockIdStock", nullable=false)
    public int getStockIdStock() {
        return this.stockIdStock;
    }
    
    public void setStockIdStock(int stockIdStock) {
        this.stockIdStock = stockIdStock;
    }

    
    @Column(name="Allee")
    public String getAllee() {
        return this.allee;
    }
    
    public void setAllee(String allee) {
        this.allee = allee;
    }

    
    @Column(name="Rangee")
    public String getRangee() {
        return this.rangee;
    }
    
    public void setRangee(String rangee) {
        this.rangee = rangee;
    }

    
    @Column(name="Etage")
    public String getEtage() {
        return this.etage;
    }
    
    public void setEtage(String etage) {
        this.etage = etage;
    }




}


