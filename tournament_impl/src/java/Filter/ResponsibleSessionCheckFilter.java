/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filter;

import beans.UserAcc;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rick
 */
public class ResponsibleSessionCheckFilter implements Filter {
    
    private String contextPath;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        contextPath = filterConfig.getServletContext().getContextPath();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;                        

        UserAcc user = (UserAcc) req.getSession().getAttribute("CURRENT_USER");
        if (user == null) {                
                //put your redirect stuff here
                res.sendRedirect(contextPath + "/index.jsp");                
        } else if(user.getType() != 2) { // Not and responsible
              res.sendRedirect(contextPath+"404.html");
            
          chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
    
    
}
