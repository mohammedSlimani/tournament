/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import beans.Tournament;
import dao.TournamentDao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

/**
 *
 * @author rick
 */
public class TournamentDaoImpl implements TournamentDao {

    @Override
    public boolean addTournament(Tournament trn) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Transaction tx = session.beginTransaction();
            session.save(trn);
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
    public boolean deleteTournament(Tournament trn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editTournament(Tournament trn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tournament> getOngoingTournament() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tournament> getEndedTournament() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
