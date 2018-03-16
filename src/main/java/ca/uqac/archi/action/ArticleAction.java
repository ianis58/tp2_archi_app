package ca.uqac.archi.action;

import ca.uqac.archi.dao.VehiculeDAO;
import ca.uqac.archi.dao.ArticleDAO;
import ca.uqac.archi.dao.SouscategorieDAO;
import ca.uqac.archi.dao.MarqueDAO;
import ca.uqac.archi.model.Article;
import ca.uqac.archi.model.Souscategorie;
import ca.uqac.archi.model.Marque;
import ca.uqac.archi.model.Vehicule;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import freemarker.core.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class ArticleAction extends ActionSupport {

    private Article art = new Article();
    private List<Article> listArticles;
    private List<Souscategorie> listAllSousCategories;
    private List<Marque> listMarques = new ArrayList<>();
    ;
    private List<Vehicule> listVehicules;

    private ArticleDAO dao;
    private SouscategorieDAO souscat_dao;
    private MarqueDAO marque_dao;
    private VehiculeDAO veh_dao;

    private String action;
    private int nbr_stock;

    private int linkedMarqueIds;

    private ArrayList<Integer> linkedSousCategoriesIds;

    private ArrayList<Integer> linkedVehIds;

    private Set<Souscategorie> sousCategorieSet;

    private Set<Vehicule> VehiculeSet;

    private int id = 0;

    public ArticleAction() {
        dao = new ArticleDAO();
        souscat_dao = new SouscategorieDAO();
        marque_dao = new MarqueDAO();
        veh_dao = new VehiculeDAO();
    }

    @Override
    public String execute() {
        action = "articleCRUD";
        listArticles = dao.list();
        listAllSousCategories = souscat_dao.getAllSouscategories();
        listMarques = marque_dao.list();
        listVehicules = veh_dao.list();
        linkedSousCategoriesIds = new ArrayList<>();
        linkedVehIds = new ArrayList<>();

        if (id != 0) {
            art = dao.findById(id);
            VehiculeSet = art.getVehicules();
            sousCategorieSet = art.getSouscategories();
            for (Vehicule vehicule : VehiculeSet) {
                linkedVehIds.add(vehicule.getIdVehicule());
            }

            for (Souscategorie sousCategorie : sousCategorieSet) {
                linkedSousCategoriesIds.add(sousCategorie.getIdSousCategorie());
            }

            System.err.println(art.getNom());

        }

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
        return val;
    }

    public String update() throws ParseException {
        try {
            art.setMarque(marque_dao.findById(linkedMarqueIds));
            sousCategorieSet = new HashSet<>();
            for (Integer linkedSousCategorieId : linkedSousCategoriesIds) {
                sousCategorieSet.add(souscat_dao.find(linkedSousCategorieId));
            }
            art.setSouscategories(sousCategorieSet);

            VehiculeSet = new HashSet<>();
            for (Integer linkedVehId : linkedVehIds) {
                VehiculeSet.add(veh_dao.findById(linkedVehId));
            }
            art.setVehicules(VehiculeSet);
            dao.update(art);
        } catch (Exception e) {
            e.printStackTrace();
        }
        linkedMarqueIds = 0;
        linkedSousCategoriesIds = new ArrayList<>();
        linkedVehIds = new ArrayList<>();
        listArticles = dao.list();
        listAllSousCategories = souscat_dao.getAllSouscategories();
        listMarques = marque_dao.list();
        listVehicules = veh_dao.list();
        return SUCCESS;
    }

    public String add() throws ParseException {

        String val = customValidate();
        art.setMarque(marque_dao.findById(linkedMarqueIds));
        System.err.println(art.getNom() + " " + art.getMarque() + " " + art.getDescription());
        if (val == SUCCESS) {
            try {
                sousCategorieSet = new HashSet<>();
                for (Integer linkedSousCategorieId : linkedSousCategoriesIds) {
                    sousCategorieSet.add(souscat_dao.find(linkedSousCategorieId));
                }
                art.setSouscategories(sousCategorieSet);

                VehiculeSet = new HashSet<>();
                for (Integer linkedVehId : linkedVehIds) {
                    VehiculeSet.add(veh_dao.findById(linkedVehId));
                }
                art.setVehicules(VehiculeSet);

                dao.add(art);

            } catch (Exception e) {
                e.printStackTrace();
            }
            listArticles = dao.list();
            listAllSousCategories = souscat_dao.getAllSouscategories();
            listMarques = marque_dao.list();
            listVehicules = veh_dao.list();
            return SUCCESS;
        } else {
            listArticles = dao.list();
            listAllSousCategories = souscat_dao.getAllSouscategories();
            listMarques = marque_dao.list();
            listVehicules = veh_dao.list();
            return INPUT;
        }
    }

    public String delete() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        try {
            dao.deleteArticle(Integer.parseInt(request.getParameter("id")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        listArticles = dao.list();
        listAllSousCategories = souscat_dao.getAllSouscategories();
        listMarques = marque_dao.list();
        listVehicules = veh_dao.list();
        return SUCCESS;
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

    public int getLinkedMarqueIds() {
        return linkedMarqueIds;
    }

    public void setLinkedMarqueIds(int linkedMarqueIds) {
        this.linkedMarqueIds = linkedMarqueIds;
    }

    public ArrayList<Integer> getLinkedSousCategoriesIds() {
        return linkedSousCategoriesIds;
    }

    public void setLinkedSousCategoriesIds(ArrayList<Integer> linkedSousCategoriesIds) {
        this.linkedSousCategoriesIds = linkedSousCategoriesIds;
    }

    public List<Vehicule> getListVehicules() {
        return listVehicules;
    }

    public void setListVehicules(List<Vehicule> listVehicules) {
        this.listVehicules = listVehicules;
    }

    public ArrayList<Integer> getLinkedVehIds() {
        return linkedVehIds;
    }

    public void setLinkedVehIds(ArrayList<Integer> linkedVehIds) {
        this.linkedVehIds = linkedVehIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
