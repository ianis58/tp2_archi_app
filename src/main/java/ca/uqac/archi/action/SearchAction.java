package ca.uqac.archi.action;

import static ca.uqac.archi.action.ManageSousCategoriesAction.categorieDAO;
import ca.uqac.archi.dao.ArticleDAO;
import ca.uqac.archi.model.Article;
import ca.uqac.archi.model.Categorie;
import ca.uqac.archi.model.Souscategorie;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SearchAction extends ActionSupport implements Preparable {

    private ArticleDAO articleDAO = new ArticleDAO();

    private Article art = new Article();
    private List<Article> listRecherche;

    private String action;

    private List<Categorie> listAllCategories = new ArrayList<>();
    private Integer searchCategorieId;
    private Categorie searchCategorie;

    private List<Souscategorie> listAllSousCategories = new ArrayList<>();
    private Integer searchSouscategorieId;

    @Override
    public String execute() {

        listRecherche = articleDAO.list();

        listAllCategories = categorieDAO.list();
        if (searchCategorie != null) {
            //listAllSousCategories.add(searchCategorie.getSouscategories()); 
            Set<Souscategorie> SetSousCategories = searchCategorie.getSouscategories();
            for (Souscategorie souscategorie : SetSousCategories) {
                listAllSousCategories.add(souscategorie);
            }
        }

        return SUCCESS;
    }

    public String AdvanceSearch() {
        Set<Souscategorie> setSousCategories = null;
        listRecherche = articleDAO.AdvanceSearch(searchCategorieId);
        searchCategorie = categorieDAO.find(searchCategorieId);
        if (searchCategorie != null) {
            //listAllSousCategories.add(searchCategorie.getSouscategories()); 
            setSousCategories = searchCategorie.getSouscategories();
            for (Souscategorie souscategorie : setSousCategories) {
                listAllSousCategories.add(souscategorie);
            }
        }
        System.out.println("hfusfhufihhgfdfhgudfghud");
        return SUCCESS;
    }

    public String FinalSearch() {
        listRecherche = articleDAO.FinalSearch(searchSouscategorieId);
        return SUCCESS;
    }

    public String processSimpleSearch() throws Exception {
        if (this.art.getNom().trim().equals("")) {
            listRecherche = articleDAO.list();
            listAllCategories = categorieDAO.list();
        } else {
            listRecherche = articleDAO.recherche(this.art.getNom());
            listAllCategories = categorieDAO.list();
        }
        return SUCCESS;
    }

    public List<Article> getListRecherche() {
        return listRecherche;
    }

    public void setListRecherche(List<Article> listRecherche) {
        this.listRecherche = listRecherche;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Article getArt() {
        return art;
    }

    public void setArt(Article art) {
        this.art = art;
    }

    //pour la recherche avance
    public List<Categorie> getListAllCategories() {
        return listAllCategories;
    }

    public void setListAllCategories(List<Categorie> listAllCategories) {
        this.listAllCategories = listAllCategories;
    }

    public Integer getSearchCategorieId() {
        return searchCategorieId;
    }

    public void setSearchCategorieId(Integer searchCategorieId) {
        this.searchCategorieId = searchCategorieId;
    }

    public Categorie getSearchCategorie() {
        return searchCategorie;
    }

    public void setSearchCategorie(Categorie searchCategorie) {
        this.searchCategorie = searchCategorie;
    }

    public List<Souscategorie> getListAllSousCategories() {
        return listAllSousCategories;
    }

    public void setListAllSousCategories(List<Souscategorie> listAllSousCategories) {
        this.listAllSousCategories = listAllSousCategories;
    }

    public Integer getSearchSouscategorieId() {
        return searchSouscategorieId;
    }

    public void setSearchSouscategorieId(Integer searchSouscategorieId) {
        this.searchSouscategorieId = searchSouscategorieId;
    }

    @Override
    public void prepare() throws Exception {
        listAllCategories = categorieDAO.list();
    }

}
