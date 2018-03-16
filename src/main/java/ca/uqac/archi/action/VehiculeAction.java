package ca.uqac.archi.action;

import ca.uqac.archi.dao.MarqueDAO;
import ca.uqac.archi.dao.VehiculeDAO;
import ca.uqac.archi.model.Marque;
import ca.uqac.archi.model.Vehicule;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import freemarker.core.ParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class VehiculeAction extends ActionSupport implements Preparable {

    public static VehiculeDAO vehiculeDAO = new VehiculeDAO();
    public static MarqueDAO marqueDAO = new MarqueDAO();

    private int id = 0;
    private int marqueId = 0;

    private String action;
    private List<Vehicule> listVehicules;
    private List<Marque> listAllMarques;

    private Marque marque;

    private Vehicule vehicule = new Vehicule();

    @Override
    public String execute() {

        if (id != 0) {
            marque = vehiculeDAO.findById(id).getMarque();
            marqueId = marque.getIdMarque();
            vehicule = vehiculeDAO.findById(id);
        }

        action = "vehiculeCRUD";//permet de mettre la classe css active sur le bon menu

        listVehicules = vehiculeDAO.list();
        
        return SUCCESS;
    }

    public String add() throws ParseException {
        vehicule.setMarque(marqueDAO.findById(marqueId));

        try {
            vehiculeDAO.create(vehicule);
        } catch (Exception e) {
            e.printStackTrace();
        }

        listVehicules = vehiculeDAO.list();
        listAllMarques = marqueDAO.list();
        id = 0;
        vehicule = new Vehicule();
        
        return SUCCESS;
    }

    public String update() throws ParseException {
        vehicule.setMarque(marqueDAO.findById(marqueId));

        try {
            vehiculeDAO.update(vehicule);
        } catch (Exception e) {
            e.printStackTrace();
        }

        listVehicules = vehiculeDAO.list();
        listAllMarques = marqueDAO.list();
        id = 0;

        return SUCCESS;
    }

    public String delete() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        id = Integer.parseInt(request.getParameter("id"));
        try {
            vehiculeDAO.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        listVehicules = vehiculeDAO.list();
        listAllMarques = marqueDAO.list();
        id = 0;

        return SUCCESS;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getMarqueId() {
        return marqueId;
    }

    public void setMarqueId(int marqueId) {
        this.marqueId = marqueId;
    }

    public List<Vehicule> getListVehicules() {
        return listVehicules;
    }

    public void setListVehicules(List<Vehicule> listVehicules) {
        this.listVehicules = listVehicules;
    }

    public List<Marque> getListAllMarques() {
        return listAllMarques;
    }

    public void setListAllMarques(List<Marque> listAllMarques) {
        this.listAllMarques = listAllMarques;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }
    
    

    @Override
    public void prepare() throws Exception {
        listAllMarques = marqueDAO.list();
        listVehicules = vehiculeDAO.list();
    }

}
