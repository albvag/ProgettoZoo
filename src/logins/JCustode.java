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
import database.DBConnect;
import progettozoo.Pasto;
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
     * Crea nuova form JCustode
     */
    public JCustode() {
        initComponents();
    }
    /**
     * Crea nuova form JCustode e salva dati dell'utente
     */
    
     public JCustode(Utente user_login) {
        initComponents();
        
        setVisible(true);
        
        this.jTerminaCompito.setVisible(false);
        this.jAnnullaCompito.setVisible(false);
        this.jRichiestaAiuto.setVisible(false);
        setTitle("Benvenuto, "+user_login.getNome()+ " " + user_login.getCognome() );
        
        user.setUsername(user_login.getUsername());
        user.setNome(user_login.getNome());
        user.setCognome(user_login.getCognome());
        
        String[] jTablePulizieHeaders  = {"Habitat"};
        String[] jTableAiutiHeaders  = {"Habitat"};
        String[] jTablePastiHeaders  = {"Habitat","Tipo"};
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
        
        if(conn.stoPulendo( user)|| conn.stoNutrendo(user)){
            this.jLabelCompito.setText("Hai un compito");
            this.jNutrireFrame.setVisible(false);
            this.jPulizieFrame.setVisible(false);
            this.jAnnullaCompito.setVisible(true);
            this.jTerminaCompito.setVisible(true);
            
            
            if(conn.stoPulendo( user)){
                if(conn.attualePulizia(user).getServeAiuto()){
                    this.JAccettaRichiestaAiuto.setVisible(false);
                    this.jAiutoLabel.setText("è stato richiesto aiuto per questa pulizia");
                }else if(conn.numeroCustodiInPulizia(conn.attualePulizia(user))==3) {
                    this.JAccettaRichiestaAiuto.setVisible(false);
                    this.jAiutoLabel.setText("raggiunto limite massimo di custodi per questa pulizia");
                }else this.jRichiestaAiuto.setVisible(true);
                    this.jTipoCompito.setText("Devi pulire l'habitat : "+conn.attualePulizia(user).getCodice_Gabbia());   
            }else if(conn.stoNutrendo(user)){
                this.jTipoCompito.setText("Devi portare cibo all'habitat : "+conn.attualePasto(user).getCodice_Gabbia());   
            }
        }else this.jLabelCompito.setText("Scegli un compito");
        this.jLogout.setVisible(true);
        
        this.jPasti.getTableHeader().setReorderingAllowed(false);
        this.jPasti.getTableHeader().setResizingAllowed(false);
        this.jTablePulizie.getTableHeader().setReorderingAllowed(false);
        this.jTablePulizie.getTableHeader().setResizingAllowed(false);
        this.jTableAiuti.getTableHeader().setReorderingAllowed(false);
        this.jTableAiuti.getTableHeader().setResizingAllowed(false);
        
        pack();
        setLocationRelativeTo(null);
    }
    
    /**
     * Riempie una JTable con le pulizie del giorno ancora disponibili
     */ 
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
    
    /**
     * Riempie una JTable con le pulizie in cui è stato richiesto aiuto
     */ 
       public final void Show_Aiuti_In_JTable(JTable table)
    {
       ArrayList<Pulizia> list = conn.listRichiesteAiuto();
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
     * Riempe una JTable con i pasti del giorno
     */    
    public void Show_Pasti_In_JTable(JTable table)
    {
       ArrayList<Pasto> list = conn.listaPastiDisponibili();
       DefaultTableModel model = (DefaultTableModel) table.getModel();
       Object[] row = new Object[2];
       
       table.changeSelection(0, 0, false, false);
       for(int i = 0; i < list.size(); i++)
       {
     
           row[0] = list.get(i).getCodice_Gabbia();
           
           String pasto;
           if(list.get(i).getData_Pasto().getHours()== 12){
               pasto = "Pranzo";
           }else{
               pasto= "Cena";
           }
           
           row[1] = pasto;
           
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
        jNutrireFrame = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPasti = new javax.swing.JTable();
        jAccettaNutri = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPulizieFrame = new javax.swing.JInternalFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePulizie = new javax.swing.JTable();
        JAccettaRichiestaAiuto = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableAiuti = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JAccettaPulizia = new javax.swing.JButton();
        jLogout = new javax.swing.JButton();
        jLabelCompito = new javax.swing.JLabel();
        jTipoCompito = new javax.swing.JLabel();
        jTerminaCompito = new javax.swing.JButton();
        jRichiestaAiuto = new javax.swing.JButton();
        jAnnullaCompito = new javax.swing.JButton();
        jAiutoLabel = new javax.swing.JLabel();
        jAggiorna = new javax.swing.JButton();

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

        jNutrireFrame.setVisible(true);

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

        jLabel4.setText("PASTI DISPONIBILI");

        javax.swing.GroupLayout jNutrireFrameLayout = new javax.swing.GroupLayout(jNutrireFrame.getContentPane());
        jNutrireFrame.getContentPane().setLayout(jNutrireFrameLayout);
        jNutrireFrameLayout.setHorizontalGroup(
            jNutrireFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jNutrireFrameLayout.createSequentialGroup()
                .addGroup(jNutrireFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jNutrireFrameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jNutrireFrameLayout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jAccettaNutri)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jNutrireFrameLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(156, 156, 156))
        );
        jNutrireFrameLayout.setVerticalGroup(
            jNutrireFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jNutrireFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jAccettaNutri)
                .addContainerGap())
        );

        jPulizieFrame.setVisible(true);

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

        JAccettaRichiestaAiuto.setText("Aiuta");
        JAccettaRichiestaAiuto.setActionCommand("Aiuta");
        JAccettaRichiestaAiuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JAccettaRichiestaAiutoActionPerformed(evt);
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

        jLabel2.setText("PULIZIE DISPONIBILI");

        jLabel3.setText("RICHIESTE AIUTO");

        JAccettaPulizia.setText("Accetta Pulizia");
        JAccettaPulizia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JAccettaPuliziaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPulizieFrameLayout = new javax.swing.GroupLayout(jPulizieFrame.getContentPane());
        jPulizieFrame.getContentPane().setLayout(jPulizieFrameLayout);
        jPulizieFrameLayout.setHorizontalGroup(
            jPulizieFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPulizieFrameLayout.createSequentialGroup()
                .addGroup(jPulizieFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPulizieFrameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPulizieFrameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPulizieFrameLayout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel2))
                    .addGroup(jPulizieFrameLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(jPulizieFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JAccettaPulizia)
                            .addComponent(jLabel3)))
                    .addGroup(jPulizieFrameLayout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(JAccettaRichiestaAiuto)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPulizieFrameLayout.setVerticalGroup(
            jPulizieFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPulizieFrameLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JAccettaPulizia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JAccettaRichiestaAiuto)
                .addContainerGap())
        );

        jLogout.setText("Logout");
        jLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogoutActionPerformed(evt);
            }
        });

        jTerminaCompito.setText("Termina");
        jTerminaCompito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTerminaCompitoActionPerformed(evt);
            }
        });

        jRichiestaAiuto.setText("Richiedi Aiuto");
        jRichiestaAiuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRichiestaAiutoActionPerformed(evt);
            }
        });

        jAnnullaCompito.setText("Annulla");
        jAnnullaCompito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAnnullaCompitoActionPerformed(evt);
            }
        });

        jAggiorna.setText("Aggiorna");
        jAggiorna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAggiornaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPulizieFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabelCompito, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jAggiorna, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jAiutoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jTipoCompito, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5)
                        .addComponent(jNutrireFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTerminaCompito, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jAnnullaCompito, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRichiestaAiuto, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jNutrireFrame)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabelCompito, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTipoCompito, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jAiutoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jAnnullaCompito, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTerminaCompito, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jRichiestaAiuto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAggiorna, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPulizieFrame)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLogoutActionPerformed

        JLogin log = new JLogin();
        log.setLocationRelativeTo(null);
        log.setVisible(true);
        log.close(this);
    }//GEN-LAST:event_jLogoutActionPerformed

    private void jAccettaNutriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAccettaNutriActionPerformed
        
        if(this.jPasti.getSelectedRow()==0){
            JOptionPane.showMessageDialog(null, "DEVI SELEZIONARE UN COMPITO");
        }else {
            String specie = this.jPasti.getValueAt(this.jPasti.getSelectedRow(), 0).toString();
                if(specie.equals(conn.listaPastiDisponibili().get(this.jPasti.getSelectedRow()-1).getCodice_Gabbia())){
                   conn.accettaPasto(conn.listaPastiDisponibili().get(this.jPasti.getSelectedRow()-1), user);
                }else JOptionPane.showMessageDialog(null, "IL COMPITO SELEZIONATO È GIÀ STATO ASSEGNATO \n SELEZIONARNE UN ALTRO");
            
            setVisible(false); 
            JCustode cus = new JCustode(user);
        }
    }//GEN-LAST:event_jAccettaNutriActionPerformed

    private void JAccettaRichiestaAiutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JAccettaRichiestaAiutoActionPerformed
        
        if(this.jTableAiuti.getSelectedRow() ==0){
            JOptionPane.showMessageDialog(null, "DEVI SELEZIONARE UN COMPITO");
        }else {
                String specie = this.jTableAiuti.getValueAt(this.jTableAiuti.getSelectedRow(), 0).toString();
                if(specie.equals(conn.listRichiesteAiuto().get(this.jTableAiuti.getSelectedRow()-1).getCodice_Gabbia())){
                    conn.accettaPulizia(conn.listRichiesteAiuto().get(this.jTableAiuti.getSelectedRow()-1), user);
                }else JOptionPane.showMessageDialog(null, "IL COMPITO SELEZIONATO È GIÀ STATO ASSEGNATO \n SELEZIONARNE UN ALTRO");
            
            
            setVisible(false); 
            JCustode cus = new JCustode(user);
        }
    }//GEN-LAST:event_JAccettaRichiestaAiutoActionPerformed

    private void jTerminaCompitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTerminaCompitoActionPerformed
       int reply =JOptionPane.showConfirmDialog(null,"Hai teminato il tuo compito ?","Conferma?" , JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION){
            conn.terminaCompito(user);
            setVisible(false);
            JCustode cus = new JCustode(user);
            cus.setVisible(true);
        }
    }//GEN-LAST:event_jTerminaCompitoActionPerformed

    private void jAnnullaCompitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAnnullaCompitoActionPerformed
        int reply =JOptionPane.showConfirmDialog(null,"Vuoi annullare il tuo compito ?","Conferma?" , JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION){
            conn.annullaCompito(user);
            setVisible(false);
            JCustode cus = new JCustode(user);
            cus.setVisible(true);
        }
    }//GEN-LAST:event_jAnnullaCompitoActionPerformed

    private void JAccettaPuliziaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JAccettaPuliziaActionPerformed
        
        if(this.jTablePulizie.getSelectedRow()==0){
            JOptionPane.showMessageDialog(null, "DEVI SELEZIONARE UN COMPITO");
        }else {
            String specie = this.jTablePulizie.getValueAt(this.jTablePulizie.getSelectedRow(), 0).toString();
                if(specie.equals(conn.listPulizieDisponibili().get(this.jTablePulizie.getSelectedRow()-1).getCodice_Gabbia())){
                    conn.accettaPulizia(conn.listPulizieDisponibili().get(this.jTablePulizie.getSelectedRow()-1), user);
                }else JOptionPane.showMessageDialog(null, "IL COMPITO SELEZIONATO È GIÀ STATO ASSEGNATO \n SELEZIONARNE UN ALTRO");
            
            setVisible(false); 
            JCustode cus = new JCustode(user);
        }
    }//GEN-LAST:event_JAccettaPuliziaActionPerformed

    private void jRichiestaAiutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRichiestaAiutoActionPerformed
        
        conn.richiediAiutoPulizia(conn.attualePulizia(user));
        setVisible(false);
        JCustode cus = new JCustode(user);
    }//GEN-LAST:event_jRichiestaAiutoActionPerformed

    private void jAggiornaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAggiornaActionPerformed
        setVisible(false);
        JCustode cus = new JCustode(user);
    }//GEN-LAST:event_jAggiornaActionPerformed

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
    private javax.swing.JButton JAccettaPulizia;
    private javax.swing.JButton JAccettaRichiestaAiuto;
    private javax.swing.JButton jAccettaNutri;
    private javax.swing.JButton jAggiorna;
    private javax.swing.JLabel jAiutoLabel;
    private javax.swing.JButton jAnnullaCompito;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelCompito;
    private javax.swing.JButton jLogout;
    private javax.swing.JInternalFrame jNutrireFrame;
    private javax.swing.JTable jPasti;
    private javax.swing.JInternalFrame jPulizieFrame;
    private javax.swing.JButton jRichiestaAiuto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableAiuti;
    private javax.swing.JTable jTablePulizie;
    private javax.swing.JButton jTerminaCompito;
    private javax.swing.JLabel jTipoCompito;
    // End of variables declaration//GEN-END:variables

   
}
