/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import dtos.PeliculaDTO;
import enums.Clasificaciones;
import java.awt.Image;
import java.awt.Window;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import negocio.IPeliculaNegocio;
import negocio.NegocioException;
import utilerias.Forms;

/**
 *
 * @author Usuario
 */
public class FrmAgregarPelicula extends javax.swing.JFrame {

    FrmCatalogoPeliculas peliculas;
    IPeliculaNegocio peliNeg;
    String ruta = "";

    public FrmAgregarPelicula(FrmCatalogoPeliculas peliculas, IPeliculaNegocio peliNeg) {
        initComponents();
        this.peliNeg = peliNeg;
        peliculas=peliculas;
        llenarComboEnum();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnPelicula1 = new javax.swing.JButton();
        txtCorreo1 = new javax.swing.JTextField();
        LblCorreo1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        BtnLogo = new javax.swing.JButton();
        BtnPelicula = new javax.swing.JButton();
        txtTitulo = new javax.swing.JTextField();
        LblCorreo = new javax.swing.JLabel();
        cbPais = new javax.swing.JComboBox<>();
        btnAplicar = new javax.swing.JButton();
        BtnExplorar = new javax.swing.JButton();
        LblCorreo3 = new javax.swing.JLabel();
        LblCorreo4 = new javax.swing.JLabel();
        txtTrailer = new javax.swing.JTextField();
        LblCorreo5 = new javax.swing.JLabel();
        txtDuracion = new javax.swing.JTextField();
        LblCorreo6 = new javax.swing.JLabel();
        LblCorreo7 = new javax.swing.JLabel();
        cbClasificacion = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtSinopsis = new javax.swing.JTextArea();

        txtCorreo1.setForeground(new java.awt.Color(102, 102, 102));
        txtCorreo1.setToolTipText("");
        txtCorreo1.setBorder(null);

        LblCorreo1.setBackground(new java.awt.Color(5, 16, 42));
        LblCorreo1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LblCorreo1.setForeground(new java.awt.Color(5, 16, 42));
        LblCorreo1.setText("Correo:");
        LblCorreo1.setToolTipText("");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cinepolis - Agregar Pelicula");

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(5, 16, 42));

        BtnLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO.png"))); // NOI18N
        BtnLogo.setBorderPainted(false);
        BtnLogo.setContentAreaFilled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(BtnLogo)
                .addContainerGap(409, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(BtnLogo)
                .addGap(1, 1, 1))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanel1.add(BtnPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 163, 210));

        txtTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(51, 51, 51));
        txtTitulo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTitulo.setToolTipText("");
        txtTitulo.setBorder(null);
        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });
        jPanel1.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 156, 280, 34));

        LblCorreo.setBackground(new java.awt.Color(5, 16, 42));
        LblCorreo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LblCorreo.setForeground(new java.awt.Color(5, 16, 42));
        LblCorreo.setText("Pais:");
        LblCorreo.setToolTipText("");
        jPanel1.add(LblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(674, 127, -1, -1));

        cbPais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estados Unidos" }));
        jPanel1.add(cbPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(674, 162, 128, -1));

        btnAplicar.setText("Agregar");
        btnAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAplicar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 510, 122, 35));

        BtnExplorar.setText("Explorar...");
        BtnExplorar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnExplorar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExplorarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnExplorar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 140, -1));

        LblCorreo3.setBackground(new java.awt.Color(5, 16, 42));
        LblCorreo3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LblCorreo3.setForeground(new java.awt.Color(5, 16, 42));
        LblCorreo3.setText("Titulo:");
        LblCorreo3.setToolTipText("");
        jPanel1.add(LblCorreo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 127, -1, -1));

        LblCorreo4.setBackground(new java.awt.Color(5, 16, 42));
        LblCorreo4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LblCorreo4.setForeground(new java.awt.Color(5, 16, 42));
        LblCorreo4.setText("Sinopsis:");
        LblCorreo4.setToolTipText("");
        jPanel1.add(LblCorreo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 349, -1, -1));

        txtTrailer.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTrailer.setForeground(new java.awt.Color(51, 51, 51));
        txtTrailer.setToolTipText("");
        txtTrailer.setBorder(null);
        txtTrailer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrailerActionPerformed(evt);
            }
        });
        jPanel1.add(txtTrailer, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 238, 280, 34));

        LblCorreo5.setBackground(new java.awt.Color(5, 16, 42));
        LblCorreo5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LblCorreo5.setForeground(new java.awt.Color(5, 16, 42));
        LblCorreo5.setText("Trailer:");
        LblCorreo5.setToolTipText("");
        jPanel1.add(LblCorreo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 208, -1, -1));

        txtDuracion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtDuracion.setForeground(new java.awt.Color(51, 51, 51));
        txtDuracion.setToolTipText("");
        txtDuracion.setBorder(null);
        txtDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDuracionActionPerformed(evt);
            }
        });
        jPanel1.add(txtDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(674, 232, 150, 34));

        LblCorreo6.setBackground(new java.awt.Color(5, 16, 42));
        LblCorreo6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LblCorreo6.setForeground(new java.awt.Color(5, 16, 42));
        LblCorreo6.setText("Duracion (min):");
        LblCorreo6.setToolTipText("");
        jPanel1.add(LblCorreo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(674, 202, 150, -1));

        LblCorreo7.setBackground(new java.awt.Color(5, 16, 42));
        LblCorreo7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LblCorreo7.setForeground(new java.awt.Color(5, 16, 42));
        LblCorreo7.setText("Clasificacion:");
        LblCorreo7.setToolTipText("");
        jPanel1.add(LblCorreo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(674, 284, -1, -1));

        cbClasificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbClasificacionActionPerformed(evt);
            }
        });
        jPanel1.add(cbClasificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(674, 315, 128, -1));

        txtSinopsis.setColumns(20);
        txtSinopsis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSinopsis.setForeground(new java.awt.Color(51, 51, 51));
        txtSinopsis.setRows(5);
        jScrollPane3.setViewportView(txtSinopsis);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 380, 518, 109));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnExplorarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExplorarActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("JPG, PNG Y JPEG", "jpg", "png", "jpeg");
        fileChooser.setFileFilter(extensionFilter);

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            ruta = fileChooser.getSelectedFile().getAbsolutePath();
            ImageIcon icon = new ImageIcon(ruta);
            Image scaledImage = icon.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH);
            BtnPelicula.setIcon(new ImageIcon(scaledImage));

        }
    }//GEN-LAST:event_BtnExplorarActionPerformed

    private void btnAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarActionPerformed
        String titulo = txtTitulo.getText().trim();
        String sinopsis = txtSinopsis.getText().trim();
        String clasificacion = cbClasificacion.getSelectedItem().toString();
        String trailer = txtTrailer.getText().trim();
        String pais = cbPais.getSelectedItem().toString().trim();
        String duracionStr = txtDuracion.getText().trim();
        String cartel = ruta.trim();

        if (titulo.isEmpty() || sinopsis.isEmpty() || trailer.isEmpty()
                || pais.isEmpty() || duracionStr.isEmpty() || cartel.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Campos vacíos", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int duracion;
        try {
            duracion = Integer.parseInt(duracionStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La duración debe ser un número entero.", "Error de formato", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PeliculaDTO pelicula = new PeliculaDTO();
        pelicula.setTitulo(titulo);
        pelicula.setSinopsis(sinopsis);
        pelicula.setLink_trailer(trailer);
        pelicula.setPais(pais);
        pelicula.setCartel(cartel);
        pelicula.setClasificacion(clasificacion);
        pelicula.setDuracion(duracion);
        try {
            peliNeg.agregaPelicula(pelicula);
            JOptionPane.showMessageDialog(this, "Película agregada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            peliculas.cargarPeliculas();
            this.dispose();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, "La pelicula no ha sio agregada!.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAplicarActionPerformed

    private void cbClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbClasificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbClasificacionActionPerformed

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void txtTrailerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrailerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTrailerActionPerformed

    private void txtDuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDuracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDuracionActionPerformed

    public void llenarComboEnum() {
        for (Clasificaciones clasi : Clasificaciones.values()) {
            cbClasificacion.addItem(clasi);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnExplorar;
    private javax.swing.JButton BtnLogo;
    private javax.swing.JButton BtnPelicula;
    private javax.swing.JButton BtnPelicula1;
    private javax.swing.JLabel LblCorreo;
    private javax.swing.JLabel LblCorreo1;
    private javax.swing.JLabel LblCorreo3;
    private javax.swing.JLabel LblCorreo4;
    private javax.swing.JLabel LblCorreo5;
    private javax.swing.JLabel LblCorreo6;
    private javax.swing.JLabel LblCorreo7;
    private javax.swing.JButton btnAplicar;
    private javax.swing.JComboBox<Clasificaciones> cbClasificacion;
    private javax.swing.JComboBox<String> cbPais;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txtCorreo1;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextArea txtSinopsis;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtTrailer;
    // End of variables declaration//GEN-END:variables
}
