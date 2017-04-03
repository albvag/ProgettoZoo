/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schede;

import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import logins.JDirettore;
import database.DBConnect;
import progettozoo.ProgettoZoo;
import progettozoo.Utente;

import static schede.JAggiungiPersonale_Direttore.check;



/**
 *
 * @author Roberto
 */
public class JModificaPersonale_Direttore extends javax.swing.JFrame {
    public static Utente utente = new Utente();
    DBConnect conn =new DBConnect();
    ProgettoZoo pz =new ProgettoZoo();
    /**
     * Creates new form JModificaPersonale_Direttore
     */
    public JModificaPersonale_Direttore(Utente user_log) {
        initComponents();
         utente.setUsername(user_log.getUsername());
        utente.setNome(user_log.getNome());
        utente.setCognome(user_log.getCognome());
            
        ArrayList<Utente> list = conn.selezionaPersonaleRuolo();
        
        
        for(int i = 0; i < list.size(); i++)
        {       
            this.jselruolo.addItem(list.get(i).getRuolo());
           
        }
        this.jInternalFrame2.setVisible(false);
        pack();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame2 = new javax.swing.JInternalFrame();
        jLabel11 = new javax.swing.JLabel();
        erroreresidenza1 = new javax.swing.JLabel();
        jAggiungiNumeroTelefono1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jAggiungiPassword1 = new javax.swing.JPasswordField();
        jAggiungiIndirizzo1 = new javax.swing.JTextField();
        erroretel1 = new javax.swing.JLabel();
        errorecognome1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        errorepass1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jNomePersonale1 = new javax.swing.JTextField();
        jAggiungiResidenza1 = new javax.swing.JTextField();
        jAggiungiCognome1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jRuolo1 = new javax.swing.JComboBox<>();
        jRipetiPassword1 = new javax.swing.JPasswordField();
        jLabel17 = new javax.swing.JLabel();
        erroredata1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jSalva = new javax.swing.JButton();
        jDatanascita1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        erroreruolo1 = new javax.swing.JLabel();
        errorenome1 = new javax.swing.JLabel();
        erroreindirizzo1 = new javax.swing.JLabel();
        errconfpass1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jselruolo = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jselnome = new javax.swing.JComboBox<>();
        jConferma = new javax.swing.JButton();
        jChiudi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame2.setVisible(true);

        jLabel11.setText("  Conferma Password");

        jLabel12.setText("      Cognome");

        jAggiungiPassword1.setToolTipText("");
        jAggiungiPassword1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel14.setText("            Ruolo");

        jLabel15.setText("            Telefono");

        jLabel16.setText("        Password");

        jRuolo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Direttore", "Custode", "Veterinario", "Cassiere" }));

        jRipetiPassword1.setToolTipText("");

        jLabel17.setText(" Data di Nascita");

        jLabel18.setText("        Nome");

        jSalva.setText("Salva");
        jSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalvaActionPerformed(evt);
            }
        });

        jLabel19.setText("         Città");

        jLabel20.setText("       Indirizzo");

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(errorenome1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jAggiungiResidenza1)
                    .addComponent(jAggiungiIndirizzo1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(jDatanascita1)
                    .addComponent(jAggiungiCognome1)
                    .addComponent(jNomePersonale1)
                    .addComponent(erroreresidenza1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(erroredata1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errorecognome1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(erroreindirizzo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(76, 76, 76)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRipetiPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(erroreruolo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(errconfpass1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRuolo1, 0, 190, Short.MAX_VALUE)
                        .addComponent(jAggiungiPassword1)
                        .addComponent(jAggiungiNumeroTelefono1)
                        .addComponent(erroretel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(errorepass1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSalva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(errorenome1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(erroretel1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jNomePersonale1)
                            .addComponent(jAggiungiNumeroTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errorecognome1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errorepass1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jAggiungiCognome1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jAggiungiPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(erroredata1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errconfpass1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jDatanascita1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRipetiPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(erroreresidenza1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGap(0, 192, Short.MAX_VALUE)
                        .addComponent(erroreruolo1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAggiungiResidenza1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRuolo1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(erroreindirizzo1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAggiungiIndirizzo1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jSalva)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jLabel21.setText("                             SELEZIONA LA PERSONA DA MODIFICARE:");

        jLabel22.setText("SELEZIONA IL RUOLO:");

        jselruolo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jselruoloFocusGained(evt);
            }
        });
        jselruolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jselruoloActionPerformed(evt);
            }
        });

        jLabel23.setText("SELEZIONA IL NOME:");

        jselnome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jselnomeFocusGained(evt);
            }
        });

        jConferma.setText("Conferma");
        jConferma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConfermaActionPerformed(evt);
            }
        });

        jChiudi.setText("Chiudi");
        jChiudi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChiudiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jselruolo, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jselnome, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jConferma, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(204, 204, 204)
                        .addComponent(jChiudi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jselruolo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jselnome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jConferma, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChiudi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jConfermaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConfermaActionPerformed
         String ruolo = this.jselruolo.getSelectedItem().toString();
        String nome = this.jselnome.getSelectedItem().toString();
        Utente ut=new Utente();
        ArrayList<Utente> ruololist = new ArrayList<Utente>();
        ruololist=conn.selezionaPersonaleRuolo();
         String [] nom=nome.split(" ");
        int no=nom.length-1;
        String n=nom[no]; 
        
        ut=conn.selezionaPersonale(ruolo, n);
       
             this.jNomePersonale1.setText(ut.getNome());
             this.jAggiungiCognome1.setText(ut.getCognome());
              String DataNascita = ut.getData().toString();
           String DataNascita_String = pz.NuovoFormatoData(DataNascita, "yyyy-MM-dd", "dd-MM-yyyy");
            this.jDatanascita1.setText(DataNascita_String);
            this.jAggiungiResidenza1.setText(ut.getResidenza());
            this.jAggiungiIndirizzo1.setText(ut.getIndirizzo());
            this.jAggiungiNumeroTelefono1.setText(ut.getTelefono());
            this.jAggiungiPassword1.setText(ut.getPassword());
            this.jRipetiPassword1.setText(ut.getPassword());
            this.jRuolo1.setSelectedItem(ut.getRuolo());
            this.jRuolo1.setSelectedItem(ut.getRuolo());
   
        
        this.jInternalFrame2.setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }//GEN-LAST:event_jConfermaActionPerformed

    private void jselruoloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jselruoloActionPerformed
        String ruolo=this.jselruolo.getSelectedItem().toString();
       ArrayList<Utente> lista= new ArrayList<Utente>();
       
       lista=conn.selezionaPersonaleNome(ruolo);  
      if(!lista.isEmpty())
       {  this.jselnome.removeAllItems();
     for(int j = 0; j < lista.size(); j++)
        {
            
            this.jselnome.addItem(lista.get(j).getNome()+" "+lista.get(j).getCognome());
            
            
        }}
    }//GEN-LAST:event_jselruoloActionPerformed

    private void jChiudiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChiudiActionPerformed
        setVisible(false);
        new JDirettore(utente).setVisible(true);
    }//GEN-LAST:event_jChiudiActionPerformed

    private void jSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalvaActionPerformed
        String nome= this.jNomePersonale1.getText();
        String name=this.jselnome.getSelectedItem().toString();
        String role=this.jselruolo.getSelectedItem().toString();
       String cognome= this.jAggiungiCognome1.getText();
       String data=this.jDatanascita1.getText();
       String residenza =this.jAggiungiResidenza1.getText();
       String indirizzo= this.jAggiungiIndirizzo1.getText();
       String telefono= this.jAggiungiNumeroTelefono1.getText();
       String password= this.jAggiungiPassword1.getText();
       String rippass= this.jRipetiPassword1.getText();
       String ruolo = this.jRuolo1.getSelectedItem().toString();
       
        nome=nome.substring(0,1).toUpperCase()+nome.substring(1, nome.length()).toLowerCase();
          cognome=cognome.substring(0,1).toUpperCase()+cognome.substring(1, cognome.length()).toLowerCase();
          residenza=residenza.substring(0,1).toUpperCase()+residenza.substring(1, residenza.length()).toLowerCase();
          indirizzo=indirizzo.substring(0,1).toUpperCase()+indirizzo.substring(1, indirizzo.length()).toLowerCase();
       
       
       
       
       
        String formnome = "[a-zA-Z ]{1,30}";
          String formcog = "[a-zA-Z ]{1,30}";
           String fordata="(0[1-9]|1[0-9]|2[0-9]|3[01])[-](0[1-9]|1[0-2])[-](19|20)[0-9]{2}";
          String fordata2 ="(0[1-9]|1[0-9]|2[0-9]|3[01])[/](0[1-9]|1[0-2])[/](19|20)[0-9]{2}";
          String formres = "[a-zA-Z ]{1,30}";
          String formind = "[a-zA-Z ]{1,25}+[ 0-9]{1,4}";
          //Numero di telefono formato da soli numeri,minimo 1 e massimo 10
          String formtel = "[0-9]{1,10}";
         
          //password che deve contenere un numero, un carattere minuscolo, uno maiuscolo e un carattere speciale tra !@#$% e deve avere lunghezza min 8 e max 20)
          String formpass= "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%]).{8,20})";
        //questa partecontiene le funzioni per validare il contenuto delle form
           Pattern pattern = Pattern.compile(formnome);
           Pattern pattern1 = Pattern.compile(formcog);
           Pattern pattern2 = Pattern.compile(formres);
           Pattern pattern3 = Pattern.compile(formind);
           Pattern pattern4 = Pattern.compile(formtel);
           
           Pattern pattern6 = Pattern.compile(formpass);
           Pattern pattern7 = Pattern.compile(fordata);
           Pattern pattern8 = Pattern.compile(fordata2);
boolean nom=check(formnome,nome);
boolean cog=check(formcog,cognome);
boolean dat=check(fordata,data);
boolean res=check(formres,residenza);
boolean ind=check(formind,indirizzo);
boolean tel=check(formtel,telefono);
boolean pass=check(formpass,password);
boolean rpass=check(password,rippass);
 boolean dat2=check(fordata2,data); 
   
   Date today =new Date();
 Date d= new Date();
   Date d1= pz.ConvertStringToDate(data,"dd-MM-yyyy");
   Date d2= pz.ConvertStringToDate(data,"dd/MM/yyyy");
   if(dat)
   {d=d1;}
   else if(dat2)
   {d=d2;}
      java.sql.Date sqlDate = new java.sql.Date(d.getTime());
      
      //nel caso i caratteri inseriti non siano quelli richiesti appare un messaggio d'errore
if(nom== false)
 errorenome1.setText("Caratteri non validi");
else
    errorenome1.setText("Caratteri validi");
if(cog==false)
    errorecognome1.setText("Caratteri non validi");
else
    errorecognome1.setText("Caratteri validi");
if(dat==false && dat2==false)
    erroredata1.setText("Caratteri non validi");
else if(d.after(today))
     erroredata1.setText("Non puoi inserire una data futura");
else
    erroredata1.setText("Caratteri validi");
if(res==false)
    erroreresidenza1.setText("Caratteri non validi");
else
    erroreresidenza1.setText("Caratteri validi");
if(ind==false)
    erroreindirizzo1.setText("Caretteri non validi");
else
    erroreindirizzo1.setText("Caretteri validi");
if(tel==false)
    erroretel1.setText("Caratteri non validi");
else
    erroretel1.setText("Caratteri validi");

if(pass==false)
    errorepass1.setText("Caratteri non validi");
else
    errorepass1.setText("Caratteri validi");
if(rpass==false || pass==false )
    errconfpass1.setText("Password non corrispondente");
else
    errconfpass1.setText("Caratteri validi");
if(this.jRuolo1.getSelectedItem().toString().equals(" "))
    erroreruolo1.setText("Non hai inserito il ruolo");
else
    erroreruolo1.setText("Caratteri Validi");
 
 String [] nom1=name.split(" ");
        int no1=nom1.length-1;
        String n1=nom1[no1]; 
 
         if(nom==true && cog==true && (dat==true ||dat2==true) && res==true && ind==true && tel==true  && pass==true && rpass==true && this.jRuolo1.getSelectedItem().toString().equals(" ")==false)
  { 
      if(d.before(today))
      {
    
       int reply = JOptionPane.showConfirmDialog(null, "Stai modificando l'utente "+this.jNomePersonale1.getText()+" "+this.jAggiungiCognome1.getText()+"\n Data di nascita: "+this.jDatanascita1.getText()+"\n Città: "+this.jAggiungiResidenza1.getText()+"\n Indirizzo: "+this.jAggiungiIndirizzo1.getText()+"\n Telefono: "+this.jAggiungiNumeroTelefono1.getText()+"\n Password: "+this.jAggiungiPassword1.getText()+"\n Conferma Password: "+this.jRipetiPassword1.getText()+"\n Ruolo: "+this.jRuolo1.getSelectedItem().toString(), "Confermare?", JOptionPane.YES_NO_OPTION);
      if (reply == JOptionPane.YES_OPTION)
      {
          String Cod_Utente=conn.selezionaPersonale(role,n1 ).getUsername();
          conn.updatePersonale(Cod_Utente, nome, cognome, sqlDate, residenza, indirizzo, telefono, password, ruolo);
          JOptionPane.showMessageDialog(null, "UTENTE MODIFICATO CORRETTAMENTE");
          setVisible(false);
          new JDirettore(utente).setVisible(true);
           if( null!=this.jselruolo.getSelectedItem().toString())
               if(this.jselruolo.getSelectedItem().toString() != this.jRuolo1.getSelectedItem().toString())
               {
                   switch (this.jselruolo.getSelectedItem().toString() ) {
          case "Direttore":
              conn.deleteDirettore(Cod_Utente);
              break;
          case "Veterinario":
              conn.deleteVeterinario(Cod_Utente);
              break;
          case "Custode":
              conn.deleteCustode(Cod_Utente);
              break;
          case "Cassiere":
              conn.deleteCassiere(Cod_Utente);
              break;
          default:
              break;
     
                   }
  if( null!=this.jRuolo1.getSelectedItem().toString())
      switch (this.jRuolo1.getSelectedItem().toString()) {
          case "Direttore":
              conn.insertDirettore(Cod_Utente);
              break;
          case "Veterinario":
              conn.insertVeterinario(Cod_Utente);
              break;
          case "Custode":
              conn.insertCustode(Cod_Utente);
              break;
          case "Cassiere":
              conn.insertCassiere(Cod_Utente);
              break;
          default:
              break;
      }
      }
      }
      }else{JOptionPane.showMessageDialog(null, "NON PUOI INSERIRE UNA DATA FUTURA");}
  
  }else{JOptionPane.showMessageDialog(null, "CARATTERI NON VALIDI");}
    }//GEN-LAST:event_jSalvaActionPerformed

    private void jselruoloFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jselruoloFocusGained
        this.jInternalFrame2.setVisible(false);
        pack();
    }//GEN-LAST:event_jselruoloFocusGained

    private void jselnomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jselnomeFocusGained
        this.jInternalFrame2.setVisible(false);
        pack();
    }//GEN-LAST:event_jselnomeFocusGained

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
            java.util.logging.Logger.getLogger(JModificaPersonale_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JModificaPersonale_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JModificaPersonale_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JModificaPersonale_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JModificaPersonale_Direttore(utente).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errconfpass1;
    private javax.swing.JLabel errorecognome1;
    private javax.swing.JLabel erroredata1;
    private javax.swing.JLabel erroreindirizzo1;
    private javax.swing.JLabel errorenome1;
    private javax.swing.JLabel errorepass1;
    private javax.swing.JLabel erroreresidenza1;
    private javax.swing.JLabel erroreruolo1;
    private javax.swing.JLabel erroretel1;
    private javax.swing.JTextField jAggiungiCognome1;
    private javax.swing.JTextField jAggiungiIndirizzo1;
    private javax.swing.JTextField jAggiungiNumeroTelefono1;
    private javax.swing.JPasswordField jAggiungiPassword1;
    private javax.swing.JTextField jAggiungiResidenza1;
    private javax.swing.JButton jChiudi;
    private javax.swing.JButton jConferma;
    private javax.swing.JTextField jDatanascita1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JTextField jNomePersonale1;
    private javax.swing.JPasswordField jRipetiPassword1;
    private javax.swing.JComboBox<String> jRuolo1;
    private javax.swing.JButton jSalva;
    private javax.swing.JComboBox<String> jselnome;
    private javax.swing.JComboBox<String> jselruolo;
    // End of variables declaration//GEN-END:variables
}
