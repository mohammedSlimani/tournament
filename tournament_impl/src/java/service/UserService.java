/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.UserAcc;

/**
 *
 * @author rick
 */
public interface UserService {
    
    boolean startRegistration(int id_trnmt);
    
    boolean endRegistration(int id_trnmt);
    
    boolean addTeam();
    
    boolean editPersonalInfo(UserAcc oldOne, UserAcc newOne);
    
    
    
}
