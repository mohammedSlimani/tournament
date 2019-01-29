/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import beans.UserAcc;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.LoginUtil;

/**
 *
 * @author rick
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
     	LoginUtil.login(request);
        //After this, we now have a user defined in the session scope if the login was successful 
        
        HttpSession session = request.getSession();
        UserAcc user = (UserAcc) session.getAttribute("CURRENT_USER");
        
        //If the login failed!
        if(user == null){
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }else{
            //The user was successefully logged in. we redirect it according to it's role
            switch(user.getType()){
                case 1://Admin
                    request.getRequestDispatcher("admin/main.jsp").forward(request, response);
                    //response.sendRedirect(request.getContextPath() + "/admin/main");
                    break;
                case 2://Responsible
                    request.getRequestDispatcher("responsible/main.jsp").forward(request, response);
                    break;
                case 3://captain
                    request.getRequestDispatcher("captain/main.jsp").forward(request, response);
                    break;
                default:
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
            }
            
        }

    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    
 

}
