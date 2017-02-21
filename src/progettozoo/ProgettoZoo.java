/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettozoo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import logins.JLogin;
import logins.JVeterinario;

/**
 *
 * @author Alberto
 */
public class ProgettoZoo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        JLogin login = new JLogin();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }  
    
public Date ConvertStringToDate(String Data, String FORMAT)
{
    String startDateString = Data;
                DateFormat df = new SimpleDateFormat(FORMAT); 
                Date startDate = new Date();
                try {
                    startDate = df.parse(startDateString);
                    
                } catch (ParseException e) {
                  //  e.printStackTrace();
                }
                return startDate;
}
        public String NuovoFormatoData(String DataToFormat_AS_STRING, String OLD_FORMAT, String NEW_FORMAT)
        { 
           String DATE_FORMAT = NEW_FORMAT; 
           Date newDate = ConvertStringToDate(DataToFormat_AS_STRING,OLD_FORMAT);
           SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
           return sdf.format(newDate);
        }

        public String StringFormat(String stringToFormat, int intervallo)
        {
            int index = 0;          
              if( stringToFormat.length() > intervallo )
              {        
                    for(int i=intervallo; i<stringToFormat.length(); i=i+intervallo)
                    {
                    index = stringToFormat.indexOf( " ", i);
                    
                        if(index >= i)
                        { 
                        char[] notaChars = stringToFormat.toCharArray();
                        notaChars[index] = '\n';
                        stringToFormat = String.valueOf(notaChars);
                        }
                        
                    }
                    return stringToFormat;
             }
                return stringToFormat;
        }
        
        public boolean isThisDateValid(String dateToValidate, String dateFormat){

		if(dateToValidate == null){
			return false;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		sdf.setLenient(false);

		try {

			//if not valid, it will throw ParseException
			Date date = sdf.parse(dateToValidate);
			

		} catch (ParseException e) {

			return false;
		}

		return true;
	}
        
        public void quicksortDate(ArrayList<Visita> arrayDate, int start, int end, String ordine)
        {
            Date pivotElem, tmp;
            String cod_v, note_visita;
                    String tmp_cod, tmp_nv;
            int endS1 = start;

            if ((end-start) <= 0)
                return;

            pivotElem = arrayDate.get(start).getDV();
            cod_v = arrayDate.get(start).getVeterinario();
            note_visita = arrayDate.get(start).getNote();
 
            switch(ordine){
                case "crescente":{
                for(int i = start+1; i <= end; i++) {
                    if (arrayDate.get(i).getDV().before(pivotElem) ) {
                        endS1++;
                        tmp = arrayDate.get(endS1).getDV();
                        tmp_cod = arrayDate.get(endS1).getVeterinario();
                        tmp_nv = arrayDate.get(endS1).getNote();

                        arrayDate.get(endS1).setDataVisita(arrayDate.get(i).getDV());
                        arrayDate.get(endS1).setVeterinario(arrayDate.get(i).getVeterinario());
                        arrayDate.get(endS1).setNote(arrayDate.get(i).getNote());

                        arrayDate.get(i).setDataVisita(tmp);
                        arrayDate.get(i).setVeterinario(tmp_cod);
                        arrayDate.get(i).setNote(tmp_nv);   

                    }
                }
                arrayDate.get(start).setDataVisita(arrayDate.get(endS1).getDV());
                arrayDate.get(start).setVeterinario(arrayDate.get(endS1).getVeterinario());
                arrayDate.get(start).setNote(arrayDate.get(endS1).getNote());


                arrayDate.get(endS1).setDataVisita(pivotElem);
                arrayDate.get(endS1).setVeterinario(cod_v);
                arrayDate.get(endS1).setNote(note_visita);

                // Sort the two parts of the array
                quicksortDate(arrayDate, start, endS1-1,ordine);
                quicksortDate(arrayDate, endS1+1, end, ordine);
                } break;                
                case "decrescente":{
                for(int i = start+1; i <= end; i++) {
                    if (arrayDate.get(i).getDV().after(pivotElem) ) {
                        endS1++;
                        tmp = arrayDate.get(endS1).getDV();
                        tmp_cod = arrayDate.get(endS1).getVeterinario();
                        tmp_nv = arrayDate.get(endS1).getNote();

                        arrayDate.get(endS1).setDataVisita(arrayDate.get(i).getDV());
                        arrayDate.get(endS1).setVeterinario(arrayDate.get(i).getVeterinario());
                        arrayDate.get(endS1).setNote(arrayDate.get(i).getNote());

                        arrayDate.get(i).setDataVisita(tmp);
                        arrayDate.get(i).setVeterinario(tmp_cod);
                        arrayDate.get(i).setNote(tmp_nv);   

                    }
                }
                arrayDate.get(start).setDataVisita(arrayDate.get(endS1).getDV());
                arrayDate.get(start).setVeterinario(arrayDate.get(endS1).getVeterinario());
                arrayDate.get(start).setNote(arrayDate.get(endS1).getNote());


                arrayDate.get(endS1).setDataVisita(pivotElem);
                arrayDate.get(endS1).setVeterinario(cod_v);
                arrayDate.get(endS1).setNote(note_visita);

                // Sort the two parts of the array
                quicksortDate(arrayDate, start, endS1-1,ordine);
                quicksortDate(arrayDate, endS1+1, end, ordine);
                } break;
            }
        }
     
 public void quicksortTAB_ANIM(ArrayList<Animale> list, int start, int end, String ordine)
 { 
     DBConnect conn = new DBConnect();
     ProgettoZoo pz = new ProgettoZoo();
     
          
     Date[] DateDUV = new Date[list.size()];

         
            for(int i = 0; i < list.size(); i++)
            {
               ArrayList<Visita> visList = conn.visitaList(list.get(i).getId());    
             
               if(!visList.isEmpty())    DateDUV[i] = pz.ConvertStringToDate( visList.get(0).getDUV(list.get(i).getId() ).toString(), "yyyy-MM-dd");
               else {
                   String zero = "0001-01-01";
                   DateDUV[i] = pz.ConvertStringToDate(zero, "yyyy-MM-dd");

               }
            }
  
     Date pivotElem, tmp;
     Date nascita, tmp_nascita;
     
     String cod_an, nome, specie, genere;
     boolean presente, salute ;
     
     String tmp_cod_an, tmp_nome, tmp_specie, tmp_genere;
     boolean tmp_presente, tmp_salute;
     
     int endS1 = start;
     if ((end-start) <= 0) return;
          
      pivotElem = DateDUV[start];
      
      cod_an = list.get(start).getId();
      nome = list.get(start).getNome();
      specie = list.get(start).getSpecie();
      genere = list.get(start).getSesso();
      presente = list.get(start).getPresente();
      salute = list.get(start).getSalute();
      nascita = list.get(start).getDataNascita();
      
            switch(ordine){
                
                case "DUV_CRESCENTE":{
                      
                for(int i = start+1; i <= end; i++) {
                    if (DateDUV[i].before(pivotElem) ) {
                        endS1++;
                        tmp = DateDUV[endS1];
                        tmp_cod_an = list.get(endS1).getId();
                        tmp_nome = list.get(endS1).getNome();
                        tmp_specie = list.get(endS1).getSpecie();
                        tmp_genere = list.get(endS1).getSesso();
                        tmp_presente = list.get(endS1).getPresente();
                        tmp_salute = list.get(endS1).getSalute();
                        tmp_nascita = list.get(endS1).getDataNascita();

                        DateDUV[endS1] = DateDUV[i];
                        list.get(endS1).setId(list.get(i).getId());
                        list.get(endS1).setNome(list.get(i).getNome());
                        list.get(endS1).setSpecie(list.get(i).getSpecie());
                        list.get(endS1).setSesso(list.get(i).getSesso());
                        list.get(endS1).setPresente(list.get(i).getPresente());
                        list.get(endS1).setSalute(list.get(i).getSalute());
                        list.get(endS1).setDataNascita(list.get(i).getDataNascita());
                        
                        DateDUV[i] = tmp;
                        list.get(i).setId(tmp_cod_an);
                        list.get(i).setNome(tmp_nome);
                        list.get(i).setSesso(tmp_genere);
                        list.get(i).setSpecie(tmp_specie);
                        list.get(i).setPresente(tmp_presente);
                        list.get(i).setSalute(tmp_salute);  
                        list.get(i).setDataNascita(tmp_nascita);

                    }
                }
                
                DateDUV[start] = DateDUV[endS1];
                list.get(start).setId(list.get(endS1).getId());
                list.get(start).setNome(list.get(endS1).getNome());
                list.get(start).setSpecie(list.get(endS1).getSpecie());
                list.get(start).setSesso(list.get(endS1).getSesso());
                list.get(start).setPresente(list.get(endS1).getPresente());
                list.get(start).setSalute(list.get(endS1).getSalute());
                list.get(start).setDataNascita(list.get(endS1).getDataNascita());
                
                DateDUV[endS1] = pivotElem;
                list.get(endS1).setId(cod_an);
                list.get(endS1).setNome(nome);
                list.get(endS1).setSpecie(specie);
                list.get(endS1).setSesso(genere);
                list.get(endS1).setPresente(presente);
                list.get(endS1).setSalute(salute);
                list.get(endS1).setDataNascita(nascita);


                // Sort the two parts of the array
                
                quicksortTAB_ANIM(list, start, endS1-1,ordine);
                quicksortTAB_ANIM(list, endS1+1, end, ordine);
                }break;
                case "DUV_DECRESCENTE":{
                    for(int i = start+1; i <= end; i++) {
                    if (DateDUV[i].after(pivotElem) ) {
                        endS1++;
                        tmp = DateDUV[endS1];
                        tmp_cod_an = list.get(endS1).getId();
                        tmp_nome = list.get(endS1).getNome();
                        tmp_specie = list.get(endS1).getSpecie();
                        tmp_genere = list.get(endS1).getSesso();
                        tmp_presente = list.get(endS1).getPresente();
                        tmp_salute = list.get(endS1).getSalute();
                        tmp_nascita = list.get(endS1).getDataNascita();

                        DateDUV[endS1] = DateDUV[i];
                        list.get(endS1).setId(list.get(i).getId());
                        list.get(endS1).setNome(list.get(i).getNome());
                        list.get(endS1).setSpecie(list.get(i).getSpecie());
                        list.get(endS1).setSesso(list.get(i).getSesso());
                        list.get(endS1).setPresente(list.get(i).getPresente());
                        list.get(endS1).setSalute(list.get(i).getSalute());
                        list.get(endS1).setDataNascita(list.get(i).getDataNascita());
                        
                        DateDUV[i] = tmp;
                        list.get(i).setId(tmp_cod_an);
                        list.get(i).setNome(tmp_nome);
                        list.get(i).setSesso(tmp_genere);
                        list.get(i).setSpecie(tmp_specie);
                        list.get(i).setPresente(tmp_presente);
                        list.get(i).setSalute(tmp_salute);  
                        list.get(i).setDataNascita(tmp_nascita);

                    }
                }
                
                DateDUV[start] = DateDUV[endS1];
                list.get(start).setId(list.get(endS1).getId());
                list.get(start).setNome(list.get(endS1).getNome());
                list.get(start).setSpecie(list.get(endS1).getSpecie());
                list.get(start).setSesso(list.get(endS1).getSesso());
                list.get(start).setPresente(list.get(endS1).getPresente());
                list.get(start).setSalute(list.get(endS1).getSalute());
                list.get(start).setDataNascita(list.get(endS1).getDataNascita());
                
                DateDUV[endS1] = pivotElem;
                list.get(endS1).setId(cod_an);
                list.get(endS1).setNome(nome);
                list.get(endS1).setSpecie(specie);
                list.get(endS1).setSesso(genere);
                list.get(endS1).setPresente(presente);
                list.get(endS1).setSalute(salute);
                list.get(endS1).setDataNascita(nascita);


                // Sort the two parts of the array
                
                quicksortTAB_ANIM(list, start, endS1-1,ordine);
                quicksortTAB_ANIM(list, endS1+1, end, ordine); 
                }
                    
            }
     
        
    }   

 }
