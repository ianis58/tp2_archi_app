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

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class LoginAction extends ActionSupport implements SessionAware{
 
    private static final long serialVersionUID = 1L;
    EmployeDAO dao = new EmployeDAO();
    Employe user;
    
    private Map<String, Object> session;

    @Override
    public void validate() {
        if(user != null){
            if (user.getMail() == null || user.getMail().length() < 5) {
                this.addFieldError("user.mail", "Veuillez entrer un email valide");
            }
            if (user.getPassword() == null || user.getPassword().length() < 3) {
                this.addFieldError("user.password", "Veuillez entrer un mot de passe valide");
            }

            if(!getFieldErrors().isEmpty()){
                user = null;
            }
        }
    }
 
    @Override
    public String execute() {
        if(user != null){
            user = dao.find(user.getMail(), user.getPassword());

            if (user != null && user.getMail() != null) {
                session.put("nom",user.getNom());
                session.put("prenom",user.getPrenom());
                session.put("admin",user.isIsAdmin());
                return SUCCESS;
            } else {
                this.addActionError("Combinaison email / mot de passe invalide");
                user = null;
            }
        }
        return INPUT;
    }
     
 
    public Employe getUser() {
        return user;
    }
 
    public void setUser(Employe user) {
        this.user = user;
    }    

    @Override
    public void setSession(Map<String, Object> session) {
      this.session=session;
    }
}
