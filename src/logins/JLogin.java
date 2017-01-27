/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logins;

import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.*;
import progettozoo.DBConnect;

/**
 *
 * @author Alberto
 */
public class JLogin extends javax.swing.JFrame {

    /**
     * Creates new form JLogin
     */
    public JLogin() {
        initComponents();
        //getContentPane().setBackground(Color.yellow);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonInvia = new javax.swing.JButton();
        jButtonEsci = new javax.swing.JButton();
        jTextFieldUsername = new javax.swing.JTextField();
        jPasswordFieldPassword = new javax.swing.JPasswordField();
        jLabelUsername = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jLabelHide1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Zoo Login");
        setLocation(new java.awt.Point(0, 0));

        jButtonInvia.setText("Invia");
        jButtonInvia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInviaActionPerformed(evt);
            }
        });

        jButtonEsci.setText("Esci");
        jButtonEsci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEsciActionPerformed(evt);
            }
        });

        jTextFieldUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldUsernameFocusGained(evt);
            }
        });
        jTextFieldUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldUsernameKeyPressed(evt);
            }
        });

        jPasswordFieldPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordFieldPasswordFocusGained(evt);
            }
        });
        jPasswordFieldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldPasswordKeyPressed(evt);
            }
        });

        jLabelUsername.setText("Username");

        jLabelPassword.setText("Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonInvia)
                        .addGap(33, 33, 33)
                        .addComponent(jLabelHide1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonEsci)
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelPassword)
                                .addGap(18, 18, 18)
                                .addComponent(jPasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelUsername)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(88, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsername)
                    .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPassword)
                    .addComponent(jPasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonInvia)
                    .addComponent(jButtonEsci)
                    .addComponent(jLabelHide1))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInviaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInviaActionPerformed
        // TODO add your handling code here:
       
       
        DBConnect conn = new DBConnect();
        String user = this.jTextFieldUsername.getText();
        String password = this.jPasswordFieldPassword.getText();
        int userExists = conn.userExists(user, password);
        if( userExists == 1)
        {
            String ruolo;
            ruolo = conn.checkRole(user);
            switch(ruolo){
                case "Cassiere": {
                    JCassiere cass = new JCassiere();
                    cass.setLocationRelativeTo(null);
                    cass.setVisible(true);
                    break;
                }
                case "Veterinario": {
                    JVeterinario vet = new JVeterinario();
                    vet.setLocationRelativeTo(null);
                    vet.setVisible(true);
                    break;
                }
                case "Custode":{
                    JCustode cust = new JCustode();
                    cust.setLocationRelativeTo(null);
                    cust.setVisible(true);
                    break;
                }
                case "Direttore":{
                    JDirettore dir = new JDirettore();
                    dir.setLocationRelativeTo(null);
                    dir.setVisible(true);
                    break;
                }
                case "Errore":{
                    this.jLabelHide1.setText(String.format("%d", userExists));
                }
            }
            close(this);
        }
        else {
           this.jLabelHide1.setText(String.format("%d", userExists)); /* Gestire errore */
        }
        
    }//GEN-LAST:event_jButtonInviaActionPerformed

    private void jButtonEsciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEsciActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButtonEsciActionPerformed

    private void jPasswordFieldPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordKeyPressed
        
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
                DBConnect conn = new DBConnect();
            String user = this.jTextFieldUsername.getText();
            String password = this.jPasswordFieldPassword.getText();
            int userExists = conn.userExists(user, password);
            if( userExists == 1)
            {
                String ruolo;
                ruolo = conn.checkRole(user);
                switch(ruolo){
                    case "Cassiere": {
                        JCassiere cass = new JCassiere();
                        cass.setLocationRelativeTo(null);
                        cass.setVisible(true);
                        break;
                    }
                    case "Veterinario": {
                        JVeterinario vet = new JVeterinario();
                        vet.setLocationRelativeTo(null);
                        vet.setVisible(true);
                        break;
                    }
                    case "Custode":{
                        JCustode cust = new JCustode();
                        cust.setLocationRelativeTo(null);
                        cust.setVisible(true);
                        break;
                    }
                    case "Direttore":{
                        JDirettore dir = new JDirettore();
                        dir.setLocationRelativeTo(null);
                        dir.setVisible(true);
                        break;
                    }
                    case "Errore":{
                        this.jLabelHide1.setText(String.format("%d", userExists));
                    }
                }
                close(this);
            }
            else {
               this.jLabelHide1.setText(String.format("%d", userExists)); /* Gestire errore */
            }
        } ;  
            
    }//GEN-LAST:event_jPasswordFieldPasswordKeyPressed

    private void jPasswordFieldPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordFocusGained

    this.jPasswordFieldPassword.selectAll();        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldPasswordFocusGained

    private void jTextFieldUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldUsernameFocusGained

        this.jTextFieldUsername.selectAll();     // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsernameFocusGained

    private void jTextFieldUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUsernameKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
                DBConnect conn = new DBConnect();
            String user = this.jTextFieldUsername.getText();
            String password = this.jPasswordFieldPassword.getText();
            int userExists = conn.userExists(user, password);
            if( userExists == 1)
            {
                String ruolo;
                ruolo = conn.checkRole(user);
                switch(ruolo){
                    case "Cassiere": {
                        JCassiere cass = new JCassiere();
                        cass.setLocationRelativeTo(null);
                        cass.setVisible(true);
                        break;
                    }
                    case "Veterinario": {
                        JVeterinario vet = new JVeterinario();
                        vet.setLocationRelativeTo(null);
                        vet.setVisible(true);
                        break;
                    }
                    case "Custode":{
                        JCustode cust = new JCustode();
                        cust.setLocationRelativeTo(null);
                        cust.setVisible(true);
                        break;
                    }
                    case "Direttore":{
                        JDirettore dir = new JDirettore();
                        dir.setLocationRelativeTo(null);
                        dir.setVisible(true);
                        break;
                    }
                    case "Errore":{
                        this.jLabelHide1.setText(String.format("%d", userExists));
                    }
                }
                close(this);
            }
            else {
               this.jLabelHide1.setText(String.format("%d", userExists)); /* Gestire errore */
            }
        };
    }//GEN-LAST:event_jTextFieldUsernameKeyPressed

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
            java.util.logging.Logger.getLogger(JLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JLogin().setVisible(true);
                         
            }
        });
    }
    
    public void close(Window Form)
    {
    WindowEvent winClosingEvent = new WindowEvent(Form, WindowEvent.WINDOW_CLOSING);
    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEsci;
    private javax.swing.JButton jButtonInvia;
    private javax.swing.JLabel jLabelHide1;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JPasswordField jPasswordFieldPassword;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
}
