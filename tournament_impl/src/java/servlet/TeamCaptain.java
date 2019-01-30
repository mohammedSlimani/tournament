/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CaptainService;
import serviceImpl.CaptainServiceImpl;

/**
 *
 * @author rick
 */
@WebServlet(name = "TeamCaptain", urlPatterns = {"/captainteam"})
public class TeamCaptain extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CaptainServiceImpl sc = new CaptainServiceImpl();
        String registerForm = request.getParameter("submit");
        if(request.getParameter("registration") == null){    
            if(sc.addTeam(request)){
                response.sendRedirect(request.getContextPath() + "/captainmain");
            }
        }
        
        request.getRequestDispatcher("captain/team.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
