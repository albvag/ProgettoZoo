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
    
    /**
     * Crea un istanza della classe Utente vuota
     */
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
   
    /**
     * Crea un istanza della classe Utente con i parametri dati
     */
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
    
    
    /**
     * Modifica l'attributo Username
     */
    public String setUsername(String Username)
    {
       return this.Username = Username;
    }
    
    /**
     * Modifica l'attributo Password
     */
    public String setPassword(String Password)
    {
        return this.Password = Password;
    }
    
    /**
     * Modifica l'attributo Nome
     */
    public String setNome(String Nome)
    {
        return this.Nome = Nome;
    }
    
    /**
     * Modifica l'attributo Cognome
     */
    public String setCognome(String Cognome)
    {
        return this.Cognome = Cognome;
    }
    
    /**
     * Modifica l'attributo Ruolo
     */
    public String setRuolo(String Ruolo)
    {
        return this.Ruolo = Ruolo;
    }
    
    /**
     * Modifica l'attributo Residenza
     */
    public String setResidenza(String Residenza)
    {
      return this.Residenza = Residenza;
    }
    
    /**
     * Modifica l'attributo Indirizzo
     */
    public String setIndirizzo(String Indirizzo)
    {
        return this.Indirizzo = Indirizzo;
    }
    
    /**
     * Modifica l'attributo Telefono
     */
    public String setTelefono(String Telefono)
    {
        return this.Telefono = Telefono;
    }
    
    /**
     * Modifica l'attributo DataNascita
     */
    public Date setData(Date data)
    {
        return this.DataNascita=data;
    }
    
    /**
     * Restituisce l'attributo Username
     */
    public String getUsername()
    {
        return this.Username;
    }    
    
    /**
     * Restituisce l'attributo Password
     */
    public String getPassword()
    {
        return this.Password;
    }
    
    /**
     * Restituisce l'attributo Nome
     */
    public String getNome()
    {
        return this.Nome;
    }
    
    /**
     * Restituisce l'attributo Cognome
     */
    public String getCognome()
    {
        return this.Cognome;
    }
    
    /**
     * Restituisce l'attributo Ruolo
     */
    public String getRuolo()
    {
        return this.Ruolo;
    }
    
    /**
     * Restituisce l'attributo Residenza
     */
    public String getResidenza()
    {
      return this.Residenza;
    }
    
    /**
     * Restituisce l'attributo indirizzo
     */
    public String getIndirizzo()
    {
        return this.Indirizzo;
    }
    
    /**
     * Restituisce l'attributo Telefono
     */
    public String getTelefono()
    {
        return this.Telefono;
    }
    
    /**
     * Restituisce l'attributo DataNascita
     */
    public Date getData()
    {
        return this.DataNascita;
    }
}
