
package ca.uqac.archi.dao;

import ca.uqac.archi.model.Article;
import ca.uqac.archi.model.Categorie;
import ca.uqac.archi.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Nico
 */

  import ca.uqac.archi.model.Article;
import ca.uqac.archi.model.Categorie;
import ca.uqac.archi.model.Employe;
import ca.uqac.archi.model.Marque;
import ca.uqac.archi.model.Vehicule;
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
public class VehiculeDAO extends HibernateUtil{
    

    public List<Vehicule> list()
 {
     List<Vehicule> AllVeh = null;
     Session session = HibernateUtil.getSessionFactory().openSession();
     session.beginTransaction();
     Query query = session.createQuery(" from Vehicule");
     AllVeh = (List<Vehicule>) query.list();
     return AllVeh;
 }
    
     public Vehicule findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = " from Vehicule c where c.idVehicule=:id";
        Query query = session.createQuery(sql);
        query.setParameter("id", id);
        List<Vehicule> list = (List<Vehicule>) query.list();
        session.close();
        if (list.size() > 0) {
            return list.get(0);
        } 
        return new Vehicule();
    } 
}
