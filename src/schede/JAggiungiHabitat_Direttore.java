/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schede;
import javax.swing.JOptionPane;
import progettozoo.DBConnect;

/**
 *
 * @author Roberto
 */
public class JAggiungiHabitat_Direttore extends javax.swing.JFrame {

    /**
     * Creates new form JAggiungiHabitat_Direttore
     */
    public JAggiungiHabitat_Direttore() {
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

        jLabel1 = new javax.swing.JLabel();
        jSalva = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();
        jInseriscihabitat = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        jLabel1.setText("           SELEZIONA IL TIPO DI HABITAT CHE VUOI INSERIRE:");

        jSalva.setText("Salva");
        jSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalvaActionPerformed(evt);
            }
        });

        jButtonClose.setText("Chiudi");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jInseriscihabitat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jInseriscihabitatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSalva)
                .addGap(43, 43, 43)
                .addComponent(jButtonClose)
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                    .addComponent(jInseriscihabitat))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jInseriscihabitat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSalva)
                    .addComponent(jButtonClose))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jInseriscihabitatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jInseriscihabitatActionPerformed
        
    }//GEN-LAST:event_jInseriscihabitatActionPerformed

    private void jSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalvaActionPerformed
       String habitat= this.jInseriscihabitat.getText();
       DBConnect conn= new DBConnect();
       if(conn.habitatExists(habitat))
       {
            JOptionPane.showMessageDialog(null, "Errore! L'Habitat è già esistente");
       }else{
            int reply = JOptionPane.showConfirmDialog(null, "L'habitat che vuoi inserire è: "+this.jInseriscihabitat.getText(), "Confermare?", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION)
                {  
                       JOptionPane.showMessageDialog(null, "Devi Inserire anche la nuova specie");
              
                    JAggiungiSpecie_Direttore aggspe= new JAggiungiSpecie_Direttore();
                      aggspe.setLocationRelativeTo(null);
                      aggspe.setVisible(true);
                    conn.insertHabitat(habitat);
                    setVisible(false);          
                }
                 
              
              
                
    
    }//GEN-LAST:event_jSalvaActionPerformed
    }
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
            java.util.logging.Logger.getLogger(JAggiungiHabitat_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JAggiungiHabitat_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JAggiungiHabitat_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JAggiungiHabitat_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JAggiungiHabitat_Direttore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JTextField jInseriscihabitat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jSalva;
    // End of variables declaration//GEN-END:variables
}
