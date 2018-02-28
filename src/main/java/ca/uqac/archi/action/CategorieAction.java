/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uqac.archi.action;

import ca.uqac.archi.dao.CategorieDAO;
import ca.uqac.archi.model.Categorie;
import com.opensymphony.xwork2.ActionSupport;
import freemarker.core.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author almes
 */
public class CategorieAction extends ActionSupport{
    private static final long serialVersionUID = 1L;  
    private Categorie cat = new Categorie();
    private List<Categorie> CategorieList= new ArrayList<Categorie>(); 
     
    private int id;   
    private CategorieDAO dao;
    private Integer[] Checkbox;//stores id of selected(checked) records for deletion.  
      
    public CategorieAction() {  
         dao= new CategorieDAO(); 
    }  
    
      
    @Override  
    public String execute() {  
        this.CategorieList =  dao.list();  
        
        int count = CategorieList.size();  
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
        this.CategorieList =  dao.list();  
        return SUCCESS;  
    }  
     
    public String update() throws ParseException{ 
         System.out.println(getCat());  
        try {  
              
             dao.update(cat);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
       this.CategorieList =  dao.list();  
        return SUCCESS;  
    }  
      
     public String removeCategorie() throws ParseException { 
               
        try {  
            
            System.out.println("No of Selected Record:-" + Checkbox.length);  
            for (int i=0;i<Checkbox.length; i++){  
               System.out.println("Selected RecordId:-" + Checkbox[i]);  
              dao.deleteCategorie((Checkbox[i]));  
              
            }                
           
              
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        this.CategorieList =  dao.list();  
        return SUCCESS;  
    }  
       
       
      public String deleteCategorie() {  
          
        System.out.println("id value="+cat.getIdCategorie());  
        int id = cat.getIdCategorie();  
        try {  
              
             dao.deleteCategorie(id);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        this.CategorieList =  dao.list();  
        return SUCCESS;  
    }      
   
    public Categorie getCat() {  
        return cat;  
    }  
  
    public void setCat(Categorie cat) {  
        this.cat = cat;  
    }  
  
   public List<Categorie> getCategorieList() {  
        return CategorieList;  
    }  
    public void setCategorieList(List<Categorie> CategorieList) {  
        this.CategorieList = CategorieList;  
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
}
