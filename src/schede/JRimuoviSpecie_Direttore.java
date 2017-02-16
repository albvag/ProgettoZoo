/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schede;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import progettozoo.Animale;
import progettozoo.DBConnect;
import progettozoo.Habitat;

/**
 *
 * @author Roberto
 */
public class JRimuoviSpecie_Direttore extends javax.swing.JFrame {

    /**
     * Creates new form JRimuoviSpecie_Direttore
     */
    public JRimuoviSpecie_Direttore() {
        initComponents();
             DBConnect conn =new DBConnect();
        ArrayList<Animale> list = conn.selezionaSpecie();
        
        for(int i = 0; i < list.size(); i++)
        {
            
            this.jselspecie.addItem(list.get(i).getSpecie());
            
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
        jselspecie = new javax.swing.JComboBox<>();
        jrimuovispecie = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("                      SELEZIONA LA SPECIE CHE SI INTENDE RIMUOVERE");

        jselspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jselspecieActionPerformed(evt);
            }
        });

        jrimuovispecie.setText("Rimuovi");
        jrimuovispecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrimuovispecieActionPerformed(evt);
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
                    .addComponent(jselspecie, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jrimuovispecie, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jselspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jrimuovispecie, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrimuovispecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrimuovispecieActionPerformed
        String specie=this.jselspecie.getSelectedItem().toString();
        DBConnect conn=new DBConnect();
       
         int reply = JOptionPane.showConfirmDialog(null, "Hai Selezionato: "+this.jselspecie.getSelectedItem().toString(),  "Confermare?", JOptionPane.YES_NO_OPTION);
                 if (reply == JOptionPane.YES_OPTION)
                 {   conn.deleteSpecie(specie);
                        JListaHabitat_Direttore lishab= new JListaHabitat_Direttore();
                        lishab.setLocationRelativeTo(null);
                        lishab.setVisible(true);
                        JOptionPane.showMessageDialog(null, "HAI CANCELLATO HABITAT E SPECIE");
                        setVisible(false);
                 }   
         
    }//GEN-LAST:event_jrimuovispecieActionPerformed

    private void jselspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jselspecieActionPerformed
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(JRimuoviSpecie_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JRimuoviSpecie_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JRimuoviSpecie_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JRimuoviSpecie_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JRimuoviSpecie_Direttore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jrimuovispecie;
    private javax.swing.JComboBox<String> jselspecie;
    // End of variables declaration//GEN-END:variables
}
