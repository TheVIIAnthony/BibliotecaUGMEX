/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaAdmin;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Usuario
 */
public class Registros extends javax.swing.JFrame {

    /**
     * Creates new form Registros
     */
    public Registros() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        seleccionarGraficas = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaGraficas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jLabel1.setText("Ventana de Registros");

        jLabel2.setText("Agrupar por:");

        seleccionarGraficas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--selecciona una carrera--", "Sistemas", "Psicologia", "Pedagogia", "Turismo", "Administracion", "Diseño Grafico", "Industrial", "Derecho", "Arquitectura" }));
        seleccionarGraficas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarGraficasActionPerformed(evt);
            }
        });

        TablaGraficas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TablaGraficas);

        jButton1.setText("Mostrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Gráficar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(seleccionarGraficas, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3)))
                        .addGap(54, 54, 54)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 447, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(seleccionarGraficas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void seleccionarGraficasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarGraficasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seleccionarGraficasActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Menu_admin ventana = new Menu_admin();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel miModelo;
        Graficar miGrafica = new Graficar();
        String opcion = seleccionarGraficas.getSelectedItem().toString();
        switch (opcion) {
            case "--selecciona una carrera--":
                miModelo = miGrafica.mostrarCarreras(opcion);
                TablaGraficas.setModel(miModelo);
                break;
            case "Sistemas":
                miModelo = miGrafica.mostrarCarreras(opcion);
                TablaGraficas.setModel(miModelo);
                break;
            case "Psicologia":
                miModelo = miGrafica.mostrarCarreras(opcion);
                TablaGraficas.setModel(miModelo);
                break;
            case "Pedagogia":
                miModelo = miGrafica.mostrarCarreras(opcion);
                TablaGraficas.setModel(miModelo);
                break;
            case "Turismo":
                miModelo = miGrafica.mostrarCarreras(opcion);
                TablaGraficas.setModel(miModelo);
                break;
            case "Administracion":
                miModelo = miGrafica.mostrarCarreras(opcion);
                TablaGraficas.setModel(miModelo);
                break;
            case "Diseño Grafico":
                miModelo = miGrafica.mostrarCarreras(opcion);
                TablaGraficas.setModel(miModelo);
                break;
            case "Industrial":
                miModelo = miGrafica.mostrarCarreras(opcion);
                TablaGraficas.setModel(miModelo);
                break;
            case "Derecho":
                miModelo = miGrafica.mostrarCarreras(opcion);
                TablaGraficas.setModel(miModelo);
                break;
            case "Arquitectura":
                miModelo = miGrafica.mostrarCarreras(opcion);
                TablaGraficas.setModel(miModelo);
                break;

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String opcion = seleccionarGraficas.getSelectedItem().toString();
        switch (opcion) {
            case "selecciona una opcion":
                JOptionPane.showMessageDialog(null, "selecciona una opcion para graficar");
                break;
            case "Alumnos":
                DefaultCategoryDataset dtsc = new DefaultCategoryDataset();
                for (int i = 0; i < TablaGraficas.getRowCount(); i++) {
                    dtsc.setValue(Integer.parseInt(TablaGraficas.getValueAt(i, 0).toString()),
                            TablaGraficas.getValueAt(i, 1).toString(), TablaGraficas.getValueAt(i, 2).toString());
                }
                JFreeChart ch = ChartFactory.createBarChart3D("Grafica de barras 3D", "Cantidad", "Genero", dtsc, PlotOrientation.HORIZONTAL, true, true, false);
                ChartPanel cp = new ChartPanel(ch);
                add(cp);
                cp.setBounds(500, 40, 500, 400);
                break;
            case "Carreras":
                DefaultCategoryDataset dtsc2 = new DefaultCategoryDataset();

                for (int i = 0; i < TablaGraficas.getRowCount(); i++) {
                    dtsc2.setValue(Integer.parseInt(TablaGraficas.getValueAt(i, 0).toString()), TablaGraficas.getValueAt(i, 1).toString(),
                            TablaGraficas.getValueAt(i, 2).toString());
                }
                JFreeChart ch2 = ChartFactory.createBarChart3D("Grafica de barras 3D", "Cantidad", "Genero", dtsc2,
                        PlotOrientation.HORIZONTAL, true, true, false);
                ChartPanel cp2 = new ChartPanel(ch2);
                add(cp2);
                cp2.setBounds(500, 40, 500, 400);
                break;
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaGraficas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> seleccionarGraficas;
    // End of variables declaration//GEN-END:variables
}
