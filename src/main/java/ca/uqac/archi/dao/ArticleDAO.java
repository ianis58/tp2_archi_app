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
import ca.uqac.archi.model.Souscategorie;
import ca.uqac.archi.model.Vehicule;
import ca.uqac.archi.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
    
    public void add(Article art) {  
       Session session = HibernateUtil.getSessionFactory().openSession();  
        session.beginTransaction();   
        session.save(art);  
        session.getTransaction().commit();  
                session.flush();  
                session.close();  
          
    }  
    
     public void deleteArticle(int id) {  
        Session session = HibernateUtil.getSessionFactory().openSession();  
        session.beginTransaction();  
          try {  
        Article art = (Article) session.load(Article.class,id);  
        if(null != art) {  
            session.delete(art); 
            //TODO Appeler le delete de la ligne de la relation article/sous categorie
        }          
         } catch (HibernateException e) {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        }  
           session.getTransaction().commit();  
            session.flush();  
            session.close();  
    }       
    
 public List<Article> list()
 {
    List<Article> AllArticles = null;
     Session session = HibernateUtil.getSessionFactory().openSession();
     session.beginTransaction();
     Query query = session.createQuery(" from Article");
     AllArticles = (List<Article>) query.list();
     System.err.println(AllArticles);
     System.err.println(query);
     return AllArticles;
 }
 
 public void update(Article art){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.update(art);
        session.flush(); //le flush permet de prendre en compte les modifs dans la bdd immédiatement
       session.close();
    }


public List<Article> recherche (String nomArticle){
        List<Article> AllArticles = null;
         Session session = HibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         Query query = session.createQuery(" from Article where nom like :nomArticle");
         query.setParameter("nomArticle", "%" + nomArticle + "%");
         AllArticles = (List<Article>) query.list();
         System.err.println(AllArticles);
         System.err.println(query);
         return AllArticles;   
    
   }

public List<Article> FinalSearch (Integer IdSouscategorie){
       
        
       Souscategorie souscategorie = new SouscategorieDAO().find(IdSouscategorie);
       List<Article> lstArticle = new ArrayList<>();
       Set<Article> resArticles = souscategorie.getArticles();
       for(Article article : resArticles){
           lstArticle.add(article);
       }
       return lstArticle;
       
       //return null;
   }
  
public List<Article> AdvanceSearch(Integer IdCategorie){
        System.out.println("qwerty");
        Categorie categorie = new CategorieDAO().find(IdCategorie);
        List<Article> lstArticle = new ArrayList<>();
        Set<Souscategorie> resSousategories = categorie.getSouscategories();
        for(Souscategorie souscategorie : resSousategories){
            lstArticle.addAll(souscategorie.getArticles());
        }
        System.out.println("123456789"+lstArticle.toString());
        return lstArticle;
    }

    public Article findById(int id) {
         Session session = HibernateUtil.getSessionFactory().openSession();
         Article art = (Article) session.get(Article.class, id);    
        session.close();
        return art;
    }
}
