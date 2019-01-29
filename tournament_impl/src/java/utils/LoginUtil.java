/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import beans.Auth;
import beans.UserAcc;
import dao.UserDao;
import daoImpl.UserDaoImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rick
 */
public class LoginUtil {

    public static void login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //If the fields are empty we do nothing 
        if (isEmpty(username) || isEmpty(password)) {
            return;
        }

        //We fetsh the database to see if the Authenitcation is right
        UserDaoImpl dao = new UserDaoImpl();
        UserAcc user = dao.login(username, password);

        //IF the Password ant the username dont match
        if (user == null) {
            return;
        }

        //If I get here then Everything went good.
        //set the session variable for other uses.
        HttpSession session = request.getSession();
        session.setAttribute("CURRENT_USER", user);

    }

    public static boolean isEmpty(String str) {

        if (str == null || str.trim().equals("")) {
            return true;
        }
        return false;
    }
}
