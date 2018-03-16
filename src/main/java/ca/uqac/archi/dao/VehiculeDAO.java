package ca.uqac.archi.dao;

import ca.uqac.archi.model.Categorie;
import ca.uqac.archi.model.Souscategorie;
import ca.uqac.archi.model.Vehicule;
import ca.uqac.archi.util.HibernateUtil;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class VehiculeDAO extends HibernateUtil {

    public List<Vehicule> list() {
        List<Vehicule> AllVeh = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery(" from Vehicule");
        AllVeh = (List<Vehicule>) query.list();
        
        session.getTransaction().commit();
        session.flush();
        //session.close();
        return AllVeh;
    }

    public Vehicule findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        
        String sql = " from Vehicule c where c.idVehicule=:id";
        Query query = session.createQuery(sql);
        query.setParameter("id", id);
        List<Vehicule> list = (List<Vehicule>) query.list();
        
        session.getTransaction().commit();
        session.flush();
        //session.close();
        
        if (list.size() > 0) {
            return list.get(0);
        }
        return new Vehicule();
    }
    
    public Vehicule create(Vehicule vehicule) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction(); //open transaction
        session.save(vehicule); //save the souscategories to database

        int insertedVehiculeId = ((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).intValue();

        session.getTransaction().commit();
        session.flush();
        //session.close();

        return this.findById(insertedVehiculeId);
    }
    
    public void update(Vehicule vehicule) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        try {
            if (vehicule != null) {
                session.saveOrUpdate(vehicule);
            }

        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        session.flush();
        //session.close();
    }

    public void delete(int vehiculeId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Vehicule vehicule = (Vehicule) session.load(Vehicule.class, vehiculeId);
            if (null != vehicule) {
                session.delete(vehicule);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        session.flush();
        //session.close();
    }
}
