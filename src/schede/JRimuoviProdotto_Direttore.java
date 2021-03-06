/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schede;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import logins.JDirettore;
import database.DBConnect;
import progettozoo.Prodotto;
import progettozoo.Utente;


/**
 *
 * @author Roberto
 */
public class JRimuoviProdotto_Direttore extends javax.swing.JFrame {
    public static Utente utente = new Utente();
    DBConnect conn =new DBConnect();
    /**
     * Creates new form JRimuoviProdotto_Direttore
     */
    public JRimuoviProdotto_Direttore(Utente user_log) {
        initComponents(); 
        utente.setUsername(user_log.getUsername());
        utente.setNome(user_log.getNome());
        utente.setCognome(user_log.getCognome());
        ArrayList<Prodotto> list = conn.listaProdotti();
        
        
        for(int i = 0; i < list.size(); i++)
        {
            
            this.jrimuoviprodotto.addItem(list.get(i).getTipo());
           
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

        jLabel1 = new javax.swing.JLabel();
        jrimuoviprodotto = new javax.swing.JComboBox<>();
        jRimuovi = new javax.swing.JButton();
        jChiudi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("                             SELEZIONA IL PRODOTTO DA RIMUOVERE");

        jrimuoviprodotto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrimuoviprodottoActionPerformed(evt);
            }
        });

        jRimuovi.setText("Rimuovi");
        jRimuovi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRimuoviActionPerformed(evt);
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jrimuoviprodotto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jRimuovi, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jChiudi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jrimuoviprodotto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRimuovi)
                    .addComponent(jChiudi))
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrimuoviprodottoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrimuoviprodottoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrimuoviprodottoActionPerformed

    private void jRimuoviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRimuoviActionPerformed
        String tipoPro = this.jrimuoviprodotto.getSelectedItem().toString();
         int reply = JOptionPane.showConfirmDialog(null, "Vuoi eliminare il prodotto "+this.jrimuoviprodotto.getSelectedItem().toString()+"?", "Confermare?", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION)
                { conn.deleteProdotto(tipoPro);
         JOptionPane.showMessageDialog(null, "IL PRODOTTO E' STATO RIMOSSO CORRETTAMENTE");
             JListaProdotti_Direttore lispro=new JListaProdotti_Direttore(utente);
       lispro.setLocationRelativeTo(null);
       lispro.setVisible(true);
          setVisible(false);}
    }//GEN-LAST:event_jRimuoviActionPerformed

    private void jChiudiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChiudiActionPerformed
      setVisible(false);  
      new JDirettore(utente).setVisible(true);
    }//GEN-LAST:event_jChiudiActionPerformed

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
            java.util.logging.Logger.getLogger(JRimuoviProdotto_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JRimuoviProdotto_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JRimuoviProdotto_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JRimuoviProdotto_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JRimuoviProdotto_Direttore(utente).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jChiudi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jRimuovi;
    private javax.swing.JComboBox<String> jrimuoviprodotto;
    // End of variables declaration//GEN-END:variables
}
