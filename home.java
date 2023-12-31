
public class home extends javax.swing.JFrame {

    /**
     * Creates new form home
     */

    private String email;
    private Database db;
    public home(String email,Database db) {
        this.email=email;
        this.db=db;

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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        Merchandise = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        PlantTree = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 500));

        jDesktopPane1.setBackground(new java.awt.Color(0, 153, 153));
        jDesktopPane1.setPreferredSize(new java.awt.Dimension(800, 500));
        jDesktopPane1.setRequestFocusEnabled(false);

        Merchandise.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        Merchandise.setText("Redeem Merchandise");
        Merchandise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MerchandiseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        PlantTree.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        PlantTree.setText("Plant a Tree");
        PlantTree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlantTreeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 1, 36)); // NOI18N
        jLabel1.setText("Welcome To Point Shop!");

        Back.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        Back.setText("Return");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(Merchandise, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(PlantTree, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(Back, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
                jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                                                .addGap(227, 227, 227)
                                                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(PlantTree, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(Merchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                                                .addGap(337, 337, 337)
                                                                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap(261, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(96, 96, 96))))
        );
        jDesktopPane1Layout.setVerticalGroup(
                jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Merchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(PlantTree, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(104, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(101, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
         /*
         MercFrame = new ();
        MercFrame.setVisible(true);
        MercFrame.pack();
        MercFrame.setLocationRelativeTo(null);
        this.dispose();
       */

    }//GEN-LAST:event_BackActionPerformed

    private void MerchandiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MerchandiseActionPerformed
        // TODO add your handling code here:
        Merchandise MercFrame = new Merchandise(email,db);
        MercFrame.setVisible(true);
        MercFrame.pack();
        MercFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MerchandiseActionPerformed

    private void PlantTreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlantTreeActionPerformed
        // TODO add your handling code here:
        PTree PTreeFrame = new PTree(email,db);
        PTreeFrame.setVisible(true);
        PTreeFrame.pack();
        PTreeFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_PlantTreeActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new home().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Merchandise;
    private javax.swing.JButton PlantTree;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
