/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uqac.archi.action;

import ca.uqac.archi.dao.MarqueDAO;
import ca.uqac.archi.model.Marque;
import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import freemarker.core.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author almes
 */
public class MarqueAction extends ActionSupport {
    private Marque mar = new Marque();
    private List<Marque> listMarques = new ArrayList();

    private int id = 0;
    private MarqueDAO dao;
    private String action;

    public MarqueAction() {
        dao = new MarqueDAO();
    }

    @Override
    public String execute() {
        action = "marqueCRUD";

        listMarques = dao.list();

        /*int count = listMarques.size();
        System.out.println("marList Size " + count);*/
        //System.out.println("execute called");
        return SUCCESS;
    }

    // fonction de validation de champs
    public String customValidate() {
        String val = SUCCESS;
        Marque marVerif = dao.find(mar.getLibelleMarque());
        if (mar.getLibelleMarque().length() < 1 || mar.getLibelleMarque().equals(" ")) {
            this.addActionError("Entrez un nom svp !");
            val = INPUT;
        }
        if (marVerif.getLibelleMarque() != null) {
            this.addActionError("Ce nom existe déjà !");
            val = INPUT;
        }
        marVerif = null;
        return val;
    }

    public String add() throws ParseException {
        //System.out.println(mar);
        String val = customValidate();
        if (val == SUCCESS) {
            try {
                dao.add(mar);
            } catch (Exception e) {
                e.printStackTrace();
            }
            listMarques = dao.list();
            return SUCCESS;
        } else {
            listMarques = dao.list();
            return INPUT;
        }
    }

    public String update() throws ParseException {
        //System.out.println(getMar());
        String val = customValidate();
        if (val == SUCCESS) {
            try {
                dao.update(mar);
                mar = null;
            } catch (Exception e) {
                e.printStackTrace();
            }

            listMarques = dao.list();
            return SUCCESS;
        } else {
            listMarques = dao.list();
            return INPUT;
        }

    }

    public String delete() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        System.out.println("id value=" + Long.parseLong(request.getParameter("id")));
        this.setId(Integer.parseInt(request.getParameter("id")));
        try {
            dao.deleteMarque(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        listMarques = dao.list();
        return SUCCESS;
    }

    public Marque getMar() {
        return mar;
    }

    public void setMar(Marque mar) {
        this.mar = mar;
    }

    public List<Marque> getListMarques() {
        return listMarques;
    }

    public void setListMarques(List<Marque> listMarques) {
        this.listMarques = listMarques;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
