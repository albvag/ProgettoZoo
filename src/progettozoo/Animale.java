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
    
    public void setId(String ID)
    {
        this.id = ID;
    }
    
    public void setNome(String NOME)
    {
        this.nome = NOME;
    }
    
    public void setSpecie(String SPECIE)
    {
        this.specie = SPECIE;
    }
    
    public void setSesso(String SESSO)
    {
        this.sesso = SESSO;
    }
    
    public void setHabitat(String HABITAT)
    {
        this.habitat = HABITAT;
    }
    
    public void setDataNascita(Date DATA)
    {
        this.data_nascita = DATA;
    }
    
    public void setSalute(boolean SALUTE)
    {
        this.salute = SALUTE;   
    }
    
     public void setPresente(boolean PRESENTE)
    {
       this.presente = PRESENTE;     
    }
    
    public void setNostro(boolean NOSTRO)
    {
       this.nostro = NOSTRO;     
    }
    
    public String getId()
    {
        return id;
    }
    
    public String getNome()
    {
        return nome;
    }
    
    public String getSpecie()
    {
        return specie;
    }
    
    public String getSesso()
    {
        return sesso;
    }
    
    public String getHabitat()
    {
        return habitat;
    }
    
    public Date getDataNascita()
    {
        return data_nascita;
    }
    
    public boolean getSalute()
    {
        return salute;
    }
    
    public boolean getPresente()
    {
        return presente;
    }
    
    public boolean getNostro()
    {
        return nostro;
    }
}
