/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logins;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import progettozoo.DBConnect;
import progettozoo.Prodotto;
import progettozoo.Utente;

/**
 *
 * @author Alberto
 */
public class JCassiere extends javax.swing.JFrame {

    JVeterinario v = new JVeterinario();
    Utente user = new Utente();
    DBConnect conn = new DBConnect();
    /**
     * Creates new form JCassiere
     */
    public JCassiere() {
        initComponents();
    }
    
    public JCassiere(Utente user_login) {
       

        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Benvenuto, "+user_login.getNome()+ " " + user_login.getCognome() );
        
        user.setUsername(user_login.getUsername());
        user.setNome(user_login.getNome());
        user.setCognome(user_login.getCognome());
        
        String[] jTableProdottiHeaders  = {"Nome","Prezzo","Disponibilità","Ordine"};
        v.selectmode(this.jTableProdotti);   
        creaTabella(this.jTableProdotti, jTableProdottiHeaders);
        this.jTableProdotti.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        Show_Prodotti_In_JTable(this.jTableProdotti);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jButtonLogout = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProdotti = new javax.swing.JTable();
        jVendiProdotti = new javax.swing.JToggleButton();

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jFrame1.setBackground(new java.awt.Color(51, 204, 255));

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 283, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cassiere");

        jButtonLogout.setText("Logout");
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        jTableProdotti.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableProdotti);

        jVendiProdotti.setText("Vendi");
        jVendiProdotti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVendiProdottiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jVendiProdotti)
                        .addGap(267, 267, 267)
                        .addComponent(jButtonLogout)))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jVendiProdotti)
                    .addComponent(jButtonLogout))
                .addContainerGap(37, Short.MAX_VALUE))
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

    private void jVendiProdottiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVendiProdottiActionPerformed
        // TODO add your handling code here:
        
        ArrayList<Prodotto> pro = conn.listaProdotti();
        for(int i = 0;i< pro.size(); i++){
            
            Object go = this.jTableProdotti.getValueAt(i+1, 3);
            
            String gs = go.toString();
            
            int gi = Integer.parseInt(gs);
            
            System.out.print(go);
            System.out.print(gs);
            System.out.print(gi);
            
            
            conn.vendiProdotto(pro.get(i), gi, user);
            
        }
        setVisible(false);
        JCassiere cas = new JCassiere(user);
    }//GEN-LAST:event_jVendiProdottiActionPerformed

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
            java.util.logging.Logger.getLogger(JCassiere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JCassiere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JCassiere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JCassiere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JCassiere().setVisible(true);
            }
        });
    }
    
    public void creaTabella(JTable table,String[] columnHeaders){
        Object[][] data = {
            {"","","","","","","","",""},
        };
        
        DefaultTableModel tableModel = new DefaultTableModel(data, columnHeaders)
        {
            boolean[] canEdit = new boolean[]{
                    false, false, false, true //messo così per ricordarmi come si fa per ogni singola cella
            };
            
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
         
        };
         table.setModel(tableModel);  
        
    }
    
    public void Show_Prodotti_In_JTable(JTable table)
   {
       ArrayList<Prodotto> list = conn.listaProdotti();
       DefaultTableModel model = (DefaultTableModel) table.getModel();
       Object[] row = new Object[4];
       
        table.changeSelection(0, 0, false, false);
       for(int i = 0; i < list.size(); i++)
       {
     
           row[0] = list.get(i).getTipo();
           
           row[1] = list.get(i).getPrezzo();
           
           row[2] = list.get(i).getGiacenza();
           
           row[3] = 0;
                   
           model.addRow(row);
           
       }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableProdotti;
    private javax.swing.JToggleButton jVendiProdotti;
    // End of variables declaration//GEN-END:variables
}
