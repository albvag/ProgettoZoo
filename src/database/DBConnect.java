/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.Date;
import progettozoo.Animale;
import progettozoo.Habitat;
import progettozoo.Pasto;
import progettozoo.Prodotto;
import progettozoo.ProgettoZoo;
import progettozoo.Pulizia;
import progettozoo.Utente;
import progettozoo.Vende;
import progettozoo.Visita;

/**
 *
 * @author Alberto
 */
public class DBConnect {
    
    private Connection conn;
    private Statement st;
    private ResultSet rs;
    
    
    /**
     * Crea una connessione al DB
     */
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
    /**
     * Chiude la connessione al DB
     */
    public void close() throws Throwable {
        try {
            super.finalize();
            
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }
    
    /**
     * Imposta le connessioni massime
     */
    public void setmaxconn(int n){
        String query = "set global max_connections= "+n;
        
           try{
               rs = st.executeQuery(query);
    
            }catch(Exception ex){
                
                System.out.println(ex);
            }   
           
    }
    
    /**
     * Crea il codice identificativo per l'animale insetito
     * il codice è composto dalla specie dell'animale più un numero
     */
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
    
    /**
     * Ritorna il numero di direttori presenti nel DB
     */
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
    
    /**
     * Query di inserimento di una nuova specie nel DB
     */
     public void insertSpecie(String Cod_Specie)
    {
        try {
            st.executeUpdate("INSERT INTO specie values ('"+Cod_Specie+"')");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    /**
     * Query di inserimento un nuovo habitat nel DB
     * e data l'ora inserisce i pasti
     * fino alle 14:59 inserisce pranzo e cena
     * dalle 15:00 alle 20:59 inserisce solo la cena
     * dalle 21:00 non inseriesce pasti
     */ 
    public void insertHabitat(String Cod_Gabbia,String Cod_Specie)
    {
        try {
            st.executeUpdate("INSERT INTO gabbia values ('"+Cod_Gabbia+"','"+Cod_Specie+"')");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
           Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String dataPranzo = format.format(date)+" 12:00:00";
        String dataCena = format.format(date)+" 19:00:00";
        String dataLimite = format.format(date)+" 12:00:00";
        
        if(date.getHours()<15){
            try{
                st.executeUpdate("INSERT INTO pasti values("+0+",'"+Cod_Gabbia+"','"+dataPranzo+"',"+true+","+false+")");
            }catch(SQLException ex) {
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(date.getHours()<21){
            try{
                st.executeUpdate("INSERT INTO pasti values("+0+",'"+Cod_Gabbia+"','"+dataCena+"',"+true+","+false+")");
            }catch(SQLException ex) {
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Query di inserimento di un nuovo animale nel DB
     */
    public void insertAnimale(String Cod_Animale,String nome,String specie,String genere,Date data,int salute,int nostro,int presente)
    {
     try {
         st.executeUpdate("INSERT INTO animale values ('"+Cod_Animale+"','"+nome+"','"+specie+"','"+genere+"','"+data+"',"+salute+","+nostro+","+presente+")");
     }   catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Query di inserimento un animale nell'habitat nella table situto del DB
     */
    public void insertAnimaleSituato(int codsituato,String Cod_anim,String Cod_Hab)
    {
        try {
            st.executeUpdate("INSERT INTO situato values ("+codsituato+",'"+Cod_anim+"','"+Cod_Hab+"')");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    /**
     * Query di inserimento del personale nel DB
     */
    public void insertImpiegato(String user,String nome,String cognome,Date data,String residenza,String indirizzo,String telefono)
    {
     try {
         st.executeUpdate("INSERT INTO impiegato values ('"+user+"','"+nome+"','"+cognome+"','"+residenza+"','"+indirizzo+"','"+telefono+"','"+data+"')");
     }   catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     /**
     * Query di inserimento di un utente nel DB
     */
    public void inserisciUtente(String user,String password,String ruolo)
    {
        try {
            st.executeUpdate("INSERT INTO utente values ('"+user+"','"+password+"','"+ruolo+"')");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /**
     * Query di inserimento di un direttore nel DB
     */
    public void insertDirettore(String user)
    {
        try{
            st.executeUpdate("INSERT INTO direttore values('"+user+"')");
        }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Query di inserimento di un veterinario nel DB
     */
    public void insertVeterinario(String user)
    {
        try{
            st.executeUpdate("INSERT INTO veterinario values('"+user+"')");
        }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         
    /**
     * Query di inserimento di un custode nel DB
     */     
    public void insertCustode(String user)
    {
        try{
            st.executeUpdate("INSERT INTO custode values('"+user+"')");
        }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Query di inserimento di un cassiere nel DB
     */
    public void insertCassiere(String user)
            
    /**
     * Query di inserimento di una visita nel DB
     */
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
    
    /**
     * Query per la modifica della salute di un animale nel DB 
     * e restituisce la salute
     */
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
    
    /**
     * Query per modifica dell'attributo presente della tabella animale 
     * serve per gestire il prestito degli animali
     */
     public void updateAnimalePresente(boolean presente,Animale an)
    {
        
        try {
            st.executeUpdate("UPDATE animale SET Presente = "+ presente + " where Codice_Animale = '"+ an.getId()+ "'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     /**
     * Query per la modifica del prezzo di un prodotto nel DB
     */
    public double updatePrezzoProdotto(double prezzo, String prodotto)
    {
       
        try {
            st.executeUpdate("UPDATE prodotto SET Prezzo = '"+ prezzo + "' where Codice_Prodotto = '"+ prodotto + "'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prezzo;
    }
      
    /**
     * Query per la modifica dei dati del personale nel DB
     * Il codice utente non è modificabile
     */
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
      
    /**
     * Query per la modifica dei dati di un animale nel DB
     * il codice identificativo, la specie e l'habitat di appartenenza non sono modificabili
     */
    public void updateAnimale(String nome,String genere,Date data,int nostro,String codice)
      {
        try {
            st.executeUpdate("UPDATE animale SET Nome= '"+nome+"',Genere= '"+genere+"',Data_Nascita= '"+data.toString()+"',Nostro= "+nostro+" where Codice_Animale= '"+codice+"'" );
                    } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    
    /**
     * Query che restituisce l'habitat dato un animale
     */
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
    
    /**
     * Query che restituisce il ruolo dato un utente
     */
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
    
    /**
    * Query che restituisce una lista di habitat
    */
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
    
    /**
     * Query che restituisce l'habitat di una specie data
     */
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
    
    /**
     * Query che restituisce un habitat dato il codice dell'habitat
     */
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
    
    /**
     * Query che restituisce la lista delle specie
     */
    public ArrayList<String> selezionaSpecie()
    {
        ArrayList<String> spelist = new ArrayList<>();
        String query = "Select distinct Codice_Specie from specie ";

           try{
               String specie;
               rs = st.executeQuery(query);
               
               
                while(rs.next())
                {
                    
                    specie = rs.getString("specie.Codice_Specie");
                    spelist.add(specie);
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
           return spelist; 
    }
    
    /**
     * Query che restituisce un prodotto dato il codice
     */
    public Prodotto selezionaProdotto(String prodotto)
    {
        Prodotto pro = new Prodotto();
        String query = "Select * from prodotto where prodotto.Codice_Prodotto=  '"+prodotto+"'";

           try{
               
               rs = st.executeQuery(query);
               
               
                while(rs.next())
                {
                    pro = new Prodotto(rs.getString("prodotto.Codice_Prodotto"),rs.getDouble("prodotto.Prezzo"),rs.getInt("prodotto.Giacenza"));
                    
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
           return pro;
    }
    
    /**
     * Query che restituisce un animale dato il nome e la specie
     */
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
    
    /**
     * Query che restituisce la lista delle specie di cui esiste anche un animale
     */
    public ArrayList<String> selezionaAnimaliSpecie()
    {
        ArrayList<String> spelist = new ArrayList<>();
        String query = "Select distinct Specie from animale ";
        
           try{
               String spe;
               rs = st.executeQuery(query);
               
               
                while(rs.next())
                {
                    
                    spe = rs.getString("animale.Specie");
                    spelist.add(spe);
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
           return spelist; 
    }
    
    /**
     * Query che restituisce la lista dei nome degli animali data la specie a cui appartengono
     */
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
     
     /**
     * Query che restituisce la lista degli animali appartenetni allo zoo che sono presenti in questo momento
     */
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
    
    /**
     * Query che restituisce la lista degli animali appertanenti allo zoo che sono al momento in prestito
     */
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
    
    /**
     * Query che restituisce un impiegato dato il ruolo e il nome
     */
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
    
    /**
     * Query che restituisce la lista di impiegati
     */
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
    
    /**
    * Query che restituisce la lista dei ruoli
    */
    
     public ArrayList<String> selezionaPersonaleRuolo()
    {
        ArrayList<String> ruololist = new ArrayList<>();
        String query = "SELECT DISTINCT Ruolo_Utente from utente";

           try{
               String ruolo;
               rs = st.executeQuery(query);
               
               
                while(rs.next())
                {   
                    
                    
                    ruolo = rs.getString("utente.Ruolo_Utente");
                    
                    
                    ruololist.add(ruolo);
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
           return ruololist; 
    }
     
    /**
     * Query che restituisce una lista con i nomi e cognomi del personale
     */ 
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
    
    /**
     * dato il nome dell'animale restituisce il codice identificativo
     */
    public String selezionaCodiceAnimale(String nome)
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
    
    /**
     * Query che restituisce il codice identificativo di un impiegato dato il cognome
     */
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
    
    /**
     * Query che dato il codice identificativo cancella un impiegato dalla tabella impiegato
     */
    public void deletePersonaleImpiegato(String  codice)
    {
        try {
            st.execute("DELETE FROM impiegato where impiegato.Codice_Impiegato = '"+codice+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Query che dato il codice identificativo cancella un utente dalla tabella utente 
     */
    public void deletePersonaleUtente(String  codice)
    {
        try {
            st.execute("DELETE FROM utente where utente.Codice_Utente = '"+codice+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Query che dato il codice identificativo cancella un direttore dalla tabella direttore 
     */
    public void deleteDirettore(String  codice)
    {
        try {
            st.execute("DELETE FROM direttore where direttore.Codice_Direttore = '"+codice+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Query che dato il codice identificativo cancella un veterinario dalla tabella veterinario 
     */
    public void deleteVeterinario(String  codice)
    {
        try {
            st.execute("DELETE FROM veterinario where veterinario.Codice_Veterinario = '"+codice+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Query che dato il codice identificativo cancella un custode dalla tabella custode 
     */
    public void deleteCustode(String  codice)
    {
        try {
            st.execute("DELETE FROM custode where custode.Codice_Custode = '"+codice+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Query che dato il codice identificativo cancella un cassiere dalla tabella cassiere 
     */
    public void deleteCassiere(String  codice)
    {
        try {
            st.execute("DELETE FROM cassiere where cassiere.Codice_Cassiere = '"+codice+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Query che cancella un habitat dato il codice identificativo
     */
    public void deleteHabitat(String Cod_Gabbia)
    {
        try {
            st.execute("DELETE FROM gabbia where Codice_Gabbia= '"+Cod_Gabbia+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Query che cancella cancella una specie
     */
    public void deleteSpecie(String specie)
    {
        try {
            st.execute("DELETE FROM specie where Codice_Specie= '"+specie+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Query che cancella un prodotto
     */
    public void deleteProdotto(String codice)
    {
        try {
            st.execute("DELETE FROM prodotto where Codice_Prodotto= '"+codice+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Query che cancella un animale
     */
    public void deleteAnimale(String Cod_anim)
    {
        try {
            st.execute("DELETE FROM animale where Nome= '"+Cod_anim+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Query che cancella tutte le visite dell'animale che ha come codice il codice dato
     */
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
         
    /**
     * Query che controlla che esiste un animale con il codice dato
     */
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
    
    /**
     * Query che controlla che esiste un impiegato con il codice dato 
     */
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
    
    /**
     * Query che controlla che esiste un habitat con il codice dato 
     */
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
    
    /**
     * Query che controlla se un habitat è vuoto con il codice dato 
     */
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
    
    
    /**
     * verifica la corrispondenza tra utente e password inseriti
     */
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
    
    /**
     * Query che restituisce l'utente che ha come codice identificativo il codice dato
     */
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

    
    /**
     * Query che restituisce una lista di animali che soddisfano i filtri
     */
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
       
       /**
        * Query che restituisce la lista delle visite di un animale
        */
       public ArrayList<Visita> visitaList(String animale)
       {
        ArrayList<Visita> visitaList = new ArrayList<>();
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
       
       /**
        * Query che restituisce la lista di tutte le visite
        */
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
    
    /**
     * Query che restituisce la lista dei prodotti attualmente venduti nello zoo
     */   
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
    
    /**
     * Query che restituisce la lista di tutti i prodotti che siano mai stati venduti nello zoo
     */
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
    
    /**
     * Query che restituisce un array di utenti e riempie la lista dei pasti del giorno dato
     */
    public Utente[] getPasti(Date dat,ArrayList<Pasto> listaPasti)
    {
        
       
        Pasto pas;
        
         String data1=dat.toString()+" 00:00:00";
         String data2=dat.toString()+" 23:59:59";
         
        //viene riempita la lista dei pasti del giorno dato
        
       String query1 = "Select * from pasti  where  pasti.Data_Pasto >=  '"+data1+"' AND pasti.Data_Pasto <= '"+data2+"'";
        try {
            
            rs=st.executeQuery(query1);
            
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
        
        //lista di nutre che hanno come pasto una di quelle nella lista riempita sopra
        
        String query2 = "Select * from nutre  where Cod_Pasto= '"+listaPasti.get(i).getCodice_Pasto()+"'";
        try {
            
            rs=st.executeQuery(query2);
            
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
            //riempio l'array con gli utenti che hanno nutrito gli habitat
            //l'indice dell'utente corrisponde all'indice del pasto che l'utente ha portato all'habitat
            
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
     
    /**
     * Query che restituisce una matrice con gli utenti che hanno pulito gli habitat e riempie la lista delle pulizie del giorno 
     */ 
    public Utente[][] getPulizie(Date dat,ArrayList<Pulizia> listaPulizie)
    {
        
       
        Pulizia pul;
        
         String data1=dat.toString()+" 00:00:00";
         String data2=dat.toString()+" 23:59:59";
         
       //lista di pulizie del giorno dato
         
       String query1 = "Select * from pulizia  where  pulizia.Data_Pulizia >=  '"+data1+"' AND pulizia.Data_Pulizia <= '"+data2+"'";
        try {
            
            rs=st.executeQuery(query1);
            
             while(rs.next())  
        {
            
            
             pul = new Pulizia(rs.getInt("Codice_Pulizia"),rs.getString("Cod_Gabbia"), rs.getTimestamp("Data_Pulizia"),rs.getBoolean("Disponibile"),rs.getBoolean("ServeAiuto"),rs.getBoolean("Terminato"));
                    listaPulizie.add(pul);
   
        }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    
       
        Utente[][] utlist= new Utente[listaPulizie.size()][3];
        
        //inizializzo la matrice
        
        for(int i =0;i<listaPulizie.size();i++)
        {
            Utente  ut=new Utente();
          for(int j=0;j<3;j++)
          {
               Utente user=new Utente();
              utlist[i][j]=user;
          }           
          int j=0;
         
        //lista dei pulisce in cui la pulizia appartiene alla lista riempita sopra
           
        String query2 = "Select * from pulisce  where Cod_Pulizia= '"+listaPulizie.get(i).getCodice_Pulizia()+"'";
        try {
           
            rs=st.executeQuery(query2);
            
             while(rs.next())  
        {
           
            
             utlist[i][j].setUsername(rs.getString("pulisce.Cod_Custode"));
             
              
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
                
               //riempie la matrice con gli utenti che hanno pulito gli habita
               //l'indice delle colonne della matrice coincide con l'indice della pulizia nella lista
             String query3 = "Select * from impiegato  where Codice_Impiegato= '"+utlist[i][j].getUsername()+"'";
        try {
            
            rs=st.executeQuery(query3);
            
             while(rs.next())  
        {
            
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
    
    /**
     * Query che restituisce gli incassi dello zoo in una data specificata
     */
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
    
    /**
     * Funzione che data la lista degli incassi restituisce il ricavo totale
     */
    public double totaleIncassi(ArrayList<Vende> venlist)
    {
        double totale=0;
        for(int i=0;i<venlist.size();i++)
        {
            totale=totale+venlist.get(i).getRicavi();
        }
        return totale;
    }
    
    /**
     * Query che aggiunge un prodotto al DB
     */
    public void addProdotto(String Codice_Prodotto, double Prezzo, int Giacenza){
      try {
         st.executeUpdate("INSERT INTO prodotto values ('"+Codice_Prodotto+"','"+Prezzo+"','"+Giacenza+"')");
     }   catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }  
    
    }
    
    /**
     * Query per la vendità di un prodotto
     */
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
    
    /**
     * Query per aggiungere prodotti alla giacenza
     */
    public void addToGiacenza(Prodotto p,int q){
        int newGiacenza = q + p.getGiacenza();
        
        try {
         st.executeUpdate("UPDATE `prodotto` SET `Giacenza` = '"+newGiacenza+"' WHERE `prodotto`.`Codice_Prodotto` = '"+p.getTipo()+"' ");
            }   catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Query che restituisce la lista di pulizie odierne disponibili 
     */
    public ArrayList <Pulizia> listPulizieDisponibili(){
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String dataInizio = format.format(date)+" 00:00:00";
        
        ArrayList<Pulizia> listaPulizie = new ArrayList<>();
        String query = "Select * from pulizia WHERE Disponibile = "+true+" AND ServeAiuto="+false+" AND Data_Pulizia = '"+dataInizio+"'";

           try{
               Pulizia pul;
               rs = st.executeQuery(query);
                while(rs.next())
                {
                    pul = new Pulizia(rs.getInt("Codice_Pulizia"),rs.getString("Cod_Gabbia"), rs.getDate("Data_Pulizia"),rs.getBoolean("Disponibile"),rs.getBoolean("ServeAiuto"),rs.getBoolean("Terminato"));
                    listaPulizie.add(pul);
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
           return listaPulizie;
           
    }
    
    /**
     * Query che restituisce la lista delle pulizie odierne di cui è stato richiesto aiuto
     */
    public ArrayList <Pulizia> listRichiesteAiuto() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String dataInizio = format.format(date)+" 00:00:00";
        
        ArrayList<Pulizia> listaPulizie = new ArrayList<>();
        
        String query = "Select * from pulizia WHERE ServeAiuto = "+true+" AND Disponibile = "+false+" AND Data_Pulizia >= '"+dataInizio+"' AND Terminato = "+false+" ";

           try{
               Pulizia pul;
               rs = st.executeQuery(query);
                while(rs.next())
                {
                    pul = new Pulizia(rs.getInt("Codice_Pulizia"),rs.getString("Cod_Gabbia"), rs.getDate("Data_Pulizia"),rs.getBoolean("Disponibile"),rs.getBoolean("ServeAiuto"),rs.getBoolean("Terminato"));
                    listaPulizie.add(pul);
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
           
           return listaPulizie;
           
    }
    
    /**
     * Query che restituisce la lista dei pasti odierni ancora disponibili
     * Prima delle 12:00 restituisce un lista vuota
     * Dalle 12:00 fino alle 17:59 restituisce la lista contenente i prazi che sono diponibili
     * Dalle 19:00 fino alle 23:59 restituisce la lista contenente i prazi e le cene ancora disponibili
     */
    public ArrayList <Pasto> listaPastiDisponibili(){
        Date date = new Date();
        DateFormat formatDate = new SimpleDateFormat("yyyy.MM.dd");
        DateFormat formatDateTime = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String adesso= formatDateTime.format(date);
        String dataInizio = formatDate.format(date)+" 00:00:00";
        String dataCena = formatDate.format(date)+" 18:00:00";
        String query;
        if(date.getHours()<18){
            query = "Select * from pasti WHERE Disponibile = "+true+" AND Terminato = "+false+" AND Data_Pasto<'"+adesso+"'AND Data_Pasto>'"+dataInizio+"'";
        }else query = "Select * from pasti WHERE Disponibile = "+true+" AND Terminato = "+false+" AND Data_Pasto<'"+adesso+"'AND Data_Pasto>'"+dataCena+"'";
            
        ArrayList<Pasto> listaPasti = new ArrayList();

           try{
               Pasto pas;
               rs = st.executeQuery(query);
                while(rs.next())
                {
                    pas = new Pasto(rs.getInt("Codice_Pasto"),rs.getString("Cod_Gabbia"), rs.getTimestamp("Data_Pasto"),rs.getBoolean("Disponibile"),rs.getBoolean("Terminato"));
                    listaPasti.add(pas);
                    
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
           return listaPasti;
        
    }
    
    /**
     * Query che aggiunge le pulizie odierne nel DB
     */
    public void addPulizieGionaliere(){
        
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String dataInizio = format.format(date)+" 00:00:00";
        String dataFine ="1980/01/01 01:00:00";
                
        ArrayList<Habitat> list = selezionaHabitat();
        for(int i=0;i<list.size();i++){
            try{
            st.executeUpdate("INSERT INTO pulizia values("+0+",'"+list.get(i).getHabitat()+"','"+dataInizio+"',"+true+","+false+","+false+")");
            }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
    /**
     * Query che aggiunge i pranzi odierni al DB
     */
    public void addPranziGionalieri(){
        
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String dataPasto = format.format(date)+" 12:00:00";
        
                
        ArrayList<Habitat> list = selezionaHabitat();
        for(int i=0;i<list.size();i++){
            try{
            st.executeUpdate("INSERT INTO pasti values("+0+",'"+list.get(i).getHabitat()+"','"+dataPasto+"',"+true+","+false+")");
            }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
    /**
     * Query che aggiunge le cene odierne nel DB
     */
    public void addCeneGionaliere(){
        
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String dataPasto = format.format(date)+" 19:00:00";
        
                
        ArrayList<Habitat> list = selezionaHabitat();
        for(int i=0;i<list.size();i++){
            try{
            st.executeUpdate("INSERT INTO pasti values("+0+",'"+list.get(i).getHabitat()+"','"+dataPasto+"',"+true+","+false+")");
            }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
    /**
     * Query che controlla se sono stati creati compiti per oggi nel DB
     * Controllando se esintono pasti con la dta di oggi nel DB
     */
    public boolean ciSonoCompiti(){
        
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String data = format.format(date)+" 12:00:00";
       
        
        try{
            String query = "Select * from pasti where Data_Pasto =  '"+data+"' ";
            rs = st.executeQuery(query);
           
            while(rs.next())  return true;
            
        }catch(Exception ex){
            

        }
        return false;
    }   
    
    /**
     * Query usata per accettare una pulizia 
     * Aggiunge una riga nella tabella pulisce e setta la pulizia a non disponibile
     */
    public void accettaPulizia(Pulizia pul,Utente user){
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        
        
        try{
            st.executeUpdate("INSERT INTO pulisce values("+0+",'"+user.getUsername()+"','"+pul.getCodice_Pulizia()+"')");
            }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        try{
            st.executeUpdate("UPDATE pulizia SET Disponibile = "+ false + " , ServeAiuto="+false+" where Codice_Pulizia = '"+ pul.getCodice_Pulizia() + "' ");
            }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }    
    
    /**
     * Query usate per accettare il compito pasto
     * aggiunge una riga alla tabella nutre e setta il pasto a non disponibile
     */
    public void accettaPasto(Pasto pas,Utente user){
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        
        
        try{
            st.executeUpdate("INSERT INTO nutre values("+0+",'"+user.getUsername()+"','"+pas.getCodice_Pasto()+"')");
            }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        try{
            st.executeUpdate("UPDATE pasti SET Disponibile = "+ false + " where Codice_Pasto = '"+ pas.getCodice_Pasto() + "' ");
            }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
    }    
    
    /**
     * Query per la richiesta di aiuto in una pulizia
     * setta ServeAiuto a true
     */
    public void richiediAiutoPulizia(Pulizia pul){
        try{
            st.executeUpdate("UPDATE pulizia SET ServeAiuto = "+true+" where Codice_Pulizia = '"+ pul.getCodice_Pulizia() + "'");
            }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }    
    
    /**
     * Query che serve a terminare un compito
     * setta Terminato a true
     */
    public void terminaCompito(Utente user){
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String data = format.format(date);
        
        if(stoNutrendo(user)){
            Pasto pas =attualePasto(user);
        try{
            st.executeUpdate("UPDATE pasti SET Terminato = "+true+" WHERE Codice_Pasto = '"+pas.getCodice_Pasto()+"'");
            }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }else {
           
            Pulizia pul =attualePulizia(user);
            try{
            st.executeUpdate("UPDATE pulizia SET Terminato = "+true+" WHERE Codice_Pulizia = '"+pul.getCodice_Pulizia()+"'");
            }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        }
    
    /**
     * Query usata per rinunciare a un compito accettato che non sia ha intenzione di terminare
     * modifica Disponibile mettendolo a true se si è l'unico che stava svolgendo il compito
     */
    public void annullaCompito(Utente user){
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String data = format.format(date)+" 00:00:00";
            
        if(stoNutrendo(user)){
            Pasto pas =attualePasto(user);
            try{
            st.executeUpdate("UPDATE pasti SET Disponibile = "+true+" WHERE Codice_Pasto = '"+pas.getCodice_Pasto()+"'");
            }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);}
            
            try {
            st.execute("DELETE FROM nutre where Cod_Pasto = '"+pas.getCodice_Pasto()+"' ");
            } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);}
            
        }else if(stoPulendo(user)) {
            Pulizia pul =attualePulizia(user);
            try{
                if(numeroCustodiInPulizia(pul)==1){
                    st.executeUpdate("UPDATE pulizia SET Disponibile = "+true+", Data_Pulizia = '"+data+"', ServeAiuto = "+false+" WHERE Codice_Pulizia = '"+pul.getCodice_Pulizia()+"'");
                }
            }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);   }
   
            try {
            st.execute("DELETE FROM pulisce where Cod_Pulizia = '"+pul.getCodice_Pulizia()+"' AND Cod_Custode ='"+user.getUsername()+"' ");
            } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);}
            
        }
        }
    
    /**
     * Query che restitusce true se l'utente sta eseguendo compiti di pulizia
     */
    public boolean stoPulendo(Utente user){
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String data = format.format(date)+" 00:00:00";
        ArrayList<String> list = new ArrayList<>();
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
            
            String query = "Select * from pulizia WHERE Codice_Pulizia= '"+list.get(i)+"' AND Disponibile = "+false+" AND Data_Pulizia >= '"+data+"' AND Terminato = "+false+" ";
            rs = st.executeQuery(query);
            while(rs.next()){
          
                return true;}
            }catch(Exception ex) {
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
        return false;
    }

    /**
     * Query che restitusce true se l'utente sta nutrendo un habitat
     */
    public boolean stoNutrendo(Utente user){
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String data = format.format(date)+" 00:00:00";
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
            
            String query = "Select * from pasti WHERE Codice_Pasto = '"+list.get(i)+"' AND Disponibile = "+false+" AND Data_Pasto > '"+data+"' AND Terminato = "+false+" ";
            rs = st.executeQuery(query);
            while(rs.next()){
                
                return true;}
            }catch(Exception ex) {
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
        return false;
    }
    
    /**
     * Query che restituisce il compito di pulizia che il custode sta attualmente svolgendo
     */
    public Pulizia attualePulizia(Utente user){
        Pulizia pul = new Pulizia();
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String data = format.format(date)+" 00:00:00";
        ArrayList<String> list = new ArrayList<>();
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
            String query = "Select * from pulizia WHERE Codice_Pulizia = '"+list.get(i)+"' AND Disponibile ="+false+" AND Data_Pulizia >= '"+data+"' AND Terminato = "+false+" ";
            rs = st.executeQuery(query);
            while(rs.next()){
                pul = new Pulizia(rs.getInt("Codice_Pulizia"),rs.getString("Cod_Gabbia"), rs.getDate("Data_Pulizia"),rs.getBoolean("Disponibile"),rs.getBoolean("ServeAiuto"),rs.getBoolean("Terminato"));
            }
            }catch(Exception ex){
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
        return pul;
    }

    /**
     * Query che restituisce il pasto che l'utente sta attualmente svolgendo
     */
    public Pasto attualePasto(Utente user){
        Pasto pas = new Pasto();
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String data = format.format(date)+" 00:00:00";
        DateFormat formatTime = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        
        ArrayList<String> list = new ArrayList<String>();
        try{
            String query = "Select * from nutre WHERE Cod_Custode = '"+user.getUsername()+"'" ;
            rs = st.executeQuery(query);
           
            while(rs.next())  
            list.add(rs.getString("Cod_Pasto"));
        }catch(Exception ex) {
            
        }
        
        if(list.size()>0){
            for(int i=0;i<list.size();i++){
                
            try{  
            
            String query = "Select * from pasti WHERE Codice_Pasto = '"+list.get(i)+"' AND Disponibile = "+false+" AND Data_Pasto > '"+data+"' AND Terminato = "+false+" ";
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
    
    /**
     * Query che restituisce il numero di custodi che stanno svolgendo una pulizia data 
     */
    public int numeroCustodiInPulizia(Pulizia pul){
        int i = 0;
        
        try {
            String query ="SELECT * FROM pulisce WHERE Cod_Pulizia= '"+pul.getCodice_Pulizia()+"' ";  
            rs = st.executeQuery(query);
            while(rs.next()){
               i++; 
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return i;
    }
}
