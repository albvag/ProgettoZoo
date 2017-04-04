/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettozoo;

import java.util.Date;

/**
 *
 * @author Roberto
 */
public class Vende {
    private String Cod_Cassiere;
    private String Cod_Prodotto;
    private int Quantita;
    private double Ricavi;
    private Date DataVendita;

    /**
     * Crea un istanza della classe Vende vuota
     */
    public  Vende()
    {
        this.Cod_Cassiere = "";
        this.Cod_Prodotto = "";
        this.Quantita=0;
        this.Ricavi=0;
        this.DataVendita = new Date(0000,00,00);
    }
    
    /**
     * Modifica l'attributo Cod_Casiere
     */
    public void setCod_Cassiere(String Cod_Cassiere)
    {
        this.Cod_Cassiere=Cod_Cassiere;
    }
    
    /**
     * Modifica l'attributo Cod_Prodotto
     */
    public void setCod_Prodotto(String Cod_Prodotto)
    {
        this.Cod_Prodotto=Cod_Prodotto;
    }
    
    /**
     * Modifica l'attributo Quantità
     */
    public void setQuantita(int quant)
    {
        this.Quantita=quant;
    }
    
    /**
     * Modifica l'attributo Ricavi
     */
    public void setRicavi(double ricavi)
    {
        this.Ricavi=ricavi;
    }
    
    /**
     * Modifica l'attributo DataVendita
     */
    public void setDataVendita(Date data)
    {
        this.DataVendita=data;
    }
    
    /**
     * Restituisce l'attributo Cod_Cassiere
     */
    public String getCod_Cassiere()
    {
        return Cod_Cassiere;
    }
    
    /**
     * Restituisce l'attributo Cod_Prodotto
     */
    public String getCod_Prodotto()
    {
        return Cod_Prodotto;
    }
    
    /**
     * Restituisce l'attributo Quantità
     */
    public int getQuantita()
    {
        return Quantita;
    }
    
    /**
     * Restituisce l'attributo Ricavi
     */
    public double getRicavi()
    {
        return Ricavi;
    }
    
    /**
     * Restituisce l'attributo DataVendita
     */
    public Date getDataVendita()
    {
        return DataVendita;
    }

    }