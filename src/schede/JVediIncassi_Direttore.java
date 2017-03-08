/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schede;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import logins.JDirettore;
import logins.JVeterinario;
import progettozoo.DBConnect;
import progettozoo.Prodotto;
import progettozoo.ProgettoZoo;
import progettozoo.Utente;
import progettozoo.Vende;
import static schede.JAggiungiAnimale_Direttore.check;


/**
 *
 * @author Roberto
 */
public class JVediIncassi_Direttore extends javax.swing.JFrame {
    public static Utente utente = new Utente();
    /**
     * Creates new form JVediIncassi_Direttore
     */
    public JVediIncassi_Direttore(Utente user_log) {
        initComponents();
        utente.setUsername(user_log.getUsername());
        utente.setNome(user_log.getNome());
        utente.setCognome(user_log.getCognome());
       this.jInternalFrameTableIncassi.setVisible(false);
   
      this.jTableIncassi.getTableHeader().setVisible(false);
       this.jTableIncassi.setVisible(false);
        
       this.jLabel1.setVisible(false);
       this.jTextField1.setVisible(false);
       pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jChiudi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jdataincassi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jConferma = new javax.swing.JButton();
        jInternalFrameTableIncassi = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableIncassi = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jChiudi.setText("Chiudi");
        jChiudi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChiudiActionPerformed(evt);
            }
        });

        jLabel1.setText("    TOTALE:");

        jdataincassi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdataincassiActionPerformed(evt);
            }
        });

        jLabel2.setText("                DI QUALE DATA VUOI VEDERE L'INCASSO? ");

        jConferma.setText("Conferma");
        jConferma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConfermaActionPerformed(evt);
            }
        });

        jInternalFrameTableIncassi.setVisible(true);

        jTableIncassi.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableIncassi.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTableIncassi);

        javax.swing.GroupLayout jInternalFrameTableIncassiLayout = new javax.swing.GroupLayout(jInternalFrameTableIncassi.getContentPane());
        jInternalFrameTableIncassi.getContentPane().setLayout(jInternalFrameTableIncassiLayout);
        jInternalFrameTableIncassiLayout.setHorizontalGroup(
            jInternalFrameTableIncassiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrameTableIncassiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jInternalFrameTableIncassiLayout.setVerticalGroup(
            jInternalFrameTableIncassiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrameTableIncassiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                                .addGap(38, 38, 38))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jdataincassi)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jConferma, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jChiudi, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)))
                        .addComponent(jInternalFrameTableIncassi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(jdataincassi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jConferma, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jChiudi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jInternalFrameTableIncassi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1))
                .addGap(109, 109, 109))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jChiudiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChiudiActionPerformed
       setVisible(false);
       new JDirettore(utente).setVisible(true);
    }//GEN-LAST:event_jChiudiActionPerformed

    private void jdataincassiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdataincassiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jdataincassiActionPerformed

    private void jConfermaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConfermaActionPerformed
        DBConnect conn =new DBConnect();
        ProgettoZoo pz= new ProgettoZoo();
        JVeterinario v=new JVeterinario();
        Date today=new Date();
      
        
        ArrayList<Vende> venlist=new ArrayList<Vende>();
        String data=this.jdataincassi.getText();
        String fordata ="(0[1-9]|1[0-9]|2[0-9]|3[01])[-](0[1-9]|1[0-2])[-](19|20)[0-9]{2}";
        String fordata2 ="(0[1-9]|1[0-9]|2[0-9]|3[01])[/](0[1-9]|1[0-2])[/](19|20)[0-9]{2}";
        Pattern pattern = Pattern.compile(fordata);
        Pattern pattern2 = Pattern.compile(fordata2);
         boolean dat=check(fordata,data);
         boolean dat2=check(fordata2,data);
         
          Date d= new Date();
   Date d1= pz.ConvertStringToDate(data,"dd-MM-yyyy");
   Date d2= pz.ConvertStringToDate(data,"dd/MM/yyyy");
   
   if(dat)
   {d=d1;}
   else if(dat2)
   {d=d2;}
        java.sql.Date sqlDate = new java.sql.Date(d.getTime());
        if(!(dat || dat2))
              {  
        this.jInternalFrameTableIncassi.setVisible(false);
   
      this.jTableIncassi.getTableHeader().setVisible(false);
       this.jTableIncassi.setVisible(false);
        
       this.jLabel1.setVisible(false);
       this.jTextField1.setVisible(false);
       pack();
       JOptionPane.showMessageDialog(null, "CARATTERI NON VALIDI");}
        else if(data.isEmpty())
       {  
        this.jInternalFrameTableIncassi.setVisible(false);
   
      this.jTableIncassi.getTableHeader().setVisible(false);
       this.jTableIncassi.setVisible(false);
        
       this.jLabel1.setVisible(false);
       this.jTextField1.setVisible(false);
       pack();
       JOptionPane.showMessageDialog(null, "DEVI INSERIRE UNA DATA");}
       else if(d.after(today))
           {  
        this.jInternalFrameTableIncassi.setVisible(false);
   
      this.jTableIncassi.getTableHeader().setVisible(false);
       this.jTableIncassi.setVisible(false);
        
       this.jLabel1.setVisible(false);
       this.jTextField1.setVisible(false);
       pack();
       JOptionPane.showMessageDialog(null, "NON PUOI INSERIRE UNA DATA FUTURA");} 
       
       
       else{
       
      
            venlist=conn.getIncassi(conn.selezionaProdVenduti(),sqlDate);
             if (venlist.isEmpty())
       {
             this.jInternalFrameTableIncassi.setVisible(false);
   
      this.jTableIncassi.getTableHeader().setVisible(false);
       this.jTableIncassi.setVisible(false);
        
       this.jLabel1.setVisible(false);
       this.jTextField1.setVisible(false);
       pack();
           JOptionPane.showMessageDialog(null, "NON E' STATO VENDUTO NESSUN PRODOTTO IN QUELLA DATA");}
             else{
                        this.jTableIncassi.getTableHeader().setVisible(true);
        this.jTableIncassi.setVisible(true);
       this.jLabel1.setVisible(true);
       this.jTextField1.setVisible(true);
       this.jInternalFrameTableIncassi.setVisible(true);
       
       pack();
          this.jTableIncassi.getTableHeader().setReorderingAllowed(false);
           String[] jTableAnimaliHeaders  = {"Nome Prodotto","Quantità","Ricavi"};
        v.selectmode(this.jTableIncassi);   
        v.creaTabella(this.jTableIncassi, jTableAnimaliHeaders);
        this.jTableIncassi.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        Show_Incassi_In_JTable(this.jTableIncassi,sqlDate);
        Double totale=conn.totaleIncassi(venlist);
        this.jTextField1.setText(totale.toString());
             }
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
            java.util.logging.Logger.getLogger(JVediIncassi_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JVediIncassi_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JVediIncassi_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JVediIncassi_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JVediIncassi_Direttore(utente).setVisible(true);
            }
        });
    }
 public void Show_Incassi_In_JTable(JTable table,Date data)
   {
       ProgettoZoo pz=new ProgettoZoo();
       DBConnect conn=new DBConnect();
       ArrayList<String> prodlist=conn.selezionaProdVenduti();
      
       ArrayList<Vende> venlist = conn.getIncassi(prodlist,data);
       DefaultTableModel model = (DefaultTableModel) table.getModel();
       Object[] row = new Object[3];
       
       
        table.changeSelection(0, 0, false, false);
       for(int i = 0; i < venlist.size(); i++)
       {
     
           row[0] = venlist.get(i).getCod_Prodotto();
           
           row[1] = venlist.get(i).getQuantita();
           
           row[2] = venlist.get(i).getRicavi();
         
           model.addRow(row);
           
       }
   }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jChiudi;
    private javax.swing.JButton jConferma;
    private javax.swing.JInternalFrame jInternalFrameTableIncassi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableIncassi;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jdataincassi;
    // End of variables declaration//GEN-END:variables
}
