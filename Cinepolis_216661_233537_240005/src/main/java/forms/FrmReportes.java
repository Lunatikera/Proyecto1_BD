/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import dtos.SucursalDTO;
import entidades.Sucursal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import negocio.GenerarReporteGananciasSucursal;
import negocio.ISucursalNegocio;
import negocio.NegocioException;
import persistencia.IConexionBD;

/**
 *
 * @author Chris
 */
public class FrmReportes extends javax.swing.JFrame {

    GenerarReporteGananciasSucursal a;
    IConexionBD conexionBD;
    ISucursalNegocio sucursalNeg;
    List<SucursalDTO> listaSucursales;

    /**
     * Creates new form FrmReportes
     */
    public FrmReportes(ISucursalNegocio sucursalNeg) {
        initComponents();
        this.a = new GenerarReporteGananciasSucursal(conexionBD);
        this.sucursalNeg = sucursalNeg;
        listaSucursales = new ArrayList<>();
        llenarComboBoxPaises();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdcInicio = new com.toedter.calendar.JDateChooser();
        jdcFin = new com.toedter.calendar.JDateChooser();
        cbSucursal = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bReporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jdcInicio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jdcFin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cbSucursal.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        cbSucursal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        jLabel1.setText("Sucursal:");

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        jLabel2.setText("Fecha inicio:");

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        jLabel3.setText("Fecha fin:");

        bReporte.setBackground(new java.awt.Color(252, 207, 4));
        bReporte.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        bReporte.setForeground(new java.awt.Color(0, 0, 0));
        bReporte.setText("Generar PDF");
        bReporte.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbSucursal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jdcInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jdcFin, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(bReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(208, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jdcInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jdcFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(bReporte)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void llenarComboBoxPaises() {
        try {
            listaSucursales = sucursalNeg.obtenerSucursales();

            for (SucursalDTO sucursal : listaSucursales) {
                cbSucursal.addItem(sucursal.getNombre());
            }
        } catch (NegocioException ex) {
            Logger.getLogger(FrmRegistrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void bReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReporteActionPerformed
        try {

            Date fechaIni = jdcInicio.getDate();
            Date fechaFin = jdcFin.getDate();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaInicio = sdf.format(fechaIni);
            String fechaFinStr = sdf.format(fechaFin);

            SucursalDTO sucursalSeleccionada = (SucursalDTO) cbSucursal.getSelectedItem();
            int sucursalId = sucursalSeleccionada.getId();

            a.generarReporte(sucursalId, fechaInicio, fechaFinStr);

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(this, "Reporte generado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al generar el reporte: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bReporte;
    private javax.swing.JComboBox<String> cbSucursal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private com.toedter.calendar.JDateChooser jdcFin;
    private com.toedter.calendar.JDateChooser jdcInicio;
    // End of variables declaration//GEN-END:variables
}
