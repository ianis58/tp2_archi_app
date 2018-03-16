package ca.uqac.archi.dao;

import ca.uqac.archi.model.Marque;
import ca.uqac.archi.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class MarqueDAO extends HibernateUtil {

    @SuppressWarnings("unchecked")
    public Marque find(String nom) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = " from Marque c where c.LibelleMarque=:nom";
        Query query = session.createQuery(sql);
        query.setParameter("nom", nom);
        List<Marque> list = (List<Marque>) query.list();
        session.getTransaction().commit();
        session.flush();
        //session.close();
        if (list.size() > 0) {
            return list.get(0);
        }
        return new Marque();
    }

    public Marque findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = " from Marque c where c.idMarque=:idM";
        Query query = session.createQuery(sql);
        query.setParameter("idM", id);
        List<Marque> list = (List<Marque>) query.list();
        session.getTransaction().commit();
        session.flush();
        //session.close();
        if (list.size() > 0) {
            return list.get(0);
        }
        return new Marque();
    }

    public List<Marque> list() {
        List<Marque> AllMarques = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        
        Query query = session.createQuery(" from Marque");
        AllMarques = (List<Marque>) query.list();
        System.err.println(AllMarques);
        System.err.println(query);
        
        session.getTransaction().commit();
        session.flush();
        //session.close();
        return AllMarques;
    }

}
