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
import java.util.ArrayList;
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
     
    private int id =0;   
    private CategorieDAO dao;
    private Integer[] Checkbox;//stores id of selected(checked) records for deletion.  
    
    private String action;
      
    public CategorieAction() {  
         dao= new CategorieDAO(); 
    }  
    
      
    @Override  
    public String execute() {  
        action = "categorieCRUD";
        
        listCategories =  dao.list();  
        
        int count = listCategories.size();  
      System.out.println("catList Size"+ count);  
        //System.out.println("execute called");  
        return SUCCESS;  
    }    
    public String add() throws ParseException {      
        System.out.println(cat);  
        try {  
             
             dao.add(cat);  
              
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        listCategories =  dao.list();  
        return SUCCESS;  
    }  
     
    public String update() throws ParseException{ 
         System.out.println(getCat());  
        try {  
              
             dao.update(cat);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
       listCategories =  dao.list();  
        return SUCCESS;  
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
        listCategories =  dao.list();  
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
     public Integer[] getCheckbox() {  
        return Checkbox;  
    }  
    public void setCheckbox(Integer[] Checkbox) {  
        this.Checkbox = Checkbox;  
    }   

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    
    
}
