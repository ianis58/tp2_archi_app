package ca.uqac.archi.model;
// Generated 1 mars 2018 16:36:01 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Lignecommande generated by hbm2java
 */
@Entity
@Table(name="lignecommande"
    ,catalog="aaetp"
)
public class Lignecommande  implements java.io.Serializable {


     private Integer idLigneCommande;
     private Article article;
     private Commande commande;
     private int quantite;

    public Lignecommande() {
    }

    public Lignecommande(Article article, Commande commande, int quantite) {
       this.article = article;
       this.commande = commande;
       this.quantite = quantite;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="IdLigneCommande", unique=true, nullable=false)
    public Integer getIdLigneCommande() {
        return this.idLigneCommande;
    }
    
    public void setIdLigneCommande(Integer idLigneCommande) {
        this.idLigneCommande = idLigneCommande;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ArticleIdArticle", nullable=false)
    public Article getArticle() {
        return this.article;
    }
    
    public void setArticle(Article article) {
        this.article = article;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CommandeIdCommande", nullable=false)
    public Commande getCommande() {
        return this.commande;
    }
    
    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    
    @Column(name="Quantite", nullable=false)
    public int getQuantite() {
        return this.quantite;
    }
    
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }




}


