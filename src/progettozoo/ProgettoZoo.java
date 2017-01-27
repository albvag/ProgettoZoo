/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettozoo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
  public void DateFormatter(String DateToChange)
  {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateInString = DateToChange;

        try {

            Date date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }
  }
  
  public void ciao()
  {
      System.out.println("ciao");
  }
  

}
