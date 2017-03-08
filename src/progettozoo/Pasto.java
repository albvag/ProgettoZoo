/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettozoo;

/**
 *
 * @author niereo
 */
import java.util.Date;

/**
 *
 * @author niereo
 */
public class Pasto {
    private int Codice_Pasto;
    private String Cod_Gabbia;
    private Date Data_Pasto;
    private boolean Disponibile;
    private boolean Terminato;
    
    Pasto(){
        
    }
    
    Pasto(int Codice_Pasto,String Cod_Gabbia, Date Data_Pasto, boolean Disponibile, boolean Terminato){
       this.Codice_Pasto = Codice_Pasto;
       this.Cod_Gabbia = Cod_Gabbia;
       this.Data_Pasto = Data_Pasto;
       this.Disponibile = Disponibile;
       this.Terminato = Terminato;
    }
    
    public int getCodice_Pasto(){
        return this.Codice_Pasto;
    }
    
    public String getCodice_Gabbia(){
        return this.Cod_Gabbia;
    }
    
    public Date getData_Pasto(){
        return this.Data_Pasto;
    }
    
    public boolean getDisponibile(){
        return this.Disponibile;
    }
    
     public boolean getTerminato(){
        return this.Terminato;
    }
    
}
