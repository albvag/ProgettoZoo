/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schede;

import java.util.ArrayList;
import java.util.function.UnaryOperator;
import javax.swing.JOptionPane;
import logins.JDirettore;
import progettozoo.Animale;
import progettozoo.DBConnect;
import progettozoo.Habitat;
import progettozoo.Utente;


/**
 *
 * @author Roberto
 */
public class JRimuoviAnimale_Direttore extends javax.swing.JFrame {
     public static Utente utente = new Utente();
    /**
     * Creates new form JRimuoviAnimale_Direttore
     */
    public JRimuoviAnimale_Direttore(Utente user_log) {
        initComponents();
        utente.setUsername(user_log.getUsername());
        utente.setNome(user_log.getNome());
        utente.setCognome(user_log.getCognome());
         DBConnect conn =new DBConnect();
         
        ArrayList<Animale> list = conn.selezionaAnimaliSpecie();
        
        
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
        jRimuovi = new javax.swing.JButton();
        jChiudi = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jselanim = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("                                  SELEZIONA L'ANIMALE DA RIMUOVERE");

        jselspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jselspecieActionPerformed(evt);
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

        jLabel2.setText("SELEZIONA LA SPECIE:");

        jLabel3.setText("SELEZIONA ANIMALE:");

        jselanim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jselanimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jRimuovi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(jChiudi)
                .addGap(68, 68, 68))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jselspecie, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jselanim, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jselspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jselanim, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRimuovi)
                    .addComponent(jChiudi))
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jChiudiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChiudiActionPerformed
       setVisible(false); 
       new JDirettore(utente).setVisible(true);
    }//GEN-LAST:event_jChiudiActionPerformed

    private void jRimuoviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRimuoviActionPerformed
          DBConnect conn= new DBConnect();
          String Cod_anim=this.jselanim.getSelectedItem().toString();
          String codice=conn.selezionacodiceAnimale(Cod_anim);
           int reply = JOptionPane.showConfirmDialog(null, "Vuoi eliminare l'animale "+this.jselanim.getSelectedItem().toString()+"\n di specie "+this.jselspecie.getSelectedItem().toString() , "Confermare?", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION)
                { conn.deleteAnimale(Cod_anim);
          conn.deleteAnimaleVisita(codice);
          conn.deleteAnimaleSituato(codice);
          JOptionPane.showMessageDialog(null, "L'ANIMALE E' STATO RIMOSSO CORRETTAMENTE");
         jListaAnimali_Direttore lis = new jListaAnimali_Direttore(utente);
         lis.setLocationRelativeTo(null);
                   lis.setVisible(true);
          setVisible(false);}
    }//GEN-LAST:event_jRimuoviActionPerformed

    private void jselspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jselspecieActionPerformed
          DBConnect conn=new DBConnect();
       String specie=this.jselspecie.getSelectedItem().toString();
       ArrayList<Animale> lista= new ArrayList<Animale>();
       
       lista=conn.selezionaAnimaliNome(specie);
       if(!lista.isEmpty())
       {  this.jselanim.removeAllItems();
     for(int j = 0; j < lista.size(); j++)
        {
            
            this.jselanim.addItem(lista.get(j).getNome());
            
            
        }}
     
     
       
        
      // TODO add your handling code here:
    }//GEN-LAST:event_jselspecieActionPerformed

    private void jselanimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jselanimActionPerformed
    
     
    }//GEN-LAST:event_jselanimActionPerformed

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
            java.util.logging.Logger.getLogger(JRimuoviAnimale_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JRimuoviAnimale_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JRimuoviAnimale_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JRimuoviAnimale_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JRimuoviAnimale_Direttore(utente).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jChiudi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jRimuovi;
    private javax.swing.JComboBox<String> jselanim;
    private javax.swing.JComboBox<String> jselspecie;
    // End of variables declaration//GEN-END:variables
}
