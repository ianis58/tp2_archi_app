/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uqac.archi.action;

import ca.uqac.archi.dao.CategorieDAO;
import ca.uqac.archi.model.Categorie;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import freemarker.core.ParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author almes
 */
public class CategorieAction extends ActionSupport{
    private static final long serialVersionUID = 1L;
    private Categorie cat = new Categorie();
    private List<Categorie> listCategories;

    private int id = 0;
    private CategorieDAO dao;
    private String action;

    public CategorieAction() {
         dao = new CategorieDAO();
    }

    @Override
    public String execute() {
        action = "categorieCRUD";

        listCategories = dao.list();

        /*int count = listCategories.size();
        System.out.println("catList Size " + count);*/
        //System.out.println("execute called");
        return SUCCESS;
    }
    
    // fonction de validation de champs
    public String customValidate(){
        String val = SUCCESS;
        Categorie catVerif = dao.find(cat.getNom());
        if(cat.getNom().length() < 1 || cat.getNom().equals(" ")){
            this.addActionError("Entrez un nom svp !");
            val = INPUT;
        }
        if(catVerif.getNom() != null){
            this.addActionError("Ce nom existe déjà !");
            val = INPUT;
        }
        catVerif = null;
        return val;
    }

    public String add() throws ParseException {
        //System.out.println(cat);
        String val = customValidate();
        if(val == SUCCESS){
            try {
                dao.add(cat);
            } catch (Exception e) {
                e.printStackTrace();
            }
            listCategories = dao.list();
            return SUCCESS;
        }else{
            listCategories = dao.list();
            return INPUT;
        }
    }

    public String update() throws ParseException{
        //System.out.println(getCat());
        String val = customValidate();
        if(val == SUCCESS){
            try {
             dao.update(cat);
             cat = null;
            } catch (Exception e) {
                e.printStackTrace();
            }

            listCategories = dao.list();
            return SUCCESS;
        }else{
            listCategories = dao.list();
            return INPUT;
        }
        
    }

    public String delete() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        System.out.println("id value="+Long.parseLong( request.getParameter("id")));
        this.setId(Integer.parseInt(request.getParameter("id")));
        try {
             dao.deleteCategorie(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        listCategories = dao.list();
        return SUCCESS;
    }

    public Categorie getCat() {
        return cat;
    }

    public void setCat(Categorie cat) {
        this.cat = cat;
    }

   public List<Categorie> getListCategories() {
        return listCategories;
    }

    public void setListCategories(List<Categorie> listCategories) {
        this.listCategories = listCategories;
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
