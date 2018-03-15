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
 * @author almes
 */
public class MarqueDAO extends HibernateUtil{
    
    @SuppressWarnings("unchecked")
    public Marque find(String nom) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = " from Marque c where c.LibelleMarque=:nom";
        Query query = session.createQuery(sql);
        query.setParameter("nom", nom);
        List<Marque> list = (List<Marque>) query.list();
        session.close();
        if (list.size() > 0) {
            return list.get(0);
        } 
        return new Marque();
    }
    
    public List<Marque> list()
 {
     List<Marque> AllMarques = null;
     Session session = HibernateUtil.getSessionFactory().openSession();
     session.beginTransaction();
     Query query = session.createQuery(" from Marque");
     AllMarques = (List<Marque>) query.list();
     System.err.println(AllMarques);
     System.err.println(query);
     return AllMarques;
 }
    
   
}
