/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hourcalendar;

import com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI;
//import com.sun.java.swing.plaf.windows.WindowsTableHeaderUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.Vector;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
//import javax.swing.plaf.basic.BasicTabbedPaneUI;

/**
 *
 * @author admin
 */
public class MainFrame extends javax.swing.JFrame {
    static javax.swing.JFrame frameCalendari;
    public JPanel ContentPane;
    public ControlProgres controlProgres;
    public boolean showTabsHeader = false;
    public FormulariOpcions formulariOpcions;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        setExtendedState( getExtendedState()|JFrame.MAXIMIZED_BOTH );
        
        formulariOpcions = new FormulariOpcions();
        controlProgres = new ControlProgres(this);
        controlProgres.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        controlProgres.setVisible(false);

        ContentPane = new JPanel();
        ContentPane.setLayout(new GridBagLayout());
        ContentPane.setPreferredSize(new Dimension(Contenidor.getWidth(), Contenidor.getHeight()));
        //ContentPane.setBackground(Color.YELLOW);
        JLabel label = new JLabel("");
        ContentPane.add(label);
        Contenidor.setViewportView(ContentPane);
        //Contenidor.setBackground(Color.YELLOW);
        //Contenidor.setVisible(false);
        
        TabbedPane.setUI(new WindowsTabbedPaneUI() {
			@Override
			protected int calculateTabAreaHeight(int tabPlacement, int horizRunCount, int maxTabHeight) {
                HourCalendar.getBase().dbgUI("CALCULATETABAREAHEIGHT".concat(String.valueOf(tabPlacement)).concat(" - ").concat(String.valueOf(horizRunCount)));
				if (showTabsHeader) {
					return super.calculateTabAreaHeight(tabPlacement, horizRunCount, maxTabHeight);
				} else {
					return 0;
				}
			}
            @Override
            protected void paintTab(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect) {
                if (showTabsHeader) {
                    super.paintTab(g, tabPlacement, rects, tabIndex, iconRect, textRect);
                }
            }

		});

        
        //Contenidor.setLayout(new GridLayout(3,1));
        updateAssignatures();
    }
    
    public void updateAssignatures() {
        PanellAssignatures.removeAll();
        Base base = HourCalendar.getBase();
        int numAssignatures = base.getNumAssignatures();
        for (int i = 0; i < numAssignatures; ++i) {
            AssignaturaPane a = new AssignaturaPane(base.getAssignaturaAt(i));  
            a.setSize(300,50);  
            a.setVisible(true);  
            PanellAssignatures.add(a);
            PanellAssignatures.add(Box.createRigidArea(new Dimension(0,3)));
        }
        PanellAssignatures.revalidate();
        PanellAssignatures.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        PopupCrear = new javax.swing.JPopupMenu();
        CrearAssignatura = new javax.swing.JMenuItem();
        CrearGrau = new javax.swing.JMenuItem();
        CrearTipusAula = new javax.swing.JMenuItem();
        CrearTipusMateria = new javax.swing.JMenuItem();
        CrearAula = new javax.swing.JMenuItem();
        TabbedPane = new javax.swing.JTabbedPane();
        TabAssignatures = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        BotoCrear = new javax.swing.JButton();
        BotoGenerarHorari = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        PanellAssignatures = new javax.swing.JPanel();
        Contenidor = new javax.swing.JScrollPane();
        TabInforme = new javax.swing.JScrollPane();
        Informe = new javax.swing.JEditorPane();

        PopupCrear.setBackground(new java.awt.Color(255, 51, 51));
        PopupCrear.setInvoker(BotoCrear);
        PopupCrear.setLabel("asdasd");
        PopupCrear.setMinimumSize(new java.awt.Dimension(100, 50));

        CrearAssignatura.setText("Assignatura");
        CrearAssignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearAssignaturaActionPerformed(evt);
            }
        });
        PopupCrear.add(CrearAssignatura);

        CrearGrau.setText("Grau");
        CrearGrau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearGrauActionPerformed(evt);
            }
        });
        PopupCrear.add(CrearGrau);

        CrearTipusAula.setText("Tipus d'aula");
        CrearTipusAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearTipusAulaActionPerformed(evt);
            }
        });
        PopupCrear.add(CrearTipusAula);

        CrearTipusMateria.setText("Tipus de matèria");
        CrearTipusMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearTipusMateriaActionPerformed(evt);
            }
        });
        PopupCrear.add(CrearTipusMateria);

        CrearAula.setText("Aula");
        CrearAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearAulaActionPerformed(evt);
            }
        });
        PopupCrear.add(CrearAula);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HourCalendar");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        TabbedPane.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        TabAssignatures.setBackground(new java.awt.Color(255, 255, 255));
        TabAssignatures.setBorder(null);
        TabAssignatures.setPreferredSize(new java.awt.Dimension(400, 300));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setOpaque(false);

        BotoCrear.setText("Crear");
        BotoCrear.setOpaque(false);
        BotoCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotoCrearMouseClicked(evt);
            }
        });

        BotoGenerarHorari.setText("Generar horari");
        BotoGenerarHorari.setOpaque(false);
        BotoGenerarHorari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotoGenerarHorariMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(242, Short.MAX_VALUE)
                .addComponent(BotoCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotoGenerarHorari))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(BotoCrear)
                .addComponent(BotoGenerarHorari))
        );

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Assignatures:");

        PanellAssignatures.setBackground(new java.awt.Color(255, 255, 204));
        PanellAssignatures.setOpaque(false);
        PanellAssignatures.setLayout(new javax.swing.BoxLayout(PanellAssignatures, javax.swing.BoxLayout.PAGE_AXIS));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanellAssignatures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanellAssignatures, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addContainerGap())
        );

        TabAssignatures.setViewportView(jPanel4);

        TabbedPane.addTab("Assignatures", TabAssignatures);

        Contenidor.setBackground(new java.awt.Color(255, 255, 255));
        Contenidor.setBorder(null);
        TabbedPane.addTab("Horari generat", Contenidor);

        TabInforme.setBackground(new java.awt.Color(255, 255, 255));
        TabInforme.setBorder(null);

        Informe.setEditable(false);
        Informe.setBorder(null);
        Informe.setContentType("text/html"); // NOI18N
        Informe.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        Informe.setText("<html>\n  <head>\n\n  </head>\n  <body style=\"font-family: Verdana,Tahoma,sans-serif; font-size: 10px; color: #666666; margin: 5px 15px 5px 15px;\">\n    <h1>PROJECTE DE PROGRAMACIÓ</h1>\n    <br>\n    <h2>HourCalendar</h2>\n    <p style=\"margin-top: 0;\">\n      Integrants del grup en ordre alfabètic:\n    </p>\n    <ul style=\"list-style-type: none; padding-left: 0px; margin-left: 20px;\">\n      <li><b>Antoni Garí</b></li>\n      <li><b>Cristina Nogués</b></li>\n      <li><b>Daniel Santos</b></li>\n      <li><b>Raimon Beltran</b></li>\n    </ul>\n    <p style=\"margin-top: 0;\">Per al desenvolupament del projecte hem utilitzat la versió <b>1.7</b> del <b>JDK</b> en <b>NetBeans 7.3</b> i per a poder treballar en grup hem utilitzat el sistema de control de versions <b>GIT</b> en un repositori a GitHub públic, al que s'hi pot accedir des d'aquí:</p>\n    <p><a href=\"http://github.com/CristinaNogues/HourCalendar\">http://github.com/CristinaNogues/HourCalendar</a></p>\n    <br>\n    <h2>Estat del projecte</h2>\n    <p style=\"margin-top: 0;\">L'aplicació és completament funcional i lliure d'errors en temps d'execució, almenys, tots els errors que s'han anat trobant s'han arreglat i durant les últimes proves no n'hem detectat més.</p>\n    <p>Als següents apartats expliquem detalladament les característiques de l'aplicació, les funcionalitats que no s'han arribat a implementar i l'estructura utilitzada a l'algorisme per a la generació dels diferents horaris.</p>\n    <br>\n    <h2>Característiques</h2>\n    <ul style=\"list-style-type: decimal; padding-left: 0px; margin-left: 20px;\">\n      <li style=\"margin-bottom: 5px;\">Formularis per a crear noves assignatures, graus, tipus de matèries, tipus d'aules i aules.</li>\n      <li style=\"margin-bottom: 5px;\">Permet editar les assignatures i les aules existents.</li>\n      <li style=\"margin-bottom: 5px;\">Recuperació dels conjunts de dades introduïts durant l'última execució de l'aplicació incorporant també les opcions per a utilitzar un conjunt de dades nou o un de predefinit.</li>\n      <li style=\"margin-bottom: 5px;\">Generació d'horaris per a tots els graus i els cursos.</li>\n      <li style=\"margin-bottom: 5px;\">Permet escollir entre generar els horaris per al Quadrimestre 1 o 2.</li>\n      <li style=\"margin-bottom: 5px;\">Proporciona un conjunt d'opcions a l'hora de generar els horaris que influeixen directament a l'horari generat.</li>\n      <li style=\"margin-bottom: 5px;\">Permet fàcilment l'edició del calendari de dies amb docència permetent a l'usuari indicar quins són els dies lectius.</li>\n      <li style=\"margin-bottom: 5px;\">Opcionalment, permet activar les modificacions del calendari establertes per al curs 2012-2013 per la UPC, fent que hi hagi el mateix número de dies per a tots els dies de la setmana.</li>\n      <li style=\"margin-bottom: 5px;\">Permet limitar el número de permutacions utilitzades per a generar el calendari i així poder agilitzar el procés.</li>\n      <li style=\"margin-bottom: 5px;\">Durant la generació dels horaris, mostra una barra de progrés que va informant a l'usuari de l'estat del procés.</li>\n      <li style=\"margin-bottom: 5px;\">Per a cada horari generat, proporciona l'habilitat de filtrar la visualització de les classes dels diferents grups de pràctiques.</li>\n      <li>Proporciona un conjunt de dades per defecte amb totes les dades presents a la pàgina web de la universitat.</li>\n    </ul>\n    <br>\n    <h2>Funcionalitats pendents</h2>\n    <p style=\"margin-top: 0;\">A causa de la falta de temps per a la implementació del projecte, ens han quedat algunes funcionalitats pendents d'implementar i les hem llistat a continuació.</p>\n    <ul style=\"list-style-type: decimal; padding-left: 0px; margin-left: 20px;\">\n      <li style=\"margin-bottom: 5px;\">A la part d'ocupació d'aules, si que hem implementat la repartició d'aules sense que hi hagi solapaments en cap dels horaris que es generen però aquesta repartició s'aplica una vegada s'ha generat l'horari i no es té en compte si hi ha suficients aules de cada tipus durant la generació dels diferents horaris.</li>\n      <li style=\"margin-bottom: 5px;\">No s'ha tingut en compte el possible solapament horari per a assignatures de cursos adjacents d'un mateix grau. De manera, que si un alumne escull assignatures dels cursos 1 i 3, per exemple, probablement se li solapin hores de classe de vàries assignatures.</li>\n      <li>No s'ha tingut en compte la capacitat de les aules ja que tampoc hem tingut en compte el número d'alumnes de les assignatures.</li>\n    </ul>\n    <br>\n    <h2>Estructura de l'algorisme</h2>\n    <p>Partint d'una instància de la classe DisponibilitatHoraria que ens proporciona la quantitat de dies disponibles, per exemple, 14 dilluns dels quals 4 en setmana 11, 3 en setmana 21, etc. la qual hem anomenat disponibilitatHorariaInicial, procedim a la generació dels diferents horaris de la següent manera:</p>\n    <p>Per a cada Grau i cada curs, n'obtenim les assignatures que passaran a formar part d'un horari, aquestes, les passem com a paràmetre d'una nova instància de la classe Generador.</p>\n    <p>A la classe generador, trenquem cada una de les assignatures en subgrups anomenats Items, on un dels subgrups serà les hores conjuntes, i els altres les hores per a cada un dels grups de pràctiques que formen una assignatura. De manera, que per exemple el Curs 4 D'informàtica tindrà uns 18 o 20 items. Degut a que la distribució d'aquests items ens acaben proporcionant diferents horaris, els quals poden ser millor o pitjor, hem dotat al generador de la capacitat de reordenar el conjunt d'items N vegades, generant un horari per a cada una de les permutacions i al final, quedar-nos amb la que ens ha proporcionat una millor ponderació. <b>Degut a que les diferents permutacions d'aquests items és el factorial del número d'items, s'ha optat per proporcionar el límit d'iteracions al formulari d'opcions.</b> (18! és 6402373705728000). A cada iteració, per a cada un dels items es crida al mètode addReserva() d'un clon de la disponibilitatHorariaInicial per a que aquesta vaigi fent les reserves necessàries per representar els diferents Items.</p>\n    <p>La classe DisponibilitatHoraria, a part de proporcionar-nos la quantitat de dies disponibles, també ens proporciona la funcionalitat de reservar les hores per als diferents items, mitjançant una implementació de l'algorisme de cerca en profunditat amb funció heurística. Cada instància de DisponibilitatHoraria té les seves instàncies de la subclasse DiaDeLaSetmana, que ens proporciona les ocupacions de classes d'un dia de la setmana agrupades pels diferents tipus de setmana (s11, s21, etc). La classe DiaDeLaSetmana és la que ens proporciona les operacions esencials per a l'avaluació de la repartició de classes d'aquest dia.</p>\n    <p>Aquesta funció d'avaluació fa ús de la classe HoresRepresentables, la qual ens proporciona l'agrupació i el solapament de reserves en una mateixa hora del dia ja que fins ara, la classe DiaDeLaSetmana, tenia com a reserves diferents,  per exemple, PROP I45 :s11, PROP I45 :s12, XACO I4511 :s11 i AMEP I4512 :s11. DiaDeLaSetmana representaria aquestes reserves una a cada hora però mitjançant l'ús d'HoresRepresentables, ens les ha agrupat i solapat en una sola hora.</p>\n    <p>HoresRepresentables utilitza una subclasse anomenada ClasseAgrupada, que ens agrupa les classes d'una mateixa assignatura i grup en setmanes diferents. Partint de l'exemple anterior, PROP I45 :s11 i PROP I45 :s12 passarien a ser una sola ClasseAgrupada amb el nom de PROP I45 :s1.</p>\n    <p>Una vegada s'han realitzat totes les permutacions (limitades) per a cada Grau i cada curs, aquestes es passen com a paràmetre de noves instàncies de TaulellHorari, que és qui s'encarrega de representar gràficament els resultats obtinguts però també, cada vegada que ha de representar una nova ClasseAgrupada, li assigna una aula mitjançant una crida a l'única instància de la classe OcupacioAules, la qual per a cada dia de la setmana, cada tipus de setmana (:s11, :s21, etc) i cada hora del dia té una instància de la classe DisponibilitatAules, que és la classe que s'encarrega de gestionar l'ocupació de totes les aules d'una hora determinada.</p>\n    <br>\n  </body>\n</html>");
        Informe.setAutoscrolls(false);
        Informe.setCaretPosition(0);
        TabInforme.setViewportView(Informe);

        TabbedPane.addTab("Informació del projecte", TabInforme);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(TabbedPane, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CrearAssignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearAssignaturaActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormulariAssignatura().setVisible(true);
            }
        });
    }//GEN-LAST:event_CrearAssignaturaActionPerformed

    private void BotoCrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotoCrearMouseClicked
        // TODO add your handling code here:
        PopupCrear.show(BotoCrear, 0, BotoCrear.getHeight());
    }//GEN-LAST:event_BotoCrearMouseClicked

    private void CrearGrauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearGrauActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormulariGrau().setVisible(true);
            }
        });
    }//GEN-LAST:event_CrearGrauActionPerformed

    private void CrearTipusAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearTipusAulaActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormulariTipusAula().setVisible(true);
            }
        });
    }//GEN-LAST:event_CrearTipusAulaActionPerformed

    private void CrearTipusMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearTipusMateriaActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormulariTipusMateria().setVisible(true);
            }
        });
    }//GEN-LAST:event_CrearTipusMateriaActionPerformed

    private void CrearAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearAulaActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormulariAula().setVisible(true);
            }
        });
    }//GEN-LAST:event_CrearAulaActionPerformed

    private void BotoGenerarHorariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotoGenerarHorariMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                formulariOpcions.setVisible(true);
            }
        });
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
    public javax.swing.JButton BotoCrear;
    private javax.swing.JButton BotoGenerarHorari;
    public javax.swing.JScrollPane Contenidor;
    private javax.swing.JMenuItem CrearAssignatura;
    private javax.swing.JMenuItem CrearAula;
    private javax.swing.JMenuItem CrearGrau;
    private javax.swing.JMenuItem CrearTipusAula;
    private javax.swing.JMenuItem CrearTipusMateria;
    public javax.swing.JEditorPane Informe;
    public javax.swing.JPanel PanellAssignatures;
    public javax.swing.JPopupMenu PopupCrear;
    public javax.swing.JScrollPane TabAssignatures;
    private javax.swing.JScrollPane TabInforme;
    public javax.swing.JTabbedPane TabbedPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
