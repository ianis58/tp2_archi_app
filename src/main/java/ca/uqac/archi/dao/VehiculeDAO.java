package ca.uqac.archi.dao;

import ca.uqac.archi.model.Vehicule;
import ca.uqac.archi.util.HibernateUtil;
import java.util.List;
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
}
