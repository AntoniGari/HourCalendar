package hourcalendar;

import hourcalendar.Base.Regles;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FormulariOpcions extends javax.swing.JFrame {
    static javax.swing.JFrame frameCalendari;
    private boolean inicialitzat = false;

    /**
     * Creates new form FormulariOpcions
     */
    public FormulariOpcions() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        solapar.setText(Regles.SOLAPAR_HORES_PRACTICA.getMissatge());
        solapar.setSelected(Regles.SOLAPAR_HORES_PRACTICA.get());
        assignar.setText(Regles.ASSIGNAR_HORES_RESTANTS.getMissatge());
        assignar.setSelected(Regles.ASSIGNAR_HORES_RESTANTS.get());
        prioritzar.setText(Regles.PRIORITZAR_QUADRAR_HORES.getMissatge());
        prioritzar.setSelected(Regles.PRIORITZAR_QUADRAR_HORES.get());
        textIteracions.setText(Regles.ITERACIONS_GENERADOR.getMissatge());
        iteracions.setText(String.valueOf(Regles.ITERACIONS_GENERADOR.getInt()));
        quadrimestre.setSelectedIndex(Regles.QUADRIMESTRE.getInt() - 1);
        textQuadrimestre.setText(String.valueOf(Regles.QUADRIMESTRE.getMissatge()));
        convocatoria.setSelectedIndex(Regles.CONVOCATORIA.getInt() - 1);
        textConvocatoria.setText(String.valueOf(Regles.CONVOCATORIA.getMissatge()));
        modsCalendari.setText(Regles.APLICAR_MODS_CALENDARI.getMissatge());
        modsCalendari.setSelected(Regles.APLICAR_MODS_CALENDARI.get());
        
        updateDisponibilitatHoraria();
        inicialitzat = true;
    }
    
    public void updateDisponibilitatHoraria() {
        HourCalendar.getBase().updateDisponibilitatHoraria();
        DisponibilitatsHoraries.setText("<html><body style=\"font-family: Verdana,Tahoma,sans-serif; font-size: 8px;\">".concat(HourCalendar.getBase().disponibilitatsHoraries.get(0).toHTML()).concat("</body></html>"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        solapar = new javax.swing.JCheckBox();
        assignar = new javax.swing.JCheckBox();
        prioritzar = new javax.swing.JCheckBox();
        iteracions = new javax.swing.JTextField();
        textIteracions = new javax.swing.JLabel();
        BotoGenerar = new javax.swing.JButton();
        BotoCancelar = new javax.swing.JButton();
        quadrimestre = new javax.swing.JComboBox();
        textQuadrimestre = new javax.swing.JLabel();
        textConvocatoria = new javax.swing.JLabel();
        convocatoria = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        DisponibilitatsHoraries = new javax.swing.JEditorPane();
        BotoModificarCalendari = new javax.swing.JButton();
        modsCalendari = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Opcions");
        setResizable(false);

        solapar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        solapar.setText("text");
        solapar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        solapar.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        solapar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                solaparPropertyChange(evt);
            }
        });

        assignar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        assignar.setText("text");
        assignar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        assignar.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        prioritzar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        prioritzar.setText("text");
        prioritzar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        prioritzar.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        iteracions.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        iteracions.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        iteracions.setText("jTextField1");

        textIteracions.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        textIteracions.setText("jLabel1");
        textIteracions.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        BotoGenerar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        BotoGenerar.setText("Generar");
        BotoGenerar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotoGenerarMouseClicked(evt);
            }
        });
        BotoGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotoGenerarActionPerformed(evt);
            }
        });

        BotoCancelar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        BotoCancelar.setText("Cancel·lar");
        BotoCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotoCancelarMouseClicked(evt);
            }
        });

        quadrimestre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        quadrimestre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Q1", "Q2" }));
        quadrimestre.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                quadrimestrePropertyChange(evt);
            }
        });

        textQuadrimestre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        textQuadrimestre.setText("jLabel1");
        textQuadrimestre.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        textConvocatoria.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        textConvocatoria.setText("jLabel1");
        textConvocatoria.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        convocatoria.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        convocatoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2012 - 2013" }));
        convocatoria.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                convocatoriaPropertyChange(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Disponibilitat Horària"));

        jScrollPane2.setBorder(null);
        jScrollPane2.setOpaque(false);

        DisponibilitatsHoraries.setBorder(null);
        DisponibilitatsHoraries.setContentType("text/html"); // NOI18N
        DisponibilitatsHoraries.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        DisponibilitatsHoraries.setText("<html>\r\n  <head>\r\n\r\n  </head>\r\n  <body>\r\n    <p style=\"margin-top: 0\">\r\n      \r-- output --\n    </p>\r\n  </body>\r\n</html>\r\n");
        DisponibilitatsHoraries.setOpaque(false);
        jScrollPane2.setViewportView(DisponibilitatsHoraries);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        BotoModificarCalendari.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        BotoModificarCalendari.setText("Modificar Calendari!");
        BotoModificarCalendari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotoModificarCalendariMouseClicked(evt);
            }
        });

        modsCalendari.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        modsCalendari.setText("text");
        modsCalendari.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        modsCalendari.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        modsCalendari.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                modsCalendariPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BotoModificarCalendari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotoCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotoGenerar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(convocatoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(quadrimestre, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textQuadrimestre, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                            .addComponent(textConvocatoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(prioritzar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(assignar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(solapar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(iteracions)
                        .addGap(10, 10, 10)
                        .addComponent(textIteracions, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
                    .addComponent(modsCalendari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quadrimestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textQuadrimestre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(convocatoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textConvocatoria, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(solapar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(assignar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prioritzar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(modsCalendari)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textIteracions, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iteracions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotoGenerar)
                    .addComponent(BotoCancelar)
                    .addComponent(BotoModificarCalendari))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void solaparPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_solaparPropertyChange
        
    }//GEN-LAST:event_solaparPropertyChange

    private void BotoGenerarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotoGenerarMouseClicked
        // TODO add your handling code here:
        Regles.SOLAPAR_HORES_PRACTICA.set(solapar.isSelected());
        Regles.ASSIGNAR_HORES_RESTANTS.set(assignar.isSelected());
        Regles.PRIORITZAR_QUADRAR_HORES.set(prioritzar.isSelected());
        Regles.ITERACIONS_GENERADOR.set(Integer.parseInt(iteracions.getText()));
        Regles.QUADRIMESTRE.set(quadrimestre.getSelectedIndex() + 1);
        Regles.CONVOCATORIA.set(convocatoria.getSelectedIndex() + 1);
        Regles.APLICAR_MODS_CALENDARI.set(modsCalendari.isSelected());
        
        //Mostrem el control de progrés
        Base base = HourCalendar.getBase();
        MainFrame mainFrame = HourCalendar.getMainFrame();
        mainFrame.controlProgres.setVisible(true);
        System.out.println("START UPDATE");
        //base.updateDisponibilitatHoraria(2, 2013);
        System.out.println("END UPDATE");
        mainFrame.controlProgres.startControl();
        
        //ocultem el formulari d'opcions
        setVisible(false);
        dispose();
    }//GEN-LAST:event_BotoGenerarMouseClicked

    private void BotoCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotoCancelarMouseClicked
        // TODO add your handling code here:
        setVisible(false);
        dispose();
    }//GEN-LAST:event_BotoCancelarMouseClicked

    private void BotoGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotoGenerarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotoGenerarActionPerformed

    private void BotoModificarCalendariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotoModificarCalendariMouseClicked
        SwingUtilities.invokeLater(new Runnable() { 
			@Override
			public void run() {
				SelectorDiesDocencia selectorDiesDocencia = new SelectorDiesDocencia();
				frameCalendari = new JFrame();
				frameCalendari.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                frameCalendari.setLocation(dim.width/2-frameCalendari.getSize().width/2, dim.height/2-frameCalendari.getSize().height/2);
				Container panel = frameCalendari.getContentPane();
				panel.setLayout(new BorderLayout());
				panel.add(selectorDiesDocencia, BorderLayout.CENTER);
				frameCalendari.pack();
				frameCalendari.setSize(441, 234);    //(435,206);
                frameCalendari.setResizable(false);
				frameCalendari.setVisible(true);
			}
		});
    }//GEN-LAST:event_BotoModificarCalendariMouseClicked

    private void quadrimestrePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_quadrimestrePropertyChange
        HourCalendar.getBase().dbgUI("QUADRIMESTRE property changed!");
        if (inicialitzat) {
            Regles.QUADRIMESTRE.set(quadrimestre.getSelectedIndex() + 1);
            updateDisponibilitatHoraria();
        }
    }//GEN-LAST:event_quadrimestrePropertyChange

    private void convocatoriaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_convocatoriaPropertyChange
        if (inicialitzat) {
            Regles.CONVOCATORIA.set(convocatoria.getSelectedIndex() + 1);
            updateDisponibilitatHoraria();
        }
    }//GEN-LAST:event_convocatoriaPropertyChange

    private void modsCalendariPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_modsCalendariPropertyChange
        if (inicialitzat) {
            Regles.APLICAR_MODS_CALENDARI.set(modsCalendari.isSelected());
            updateDisponibilitatHoraria();
        }
    }//GEN-LAST:event_modsCalendariPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotoCancelar;
    private javax.swing.JButton BotoGenerar;
    private javax.swing.JButton BotoModificarCalendari;
    private javax.swing.JEditorPane DisponibilitatsHoraries;
    private javax.swing.JCheckBox assignar;
    private javax.swing.JComboBox convocatoria;
    private javax.swing.JTextField iteracions;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JCheckBox modsCalendari;
    private javax.swing.JCheckBox prioritzar;
    private javax.swing.JComboBox quadrimestre;
    private javax.swing.JCheckBox solapar;
    private javax.swing.JLabel textConvocatoria;
    private javax.swing.JLabel textIteracions;
    private javax.swing.JLabel textQuadrimestre;
    // End of variables declaration//GEN-END:variables
}
