/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import dtos.ClienteDTO;
import dtos.PeliculaDTO;
import negocio.IClienteNegocio;
import negocio.IPeliculaNegocio;
import utilerias.Forms;

/**
 *
 * @author Chris
 */
public class FrmModoAdmin extends javax.swing.JFrame {

    IPeliculaNegocio peliculas;
    private IClienteNegocio clienteNeg;
    private ClienteDTO cliente;
    private PeliculaDTO pelicula;

    /**
     * Creates new form FrmModoAdmin
     */
    public FrmModoAdmin(IPeliculaNegocio peliculas, ClienteDTO cliente, IClienteNegocio clienteNeg, PeliculaDTO pelicula) {
        initComponents();
        this.setLocationRelativeTo(this);
        this.peliculas = peliculas;
        this.cliente = cliente;
        this.clienteNeg = clienteNeg;
        this.pelicula = pelicula;
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
        LblLogo = new javax.swing.JLabel();
        bRegresar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        bCatalogo = new javax.swing.JButton();
        bCatalogo1 = new javax.swing.JButton();
        btnAgregarPelicula = new javax.swing.JButton();
        bReportes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(5, 16, 42));

        LblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO.png"))); // NOI18N

        bRegresar.setBackground(new java.awt.Color(252, 207, 4));
        bRegresar.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        bRegresar.setForeground(new java.awt.Color(0, 0, 0));
        bRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/undo (1).png"))); // NOI18N
        bRegresar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bRegresar.setBorderPainted(false);
        bRegresar.setContentAreaFilled(false);
        bRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(LblLogo)
                .addContainerGap(152, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblLogo))
                .addGap(15, 15, 15))
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        bCatalogo.setBackground(new java.awt.Color(252, 207, 4));
        bCatalogo.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        bCatalogo.setForeground(new java.awt.Color(0, 0, 0));
        bCatalogo.setText("Catalogo de clientes");
        bCatalogo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCatalogoActionPerformed(evt);
            }
        });

        bCatalogo1.setBackground(new java.awt.Color(252, 207, 4));
        bCatalogo1.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        bCatalogo1.setForeground(new java.awt.Color(0, 0, 0));
        bCatalogo1.setText("Catalogo de Peliculas");
        bCatalogo1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bCatalogo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCatalogo1ActionPerformed(evt);
            }
        });

        btnAgregarPelicula.setBackground(new java.awt.Color(252, 207, 4));
        btnAgregarPelicula.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        btnAgregarPelicula.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarPelicula.setText("Agregar Pelicula");
        btnAgregarPelicula.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPeliculaActionPerformed(evt);
            }
        });

        bReportes.setBackground(new java.awt.Color(252, 207, 4));
        bReportes.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        bReportes.setForeground(new java.awt.Color(0, 0, 0));
        bReportes.setText("Reportes");
        bReportes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReportesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAgregarPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bCatalogo1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(bCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(bCatalogo1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnAgregarPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(bReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCatalogoActionPerformed
        Forms.cargarForm(new FrmCatalogoClientes(clienteNeg, peliculas, pelicula, cliente), this);
    }//GEN-LAST:event_bCatalogoActionPerformed

    private void bRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegresarActionPerformed
        Forms.cargarForm(new FrmCatalogo(peliculas, cliente, clienteNeg, pelicula), this);
    }//GEN-LAST:event_bRegresarActionPerformed

    private void bCatalogo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCatalogo1ActionPerformed
        Forms.cargarForm(new FrmCatalogoPeliculas(peliculas, cliente, clienteNeg, pelicula), this);
    }//GEN-LAST:event_bCatalogo1ActionPerformed

    private void btnAgregarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPeliculaActionPerformed
        Forms.cargarForm(new FrmAgregarPelicula(peliculas), this);
    }//GEN-LAST:event_btnAgregarPeliculaActionPerformed

    private void bReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReportesActionPerformed
        
    }//GEN-LAST:event_bReportesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblLogo;
    private javax.swing.JButton bCatalogo;
    private javax.swing.JButton bCatalogo1;
    private javax.swing.JButton bRegresar;
    private javax.swing.JButton bReportes;
    private javax.swing.JButton btnAgregarPelicula;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
