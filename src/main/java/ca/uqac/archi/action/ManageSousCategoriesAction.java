package ca.uqac.archi.action;

import ca.uqac.archi.dao.CategorieDAO;
import ca.uqac.archi.dao.SouscategorieDAO;
import ca.uqac.archi.model.Categorie;
import ca.uqac.archi.model.Souscategorie;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import freemarker.core.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class ManageSousCategoriesAction extends ActionSupport implements Preparable {

    public static SouscategorieDAO souscategorieDAO = new SouscategorieDAO();
    public static CategorieDAO categorieDAO = new CategorieDAO();

    private int id = 0;

    private String action;
    private List<Souscategorie> listSouscategories;
    private List<Categorie> listAllCategories;

    private ArrayList<Integer> linkedCategoriesIds;
    private Set<Categorie> categoriesSet;

    private Souscategorie souscategorie = new Souscategorie();

    @Override
    public String execute() {

        linkedCategoriesIds = new ArrayList<>();

        if (id != 0) {
            categoriesSet = souscategorieDAO.find(id).getCategories();

            for (Categorie categorie : categoriesSet) {
                linkedCategoriesIds.add(categorie.getIdCategorie());
            }
        }

        if (id != 0) {//si l'id est défini c'est qu'on est sur la page modifier user
            souscategorie = souscategorieDAO.find(id);
            //categoriesSet = souscategorie.getCategories();
        } else {//sinon on est sur la page du CRUD
            listSouscategories = souscategorieDAO.getAllSouscategories();
        }

        action = "managesouscategories";//permet de mettre la classe css active sur le bon menu

        return SUCCESS;
    }

    public String add() throws ParseException {
        categoriesSet = new HashSet<>();

        for (Integer linkedCategorieId : linkedCategoriesIds) {
            categoriesSet.add(categorieDAO.find(linkedCategorieId));
        }

        souscategorie.setCategories(categoriesSet);

        try {
            souscategorieDAO.create(souscategorie);
        } catch (Exception e) {
            e.printStackTrace();
        }

        listSouscategories = this.getListSouscategories();
        id = 0;
        souscategorie = new Souscategorie();
        
        souscategorie = new Souscategorie();
        return SUCCESS;
    }

    public String update() throws ParseException {
        categoriesSet = new HashSet<>();

        for (Integer linkedCategorieId : linkedCategoriesIds) {
            categoriesSet.add(categorieDAO.find(linkedCategorieId));
        }

        souscategorie.setCategories(categoriesSet);

        try {
            souscategorieDAO.update(souscategorie);
        } catch (Exception e) {
            e.printStackTrace();
        }

        listSouscategories = this.getListSouscategories();
        id = 0;
        souscategorie = new Souscategorie();
        return SUCCESS;
    }

    public String delete() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        id = Integer.parseInt(request.getParameter("id"));
        try {
            souscategorieDAO.delete(souscategorieDAO.find(id));
        } catch (Exception e) {
            e.printStackTrace();
        }

        listSouscategories = this.getListSouscategories();
        id = 0;
        souscategorie = new Souscategorie();

        return SUCCESS;
    }

    public List<Souscategorie> getListSouscategories() {
        return listSouscategories;
    }

    public void setListSouscategories(List<Souscategorie> listSouscategories) {
        this.listSouscategories = listSouscategories;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Souscategorie getSouscategorie() {
        return souscategorie;
    }

    public void setSouscategorie(Souscategorie souscategorie) {
        this.souscategorie = souscategorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Categorie> getListAllCategories() {
        return listAllCategories;
    }

    public void setListAllCategories(List<Categorie> listAllCategories) {
        this.listAllCategories = listAllCategories;
    }

    public ArrayList<Integer> getLinkedCategoriesIds() {
        return linkedCategoriesIds;
    }

    public void setLinkedCategoriesIds(ArrayList<Integer> linkedCategoriesIds) {
        this.linkedCategoriesIds = linkedCategoriesIds;
    }

    @Override
    public void prepare() throws Exception {
        listAllCategories = new CategorieDAO().list();
    }

}
