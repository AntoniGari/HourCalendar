/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hourcalendar;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author admin
 */
public class MainFrame extends javax.swing.JFrame {
    static javax.swing.JFrame frameCalendari;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        setExtendedState( getExtendedState()|JFrame.MAXIMIZED_BOTH );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        BotoCalendari = new javax.swing.JButton();
        BotoGenerarHorari = new javax.swing.JButton();
        Contenidor = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        BotoCalendari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hourcalendar/calendar2.png"))); // NOI18N
        BotoCalendari.setToolTipText("Editar el calendari de dies amb docència");
        BotoCalendari.setFocusable(false);
        BotoCalendari.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotoCalendari.setMaximumSize(new java.awt.Dimension(32, 32));
        BotoCalendari.setMinimumSize(new java.awt.Dimension(32, 32));
        BotoCalendari.setName(""); // NOI18N
        BotoCalendari.setPreferredSize(new java.awt.Dimension(32, 32));
        BotoCalendari.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotoCalendari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotoCalendariMouseClicked(evt);
            }
        });
        jToolBar1.add(BotoCalendari);

        BotoGenerarHorari.setText("Generar Horari");
        BotoGenerarHorari.setFocusable(false);
        BotoGenerarHorari.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotoGenerarHorari.setMaximumSize(new java.awt.Dimension(100, 32));
        BotoGenerarHorari.setMinimumSize(new java.awt.Dimension(100, 32));
        BotoGenerarHorari.setPreferredSize(new java.awt.Dimension(100, 32));
        BotoGenerarHorari.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotoGenerarHorari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotoGenerarHorariMouseClicked(evt);
            }
        });
        jToolBar1.add(BotoGenerarHorari);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(Contenidor)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Contenidor, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotoCalendariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotoCalendariMouseClicked
        // TODO add your handling code here:
        SwingUtilities.invokeLater(new Runnable() { 
			@Override
			public void run() {
				SelectorDiesDocencia selectorDiesDocencia = new SelectorDiesDocencia();
				frameCalendari = new JFrame();
				frameCalendari.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Container panel = frameCalendari.getContentPane();
				panel.setLayout(new BorderLayout());
				panel.add(selectorDiesDocencia, BorderLayout.CENTER);
				frameCalendari.pack();
				frameCalendari.setSize(441, 234);    //(435,206);
                frameCalendari.setResizable(false);
				frameCalendari.setVisible(true);
			}
		});
    }//GEN-LAST:event_BotoCalendariMouseClicked

    private void BotoGenerarHorariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotoGenerarHorariMouseClicked
        // TODO add your handling code here:
        Base base = HourCalendar.getBase();
        base.updateDisponibilitatHoraria(2, 2013);
        Vector<DisponibilitatHoraria> disponibilitats = base.getDisponibilitatsHoraries();
        for (int idDisponibilitat = 0; idDisponibilitat < disponibilitats.size(); ++idDisponibilitat) {
            PanellHorari horari = new PanellHorari(disponibilitats.elementAt(idDisponibilitat));
            Contenidor.setViewportView(horari);
        }
    }//GEN-LAST:event_BotoGenerarHorariMouseClicked

    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        //Set the Nimbus look and feel
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotoCalendari;
    private javax.swing.JButton BotoGenerarHorari;
    private javax.swing.JScrollPane Contenidor;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}