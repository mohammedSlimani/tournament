/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import beans.Auth;
import beans.UserAcc;
import daoImpl.UserDaoImpl;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author rick
 */
public class RegistrationUtils {

    public static boolean Register(HttpServletRequest request) {
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String teamTitle = request.getParameter("team_title");

        UserAcc user = new UserAcc(name, 3, false);
        user.setTeam(teamTitle);
        Auth auth = new Auth(username, user, password);

        UserDaoImpl dao = new UserDaoImpl();
        return dao.addUser(user, auth) && !StringUtils.isEmpty(teamTitle); //Because the TeamTitle is nullable only for the admin
        
    }
}
