/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package schede;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import logins.JDirettore;
import logins.JVeterinario;
import progettozoo.DBConnect;
import progettozoo.Pasto;
import progettozoo.ProgettoZoo;
import progettozoo.Utente;
import static schede.JAggiungiAnimale_Direttore.check;

/**
 *
 * @author Roberto
 */
public class JControlloPasti_Direttore extends javax.swing.JFrame {
     public static Utente utente = new Utente();
     DBConnect conn= new DBConnect();
     ProgettoZoo pz= new ProgettoZoo();
     JVeterinario v= new JVeterinario();
    /** Creates new form JControlloPasti_Direttore */
    public JControlloPasti_Direttore( Utente user_log) {
        initComponents();
        utente.setUsername(user_log.getUsername());
        utente.setNome(user_log.getNome());
        utente.setCognome(user_log.getCognome());
        this.jTablePasti.setVisible(false);
        this.jTablePasti.getTableHeader().setReorderingAllowed(false);
        this.jTablePasti.getTableHeader().setResizingAllowed(false);
       pack();
       setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jseldata = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jConferma = new javax.swing.JButton();
        jChiudi = new javax.swing.JButton();
        jInternalFrameTablePasti = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePasti = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("                        INSERISCI DATA:");

        jConferma.setText("Conferma");
        jConferma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConfermaActionPerformed(evt);
            }
        });

        jChiudi.setText("Chiudi");
        jChiudi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChiudiActionPerformed(evt);
            }
        });

        jInternalFrameTablePasti.setVisible(true);

        jTablePasti.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTablePasti);

        javax.swing.GroupLayout jInternalFrameTablePastiLayout = new javax.swing.GroupLayout(jInternalFrameTablePasti.getContentPane());
        jInternalFrameTablePasti.getContentPane().setLayout(jInternalFrameTablePastiLayout);
        jInternalFrameTablePastiLayout.setHorizontalGroup(
            jInternalFrameTablePastiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrameTablePastiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrameTablePastiLayout.setVerticalGroup(
            jInternalFrameTablePastiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrameTablePastiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jConferma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addComponent(jChiudi, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jseldata)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jInternalFrameTablePasti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jseldata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jConferma)
                            .addComponent(jChiudi)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jInternalFrameTablePasti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jChiudiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChiudiActionPerformed
     setVisible(false);  
     new JDirettore(utente).setVisible(true);
    }//GEN-LAST:event_jChiudiActionPerformed

    private void jConfermaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConfermaActionPerformed
       
        String data =this.jseldata.getText();
         String fordata ="(0[1-9]|1[0-9]|2[0-9]|3[01])[-](0[1-9]|1[0-2])[-](19|20)[0-9]{2}";
        String fordata2 ="(0[1-9]|1[0-9]|2[0-9]|3[01])[/](0[1-9]|1[0-2])[/](19|20)[0-9]{2}";
        Pattern pattern = Pattern.compile(fordata);
        Pattern pattern2 = Pattern.compile(fordata2);
         boolean dat=check(fordata,data);
         boolean dat2=check(fordata2,data);
        
                 Date d= new Date();
                 Date today=new Date();
   Date d1= pz.ConvertStringToDate(data,"dd-MM-yyyy");
   Date d2= pz.ConvertStringToDate(data,"dd/MM/yyyy");
   
   if(dat)
   {d=d1;}
   else if(dat2)
   {d=d2;}
          java.sql.Date sqlDate = new java.sql.Date(d.getTime());
       
          if(data.isEmpty())
       {  
        this.jInternalFrameTablePasti.setVisible(false);
       pack();
       JOptionPane.showMessageDialog(null, "DEVI INSERIRE UNA DATA");}
          else if(!(dat || dat2))
              {  
        this.jInternalFrameTablePasti.setVisible(false);
       pack();
       JOptionPane.showMessageDialog(null, "CARATTERI NON VALIDI");}

       else if(d.after(today))
           {  
        this.jInternalFrameTablePasti.setVisible(false);
       pack();
       JOptionPane.showMessageDialog(null, "NON PUOI INSERIRE UNA DATA FUTURA");} 
       
       else{
            ArrayList<Pasto> listaPasti = new ArrayList<Pasto>();
       Utente[] utlist=conn.getPasti(sqlDate, listaPasti);
           if(listaPasti.isEmpty())
           {
                this.jInternalFrameTablePasti.setVisible(false);
       pack();
       JOptionPane.showMessageDialog(null, "NON CI SONO PASTI IN QUELLA DATA"); 
           }    else{
            this.jTablePasti.getTableHeader().setReorderingAllowed(false);
           String[] jTableAnimaliHeaders  = {"Pasto","Custode","Disponibile","Terminato"};
        v.selectmode(this.jTablePasti);   
        v.creaTabella(this.jTablePasti, jTableAnimaliHeaders);
        this.jTablePasti.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        Show_ControlloPasti_In_JTable(this.jTablePasti,sqlDate);
        this.jInternalFrameTablePasti.setVisible(true);
        pack();
        setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(JControlloPasti_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JControlloPasti_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JControlloPasti_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JControlloPasti_Direttore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JControlloPasti_Direttore(utente).setVisible(true);
            }
        });
    }
   public void Show_ControlloPasti_In_JTable(JTable table,Date data)
   {
      
       ArrayList<Pasto> listaPasti = new ArrayList<Pasto>();
       Utente[] utlist=conn.getPasti(data, listaPasti);
       DefaultTableModel model = (DefaultTableModel) table.getModel();
       Object[] row = new Object[4];
       
        table.changeSelection(0, 0, false, false);
       for(int i = 0; i < listaPasti.size(); i++)
       {
           String time="";

           if(listaPasti.get(i).getData_Pasto().getHours()< 19)
           {time="Pranzo";}
           else time="Cena";
           row[0] = time+" "+listaPasti.get(i).getCodice_Gabbia();
           
           row[1] = utlist[i].getNome()+" "+utlist[i].getCognome();
           
            String disp="";
           if(listaPasti.get(i).getDisponibile())
           {
             disp="NON INIZIATO";
           }else{disp="INIZIATO";}
           row[2] = disp;
           
           String term="";
           if(listaPasti.get(i).getTerminato())
           {
             term="TERMINATO";
           }else{term="NON TERMINATO";}
           row[3] = term;
           
           model.addRow(row);
           
       }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jChiudi;
    private javax.swing.JButton jConferma;
    private javax.swing.JInternalFrame jInternalFrameTablePasti;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePasti;
    private javax.swing.JTextField jseldata;
    // End of variables declaration//GEN-END:variables

}
