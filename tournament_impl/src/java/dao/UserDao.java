/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Auth;
import beans.UserAcc;
import java.util.List;

/**
 *
 * @author rick
 */
public interface UserDao {
    
    boolean addUser(UserAcc user,Auth auth);
    
    boolean deleteUser(UserAcc captain);
    
    boolean deleteAllUsers();
        
    List getAllCaptains();
    
    List getAllResponsibles();
    
    List getAllTeams();
    
    boolean addTeammates(List <String> teammates);
    
    List getTeammates(UserAcc captain);
    
    //edit teammates ?
    
    
    
}
