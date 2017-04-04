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
    private double prezzo;
    private int giacenza;
    
   
    /**
     * Crea un istanza della classe Prodotto con i parametri dati
     */
    public Prodotto(String tipo,double prezzo, int giacenza ){
        this.prezzo = prezzo;
        this.tipo = tipo;
        this.giacenza = giacenza;
    }
    
    /**
     * Crea un istanza della classe Prodotto vuota
     */
    public Prodotto(){
        
    }
        
    /**
     * Restituisce l'attributo prezzo
     */ 
    public double getPrezzo(){
    return this.prezzo;
    }
    
    /**
     * Restituisce l'attributo tipo
     */
    public String getTipo(){
    return this.tipo;
    }
    
    /**
     * Restituisce l'attributo giacenza
     */
    public int getGiacenza(){
    return this.giacenza;
    }
          
    }
