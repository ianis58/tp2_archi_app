package ca.uqac.archi.model;
// Generated 24 fevr. 2018 20:23:59 by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Stock generated by hbm2java
 */
@Entity
@Table(name="stock"
    ,catalog="aaetp"
)
public class Stock  implements java.io.Serializable {


     private Integer idStock;
     private int quantite;
     private Date dateEntree;

    public Stock() {
    }

	
    public Stock(int quantite) {
        this.quantite = quantite;
    }
    public Stock(int quantite, Date dateEntree) {
       this.quantite = quantite;
       this.dateEntree = dateEntree;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="IdStock", unique=true, nullable=false)
    public Integer getIdStock() {
        return this.idStock;
    }
    
    public void setIdStock(Integer idStock) {
        this.idStock = idStock;
    }

    
    @Column(name="Quantite", nullable=false)
    public int getQuantite() {
        return this.quantite;
    }
    
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="DateEntree", length=10)
    public Date getDateEntree() {
        return this.dateEntree;
    }
    
    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }




}


