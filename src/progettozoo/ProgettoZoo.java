/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettozoo;

import logins.JLogin;

/**
 *
 * @author Alberto
 */
public class ProgettoZoo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        DBConnect connect = new DBConnect();
        connect.getData();
        // TODO code application logic here
        JLogin login = new JLogin();
        login.setVisible(true);
   
    }
    
}
