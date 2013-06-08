/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hourcalendar;

import hourcalendar.Base.Regles;
import hourcalendar.HoresRepresentables.ClasseAgrupada;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author admin
 */
public class PanellHorari extends javax.swing.JPanel {
    private DisponibilitatHoraria disponibilitat;
    private boolean esUpdate = false;
    /**
     * Creates new form PanellHorari
     */
    public PanellHorari(DisponibilitatHoraria _disponibilitat) {
        initComponents();
        disponibilitat = _disponibilitat;
        //Cel·les multilinia
        for (int i = 0; i <= 5; ++i) {
            TaulaHorari.getColumnModel().getColumn(i).setCellRenderer(new TextAreaRenderer());
            TaulaHorari.getColumnModel().getColumn(i).setHeaderRenderer(new TextAreaRenderer());
        }
        
        TaulaHorari.getColumnModel().getColumn(0).setWidth(75);
        TaulaHorari.getColumnModel().getColumn(0).setPreferredWidth(75);
        TaulaHorari.getColumnModel().getColumn(0).setMinWidth(75);
        TaulaHorari.getColumnModel().getColumn(0).setMaxWidth(75);
        
        update();
        
        FiltreGrup1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                update();
            }
        });
        
        esUpdate = true;
    }
    
    private void update() {
        Regles.DEBUG_ENABLED.set(true);
        if (!this.esUpdate) {
            FiltreGrup1.setVisible(false);
            FiltreGrup2.setVisible(false);
            FiltreGrup3.setVisible(false);
            FiltreGrup4.setVisible(false);
            FiltreGrup5.setVisible(false);
            FiltreGrup6.setVisible(false);
            FiltreGrup7.setVisible(false);
            FiltreGrup8.setVisible(false);
        }
        
        
        Vector<DisponibilitatHoraria.DiaDeLaSetmana> dies = disponibilitat.getDisponibilitat();
        Vector<ClasseAgrupada> classes = new Vector<ClasseAgrupada>();
        String newLine = System.getProperty("line.separator");
        int maxHoresOcupades = 0;
        TaulaHorari.setSize(300, 400);
        System.out.println("DIMENSIO TAULA: ".concat(String.valueOf(TaulaHorari.getWidth())).concat(", ").concat(String.valueOf(TaulaHorari.getHeight())));
        for (int idDia = 2; idDia <= 6; ++idDia) {
            DisponibilitatHoraria.DiaDeLaSetmana dia = dies.get(idDia);
            HoresRepresentables horesRepresentables = dia.getHoresRepresentables();
            for (int hora = horesRepresentables.size(); --hora >= 0;) {
                classes = horesRepresentables.get(hora);
                String text = "";
                for (int index = classes.size(); --index >= 0;) {
                    ClasseAgrupada classe = classes.get(index);
                    if (!this.esUpdate) {
                        if (classe.grup != 0) {
                            //Inicialitzem valors dels checkbox de filtres per a grups de pràctiques
                            switch (classe.grup) {
                                case 1:
                                    FiltreGrup1.setText(classe.grupAsText);
                                    FiltreGrup1.setVisible(true);
                                    break;
                                case 2:
                                    FiltreGrup2.setText(classe.grupAsText);
                                    FiltreGrup2.setVisible(true);
                                    break;
                                case 3:
                                    FiltreGrup3.setText(classe.grupAsText);
                                    FiltreGrup3.setVisible(true);
                                    break;
                                case 4:
                                    FiltreGrup4.setText(classe.grupAsText);
                                    FiltreGrup4.setVisible(true);
                                    break;
                                case 5:
                                    FiltreGrup5.setText(classe.grupAsText);
                                    FiltreGrup5.setVisible(true);
                                    break;
                                case 6:
                                    FiltreGrup6.setText(classe.grupAsText);
                                    FiltreGrup6.setVisible(true);
                                    break;
                                case 7:
                                    FiltreGrup7.setText(classe.grupAsText);
                                    FiltreGrup7.setVisible(true);
                                    break;
                                case 8:
                                    FiltreGrup8.setText(classe.grupAsText);
                                    FiltreGrup8.setVisible(true);
                                    break;
                                
                            }
                        }
                    } else {
                        //Si el grup està filtrat (no seleccionat) passem al següent
                        if (classe.grup != 0) {
                            //Inicialitzem valors dels checkbox de filtres per a grups de pràctiques
                            switch (classe.grup) {
                                case 1:
                                    if (!FiltreGrup1.isSelected()) continue;
                                    break;
                                case 2:
                                    if (!FiltreGrup2.isSelected()) continue;
                                    break;
                                case 3:
                                    if (!FiltreGrup3.isSelected()) continue;
                                    break;
                                case 4:
                                    if (!FiltreGrup4.isSelected()) continue;
                                    break;
                                case 5:
                                    if (!FiltreGrup5.isSelected()) continue;
                                    break;
                                case 6:
                                    if (!FiltreGrup6.isSelected()) continue;
                                    break;
                                case 7:
                                    if (!FiltreGrup7.isSelected()) continue;
                                    break;
                                case 8:
                                    if (!FiltreGrup8.isSelected()) continue;
                                    break;
                                
                            }
                        }
                    }
                    text = text.concat(classe.toString()).concat(newLine);
                }
                TaulaHorari.getModel().setValueAt(text, hora, idDia - 1);
                if (maxHoresOcupades < hora) maxHoresOcupades = hora;
            }
        }
        System.out.println("DIMENSIO TAULA: ".concat(String.valueOf(TaulaHorari.getWidth())).concat(", ").concat(String.valueOf(TaulaHorari.getHeight())));
        System.out.println("ROW COUNT = ".concat(String.valueOf(TaulaHorari.getRowCount())));
        for (int i = 0; i < TaulaHorari.getRowCount() && TaulaHorari.getRowCount() > maxHoresOcupades; ++i) {
            System.out.println("REMOVING!!");
            ((DefaultTableModel)TaulaHorari.getModel()).removeRow(TaulaHorari.getRowCount() - 1);
        }
        System.out.println("DIMENSIO TAULA: ".concat(String.valueOf(TaulaHorari.getX())).concat(", ").concat(String.valueOf(TaulaHorari.getY())));
        this.setPreferredSize(new Dimension(600, 84 + 32 - 3 + (96 * maxHoresOcupades)));
        this.setMinimumSize(new Dimension(600, 84 + 32 - 3 + (96 * maxHoresOcupades)));
        //this.setPreferredSize(new Dimension());
        //jScrollPane1.setPreferredSize(this.getWidth(), 800);
        revalidate();
        repaint();
    }
    
    
    public class TextAreaRenderer extends JTextArea implements TableCellRenderer {

        public TextAreaRenderer() {
            setLineWrap(true);
            setWrapStyleWord(true);
        }

        public Component getTableCellRendererComponent(JTable jTable, Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
            String text = (String)obj;
            setText(text);
            setMargin(new Insets(3, 0, 3, 0));
            if (row == -1) {
                setBackground(new Color(52, 136, 187));
                setForeground(new Color(255, 255, 255));
                //Font font = getFont();
                //font.getF
                setFont(new Font("Arial", Font.BOLD, 14));
            } else if (text != null && !text.isEmpty() && column != 0) {
                setBackground(new Color(238, 245, 255));
                setForeground(new Color(88, 87, 146));
            } else {
                setBackground(Color.WHITE);
                setForeground(new Color(88, 87, 146));
                //setText(getSize().toString());
            }
            return this;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        FiltreGrup1 = new javax.swing.JCheckBox();
        FiltreGrup2 = new javax.swing.JCheckBox();
        FiltreGrup3 = new javax.swing.JCheckBox();
        FiltreGrup4 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        TaulaHorari = new javax.swing.JTable();
        FiltreGrup5 = new javax.swing.JCheckBox();
        FiltreGrup6 = new javax.swing.JCheckBox();
        FiltreGrup7 = new javax.swing.JCheckBox();
        FiltreGrup8 = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(204, 255, 204));
        setMinimumSize(new java.awt.Dimension(200, 200));

        jLabel1.setBackground(javax.swing.UIManager.getDefaults().getColor("PasswordField.selectionBackground"));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Grau Informàtica Q2");
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setText("Filtre:");

        FiltreGrup1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        FiltreGrup1.setSelected(true);
        FiltreGrup1.setText("I2511");
        FiltreGrup1.setOpaque(false);

        FiltreGrup2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        FiltreGrup2.setSelected(true);
        FiltreGrup2.setText("I2512");
        FiltreGrup2.setOpaque(false);

        FiltreGrup3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        FiltreGrup3.setSelected(true);
        FiltreGrup3.setText("I2521");
        FiltreGrup3.setOpaque(false);

        FiltreGrup4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        FiltreGrup4.setSelected(true);
        FiltreGrup4.setText("I2522");
        FiltreGrup4.setOpaque(false);

        TaulaHorari.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"8:30-10:30", null, null, null, null, null},
                {"10:30-12:30", null, null, null, null, null},
                {"12:30-14:30", null, null, null, null, null},
                {"15:00-17:00", null, null, null, null, null},
                {"17:00-19:00", null, null, null, null, null},
                {"19:00-21:00", null, null, null, null, null}
            },
            new String [] {
                " Hores", " Dilluns", " Dimarts", " Dimecres", " Dijous", " Divendres"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TaulaHorari.setFillsViewportHeight(true);
        TaulaHorari.setRowHeight(96);
        jScrollPane1.setViewportView(TaulaHorari);

        FiltreGrup5.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        FiltreGrup5.setSelected(true);
        FiltreGrup5.setText("I2522");
        FiltreGrup5.setOpaque(false);

        FiltreGrup6.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        FiltreGrup6.setSelected(true);
        FiltreGrup6.setText("I2522");
        FiltreGrup6.setOpaque(false);

        FiltreGrup7.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        FiltreGrup7.setSelected(true);
        FiltreGrup7.setText("I2522");
        FiltreGrup7.setOpaque(false);

        FiltreGrup8.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        FiltreGrup8.setSelected(true);
        FiltreGrup8.setText("I2522");
        FiltreGrup8.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FiltreGrup1)
                        .addGap(10, 10, 10)
                        .addComponent(FiltreGrup2)
                        .addGap(10, 10, 10)
                        .addComponent(FiltreGrup3)
                        .addGap(10, 10, 10)
                        .addComponent(FiltreGrup4)
                        .addGap(10, 10, 10)
                        .addComponent(FiltreGrup5)
                        .addGap(10, 10, 10)
                        .addComponent(FiltreGrup6)
                        .addGap(10, 10, 10)
                        .addComponent(FiltreGrup7)
                        .addGap(10, 10, 10)
                        .addComponent(FiltreGrup8)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(FiltreGrup1)
                    .addComponent(FiltreGrup2)
                    .addComponent(FiltreGrup3)
                    .addComponent(FiltreGrup4)
                    .addComponent(FiltreGrup5)
                    .addComponent(FiltreGrup6)
                    .addComponent(FiltreGrup7)
                    .addComponent(FiltreGrup8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox FiltreGrup1;
    private javax.swing.JCheckBox FiltreGrup2;
    private javax.swing.JCheckBox FiltreGrup3;
    private javax.swing.JCheckBox FiltreGrup4;
    private javax.swing.JCheckBox FiltreGrup5;
    private javax.swing.JCheckBox FiltreGrup6;
    private javax.swing.JCheckBox FiltreGrup7;
    private javax.swing.JCheckBox FiltreGrup8;
    public javax.swing.JTable TaulaHorari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
