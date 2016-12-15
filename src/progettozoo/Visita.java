/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettozoo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.*;
/**
 *
 * @author Alberto
 */
public class Visita {
    
    private String veterinario;
    private String animale;
    private Date data_visita;
    
    public Visita(String Vet, String An, Date DV)
    {
        this.veterinario = Vet;
        this.animale = An;
        this.data_visita = DV;
    }        
        public String getVeterinario()
        {
            return veterinario;
        }
        public String getAnimaleVisitato()
        {
            return animale;
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
