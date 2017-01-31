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
    public Habitat()
    {
       this.Codice_Gabbia="";
    }
    public Habitat(String Cod)
    {
        this.Codice_Gabbia=Cod;
    }
    public String getHabitat()
    {
        return this.Codice_Gabbia;
    }
    public String setHabitat(String Cod)
    {
        return this.Codice_Gabbia=Cod;
    }
}
