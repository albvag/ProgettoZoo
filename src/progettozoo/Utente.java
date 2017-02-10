/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettozoo;

import java.util.Date;

/**
 *
 * @author Alberto
 */
public class Utente {
    
    private String Username, Nome, Cognome, Residenza, Indirizzo, Telefono, Ruolo, Password;
    private Date DataNascita;

    public Utente(){
        this.Username = "";
        this.Password = "";
        this.Nome = "";
        this.Cognome = "";
        this.DataNascita=new Date();
        this.Ruolo = "";
        this.Residenza = "";
        this.Indirizzo = "";
        this.Telefono = "";
    }
   
    
    public Utente(String Username, String Password, String Nome, String Cognome,Date DataNascita, String Ruolo, String Residenza, String Indirizzo, String Telefono){
        this.Username = Username;
        this.Password = Password;
        this.Nome = Nome;
        this.Cognome = Cognome;
        this.DataNascita=DataNascita;
        this.Ruolo = Ruolo;
        this.Residenza = Residenza;
        this.Indirizzo = Indirizzo;
        this.Telefono = Telefono;
    }
    
    
    //SET
    public String setUsername(String Username)
    {
       return this.Username = Username;
    }
    
    public String setPassword(String Password)
    {
        return this.Password = Password;
    }
    
    public String setNome(String Nome)
    {
        return this.Nome = Nome;
    }
    
    public String setCognome(String Cognome)
    {
        return this.Cognome = Cognome;
    }
    
    public String setRuolo(String Ruolo)
    {
        return this.Ruolo = Ruolo;
    }
    
    public String setResidenza(String Residenza)
    {
      return this.Residenza = Residenza;
    }
    
    public String setIndirizzo(String Indirizzo)
    {
        return this.Indirizzo = Indirizzo;
    }
    
    public String setTelefono(String Telefono)
    {
        return this.Telefono = Telefono;
    } 
    public Date setData(Date data)
    {
        return this.DataNascita=data;
    }
    
    //GET
    public String getUsername()
    {
        return this.Username;
    }    
   
    public String getPassword()
    {
        return this.Password;
    }
    
    public String getNome()
    {
        return this.Nome;
    }
    
    public String getCognome()
    {
        return this.Cognome;
    }
    
    public String getRuolo()
    {
        return this.Ruolo;
    }
    
    public String getResidenza()
    {
      return this.Residenza;
    }
    
    public String getIndirizzo()
    {
        return this.Indirizzo;
    }
    
    public String getTelefono()
    {
        return this.Telefono;
    }
    public Date getData()
    {
        return this.DataNascita;
    }
}
