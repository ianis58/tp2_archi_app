/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uqac.archi.action;

import ca.uqac.archi.dao.EmployeDAO;
import ca.uqac.archi.model.Employe;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author Ianis
 */
public class ManageUsersAction extends ActionSupport {
    
    private String action;
    private List<Employe> listEmployees;
    
    @Override
    public String execute() {
        action = "manageusers";
        listEmployees = new EmployeDAO().getAllEmployees();
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
    
    
    
}
