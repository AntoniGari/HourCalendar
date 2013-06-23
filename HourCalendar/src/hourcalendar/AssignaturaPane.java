/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hourcalendar;

import java.awt.Color;
import java.util.Vector;

/**
 *
 * @author admin
 */
public class AssignaturaPane extends javax.swing.JPanel {
    Assignatura assignatura;
    private Vector<Color> colors;
    /**
     * Creates new form AssignaturaPane
     */
    public AssignaturaPane() {
        initComponents();
    }
    
    public AssignaturaPane(Assignatura assignatura) {
        initComponents();
        colors = new Vector<Color>();
        //colors pastel
        colors.add(new Color(204, 255, 204));   //verd (no pastel)
        colors.add(new Color(253, 253, 150));   //groc
        colors.add(new Color(174, 198, 207));   //blau
        colors.add(new Color(255, 105, 97));    //vermell
        colors.add(new Color(130, 105, 83));    //marro
        colors.add(new Color(255, 179, 71));    //taronja
        colors.add(new Color(177, 156, 217));   //lila
        this.assignatura = assignatura;
        sigles.setText(assignatura.getSigles());
        codi.setText(String.valueOf(assignatura.getCodi()));
        String prefixNom = "[Curs ".concat(String.valueOf(assignatura.getQuadrimestre()).concat("] "));
        nom.setText(prefixNom.concat(assignatura.getNom()));
        int colorGrau = Math.abs(HourCalendar.getBase().getIndexOfGrau(assignatura.getGrau())) % 7;
        System.out.println("COLORGRAU: ".concat(String.valueOf(colorGrau)));
        this.setBackground(colors.get(colorGrau));
        assignatura.getGrau().color = colors.get(colorGrau);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sigles = new javax.swing.JLabel();
        codi = new javax.swing.JLabel();
        editar = new javax.swing.JButton();
        nom = new javax.swing.JLabel();
        eliminar = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 204));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 10, 3, 10));

        sigles.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        sigles.setText("PROP");
        sigles.setToolTipText("");

        codi.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        codi.setText("340380");

        editar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        editar.setText("Editar");
        editar.setOpaque(false);
        editar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarMouseClicked(evt);
            }
        });

        nom.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        nom.setText("PROJECTE DE PROGRAMACIÓ");

        eliminar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        eliminar.setText("Eliminar");
        eliminar.setOpaque(false);
        eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sigles, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(codi, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nom, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editar))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(sigles, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(codi, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(editar)
                .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(eliminar))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormulariAssignatura(assignatura).setVisible(true);
            }
        });
    }//GEN-LAST:event_editarMouseClicked

    private void eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarMouseClicked
        Base base = HourCalendar.getBase();
        base.removeAssignatura(assignatura);
        HourCalendar.getMainFrame().updateAssignatures();
    }//GEN-LAST:event_eliminarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel codi;
    private javax.swing.JButton editar;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel nom;
    private javax.swing.JLabel sigles;
    // End of variables declaration//GEN-END:variables
}
