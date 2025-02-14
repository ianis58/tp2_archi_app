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
import javax.persistence.Table;

/**
 * Souscategorie generated by hbm2java
 */
@Entity
@Table(name="souscategorie"
    ,catalog="aaetp"
)
public class Souscategorie  implements java.io.Serializable {


     private Integer idSousCategorie;
     private String nom;
     private Set categories = new HashSet(0);
     private Set articles = new HashSet(0);

    public Souscategorie() {
    }

    public Souscategorie(String nom, Set categories, Set articles) {
       this.nom = nom;
       this.categories = categories;
       this.articles = articles;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="IdSousCategorie", unique=true, nullable=false)
    public Integer getIdSousCategorie() {
        return this.idSousCategorie;
    }
    
    public void setIdSousCategorie(Integer idSousCategorie) {
        this.idSousCategorie = idSousCategorie;
    }

    
    @Column(name="Nom")
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="souscategorie_categorie", catalog="aaetp", joinColumns = { 
        @JoinColumn(name="SousCategorieIdSousCategorie", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="CategorieIdCategorie", nullable=false, updatable=false) })
    public Set getCategories() {
        return this.categories;
    }
    
    public void setCategories(Set categories) {
        this.categories = categories;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="souscategorie_article", catalog="aaetp", joinColumns = { 
        @JoinColumn(name="SousCategorieIdSousCategorie", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="ArticleIdArticle", nullable=false, updatable=false) })
    public Set getArticles() {
        return this.articles;
    }
    
    public void setArticles(Set articles) {
        this.articles = articles;
    }
}
