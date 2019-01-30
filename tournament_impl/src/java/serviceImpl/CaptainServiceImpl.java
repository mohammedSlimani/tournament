/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceImpl;

import beans.Teammates;
import beans.UserAcc;
import daoImpl.UserDaoImpl;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import service.CaptainService;
import utils.StringUtils;

/**
 *
 * @author rick
 */
public class CaptainServiceImpl implements CaptainService{

    @Override
    public boolean addTeam(HttpServletRequest request) {
        UserAcc user= (UserAcc) request.getAttribute("CURRENT_USER");
        ArrayList<String> team = new ArrayList<String>();
        UserDaoImpl dao = new UserDaoImpl();
        String name;
        for(int i =1;i<=8;i++){
            name = request.getParameter("field"+i);
            if(!StringUtils.isEmpty(name)){
                team.add(name);
            }
        }
        if(team.isEmpty()){
            return false;
        }else{
            for(String player : team){
                dao.addTeammates(new Teammates(user,player), user);
            }return true;
        }
    }

    @Override
    public boolean editPersonalInfo(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
