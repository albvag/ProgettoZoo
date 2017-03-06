/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schede;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import logins.JLogin;
import progettozoo.DBConnect;
import logins.JDirettore;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import progettozoo.Animale;
import progettozoo.Habitat;
import progettozoo.ProgettoZoo;
/**
 *
 * @author Roberto
 */
public class JAggiungiAnimale_Direttore extends javax.swing.JFrame {

    /**
     * Creates new form JAggiungiAnimale_Direttore
     */
    public JAggiungiAnimale_Direttore() {
        initComponents();
          DBConnect conn =new DBConnect();
       
             
        ArrayList<Animale> lista = conn.selezionaSpecie();
        
        for(int i = 0; i < lista.size(); i++)
        {
            
            this.jselspecie.addItem(lista.get(i).getSpecie());
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jNomeAnimale = new javax.swing.JLabel();
        jSpecieAnimale = new javax.swing.JLabel();
        jGenereAnimale = new javax.swing.JLabel();
        jDataAnimale = new javax.swing.JLabel();
        jAggiunginomeanimale = new javax.swing.JTextField();
        jDatadinascita = new javax.swing.JTextField();

        jButtonSave = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();
        jGenere = new javax.swing.JComboBox<>();
        errorenome = new javax.swing.JLabel();
        errorespecie = new javax.swing.JLabel();
        erroredata = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jsalute = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jnostro = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jselspecie = new javax.swing.JComboBox<>();
        errorehabitat = new javax.swing.JLabel();
        jselhabitat = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jNomeAnimale.setText("         Nome");

        jSpecieAnimale.setText("        Specie");

        jGenereAnimale.setText("        Genere");

        jDataAnimale.setText("  Data di nascita");

        jAggiunginomeanimale.setForeground(new java.awt.Color(153, 153, 153));
        jAggiunginomeanimale.setText("Nome formato da sole lettere");
        jAggiunginomeanimale.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jAggiunginomeanimaleFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jAggiunginomeanimaleFocusLost(evt);
            }
        });
        jAggiunginomeanimale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAggiunginomeanimaleActionPerformed(evt);
            }
        });

        jDatadinascita.setForeground(new java.awt.Color(153, 153, 153));
        jDatadinascita.setText("dd/mm/aaaa");
        jDatadinascita.setToolTipText("");
        jDatadinascita.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jDatadinascitaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jDatadinascitaFocusLost(evt);
            }
        });
        jDatadinascita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDatadinascitaActionPerformed(evt);
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

        jGenere.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));
        jGenere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGenereActionPerformed(evt);
            }
        });

        jLabel1.setText("       Salute");

        jsalute.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SANO", "MALATO", " " }));
        jsalute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsaluteActionPerformed(evt);
            }
        });

        jLabel2.setText("      Nostro");

        jnostro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        jnostro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jnostroActionPerformed(evt);
            }
        });

        jLabel4.setText("      Habitat");

        jselspecie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jselspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jselspecieActionPerformed(evt);
            }
        });

        jselhabitat.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSpecieAnimale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jGenereAnimale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDataAnimale, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                    .addComponent(jNomeAnimale, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(erroredata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(errorespecie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(errorenome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jAggiunginomeanimale, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                        .addComponent(jDatadinascita, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                        .addComponent(jGenere, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jselspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jnostro, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jsalute, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jButtonSave)
                        .addGap(46, 46, 46)
                        .addComponent(jButtonClose))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(errorehabitat, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(jselhabitat))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errorenome, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorehabitat, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jselhabitat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jNomeAnimale, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jAggiunginomeanimale, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorespecie, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jSpecieAnimale, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jselspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jsalute, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGenereAnimale, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGenere, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jnostro, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(erroredata, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jDataAnimale, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDatadinascita, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonClose))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 public static boolean check(String regex, String input){
  if (Pattern.matches(regex, input))
    return true;
  else
    return false;
}

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        setVisible(false); // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jDatadinascitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDatadinascitaActionPerformed
    // TODO add your handling code here:
    }//GEN-LAST:event_jDatadinascitaActionPerformed

    private void jAggiunginomeanimaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAggiunginomeanimaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jAggiunginomeanimaleActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        String nome= this.jAggiunginomeanimale.getText();
        String specie=this.jselspecie.getSelectedItem().toString();
        String genere = this.jGenere.getSelectedItem().toString();
        //data in formato dd/mm/aaaa
        String data = this.jDatadinascita.getText();
        
      
         String formnome = "[a-zA-Z ]{1,}";
         //inserire la data in formato dd/mm/aaaa (giorno/mese/anno)
         String fordata ="(0[1-9]|1[0-9]|2[0-9]|3[01])[ /](0[1-9]|1[0-2])[/](19|20)[0-9]{2}";
          Pattern pattern = Pattern.compile(formnome);
          Pattern pattern2 = Pattern.compile(fordata);
        boolean nom=check(formnome,nome); 
        boolean dat=check(fordata,data);
        
         ProgettoZoo pz= new ProgettoZoo();
   Date today=new Date();
   Date d= pz.ConvertStringToDate(data,"dd/MM/yyyy");
   java.sql.Date sqlDate = new java.sql.Date(d.getTime());
        
        if(nom== false)
 errorenome.setText("Caratteri non validi");
else
    errorenome.setText("Caratteri validi");
if(this.jselspecie.getSelectedItem().toString().equals(" "))
    errorespecie.setText("Non hai selezionato alcuna specie");
else
    errorespecie.setText("Caratteri validi");
if(dat==false  )
    erroredata.setText("Caratteri non validi");
else if(d.after(today))
 erroredata.setText("Non puoi inserire una data futura");
else
    erroredata.setText("Caratteri validi");

    
   DBConnect conn =new DBConnect();
   
   int cod=conn.countSpecie(specie);
   
   String Cod_anim=(this.jselspecie.getSelectedItem().toString()+cod);
   
  
   
   int presente=1;
   int salute;
 if(this.jsalute.getSelectedItem()== "SANO")
       salute=1;
   else{salute=0;}
   int nostro;
    if(this.jnostro.getSelectedItem()== "SI")
       nostro=1;
   else{nostro=0;}
   
     if(nom==true  && dat==true && this.jselspecie.getSelectedItem().toString().equals(" ")==false )
    {
        if(d.before(today))
        {int reply = JOptionPane.showConfirmDialog(null, "Stai inserendo l'animale: "+this.jAggiunginomeanimale.getText()+"\n Specie: "+this.jselspecie.getSelectedItem().toString()+"\n Sesso: "+this.jGenere.getSelectedItem().toString()+"\n Nato il: "+this.jDatadinascita.getText()+"\n Habitat: "+this.jselhabitat.getText()+"\n Salute: "+this.jsalute.getSelectedItem().toString()+"\n Nostro: "+this.jnostro.getSelectedItem().toString(), "Confermare?", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION)
                { conn.insertAnimale(Cod_anim, nome,specie,genere , sqlDate, salute,nostro,presente);
    String codiceanim=conn.selezionacodiceAnimale(nome);
    conn.insertAnimaleSituato(0,codiceanim, this.jselhabitat.getText());
    JOptionPane.showMessageDialog(null, "ANIMALE INSERITO CORRETTAMENTE");
     jListaAnimali_Direttore lis = new jListaAnimali_Direttore();
     lis.setLocationRelativeTo(null);
     lis.setVisible(true);
    setVisible(false);}
    }else{JOptionPane.showMessageDialog(null, "NON PUOI INSERIRE UNA DATA FUTURA");}
    }  else{JOptionPane.showMessageDialog(null, "ALCUNI CAMPI NON SONO INSERITI CORRETTAMENTE");}
    
    
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jGenereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGenereActionPerformed
               // TODO add your handling code here:
    }//GEN-LAST:event_jGenereActionPerformed

    private void jnostroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jnostroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jnostroActionPerformed

    private void jsaluteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsaluteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jsaluteActionPerformed

    private void jDatadinascitaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jDatadinascitaFocusGained
        if(jDatadinascita.getText().equals("dd/mm/aaaa"))
        {jDatadinascita.setText("");
         jDatadinascita.setForeground(Color.black);
        }
        else
            jDatadinascita.getText(); // TODO add your handling code here:
    }//GEN-LAST:event_jDatadinascitaFocusGained

    private void jDatadinascitaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jDatadinascitaFocusLost
       if(jDatadinascita.getText().equals(""))
       { jDatadinascita.setForeground(Color.gray);   
        jDatadinascita.setText("dd/mm/aaaa");}   
    }//GEN-LAST:event_jDatadinascitaFocusLost

    private void jAggiunginomeanimaleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jAggiunginomeanimaleFocusLost
        if(jAggiunginomeanimale.getText().equals(""))
        { jAggiunginomeanimale.setForeground(Color.gray);   
        jAggiunginomeanimale.setText("Nome formato da sole lettere");} 
    }//GEN-LAST:event_jAggiunginomeanimaleFocusLost

    private void jAggiunginomeanimaleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jAggiunginomeanimaleFocusGained
         if(jAggiunginomeanimale.getText().equals("Nome formato da sole lettere"))
          {jAggiunginomeanimale.setText("");
           jAggiunginomeanimale.setForeground(Color.black);
          }
        else
            jAggiunginomeanimale.getText(); // TODO add your handling code here:
    }//GEN-LAST:event_jAggiunginomeanimaleFocusGained

    private void jselspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jselspecieActionPerformed
        DBConnect conn=new DBConnect();
        this.jselhabitat.setText(conn.selezionaHabitatSpecie(this.jselspecie.getSelectedItem().toString()).getHabitat());
        
       
    }//GEN-LAST:event_jselspecieActionPerformed

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
            java.util.logging.Logger.getLogger(JAggiungiAnimale_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JAggiungiAnimale_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JAggiungiAnimale_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JAggiungiAnimale_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JAggiungiAnimale_Direttore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel erroredata;
    private javax.swing.JLabel errorehabitat;
    private javax.swing.JLabel errorenome;
    private javax.swing.JLabel errorespecie;
    private javax.swing.JTextField jAggiunginomeanimale;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jDataAnimale;
    private javax.swing.JTextField jDatadinascita;
    private javax.swing.JComboBox<String> jGenere;
    private javax.swing.JLabel jGenereAnimale;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jNomeAnimale;
    private javax.swing.JLabel jSpecieAnimale;
    private javax.swing.JComboBox<String> jnostro;
    private javax.swing.JComboBox<String> jsalute;
    private javax.swing.JTextField jselhabitat;
    private javax.swing.JComboBox<String> jselspecie;
    // End of variables declaration//GEN-END:variables
}
