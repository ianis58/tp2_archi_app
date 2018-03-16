package ca.uqac.archi.dao;

import ca.uqac.archi.model.Souscategorie;
import ca.uqac.archi.util.HibernateUtil;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.Session;

public class SouscategorieDAO {

    @SuppressWarnings("unchecked")
    public List<Souscategorie> getAllSouscategories() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        
        List<Souscategorie> listSouscategories = (List<Souscategorie>) session.createQuery("from Souscategorie").list();

        session.getTransaction().commit();
        session.flush();
        //session.close();
        return listSouscategories;
    }

    /**
     * CRUD: READ Permet de récupérer un Souscategorie via son ID
     *
     * @param id
     * @return
     */
    public Souscategorie find(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        
        Souscategorie souscategories = (Souscategorie) session.get(Souscategorie.class, id);

        session.getTransaction().commit();
        session.flush();
        //session.close();

        return souscategories;
    }

    /**
     * CRUD: CREATE Permet de créer une entrée dans la base de données par
     * rapport à un objet
     *
     * @param obj
     */
    public Souscategorie create(Souscategorie souscategories) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction(); //open transaction
        session.save(souscategories); //save the souscategories to database

        int insertedSouscategorieId = ((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).intValue();

        session.getTransaction().commit();
        session.flush();
        //session.close();

        return this.find(insertedSouscategorieId);
    }

    /**
     * CRUD: UPDATE Permet de mettre à jour les données d'une entrée dans la
     * base
     *
     * @param obj
     */
    public Souscategorie update(Souscategorie souscategories) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        
        session.update(souscategories);

        session.getTransaction().commit();
        session.flush();
        //session.close();

        return this.find(souscategories.getIdSousCategorie());
    }

    /**
     * CRUD: DELETE Permet la suppression d'une entrée de la base
     *
     * @param obj
     */
    public void delete(Souscategorie souscategories) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        
        session.delete(souscategories);

        session.getTransaction().commit();
        session.flush();
        //session.close();
    }

}
