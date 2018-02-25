package ca.uqac.archi.model;
// Generated 24 fevr. 2018 20:23:59 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VehiculeArticleId generated by hbm2java
 */
@Embeddable
public class VehiculeArticleId  implements java.io.Serializable {


     private int vehiculeIdVehicule;
     private int articleIdArticle;

    public VehiculeArticleId() {
    }

    public VehiculeArticleId(int vehiculeIdVehicule, int articleIdArticle) {
       this.vehiculeIdVehicule = vehiculeIdVehicule;
       this.articleIdArticle = articleIdArticle;
    }
   


    @Column(name="VehiculeIdVehicule", nullable=false)
    public int getVehiculeIdVehicule() {
        return this.vehiculeIdVehicule;
    }
    
    public void setVehiculeIdVehicule(int vehiculeIdVehicule) {
        this.vehiculeIdVehicule = vehiculeIdVehicule;
    }


    @Column(name="ArticleIdArticle", nullable=false)
    public int getArticleIdArticle() {
        return this.articleIdArticle;
    }
    
    public void setArticleIdArticle(int articleIdArticle) {
        this.articleIdArticle = articleIdArticle;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VehiculeArticleId) ) return false;
		 VehiculeArticleId castOther = ( VehiculeArticleId ) other; 
         
		 return (this.getVehiculeIdVehicule()==castOther.getVehiculeIdVehicule())
 && (this.getArticleIdArticle()==castOther.getArticleIdArticle());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getVehiculeIdVehicule();
         result = 37 * result + this.getArticleIdArticle();
         return result;
   }   


}


