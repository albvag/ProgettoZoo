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
public class Prodotto {
    private String tipo;
    private final double prezzo;
    private int giacenza;
   
  
    public Prodotto(String tipo,double prezzo, int giacenza ){
        this.prezzo = prezzo;
        this.tipo = tipo;
        this.giacenza = giacenza;
    }
   
    public double getPrezzo(){
    return this.prezzo;
    }
    
    public String getTipo(){
    return this.tipo;
    }
    
    public int getGiacenza(){
    return this.giacenza;
    }
          
    }
