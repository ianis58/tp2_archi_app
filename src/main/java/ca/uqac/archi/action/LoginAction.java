/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uqac.archi.action;

/**
 *
 * @author almes
 */

import com.opensymphony.xwork2.ActionSupport;
import ca.uqac.archi.dao.EmployeDAO;
import ca.uqac.archi.model.Employe;
public class LoginAction extends ActionSupport {
 
    private static final long serialVersionUID = 1L;    
    EmployeDAO dao = new EmployeDAO();
    Employe user;
 
    @Override
    public void validate() {
        if (user.getMail().length() == (0)) {
            this.addFieldError("user.mail", "Mail is required");
        }
        if (user.getPassword().length() == (0)) {
            this.addFieldError("user.password", "Password is required");
        }
    }
 
    @Override
    public String execute() {
        if (dao.find(user.getMail(), user.getPassword())) {
            return SUCCESS;
        } else {
            this.addActionError("Invalid username and password");
        }
        return INPUT;
    }
     
 
    public Employe getUser() {
        return user;
    }
 
    public void setUser(Employe user) {
        this.user = user;
    }    
}
