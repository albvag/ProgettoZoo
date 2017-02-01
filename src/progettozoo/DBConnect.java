/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettozoo;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
            JOptionPane.showMessageDialog(null, "Errore! Impossibile connettersi al Database");
            System.out.printf("Errore "+ex);
        };
    }
    
    
    public void insertHabitat(String Cod_Gabbia)
    {
        try {
            st.executeUpdate("INSERT INTO gabbia values ('"+Cod_Gabbia+"')");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertVisita(int Cod_Visita, String Cod_Vet, String Cod_Anim, Date DataVisita, String NoteVisita)
    {
        try {
            st.executeUpdate("INSERT INTO visita values ("+Cod_Visita+",'"+Cod_Vet +"','"+Cod_Anim+"','"+DataVisita+"','"+NoteVisita+"')");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public String checkAnimalHabitat(String Codice_Animale)
    {
    try{
            String query = "Select Cod_Gabbia from situato where situato.Cod_Animale = '"+Codice_Animale+"'";
            rs = st.executeQuery(query);
            String habitat = "";
            while(rs.next())
            {habitat = rs.getString("Cod_Gabbia");}
            
            return habitat;
        }catch(Exception ex){
            System.out.println(ex);
            return "Errore";
        }
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
    
    
    public ArrayList<Habitat> selezionaHabitat()
    {
        ArrayList<Habitat> hablist = new ArrayList<Habitat>();
        String query = "Select * from gabbia ";

           try{
               Habitat hab;
               rs = st.executeQuery(query);
               
               
                while(rs.next())
                {
                    hab = new Habitat(rs.getString("gabbia.Codice_Gabbia"));
                    hablist.add(hab);
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
           return hablist; 
    }
    
    
    public void deleteHabitat(String Cod_Gabbia)
    {
        try {
            st.execute("DELETE FROM gabbia where Codice_Gabbia= '"+Cod_Gabbia+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public boolean habitatExists(String Cod_Gabbia)
    {
        try{
            String query = "Select * from gabbia where gabbia.Codice_Gabbia = '"+Cod_Gabbia+"'";
            rs = st.executeQuery(query);
           
            while(rs.next())  return true;
            
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, "Errore! L'Habitat è già esistente");
            return false;
        }
        return false;
    }
    
    
    
    //verifica la corrispondenza tra utente e password inseriti
    public boolean userExists(String user, String password)
    {
        try{
            String query = "Select * from utente where utente.Codice_Utente = '"+user+"' AND utente.Password = '"+password+"'";
            rs = st.executeQuery(query);
           
            while(rs.next())  return true;
            
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, "Errore! Username o password non sono corretti.");
            return false;
        }
        return false;
    }
    
    public Utente InfoUtente(String Cod_Utente)
    {
        Utente utente = new Utente();
          try{
            String query = "Select * from utente JOIN impiegato on impiegato.Codice_Impiegato = utente.Codice_Utente where utente.Codice_Utente = '"+Cod_Utente+"'";
            rs = st.executeQuery(query);
            
            while(rs.next())
            {
              String username = utente.setUsername(rs.getString("utente.Codice_Utente"));
              String password = utente.setPassword(rs.getString("utente.Password"));
               String nome = utente.setNome(rs.getString("impiegato.Nome"));
               String cognome = utente.setCognome(rs.getString("impiegato.Cognome"));
               String ruolo = utente.setRuolo(rs.getString("utente.Ruolo_Utente"));
               String residenza = "";
               String indirizzo = "";
               String telefono = "";
               utente = new Utente(username, password, nome, cognome, ruolo, residenza, indirizzo, telefono);
               return utente;
            }
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, "Errore! Nessun utente trovato.");
            return null;
        }
        return utente;
    }
    
    //Estrae le informazioni sull'animale da poter mettere sulla tabella
       public ArrayList<Animale> animaliList()
       {
        ArrayList<Animale> animaliList = new ArrayList<Animale>();
        String query = "Select * from animale LEFT JOIN situato on situato.Cod_Animale = animale.Codice_Animale";

           try{
               Animale anim;
               rs = st.executeQuery(query);
               
               
                while(rs.next())
                {
                    anim = new Animale(rs.getString("animale.Codice_Animale"),rs.getString("animale.Nome"),
                            rs.getString("animale.Specie"),rs.getString("animale.Genere"),rs.getString("situato.Cod_Gabbia"),rs.getDate("animale.Data_Nascita"),
                            rs.getBoolean("animale.Salute"), rs.getBoolean("animale.Nostro"), rs.getBoolean("animale.Presente"));
                    animaliList.add(anim);
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
           return animaliList;   
        }       
       
       //DATI VISITE EFFETTUATE AD UN CERTO ANIMALE
       public ArrayList<Visita> visitaList(String animale)
       {
        ArrayList<Visita> visitaList = new ArrayList<Visita>();
        String query = "Select * from visita where Cod_Animale = '"+animale+"'";

           try{
               Visita vis;
               rs = st.executeQuery(query);
                while(rs.next())
                {
                    vis = new Visita(rs.getString("Cod_Veterinario"),rs.getString("Cod_Animale"), rs.getDate("Data_Visita"), rs.getString("Note_Visita"));
                    visitaList.add(vis);
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
           return visitaList;   
        }
       
       public ArrayList<Visita> visitaTuttiList()
       {
        ArrayList<Visita> visitaTuttiList = new ArrayList<Visita>();
        String query = "Select * from visita ";

           try{
               Visita vis;
               rs = st.executeQuery(query);
                while(rs.next())
                {
                    vis = new Visita(rs.getString("Cod_Veterinario"),rs.getString("Cod_Animale"), rs.getDate("Data_Visita"), rs.getString("Note_Visita"));
                    visitaTuttiList.add(vis);
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
           return visitaTuttiList;   
        }

}
