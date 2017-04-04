/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logins;


import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.*;
import progettozoo.Animale;
import database.DBConnect;
import java.util.logging.Level;
import java.util.logging.Logger;
import progettozoo.Visita;
import progettozoo.ProgettoZoo;
import progettozoo.Utente;
import schede.JSchedaAnimale_Veterinario;

/**
 *
 * @author Alberto
 */
public class JVeterinario extends javax.swing.JFrame {

    /**
     * Creates new form JVeterinario
     */
    public String COD_AN, NOME, SPECIE, GENERE, HABITAT;
    public Date DATANASCITA;
    public boolean NOSTRO,PRESENTE,SALUTE;
    public Animale anim_sel = new Animale();
    
    public Utente user = new Utente();
    
       public String filtro_genere, filtro_specie, filtro_presente, filtro_salute, filtro_codice;
       public String DN_Da, DN_A, DUV_ORDINE;
       public String[] filtri = {filtro_genere, filtro_specie,filtro_presente, filtro_salute, filtro_codice, DN_Da, DN_A, DUV_ORDINE };
       ButtonGroup bG = new ButtonGroup();
       
       
    public JVeterinario() {
       

        initComponents();
        
    }
    
    public JVeterinario(Utente user_login, String[] filter) throws Throwable {
       
        ProgettoZoo pz = new ProgettoZoo();
        initComponents();
        
        this.jPanelFiltri.setVisible(false);
        setVisible(true);
        setTitle("Benvenuto, "+user_login.getNome()+ " " + user_login.getCognome() );
        
        user.setUsername(user_login.getUsername());
        user.setNome(user_login.getNome());
        user.setCognome(user_login.getCognome());
        user.setRuolo(user_login.getRuolo());
        
        String[] jTableAnimaliHeaders  = {"Codice Animale","Nome Animale","Specie","Data di Nascita","Genere","Ultima Visita","Salute","Presente"};
        selectmode(this.jTableAnimali);   
        creaTabella(this.jTableAnimali, jTableAnimaliHeaders);
        
        for(int i=0; i< filter.length; i++)
           filtri[i] = filter[i];
        
      
        this.jTextFieldDN_A.setEditable(false);
        Show_Animali_In_JTable(this.jTableAnimali, filtri);
        
         DBConnect conn=new DBConnect();
         ArrayList<String> list = conn.selezionaAnimaliSpecie();
        for(int i = 0; i < list.size(); i++)  
            this.jComboBoxSpecie.addItem(list.get(i));
        setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonLogout = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAnimali = new javax.swing.JTable();
        jButtonSchedaAnimale = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanelFiltri = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxGenere = new javax.swing.JComboBox<>();
        jComboBoxSpecie = new javax.swing.JComboBox<>();
        jButtonFiltra = new javax.swing.JButton();
        jComboBoxSalute = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxPresente = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldDN_Da = new javax.swing.JTextField();
        jTextFieldDN_A = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldCodAni_Filtro = new javax.swing.JTextField();
        jButtonReset_Filtri = new javax.swing.JButton();
        jRadioButtonDUV_CRE = new javax.swing.JRadioButton();
        jRadioButtonDUV_DECR = new javax.swing.JRadioButton();
        jCheckBoxFiltri = new javax.swing.JCheckBox();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(7, 9), new java.awt.Dimension(7, 9), new java.awt.Dimension(7, 9));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Veterinario");
        setResizable(false);

        jButtonLogout.setText("Logout");
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        jTableAnimali.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", "", ""},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jTableAnimali.getTableHeader().setResizingAllowed(false);
        jTableAnimali.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableAnimali);

        jButtonSchedaAnimale.setText("Scheda Animale");
        jButtonSchedaAnimale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSchedaAnimaleActionPerformed(evt);
            }
        });

        jLabel1.setText("Filtri di ricerca:");

        jLabel2.setText("Specie: ");

        jLabel3.setText("Genere:");

        jComboBoxGenere.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "M", "F" }));

        jComboBoxSpecie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        jComboBoxSpecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSpecieActionPerformed(evt);
            }
        });

        jButtonFiltra.setText("Filtra");
        jButtonFiltra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltraActionPerformed(evt);
            }
        });

        jComboBoxSalute.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SANO", "MALATO" }));

        jLabel4.setText("Presente:");

        jComboBoxPresente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SI", "NO" }));

        jLabel5.setText("Salute:");

        jLabel6.setText("Data di Nascita compresa tra:");

        jTextFieldDN_Da.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldDN_DaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldDN_DaFocusLost(evt);
            }
        });

        jTextFieldDN_A.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldDN_AFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldDN_AFocusLost(evt);
            }
        });

        jLabel7.setText("Ordina Date Ultima visita");

        jLabel8.setText("e");

        jLabel10.setText("Codice:");

        jButtonReset_Filtri.setText("Reset Filtri");
        jButtonReset_Filtri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReset_FiltriActionPerformed(evt);
            }
        });

        jRadioButtonDUV_CRE.setText("Crescente");

        jRadioButtonDUV_DECR.setText("Decrescente");

        javax.swing.GroupLayout jPanelFiltriLayout = new javax.swing.GroupLayout(jPanelFiltri);
        jPanelFiltri.setLayout(jPanelFiltriLayout);
        jPanelFiltriLayout.setHorizontalGroup(
            jPanelFiltriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiltriLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFiltriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFiltriLayout.createSequentialGroup()
                        .addGroup(jPanelFiltriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(38, 38, 38)
                        .addGroup(jPanelFiltriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxSpecie, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxGenere, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelFiltriLayout.createSequentialGroup()
                        .addGroup(jPanelFiltriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10))
                        .addGap(30, 30, 30)
                        .addGroup(jPanelFiltriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxPresente, 0, 109, Short.MAX_VALUE)
                            .addComponent(jComboBoxSalute, 0, 109, Short.MAX_VALUE)
                            .addComponent(jTextFieldCodAni_Filtro))))
                .addGap(26, 76, Short.MAX_VALUE)
                .addGroup(jPanelFiltriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFiltriLayout.createSequentialGroup()
                        .addComponent(jTextFieldDN_Da, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldDN_A, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFiltriLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFiltriLayout.createSequentialGroup()
                        .addGroup(jPanelFiltriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonDUV_CRE)
                            .addComponent(jButtonFiltra, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanelFiltriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRadioButtonDUV_DECR, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonReset_Filtri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFiltriLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(105, 105, 105))))
        );
        jPanelFiltriLayout.setVerticalGroup(
            jPanelFiltriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiltriLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFiltriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelFiltriLayout.createSequentialGroup()
                        .addGroup(jPanelFiltriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxGenere, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelFiltriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel6)))
                        .addGroup(jPanelFiltriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFiltriLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanelFiltriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBoxSpecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addGroup(jPanelFiltriLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanelFiltriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelFiltriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldDN_A, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8))
                                    .addComponent(jTextFieldDN_Da, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanelFiltriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFiltriLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanelFiltriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jComboBoxPresente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxSalute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelFiltriLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelFiltriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButtonDUV_CRE)
                                    .addComponent(jRadioButtonDUV_DECR)))))
                    .addComponent(jLabel5))
                .addGap(22, 22, 22)
                .addGroup(jPanelFiltriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFiltra)
                    .addComponent(jButtonReset_Filtri)
                    .addComponent(jTextFieldCodAni_Filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jCheckBoxFiltri.setText("Attiva/Disattiva");
        jCheckBoxFiltri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBoxFiltriMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxFiltri)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelFiltri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButtonSchedaAnimale, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButtonLogout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)))
                        .addGap(82, 82, 82))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCheckBoxFiltri))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonSchedaAnimale)
                        .addGap(44, 44, 44)
                        .addComponent(jButtonLogout)
                        .addGap(4, 4, 4)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelFiltri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        
        JLogin log = new JLogin();
        log.setLocationRelativeTo(null);
        log.setVisible(true);
        log.close(this);
    }//GEN-LAST:event_jButtonLogoutActionPerformed

    private void jButtonSchedaAnimaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSchedaAnimaleActionPerformed
        
 
        if(jTableAnimali.getSelectedRow() == -1) JOptionPane.showMessageDialog(null, "Errore: Nessuna riga selezionata", "Errore", JOptionPane.ERROR_MESSAGE);
        else{
            if(!"".equals(getTableSelectedItem(this.jTableAnimali, "Codice Animale")) )
            {
            DBConnect conn = new DBConnect();
            ProgettoZoo pz = new ProgettoZoo();
           COD_AN = getTableSelectedItem(this.jTableAnimali, "Codice Animale");
           NOME = getTableSelectedItem(this.jTableAnimali, "Nome Animale");
           SPECIE = getTableSelectedItem(this.jTableAnimali, "Specie");
           GENERE = getTableSelectedItem(this.jTableAnimali, "Genere");
           HABITAT = conn.checkAnimalHabitat(COD_AN);

           
           String DataTable = getTableSelectedItem(this.jTableAnimali, "Data di Nascita"); 
           DATANASCITA = pz.ConvertStringToDate(DataTable, "dd-MM-yyyy");
           
                      
           String salute = getTableSelectedItem(this.jTableAnimali, "Salute");
           SALUTE = "SANO".equals(salute);
           
           String presente = getTableSelectedItem(this.jTableAnimali, "Presente");
           PRESENTE = "SI".equals(presente);
              
           
           anim_sel.setId(COD_AN);
           anim_sel.setNome(NOME);
           anim_sel.setSpecie(SPECIE);
           anim_sel.setSesso(GENERE);
           anim_sel.setHabitat(HABITAT);
           anim_sel.setDataNascita(DATANASCITA);
           anim_sel.setSalute(SALUTE);
           anim_sel.setPresente(PRESENTE);
           
           setVisible(false);            
           new JSchedaAnimale_Veterinario(anim_sel,user);  
           
            }
            else JOptionPane.showMessageDialog(null, "Errore: selezionata riga nulla", "Errore", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_jButtonSchedaAnimaleActionPerformed

    private void jCheckBoxFiltriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxFiltriMouseClicked
        

            if(this.jCheckBoxFiltri.isSelected())
            {
                bG.add(this.jRadioButtonDUV_CRE);
                bG.add(this.jRadioButtonDUV_DECR);
                this.jRadioButtonDUV_CRE.setSelected(true);
                this.jPanelFiltri.setVisible(true);
            }
            else this.jPanelFiltri.setVisible(false);
        
    }//GEN-LAST:event_jCheckBoxFiltriMouseClicked

    private void jComboBoxSpecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSpecieActionPerformed
        

    }//GEN-LAST:event_jComboBoxSpecieActionPerformed

    private void jTextFieldDN_AFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDN_AFocusGained
      
        ProgettoZoo pz = new ProgettoZoo();
      boolean dat = pz.isThisDateValid(this.jTextFieldDN_Da.getText(), "dd-MM-yyyy");
      
      Date DN_DA = pz.ConvertStringToDate(this.jTextFieldDN_Da.getText(), "dd-MM-yyyy");
      Date DN_A = pz.ConvertStringToDate(this.jTextFieldDN_A.getText(), "dd-MM-yyyy");
      Date today = new Date();
      
        if(dat && DN_DA.before(today) && DN_DA.before(DN_A) ) this.jTextFieldDN_A.setText(pz.NuovoFormatoData(today.toString(), "dd-MM-yyyy", "dd-MM-yyyy"));
        if(dat && DN_DA.after(today) && DN_DA.after(DN_A)) this.jTextFieldDN_Da.setText(pz.NuovoFormatoData(today.toString(), "dd-MM-yyyy", "dd-MM-yyyy"));
   
        this.jTextFieldDN_A.selectAll();       
    }//GEN-LAST:event_jTextFieldDN_AFocusGained

    private void jTextFieldDN_DaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDN_DaFocusGained
   
         
        ProgettoZoo pz = new ProgettoZoo();
      boolean dat = pz.isThisDateValid(this.jTextFieldDN_Da.getText(), "dd-MM-yyyy");
      
      Date DN_DA = pz.ConvertStringToDate(this.jTextFieldDN_Da.getText(), "dd-MM-yyyy");
      Date DN_A = pz.ConvertStringToDate(this.jTextFieldDN_A.getText(), "dd-MM-yyyy");
      Date today = new Date();
      
        if(dat && DN_DA.after(today) && DN_DA.after(DN_A)) this.jTextFieldDN_Da.setText(pz.NuovoFormatoData(today.toString(), "dd-MM-yyyy", "dd-MM-yyyy"));
    this.jTextFieldDN_Da.selectAll();        
    }//GEN-LAST:event_jTextFieldDN_DaFocusGained

    private void jButtonFiltraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltraActionPerformed
        
       
        setVisible(false);    
        
           filtri[0] = this.jComboBoxGenere.getSelectedItem().toString();
           filtri[1] = this.jComboBoxSpecie.getSelectedItem().toString();
           filtri[2] = this.jComboBoxPresente.getSelectedItem().toString();
           filtri[3] = this.jComboBoxSalute.getSelectedItem().toString();
           filtri[4] = this.jTextFieldCodAni_Filtro.getText();
           filtri[5] = this.jTextFieldDN_Da.getText();
           filtri[6] = this.jTextFieldDN_A.getText();
           if(this.jRadioButtonDUV_CRE.isSelected()) filtri[7] = "DUV_CRESCENTE";
           if(this.jRadioButtonDUV_DECR.isSelected()) filtri[7] = "DUV_DECRESCENTE";
           
           
        try {
            new JVeterinario(user, filtri);
        } catch (Throwable ex) {
            Logger.getLogger(JVeterinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonFiltraActionPerformed

    private void jTextFieldDN_DaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDN_DaFocusLost
      
      ProgettoZoo pz = new ProgettoZoo();
      boolean dat = pz.isThisDateValid(this.jTextFieldDN_Da.getText(), "dd-MM-yyyy");
      
      Date DN_DA = pz.ConvertStringToDate(this.jTextFieldDN_Da.getText(), "dd-MM-yyyy");
      Date DN_A = pz.ConvertStringToDate(this.jTextFieldDN_A.getText(), "dd-MM-yyyy");
      Date today = new Date(); 
      Date limite_inf = pz.ConvertStringToDate("01-01-1900", "dd-MM-yyyy");
      
      if(dat && DN_DA.before(today) && DN_DA.before(DN_A) && DN_DA.after(limite_inf)){
          this.jTextFieldDN_A.setEditable(true);
      }
      else {
          this.jTextFieldDN_Da.setText("");
          this.jTextFieldDN_A.setEditable(false);
      }
           if(!dat) this.jTextFieldDN_A.setText("");
    }//GEN-LAST:event_jTextFieldDN_DaFocusLost

    private void jTextFieldDN_AFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDN_AFocusLost
        
        if(this.jTextFieldDN_A.getText().equals("")) {
            this.jTextFieldDN_Da.setText("");
        
          this.jTextFieldDN_A.setEditable(false);}
    }//GEN-LAST:event_jTextFieldDN_AFocusLost

    private void jButtonReset_FiltriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReset_FiltriActionPerformed
        
        this.jComboBoxGenere.setSelectedIndex(0);
        this.jComboBoxSpecie.setSelectedIndex(0);
        this.jComboBoxSalute.setSelectedIndex(0);
        this.jComboBoxPresente.setSelectedIndex(0);
        this.jTextFieldCodAni_Filtro.setText("");
        this.jTextFieldDN_Da.setText("");
        this.jTextFieldDN_A.setText("");
        this.jTextFieldDN_A.setEditable(false);
    }//GEN-LAST:event_jButtonReset_FiltriActionPerformed
    
    //Restituisce il valore di una certa colonna di una tabella in base alla riga selezionata.
    public String getTableSelectedItem(JTable table, String item)
    {
        String selezione = "";
        int stop = -1;
        ArrayList jTableHeaders = new ArrayList();
        for(int i=0; i<table.getColumnCount(); i++)
        {  
            jTableHeaders.add(i,table.getColumnName(i));         
            if( jTableHeaders.contains(item)){
                    stop = i;
                    selezione = getTableValue(table, i);
                    return selezione;
                }
        }
        if(stop == -1) {
            JOptionPane.showMessageDialog(null, "INDICE TABELLA NON TROVATO", "Errore", JOptionPane.ERROR_MESSAGE);}
        return selezione;
    }

public void selectmode(JTable table)
{
    //SET SELECTION MODE
    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
}   

//ritorna il valore della colonna i-esima della riga selezionata nella tabella
    public String getTableValue(JTable table, int column)
    {
        int row = table.getSelectedRow();
        String value = table.getModel().getValueAt(row, column).toString();
        return value;
    }
    
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
            java.util.logging.Logger.getLogger(JVeterinario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JVeterinario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JVeterinario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JVeterinario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        /* Create and display the form */
            
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JVeterinario().setVisible(true);
            }
        });
    }
    
    //Crea una tabella non modificabile tranne che per la colonna ultima visita
    /*
    Ho fatto così perchè se andavo a modificare la tabella attraverso custom code
    cambiando il valore tornato da isCellEditable(i,c) la tabella diventava invisibile.
    */
    public void creaTabella(JTable table,String[] columnHeaders){
        Object[][] data = {
            {"","","","","","","","",""},
        };
        
        DefaultTableModel tableModel = new DefaultTableModel(data, columnHeaders)
        {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false, false //messo così per ricordarmi come si fa per ogni singola cella
            };
            
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
    table.setModel(tableModel);
    }
        
    @SuppressWarnings("empty-statement")
   public void Show_Animali_In_JTable(JTable table, String[] Filtri) throws Throwable
   {
       DBConnect conn = new DBConnect();
       ProgettoZoo pz = new ProgettoZoo();          
       
       ArrayList<Animale> list = new ArrayList<>();
       if(user.getRuolo().equals("Veterinario")) list = conn.animaliList(filtri);
       else list = conn.animaliList(Filtri);
       
       DefaultTableModel model = (DefaultTableModel) table.getModel();
       Object[] row = new Object[8];

       table.changeSelection(0, 0, false, false);
       if(user.getRuolo().equals("Veterinario"))
       {
           pz.quicksortTAB_ANIM(list, 0, list.size()-1, filtri[7]);
       }
    
            for(int i = 0; i < list.size(); i++)
            {
                ArrayList<Visita> visList = conn.visitaList(list.get(i).getId());

                row[0] = list.get(i).getId();
                row[1] = list.get(i).getNome();
                row[2] = list.get(i).getSpecie();
                
                String DataNascita = list.get(i).getDataNascita().toString();
                String DataNascita_String = pz.NuovoFormatoData(DataNascita, "yyyy-MM-dd", "dd-MM-yyyy");
                row[3] = DataNascita_String;
                row[4] = list.get(i).getSesso();


                if( !visList.isEmpty()){
                    String DUV = visList.get(0).getDUV(list.get(i).getId()).toString();
                    String DUV_String = pz.NuovoFormatoData(DUV, "yyyy-MM-dd", "dd-MM-yyyy");
                    row[5] =  DUV_String;
                }
                else row[5] =  "MAI VISITATO";
                /*
                get(0) perchè la data dell'ultima visita viene registrata ogni volta con un solo elemento
                quindi se metto indice i non va bene perchè altrimenti avanza nella lista in elementi non esistenti
                */

                if(list.get(i).getSalute() == true ) row[6] = "SANO";
                else row[6] = "MALATO";

                if(list.get(i).getPresente() == true ) row[7] = "SI";
                else row[7] = "NO";

                model.addRow(row);
            }
            conn.close();
        
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButtonFiltra;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonReset_Filtri;
    private javax.swing.JButton jButtonSchedaAnimale;
    private javax.swing.JCheckBox jCheckBoxFiltri;
    private javax.swing.JComboBox<String> jComboBoxGenere;
    private javax.swing.JComboBox<String> jComboBoxPresente;
    private javax.swing.JComboBox<String> jComboBoxSalute;
    private javax.swing.JComboBox<String> jComboBoxSpecie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanelFiltri;
    private javax.swing.JRadioButton jRadioButtonDUV_CRE;
    private javax.swing.JRadioButton jRadioButtonDUV_DECR;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTableAnimali;
    private javax.swing.JTextField jTextFieldCodAni_Filtro;
    private javax.swing.JTextField jTextFieldDN_A;
    private javax.swing.JTextField jTextFieldDN_Da;
    // End of variables declaration//GEN-END:variables
}
