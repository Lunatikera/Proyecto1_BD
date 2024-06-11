/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forms;

import dtos.CiudadDTO;
import dtos.ClienteDTO;
import dtos.SucursalDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import negocio.ICiudadNegocio;
import negocio.IClienteNegocio;
import negocio.IPaisNegocio;
import negocio.IPeliculaNegocio;
import negocio.ISucursalNegocio;
import negocio.NegocioException;

/**
 *
 * @author Usuario
 */
public class DlgUbicacion extends javax.swing.JDialog {

    IClienteNegocio clienteNeg;
    IPeliculaNegocio peliNeg;
    ICiudadNegocio ciudadNeg;
    ClienteDTO cliente;
    ISucursalNegocio sucursalNeg;
    List<CiudadDTO> listaCiudades;
    List<SucursalDTO> listaSucursales;

    public DlgUbicacion(java.awt.Frame parent, boolean modal, IClienteNegocio clienteNeg, IPeliculaNegocio peliNeg,
            ICiudadNegocio ciudadNeg, ISucursalNegocio sucursalNeg, ClienteDTO cliente) {
        super(parent, modal);
        initComponents();
        this.clienteNeg = clienteNeg;
        this.peliNeg = peliNeg;
        this.ciudadNeg = ciudadNeg;
        this.sucursalNeg = sucursalNeg;
        this.cliente = cliente;
        listaCiudades = new ArrayList<>();
        listaSucursales = new ArrayList<>();
        this.setLocationRelativeTo(this);
        llenarComboBoxCiudad();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbCiudad = new javax.swing.JComboBox<>();
        BtnSucursalCercana = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        LblCorreo = new javax.swing.JLabel();
        BtnSiguiente = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblMexico = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbSucursal = new javax.swing.JComboBox<>();
        LblCorreo1 = new javax.swing.JLabel();
        LblCorreo2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(5, 16, 42));

        cbCiudad.setBackground(new java.awt.Color(204, 204, 204));
        cbCiudad.setForeground(new java.awt.Color(5, 16, 42));

        BtnSucursalCercana.setBackground(new java.awt.Color(204, 204, 204));
        BtnSucursalCercana.setForeground(new java.awt.Color(5, 16, 42));
        BtnSucursalCercana.setText("Ir a la sucursal mas cercana");
        BtnSucursalCercana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSucursalCercanaActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/littlelogoMedium.png"))); // NOI18N

        LblCorreo.setBackground(new java.awt.Color(5, 16, 42));
        LblCorreo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LblCorreo.setText("Seleccione una Ciudad:");
        LblCorreo.setToolTipText("");

        BtnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flechaDer.png"))); // NOI18N
        BtnSiguiente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnSiguiente.setContentAreaFilled(false);
        BtnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSiguienteActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(252, 207, 4));

        lblMexico.setBackground(new java.awt.Color(5, 16, 42));
        lblMexico.setForeground(new java.awt.Color(5, 16, 42));
        lblMexico.setText("México");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mexico.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMexico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(335, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMexico)
                    .addComponent(jLabel3)))
        );

        cbSucursal.setBackground(new java.awt.Color(204, 204, 204));
        cbSucursal.setForeground(new java.awt.Color(5, 16, 42));

        LblCorreo1.setBackground(new java.awt.Color(5, 16, 42));
        LblCorreo1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LblCorreo1.setText("Seleccione una Sucursal:");
        LblCorreo1.setToolTipText("");

        LblCorreo2.setBackground(new java.awt.Color(5, 16, 42));
        LblCorreo2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LblCorreo2.setText("                      O");
        LblCorreo2.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(LblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(cbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(LblCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnSucursalCercana, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblCorreo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(LblCorreo)
                .addGap(10, 10, 10)
                .addComponent(cbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(LblCorreo1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(cbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addComponent(LblCorreo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnSucursalCercana, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     private void llenarComboBoxCiudad() {
        try {
            listaCiudades = ciudadNeg.listaCiudades(lblMexico.getText());

            for (CiudadDTO ciudad : listaCiudades) {
                cbCiudad.addItem(ciudad.getNombre());
            }
        } catch (NegocioException ex) {
            Logger.getLogger(DlgUbicacion.class.getName()).log(Level.SEVERE, null, ex);
        }

        cbCiudad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarComboBoxCiudad();
            }
        });
    }

    private void actualizarComboBoxCiudad() {
        String ciudadSeleccionada = (String) cbCiudad.getSelectedItem();
        try {
            CiudadDTO ciudad = ciudadNeg.obtenerCiudadPorNombre(ciudadSeleccionada);
            listaSucursales = sucursalNeg.listaSucursalesporCiudad(ciudad.getId());
        } catch (NegocioException ex) {
            Logger.getLogger(FrmRegistrar.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Limpiar el combo box de ciudades
        cbSucursal.removeAllItems();

        // Añadir las ciudades correspondientes
        if (listaSucursales != null) {
            for (SucursalDTO sucursal : listaSucursales) {
                cbSucursal.addItem(sucursal.getNombre());
            }
        }
    }
    private void BtnSucursalCercanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSucursalCercanaActionPerformed
        try {
            sucursalNeg.obtenerSucursalMasCercana(cliente.getId());
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo encontrar la ubicacion", "Error en la ubicacion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnSucursalCercanaActionPerformed

    private void BtnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSiguienteActionPerformed
        String sucursal = cbSucursal.getSelectedItem() != null ? cbCiudad.getSelectedItem().toString() : "";
        try {
            SucursalDTO sucursalDTO=sucursalNeg.obtenerSucursalporNombre(sucursal);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo encontrar la ubicacion seleccionada", "Error en la ubicacion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnSiguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSiguiente;
    private javax.swing.JButton BtnSucursalCercana;
    private javax.swing.JLabel LblCorreo;
    private javax.swing.JLabel LblCorreo1;
    private javax.swing.JLabel LblCorreo2;
    private javax.swing.JComboBox<String> cbCiudad;
    private javax.swing.JComboBox<String> cbSucursal;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblMexico;
    // End of variables declaration//GEN-END:variables
}
