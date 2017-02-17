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
    private Date Data_Inizio_Pulizia;
    private Date Data_Fine_Pulizia;
    private boolean Disponibile;
    private boolean ServeAiuto;
    private String NotePulizia;
    
    
    Pulizia(int Codice_Pulizia,String Cod_Gabbia, Date Data_Inizio_Pulizia, Date Data_Fine_Pulizia, boolean Disponibile, boolean ServeAiuto, String NotePulizia){
       this.Codice_Pulizia = Codice_Pulizia;
       this.Cod_Gabbia = Cod_Gabbia;
       this.Data_Inizio_Pulizia = Data_Inizio_Pulizia;
       this.Data_Fine_Pulizia = Data_Fine_Pulizia;
       this.Disponibile = Disponibile;
       this.ServeAiuto = ServeAiuto;
       this.NotePulizia = NotePulizia;
       
    }
    int getCodice_Pulizia(){
        return this.Codice_Pulizia;
    }
    
    String getCodice_Gabbia(){
        return this.Cod_Gabbia;
    }
    
    Date getData_Inizio_Pulizia(){
        return this.Data_Inizio_Pulizia;
    }
    
    Date getData_Fine_Pulizia(){
        return this.Data_Fine_Pulizia;
    }
    
    boolean getDisponibile(){
        return this.Disponibile;
    }
    
    boolean getServeAiuto(){
        return this.ServeAiuto;
    }
    
    String getNotePulizia(){
        return this.NotePulizia;
    }
       
}
