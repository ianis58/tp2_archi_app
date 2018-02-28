package ca.uqac.archi.action;

import ca.uqac.archi.dao.SouscategorieDAO;
import ca.uqac.archi.model.Souscategorie;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import freemarker.core.ParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class ManageSousCategoriesAction extends ActionSupport{
    public static SouscategorieDAO souscategorieDAO = new SouscategorieDAO();
    
    private int id = 0;

    private String action;
    private List<Souscategorie> listSouscategories;

    private Souscategorie souscategorie = new Souscategorie();

    @Override
    public String execute() {
        if(id != 0){//si l'id est défini c'est qu'on est sur la page modifier user
            souscategorie = souscategorieDAO.find(id);
        }
        else{//sinon on est sur la page du CRUD
            listSouscategories = souscategorieDAO.getAllSouscategories();
        }

        action = "managesouscategories";//permet de mettre la classe css active sur le bon menu

        return SUCCESS;
    }

    public String add() throws ParseException {
        try {
            souscategorieDAO.create(souscategorie);
        } catch (Exception e) {
            e.printStackTrace();
        }

        listSouscategories = this.getListSouscategories();
        id = 0;
        souscategorie = new Souscategorie();
        return SUCCESS;
    }

    public String update() throws ParseException {
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
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
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
}
