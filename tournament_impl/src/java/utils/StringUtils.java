/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author rick
 */
public class StringUtils {
    public static boolean isEmpty(String str) {

        if (str == null || str.trim().equals("")) {
            return true;
        }
        return false;
    }
}
