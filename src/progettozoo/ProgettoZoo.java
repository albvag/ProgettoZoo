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
			System.out.println(date);

		} catch (ParseException e) {

			return false;
		}

		return true;
	}
        
        public void quicksortDate(ArrayList<Visita> arrayDate, int start, int end)
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
                    
                    System.out.println("dv: "+ arrayDate.get(i).getDV() + " cod: "+arrayDate.get(i).getVeterinario()+" note: "+  arrayDate.get(i).getNote());
                    System.out.println("tmp: "+ tmp + " tmp_cod: "+tmp_cod+" tmp_nve: "+  tmp_nv +"\n\n");
                    
                    
                }
            }
            arrayDate.get(start).setDataVisita(arrayDate.get(endS1).getDV());
            arrayDate.get(start).setVeterinario(arrayDate.get(endS1).getVeterinario());
            arrayDate.get(start).setNote(arrayDate.get(endS1).getNote());
            
            
            arrayDate.get(endS1).setDataVisita(pivotElem);
            arrayDate.get(endS1).setVeterinario(cod_v);
            arrayDate.get(endS1).setNote(note_visita);

            // Sort the two parts of the array
            quicksortDate(arrayDate, start, endS1-1);
            quicksortDate(arrayDate, endS1+1, end);
        }


 }
