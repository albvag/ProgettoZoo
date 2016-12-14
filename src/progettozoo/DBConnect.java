/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettozoo;

import java.sql.*;
import java.util.ArrayList;
import progettozoo.Animale;

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
    
    //Mi dice qual è il ruolo di un certo utente
    public String checkRole(String user)
    {
        try{
            String query = "Select * from utente where utente.Codice_Utente = '"+user+"'";
            rs = st.executeQuery(query);
            String ruolo = "";
            while(rs.next())
            {ruolo = rs.getString("Ruolo_Utente");}
            
            return ruolo;
        }catch(Exception ex){
            System.out.println(ex);
            return "Errore";
        }
    }
    
    //verifica la corrispondenza tra utente e password inseriti
    public int userExists(String user, String password)
    {
        try{
            String query = "Select * from utente where utente.Codice_Utente = '"+user+"' AND utente.Password = '"+password+"'";
            rs = st.executeQuery(query);
            int count=0;
            while(rs.next())
            {
                count++;
                String utente = rs.getString("Codice_Utente");
                System.out.println(utente);
            }
            return count;
        }catch(Exception ex){
            
            System.out.println(ex);
            return -1;
        }
        
    }
    //Estrae le informazioni sull'animale da poter mettere sulla tabella
       public ArrayList<Animale> animaliList()
       {
        ArrayList<Animale> animaliList = new ArrayList<Animale>();
        String query = "Select * from animale";

           try{
               Animale anim;
               rs = st.executeQuery(query);
                while(rs.next())
                {
                    anim = new Animale(rs.getString("animale.Codice_Animale"),rs.getString("Nome"),
                            rs.getString("Specie"),rs.getString("Genere"),rs.getString("Data_Nascita"),
                            rs.getBoolean("Salute"), rs.getBoolean("Nostro"), rs.getBoolean("Presente"));
                    animaliList.add(anim);
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
           return animaliList;   
        }
    

}
