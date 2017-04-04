/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettozoo;

import database.DBConnect;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Alberto
 */
public class Visita {
    
    private String veterinario;
    private String animale;
    private Date data_visita;
    private String note;
    
    /**
     * Crea un istanza della classe Visita con i parametri dati
     */
    public Visita(String Vet, String An, Date DV, String NOTE)
    {
        this.veterinario = Vet;
        this.animale = An;
        this.data_visita = DV;
        this.note = NOTE;
    } 
    
    /**
     * Crea un istanza della classe Visita vuota
     */
    public Visita() {
        this.veterinario = "";
        this.animale = "";
        this.data_visita = new Date();
        this.note = "";
    }
    
    /**
     * Modifica l'attributo veterinario
     */
    public String setVeterinario(String Veterinario)
    {
        return this.veterinario = Veterinario;
    }
    
    /**
     * Modifica l'attributo animale
     */
    public String setAnimale(String Animale)
    {
       return this.animale = Animale;
    }
    
    /**
     * Modifica l'attributo data_visita
     */
    public Date setDataVisita(Date DataVisita)
    {
        return this.data_visita = DataVisita;
    }
    
    /**
     * Modifica l'attributo note
     */
    public String setNote(String Note)
    {
        return this.note = Note;
    }
    
    public String getVeterinario()
    {
        return veterinario;
    }
    public String getAnimaleVisitato()
    {
        return animale;
    }

    public String getNote()
    {
        return note;
    }

    public Date getDV()
    {
        return data_visita;
    }

    //ritorna data ultima visita
    public Date getDUV(String animale)
    {
        DBConnect conn = new DBConnect();
        ArrayList<Visita> visList = conn.visitaList(animale);

        Date maxdate = visList.get(0).data_visita;
        for(int j=0; j<visList.size(); j++){
           if( maxdate.before(visList.get(j).data_visita) ) maxdate = visList.get(j).data_visita ;
        }

        return maxdate;
    }
}
