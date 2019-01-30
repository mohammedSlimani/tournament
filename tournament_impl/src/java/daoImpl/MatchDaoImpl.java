/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import beans.Match;
import dao.MatchDao;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

/**
 *
 * @author rick
 */
public class MatchDaoImpl implements MatchDao {

    @Override
    public boolean addMatch(Match match) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Transaction tx = session.beginTransaction();
            session.save(match);
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
    public boolean deleteMatch(Match match) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Match> getAllmatches() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            String hql = "FROM Match M order by date ";
            Query query = session.createQuery(hql);
            List results = query.list();

            if (results.isEmpty()) {
                session.close();
                System.out.println("The results is empty");
                return null;
            } else {
                List<Match> match = (List<Match>) results;
                session.close();
                return match;
            }

        } catch (Exception e) {
            System.out.println("The shit happened: " + e);
            session.close();
            return null;
        }    
    }

    @Override
    public boolean editMatch(Match match) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Match getCloseMatch() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            String hql = "FROM Match M order by date ";
            Query query = session.createQuery(hql);
            query.setMaxResults(1);
            List results = query.list();

            if (results.isEmpty()) {
                session.close();
                System.out.println("The results is empty");
                return null;
            } else {
                Match match = (Match) results.get(0);
                session.close();
                return match;
            }

        } catch (Exception e) {
            System.out.println("The shit happened: " + e);
            session.close();
            return null;
        }    
    }

    @Override
    public List getMatchHistory() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Date currentdate = new Date();
        try {
            String hql = "FROM Match M where M.date <:_currentdate where M.score_a is not null";
            //I think just getting the score_a is enough
            Query query = session.createQuery(hql);
            query.setParameter("_currentdate",currentdate );

            List results = query.list();

            if (results.isEmpty()) {
                session.close();
                System.out.println("The results is empty");
                return null;
            } else {
                List<Match> match = (List<Match>) results;
                session.close();
                return match;
            }

        } catch (Exception e) {
            System.out.println("The shit happened: " + e);
            session.close();
            return null;
        } 
    }

    @Override
    public List getAppendingForResults() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Date currentdate = new Date();
        try {
            String hql = "FROM Match M where M.date <:_currentdate where M.score_a is null";
            //I think just getting the score_a is enough
            Query query = session.createQuery(hql);
            query.setParameter("_currentdate",currentdate );

            List results = query.list();

            if (results.isEmpty()) {
                session.close();
                System.out.println("The results is empty");
                return null;
            } else {
                List<Match> match = (List<Match>) results;
                session.close();
                return match;
            }

        } catch (Exception e) {
            System.out.println("The shit happened: " + e);
            session.close();
            return null;
        }    
    }

    @Override
    public List<Match> getFutureMatches() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Date currentdate = new Date();
        try {
            String hql = "FROM Match M where M.date >:_currentdate where M.score_a is not null";
            //I think just getting the score_a is enough
            Query query = session.createQuery(hql);
            query.setParameter("_currentdate",currentdate );

            List results = query.list();

            if (results.isEmpty()) {
                session.close();
                System.out.println("The results is empty");
                return null;
            } else {
                List<Match> match = (List<Match>) results;
                session.close();
                return match;
            }

        } catch (Exception e) {
            System.out.println("The shit happened: " + e);
            session.close();
            return null;
        }
    }

    @Override
    public boolean enterResult(Match match, int scoreA, int scoreB) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("update match set score_a = :_scorea and score_b = :_scoreb" +
    				" where id = :_matchid");
            query.setParameter("_matchid", match.getId());
            query.setParameter("_scorea", scoreA);
            query.setParameter("_scoreb", scoreB);
            query.executeUpdate();
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            System.out.println("The shit happened: " + e);
            session.close();
            return false;
        }
    }

}
