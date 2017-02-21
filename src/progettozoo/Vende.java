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


public  Vende()
{
    this.Cod_Cassiere = "";
    this.Cod_Prodotto = "";
    this.Quantita=0;
    this.Ricavi=0;
    this.DataVendita = new Date(0000,00,00);
}
public void setCod_Cassiere(String Cod_Cassiere)
{
    this.Cod_Cassiere=Cod_Cassiere;
}
public void setCod_Prodotto(String Cod_Prodotto)
{
    this.Cod_Prodotto=Cod_Prodotto;
}
public void setQuantita(int quant)
{
    this.Quantita=quant;
}
public void setRicavi(double ricavi)
{
    this.Ricavi=ricavi;
}
public void setDataVendita(Date data)
{
    this.DataVendita=data;
}
public String getCod_Cassiere()
{
    return Cod_Cassiere;
}
public String getCod_Prodotto()
{
    return Cod_Prodotto;
}
public int getQuantita()
{
    return Quantita;
}
public double getRicavi()
{
    return Ricavi;
}
public Date getDataVendita()
{
    return DataVendita;
}

}