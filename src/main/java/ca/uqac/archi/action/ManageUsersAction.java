/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uqac.archi.action;

import ca.uqac.archi.dao.EmployeDAO;
import ca.uqac.archi.model.Employe;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import freemarker.core.ParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Ianis
 */
public class ManageUsersAction extends ActionSupport {
    public static EmployeDAO employeDAO = new EmployeDAO();
    
    private int id = 0;

    private String action;
    private List<Employe> listEmployees;

    private Employe employe = new Employe();

    @Override
    public String execute() {
        if(id != 0){
            employe = employeDAO.find(id);
        }
        else{
            listEmployees = employeDAO.getAllEmployees();
        }

        action = "manageusers";

        return SUCCESS;
    }

    public String add() throws ParseException {
        try {
            employeDAO.create(employe);
        } catch (Exception e) {
            e.printStackTrace();
        }

        listEmployees = this.getListEmployees();
        id = 0;
        employe = new Employe(); //empty employe object, that will be read by manageusers.jsp (via this.getEmploye()) to prevent refilling form...
        return SUCCESS;
    }

    public String update() throws ParseException {
        try {
            employeDAO.update(employe);
        } catch (Exception e) {
            e.printStackTrace();
        }

        listEmployees = this.getListEmployees();
        id = 0;
        employe = new Employe(); //empty employe object, that will be read by manageusers.jsp (via this.getEmploye()) to prevent refilling form...
        return SUCCESS;
    }
    
    public String delete() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        id = Integer.parseInt(request.getParameter("id"));
        try {
            employeDAO.delete(employeDAO.find(id));
        } catch (Exception e) {
            e.printStackTrace();
        }

        listEmployees = this.getListEmployees();
        id = 0;
        employe = new Employe(); //empty employe object, that will be read by manageusers.jsp (via this.getEmploye()) to prevent refilling form...

        return SUCCESS;
    }

    public List<Employe> getListEmployees() {
        return listEmployees;
    }

    public void setListEmployees(List<Employe> listEmployees) {
        this.listEmployees = listEmployees;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
