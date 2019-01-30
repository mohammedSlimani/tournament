/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl.test;

import beans.Auth;
import beans.Match;
import beans.Tournament;
import beans.UserAcc;
import daoImpl.MatchDaoImpl;
import daoImpl.TournamentDaoImpl;
import daoImpl.UserDaoImpl;
import java.util.Date;

/**
 *
 * @author rick
 */
public class DAOTest {

    public static void main(String[] args) {
        //loginTest();
        //addUserAccTest();
        addTournament();
    }

    public static void addUserAccTest() {
        UserAcc med = new UserAcc("admin", 1, true);
        Auth auth = new Auth("admin", med, "admin");

        UserDaoImpl dao = new UserDaoImpl();
        if (dao.addUser(med, auth)) {
            System.out.println("User added");
        } else {
            System.out.println("damn, some weird shit happened :( ");
        }
    }

    public static void loginTest() {
        UserDaoImpl dao = new UserDaoImpl();
        UserAcc user = new UserAcc();

        user = dao.login("username2", "password");
        if (user == null) {
            System.out.println("Somestuff happend Or the user just doesnt exist");
        } else {
            System.out.println("The user is connected: \nuser:" + user.getName());
        }

    }
    
    public static void addTournament(){
        TournamentDaoImpl dao = new TournamentDaoImpl();
        Tournament trn = new Tournament(new Date(), new Date());
        trn.setDateEnd(null);
        trn.setRegistrationEnd(new Date());
        trn.setState(1);
        dao.addTournament(trn);
        MatchDaoImpl daao = new MatchDaoImpl();
        Match m = new Match(trn, "team A", "team B", new Date());
        Match m2 = new Match(trn, "team C", "team D", new Date());
        
        daao.addMatch(m, trn);
        daao.addMatch(m2, trn);

    }
    
}
