package ca.uqac.archi.model;
// Generated 1 mars 2018 16:36:01 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Commande generated by hbm2java
 */
@Entity
@Table(name="commande"
    ,catalog="aaetp"
)
public class Commande  implements java.io.Serializable {


     private Integer idCommande;
     private Employe employe;
     private Set factures = new HashSet(0);
     private Set livraisons = new HashSet(0);
     private Set lignecommandes = new HashSet(0);

    public Commande() {
    }

	
    public Commande(Employe employe) {
        this.employe = employe;
    }
    public Commande(Employe employe, Set factures, Set livraisons, Set lignecommandes) {
       this.employe = employe;
       this.factures = factures;
       this.livraisons = livraisons;
       this.lignecommandes = lignecommandes;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="IdCommande", unique=true, nullable=false)
    public Integer getIdCommande() {
        return this.idCommande;
    }
    
    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="EmployeIdPersonne", nullable=false)
    public Employe getEmploye() {
        return this.employe;
    }
    
    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="commande")
    public Set getFactures() {
        return this.factures;
    }
    
    public void setFactures(Set factures) {
        this.factures = factures;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="commande")
    public Set getLivraisons() {
        return this.livraisons;
    }
    
    public void setLivraisons(Set livraisons) {
        this.livraisons = livraisons;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="commande")
    public Set getLignecommandes() {
        return this.lignecommandes;
    }
    
    public void setLignecommandes(Set lignecommandes) {
        this.lignecommandes = lignecommandes;
    }




}


