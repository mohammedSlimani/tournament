/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.UserAcc;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author rick
 */
public interface CaptainService {

    boolean addTeam(HttpServletRequest request);

    boolean editPersonalInfo(HttpServletRequest request);

    boolean registerTeam(HttpServletRequest request);

}
