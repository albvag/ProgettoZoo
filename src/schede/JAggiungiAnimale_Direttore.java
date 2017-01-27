/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schede;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.*;
import logins.JLogin;
import progettozoo.DBConnect;
import logins.JDirettore;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;
import javax.swing.ComboBoxModel;
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
        jAggiungispecie = new javax.swing.JTextField();
        jDatadinascita = new javax.swing.JTextField();

        jButtonSave = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();
        jGenere = new javax.swing.JComboBox<>();
        errorenome = new javax.swing.JLabel();
        errorespecie = new javax.swing.JLabel();
        erroredata = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jNomeAnimale.setText("         Nome");

        jSpecieAnimale.setText("        Specie");

        jGenereAnimale.setText("        Genere");

        jDataAnimale.setText("  Data di nascita");

        jAggiunginomeanimale.setForeground(new java.awt.Color(153, 153, 153));
        jAggiunginomeanimale.setText("Nome formato da sole lettere");
        jAggiunginomeanimale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAggiunginomeanimaleMouseClicked(evt);
            }
        });
        jAggiunginomeanimale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAggiunginomeanimaleActionPerformed(evt);
            }
        });

        jAggiungispecie.setForeground(new java.awt.Color(153, 153, 153));
        jAggiungispecie.setText("Es.leone,orso,pinguino,ecc.");
        jAggiungispecie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAggiungispecieMouseClicked(evt);
            }
        });
        jAggiungispecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAggiungispecieActionPerformed(evt);
            }
        });

        jDatadinascita.setForeground(new java.awt.Color(153, 153, 153));
        jDatadinascita.setText("dd/mm/aaaa");
        jDatadinascita.setToolTipText("");
        jDatadinascita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDatadinascitaMouseClicked(evt);
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

        jGenere.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Maschio", "Femmina" }));
        jGenere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGenereActionPerformed(evt);
            }
        });

        jLabel1.setText("       Salute");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sano", "Malato" }));

        jLabel2.setText("      Nostro");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));

        jLabel3.setText("     Presente");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(422, Short.MAX_VALUE)
                .addComponent(jButtonSave)
                .addGap(45, 45, 45)
                .addComponent(jButtonClose)
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSpecieAnimale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jGenereAnimale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDataAnimale, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                    .addComponent(jNomeAnimale, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(erroredata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errorespecie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errorenome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jAggiunginomeanimale, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(jDatadinascita, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(jAggiungispecie, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(jGenere, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(errorenome, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNomeAnimale, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAggiunginomeanimale, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorespecie, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpecieAnimale, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jAggiungispecie, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGenereAnimale, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGenere, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(erroredata, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jDataAnimale, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDatadinascita, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonClose))
                .addGap(39, 39, 39))
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
        String specie=this.jAggiungispecie.getText();
        String genere = this.jGenere.getSelectedItem().toString();
        //data in formato dd/mm/aaaa
        String data = this.jDatadinascita.getText();
         String formnome = "[a-zA-Z]{1,}";
         String forspecie ="[a-zA-Z]{1,}";
         //inserire la data in formato dd/mm/aaaa (giorno/mese/anno)
         String fordata ="(0[1-9]|1[0-9]|2[0-9]|3[01])[- /.](0[1-9]|[12][0-9]|3[01])[-/.](19|20)[0-9]{2}";
          Pattern pattern = Pattern.compile(formnome);
          Pattern pattern1 = Pattern.compile(forspecie);
          Pattern pattern2 = Pattern.compile(fordata);
        boolean nom=check(formnome,nome);
        boolean spe=check(forspecie,specie);
        boolean dat=check(fordata,data);
        
        if(nom== false)
 errorenome.setText("Caratteri non validi");
else
    errorenome.setText("Caratteri validi");
if(spe==false)
    errorespecie.setText("Caratteri non validi");
else
    errorespecie.setText("Caratteri validi");
if(dat==false)
    erroredata.setText("Caratteri non validi");
else
    erroredata.setText("Caratteri validi");


    if(nom==true && spe==true && dat==true)
     System.out.println("Nome: "+nome+" Specie: "+specie+" Genere: "+genere+" nato il: "+data);
    else{System.out.println("ERRORE");}
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jGenereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGenereActionPerformed
               // TODO add your handling code here:
    }//GEN-LAST:event_jGenereActionPerformed

    private void jDatadinascitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDatadinascitaMouseClicked
        if(jDatadinascita.getText().equals("dd/mm/aaaa"))
        {jDatadinascita.setText("");
         jDatadinascita.setForeground(Color.black);
        }
        else
            jDatadinascita.getText();
        
       
        // TODO add your handling code here:
    }//GEN-LAST:event_jDatadinascitaMouseClicked

    private void jAggiunginomeanimaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAggiunginomeanimaleMouseClicked
          if(jAggiunginomeanimale.getText().equals("Nome formato da sole lettere"))
          {jAggiunginomeanimale.setText("");
           jAggiunginomeanimale.setForeground(Color.black);
          }
        else
            jAggiunginomeanimale.getText();   // TODO add your handling code here:
    }//GEN-LAST:event_jAggiunginomeanimaleMouseClicked

    private void jAggiungispecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAggiungispecieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jAggiungispecieActionPerformed

    private void jAggiungispecieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAggiungispecieMouseClicked
         if(jAggiungispecie.getText().equals("Es.leone,orso,pinguino,ecc."))
         {jAggiungispecie.setText("");
          jAggiungispecie.setForeground(Color.black);
         }
        else
            jAggiungispecie.getText(); 
         // TODO add your handling code here:
    }//GEN-LAST:event_jAggiungispecieMouseClicked

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
    private javax.swing.JLabel errorenome;
    private javax.swing.JLabel errorespecie;
    private javax.swing.JTextField jAggiunginomeanimale;
    private javax.swing.JTextField jAggiungispecie;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jDataAnimale;
    private javax.swing.JTextField jDatadinascita;
    private javax.swing.JComboBox<String> jGenere;
    private javax.swing.JLabel jGenereAnimale;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jNomeAnimale;
    private javax.swing.JLabel jSpecieAnimale;
    // End of variables declaration//GEN-END:variables
}
