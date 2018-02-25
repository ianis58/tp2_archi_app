/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uqac.archi.dao;

/**
 *
 * @author almes
 */
import ca.uqac.archi.model.Employe;
import ca.uqac.archi.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
 
public class EmployeDAO {
    public boolean find(String mail, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //session.beginTransaction();
        String sql = " from Employe u where u.mail=:mail and u.password=:pass";
        Query query = session.createQuery(sql);
        query.setParameter("mail", mail);
        query.setParameter("pass", password);
        List<Employe> list = query.list();
        if (list.size() > 0) {
            session.close();
            return true;
        }
        session.close();
        return false;
    }
}
