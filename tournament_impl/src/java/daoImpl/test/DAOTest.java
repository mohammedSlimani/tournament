/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl.test;

import beans.Auth;
import beans.UserAcc;
import daoImpl.UserDaoImpl;

/**
 *
 * @author rick
 */
public class DAOTest {
    public static void main(String[]args){
        //loginTest();
        addUserAccTest();
        
    }
    
    public static void addUserAccTest(){
        UserAcc med = new UserAcc("admin", 1, true);
        Auth auth = new Auth("admin", med, "admin");
        
        UserDaoImpl dao = new UserDaoImpl();
        if(dao.addUser(med, auth)){
         System.out.println("User added");
        }else{
            System.out.println("damn, some weird shit happened :( ");
        }
    }
    
    public static void loginTest(){
        UserDaoImpl dao = new UserDaoImpl();
        UserAcc user = new UserAcc();
        
        user = dao.login("username2","password");
        if(user == null){
            System.out.println("Somestuff happend Or the user just doesnt exist");
        }else{
            System.out.println("The user is connected: \nuser:"+user.getName() );
        }
        
    }
}
