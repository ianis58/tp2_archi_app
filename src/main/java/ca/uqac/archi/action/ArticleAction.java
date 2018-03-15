/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uqac.archi.action;

import ca.uqac.archi.dao.ArticleDAO;
import ca.uqac.archi.dao.SouscategorieDAO;
import ca.uqac.archi.dao.MarqueDAO;
import ca.uqac.archi.model.Article;
import ca.uqac.archi.model.Souscategorie;
import ca.uqac.archi.model.Marque;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import freemarker.core.ParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author nruj
 */
public class ArticleAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private Article art = new Article();
    private List<Article> listArticles;
    private List<Souscategorie> listAllSousCategories;
    private List<Marque> listMarques;

    private ArticleDAO dao;
    private SouscategorieDAO souscat_dao;
    private MarqueDAO marque_dao;
    private String action;
    private int nbr_stock;

    public ArticleAction() {
        dao = new ArticleDAO();
        souscat_dao = new SouscategorieDAO();
        marque_dao = new MarqueDAO();
    }

    @Override
    public String execute() {
        action = "articleCRUD";
        listArticles = dao.list();
        listAllSousCategories = souscat_dao.getAllSouscategories();
        listMarques = marque_dao.list();
        return SUCCESS;
    }

    // fonction de validation de champs
    public String customValidate() {
        String val = SUCCESS;
        Article artVerif = dao.find(art.getNom());
        if (art.getNom().length() < 1 || art.getNom().equals(" ")) {
            this.addActionError("Entrez un nom svp !");
            val = INPUT;
        }
        if (artVerif.getNom() != null) {
            this.addActionError("Ce nom existe déjà !");
            val = INPUT;
        }
        if (artVerif.getReference() != null) {
            this.addActionError("Cette reference existe déjà !");
            val = INPUT;
        }
        artVerif = null;
        return val;
    }

    public String add() throws ParseException {
        String val = customValidate();
        if (val == SUCCESS) {
            try {
                dao.add(art);
            } catch (Exception e) {
                e.printStackTrace();
            }
            listArticles = dao.list();
            return SUCCESS;
        } else {
            listArticles = dao.list();
            return INPUT;
        }
    }

    public Article getArt() {
        return art;
    }

    public void setArt(Article art) {
        this.art = art;
    }

    public List<Article> getListArticles() {
        return listArticles;
    }

    public void setListArticles(List<Article> listArticles) {
        this.listArticles = listArticles;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getNbr_stock() {
        return nbr_stock;
    }

    public void setNbr_stock(int stock) {
        nbr_stock = stock;
    }

    public List<Souscategorie> getListAllSousCategories() {
        return listAllSousCategories;
    }

    public void setListAllSousCategories(List<Souscategorie> listAllSousCategories) {
        this.listAllSousCategories = listAllSousCategories;
    }

    public List<Marque> getListMarques() {
        return listMarques;
    }

    public void setListMarques(List<Marque> listMarques) {
        this.listMarques = listMarques;
    }

}
