/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import beans.Auth;
import beans.Teammates;
import beans.UserAcc;
import dao.UserDao;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

/**
 *
 * @author rick
 */
public class UserDaoImpl implements UserDao {

    @Override
    public boolean addUser(UserAcc user, Auth auth) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Transaction tx = session.beginTransaction();
            session.save(user);
            session.save(auth);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            System.out.println("The shit happened: " + e);
            session.close();
            return false;
        }
    }

    @Override
    public boolean deleteUser(UserAcc captain) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteAllUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAllCaptains() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAllResponsibles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAllTeams() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addTeammates(Teammates teammates, UserAcc user) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Transaction tx = session.beginTransaction();
            teammates.setId(user.getId());
            session.save(teammates);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            System.out.println("The shit happened: " + e);
            session.close();
            return false;
        }
    }

    @Override
    public List getTeammates(UserAcc captain) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserAcc login(String username, String password) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            String hql = "FROM Auth A WHERE A.username = :_username AND A.password = :_password";
            Query query = session.createQuery(hql);
            query.setParameter("_username", username);
            query.setParameter("_password", password);
            List results = query.list();

            if (results.isEmpty()) {
                session.close();
                System.out.println("The results is empty");
                return null;
            } else {
                Auth auth = (Auth) results.get(0);
                UserAcc user = auth.getUserAcc();
                session.close();
                return user;
            }

        } catch (Exception e) {
            System.out.println("The shit happened: " + e);
            session.close();
            return null;
        }
    }

    @Override
    public boolean register(UserAcc user, Auth auth) {
        return addUser(user, auth);
    }

}
