/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schede;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import logins.JDirettore;
import logins.JVeterinario;
import progettozoo.Animale;
import progettozoo.DBConnect;
import progettozoo.ProgettoZoo;
import progettozoo.Utente;
import progettozoo.Visita;


/**
 *
 * @author Roberto
 */
public class JPrestaAnimale_Direttore extends javax.swing.JFrame {
    public static Utente utente = new Utente();
    JVeterinario v=new JVeterinario();
    DBConnect conn=new DBConnect();
    ProgettoZoo pz = new ProgettoZoo();
    /**
     * Creates new form JPrestaAnimale_Direttore
     */
    public JPrestaAnimale_Direttore(Utente user_log) {
        initComponents();
        utente.setUsername(user_log.getUsername());
        utente.setNome(user_log.getNome());
        utente.setCognome(user_log.getCognome());
        this.jTablePresenti.getTableHeader().setReorderingAllowed(false);
           String[] jTableAnimaliHeaders  = {"Nome Animale","Specie","Genere","Data di Nascita"};
        v.selectmode(this.jTablePresenti);   
        v.creaTabella(this.jTablePresenti, jTableAnimaliHeaders);
        this.jTablePresenti.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        Show_AnimaliPresenti_In_JTable(this.jTablePresenti);
        this.jTableInPrestito.getTableHeader().setReorderingAllowed(false);
           String[] jTableAnimaliHeaders1  = {"Nome Animale","Specie","Genere","Data di Nascita"};
        v.selectmode(this.jTableInPrestito);   
        v.creaTabella(this.jTableInPrestito, jTableAnimaliHeaders);
        this.jTableInPrestito.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        Show_AnimaliInPrestito_In_JTable(this.jTableInPrestito);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePresenti = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableInPrestito = new javax.swing.JTable();
        jPrestaAnimali = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jRichiamaAnimali = new javax.swing.JButton();
        jChiudi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTablePresenti.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTablePresenti);

        jTableInPrestito.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableInPrestito);

        jPrestaAnimali.setText("Presta");
        jPrestaAnimali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPrestaAnimaliActionPerformed(evt);
            }
        });

        jLabel1.setText("                                                           ANIMALI PRESENTI");

        jLabel2.setText("                                                             ANIMALI IN PRESTITO");

        jRichiamaAnimali.setText("Richiama");
        jRichiamaAnimali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRichiamaAnimaliActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jPrestaAnimali, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRichiamaAnimali, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jChiudi, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPrestaAnimali, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRichiamaAnimali, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChiudi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jChiudiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChiudiActionPerformed
       setVisible(false);
        new JDirettore(utente).setVisible(true);
    }//GEN-LAST:event_jChiudiActionPerformed

    private void jPrestaAnimaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPrestaAnimaliActionPerformed
        ArrayList<Animale> list = conn.selezionaAnimaliPresenti();
        if(this.jTablePresenti.getSelectedRow()==0)
        {JOptionPane.showMessageDialog(null, "Non hai selezionato nessun animale");}
        else{
         int reply = JOptionPane.showConfirmDialog(null, "Vuoi prestare l'animale: "+this.jTablePresenti.getValueAt(this.jTablePresenti.getSelectedRow(), 0)+"?", "Confermare?", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION)
                {
                    conn.updateAnimalePresente(false, list.get(this.jTablePresenti.getSelectedRow()-1));
        setVisible(false);
         JPrestaAnimale_Direttore presanim = new JPrestaAnimale_Direttore(utente);
        presanim.setLocationRelativeTo(null);
        presanim.setVisible(true);
                }
        }
    }//GEN-LAST:event_jPrestaAnimaliActionPerformed

    private void jRichiamaAnimaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRichiamaAnimaliActionPerformed
         ArrayList<Animale> list = conn.selezionaAnimaliInPrestito();
         if(this.jTableInPrestito.getSelectedRow()==0)
        {JOptionPane.showMessageDialog(null, "Non hai selezionato nessun animale");}
        else{
        int reply = JOptionPane.showConfirmDialog(null, "Vuoi richiamare dal prestito l'animale: "+this.jTableInPrestito.getValueAt(this.jTableInPrestito.getSelectedRow(), 0)+"?", "Confermare?", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION)
                {
                    conn.updateAnimalePresente(true, list.get(this.jTableInPrestito.getSelectedRow()-1));
         setVisible(false);
         JPrestaAnimale_Direttore presanim = new JPrestaAnimale_Direttore(utente);
        presanim.setLocationRelativeTo(null);
        presanim.setVisible(true);
                }
         }
    }//GEN-LAST:event_jRichiamaAnimaliActionPerformed

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
            java.util.logging.Logger.getLogger(JPrestaAnimale_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JPrestaAnimale_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JPrestaAnimale_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JPrestaAnimale_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JPrestaAnimale_Direttore(utente).setVisible(true);
            }
        });
    }

   public void Show_AnimaliPresenti_In_JTable(JTable table)
   {
       ArrayList<Animale> list = conn.selezionaAnimaliPresenti();
      
       
       DefaultTableModel model = (DefaultTableModel) table.getModel();
       Object[] row = new Object[4];

       table.changeSelection(0, 0, false, false);
       

            for(int i = 0; i < list.size(); i++)
            {
               

               
                row[0] = list.get(i).getNome();
                row[1] = list.get(i).getSpecie();
                row[2] = list.get(i).getSesso();
                String DataNascita = list.get(i).getDataNascita().toString();
                String DataNascita_String = pz.NuovoFormatoData(DataNascita, "yyyy-MM-dd", "dd-MM-yyyy");
                row[3] = DataNascita_String;

                model.addRow(row);
            }
   }
    public void Show_AnimaliInPrestito_In_JTable(JTable table)
   {
       ArrayList<Animale> list = conn.selezionaAnimaliInPrestito();
      
       
       DefaultTableModel model = (DefaultTableModel) table.getModel();
       Object[] row = new Object[4];

       table.changeSelection(0, 0, false, false);
       

            for(int i = 0; i < list.size(); i++)
            {
               

               
                row[0] = list.get(i).getNome();
                row[1] = list.get(i).getSpecie();
                row[2] = list.get(i).getSesso();
                String DataNascita = list.get(i).getDataNascita().toString();
                String DataNascita_String = pz.NuovoFormatoData(DataNascita, "yyyy-MM-dd", "dd-MM-yyyy");
                row[3] = DataNascita_String;

                model.addRow(row);
            }
   }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jChiudi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jPrestaAnimali;
    private javax.swing.JButton jRichiamaAnimali;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableInPrestito;
    private javax.swing.JTable jTablePresenti;
    // End of variables declaration//GEN-END:variables
}
