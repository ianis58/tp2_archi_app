/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uqac.archi.action;

import ca.uqac.archi.dao.ArticleDAO;
import ca.uqac.archi.model.Article;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import freemarker.core.ParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author almes
 */
public class ArticleAction extends ActionSupport{
    private static final long serialVersionUID = 1L;
    private Article art = new Article();
    private List<Article> listArticles;

    private ArticleDAO dao;
    private String action;

    public ArticleAction() {
         dao = new ArticleDAO();
    }

    @Override
    public String execute() {
        action = "articleCRUD";
        listArticles = dao.list();
        return SUCCESS;
    }
    
    // fonction de validation de champs
    public String customValidate(){
        String val = SUCCESS;
        Article artVerif = dao.find(art.getNom());
        if(art.getNom().length() < 1 || art.getNom().equals(" ")){
            this.addActionError("Entrez un nom svp !");
            val = INPUT;
        }
        if(artVerif.getNom() != null){
            this.addActionError("Ce nom existe déjà !");
            val = INPUT;
        }
        if(artVerif.getReference() != null){
            this.addActionError("Cette reference existe déjà !");
            val = INPUT;
        }
        artVerif = null;
        return val;
    }

    public String add() throws ParseException {
        //System.out.println(cat);
        String val = customValidate();
        if(val == SUCCESS){
            try {
                //dao.add(art);
            } catch (Exception e) {
                e.printStackTrace();
            }
            listArticles = dao.list();
            return SUCCESS;
        }else{
            listArticles = dao.list();
            return INPUT;
        }
    }

    public String update() throws ParseException{
        //System.out.println(getCat());
        String val = customValidate();
        if(val == SUCCESS){
            try {
             dao.update(cat);
             cat = null;
            } catch (Exception e) {
                e.printStackTrace();
            }

            listCategories = dao.list();
            return SUCCESS;
        }else{
            listCategories = dao.list();
            return INPUT;
        }
        
    }

    public String delete() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        System.out.println("id value="+Long.parseLong( request.getParameter("id")));
        this.setId(Integer.parseInt(request.getParameter("id")));
        try {
             dao.deleteCategorie(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        listCategories = dao.list();
        return SUCCESS;
    }

    public Article getArt() {
        return art;
    }

    public void setCat(Article art) {
        this.art = art;
    }

   public List<Article> getListCategories() {
        return listArticles;
    }

    public void setListCategories(List<Article> listArticles) {
        this.listArticles = listArticles;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
