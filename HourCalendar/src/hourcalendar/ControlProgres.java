/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hourcalendar;

import hourcalendar.Base.Regles;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author admin
 */
public class ControlProgres extends javax.swing.JFrame {
    MainFrame finestra;
    /**
     * Creates new form ControlProgress
     */
    public ControlProgres(MainFrame finestra) {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.finestra = finestra;
        BarraProgres.setValue(50);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BarraProgres = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        NomProgres = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Progrés");

        BarraProgres.setToolTipText("");

        jLabel1.setText("Calculant:");

        NomProgres.setForeground(new java.awt.Color(0, 51, 255));
        NomProgres.setText("Inicialitzant...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NomProgres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(BarraProgres, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(NomProgres))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BarraProgres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar BarraProgres;
    private javax.swing.JLabel NomProgres;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    
    public void startControl() {
        System.out.println("START CONTROL");
        setVisible(true);
        repaint();
        update(getGraphics());
        Base base = HourCalendar.getBase();

        base.generador = new Generador(base.disponibilitatsHoraries.get(0), base.assignatures);
        //base.generador.setProgressBar(BarraProgres);
        base.nomProgres = "Grau Informàtica Q2";
        System.out.println("START CONTROL INIT EXECUTE");
        base.generador.execute();
        System.out.println("START CONTROL END EXECUTE");

        Generador generador = base.generador;
        NomProgres.setOpaque(true);
        
        while (generador == null) { generador = base.generador; }
        while (!generador.finalitzat) {
            int progresValue = (int)((base.progres / (float)Regles.ITERACIONS_GENERADOR.getInt()) * 100);
            if (BarraProgres.getValue() != progresValue) {
                BarraProgres.setValue(progresValue);
                BarraProgres.update(BarraProgres.getGraphics());
            }
            if (!NomProgres.getText().equals(base.nomProgres)) {
                NomProgres.setText(base.nomProgres);
                NomProgres.getUI().update(NomProgres.getGraphics(), NomProgres);
                NomProgres.repaint();
            }
        }
        System.out.println("END CONTROL");
        
        System.out.println(generador.getHorari().toString());
        base.disponibilitatsHoraries.add(generador.getHorari());
        finestra.ContentPane.removeAll();
        System.out.println(String.valueOf(finestra.ContentPane.getComponentCount()));
        finestra.ContentPane.add(new JTextArea(0,0));
        GridBagConstraints constraints = new GridBagConstraints();
        //constraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        constraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.anchor = GridBagConstraints.PAGE_START;
        constraints.weightx = 1.0;
        constraints.weighty = 0.0;
        constraints.gridx = 0;
        constraints.insets = new Insets(0,0,0,16);
        /*c.fill = GridBagConstraints.HORIZONTAL;
c.ipady = 40;      //make this component tall
c.weightx = 0.0;
c.gridwidth = 3;
c.gridx = 0;
c.gridy = 1;*/
        //HourCalendar.getMainFrame().Contenidor.setVisible(true);
        HourCalendar.getMainFrame().showTabsHeader = true;
        HourCalendar.getMainFrame().TabbedPane.setSelectedIndex(1);
        HourCalendar.getMainFrame().Informe.setText("<html><body style=\"font-family: Verdana,Tahoma,sans-serif; font-size: 10px;\">".concat(base.informe).concat("</body></html>"));
        HourCalendar.getMainFrame().revalidate();
        HourCalendar.getMainFrame().repaint();
        //constraints.gridheight = GridBagConstraints.
        //constraints.weightx = 1.0; //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        //Inserim instancies de PanellHorari per a cada disponibilitat
        int alturaPanell = 0;
        Vector<DisponibilitatHoraria> disponibilitats = base.getDisponibilitatsHoraries();
        for (int idDisponibilitat = 0; idDisponibilitat < disponibilitats.size(); ++idDisponibilitat) {
            System.out.println("COMPTADOR DISPONIBILITATS");
            PanellHorari horari = new PanellHorari(disponibilitats.elementAt(idDisponibilitat));
            System.out.println("\t\t\t\t\tALTURA PANELL += ".concat(String.valueOf(horari.getPreferredSize().height)));
            alturaPanell += horari.getPreferredSize().height;
            //horari.add(new JTextArea(10,5));
            //finestra.Contenidor.setViewportView(horari);
            //finestra.Contenidor.getLayout().addLayoutComponent("WOLOLO!!", horari);
            //finestra.Contenidor.getViewport().add(horari);
            //finestra.Contenidor.getViewport().add(new JTextArea(10,5));
            //finestra.Contenidor.getViewport().add(horari);
            //finestra.Contenidor.getViewport().add(horari);
            //finestra.ContentPane.add(new JTextArea(0,0));
            System.out.println(String.valueOf(finestra.ContentPane.getComponentCount()));
            //horari.setSize(finestra.Contenidor.getWidth(), 300);//horari.TaulaHorari.getHeight());
            finestra.ContentPane.add(horari, constraints);
            constraints = (GridBagConstraints) constraints.clone();
            constraints.anchor = GridBagConstraints.CENTER;
            System.out.println(String.valueOf(finestra.ContentPane.getComponentCount()));
            //finestra.ContentPane.add(horari);
            //finestra.ContentPane.add(new JTextArea(50,50), constraints);
            //finestra.ContentPane.add(new JTextArea(10,10), constraints);
            //alturaPanell +=80;

            
            /*System.out.println("DIMENSIO HORARI");
            horari.setSize(finestra.Contenidor.getWidth(), 300);//horari.TaulaHorari.getHeight());
            System.out.println(String.valueOf(horari.getWidth()));
            System.out.println(String.valueOf(horari.getHeight()));
            horari.setVisible(true);
            horari.repaint();
            finestra.Contenidor.repaint();*/
        }
        
        finestra.ContentPane.setPreferredSize(new Dimension(finestra.ContentPane.getWidth(), alturaPanell - 16));
        finestra.ContentPane.setMinimumSize(new Dimension(finestra.ContentPane.getWidth(), alturaPanell - 16));
        finestra.ContentPane.revalidate();
        finestra.ContentPane.repaint();
        setVisible(false);
        System.out.println(String.valueOf(finestra.ContentPane.getComponentCount()));
    }
}
