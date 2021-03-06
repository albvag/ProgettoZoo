/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logins;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;
import database.DBConnect;
import progettozoo.Habitat;
import progettozoo.Prodotto;
import progettozoo.ProgettoZoo;
import progettozoo.Utente;
import schede.JAggiungiAnimale_Direttore;
import schede.JAggiungiHabitat_Direttore;
import schede.JAggiungiPersonale_Direttore;
import schede.JAggiungiProdotto_Direttore;
import schede.JCambiaPrezzi_Direttore;
import schede.JControlloPasti_Direttore;
import schede.JControlloPulizie_Direttore;
import schede.JListaHabitat_Direttore;
import schede.JListaPersonale_Direttore;
import schede.JListaProdotti_Direttore;
import schede.JModificaAnimale_Direttore;
import schede.JModificaPersonale_Direttore;
import schede.JPrestaAnimale_Direttore;
import schede.JRimuoviAnimale_Direttore;
import schede.JRimuoviHabitat_Direttore;
import schede.JRimuoviPersonale_Direttore;
import schede.JRimuoviProdotto_Direttore;
import schede.JVediIncassi_Direttore;
import schede.jListaAnimali_Direttore;

/**
 *
 * @author Alberto
 */
public class JDirettore extends javax.swing.JFrame {
 public Utente user = new Utente();
 DBConnect conn=new DBConnect();
 ProgettoZoo pz=new ProgettoZoo();
    /**
     * Creates new form JDirettore
     */
    public JDirettore() {
        initComponents();
    }
    public JDirettore(Utente user_login) {
        initComponents();
        
        setLocationRelativeTo(null);
        setTitle("Benvenuto, "+user_login.getNome()+ " " + user_login.getCognome() );
         user.setUsername(user_login.getUsername());
        user.setNome(user_login.getNome());
        user.setCognome(user_login.getCognome());
        user.setRuolo(user_login.getRuolo());
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
        jAggiungiPersonale = new javax.swing.JButton();
        jRimuoviPersonale = new javax.swing.JButton();
        jAggiungiAnimale = new javax.swing.JButton();
        jRimuoviAnimale = new javax.swing.JButton();
        jAggiungiHabitat = new javax.swing.JButton();
        jRimuoviHabitat = new javax.swing.JButton();
        jVediincassi = new javax.swing.JButton();
        jListaanimali = new javax.swing.JButton();
        jPrestaanimale = new javax.swing.JButton();
        jAggiungiProdotto = new javax.swing.JButton();
        jRimuoviProdotto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlistahabitat = new javax.swing.JButton();
        jlistapersonale = new javax.swing.JButton();
        jlistaprodotti = new javax.swing.JButton();
        jCambiaprezzi = new javax.swing.JButton();
        jControlloPasti = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jModificaPersonale = new javax.swing.JButton();
        jModificaAnimale = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Direttore");
        setResizable(false);

        jButtonLogout.setText("Logout");
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        jAggiungiPersonale.setText("Aggiungi Personale");
        jAggiungiPersonale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAggiungiPersonaleActionPerformed(evt);
            }
        });

        jRimuoviPersonale.setText("Rimuovi Personale");
        jRimuoviPersonale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRimuoviPersonaleActionPerformed(evt);
            }
        });

        jAggiungiAnimale.setText("Aggiungi Animale");
        jAggiungiAnimale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAggiungiAnimaleActionPerformed(evt);
            }
        });

        jRimuoviAnimale.setText("Rimuovi Animale");
        jRimuoviAnimale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRimuoviAnimaleActionPerformed(evt);
            }
        });

        jAggiungiHabitat.setText("Aggiungi Habitat");
        jAggiungiHabitat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAggiungiHabitatActionPerformed(evt);
            }
        });

        jRimuoviHabitat.setText("Rimuovi Habitat");
        jRimuoviHabitat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRimuoviHabitatActionPerformed(evt);
            }
        });

        jVediincassi.setText("Vedi Incassi");
        jVediincassi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVediincassiActionPerformed(evt);
            }
        });

        jListaanimali.setText("Lista Animali");
        jListaanimali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jListaanimaliActionPerformed(evt);
            }
        });

        jPrestaanimale.setText("Presta Animale");
        jPrestaanimale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPrestaanimaleActionPerformed(evt);
            }
        });

        jAggiungiProdotto.setText("Aggiungi Prodotto");
        jAggiungiProdotto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAggiungiProdottoActionPerformed(evt);
            }
        });

        jRimuoviProdotto.setText("Rimuovi Prodotto");
        jRimuoviProdotto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRimuoviProdottoActionPerformed(evt);
            }
        });

        jLabel1.setText("            Gestione Animali");

        jLabel2.setText("           Gestione Habitat");

        jLabel3.setText("        Gestione Personale");

        jLabel4.setText("           Gestione Prodotti");

        jlistahabitat.setText("Lista Habitat");
        jlistahabitat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlistahabitatActionPerformed(evt);
            }
        });

        jlistapersonale.setText("Lista Personale");
        jlistapersonale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlistapersonaleActionPerformed(evt);
            }
        });

        jlistaprodotti.setText("Lista Prodotti");
        jlistaprodotti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlistaprodottiActionPerformed(evt);
            }
        });

        jCambiaprezzi.setText("Cambia Prezzi");
        jCambiaprezzi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCambiaprezziActionPerformed(evt);
            }
        });

        jControlloPasti.setText("Controllo Pasti");
        jControlloPasti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jControlloPastiActionPerformed(evt);
            }
        });

        jButton2.setText("Controllo Pulizie");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jModificaPersonale.setText("Modifica Personale");
        jModificaPersonale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jModificaPersonaleActionPerformed(evt);
            }
        });

        jModificaAnimale.setText("Modifica Animale");
        jModificaAnimale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jModificaAnimaleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlistapersonale, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jAggiungiPersonale, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRimuoviPersonale, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jModificaPersonale, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(69, 69, 69))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jModificaAnimale, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jAggiungiAnimale, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jListaanimali, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jRimuoviAnimale, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPrestaanimale, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(26, 26, 26)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jlistahabitat, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jAggiungiHabitat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRimuoviHabitat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jControlloPasti, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jAggiungiProdotto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRimuoviProdotto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCambiaprezzi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlistaprodotti, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButtonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jVediincassi, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlistapersonale, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlistaprodotti, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jListaanimali, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlistahabitat, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAggiungiHabitat, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAggiungiPersonale, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAggiungiProdotto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAggiungiAnimale, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRimuoviPersonale, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRimuoviProdotto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRimuoviHabitat, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRimuoviAnimale, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCambiaprezzi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jControlloPasti, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jModificaPersonale, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jModificaAnimale, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jVediincassi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPrestaanimale, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jButtonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
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

    private void jRimuoviHabitatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRimuoviHabitatActionPerformed
         JRimuoviHabitat_Direttore rim = new JRimuoviHabitat_Direttore(user);
                    rim.setLocationRelativeTo(null);
                    rim.setVisible(true);
                    setVisible(false);
    }//GEN-LAST:event_jRimuoviHabitatActionPerformed

    private void jAggiungiPersonaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAggiungiPersonaleActionPerformed
       JAggiungiPersonale_Direttore per = new JAggiungiPersonale_Direttore(user);
                    per.setLocationRelativeTo(null);
                    per.setVisible(true);        
                    setVisible(false);
    }//GEN-LAST:event_jAggiungiPersonaleActionPerformed

    private void jAggiungiAnimaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAggiungiAnimaleActionPerformed
       JAggiungiAnimale_Direttore an = new JAggiungiAnimale_Direttore(user);
                   an.setLocationRelativeTo(null);
                   an.setVisible(true);  
                   setVisible(false);
    }//GEN-LAST:event_jAggiungiAnimaleActionPerformed

    private void jAggiungiHabitatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAggiungiHabitatActionPerformed
        JAggiungiHabitat_Direttore hab = new JAggiungiHabitat_Direttore(user);
         hab.setLocationRelativeTo(null);
                   hab.setVisible(true);
                   setVisible(false);
    }//GEN-LAST:event_jAggiungiHabitatActionPerformed

    private void jListaanimaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jListaanimaliActionPerformed
        jListaAnimali_Direttore lis = new jListaAnimali_Direttore(user);
         lis.setLocationRelativeTo(null);
                   lis.setVisible(true); 
                   setVisible(false);
    }//GEN-LAST:event_jListaanimaliActionPerformed

    private void jRimuoviPersonaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRimuoviPersonaleActionPerformed
      JRimuoviPersonale_Direttore rimpers = new JRimuoviPersonale_Direttore(user);
      rimpers.setLocationRelativeTo(null);
          rimpers.setVisible(true);
          setVisible(false);
    }//GEN-LAST:event_jRimuoviPersonaleActionPerformed

    private void jRimuoviAnimaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRimuoviAnimaleActionPerformed
       JRimuoviAnimale_Direttore riman = new JRimuoviAnimale_Direttore(user);
       riman.setLocationRelativeTo(null);
       riman.setVisible(true);
       setVisible(false);
    }//GEN-LAST:event_jRimuoviAnimaleActionPerformed

    private void jAggiungiProdottoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAggiungiProdottoActionPerformed
      JAggiungiProdotto_Direttore aggpro= new JAggiungiProdotto_Direttore(user);
      aggpro.setLocationRelativeTo(null);
      aggpro.setVisible(true);
      setVisible(false);
    }//GEN-LAST:event_jAggiungiProdottoActionPerformed

    private void jRimuoviProdottoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRimuoviProdottoActionPerformed
      JRimuoviProdotto_Direttore rimpro= new JRimuoviProdotto_Direttore(user);
      rimpro.setLocationRelativeTo(null);
      rimpro.setVisible(true);
      setVisible(false);
    }//GEN-LAST:event_jRimuoviProdottoActionPerformed

    private void jlistapersonaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlistapersonaleActionPerformed
        JListaPersonale_Direttore lisper = new JListaPersonale_Direttore(user);
        lisper.setLocationRelativeTo(null);
        lisper.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jlistapersonaleActionPerformed

    private void jlistahabitatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlistahabitatActionPerformed
         JListaHabitat_Direttore lishab= new JListaHabitat_Direttore(user);
       lishab.setLocationRelativeTo(null);
       lishab.setVisible(true);
       setVisible(false);
    }//GEN-LAST:event_jlistahabitatActionPerformed

    private void jlistaprodottiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlistaprodottiActionPerformed
          JListaProdotti_Direttore lispro=new JListaProdotti_Direttore(user);
       lispro.setLocationRelativeTo(null);
       lispro.setVisible(true);
       setVisible(false);
    }//GEN-LAST:event_jlistaprodottiActionPerformed

    private void jPrestaanimaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPrestaanimaleActionPerformed
        JPrestaAnimale_Direttore presanim = new JPrestaAnimale_Direttore(user);
        presanim.setLocationRelativeTo(null);
        presanim.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jPrestaanimaleActionPerformed

    private void jVediincassiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVediincassiActionPerformed
        JVediIncassi_Direttore vedinc = new JVediIncassi_Direttore(user);
        vedinc.setLocationRelativeTo(null);
        vedinc.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jVediincassiActionPerformed

    private void jCambiaprezziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCambiaprezziActionPerformed
        JCambiaPrezzi_Direttore campre = new JCambiaPrezzi_Direttore(user);
        campre.setLocationRelativeTo(null);
        campre.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jCambiaprezziActionPerformed

    private void jModificaAnimaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jModificaAnimaleActionPerformed
       JModificaAnimale_Direttore moddir =new JModificaAnimale_Direttore(user);
       moddir.setLocationRelativeTo(null);
       moddir.setVisible(true);
       setVisible(false);
    }//GEN-LAST:event_jModificaAnimaleActionPerformed

    private void jModificaPersonaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jModificaPersonaleActionPerformed
        JModificaPersonale_Direttore modper = new JModificaPersonale_Direttore(user);
        modper.setLocationRelativeTo(null);
        modper.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jModificaPersonaleActionPerformed

    private void jControlloPastiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jControlloPastiActionPerformed
        JControlloPasti_Direttore conpas = new JControlloPasti_Direttore(user);
        conpas.setLocationRelativeTo(null);
        conpas.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jControlloPastiActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JControlloPulizie_Direttore conpul= new JControlloPulizie_Direttore(user);
        conpul.setLocationRelativeTo(null);
        conpul.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
public void Show_Prodotti_In_JTable(JTable table)
   {
       ArrayList<Prodotto> list = conn.listaProdotti();
       DefaultTableModel model = (DefaultTableModel) table.getModel();
       Object[] row = new Object[3];
       
        table.changeSelection(0, 0, false, false);
       for(int i = 0; i < list.size(); i++)
       {
     
           row[0] = list.get(i).getTipo();
           
           row[1] = list.get(i).getPrezzo();
           
           row[2] = list.get(i).getGiacenza();
           
          
                   
           model.addRow(row);
           
       }
    }

   public void Show_Habitat_In_JTable(JTable table)
   {
       ArrayList<Habitat> list = conn.selezionaHabitat();
       DefaultTableModel model = (DefaultTableModel) table.getModel();
       Object[] row = new Object[2];
       
        table.changeSelection(0, 0, false, false);
       for(int i = 0; i < list.size(); i++)
       {
     
           row[0] = list.get(i).getHabitat();
           row[1] = list.get(i).getSpecie();
                 
           model.addRow(row);
           
       }
    }
    public void Show_Utenti_In_JTable(JTable table)
   {
       ArrayList<Utente> list = conn.selezionaImpiegato();
       DefaultTableModel model = (DefaultTableModel) table.getModel();
       Object[] row = new Object[8];
       
        table.changeSelection(0, 0, false, false);
       for(int i = 0; i < list.size(); i++)
       {
     
           row[0] = list.get(i).getUsername();
           
           row[1] = list.get(i).getNome();
           
           row[2] = list.get(i).getCognome();
           
           String DataNascita = list.get(i).getData().toString();
           
           String DataNascita_String = pz.NuovoFormatoData(DataNascita, "yyyy-MM-dd", "dd-MM-yyyy");
           
           row[3] = DataNascita_String;
           
           row[4] = list.get(i).getResidenza();
           
           row[5] = list.get(i).getIndirizzo();
           
           row[6] = list.get(i).getTelefono();
           
           row[7] = list.get(i).getRuolo();
           
           model.addRow(row);
           
       }
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
            java.util.logging.Logger.getLogger(JDirettore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDirettore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDirettore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDirettore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JDirettore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAggiungiAnimale;
    private javax.swing.JButton jAggiungiHabitat;
    private javax.swing.JButton jAggiungiPersonale;
    private javax.swing.JButton jAggiungiProdotto;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jCambiaprezzi;
    private javax.swing.JButton jControlloPasti;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jListaanimali;
    private javax.swing.JButton jModificaAnimale;
    private javax.swing.JButton jModificaPersonale;
    private javax.swing.JButton jPrestaanimale;
    private javax.swing.JButton jRimuoviAnimale;
    private javax.swing.JButton jRimuoviHabitat;
    private javax.swing.JButton jRimuoviPersonale;
    private javax.swing.JButton jRimuoviProdotto;
    private javax.swing.JButton jVediincassi;
    private javax.swing.JButton jlistahabitat;
    private javax.swing.JButton jlistapersonale;
    private javax.swing.JButton jlistaprodotti;
    // End of variables declaration//GEN-END:variables
}
