/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logins;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import progettozoo.DBConnect;
import progettozoo.Pasto;
import progettozoo.Prodotto;
import progettozoo.Pulizia;
import progettozoo.Utente;


/**
 *
 * @author Alberto
 */
public class JCustode extends javax.swing.JFrame {

    Utente user = new Utente();
    JVeterinario v = new JVeterinario();
    DBConnect conn = new DBConnect();
    
    /**
     * Creates new form JCustode
     */
    public JCustode() {
        initComponents();
    }
    
    
     public JCustode(Utente user_login) {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        this.jPulizie.setVisible(false);
        this.jNutrire.setVisible(false);
        setTitle("Benvenuto, "+user_login.getNome()+ " " + user_login.getCognome() );
        pack();
        user.setUsername(user_login.getUsername());
        user.setNome(user_login.getNome());
        user.setCognome(user_login.getCognome());
        
        String[] jTablePulizieHeaders  = {"Gabbia"};
        String[] jTableAiutiHeaders  = {"Gabbia","Custode"};
        String[] jTablePastiHeaders  = {"Gabbia"};
        v.selectmode(this.jTablePulizie); 
        v.selectmode(this.jPasti);
        v.selectmode(this.jTableAiuti);
        v.creaTabella(this.jTablePulizie, jTablePulizieHeaders);
        v.creaTabella(this.jTableAiuti, jTableAiutiHeaders);
        v.creaTabella(this.jPasti, jTablePastiHeaders);
        this.jTablePulizie.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        this.jTableAiuti.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        this.jPasti.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        Show_Pulizie_In_JTable(this.jTablePulizie);
        Show_Aiuti_In_JTable(this.jTableAiuti);
        Show_Pasti_In_JTable(this.jPasti);
        
    }
    
    public void Show_Pulizie_In_JTable(JTable table)
    {
        
       ArrayList<Pulizia> list = conn.listPulizieDisponibili();
       DefaultTableModel model = (DefaultTableModel) table.getModel();
       Object[] row = new Object[1];
       
        table.changeSelection(0, 0, false, false);
       for(int i = 0; i < list.size(); i++)
       {
           
           row[0] = list.get(i).getCodice_Gabbia();
                   
           model.addRow(row);
           
       }
    }   
       public void Show_Aiuti_In_JTable(JTable table)
    {
       ArrayList<Pulizia> list = conn.listRichiesteAiuto();
       DefaultTableModel model = (DefaultTableModel) table.getModel();
       Object[] row = new Object[2];
       
        table.changeSelection(0, 0, false, false);
       for(int i = 0; i < list.size(); i++)
       {
     
           row[0] = list.get(i).getCodice_Gabbia();
           
           row[1] = list.get(i).getDisponibile();
       
           model.addRow(row);
           
       }
    }
       
    public void Show_Pasti_In_JTable(JTable table)
    {
       ArrayList<Pasto> list = conn.listaPastiDisponibili();
       DefaultTableModel model = (DefaultTableModel) table.getModel();
       Object[] row = new Object[1];
       
       table.changeSelection(0, 0, false, false);
       for(int i = 0; i < list.size(); i++)
       {
     
           row[0] = list.get(i).getCodice_Gabbia();
          
           model.addRow(row);
           
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

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jNutrire = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPasti = new javax.swing.JTable();
        jAccettaNutri = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPulisce = new javax.swing.JButton();
        jNutri = new javax.swing.JButton();
        jPulizie = new javax.swing.JInternalFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePulizie = new javax.swing.JTable();
        AccettaPulizia = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableAiuti = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLogout = new javax.swing.JButton();
        jLabelCompito = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Custode");

        jNutrire.setVisible(true);

        jPasti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jPasti);

        jAccettaNutri.setText("Accetta");
        jAccettaNutri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAccettaNutriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jNutrireLayout = new javax.swing.GroupLayout(jNutrire.getContentPane());
        jNutrire.getContentPane().setLayout(jNutrireLayout);
        jNutrireLayout.setHorizontalGroup(
            jNutrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jNutrireLayout.createSequentialGroup()
                .addGroup(jNutrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jNutrireLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jNutrireLayout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jAccettaNutri)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jNutrireLayout.setVerticalGroup(
            jNutrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jNutrireLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jAccettaNutri)
                .addContainerGap())
        );

        jLabel1.setText("SCEGLI COMPITO");

        jPulisce.setText("Pulizie");
        jPulisce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPulisceActionPerformed(evt);
            }
        });

        jNutri.setText("Nutri");
        jNutri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNutriActionPerformed(evt);
            }
        });

        jPulizie.setVisible(true);

        jTablePulizie.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTablePulizie);

        AccettaPulizia.setText("Accetta Pulizia");
        AccettaPulizia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccettaPuliziaActionPerformed(evt);
            }
        });

        jTableAiuti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTableAiuti);

        jLabel2.setText("PULIZIE RIMANENTI");

        jLabel3.setText("RICHIESTE AIUTO");

        javax.swing.GroupLayout jPulizieLayout = new javax.swing.GroupLayout(jPulizie.getContentPane());
        jPulizie.getContentPane().setLayout(jPulizieLayout);
        jPulizieLayout.setHorizontalGroup(
            jPulizieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPulizieLayout.createSequentialGroup()
                .addGroup(jPulizieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPulizieLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPulizieLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPulizieLayout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel2))
                    .addGroup(jPulizieLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(AccettaPulizia))
                    .addGroup(jPulizieLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel3)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPulizieLayout.setVerticalGroup(
            jPulizieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPulizieLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AccettaPulizia)
                .addContainerGap())
        );

        jLogout.setText("Logout");
        jLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogoutActionPerformed(evt);
            }
        });

        if(conn.hoUnCompito( user)){
            this.jLabelCompito.setText("Scegli un compito");
        }else this.jLabelCompito.setText("Hai un compito");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPulizie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPulisce)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                                .addComponent(jNutri))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel1)))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLogout)
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelCompito, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jNutrire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jNutrire)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelCompito, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPulisce)
                    .addComponent(jNutri))
                .addGap(39, 39, 39)
                .addComponent(jLogout)
                .addContainerGap(247, Short.MAX_VALUE))
            .addComponent(jPulizie)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jNutriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNutriActionPerformed
        // TODO add your handling code here:
        this.jPulizie.setVisible(false);
        this.jNutrire.setVisible(true);
        pack();
    }//GEN-LAST:event_jNutriActionPerformed

    private void jLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLogoutActionPerformed
        // TODO add your handling code here:
        JLogin log = new JLogin();
        log.setLocationRelativeTo(null);
        log.setVisible(true);
        log.close(this);
    }//GEN-LAST:event_jLogoutActionPerformed

    private void jPulisceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPulisceActionPerformed
        // TODO add your handling code here:
        this.jPulizie.setVisible(true);
        this.jNutrire.setVisible(false);
        pack();
    }//GEN-LAST:event_jPulisceActionPerformed

    private void jAccettaNutriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAccettaNutriActionPerformed
        // TODO add your handling code here:
        if(this.jPasti.getSelectedRow()==0){
            JOptionPane.showMessageDialog(null, "DEVI SELEZIONARE UN COMPITO");
        }else {
            conn.accettaPasto(conn.listaPastiDisponibili().get(this.jPasti.getSelectedRow()-1), user);
            setVisible(false); 
            JCustode cus = new JCustode(user);
        }
    }//GEN-LAST:event_jAccettaNutriActionPerformed

    private void AccettaPuliziaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccettaPuliziaActionPerformed
        // TODO add your handling code here:
        if(this.jTablePulizie.getSelectedRow()==0&& this.jTableAiuti.getSelectedRow() ==0){
            JOptionPane.showMessageDialog(null, "DEVI SELEZIONARE UN COMPITO");
        }else if(this.jTablePulizie.getSelectedRow()!=0&& this.jTableAiuti.getSelectedRow() !=0){
            JOptionPane.showMessageDialog(null, "DEVI SEZIONARE SOLO UN COMPITO");
        }else if(this.jTablePulizie.getSelectedRow()!=0){
            conn.accettaPulizia(conn.listPulizieDisponibili().get(this.jTablePulizie.getSelectedRow()-1), user);
            setVisible(false); 
            JCustode cus = new JCustode(user);
        }else {
            conn.accettaPulizia(conn.listRichiesteAiuto().get(this.jTableAiuti.getSelectedRow()-1), user);
            setVisible(false); 
            JCustode cus = new JCustode(user);
        }
    }//GEN-LAST:event_AccettaPuliziaActionPerformed

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
            java.util.logging.Logger.getLogger(JCustode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JCustode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JCustode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JCustode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JCustode().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AccettaPulizia;
    private javax.swing.JButton jAccettaNutri;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelCompito;
    private javax.swing.JButton jLogout;
    private javax.swing.JButton jNutri;
    private javax.swing.JInternalFrame jNutrire;
    private javax.swing.JTable jPasti;
    private javax.swing.JButton jPulisce;
    private javax.swing.JInternalFrame jPulizie;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableAiuti;
    private javax.swing.JTable jTablePulizie;
    // End of variables declaration//GEN-END:variables

    public void close(schede.JCibo_Custode aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
