/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettozoo;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.Date;

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
    
    public void close() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public String createCodAnimale(String specie)
    {
        int conta=1;
        boolean flag;
        do
        {
            flag=false;
        String query="SELECT * from animale where animale.Codice_Animale= '"+specie+conta+"'";
         try{
               
               rs = st.executeQuery(query);
               
               
                while(rs.next())
                {
                    flag=true;
                    conta++;
                    
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
        }while(flag);
                return specie+conta; 
    }
    public int contaDirettore()
    {
        int conta=0;
         String query="SELECT Ruolo_Utente from utente where Ruolo_Utente= 'Direttore'";
         try{
               
               rs = st.executeQuery(query);
               
               
                while(rs.next())
                {
                    
                    conta++;
                    
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
         
           return conta; 
    
    }
     public void insertSpecie(String Cod_Specie)
    {
        try {
            st.executeUpdate("INSERT INTO specie values ('"+Cod_Specie+"')");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insertHabitat(String Cod_Gabbia,String Cod_Specie)
    {
        try {
            st.executeUpdate("INSERT INTO gabbia values ('"+Cod_Gabbia+"','"+Cod_Specie+"')");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //query per l'inserimento di un animale nel DB
    public void insertAnimale(String Cod_Animale,String nome,String specie,String genere,Date data,int salute,int nostro,int presente)
    {
     try {
         st.executeUpdate("INSERT INTO animale values ('"+Cod_Animale+"','"+nome+"','"+specie+"','"+genere+"','"+data+"',"+salute+","+nostro+","+presente+")");
     }   catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insertAnimaleSituato(int codsituato,String Cod_anim,String Cod_Hab)
    {
        try {
            st.executeUpdate("INSERT INTO situato values ("+codsituato+",'"+Cod_anim+"','"+Cod_Hab+"')");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     //query per l'inserimento del personale nel DB
    public void insertImpiegato(String user,String nome,String cognome,Date data,String residenza,String indirizzo,String telefono)
    {
     try {
         st.executeUpdate("INSERT INTO impiegato values ('"+user+"','"+nome+"','"+cognome+"','"+residenza+"','"+indirizzo+"','"+telefono+"','"+data+"')");
     }   catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void inserisciUtente(String user,String password,String ruolo)
    {
        try {
            st.executeUpdate("INSERT INTO utente values ('"+user+"','"+password+"','"+ruolo+"')");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void insertDirettore(String user)
    {
        try{
            st.executeUpdate("INSERT INTO direttore values('"+user+"')");
        }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         public void insertVeterinario(String user)
    {
        try{
            st.executeUpdate("INSERT INTO veterinario values('"+user+"')");
        }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            public void insertCustode(String user)
    {
        try{
            st.executeUpdate("INSERT INTO custode values('"+user+"')");
        }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
               public void insertCassiere(String user)
    {
        try{
            st.executeUpdate("INSERT INTO cassiere values('"+user+"')");
        }catch(SQLException ex) {
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
    
    public int updateSaluteAnimale(String Salute, String Cod_Animale)
    {
        int salute;
        if(Salute == "Sano") salute=1;
        else salute = 0;
        try {
            st.executeUpdate("UPDATE animale SET Salute = '"+ salute + "' where Codice_Animale = '"+ Cod_Animale + "'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salute;
    }
    
     public void updateAnimalePresente(boolean presente,Animale an)
    {
        
        try {
            st.executeUpdate("UPDATE animale SET Presente = "+ presente + " where Codice_Animale = '"+ an.getId()+ "'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
      public double updatePrezzoProdotto(double prezzo, String prodotto)
    {
       
        try {
            st.executeUpdate("UPDATE prodotto SET Prezzo = '"+ prezzo + "' where Codice_Prodotto = '"+ prodotto + "'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prezzo;
    }
      public void updatePersonale(String user,String nome,String cognome,Date data,String residenza,String indirizzo,String telefono,String password,String ruolo)
      {
        try {
            st.executeUpdate("UPDATE impiegato SET Nome = '"+nome+"',Cognome = '"+cognome+"', DataNascita= '"+data.toString()+"', Residenza= '"+residenza+"',Indirizzo= '"+indirizzo+"',Telefono= '"+telefono+"' where Codice_Impiegato= '"+user+"' ");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            st.executeUpdate("UPDATE utente SET Password= '"+password+"', Ruolo_Utente= '"+ruolo+"' where Codice_Utente= '"+user+"'");
        }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        } 
      }
      public void updateAnimale(String nome,String genere,Date data,int nostro,String codice)
      {
        try {
            st.executeUpdate("UPDATE animale SET Nome= '"+nome+"',Genere= '"+genere+"',Data_Nascita= '"+data.toString()+"',Nostro= "+nostro+" where Codice_Animale= '"+codice+"'" );
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
        String query = "Select *  from gabbia ";

           try{
               Habitat hab;
               rs = st.executeQuery(query);
               
               
                while(rs.next())
                {
                    hab = new Habitat(rs.getString("gabbia.Codice_Gabbia"),rs.getString("gabbia.Cod_Specie"));
                    hablist.add(hab);
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
           return hablist; 
    }
      
      public Habitat selezionaHabitatSpecie(String specie)
      {
          Habitat hab= new Habitat();
          String query="Select * from gabbia where gabbia.Cod_Specie= '"+specie+"'";
           try{
               
               rs = st.executeQuery(query);
               
               
                while(rs.next())
                {
                    hab = new Habitat(rs.getString("gabbia.Codice_Gabbia"),rs.getString("gabbia.Cod_Specie"));
                    
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
          return hab;
      }
       public Habitat selezionaSpecieHabitat(String habitat)
      {
          Habitat hab= new Habitat();
          String query="Select * from gabbia where gabbia.Codice_Gabbia= '"+habitat+"'";
           try{
               
               rs = st.executeQuery(query);
               
               
                while(rs.next())
                {
                    hab = new Habitat(rs.getString("gabbia.Codice_Gabbia"),rs.getString("gabbia.Cod_Specie"));
                    
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
          return hab;
      }
      public ArrayList<Animale> selezionaSpecie()
    {
        ArrayList<Animale> spelist = new ArrayList<Animale>();
        String query = "Select distinct Codice_Specie from specie ";

           try{
               Animale an;
               rs = st.executeQuery(query);
               
               
                while(rs.next())
                {
                    an = new Animale();
                    an.setSpecie(rs.getString("specie.Codice_Specie"));
                    spelist.add(an);
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
           return spelist; 
    }
      
     public ArrayList<Prodotto> selezionaProdotto(String prodotto)
    {
        ArrayList<Prodotto> prolist = new ArrayList<Prodotto>();
        String query="";
        if(prodotto.equals(""))
        query = "Select * from prodotto ";
        else
            query = "Select * from prodotto where prodotto.Codice_Prodotto=  '"+prodotto+"'";

           try{
               Prodotto pro;
               rs = st.executeQuery(query);
               
               
                while(rs.next())
                {
                    pro = new Prodotto(rs.getString("prodotto.Codice_Prodotto"),rs.getDouble("prodotto.Prezzo"),rs.getInt("prodotto.Giacenza"));
                    prolist.add(pro);
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
           return prolist; 
    }
    
     public Animale selezionaAnimale(String nome,String specie)
    {
       Animale an= new Animale();
        String query = "Select * from animale where animale.Nome= '"+nome+"' AND animale.Specie= '"+specie+"'";

           try{
               
               rs = st.executeQuery(query);
               
               
                while(rs.next())
                {
                    an = new Animale();
                    an.setId(rs.getString("animale.Codice_Animale"));
                    an.setNome(rs.getString("animale.Nome"));
                    an.setSpecie(rs.getString("animale.Specie"));
                    an.setSesso(rs.getString("animale.Genere"));
                    an.setDataNascita(rs.getDate("animale.Data_Nascita"));
                    an.setSalute(rs.getBoolean("animale.Salute"));
                    an.setNostro(rs.getBoolean("animale.Nostro"));
                    
                   
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
           return an; 
    }
   
    public ArrayList<Animale> selezionaAnimaliSpecie()
    {
        ArrayList<Animale> animlist = new ArrayList<Animale>();
        String query = "Select distinct Specie from animale ";

           try{
               Animale an;
               rs = st.executeQuery(query);
               
               
                while(rs.next())
                {
                    an = new Animale();
                    an.setSpecie(rs.getString("animale.Specie"));
                    animlist.add(an);
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
           return animlist; 
    }
     public ArrayList<Animale> selezionaAnimaliNome(String specie)
    {
        ArrayList<Animale> speclist = new ArrayList<Animale>();
        String query = "Select Nome from animale where animale.Specie= '"+specie+"' ";

           try{
               Animale an;
               rs = st.executeQuery(query);
               
               
                while(rs.next())
                {   
                    
                    an = new Animale();
                    an.setNome(rs.getString("animale.Nome"));
                    speclist.add(an);
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
           return speclist; 
    }
          public ArrayList<Animale> selezionaAnimaliPresenti()
    {
        ArrayList<Animale> anpreslist = new ArrayList<Animale>();
        String query = "Select * from animale where animale.Presente= "+true+" AND animale.Nostro= "+true+"";

           try{
               Animale an;
               rs = st.executeQuery(query);
               
               
                while(rs.next())
                {   
                    
                    an = new Animale();
                    an.setId(rs.getString("animale.Codice_Animale"));
                    an.setNome(rs.getString("animale.Nome"));
                    an.setSpecie(rs.getString("animale.Specie"));
                    an.setSesso(rs.getString("animale.Genere"));
                    an.setDataNascita(rs.getDate("animale.Data_Nascita"));
                    anpreslist.add(an);
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
           return anpreslist; 
    } 
                 public ArrayList<Animale> selezionaAnimaliInPrestito()
    {
        ArrayList<Animale> prestitolist = new ArrayList<Animale>();
        String query = "Select * from animale where animale.Presente= "+false+" AND animale.Nostro= "+true+"";

           try{
               Animale an;
               rs = st.executeQuery(query);
               
               
                while(rs.next())
                {   
                    
                    an = new Animale();
                    an.setId(rs.getString("animale.Codice_Animale"));
                    an.setNome(rs.getString("animale.Nome"));
                    an.setSpecie(rs.getString("animale.Specie"));
                    an.setSesso(rs.getString("animale.Genere"));
                    an.setDataNascita(rs.getDate("animale.Data_Nascita"));
                    prestitolist.add(an);
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
           return prestitolist; 
    } 
       public Utente selezionaPersonale(String ruolo,String nome)
    {
        Utente ut=new Utente();
        String query = "Select distinct * from impiegato JOIN utente on impiegato.Codice_Impiegato=utente.Codice_Utente where utente.Ruolo_Utente= '"+ruolo+"' AND impiegato.Cognome= '"+nome+"'";
        try{
            
            rs=st.executeQuery(query);
            
            while(rs.next())
            {
                
                ut.setUsername(rs.getString("utente.Codice_Utente"));
                ut.setNome(rs.getString("impiegato.Nome"));
                ut.setCognome(rs.getString("impiegato.Cognome"));
                ut.setData(rs.getDate("impiegato.DataNascita"));
                ut.setResidenza(rs.getString("impiegato.Residenza"));
                ut.setIndirizzo(rs.getString("impiegato.Indirizzo"));
                ut.setTelefono(rs.getString("impiegato.Telefono"));
                ut.setRuolo(rs.getString("utente.Ruolo_Utente"));
                ut.setPassword(rs.getString("utente.Password"));
               
            }  
        } catch(Exception ex){

                System.out.println(ex);
            }   
           return ut; 
    }
         public ArrayList<Utente> selezionaImpiegato()
    {
        ArrayList<Utente> implist = new ArrayList<Utente>();
        String query = "Select * from impiegato JOIN utente on impiegato.Codice_Impiegato=utente.Codice_Utente ";
        try{
            Utente ut;
            rs=st.executeQuery(query);
            
            while(rs.next())
            {
                ut=new Utente();
                ut.setUsername(rs.getString("utente.Codice_Utente"));
                ut.setNome(rs.getString("impiegato.Nome"));
                ut.setCognome(rs.getString("impiegato.Cognome"));
                ut.setData(rs.getDate("impiegato.DataNascita"));
                ut.setResidenza(rs.getString("impiegato.Residenza"));
                ut.setIndirizzo(rs.getString("impiegato.Indirizzo"));
                ut.setTelefono(rs.getString("impiegato.Telefono"));
                ut.setRuolo(rs.getString("utente.Ruolo_Utente"));
                implist.add(ut);
            }  
        } catch(Exception ex){

                System.out.println(ex);
            }   
           return implist; 
    }
     public ArrayList<Utente> selezionaPersonaleRuolo()
    {
        ArrayList<Utente> ruololist = new ArrayList<Utente>();
        String query = "SELECT DISTINCT Ruolo_Utente from utente";

           try{
               Utente ut;
               rs = st.executeQuery(query);
               
               
                while(rs.next())
                {   
                    
                    ut = new Utente();
                    ut.setRuolo(rs.getString("utente.Ruolo_Utente"));
                    
                    
                    ruololist.add(ut);
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
           return ruololist; 
    }
      public ArrayList<Utente> selezionaPersonaleNome(String ruolo)
    {
        
        ArrayList<Utente> ruololist = new ArrayList<Utente>();
        String query = "Select * from impiegato JOIN utente on impiegato.Codice_Impiegato=utente.Codice_Utente where utente.Ruolo_Utente= '"+ruolo+"'";
        
           try{
               Utente ut;
               rs = st.executeQuery(query);
           
               
                while(rs.next())
                {   
                    
                    ut = new Utente();
                    ut.setNome(rs.getString("impiegato.Nome"));
                    ut.setCognome(rs.getString("impiegato.Cognome"));
                    ruololist.add(ut);
                }
           }catch(Exception ex){

                System.out.println(ex);
            }   
              return ruololist; 
    }
       public String selezionacodiceAnimale(String nome)
      {   
          String codice="";
          String query="SELECT Codice_Animale from animale where animale.Nome= '"+nome+"'";
        try {
            
            rs=st.executeQuery(query);
            while(rs.next())
            {
              codice=rs.getString("animale.Codice_Animale");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
       return codice;
      }
      public String selezionacodiceImpiegato(String cognome)
      {   
          String codice="";
          String query="SELECT Codice_Impiegato from impiegato where impiegato.Cognome= '"+cognome+"'";
        try {
            
            rs=st.executeQuery(query);
            while(rs.next())
            {
              codice=rs.getString("impiegato.Codice_Impiegato");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
       return codice;
      }
     public void deletePersonaleImpiegato(String  codice)
    {
        try {
            st.execute("DELETE FROM impiegato where impiegato.Codice_Impiegato = '"+codice+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void deletePersonaleUtente(String  codice)
    {
        try {
            st.execute("DELETE FROM utente where utente.Codice_Utente = '"+codice+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteDirettore(String  codice)
    {
        try {
            st.execute("DELETE FROM direttore where direttore.Codice_Direttore = '"+codice+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void deleteVeterinario(String  codice)
    {
        try {
            st.execute("DELETE FROM veterinario where veterinario.Codice_Veterinario = '"+codice+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void deleteCustode(String  codice)
    {
        try {
            st.execute("DELETE FROM custode where custode.Codice_Custode = '"+codice+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public void deleteCassiere(String  codice)
    {
        try {
            st.execute("DELETE FROM cassiere where cassiere.Codice_Cassiere = '"+codice+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteHabitat(String Cod_Gabbia)
    {
        try {
            st.execute("DELETE FROM gabbia where Codice_Gabbia= '"+Cod_Gabbia+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void deleteSpecie(String specie)
    {
        try {
            st.execute("DELETE FROM specie where Codice_Specie= '"+specie+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void deleteProdotto(String codice)
    {
        try {
            st.execute("DELETE FROM prodotto where Codice_Prodotto= '"+codice+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void deleteAnimale(String Cod_anim)
    {
        try {
            st.execute("DELETE FROM animale where Nome= '"+Cod_anim+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public void deleteAnimaleVisita(String Cod_anim)
    {
        try {
            st.execute("DELETE FROM visita where Cod_Animale= '"+Cod_anim+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         public void deleteAnimaleSituato(String Cod_anim)
    {
        try {
            st.execute("DELETE FROM situato where Cod_Animale= '"+Cod_anim+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean animaleExists(String Cod_anim)
    {
        try{
            String query = "Select * from animale where animale.Codice_Animale = '"+Cod_anim+"'";
            rs = st.executeQuery(query);
           
            while(rs.next())  return true;
            
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, "Errore! L'animale è già esistente");
            return false;
        }
        return false;
    }
     public boolean impiegatoExists(String Cod_imp)
    {
        try{
            String query = "Select * from impiegato where impiegato.Codice_Impiegato = '"+Cod_imp+"'";
            rs = st.executeQuery(query);
           
            while(rs.next())  return true;
            
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, "Errore! L'impiegato è già esistente");
            return false;
        }
        return false;
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
     public boolean habitatisEmpty(String Cod_Gabbia)
    {
        try{
            String query = "Select * from situato where situato.Cod_Gabbia = '"+Cod_Gabbia+"'";
            rs = st.executeQuery(query);
           
            while(rs.next())  return false;
            
        }catch(Exception ex){
               
        }
        return true;
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
               Date datanascita=(Date) utente.setData(rs.getDate("impiegato.DataNascita"));
               String ruolo = utente.setRuolo(rs.getString("utente.Ruolo_Utente"));
               String residenza =utente.setResidenza(rs.getString("impiegato.Residenza"));
               String indirizzo = utente.setIndirizzo(rs.getString("impiegato.Indirizzo"));
               String telefono =utente.setTelefono(rs.getString("impiegato.Telefono"));
               utente = new Utente(username, password, nome, cognome,datanascita, ruolo, residenza, indirizzo, telefono);
               return utente;
            }
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, "Errore! Nessun utente trovato.");
            return null;
        }
        return utente;
    }

    //Estrae le informazioni sull'animale da poter mettere sulla tabella
       public ArrayList<Animale> animaliList(String[] Filtri)
       {
           ProgettoZoo pz = new ProgettoZoo();
        ArrayList<Animale> animaliList = new ArrayList<Animale>();
        String query = "Select  * from animale LEFT JOIN situato on situato.Cod_Animale = animale.Codice_Animale";
        String[] f_where = new String[9];

            f_where[0] = "animale.Genere";
            f_where[1] = "animale.Specie";
            f_where[2] = "animale.Presente";
            f_where[3] = "animale.Salute";
            f_where[4] = "animale.Codice_Animale";
            f_where[5] = "animale.Data_Nascita";
            f_where[6] = "animale.Data_Nascita";
            f_where[7] = "visita.Data_Visita";
            f_where[8] = "visita.Data_Visita";
            

       int count_nofilter = 0;
       for(int i=0; i<Filtri.length-3; i++)
       {
           
           if(Filtri[2].equals("SI") ) Filtri[2] = "1";
           else if(Filtri[2].equals("NO")) Filtri[2] = "0";
           
           if(Filtri[3].equals("SANO") ) Filtri[3] = "1";
           else if(Filtri[3].equals("MALATO")) Filtri[3] = "0";
           
           
           
           if(!Filtri[i].equals("") && count_nofilter !=0) {
               
               if(i==4) query = query + " AND "+f_where[i]+" LIKE '%"+Filtri[4]+"%'";
               else query = query + " AND "+ f_where[i] + " = '"+ Filtri[i] +"'";
               
           }
           
           else if(!Filtri[i].equals("") && count_nofilter == 0)
           {

               if(i==4) {
                   query = query + " where "+f_where[i]+" like '%"+Filtri[4]+"%'";
               }
                  else query = query + " where "+f_where[i] + " = '"+ Filtri[i] + "'";
               count_nofilter++;
           }
           
       }
       
       for(int i=Filtri.length-3; i<Filtri.length-1; i+=2)
       {     
           if(!Filtri[i].equals("") && count_nofilter !=0) {
                String dt_da = pz.NuovoFormatoData(Filtri[i], "dd-MM-yyyy", "yyyy-MM-dd");
                
                String dt_a = pz.NuovoFormatoData(Filtri[i+1], "dd-MM-yyyy", "yyyy-MM-dd");
                
               query = query + " AND "+f_where[i] + " >= '"+ dt_da + "' AND "+f_where[i] +" <= '"+dt_a+"'";
           }
            else if(!Filtri[i].equals("") && count_nofilter == 0)
           {
                String dt_da = pz.NuovoFormatoData(Filtri[i], "dd-MM-yyyy", "yyyy-MM-dd");
                
                String dt_a = pz.NuovoFormatoData(Filtri[i+1], "dd-MM-yyyy", "yyyy-MM-dd");
                
               query = query + " where "+f_where[i] + " >= '"+ dt_da + "' AND "+f_where[i] +" <= '"+dt_a+"'";
               count_nofilter++;
           }
           
       }
       
 
       
       
       
       
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
    public ArrayList<Prodotto> listaProdotti()
       {
        ArrayList<Prodotto> listaProdotti = new ArrayList<Prodotto>();
        String query = "Select * from prodotto";

           try{
               Prodotto pro;
               rs = st.executeQuery(query);
                while(rs.next())
                {
                    pro = new Prodotto(rs.getString("Codice_prodotto"),rs.getDouble("Prezzo"), rs.getInt("Giacenza"));
                    listaProdotti.add(pro);
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
           return listaProdotti;   
        }
    public ArrayList<String> selezionaProdVenduti()
    {
         ArrayList<String> prodlist = new ArrayList<String>();
        String query = "SELECT DISTINCT Cod_Prodotto from vende";

           try{
               String prod;
               rs = st.executeQuery(query);
               
               
                while(rs.next())
                {   
                    
                    prod = new String();
                    prod = rs.getString("Cod_Prodotto");
                    
                    prodlist.add(prod);
                    
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
           return prodlist; 
    }
    
     public Utente[] getPasti(Date dat,ArrayList<Pasto> listaPasti)
    {
        
       
        Pasto pas;
        
         String data1=dat.toString()+" 00:00:00";
         String data2=dat.toString()+" 23:59:59";
         
        
       String query2 = "Select * from pasti  where  pasti.Data_Pasto >=  '"+data1+"' AND pasti.Data_Pasto <= '"+data2+"'";
        try {
            
            rs=st.executeQuery(query2);
            
             while(rs.next())  
        {
            
            
             pas = new Pasto(rs.getInt("Codice_Pasto"),rs.getString("Cod_Gabbia"), rs.getTimestamp("Data_Pasto"),rs.getBoolean("Disponibile"),rs.getBoolean("Terminato"));
                    listaPasti.add(pas);
   
        }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        Utente[] utlist= new Utente[listaPasti.size()];
        
        for(int i =0;i<listaPasti.size();i++)
        {
           Utente  ut=new Utente();
           utlist[i]=ut;
        String query = "Select * from nutre  where Cod_Pasto= '"+listaPasti.get(i).getCodice_Pasto()+"'";
        try {
            
            rs=st.executeQuery(query);
            
             while(rs.next())  
        {
            
            
             utlist[i].setUsername(rs.getString("nutre.Cod_Custode"));
            
             
                
  
        }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        for(int i=0;i<utlist.length;i++)
        {
             String query3 = "Select * from impiegato  where Codice_Impiegato= '"+utlist[i].getUsername()+"'";
        try {
            
            rs=st.executeQuery(query3);
            
             while(rs.next())  
        {
           
            utlist[i].setNome(rs.getString("Nome"));
            utlist[i].setCognome(rs.getString("Cognome"));
            
        }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return utlist;
    }
     
     
       public Utente[][] getPulizie(Date dat,ArrayList<Pulizia> listaPulizie)
    {
        
       
        Pulizia pul;
        
         String data1=dat.toString()+" 00:00:00";
         String data2=dat.toString()+" 23:59:59";
         
        
       String query2 = "Select * from pulizia  where  pulizia.Data_Inizio_Pulizia >=  '"+data1+"' AND pulizia.Data_Inizio_Pulizia <= '"+data2+"'";
        try {
            
            rs=st.executeQuery(query2);
            
             while(rs.next())  
        {
            
            
             pul = new Pulizia(rs.getInt("Codice_Pulizia"),rs.getString("Cod_Gabbia"), rs.getTimestamp("Data_Inizio_Pulizia"),rs.getTimestamp("Data_Fine_Pulizia"),rs.getBoolean("Disponibile"),rs.getBoolean("ServeAiuto"),rs.getString("NotePulizia"));
                    listaPulizie.add(pul);
   
        }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    
       
        Utente[][] utlist= new Utente[listaPulizie.size()][3];
        
        for(int i =0;i<listaPulizie.size();i++)
        {
            Utente  ut=new Utente();
          for(int j=0;j<3;j++)
          {
               Utente user=new Utente();
              utlist[i][j]=user;
          }
          
           int j=0;
           
        String query = "Select * from pulisce  where Cod_Pulizia= '"+listaPulizie.get(i).getCodice_Pulizia()+"'";
        try {
           
            rs=st.executeQuery(query);
            
             while(rs.next())  
        {
           
            
             utlist[i][j].setUsername(rs.getString("pulisce.Cod_Custode"));
             
              System.out.println(rs.getString("pulisce.Cod_Custode"));
               System.out.println(j);
            j++;    
  
        }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        
        
        for(int i=0;i<utlist.length;i++)
        {
            for(int j=0;j<2;j++)
            {
             String query3 = "Select * from impiegato  where Codice_Impiegato= '"+utlist[i][j].getUsername()+"'";
        try {
            
            rs=st.executeQuery(query3);
            
             while(rs.next())  
        {
            System.out.println(j);
            utlist[i][j].setNome(rs.getString("Nome"));
            utlist[i][j].setCognome(rs.getString("Cognome"));
            
            
        }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
        }
        
        return utlist;
    }
    public ArrayList<Vende> getIncassi(ArrayList<String> prodlist,Date dat)
    {
        ArrayList<Vende> venlist = new ArrayList<Vende>();
        for(int i=0;i<prodlist.size();i++)
        {
        Vende ven;
         String prodotto=prodlist.get(i);
         String data1=dat.toString()+" 00:00:00";
         String data2=dat.toString()+" 23:59:59";
        int quantita=0;
        double ricavi=0;
        String query = "Select * from vende where vende.Cod_Prodotto= '"+prodlist.get(i)+"'AND vende.DataTime_Vendita >=  '"+data1+"' AND vende.DataTime_Vendita <= '"+data2+"'";
        try {
            
            rs=st.executeQuery(query);
            
             while(rs.next())  
        {
            
            
            quantita=quantita+rs.getInt("Quantita");
            ricavi=ricavi+rs.getDouble("Ricavo");
            
            
        }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(quantita>0)
        {
        ven=new Vende();
        ven.setCod_Prodotto(prodotto);
        ven.setQuantita(quantita);
        ven.setRicavi(ricavi);
        venlist.add(ven);
        }
        }
        return venlist;
    }
    public double totaleIncassi(ArrayList<Vende> venlist)
    {
        double totale=0;
        for(int i=0;i<venlist.size();i++)
        {
            totale=totale+venlist.get(i).getRicavi();
        }
        return totale;
    }
    
    
    public void addProdotto(String Codice_Prodotto, double Prezzo, int Giacenza){
      try {
         st.executeUpdate("INSERT INTO prodotto values ('"+Codice_Prodotto+"','"+Prezzo+"','"+Giacenza+"')");
     }   catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }  
    
    }
    public void vendiProdotto(Prodotto p, int q, Utente u){
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        format.format(date);
        double ricavo = q*p.getPrezzo();
        
        try {
         st.executeUpdate("INSERT INTO vende values ('"+0+"','"+u.getUsername()+"','"+p.getTipo()+"','"+q+"','"+ricavo+"','"+format.format(date)+"')");
            }   catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        int newGiacenza = p.getGiacenza()-q;
        try {
         st.executeUpdate("UPDATE `prodotto` SET `Giacenza` = '"+newGiacenza+"' WHERE `prodotto`.`Codice_Prodotto` = '"+p.getTipo()+"' ");
            }   catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void addToGiacenza(Prodotto p,int q){
        int newGiacenza = q + p.getGiacenza();
        
        try {
         st.executeUpdate("UPDATE `prodotto` SET `Giacenza` = '"+newGiacenza+"' WHERE `prodotto`.`Codice_Prodotto` = '"+p.getTipo()+"' ");
            }   catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ArrayList <Pulizia> listPulizieDisponibili(){
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String dataInizio = format.format(date).toString()+" 00:00:00";
        
        ArrayList<Pulizia> listaPulizie = new ArrayList<Pulizia>();
        String query = "Select * from pulizia WHERE Disponibile = "+true+" AND ServeAiuto="+false+" AND Data_Inizio_Pulizia='"+dataInizio+"'";

           try{
               Pulizia pul;
               rs = st.executeQuery(query);
                while(rs.next())
                {
                    pul = new Pulizia(rs.getInt("Codice_Pulizia"),rs.getString("Cod_Gabbia"), rs.getDate("Data_Inizio_Pulizia"),rs.getDate("Data_Fine_Pulizia"),rs.getBoolean("Disponibile"),rs.getBoolean("ServeAiuto"),rs.getString("NotePulizia"));
                    listaPulizie.add(pul);
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
           return listaPulizie;
           
    }
    
    public ArrayList <Pulizia> listRichiesteAiuto(){
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String dataInizio = format.format(date).toString()+" 00:00:00";
        ArrayList<Pulizia> listaPulizie = new ArrayList<Pulizia>();
        
        String query = "Select * from pulizia WHERE ServeAiuto = "+true+" AND Disponibile = "+false+" AND Data_Inizio_Pulizia >='"+dataInizio+"'";

           try{
               Pulizia pul;
               rs = st.executeQuery(query);
                while(rs.next())
                {
                    pul = new Pulizia(rs.getInt("Codice_Pulizia"),rs.getString("Cod_Gabbia"), rs.getDate("Data_Inizio_Pulizia"),rs.getDate("Data_Fine_Pulizia"),rs.getBoolean("Disponibile"),rs.getBoolean("ServeAiuto"),rs.getString("NotePulizia"));
                    listaPulizie.add(pul);
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
           return listaPulizie;
           
    }
    
     public ArrayList <Pasto> listaPasti(){
        String query = "Select * from pasti ";
        ArrayList<Pasto> listaPasti = new ArrayList<Pasto>();

           try{
               Pasto pas;
               rs = st.executeQuery(query);
                while(rs.next())
                {
                    pas = new Pasto(rs.getInt("Codice_Pasto"),rs.getString("Cod_Gabbia"), rs.getDate("Data_Pasto"),rs.getBoolean("Disponibile"),rs.getBoolean("Terminato"));
                    listaPasti.add(pas);
                    
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
           return listaPasti;
        
    }
 
    public ArrayList <Pasto> listaPastiDisponibili(){
        Date date = new Date();
        DateFormat formatDate = new SimpleDateFormat("yyyy.MM.dd");
        DateFormat formatDateTime = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String adesso= formatDateTime.format(date).toString();
        String dataInizio = formatDate.format(date).toString()+" 00:00:00";
        
        String query = "Select * from pasti WHERE Disponibile = "+true+" AND Terminato= "+false+" AND Data_Pasto<'"+adesso+"'AND Data_Pasto>'"+dataInizio+"'";
        ArrayList<Pasto> listaPasti = new ArrayList();

           try{
               Pasto pas;
               rs = st.executeQuery(query);
                while(rs.next())
                {
                    pas = new Pasto(rs.getInt("Codice_Pasto"),rs.getString("Cod_Gabbia"), rs.getDate("Data_Pasto"),rs.getBoolean("Disponibile"),rs.getBoolean("Terminato"));
                    listaPasti.add(pas);
                    
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
           return listaPasti;
        
    }
    
    public void addPulizieGionaliere(){
        
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String dataInizio = format.format(date).toString()+" 00:00:00";
        String dataFine ="1980/01/01 01:00:00";
                
        ArrayList<Habitat> list = selezionaHabitat();
        for(int i=0;i<list.size();i++){
            try{
            st.executeUpdate("INSERT INTO pulizia values("+0+",'"+list.get(i).getHabitat()+"','"+dataInizio+"','"+dataFine+"',"+true+","+false+",' ')");
            }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
    

        public void addPranziGionalieri(){
        
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String dataPasto = format.format(date).toString()+" 12:00:00";
        
                
        ArrayList<Habitat> list = selezionaHabitat();
        for(int i=0;i<list.size();i++){
            try{
            st.executeUpdate("INSERT INTO pasti values("+0+",'"+list.get(i).getHabitat()+"','"+dataPasto+"',"+true+","+false+")");
            }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
        public void addCeneGionaliere(){
        
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String dataPasto = format.format(date).toString()+" 19:00:00";
        
                
        ArrayList<Habitat> list = selezionaHabitat();
        for(int i=0;i<list.size();i++){
            try{
            st.executeUpdate("INSERT INTO pasti values("+0+",'"+list.get(i).getHabitat()+"','"+dataPasto+"',"+true+","+false+")");
            }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
        public boolean ciSonoCompiti(){
        
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String data = format.format(date).toString()+" 00:00:00";
        try{
            String query = "Select * from pulizia where Data_Inizio_Pulizia = '"+data+"'";
            rs = st.executeQuery(query);
           
            while(rs.next())  return true;
            
        }catch(Exception ex){
            

        }
        return false;
    }   
        
    public void accettaPulizia(Pulizia pul,Utente user){
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        
        
        try{
            st.executeUpdate("INSERT INTO pulisce values("+0+",'"+user.getUsername()+"','"+pul.getCodice_Pulizia()+"')");
            }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        try{
            st.executeUpdate("UPDATE pulizia SET Disponibile = "+ false + " , Data_Inizio_Pulizia='"+format.format(date).toString()+"' where Codice_Pulizia = "+ pul.getCodice_Pulizia() + "");
            }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }    
    
    public void accettaPasto(Pasto pas,Utente user){
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        
        
        try{
            st.executeUpdate("INSERT INTO nutre values("+0+",'"+user.getUsername()+"','"+pas.getCodice_Pasto()+"')");
            }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        try{
            st.executeUpdate("UPDATE pasti SET Disponibile = "+ false + ", Data_Pasto='"+format.format(date).toString()+"' where Codice_Pasto = '"+ pas.getCodice_Pasto() + "' ");
            }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
    }    
    
    public void richiediAiutoPulizia(Pulizia pul,Utente user){
        try{
            st.executeUpdate("UPDATE pulizia SET ServeAito = "+ true + " where Codice_Pulizia = '"+ pul.getCodice_Pulizia() + "'");
            }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }    
    
    public void terminaCompito(Utente user){
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String data = format.format(date).toString()+" 00:00:00";
        
        if(stoNutrendo(user)){
            Pasto pas =attualePasto(user);
        try{
            st.executeUpdate("UPDATE pasti SET Terminato= "+true+" WHERE Codice_Pasto='"+pas.getCodice_Pasto()+"'");
            }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }else {
           
            Pulizia pul =attualePulizia(user);
            try{
            st.executeUpdate("UPDATE pulizia SET Data_Fine_Pulizia= '"+data+"' WHERE Codice_Pulizia='"+pul.getCodice_Pulizia()+"'");
            }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        }
            
    public void annullaCompito(Utente user){
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String data = format.format(date).toString()+" 00:00:00";
            
        if(stoNutrendo(user)){
            Pasto pas =attualePasto(user);
            try{
            st.executeUpdate("UPDATE pasti SET Disponibile= "+true+" WHERE Codice_Pasto='"+pas.getCodice_Pasto()+"'");
            }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else if(stoPulendo(user)) {
            
            Pulizia pul =attualePulizia(user);
            try{
            st.executeUpdate("UPDATE pulizia SET Disponibile= "+true+" WHERE Codice_Pulizia='"+pul.getCodice_Pulizia()+"'");
            }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
    }
    
        }
        }
    
    
    public boolean stoPulendo(Utente user){
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String data = format.format(date).toString()+" 00:00:00";
        ArrayList<String> list = new ArrayList<String>();
        try{
            String query = "Select * from pulisce WHERE Cod_Custode='"+user.getUsername()+"'" ;
            rs = st.executeQuery(query);
           
            while(rs.next())  
            list.add(rs.getString("Cod_Pulizia"));
        }catch(Exception ex) {
            
        }
        
        if(list.size()>0){
            for(int i=0;i<list.size();i++){
                
            try{  
            
            String query = "Select * from pulizia WHERE Codice_Pulizia='"+list.get(i)+"' AND Disponibile ="+false+" AND Data_Inizio_Pulizia > '"+data+"' AND Data_Fine_Pulizia < '"+data+"' ";
            rs = st.executeQuery(query);
            while(rs.next()){
                System.out.println(list.get(i));
                return true;}
            }catch(Exception ex) {
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
        return false;
    }

    public boolean stoNutrendo(Utente user){
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String data = format.format(date).toString()+" 00:00:00";
        ArrayList<String> list = new ArrayList<String>();
        try{
            String query = "Select * from nutre WHERE Cod_Custode='"+user.getUsername()+"'" ;
            rs = st.executeQuery(query);
           
            while(rs.next())  
            list.add(rs.getString("Cod_Pasto"));
        }catch(Exception ex) {
            
        }
        
        if(list.size()>0){
            for(int i=0;i<list.size();i++){
                
            try{  
            
            String query = "Select * from pasti WHERE Codice_Pasto='"+list.get(i)+"' AND Disponibile ="+false+" AND Data_Pasto > '"+data+"' AND Terminato="+false+" ";
            rs = st.executeQuery(query);
            while(rs.next()){
                System.out.println(list.get(i));
                return true;}
            }catch(Exception ex) {
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
        return false;
    }
    
    public Pulizia attualePulizia(Utente user){
        Pulizia pul = new Pulizia();
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String data = format.format(date).toString()+" 00:00:00";
        ArrayList<String> list = new ArrayList<String>();
        try{
            String query = "Select * from pulisce WHERE Cod_Custode='"+user.getUsername()+"'" ;
            rs = st.executeQuery(query);
           
            while(rs.next())  
            list.add(rs.getString("Cod_Pulizia"));
        }catch(Exception ex) {
            
        }
        
        if(list.size()>0){
            for(int i=0;i<list.size();i++){
                
            try{   
            String query = "Select * from pulizia WHERE Codice_Pulizia='"+list.get(i)+"' AND Disponibile ="+false+" AND Data_Inizio_Pulizia > '"+data+"' AND Data_Fine_Pulizia < '"+data+"' ";
            rs = st.executeQuery(query);
            while(rs.next()){
                pul = new Pulizia(rs.getInt("Codice_Pulizia"),rs.getString("Cod_Gabbia"), rs.getDate("Data_Inizio_Pulizia"),rs.getDate("Data_Fine_Pulizia"),rs.getBoolean("Disponibile"),rs.getBoolean("ServeAiuto"),rs.getString("NotePulizia"));
            }
            }catch(Exception ex){
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
        return pul;
    }

    public Pasto attualePasto(Utente user){
        Pasto pas = new Pasto();
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String data = format.format(date).toString()+" 00:00:00";
        ArrayList<String> list = new ArrayList<String>();
        try{
            String query = "Select * from nutre WHERE Cod_Custode='"+user.getUsername()+"'" ;
            rs = st.executeQuery(query);
           
            while(rs.next())  
            list.add(rs.getString("Cod_Pasto"));
        }catch(Exception ex) {
            
        }
        
        if(list.size()>0){
            for(int i=0;i<list.size();i++){
                
            try{  
            
            String query = "Select * from pasti WHERE Codice_Pasto='"+list.get(i)+"' AND Disponibile ="+false+" AND Data_Pasto > '"+data+"' AND Terminato="+false+" ";
            rs = st.executeQuery(query);
            while(rs.next()){
                pas = new Pasto(rs.getInt("Codice_Pasto"),rs.getString("Cod_Gabbia"), rs.getDate("Data_Pasto"),rs.getBoolean("Disponibile"),rs.getBoolean("Terminato"));
            }
            }catch(Exception ex) {
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
        return pas;
    }
}
