/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettozoo;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Alberto
 */
public class Animale {
    
    private String id;
    private String nome;
    private String specie;
    private String sesso,habitat;
    private Date data_nascita;
    private boolean salute, nostro, presente;
    
    
    /**
     * Crea un istanza della classe Animale vuota
     */
    public Animale()
    {
        this.id = "";
        this.nome = "";
        this.specie = "";
        this.sesso = "";
        this.habitat = "";
        this.data_nascita = new Date(0000,00,00);
        this.salute = true;
        this.nostro = true;
        this.presente = true;
    }
  
    /**
     * Crea un istanza della classe Animale dati i parametri
     */
    public Animale(String ID, String Nome, String Specie, String Sesso, String Habitat, Date Data_Nascita, boolean Salute, boolean Nostro, boolean Presente)
    {
        this.id = ID;
        this.nome = Nome;
        this.specie = Specie;
        this.sesso = Sesso;
        this.habitat = Habitat;
        this.data_nascita = Data_Nascita;
        this.salute = Salute;
        this.nostro = Nostro;
        this.presente = Presente;
    }
    
    /**
     * Modifica l'attributo id
     */
    public void setId(String ID)
    {
        this.id = ID;
    }
    
    /**
     * Modifica l'attributo nome
     */
    public void setNome(String NOME)
    {
        this.nome = NOME;
    }
    
    /**
     * Modifica l'attributo specie
     */
    public void setSpecie(String SPECIE)
    {
        this.specie = SPECIE;
    }
    
    /**
     * Modifica l'attributo sesso
     */
    public void setSesso(String SESSO)
    {
        this.sesso = SESSO;
    }
    
    /**
     * Modifica l'attributo habitat
     */
    public void setHabitat(String HABITAT)
    {
        this.habitat = HABITAT;
    }
    
    /**
     * Modifica l'attributo data_nascita
     */
    public void setDataNascita(Date DATA)
    {
        this.data_nascita = DATA;
    }
    
    /**
     * Modifica l'attributo salute
     */
    public void setSalute(boolean SALUTE)
    {
        this.salute = SALUTE;   
    }
    
    /**
     * Modifica l'attributo presente
     */
    public void setPresente(boolean PRESENTE)
    {
       this.presente = PRESENTE;     
    }
    
    /**
     * Modifica l'attributo nostro
     */
    public void setNostro(boolean NOSTRO)
    {
       this.nostro = NOSTRO;     
    }
    
    /**
     * Restituisce l'attributo id
     */
    public String getId()
    {
        return id;
    }
    
    /**
     * Restituisce l'attributo nome
     */
    public String getNome()
    {
        return nome;
    }
    
    /**
     * Restituisce l'attributo specie
     */
    public String getSpecie()
    {
        return specie;
    }
    
    /**
     * Restituisce l'attributo sesso
     */
    public String getSesso()
    {
        return sesso;
    }
    
    /**
     * Restituisce l'attributo habitat
     */
    public String getHabitat()
    {
        return habitat;
    }
    
    /**
     * Restituisce l'attributo data_nascita
     */
    public Date getDataNascita()
    {
        return data_nascita;
    }
    
    /**
     * Restituisce l'attributo salute
     */
    public boolean getSalute()
    {
        return salute;
    }
    
    /**
     * Restituisce l'attributo presente
     */
    public boolean getPresente()
    {
        return presente;
    }
    
    /**
     * Restituisce l'attributo nostro
     */
    public boolean getNostro()
    {
        return nostro;
    }
}
