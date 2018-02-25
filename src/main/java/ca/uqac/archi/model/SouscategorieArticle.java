package ca.uqac.archi.model;
// Generated 24 f�vr. 2018 20:23:59 by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * SouscategorieArticle generated by hbm2java
 */
@Entity
@Table(name="souscategorie_article"
    ,catalog="aaetp"
)
public class SouscategorieArticle  implements java.io.Serializable {


     private SouscategorieArticleId id;

    public SouscategorieArticle() {
    }

    public SouscategorieArticle(SouscategorieArticleId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="sousCategorieIdSousCategorie", column=@Column(name="SousCategorieIdSousCategorie", nullable=false) ), 
        @AttributeOverride(name="articleIdArticle", column=@Column(name="ArticleIdArticle", nullable=false) ) } )
    public SouscategorieArticleId getId() {
        return this.id;
    }
    
    public void setId(SouscategorieArticleId id) {
        this.id = id;
    }




}


