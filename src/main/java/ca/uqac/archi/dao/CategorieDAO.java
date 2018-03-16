package ca.uqac.archi.dao;

import ca.uqac.archi.model.Categorie;
import ca.uqac.archi.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CategorieDAO extends HibernateUtil {

    @SuppressWarnings("unchecked")
    public Categorie find(String nom) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = " from Categorie c where c.nom=:nom";
        Query query = session.createQuery(sql);
        query.setParameter("nom", nom);
        List<Categorie> list = (List<Categorie>) query.list();
        session.getTransaction().commit();
        session.flush();
        //session.close();
        if (list.size() > 0) {
            return list.get(0);
        }

        return new Categorie();
    }

    public Categorie find(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        
        Categorie categorie = (Categorie) session.get(Categorie.class, id);

        session.getTransaction().commit();
        session.flush();
        //session.close();

        return categorie;
    }

    public void add(Categorie cat) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        session.save(cat);
        
        session.getTransaction().commit();
        session.flush();
        //session.close();
    }

    public void deleteCategorie(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Categorie cat = (Categorie) session.load(Categorie.class, id);
            if (null != cat) {
                session.delete(cat);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        session.flush();
        //session.close();
    }

    public void update(Categorie cat) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        try {
            if (cat != null) {
                session.saveOrUpdate(cat);
            }

        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        session.flush();
        //session.close();
    }

    public int getNewCategorieId() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        String query = "SELECT max(c.id) FROM Categorie c";
        List list = session.createQuery(query).list();
        int maxId = ((Integer) list.get(0));

        session.getTransaction().commit();
        session.flush();
        //session.close();
        return (maxId + 1);
    }

    public List<Categorie> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Categorie> DaoAllCategorie = null;
        session.beginTransaction();
        try {

            DaoAllCategorie = session.createCriteria(Categorie.class).list();

            int count = DaoAllCategorie.size();

        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        session.flush();
        //session.close();
        return DaoAllCategorie;

    }
}
