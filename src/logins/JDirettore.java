/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logins;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import progettozoo.Animale;
import progettozoo.DBConnect;
import progettozoo.Utente;
import schede.JAggiungiAnimale_Direttore;
import schede.JAggiungiHabitat_Direttore;
import schede.JAggiungiPersonale_Direttore;
import schede.jListaAnimali_Direttore;

/**
 *
 * @author Alberto
 */
public class JDirettore extends javax.swing.JFrame {

    /**
     * Creates new form JDirettore
     */
    public JDirettore() {
        initComponents();
    }
    public JDirettore(Utente user_login) {
        initComponents();
        setTitle("Benvenuto, "+user_login.getNome()+ " " + user_login.getCognome() );
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonLogout = new javax.swing.JButton();
        jAggiungiPersonale = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jAggiungiAnimale = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jAggiungiHabitat = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jListaanimali = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Direttore");

        jButtonLogout.setText("Logout");
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        jAggiungiPersonale.setText("Aggiungi Personale");
        jAggiungiPersonale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAggiungiPersonaleActionPerformed(evt);
            }
        });

        jButton2.setText("Rimuovi Personale");

        jAggiungiAnimale.setText("Aggiungi Animale");
        jAggiungiAnimale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAggiungiAnimaleActionPerformed(evt);
            }
        });

        jButton4.setText("Rimuovi Animale");

        jAggiungiHabitat.setText("Aggiungi Habitat");
        jAggiungiHabitat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAggiungiHabitatActionPerformed(evt);
            }
        });

        jButton6.setText("Rimuovi Habitat");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Vedi Incassi");

        jListaanimali.setText("Lista Animali");
        jListaanimali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jListaanimaliActionPerformed(evt);
            }
        });

        jButton9.setText("Presta Animale");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(317, Short.MAX_VALUE)
                .addComponent(jButtonLogout)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(jAggiungiAnimale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jAggiungiPersonale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jAggiungiHabitat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jListaanimali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAggiungiPersonale)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAggiungiAnimale)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAggiungiHabitat)
                    .addComponent(jButton6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jListaanimali))
                .addGap(18, 18, 18)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jButtonLogout)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        // TODO add your handling code here:
        JLogin log = new JLogin();
        log.setLocationRelativeTo(null);
        log.setVisible(true);
        log.close(this);
    }//GEN-LAST:event_jButtonLogoutActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jAggiungiPersonaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAggiungiPersonaleActionPerformed
       JAggiungiPersonale_Direttore per = new JAggiungiPersonale_Direttore();
                    per.setLocationRelativeTo(null);
                    per.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jAggiungiPersonaleActionPerformed

    private void jAggiungiAnimaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAggiungiAnimaleActionPerformed
       JAggiungiAnimale_Direttore an = new JAggiungiAnimale_Direttore();
                   an.setLocationRelativeTo(null);
                   an.setVisible(true);    // TODO add your handling code here:
    }//GEN-LAST:event_jAggiungiAnimaleActionPerformed

    private void jAggiungiHabitatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAggiungiHabitatActionPerformed
        JAggiungiHabitat_Direttore hab = new JAggiungiHabitat_Direttore();
         hab.setLocationRelativeTo(null);
                   hab.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_jAggiungiHabitatActionPerformed

    private void jListaanimaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jListaanimaliActionPerformed
        jListaAnimali_Direttore lis = new jListaAnimali_Direttore();
         lis.setLocationRelativeTo(null);
                   lis.setVisible(true); // TODO add your handling code here:
    }//GEN-LAST:event_jListaanimaliActionPerformed

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
            java.util.logging.Logger.getLogger(JDirettore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDirettore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDirettore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDirettore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JDirettore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAggiungiAnimale;
    private javax.swing.JButton jAggiungiHabitat;
    private javax.swing.JButton jAggiungiPersonale;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jListaanimali;
    // End of variables declaration//GEN-END:variables
}
