/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schede;

import java.awt.*;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import progettozoo.DBConnect;
import progettozoo.ProgettoZoo;
/**
 *
 * @author Roberto
 */
public class JAggiungiPersonale_Direttore extends javax.swing.JFrame {

    /**
     * Creates new form JAggiungiPersonale_Direttore
     */
    public JAggiungiPersonale_Direttore() {
        initComponents();
        
    }
 

 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jNomePersonale = new javax.swing.JTextField();
        jAggiungiCognome = new javax.swing.JTextField();
        jAggiungiResidenza = new javax.swing.JTextField();
        jAggiungiIndirizzo = new javax.swing.JTextField();
        jAggiungiNumeroTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jAggiungiUser = new javax.swing.JTextField();
        jButtonSave = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();
        jAggiungiPassword = new javax.swing.JPasswordField();
        jRipetiPassword = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jRuolo = new javax.swing.JComboBox<>();
        errorenome = new javax.swing.JLabel();
        errorecognome = new javax.swing.JLabel();
        erroreresidenza = new javax.swing.JLabel();
        erroreindirizzo = new javax.swing.JLabel();
        erroretel = new javax.swing.JLabel();
        erroreuser = new javax.swing.JLabel();
        errorepass = new javax.swing.JLabel();
        errconfpass = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jDatanascita = new javax.swing.JTextField();
        erroredata = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setText("        Nome");

        jLabel1.setText("      Cognome");

        jLabel2.setText("         Città");

        jLabel3.setText("       Indirizzo");

        jLabel4.setText("            Telefono");

        jNomePersonale.setForeground(new java.awt.Color(153, 153, 153));
        jNomePersonale.setText("Es.Mario");
        jNomePersonale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jNomePersonaleMouseClicked(evt);
            }
        });
        jNomePersonale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNomePersonaleActionPerformed(evt);
            }
        });

        jAggiungiCognome.setForeground(new java.awt.Color(153, 153, 153));
        jAggiungiCognome.setText("Es.Rossi");
        jAggiungiCognome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAggiungiCognomeMouseClicked(evt);
            }
        });
        jAggiungiCognome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAggiungiCognomeActionPerformed(evt);
            }
        });

        jAggiungiResidenza.setForeground(new java.awt.Color(153, 153, 153));
        jAggiungiResidenza.setText("Es.Roma");
        jAggiungiResidenza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAggiungiResidenzaMouseClicked(evt);
            }
        });
        jAggiungiResidenza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAggiungiResidenzaActionPerformed(evt);
            }
        });

        jAggiungiIndirizzo.setForeground(new java.awt.Color(153, 153, 153));
        jAggiungiIndirizzo.setText("Es.via indirizzo 1");
        jAggiungiIndirizzo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAggiungiIndirizzoMouseClicked(evt);
            }
        });
        jAggiungiIndirizzo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAggiungiIndirizzoActionPerformed(evt);
            }
        });

        jAggiungiNumeroTelefono.setForeground(new java.awt.Color(153, 153, 153));
        jAggiungiNumeroTelefono.setText("Es.0147852369");
        jAggiungiNumeroTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAggiungiNumeroTelefonoMouseClicked(evt);
            }
        });
        jAggiungiNumeroTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAggiungiNumeroTelefonoActionPerformed(evt);
            }
        });

        jLabel5.setText("        Username");

        jLabel7.setText("        Password");

        jLabel8.setText("  Conferma Password");

        jAggiungiUser.setForeground(new java.awt.Color(153, 153, 153));
        jAggiungiUser.setText("Campo formato da soli caratteri alfanumerici più  _ e – di lungezza min 3 e max 15");
        jAggiungiUser.setToolTipText("Username formato da soli caratteri alfanumerici più  _ e – di lungezza min 3 e max 15");
        jAggiungiUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAggiungiUserMouseClicked(evt);
            }
        });
        jAggiungiUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAggiungiUserActionPerformed(evt);
            }
        });

        jButtonSave.setText("Salva");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonClose.setText("Chiudi");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jAggiungiPassword.setToolTipText("Password che deve contenere un numero, un carattere minuscolo, uno maiuscolo e un carattere speciale tra !@#$% e deve avere lunghezza min 8 e max 20");
        jAggiungiPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jAggiungiPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAggiungiPasswordActionPerformed(evt);
            }
        });

        jRipetiPassword.setToolTipText("Password che deve contenere un numero, un carattere minuscolo, uno maiuscolo e un carattere speciale tra !@#$% e deve avere lunghezza min 8 e max 20");
        jRipetiPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRipetiPasswordActionPerformed(evt);
            }
        });

        jLabel9.setText("            Ruolo");

        jRuolo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Direttore", "Custode", "Veterinario", "Cassiere" }));
        jRuolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRuoloActionPerformed(evt);
            }
        });

        jLabel10.setText(" Data di Nascita");

        jDatanascita.setForeground(new java.awt.Color(153, 153, 153));
        jDatanascita.setText("Es.22/01/1995");
        jDatanascita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDatanascitaMouseClicked(evt);
            }
        });
        jDatanascita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDatanascitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(errorenome, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jAggiungiCognome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errorecognome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(erroreindirizzo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jAggiungiResidenza, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jAggiungiIndirizzo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jNomePersonale, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDatanascita, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(erroreresidenza, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(erroredata, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(108, 108, 108)
                                .addComponent(jButtonClose)
                                .addGap(129, 129, 129))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(38, 38, 38))
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(erroreuser, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jAggiungiUser, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jAggiungiNumeroTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(erroretel, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(errconfpass, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jRipetiPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jRuolo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jAggiungiPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(errorepass, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(26, 26, 26))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(errorenome, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(erroretel, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jAggiungiNumeroTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jNomePersonale))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(errorecognome, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jAggiungiCognome, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jAggiungiUser, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errorepass, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(erroredata, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jAggiungiPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDatanascita, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(errconfpass, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRipetiPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jAggiungiResidenza, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addComponent(erroreindirizzo, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRuolo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jAggiungiIndirizzo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonSave)
                                    .addComponent(jButtonClose))
                                .addGap(34, 34, 34))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(erroreresidenza, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(erroreuser, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    public static boolean check(String regex, String input){
  if (Pattern.matches(regex, input))
    return true;
  else
    return false;
}
  
    private void jAggiungiIndirizzoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAggiungiIndirizzoActionPerformed
         String indirizzo= this.jAggiungiIndirizzo.getText();
      // TODO add your handling code here:
    }//GEN-LAST:event_jAggiungiIndirizzoActionPerformed

    private void jNomePersonaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNomePersonaleActionPerformed
       String nome= this.jNomePersonale.getText();
       
       
// TODO add your handling code here:
    }//GEN-LAST:event_jNomePersonaleActionPerformed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
      setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jAggiungiCognomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAggiungiCognomeActionPerformed
       String cognome= this.jAggiungiCognome.getText();        // TODO add your handling code here:
    }//GEN-LAST:event_jAggiungiCognomeActionPerformed
   
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
       String nome= this.jNomePersonale.getText();
       String cognome= this.jAggiungiCognome.getText();
       String data=this.jDatanascita.getText();
       String residenza =this.jAggiungiResidenza.getText();
       String indirizzo= this.jAggiungiIndirizzo.getText();
       String telefono= this.jAggiungiNumeroTelefono.getText();
       String username= this.jAggiungiUser.getText();
       String password= this.jAggiungiPassword.getText();
       String rippass= this.jRipetiPassword.getText();
       String ruolo = this.jRuolo.getSelectedItem().toString();
       
        
        
      
          String formnome = "[a-zA-Z]{1,}";
          String formcog = "[a-zA-Z]{1,}";
          String fordata="(0[1-9]|1[0-9]|2[0-9]|3[01])[- /.](0[1-9]|1{2})[-/.](19|20)[0-9]{2}";
          String formres = "[a-zA-Z]{1,}";
          String formind = "[a-zA-Z ]{1,}+[ 0-9]{1,}";
          //Numero di telefono formato da soli numeri,minimo 1 e massimo 10
          String formtel = "[0-9]{1,10}";
          //nome utente formato da soli caratteri alfanumerici più  _ e – di lungezza min 3 e max 15
          String formuser ="^[a-z0-9_-]{3,15}$";
          //password che deve contenere un numero, un carattere minuscolo, uno maiuscolo e un carattere speciale tra !@#$% e deve avere lunghezza min 8 e max 20)
          String formpass= "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%]).{8,20})";
        //questa partecontiene le funzioni per validare il contenuto delle form
           Pattern pattern = Pattern.compile(formnome);
           Pattern pattern1 = Pattern.compile(formcog);
           Pattern pattern2 = Pattern.compile(formres);
           Pattern pattern3 = Pattern.compile(formind);
           Pattern pattern4 = Pattern.compile(formtel);
           Pattern pattern5 = Pattern.compile(formuser);
           Pattern pattern6 = Pattern.compile(formpass);
           Pattern pattern7 = Pattern.compile(fordata);
boolean nom=check(formnome,nome);
boolean cog=check(formcog,cognome);
boolean dat=check(fordata,data);
boolean res=check(formres,residenza);
boolean ind=check(formind,indirizzo);
boolean tel=check(formtel,telefono);
boolean user=check(formuser,username);
boolean pass=check(formpass,password);
boolean rpass=check(password,rippass);
//nel caso i caratteri inseriti non siano quelli richiesti appare un messaggio d'errore
if(nom== false)
 errorenome.setText("Caratteri non validi");
else
    errorenome.setText("Caratteri validi");
if(cog==false)
    errorecognome.setText("Caratteri non validi");
else
    errorecognome.setText("Caratteri validi");
if(dat==false)
    erroredata.setText("Caratteri non validi");
else
    erroredata.setText("Caratteri validi");
if(res==false)
    erroreresidenza.setText("Caratteri non validi");
else
    erroreresidenza.setText("Caratteri validi");
if(ind==false)
    erroreindirizzo.setText("Caretteri non validi");
else
    erroreindirizzo.setText("Caretteri validi");
if(tel==false)
    erroretel.setText("Caratteri non validi");
else
    erroretel.setText("Caratteri validi");
if(user==false)
    erroreuser.setText("Caratteri non validi");
else
    erroreuser.setText("Caratteri validi");
if(pass==false)
    errorepass.setText("Caratteri non validi");
else
    errorepass.setText("Caratteri validi");
if(rpass==false)
    errconfpass.setText("Caratteri non validi");
else
    errconfpass.setText("Caratteri validi");
 DBConnect conn =new DBConnect();
   String Cod_pers=(this.jAggiungiUser.getText());
   int stato=1;
   ProgettoZoo pz= new ProgettoZoo();
  
  
  if(nom==true && cog==true && dat==true && res==true && ind==true && tel==true && user==true && pass==true && rpass==true )
  {   Date d= pz.ConvertStringToDate(data, "dd/MM/yyyy");
      java.sql.Date sqlDate = new java.sql.Date(d.getTime());
      conn.insertImpiegato(username,nome, cognome,sqlDate, residenza, indirizzo, telefono);
      conn.inserisciUtente(username, password, stato, ruolo);
 
  JOptionPane.showMessageDialog(null, "UTENTE INSERITO CORRETTAMENTE");
    setVisible(false);
  if(this.jRuolo.getSelectedItem().toString()=="Direttore")
      conn.insertDirettore(username);
  else if(this.jRuolo.getSelectedItem().toString()=="Veterinario")
      conn.insertVeterinario(username);
  else if(this.jRuolo.getSelectedItem().toString()=="Custode")
      conn.insertCustode(username);
  else if(this.jRuolo.getSelectedItem().toString()=="Cassiere")
      conn.insertCassiere(username);
  }else{JOptionPane.showMessageDialog(null, "ALCUNI CAMPI NON SONO INSERITI CORRETTAMENTE");}
       
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jAggiungiResidenzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAggiungiResidenzaActionPerformed
      String residenza =this.jAggiungiResidenza.getText();
      
// TODO add your handling code here:
    }//GEN-LAST:event_jAggiungiResidenzaActionPerformed

    private void jAggiungiNumeroTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAggiungiNumeroTelefonoActionPerformed
       String telefono=this.jAggiungiNumeroTelefono.getText();  
      // TODO add your handling code here:
    }//GEN-LAST:event_jAggiungiNumeroTelefonoActionPerformed

    private void jAggiungiUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAggiungiUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jAggiungiUserActionPerformed

    private void jAggiungiPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAggiungiPasswordActionPerformed
        String password=this.jAggiungiPassword.getText(); // TODO add your handling code here:
    }//GEN-LAST:event_jAggiungiPasswordActionPerformed

    private void jRipetiPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRipetiPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRipetiPasswordActionPerformed

    private void jRuoloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRuoloActionPerformed
        
      // TODO add your handling code here:
    }//GEN-LAST:event_jRuoloActionPerformed

    private void jNomePersonaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNomePersonaleMouseClicked
         if(jNomePersonale.getText().equals("Es.Mario"))
         { jNomePersonale.setText("");
         jNomePersonale.setForeground(Color.black);
         }
        else
            jNomePersonale.getText(); // TODO add your handling code here:
    }//GEN-LAST:event_jNomePersonaleMouseClicked

    private void jAggiungiCognomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAggiungiCognomeMouseClicked
        if(jAggiungiCognome.getText().equals("Es.Rossi"))
        {jAggiungiCognome.setText("");
        jAggiungiCognome.setForeground(Color.black);
        }
        else
            jAggiungiCognome.getText();// TODO add your handling code here:
    }//GEN-LAST:event_jAggiungiCognomeMouseClicked

    private void jAggiungiResidenzaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAggiungiResidenzaMouseClicked
           if(jAggiungiResidenza.getText().equals("Es.Roma"))
           {jAggiungiResidenza.setText("");
            jAggiungiResidenza.setForeground(Color.black);
           }
        else
            jAggiungiResidenza.getText();      // TODO add your handling code here:
    }//GEN-LAST:event_jAggiungiResidenzaMouseClicked

    private void jAggiungiIndirizzoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAggiungiIndirizzoMouseClicked
          if(jAggiungiIndirizzo.getText().equals("Es.via indirizzo 1"))
          {jAggiungiIndirizzo.setText("");
          jAggiungiIndirizzo.setForeground(Color.black);
          }
        else
            jAggiungiIndirizzo.getText();// TODO add your handling code here:
    }//GEN-LAST:event_jAggiungiIndirizzoMouseClicked

    private void jAggiungiNumeroTelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAggiungiNumeroTelefonoMouseClicked
         if(jAggiungiNumeroTelefono.getText().equals("Es.0147852369"))
         {jAggiungiNumeroTelefono.setText("");
          jAggiungiNumeroTelefono.setForeground(Color.black);
         }
        else
            jAggiungiNumeroTelefono.getText();      // TODO add your handling code here:
    }//GEN-LAST:event_jAggiungiNumeroTelefonoMouseClicked

    private void jAggiungiUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAggiungiUserMouseClicked
       if(jAggiungiUser.getText().equals("Campo formato da soli caratteri alfanumerici più  _ e – di lungezza min 3 e max 15"))
       {jAggiungiUser.setText("");
        jAggiungiUser.setForeground(Color.black);
       }
        else
            jAggiungiUser.getText(); // TODO add your handling code here:
    }//GEN-LAST:event_jAggiungiUserMouseClicked

    private void jDatanascitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDatanascitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jDatanascitaActionPerformed

    private void jDatanascitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDatanascitaMouseClicked
         if(jDatanascita.getText().equals("Es.22/01/1995"))
       {jDatanascita.setText("");
        jDatanascita.setForeground(Color.black);
       }
         else
            jDatanascita.getText();
    }//GEN-LAST:event_jDatanascitaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JAggiungiPersonale_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JAggiungiPersonale_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JAggiungiPersonale_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JAggiungiPersonale_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JAggiungiPersonale_Direttore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errconfpass;
    private javax.swing.JLabel errorecognome;
    private javax.swing.JLabel erroredata;
    private javax.swing.JLabel erroreindirizzo;
    private javax.swing.JLabel errorenome;
    private javax.swing.JLabel errorepass;
    private javax.swing.JLabel erroreresidenza;
    private javax.swing.JLabel erroretel;
    private javax.swing.JLabel erroreuser;
    private javax.swing.JTextField jAggiungiCognome;
    private javax.swing.JTextField jAggiungiIndirizzo;
    private javax.swing.JTextField jAggiungiNumeroTelefono;
    private javax.swing.JPasswordField jAggiungiPassword;
    private javax.swing.JTextField jAggiungiResidenza;
    private javax.swing.JTextField jAggiungiUser;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JTextField jDatanascita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jNomePersonale;
    private javax.swing.JPasswordField jRipetiPassword;
    private javax.swing.JComboBox<String> jRuolo;
    // End of variables declaration//GEN-END:variables
}
