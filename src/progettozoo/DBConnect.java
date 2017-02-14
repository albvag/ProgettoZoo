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
    public int countSpecie(String specie)
    {
        int conta=0;
        String query="SELECT Specie from animale where animale.Specie= '"+specie+"'";
         try{
               
               rs = st.executeQuery(query);
               
               
                while(rs.next())
                {
                    rs.getString("animale.Specie");
                    conta++;
                    
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
           return conta+1; 
    }
     public void insertSpecie(String Cod_Specie)
    {
        try {
            st.executeUpdate("INSERT INTO specie values ('"+Cod_Specie+"')");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insertHabitat(String Cod_Gabbia)
    {
        try {
            st.executeUpdate("INSERT INTO gabbia values ('"+Cod_Gabbia+"')");
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
         st.executeUpdate("INSERT INTO impiegato values ('"+user+"','"+nome+"','"+cognome+"','"+data+"','"+residenza+"','"+indirizzo+"','"+telefono+"')");
     }   catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void inserisciUtente(String user,String password,int stato,String ruolo)
    {
        try {
            st.executeUpdate("INSERT INTO utente values ('"+user+"','"+password+"',"+stato+",'"+ruolo+"')");
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
        String query = "Select distinct Codice_Gabbia from gabbia ";

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
     public ArrayList<Prodotto> selezionaProdotto()
    {
        ArrayList<Prodotto> prolist = new ArrayList<Prodotto>();
        String query = "Select * from prodotto ";

           try{
               Prodotto pro;
               rs = st.executeQuery(query);
               
               
                while(rs.next())
                {
                    pro = new Prodotto(rs.getString("prodotto.Codice_Prodotto"),rs.getDouble("prodotto.prezzo"),rs.getInt("prodotto.giacenza"));
                    prolist.add(pro);
                }
            }catch(Exception ex){

                System.out.println(ex);
            }   
           return prolist; 
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
        ArrayList<Animale> animaliList = new ArrayList<Animale>();
        String query = "Select * from animale LEFT JOIN situato on situato.Cod_Animale = animale.Codice_Animale";
        String[] f_where = new String[7];

            f_where[0] = "animale.Genere";
            f_where[1] = "animale.Specie";
            f_where[2] = "animale.Presente";

       int count_nofilter = 0;
       for(int i=0; i<Filtri.length; i++){
           System.out.println("Dalla QUERY: "+Filtri[i]);
           
           if(!Filtri[i].equals("") && count_nofilter !=0) {
               query = query + " AND "+ f_where[i] + " = '"+ Filtri[i] +"'";
               
               System.out.println("Query al passaggio di "+Filtri[i]+ "con count "+count_nofilter+ ": "+query);
           }
           else if(!Filtri[i].equals("") && count_nofilter == 0)
           {
               System.out.println("Query al passaggio di "+Filtri[i]+ "con count "+count_nofilter+ ": "+query);
               query = query + " where "+f_where[i] + " = '"+ Filtri[i] + "'";
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
           System.out.println(query);
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
    
    
    public void addProdotto(String Codice_Prodotto, double Prezzo, int Giacenza){
      try {
         st.executeUpdate("INSERT INTO prodotto values ('"+Codice_Prodotto+"','"+Prezzo+"','"+Giacenza+"')");
     }   catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }  
    
    }
    public void vendiProdotto(Prodotto p, int q, Utente u){
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd  HH:mm:ss");
        format.format(date);
        
        
        try {
         st.executeUpdate("INSERT INTO vende values ('"+0+"','"+u.getUsername()+"','"+p.getTipo()+"','"+q+"','"+format.format(date)+"')");
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
    
}
