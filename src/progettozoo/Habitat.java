/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettozoo;

/**
 *
 * @author Alberto
 */
public class Habitat {
    
    private String Codice_Gabbia;
    private String Cod_Specie;
    public Habitat()
    {
       this.Codice_Gabbia="";
    }
    public Habitat(String Cod,String specie)
    {
        this.Codice_Gabbia=Cod;
        this.Cod_Specie=specie;
    }
    public String getHabitat()
    {
        return this.Codice_Gabbia;
    }
    public void setHabitat(String Cod)
    {
       this.Codice_Gabbia=Cod;
    }
    public String getSpecie()
    {
        return this.Cod_Specie;
    }
    public void setSpecie(String specie)
    {
        this.Cod_Specie=specie;
    }
}
