package ca.uqac.archi.dao;

import ca.uqac.archi.model.Employe;
import ca.uqac.archi.util.HibernateUtil;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class EmployeDAO {

    /**
     * Permet de checker si couple mail password est OK
     *
     * @param mail
     * @param password
     * @return si OK: l'employé qui s'est identifié, sinon un employé vide
     */
    @SuppressWarnings("unchecked")
    public Employe find(String mail, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = " from Employe u where u.mail=:mail and u.password=:pass";
        Query query = session.createQuery(sql);
        query.setParameter("mail", mail);
        query.setParameter("pass", password);
        List<Employe> list = (List<Employe>) query.list();
        session.getTransaction().commit();
        session.flush();
        //session.close();
        if (list.size() > 0) {
            return list.get(0);
        }

        return new Employe(); //dumb employe meaning no matching credentials found
    }

    @SuppressWarnings("unchecked")
    public List<Employe> getAllEmployees() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Employe> listEmployees = (List<Employe>) session.createQuery("from Employe").list();

        //session.close();
        return listEmployees;
    }

    /**
     * CRUD: READ Permet de récupérer un Employe via son ID
     *
     * @param id
     * @return
     */
    public Employe find(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        
        Employe employe = (Employe) session.get(Employe.class, id);

        session.getTransaction().commit();
        session.flush();
        //session.close();

        return employe;
    }

    /**
     * CRUD: CREATE Permet de créer une entrée dans la base de données par
     * rapport à un objet
     *
     * @param obj
     */
    public Employe create(Employe employe) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction(); //open transaction
        
        session.save(employe); //save the employe to database

        int insertedEmployeId = ((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).intValue();

        session.getTransaction().commit();
        session.flush();
        //session.close();

        return this.find(insertedEmployeId);
    }

    /**
     * CRUD: UPDATE Permet de mettre à jour les données d'une entrée dans la
     * base
     *
     * @param obj
     */
    public Employe update(Employe employe) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        
        session.update(employe);

        session.getTransaction().commit();
        session.flush();
        //session.close();

        return this.find(employe.getIdPersonne());
    }

    /**
     * CRUD: DELETE Permet la suppression d'une entrée de la base
     *
     * @param obj
     */
    public void delete(Employe employe) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        session.delete(employe);

        session.getTransaction().commit();
        session.flush();
        //session.close();
    }

}
