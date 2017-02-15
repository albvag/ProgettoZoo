/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schede;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ButtonGroup;
;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import progettozoo.DBConnect;
import logins.JVeterinario;
import progettozoo.Animale;
import progettozoo.ProgettoZoo;
import progettozoo.Utente;
import progettozoo.Visita;


/**
 *
 * @author Alberto
 * 
 * ATTENZIONE! QUANDO I FRAME VENGONO RICARICATI, ALL'UTENTE HO RIASSEGNATO SOLO USERNAME, NOME E COGNOME. DEVO COMPLETARE
 * 
 */

public class JSchedaAnimale_Veterinario extends javax.swing.JFrame {

    /** 
     * Creates new form JSchedaAnimale_Veterinario
     */
        DBConnect conn = new DBConnect();
        public Utente utente = new Utente();
        public Animale anim = new Animale();
        public Visita vis = new Visita();  
       
        public String[] filters = new String[9];
     ButtonGroup bG = new ButtonGroup();
     
    public JSchedaAnimale_Veterinario() {
        initComponents();        
       
        JVeterinario v = new JVeterinario();
        String[] jTableVisiteHeaders  = {"Data Visite","Note Visite","Veterinario"};
        v.creaTabella(this.jTableVisite, jTableVisiteHeaders); 
        v.selectmode(this.jTableVisite); 
     
        
        System.out.println(this.jTableVisite.getTableHeader());

    }
        
    public JSchedaAnimale_Veterinario(Animale anim_sel, Utente user_log) {
        initComponents();      
        utente.setUsername(user_log.getUsername());
        utente.setNome(user_log.getNome());
        utente.setCognome(user_log.getCognome());
        setLocationRelativeTo(null);
         setSize(900, 550);
        setTitle("Scheda Animale");
        setVisible(true); 
        this.jFrameVisita.setVisible(false);
        
        
        JVeterinario v = new JVeterinario();
        String[] jTableVisiteHeaders  = {"Data Visite","Note Visite","Veterinario"};
        v.creaTabella(this.jTableVisite, jTableVisiteHeaders); 
        v.selectmode(this.jTableVisite);      
        
        Show_DateVisite_In_JTable(anim_sel.getId());
          
            this.jLabelDisplayCod.setText(anim_sel.getId());
            this.jLabelDisplayNome.setText(anim_sel.getNome());
            this.jLabelDisplaySpecie.setText(anim_sel.getSpecie());
            this.jLabelDisplayGenere.setText(anim_sel.getSesso());
            this.jLabelDisplayHabitat.setText(anim_sel.getHabitat());
          
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            jLabelDisplayNascita.setText(sdf.format(anim_sel.getDataNascita()));
            
            if(anim_sel.getSalute() ) this.jLabelDisplaySalute.setText("SANO");
            else this.jLabelDisplaySalute.setText("MALATO");
            
            if(anim_sel.getPresente() ) this.jLabelDisplayPresente.setText("SI");
            else  this.jLabelDisplayPresente.setText("NO");
            
            String CODICE = anim_sel.getId();
            String NOME = anim_sel.getNome();
            String SPECIE = anim_sel.getSpecie();
            String GENERE = anim_sel.getSesso();
            String HABITAT = anim_sel.getHabitat();
            Date NASCITA = anim_sel.getDataNascita();
            boolean SALUTE = anim_sel.getSalute();
            boolean NOSTRO = anim_sel.getNostro();
            boolean PRESENTE = anim_sel.getPresente();
            anim = new Animale( CODICE, NOME, SPECIE, GENERE, HABITAT, NASCITA, SALUTE, NOSTRO, PRESENTE);
            
            
        this.jTextAreaNoteVisita.setLineWrap(true);
        this.jTextAreaNoteVisita.setWrapStyleWord(true);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabelNome = new javax.swing.JLabel();
        jLabelSpecie = new javax.swing.JLabel();
        jLabelHabitat = new javax.swing.JLabel();
        jLabelGenere = new javax.swing.JLabel();
        jLabelDataNascita = new javax.swing.JLabel();
        jButtonClose = new javax.swing.JButton();
        jLabelDisplayNome = new javax.swing.JLabel();
        jLabelDisplaySpecie = new javax.swing.JLabel();
        jLabelDisplayHabitat = new javax.swing.JLabel();
        jLabelDisplayGenere = new javax.swing.JLabel();
        jLabelDisplayNascita = new javax.swing.JLabel();
        jLabelSalute = new javax.swing.JLabel();
        jLabelPresente = new javax.swing.JLabel();
        jButtonNuovaVisita = new javax.swing.JButton();
        jLabelDisplaySalute = new javax.swing.JLabel();
        jLabelDisplayPresente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVisite = new javax.swing.JTable();
        jButtonLeggiNoteVisita = new javax.swing.JButton();
        jLabelCod = new javax.swing.JLabel();
        jLabelDisplayCod = new javax.swing.JLabel();
        jFrameVisita = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaNoteVisita = new javax.swing.JTextArea();
        jButtonNewVisConferma = new javax.swing.JButton();
        jButtonNewVisAnnulla = new javax.swing.JButton();
        jTextFieldDataVisita = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jRadioButtonMalato = new javax.swing.JRadioButton();
        jRadioButtonSano = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelNome.setText("Nome:");

        jLabelSpecie.setText("Specie:");

        jLabelHabitat.setText("Habitat:");

        jLabelGenere.setText("Genere:");

        jLabelDataNascita.setText("Data di Nascita:");

        jButtonClose.setText("Chiudi Scheda");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jLabelDisplayNome.setText("-");

        jLabelDisplaySpecie.setText("-");

        jLabelDisplayHabitat.setText("-");

        jLabelDisplayGenere.setText("-");

        jLabelDisplayNascita.setText("-");

        jLabelSalute.setText("Salute Attuale:");

        jLabelPresente.setText("Presente Attualmente:");

        jButtonNuovaVisita.setText("Nuova Visita");
        jButtonNuovaVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuovaVisitaActionPerformed(evt);
            }
        });

        jLabelDisplaySalute.setText("-");

        jLabelDisplayPresente.setText("-");

        jTableVisite.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jTableVisite.getTableHeader().setResizingAllowed(false);
        jTableVisite.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableVisite);
        if (jTableVisite.getColumnModel().getColumnCount() > 0) {
            jTableVisite.getColumnModel().getColumn(1).setHeaderValue("Title 2");
        }

        jButtonLeggiNoteVisita.setText("Leggi Note Visita");
        jButtonLeggiNoteVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLeggiNoteVisitaActionPerformed(evt);
            }
        });

        jLabelCod.setText("Codice Animale:");

        jLabelDisplayCod.setText("-");

        jFrameVisita.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jFrameVisita.setTitle("Registrazione Visita");
        jFrameVisita.setFrameIcon(null);
        jFrameVisita.setVisible(true);

        jLabel1.setText("Data Visita");

        jLabel2.setText("Note Visita");

        jTextAreaNoteVisita.setColumns(20);
        jTextAreaNoteVisita.setRows(5);
        jScrollPane2.setViewportView(jTextAreaNoteVisita);

        jButtonNewVisConferma.setText("Conferma");
        jButtonNewVisConferma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewVisConfermaActionPerformed(evt);
            }
        });

        jButtonNewVisAnnulla.setText("Annulla");
        jButtonNewVisAnnulla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewVisAnnullaActionPerformed(evt);
            }
        });

        jLabel3.setText("Stato Animale");

        jRadioButtonMalato.setText("Malato");

        jRadioButtonSano.setText("Sano");

        javax.swing.GroupLayout jFrameVisitaLayout = new javax.swing.GroupLayout(jFrameVisita.getContentPane());
        jFrameVisita.getContentPane().setLayout(jFrameVisitaLayout);
        jFrameVisitaLayout.setHorizontalGroup(
            jFrameVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameVisitaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jFrameVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrameVisitaLayout.createSequentialGroup()
                        .addGroup(jFrameVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jFrameVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldDataVisita, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jFrameVisitaLayout.createSequentialGroup()
                                .addComponent(jButtonNewVisConferma)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                                .addComponent(jButtonNewVisAnnulla, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jFrameVisitaLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(72, 72, 72)
                        .addComponent(jRadioButtonSano)
                        .addGap(54, 54, 54)
                        .addComponent(jRadioButtonMalato)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jFrameVisitaLayout.setVerticalGroup(
            jFrameVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameVisitaLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jFrameVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldDataVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jFrameVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jFrameVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonMalato)
                    .addComponent(jRadioButtonSano))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jFrameVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNewVisConferma)
                    .addComponent(jButtonNewVisAnnulla))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNome)
                            .addComponent(jLabelCod, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDisplayCod)
                            .addComponent(jLabelDisplayNome)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelGenere)
                            .addComponent(jLabelHabitat)
                            .addComponent(jLabelSpecie)
                            .addComponent(jLabelDataNascita))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDisplaySpecie)
                            .addComponent(jLabelDisplayHabitat)
                            .addComponent(jLabelDisplayGenere)
                            .addComponent(jLabelDisplayNascita))
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonNuovaVisita)
                                .addGap(83, 83, 83)
                                .addComponent(jButtonLeggiNoteVisita)
                                .addGap(67, 67, 67)
                                .addComponent(jButtonClose))
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPresente)
                            .addComponent(jLabelSalute))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDisplaySalute)
                            .addComponent(jLabelDisplayPresente))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jFrameVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDisplayCod)
                            .addComponent(jLabelCod))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDisplayNome)
                            .addComponent(jLabelNome))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDisplaySpecie)
                            .addComponent(jLabelSpecie))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDisplayHabitat)
                            .addComponent(jLabelHabitat))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelGenere)
                            .addComponent(jLabelDisplayGenere))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDataNascita)
                            .addComponent(jLabelDisplayNascita))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSalute)
                            .addComponent(jLabelDisplaySalute))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPresente)
                            .addComponent(jLabelDisplayPresente)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNuovaVisita)
                    .addComponent(jButtonLeggiNoteVisita)
                    .addComponent(jButtonClose))
                .addGap(34, 34, 34))
            .addComponent(jFrameVisita)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        // TODO add your handling code here: 
        setVisible(false);
        
        String[] FILTRI = new String[9];
        for(int i=0; i<FILTRI.length; i++) FILTRI[i] = "";
        
        new JVeterinario(utente, FILTRI);
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonLeggiNoteVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLeggiNoteVisitaActionPerformed
        Component frame = null;
        JVeterinario vet = new JVeterinario();
        vis.setNote(vet.getTableSelectedItem(jTableVisite, "Note Visite"));
        vis.setAnimale(this.jLabelDisplayCod.getText());
        vis.setVeterinario(vet.getTableSelectedItem(jTableVisite, "Veterinario"));
    
        String datavis =  vet.getTableSelectedItem(this.jTableVisite, "Data Visite"); 
        
        String nota = vis.setNote(vet.getTableSelectedItem(jTableVisite, "Note Visite"));

       
        ProgettoZoo pz = new ProgettoZoo();
        nota = pz.StringFormat(nota, 100);
              
        if(datavis.equals(""))  JOptionPane.showMessageDialog(null, "Errore! Nessuna visita selezionata", "Dettagli visita", JOptionPane.ERROR_MESSAGE);
        else {
            JOptionPane.showMessageDialog( frame, nota + "\nFirmato: "+ vis.getVeterinario() , "Dettagli visita del "+ datavis, JOptionPane.CLOSED_OPTION);        

        }
        
    }//GEN-LAST:event_jButtonLeggiNoteVisitaActionPerformed

    private void jButtonNuovaVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuovaVisitaActionPerformed
        // TODO add your handling code here:
        this.jFrameVisita.setTitle("Registrazione Nuova Visita per "+ this.jLabelDisplayCod.getText());
              this.jFrameVisita.setVisible(true); 
              pack();
     bG.add(this.jRadioButtonSano);
     bG.add(this.jRadioButtonMalato);
     this.jRadioButtonSano.setSelected(true);
            
        
    }//GEN-LAST:event_jButtonNuovaVisitaActionPerformed

    private void jButtonNewVisConfermaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewVisConfermaActionPerformed
        // TODO add your handling code here:
        
       ProgettoZoo pz = new ProgettoZoo();
        String DataNuovaVisita = this.jTextFieldDataVisita.getText();
        String NoteNuovaVisita = this.jTextAreaNoteVisita.getText();
        
        if(!this.jTextFieldDataVisita.getText().equals(""))
        { 
          Date DataVisita = pz.ConvertStringToDate(DataNuovaVisita, "dd-MM-yyyy");
          
          Date today = new Date();
          Date NascitaAnimale = pz.ConvertStringToDate(this.jLabelDisplayNascita.getText(), "dd-MM-yyyy");
            boolean dat =  pz.isThisDateValid(DataNuovaVisita,"dd-MM-yyyy");
        
        if(dat && DataVisita.before(today) && NascitaAnimale.before(DataVisita)) 
        {
            if(NoteNuovaVisita.length() > 400 || NoteNuovaVisita.length() < 1) JOptionPane.showMessageDialog(null, "Le note della visita devono contenere almeno 1 carattere e possono contenere al massimo 400 caratteri",
                    "ERRORE!", JOptionPane.ERROR_MESSAGE);
            else{
                
                String RB_Selected = "";
                if(this.jRadioButtonSano.isSelected()) RB_Selected = "Sano";
                else RB_Selected = "Malato";
                
                int reply = JOptionPane.showConfirmDialog(null, "Data Visita: "+this.jTextFieldDataVisita.getText()+"\nStato Animale: "+ RB_Selected + "\nNote Visita: " 
                        + pz.StringFormat(this.jTextAreaNoteVisita.getText(), 100), "Confermare?", JOptionPane.YES_NO_OPTION);
                 if (reply == JOptionPane.YES_OPTION) {
          java.sql.Date sqlDate = new java.sql.Date(DataVisita.getTime()); //converto in sqldate per inserire nel database... infatti util.date != sql.date

   conn.insertVisita(0,utente.getUsername(),this.jLabelDisplayCod.getText(), sqlDate, this.jTextAreaNoteVisita.getText());
   conn.updateSaluteAnimale(RB_Selected, anim.getId());
                  
                  setVisible(false); 
                  JSchedaAnimale_Veterinario v = new JSchedaAnimale_Veterinario(anim, utente); //resetta l'interfaccia per rendere visibile anche l'ultima data inserita dal veterinario stesso.
                  v.jLabelDisplaySalute.setText(RB_Selected);
                 } 
            }
        }
        else  JOptionPane.showMessageDialog(null, "Data non corretta! Possibili errori: \n1) Formato errato, verifica che sia GG-MM-AAAA"
                + "\n2) Data non esistente. \n3) La data della visita è precedente alla nascita dell'animale. \nSi prega di verificarne la correttezza.", "ERRORE!", JOptionPane.ERROR_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Nessun campo inserito.",
                    "ERRORE!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonNewVisConfermaActionPerformed

    private void jButtonNewVisAnnullaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewVisAnnullaActionPerformed
        // TODO add your handling code here:
        
        this.jTextFieldDataVisita.setText("");
        this.jTextAreaNoteVisita.setText("");
        this.jFrameVisita.setVisible(false);
        setSize(900, 550);
        
        
    }//GEN-LAST:event_jButtonNewVisAnnullaActionPerformed
    
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
            java.util.logging.Logger.getLogger(JSchedaAnimale_Veterinario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JSchedaAnimale_Veterinario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JSchedaAnimale_Veterinario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JSchedaAnimale_Veterinario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JSchedaAnimale_Veterinario().setVisible(true);
            }
        });
    }        
    
   public void Show_DateVisite_In_JTable(String cod_anim)
   {
       ProgettoZoo pz = new ProgettoZoo();
       ArrayList<Visita> visite = conn.visitaList(cod_anim);
        
       /* ORDINO GLI ELEMENTI PER DATE VISITE DA MENO RECENTE A PIU RECENTE */
       
       pz.quicksortDate(visite, 0, visite.size()-1, "decrescente");   
       
       
       DefaultTableModel model = (DefaultTableModel) this.jTableVisite.getModel();
       Object[] row = new Object[3];
       
       this.jTableVisite.changeSelection(0, 0, false, false);
       
       for(int i = 0; i < visite.size(); i++)
       {
           String DataTable = visite.get(i).getDV().toString();
           String DataString = pz.NuovoFormatoData(DataTable, "yyyy-MM-dd", "dd-MM-yyyy");
           
           row[0] = DataString;
           row[1] = visite.get(i).getNote();
           row[2] = visite.get(i).getVeterinario();
            
           model.addRow(row);
       }
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonLeggiNoteVisita;
    private javax.swing.JButton jButtonNewVisAnnulla;
    private javax.swing.JButton jButtonNewVisConferma;
    private javax.swing.JButton jButtonNuovaVisita;
    private javax.swing.JInternalFrame jFrameVisita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelCod;
    private javax.swing.JLabel jLabelDataNascita;
    public javax.swing.JLabel jLabelDisplayCod;
    public javax.swing.JLabel jLabelDisplayGenere;
    public javax.swing.JLabel jLabelDisplayHabitat;
    public javax.swing.JLabel jLabelDisplayNascita;
    public javax.swing.JLabel jLabelDisplayNome;
    public javax.swing.JLabel jLabelDisplayPresente;
    public javax.swing.JLabel jLabelDisplaySalute;
    public javax.swing.JLabel jLabelDisplaySpecie;
    private javax.swing.JLabel jLabelGenere;
    private javax.swing.JLabel jLabelHabitat;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPresente;
    private javax.swing.JLabel jLabelSalute;
    private javax.swing.JLabel jLabelSpecie;
    private javax.swing.JRadioButton jRadioButtonMalato;
    private javax.swing.JRadioButton jRadioButtonSano;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTableVisite;
    private javax.swing.JTextArea jTextAreaNoteVisita;
    private javax.swing.JTextField jTextFieldDataVisita;
    // End of variables declaration//GEN-END:variables
}
