/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettozoo;

import java.sql.*;

/**
 *
 * @author Alberto
 */
public class DBConnect {
    
    private Connection conn;
    private Statement st;
    private ResultSet rs;
    
    //Connessione al nostro DB
    public DBConnect(){
    
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo","root","");
            st = conn.createStatement();
        }catch(Exception ex){
            System.out.printf("Errore "+ex);
        };
    } 
   // Esempio per vedere se funziona
    public void getData(){
        try{
            String query = "Select * from utente";
            rs = st.executeQuery(query);
            System.out.println("Records from database");
            while(rs.next())
            {
                String username = rs.getString("Codice_Utente");
                System.out.println(username);
            }
        }catch(Exception ex){
            System.out.println(ex);
        };
    }
    
}
