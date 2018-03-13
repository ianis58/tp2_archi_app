/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uqac.archi.dao;

import ca.uqac.archi.model.Article;
import ca.uqac.archi.model.Categorie;
import ca.uqac.archi.model.Employe;
import ca.uqac.archi.model.Marque;
import ca.uqac.archi.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author nruj
 */
public class ArticleDAO extends HibernateUtil{
    
    @SuppressWarnings("unchecked")
    public Article find(String nom) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //session.beginTransaction();
        String sql = " from Article c where c.nom=:nom";
        Query query = session.createQuery(sql);
        query.setParameter("nom", nom);
        List<Article> list = (List<Article>) query.list();
        session.close();
        if (list.size() > 0) {
            return list.get(0);
        }
        
        return new Article(); //dumb employe meaning no matching credentials found
    }
    
    public void add(Article art, Categorie cat) {  
       MarqueDAO marquedao = new MarqueDAO();
       Marque test = new Marque();
        test=marquedao.find(art.getMarque().getLibelleMarque());
        if(test.getIdMarque()==null)
        {
            //drop la marque n'existe pas
        }
        CategorieDAO categoriedao = new CategorieDAO();
        Categorie testC = new Categorie();
        testC=categoriedao.find(cat.getNom());
        if(testC.getNom()==null)
        {
            //drop la catégorie n'existe pas
        }
        
        Session session = HibernateUtil.getSessionFactory().openSession();  
        
        session.beginTransaction();   
        session.save(art);  
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
             Session session = HibernateUtil.getSessionFactory().openSession();  
             Transaction trans = session.beginTransaction();  
     String query = "SELECT max(c.id) FROM Categorie c";  
     List list = session.createQuery(query).list();  
     int maxId = ((Integer) list.get(0));  
  
            trans.commit();  
                session.close();  
        return (maxId+1);  
    }  
  
  
public List<Article> list(){  
     Session session = HibernateUtil.getSessionFactory().openSession();  
          List<Article> DaoAllArticles = null;         
        session.beginTransaction();       
        try {                         
               DaoAllArticles = session.createCriteria(Article.class).list();  
                int count =DaoAllArticles.size();              
        } catch (HibernateException e) {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        }  
                session.getTransaction().commit();  
                session.flush();  
                session.close();  
        return DaoAllArticles;         
          
    } 
public List<Article> recherche (String nomArticle){
       Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction transaction = null;
       try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Article WHERE nom like :nomArticle");
            query.setParameter("nomArticle", nomArticle);
            List<Article> lstArticle = (List<Article>) query.list();
            transaction.commit();
            return lstArticle;
       }catch(Exception e){
           if(!(transaction == null)){
               transaction.rollback();
           }
       }finally{
           session.close();
       }
        
      /* List article = session.createCriteria(Article.class)
               .add(Restrictions.eq("nom", nom))
               .list();*/
       
       return null;
   }
}
