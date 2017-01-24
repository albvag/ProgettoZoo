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
    private String sesso;
    private Date data_nascita;
    private boolean salute, nostro, presente;
    


    public Animale(String ID, String Nome, String Specie, String Sesso, Date Data_Nascita, boolean Salute, boolean Nostro, boolean Presente)
    {
        this.id = ID;
        this.nome = Nome;
        this.specie = Specie;
        this.sesso = Sesso;
        this.data_nascita = Data_Nascita;
        this.salute = Salute;
        this.nostro = Nostro;
        this.presente = Presente;
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
