/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pavel
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Field1a = new javax.swing.JCheckBox();
        Field2a = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        Field1a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Field1aActionPerformed(evt);
            }
        });
        getContentPane().add(Field1a);
        Field1a.setBounds(30, 40, 20, 20);

        Field2a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Field2aActionPerformed(evt);
            }
        });
        getContentPane().add(Field2a);
        Field2a.setBounds(30, 20, 20, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Pavel\\Pictures\\Warship.jpg")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -10, 480, 260);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Pavel\\Pictures\\fon2.jpg")); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-6, -6, 730, 410);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Field1aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Field1aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Field1aActionPerformed

    private void Field2aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Field2aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Field2aActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Field1a;
    private javax.swing.JCheckBox Field2a;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
