/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uqac.archi.action;

import ca.uqac.archi.dao.ArticleDAO;
import ca.uqac.archi.model.Article;
import ca.uqac.archi.util.HibernateUtil;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author arthu
 */
public class SearchAction extends ActionSupport{
    public static ArticleDAO articleDAO = new ArticleDAO();
    
    private List<Article> listeArticles;
    private String nom;

    public String execute() {
        this.listeArticles = articleDAO.list();
        return SUCCESS;
    }
    public String simpleSearch()throws Exception{
        this.listeArticles = articleDAO.list();
        return SUCCESS;
    }
    public String processSimpleSearch()throws Exception{
        if(this.nom.trim().equals("")){
            this.listeArticles = articleDAO.list();
        }else{
            this.listeArticles = articleDAO.recherche(this.nom);
            
        }
        return SUCCESS;
    }
    
    public String getNom(){
        return nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public List<Article> getListArticles() {
        return listeArticles;
    }

    public void setListCategories(List<Article> listCategories) {
        this.listeArticles = listCategories;
    }

}
