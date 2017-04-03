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
import progettozoo.Prodotto;
import progettozoo.Utente;
import static schede.JAggiungiPersonale_Direttore.check;

/**
 *
 * @author Alberto
 */
public class JCassiere extends javax.swing.JFrame {

    JVeterinario v = new JVeterinario();
    Utente user = new Utente();
    DBConnect conn = new DBConnect();
    /**
     * Crea nuova form JCassiere
     */
    public JCassiere() {
        initComponents();
    }
    /**
     * Crea una nuova form JCassiere salvando i dati dell'utente
     */ 
    public JCassiere(Utente user_login) {
       

        initComponents();
        setVisible(true);
        setTitle("Benvenuto, "+user_login.getNome()+ " " + user_login.getCognome() );
        this.jFrameGiacenza.setVisible(false);
        user.setUsername(user_login.getUsername());
        user.setNome(user_login.getNome());
        user.setCognome(user_login.getCognome());
        
        String[] jTableProdottiHeaders  = {"Nome","Prezzo","Disponibilità","Ordine"};
        String[] jTableGiacenzaHeaders  = {"Nome","Disponibilità","     "};
        v.selectmode(this.jTableProdotti);   
        creaTabellaProdotti(this.jTableProdotti, jTableProdottiHeaders);
        creaTabellaGiacenza(this.jTableGiacenza, jTableGiacenzaHeaders);
        this.jTableProdotti.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        Show_Prodotti_In_JTable(this.jTableProdotti);
        Show_Giacenza_In_JTable(this.jTableGiacenza);
        this.jTableProdotti.setCellSelectionEnabled(false);
        this.jTableGiacenza.setCellSelectionEnabled(false);
        this.jTableProdotti.getTableHeader().setReorderingAllowed(false);
        this.jTableGiacenza.getTableHeader().setReorderingAllowed(false);
        this.jTableProdotti.getTableHeader().setResizingAllowed(false);
        this.jTableGiacenza.getTableHeader().setResizingAllowed(false);
        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Crea una JTable in cui la quarta colonna è editabile
     */ 
    public void creaTabellaProdotti(JTable table,String[] columnHeaders){
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
   
    /**
     * Crea una JTable in cui la terza colonna è editabile
     */ 
    public void creaTabellaGiacenza(JTable table,String[] columnHeaders){
        Object[][] data = {
            {"","","","","","","","",""},
        };
        
        DefaultTableModel tableModel = new DefaultTableModel(data, columnHeaders)
        {
            boolean[] canEdit = new boolean[]{
                    false, false, true //messo così per ricordarmi come si fa per ogni singola cella
            };
            
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
         
        };
         table.setModel(tableModel);  
        
    }
    
     /**
     * Riempe una JTable con i prodotti venduti nello zoo
     */
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
     /**
     * Riempe una JTable con i dati di giacenza dei prodotti
     */
    public void Show_Giacenza_In_JTable(JTable table)
    {
       ArrayList<Prodotto> list = conn.listaProdotti();
       DefaultTableModel model = (DefaultTableModel) table.getModel();
       Object[] row = new Object[3];
       
        table.changeSelection(0, 0, false, false);
       for(int i = 0; i < list.size(); i++)
       {
     
           row[0] = list.get(i).getTipo();
           
           row[1] = list.get(i).getGiacenza();
           
           row[2] = 0;
                   
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

        jFrame1 = new javax.swing.JFrame();
        jButtonLogout = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProdotti = new javax.swing.JTable();
        jVendiProdotti = new javax.swing.JToggleButton();
        jGiacenza = new javax.swing.JButton();
        jFrameGiacenza = new javax.swing.JInternalFrame();
        jAddGiacenza = new javax.swing.JButton();
        jBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGiacenza = new javax.swing.JTable();

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
        jTableProdotti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProdottiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableProdotti);

        jVendiProdotti.setText("Vendi");
        jVendiProdotti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVendiProdottiActionPerformed(evt);
            }
        });

        jGiacenza.setText("aggiungere alla giacenza");
        jGiacenza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGiacenzaActionPerformed(evt);
            }
        });

        jFrameGiacenza.setPreferredSize(new java.awt.Dimension(489, 450));
        jFrameGiacenza.setVisible(true);

        jAddGiacenza.setText("Conferma");
        jAddGiacenza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddGiacenzaActionPerformed(evt);
            }
        });

        jBack.setText("Annulla");
        jBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBackActionPerformed(evt);
            }
        });

        jTableGiacenza.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableGiacenza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableGiacenzaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableGiacenza);

        javax.swing.GroupLayout jFrameGiacenzaLayout = new javax.swing.GroupLayout(jFrameGiacenza.getContentPane());
        jFrameGiacenza.getContentPane().setLayout(jFrameGiacenzaLayout);
        jFrameGiacenzaLayout.setHorizontalGroup(
            jFrameGiacenzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameGiacenzaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(jFrameGiacenzaLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jAddGiacenza)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBack)
                .addGap(126, 126, 126))
        );
        jFrameGiacenzaLayout.setVerticalGroup(
            jFrameGiacenzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameGiacenzaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jFrameGiacenzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAddGiacenza)
                    .addComponent(jBack))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jVendiProdotti)
                        .addGap(80, 80, 80)
                        .addComponent(jGiacenza)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLogout)))
                .addGap(46, 46, 46)
                .addComponent(jFrameGiacenza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jVendiProdotti)
                            .addComponent(jButtonLogout)
                            .addComponent(jGiacenza)))
                    .addComponent(jFrameGiacenza, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        
        JLogin log = new JLogin();
        log.setLocationRelativeTo(null);
        log.setVisible(true);
        log.close(this);
    }//GEN-LAST:event_jButtonLogoutActionPerformed
    
    //vende biglietti e merce
    
    private void jVendiProdottiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVendiProdottiActionPerformed
        
        
        this.jTableProdotti.getSelectionModel().clearSelection();
        ArrayList<Prodotto> pro = conn.listaProdotti();        
        boolean avanza = true; 
        for(int i = 0;i< pro.size()&&avanza; i++){ 
            Object go = this.jTableProdotti.getValueAt(i+1, 3);
            String gs = "";
            if(go==null){
                gs= "0";
            }else gs = go.toString();
            
            String formInt = "[0-9]*";
            boolean pre=check(formInt,gs);
            if(!pre){
                avanza=false;
                JOptionPane.showMessageDialog(null, "CARATTERI NON VALIDI");
            }      
        }
        int conta = 0;
        ArrayList vendita = new ArrayList();
        for(int i = 0;i< pro.size()&&avanza; i++){
           
            Object go = this.jTableProdotti.getValueAt(i+1, 3);
            String gs = "";
            if(go==null){
                gs= "0";
            }else gs = go.toString();
            
            int gi = Integer.parseInt(gs);
            if(pro.get(i).getGiacenza()<gi){
                avanza = false;
                JOptionPane.showMessageDialog(null, "RICHIESTA ECCEDE GIACENZA");
            }
            if(gi!=0 && avanza ){
                String v=String.format("%s %-40s %-20s", pro.get(i).getTipo(),gi,Double.toString(gi*pro.get(i).getPrezzo()) + " €");
                vendita.add(v);
                vendita.add("\n");
                conta++;
            }
            
        }
        String venString = vendita.toString();
        venString = venString.replace('[', ' ');
        venString = venString.replace(']', ' ');
        venString = venString.replace(',', ' ');
        
        
        
        if(avanza){
            if(conta==0){
                JOptionPane.showMessageDialog(null, "Non hai selezionato nessun prodotto");
                avanza=false;
            }else{
            int reply = JOptionPane.showConfirmDialog(null,venString,"Confermare?", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.NO_OPTION)avanza=false;
            }
        }
        for(int i = 0;i< pro.size()&&avanza; i++){
            
            Object go = this.jTableProdotti.getValueAt(i+1, 3);
            String gs = "";
            if(go==null){
                gs= "0";
            }else gs = go.toString();
            int gi = Integer.parseInt(gs);
            if(gi!=0)conn.vendiProdotto(pro.get(i), gi, user);
            
        }
        if(avanza){
            setVisible(false); 
            JCassiere c = new JCassiere(user);
        }
    }//GEN-LAST:event_jVendiProdottiActionPerformed

    private void jGiacenzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGiacenzaActionPerformed
        
        this.jFrameGiacenza.setVisible(true);
        pack();
        setLocationRelativeTo(null);
        
    }//GEN-LAST:event_jGiacenzaActionPerformed

    private void jBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackActionPerformed
        
        this.jFrameGiacenza.setVisible(false);
        pack();
        setLocationRelativeTo(null);
    }//GEN-LAST:event_jBackActionPerformed

    private void jAddGiacenzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddGiacenzaActionPerformed
        
        this.jTableProdotti.getSelectionModel().clearSelection();
        ArrayList<Prodotto> pro = conn.listaProdotti();
        boolean avanza = true; 
        int conta = 0;
        for(int i = 0;i< pro.size()&&avanza; i++){ 
            Object go = this.jTableGiacenza.getValueAt(i+1, 2);
            String gs = "";
            if(go==null){
                gs= "0";
            }else {
                gs = go.toString();
                
            }
            String formInt = "[0-9]*";
            boolean pre=check(formInt,gs);
            if(!pre){
                avanza=false;
                JOptionPane.showMessageDialog(null, "CARATTERI NON VALIDI");
            }else if(!gs.equals("0")) conta++; 
            
        }
        int reply ;
        
        System.out.print(conta);
        
        if(conta==0){
                JOptionPane.showMessageDialog(null, "Non hai selezionato nessun prodotto");
        }else {reply = JOptionPane.showConfirmDialog(null,"Vuoi aggiungere la giacenza","Confermare?", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION){
        
        for(int i = 0;i< pro.size()&&avanza; i++){
            
            Object go = this.jTableGiacenza.getValueAt(i+1, 2);
            String gs = "";
            if(go==null){
                gs= "0";
            }else gs = go.toString();
            int gi = Integer.parseInt(gs);
            if(gi!=0){
                
                conn.addToGiacenza(pro.get(i), gi);
            }
            
        }
            }else avanza=false;
        if(avanza){
            setVisible(false); 
            JCassiere c = new JCassiere(user);
        }
        }
    }//GEN-LAST:event_jAddGiacenzaActionPerformed

    private void jTableProdottiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProdottiMouseClicked
        if(this.jTableProdotti.getSelectedColumn()== 3 && this.jTableProdotti.getSelectedRow()>0){
            this.jTableProdotti.setValueAt(null,this.jTableProdotti.getSelectedRow(),3);
        }
    }//GEN-LAST:event_jTableProdottiMouseClicked

    private void jTableGiacenzaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableGiacenzaMouseClicked
        if(this.jTableGiacenza.getSelectedColumn()== 2 && this.jTableGiacenza.getSelectedRow()>0){
            this.jTableGiacenza.setValueAt(null,this.jTableGiacenza.getSelectedRow(),2);
        }
    }//GEN-LAST:event_jTableGiacenzaMouseClicked
    
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



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAddGiacenza;
    private javax.swing.JButton jBack;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JInternalFrame jFrameGiacenza;
    private javax.swing.JButton jGiacenza;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableGiacenza;
    private javax.swing.JTable jTableProdotti;
    private javax.swing.JToggleButton jVendiProdotti;
    // End of variables declaration//GEN-END:variables
}
