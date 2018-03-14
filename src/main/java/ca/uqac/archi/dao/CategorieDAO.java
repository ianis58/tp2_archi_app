/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uqac.archi.dao;

import ca.uqac.archi.model.Categorie;
import ca.uqac.archi.model.Employe;
import ca.uqac.archi.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author almes
 */
public class CategorieDAO extends HibernateUtil{
    /**
    * CRUD: READ
    * Permet de récupérer une Categorie via son ID
    * @param id
    * @return
    */
    public Categorie find(Integer id){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Categorie categorie = (Categorie) session.get(Categorie.class, id);

        session.close();

        return categorie;
    }
    
    public void add(Categorie cat) {  
        Session session = HibernateUtil.getSessionFactory().openSession();  
        String fname = cat.getNom();  
        System.out.println("nom=" + fname);  
        //int newid = this.getNewCategorieId();  
       // cat.setId(newid);  
        //int catid = cat.getId();  
        //System.out.println("DaoCategorie id ;-" + catid);  
        System.out.println("From Dao:-" + cat);  
        session.beginTransaction();  
        //session.merge(cat);  
        session.save(cat);  
        session.getTransaction().commit();  
                session.flush();  
                session.close();  
          
    }  
    
     public void deleteCategorie(int id) {  
        Session session = HibernateUtil.getSessionFactory().openSession();  
        session.beginTransaction();  
          try {  
        Categorie cat = (Categorie) session.load(Categorie.class,id);  
        if(null != cat) {  
            session.delete(cat);  
        }          
         } catch (HibernateException e) {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        }  
           session.getTransaction().commit();  
        
            session.flush();  
            session.close();  
    }       
        
      public void update(Categorie cat) {  
        Session session = HibernateUtil.getSessionFactory().openSession();  
        session.beginTransaction();  
      //Categorie cat = (Categorie) session.load(Categorie.class, id);  
        try {  
        if(cat != null) {  
            session.saveOrUpdate(cat);  
        }  
          
        } catch (HibernateException e) {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        }  
            session.getTransaction().commit();        
            session.flush();  
            session.close();  
      }        
  
public int getNewCategorieId() {  
             Session session = HibernateUtil.getSessionFactory().getCurrentSession();  
             Transaction trans = session.beginTransaction();  
     String query = "SELECT max(c.id) FROM Categorie c";  
     List list = session.createQuery(query).list();  
     int maxId = ((Integer) list.get(0));  
  
            trans.commit();  
                session.close();  
        return (maxId+1);  
    }  
  
  
public List<Categorie> list(){
     Session session = HibernateUtil.getSessionFactory().openSession();  
          List<Categorie> DaoAllCategorie = null;         
        session.beginTransaction();       
        try {                         
             
               DaoAllCategorie = session.createCriteria(Categorie.class).list();  
               //DaoAllCategorie = (List<Categorie>)session.createQuery("from Categorie").list();  
                int count =DaoAllCategorie.size();  
              System.out.println("No of Record From Dao: " + count);                
        } catch (HibernateException e) {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        }  
            session.getTransaction().commit();  
                session.flush();  
                session.close();  
        return DaoAllCategorie;         
          
    }  
}
