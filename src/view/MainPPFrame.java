/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import view.component.PandaProdFrame;

/**
 *
 * @author Lucas
 */
public class MainPPFrame extends PandaProdFrame {

    /**
     * Creates new form MainPPFrame
     */
    public MainPPFrame() {

        initComponents();
        configFrame();
        putComponents();
        refresh();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        pandaProdLabelWelcome = new view.component.PandaProdLabel();
        pandaProdLabelMyApp = new view.component.PandaProdLabel();
        jScrollPanelJlistMyApp = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        pandaProdLabelReferentiel = new view.component.PandaProdLabel();
        jToolBar1 = new javax.swing.JToolBar();
        pandaProdButtonNotify = new view.component.PandaProdButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        pandaProdButtonAddApplication = new view.component.PandaProdButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        pandaProdButtonManageUser = new view.component.PandaProdButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        pandaProdButtonModifyApplication = new view.component.PandaProdButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        pandaProdButtonExportApplication = new view.component.PandaProdButton();
        jMenuBar2 = new javax.swing.JMenuBar();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pandaProdLabelWelcome.setText("WELCOME IN PANDA PRODUCTION JAVA FRAMEWORK");

        pandaProdLabelMyApp.setText("Mes applications");

        pandaProdLabelReferentiel.setText("Référentiel");

        jToolBar1.setRollover(true);

        pandaProdButtonNotify.setText("Notification");
        pandaProdButtonNotify.setFocusable(false);
        pandaProdButtonNotify.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pandaProdButtonNotify.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(pandaProdButtonNotify);
        jToolBar1.add(jSeparator4);

        pandaProdButtonAddApplication.setText("Ajout d'application");
        jToolBar1.add(pandaProdButtonAddApplication);
        jToolBar1.add(jSeparator3);

        pandaProdButtonManageUser.setText("Gestion des utilisateurs");
        pandaProdButtonManageUser.setFocusable(false);
        pandaProdButtonManageUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pandaProdButtonManageUser.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(pandaProdButtonManageUser);
        jToolBar1.add(jSeparator2);

        pandaProdButtonModifyApplication.setText("Modifier application");
        jToolBar1.add(pandaProdButtonModifyApplication);
        jToolBar1.add(jSeparator1);

        pandaProdButtonExportApplication.setText("Exporter application");
        jToolBar1.add(pandaProdButtonExportApplication);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pandaProdLabelWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pandaProdLabelReferentiel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1))))
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPanelJlistMyApp, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pandaProdLabelMyApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pandaProdLabelMyApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pandaProdLabelReferentiel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPanelJlistMyApp, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(pandaProdLabelWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MainPPFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPPFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPPFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPPFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPPFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPanelJlistMyApp;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    private view.component.PandaProdButton pandaProdButtonAddApplication;
    private view.component.PandaProdButton pandaProdButtonExportApplication;
    private view.component.PandaProdButton pandaProdButtonManageUser;
    private view.component.PandaProdButton pandaProdButtonModifyApplication;
    private view.component.PandaProdButton pandaProdButtonNotify;
    private view.component.PandaProdLabel pandaProdLabelMyApp;
    private view.component.PandaProdLabel pandaProdLabelReferentiel;
    private view.component.PandaProdLabel pandaProdLabelWelcome;
    // End of variables declaration//GEN-END:variables

    @Override
    public final void putComponents(){
        hsJcomponent.put("pandaProdButtonAddApplication", pandaProdButtonAddApplication);
        hsJcomponent.put("pandaProdButtonExportApplication", pandaProdButtonExportApplication);
        hsJcomponent.put("pandaProdButtonManageUser", pandaProdButtonManageUser);
        hsJcomponent.put("pandaProdButtonModifyApplication", pandaProdButtonModifyApplication);
        hsJcomponent.put("pandaProdButtonNotify", pandaProdButtonNotify);
        hsJcomponent.put("pandaProdLabelMyApp", pandaProdLabelMyApp);
        hsJcomponent.put("pandaProdLabelReferentiel", pandaProdLabelReferentiel);
        hsJcomponent.put("pandaProdLabelWelcome", pandaProdLabelWelcome);
        
    }
    
    @Override
    public final void configFrame() {
        super.configFrame();
        setTitle("Acceuil");

    }

}
