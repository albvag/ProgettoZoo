/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettozoo;

import java.util.Date;

/**
 *
 * @author niereo
 */
public class Pulizia {
    private int Codice_Pulizia;
    private String Cod_Gabbia;
    private Date Data_Pulizia;
    private boolean Disponibile;
    private boolean ServeAiuto;
    private boolean Terminato;
    
    public Pulizia(){
        
    }
    
    public Pulizia(int Codice_Pulizia,String Cod_Gabbia, Date Data_Pulizia, boolean Disponibile, boolean ServeAiuto,boolean Terminato){
       this.Codice_Pulizia = Codice_Pulizia;
       this.Cod_Gabbia = Cod_Gabbia;
       this.Data_Pulizia = Data_Pulizia;
       this.Disponibile = Disponibile;
       this.ServeAiuto = ServeAiuto;
       this.Terminato = Terminato;
       
    }
    public int getCodice_Pulizia(){
        return this.Codice_Pulizia;
    }
    
    public String getCodice_Gabbia(){
        return this.Cod_Gabbia;
    }
    
    public Date getData_Pulizia(){
        return this.Data_Pulizia;
    }
    
    public boolean getDisponibile(){
        return this.Disponibile;
    }
    
    public boolean getServeAiuto(){
        return this.ServeAiuto;
    }
    
    public boolean getTerminato(){
        return this.Terminato;
    }
    
       
}
