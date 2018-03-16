package ca.uqac.archi.dao;

import ca.uqac.archi.model.Marque;
import ca.uqac.archi.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class MarqueDAO extends HibernateUtil {

    @SuppressWarnings("unchecked")
    public Marque find(String nom) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = " from Marque c where c.libelleMarque=:nom";
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
    
    public void add(Marque mar) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String fname = mar.getLibelleMarque();
        System.out.println("nom=" + fname);
        //int newid = this.getNewMarqueId();  
        // mar.setId(newid);  
        //int marid = mar.getId();  
        //System.out.println("DaoMarque id ;-" + marid);  
        System.out.println("From Dao:-" + mar);
        session.beginTransaction();
        //session.merge(mar);  
        session.save(mar);
        session.getTransaction().commit();
        session.flush();
        session.close();

    }

    public void deleteMarque(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Marque mar = (Marque) session.load(Marque.class, id);
            if (null != mar) {
                session.delete(mar);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();

        session.flush();
        session.close();
    }

    public void update(Marque mar) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        //Marque mar = (Marque) session.load(Marque.class, id);  
        try {
            if (mar != null) {
                session.saveOrUpdate(mar);
            }

        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        session.flush();
        session.close();
    }

}
