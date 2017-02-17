/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schede;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import progettozoo.DBConnect;
import progettozoo.Prodotto;
import static schede.JAggiungiProdotto_Direttore.check;

/**
 *
 * @author Roberto
 */
public class JCambiaPrezzi_Direttore extends javax.swing.JFrame {

    /**
     * Creates new form JCambiaPrezzi_Direttore
     */
    public JCambiaPrezzi_Direttore() {
        initComponents();
           DBConnect conn =new DBConnect();
        ArrayList<Prodotto> list = conn.selezionaProdotto("");
        
        
        for(int i = 0; i < list.size(); i++)
        {
            
            this.jselprodotto.addItem(list.get(i).getTipo());
           
           
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

        jConferma = new javax.swing.JButton();
        jselprodotto = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        joldprize = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jnewprize = new javax.swing.JTextField();
        jChiudi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jConferma.setText("Conferma");
        jConferma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConfermaActionPerformed(evt);
            }
        });

        jselprodotto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jselprodottoActionPerformed(evt);
            }
        });

        jLabel1.setText("                            VUOI CAMBIARE IL PREZZO DI UN PRODOTTO?");

        joldprize.setEditable(false);

        jLabel2.setText("Prezzo Vecchio");

        jLabel3.setText("Nuovo Prezzo");

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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(joldprize, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jselprodotto, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jnewprize, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jConferma)
                .addGap(43, 43, 43)
                .addComponent(jChiudi, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jselprodotto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(joldprize, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jnewprize, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jConferma)
                    .addComponent(jChiudi))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jselprodottoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jselprodottoActionPerformed
        String prodotto =this.jselprodotto.getSelectedItem().toString();
        DBConnect conn= new DBConnect();
        
        ArrayList<Prodotto> prod =conn.selezionaProdotto(prodotto);
        Double a= prod.get(0).getPrezzo();
        this.joldprize.setText(a.toString());
      
    }//GEN-LAST:event_jselprodottoActionPerformed

    private void jChiudiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChiudiActionPerformed
       setVisible(false);
    }//GEN-LAST:event_jChiudiActionPerformed

    private void jConfermaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConfermaActionPerformed
       String prezzo=this.jnewprize.getText();
       String prodotto=this.jselprodotto.getSelectedItem().toString();
       String formprezzo1 = "[0-9]*+[.]+[0-9]*";
        boolean pre=check(formprezzo1,prezzo);
         if(pre==false)
         JOptionPane.showMessageDialog(null, "CARATTERI NON VALIDI");
         else{
      DBConnect conn=new DBConnect();
       int reply = JOptionPane.showConfirmDialog(null, "Vuoi cambiare il prezzo del prodotto: "+this.jselprodotto.getSelectedItem().toString()+" da: "+this.joldprize.getText()+" a: "+this.jnewprize.getText(), "Confermare?", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION)
                {    double p=Double.parseDouble(prezzo);
      conn.updatePrezzoProdotto(p, prodotto);
                          JListaProdotti_Direttore lispro=new JListaProdotti_Direttore();
       lispro.setLocationRelativeTo(null);
       lispro.setVisible(true);
       setVisible(false);}
         }       
    }//GEN-LAST:event_jConfermaActionPerformed

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
            java.util.logging.Logger.getLogger(JCambiaPrezzi_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JCambiaPrezzi_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JCambiaPrezzi_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JCambiaPrezzi_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JCambiaPrezzi_Direttore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jChiudi;
    private javax.swing.JButton jConferma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jnewprize;
    private javax.swing.JTextField joldprize;
    private javax.swing.JComboBox<String> jselprodotto;
    // End of variables declaration//GEN-END:variables
}
