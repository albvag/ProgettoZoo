/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schede;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import progettozoo.DBConnect;
import static schede.JAggiungiPersonale_Direttore.check;

/**
 *
 * @author Roberto
 */
public class JAggiungiProdotto_Direttore extends javax.swing.JFrame {

    /**
     * Creates new form JAggiungiProdotto_Direttore
     */
    public JAggiungiProdotto_Direttore() {
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jaggiunginome = new javax.swing.JTextField();
        jaggiungiprezzo = new javax.swing.JTextField();
        jaggiungigiacenza = new javax.swing.JTextField();
        jSalva = new javax.swing.JButton();
        jChiudi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("                                    QUALE PRODOTTO SI VUOLE INSERIRE?");

        jLabel2.setText("    Nome");

        jLabel3.setText("    Prezzo");

        jLabel4.setText("  Giacenza");

        jaggiunginome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jaggiunginomeActionPerformed(evt);
            }
        });

        jaggiungiprezzo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jaggiungiprezzoActionPerformed(evt);
            }
        });

        jaggiungigiacenza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jaggiungigiacenzaActionPerformed(evt);
            }
        });

        jSalva.setText("Salva");
        jSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalvaActionPerformed(evt);
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
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jaggiungigiacenza, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jaggiungiprezzo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jaggiunginome, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jSalva, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jChiudi, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jaggiunginome, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jaggiungiprezzo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jaggiungigiacenza, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSalva)
                    .addComponent(jChiudi))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
         public static boolean check(String regex, String input){
  if (Pattern.matches(regex, input))
    return true;
  else
    return false;
}
    private void jaggiunginomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jaggiunginomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jaggiunginomeActionPerformed

    private void jaggiungiprezzoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jaggiungiprezzoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jaggiungiprezzoActionPerformed

    private void jaggiungigiacenzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jaggiungigiacenzaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jaggiungigiacenzaActionPerformed

    private void jSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalvaActionPerformed
      String nome=this.jaggiunginome.getText();
      String prezzo=this.jaggiungiprezzo.getText();
      String giacenza=this.jaggiungigiacenza.getText();
        String formprezzo1 = "[0-9]*+[.]+[0-9]*";
        String formprezzo2 = "[0-9]*";
        boolean pre=check(formprezzo1,prezzo);
        boolean pre2=check(formprezzo2,prezzo);
        boolean gia=check(formprezzo2,giacenza);
        if(pre==false && pre2==false || gia==false)
      JOptionPane.showMessageDialog(null, "CARATTERI NON VALIDI");
        else{ 
             int reply = JOptionPane.showConfirmDialog(null, "Vuoi aggiungere il prodotto "+this.jaggiunginome.getText()+" al prezzo di "+this.jaggiungiprezzo.getText()+" con una giacenza di "+this.jaggiungigiacenza.getText()+" prodotti nel magazzino?", "Confermare?", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION)
                { JOptionPane.showMessageDialog(null, "PRODOTTO AGGIUNTO CORRETTAMENTE");
            setVisible(false);
      int g=Integer.parseInt(giacenza);
      double p=Double.parseDouble(prezzo);
      DBConnect conn=new DBConnect();
      conn.addProdotto(nome, p, g);}
        }
      
      
    }//GEN-LAST:event_jSalvaActionPerformed

    private void jChiudiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChiudiActionPerformed
       setVisible(false);
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
            java.util.logging.Logger.getLogger(JAggiungiProdotto_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JAggiungiProdotto_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JAggiungiProdotto_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JAggiungiProdotto_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JAggiungiProdotto_Direttore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jChiudi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jSalva;
    private javax.swing.JTextField jaggiungigiacenza;
    private javax.swing.JTextField jaggiunginome;
    private javax.swing.JTextField jaggiungiprezzo;
    // End of variables declaration//GEN-END:variables
}
