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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Article generated by hbm2java
 */
@Entity
@Table(name="article"
    ,catalog="aaetp"
)
public class Article  implements java.io.Serializable {


     private Integer idArticle;
     private Marque marque;
     private String nom;
     private String reference;
     private float prix;
     private String description;
     private Set lignecommandes = new HashSet(0);
     private Set stocks = new HashSet(0);
     private Set vehicules = new HashSet(0);
     private Set souscategories = new HashSet(0);

    public Article() {
    }

	
    public Article(Marque marque, float prix) {
        this.marque = marque;
        this.prix = prix;
    }
    public Article(Marque marque, String nom, String reference, float prix, String description, Set lignecommandes, Set stocks, Set vehicules, Set souscategories) {
       this.marque = marque;
       this.nom = nom;
       this.reference = reference;
       this.prix = prix;
       this.description = description;
       this.lignecommandes = lignecommandes;
       this.stocks = stocks;
       this.vehicules = vehicules;
       this.souscategories = souscategories;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="IdArticle", unique=true, nullable=false)
    public Integer getIdArticle() {
        return this.idArticle;
    }
    
    public void setIdArticle(Integer idArticle) {
        this.idArticle = idArticle;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="MarqueIdMarque", nullable=false)
    public Marque getMarque() {
        return this.marque;
    }
    
    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    
    @Column(name="Nom")
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    
    @Column(name="Reference")
    public String getReference() {
        return this.reference;
    }
    
    public void setReference(String reference) {
        this.reference = reference;
    }

    
    @Column(name="Prix", nullable=false, precision=12, scale=0)
    public float getPrix() {
        return this.prix;
    }
    
    public void setPrix(float prix) {
        this.prix = prix;
    }

    
    @Column(name="Description")
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="article")
    public Set getLignecommandes() {
        return this.lignecommandes;
    }
    
    public void setLignecommandes(Set lignecommandes) {
        this.lignecommandes = lignecommandes;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="stock_article", catalog="aaetp", joinColumns = { 
        @JoinColumn(name="ArticleIdArticle", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="StockIdStock", nullable=false, updatable=false) })
    public Set getStocks() {
        return this.stocks;
    }
    
    public void setStocks(Set stocks) {
        this.stocks = stocks;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="vehicule_article", catalog="aaetp", joinColumns = { 
        @JoinColumn(name="ArticleIdArticle", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="VehiculeIdVehicule", nullable=false, updatable=false) })
    public Set getVehicules() {
        return this.vehicules;
    }
    
    public void setVehicules(Set vehicules) {
        this.vehicules = vehicules;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="souscategorie_article", catalog="aaetp", joinColumns = { 
        @JoinColumn(name="ArticleIdArticle", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="SousCategorieIdSousCategorie", nullable=false, updatable=false) })
    public Set getSouscategories() {
        return this.souscategories;
    }
    
    public void setSouscategories(Set souscategories) {
        this.souscategories = souscategories;
    }




}


