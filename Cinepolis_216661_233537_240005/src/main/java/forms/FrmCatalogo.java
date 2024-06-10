/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import dtos.ClienteDTO;
import dtos.PeliculaDTO;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import negocio.IClienteNegocio;
import negocio.IPeliculaNegocio;
import negocio.NegocioException;
import utilerias.Forms;
import static utilerias.Utilidades.textoConSaltosLinea;

/**
 *
 * @author Usuario
 */
public class FrmCatalogo extends javax.swing.JFrame {

    private int pagina = 1;
    private final int LIMITE = 4;
    private JButton[] botones;
    private JLabel[] labels;
    IClienteNegocio clienteNeg;
    IPeliculaNegocio peliculas;
    private PeliculaDTO pelicula;
    private ClienteDTO cliente;
    private List<PeliculaDTO> peliculasCargadas;

    public FrmCatalogo(IPeliculaNegocio peliculas, ClienteDTO cliente, IClienteNegocio clienteNeg, PeliculaDTO pelicula) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(this);
        this.peliculas = peliculas;
        this.cliente = cliente;
        this.clienteNeg = clienteNeg;
        this.pelicula = pelicula;
        botones = new JButton[]{BtnPelicula1, BtnPelicula2, BtnPelicula3, BtnPelicula4};
        labels = new JLabel[]{LblPelicula1, LblPelicula2, LblPelicula3, LblPelicula4};
        this.peliculasCargadas = new ArrayList<>();
        this.cargarMetodosIniciales();

    }

    private void cargarMetodosIniciales() {
        this.cargarPeliculas();
        this.estadoPagina();
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
        jPanel2 = new javax.swing.JPanel();
        BtnPerfil = new javax.swing.JButton();
        BtnLocalizacion = new javax.swing.JButton();
        BtnLogOut = new javax.swing.JButton();
        BtnLogo = new javax.swing.JButton();
        BtnLittleLogo = new javax.swing.JButton();
        lblAdmin = new javax.swing.JLabel();
        BtnPelicula4 = new javax.swing.JButton();
        BtnPelicula1 = new javax.swing.JButton();
        BtnPelicula2 = new javax.swing.JButton();
        BtnPelicula3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        LblPelicula1 = new javax.swing.JLabel();
        LblPelicula2 = new javax.swing.JLabel();
        LblPelicula3 = new javax.swing.JLabel();
        LblPelicula4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        BtnPaginaAnterior1 = new javax.swing.JButton();
        LblNumeroPagina1 = new javax.swing.JLabel();
        BtnPaginaSiguiente1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(5, 16, 42));

        BtnPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/perfil.PNG"))); // NOI18N
        BtnPerfil.setBorder(null);
        BtnPerfil.setBorderPainted(false);
        BtnPerfil.setContentAreaFilled(false);
        BtnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPerfilActionPerformed(evt);
            }
        });

        BtnLocalizacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/localizacion.PNG"))); // NOI18N
        BtnLocalizacion.setBorder(null);
        BtnLocalizacion.setBorderPainted(false);
        BtnLocalizacion.setContentAreaFilled(false);

        BtnLogOut.setBackground(new java.awt.Color(5, 16, 42));
        BtnLogOut.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        BtnLogOut.setText("Log out");
        BtnLogOut.setBorderPainted(false);
        BtnLogOut.setContentAreaFilled(false);
        BtnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLogOutActionPerformed(evt);
            }
        });

        BtnLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO.png"))); // NOI18N
        BtnLogo.setBorderPainted(false);
        BtnLogo.setContentAreaFilled(false);

        BtnLittleLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/littlelogo.png"))); // NOI18N
        BtnLittleLogo.setBorderPainted(false);
        BtnLittleLogo.setContentAreaFilled(false);
        BtnLittleLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLittleLogoActionPerformed(evt);
            }
        });

        lblAdmin.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblAdmin.setText("Modo administrador");
        lblAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAdminMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(BtnLittleLogo)
                .addGap(49, 49, 49)
                .addComponent(lblAdmin)
                .addGap(61, 61, 61)
                .addComponent(BtnLogo)
                .addGap(147, 147, 147)
                .addComponent(BtnLocalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnPerfil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 98, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addComponent(BtnLogOut)
                            .addGap(8, 8, 8))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(BtnPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BtnLocalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnLogo)
                            .addComponent(BtnLittleLogo))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblAdmin)
                .addGap(39, 39, 39))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 100));

        BtnPelicula4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPelicula4ActionPerformed(evt);
            }
        });
        jPanel1.add(BtnPelicula4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 195, 163, 210));

        BtnPelicula1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPelicula1ActionPerformed(evt);
            }
        });
        jPanel1.add(BtnPelicula1, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 195, 163, 210));

        BtnPelicula2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPelicula2ActionPerformed(evt);
            }
        });
        jPanel1.add(BtnPelicula2, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 195, 163, 210));

        BtnPelicula3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPelicula3ActionPerformed(evt);
            }
        });
        jPanel1.add(BtnPelicula3, new org.netbeans.lib.awtextra.AbsoluteConstraints(489, 195, 163, 210));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 48)); // NOI18N
        jLabel1.setText("Cartelera");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 117, -1, 54));

        LblPelicula1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        LblPelicula1.setText("Titulo");
        jPanel1.add(LblPelicula1, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 417, -1, -1));

        LblPelicula2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        LblPelicula2.setText("Titulo");
        jPanel1.add(LblPelicula2, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 417, -1, -1));

        LblPelicula3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        LblPelicula3.setText("Titulo");
        jPanel1.add(LblPelicula3, new org.netbeans.lib.awtextra.AbsoluteConstraints(489, 417, -1, -1));

        LblPelicula4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        LblPelicula4.setText("Titulo");
        jPanel1.add(LblPelicula4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 417, -1, -1));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        BtnPaginaAnterior1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flechaIzq.png"))); // NOI18N
        BtnPaginaAnterior1.setBorderPainted(false);
        BtnPaginaAnterior1.setContentAreaFilled(false);
        BtnPaginaAnterior1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPaginaAnterior1ActionPerformed(evt);
            }
        });

        LblNumeroPagina1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        LblNumeroPagina1.setText("11");

        BtnPaginaSiguiente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flechaDer.png"))); // NOI18N
        BtnPaginaSiguiente1.setBorderPainted(false);
        BtnPaginaSiguiente1.setContentAreaFilled(false);
        BtnPaginaSiguiente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPaginaSiguiente1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(LblNumeroPagina1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnPaginaSiguiente1)
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 11, Short.MAX_VALUE)
                    .addComponent(BtnPaginaAnterior1)
                    .addGap(0, 133, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnPaginaSiguiente1)
                    .addComponent(LblNumeroPagina1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(BtnPaginaAnterior1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 480, 190, -1));

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

    public void cargarPeliculas() {
        try {
            List<PeliculaDTO> peliculasLista = this.peliculas.buscarPaginadoPeliculas(LIMITE, pagina);

            peliculasCargadas.clear();
            peliculasCargadas.addAll(peliculasLista);
            this.llenarCampos(peliculasLista);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Informacion", JOptionPane.ERROR_MESSAGE);

        }
    }

    private void llenarCampos(List<PeliculaDTO> peliculasLista) {
        for (int i = 0; i < peliculasLista.size(); i++) {
            botones[i].setEnabled(true);
            ImageIcon icon = new ImageIcon(peliculasLista.get(i).getCartel());
            Image scaledImage = icon.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH);
            botones[i].setIcon(new ImageIcon(scaledImage));
            labels[i].setText(textoConSaltosLinea(peliculasLista.get(i).getTitulo(), 5));
        }
        // Limpiar botones y etiquetas restantes
        for (int i = peliculasLista.size(); i < LIMITE; i++) {
            ImageIcon icono = new ImageIcon(("carteles/ComingSoon.jpg"));
            Image scaledIcono = icono.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH);
            botones[i].setIcon(new ImageIcon(scaledIcono));
            labels[i].setText("");
            botones[i].setEnabled(false);

        }

    }

    private void BtnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnPerfilActionPerformed

    private void BtnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLogOutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnLogOutActionPerformed

    private void BtnPaginaAnterior1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPaginaAnterior1ActionPerformed
        this.pagina = this.pagina - 1;
        this.cargarPeliculas();
        this.estadoPagina();

    }//GEN-LAST:event_BtnPaginaAnterior1ActionPerformed


    private void BtnPaginaSiguiente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPaginaSiguiente1ActionPerformed
        this.pagina = this.pagina + 1;
        this.cargarPeliculas();
        this.estadoPagina();
    }//GEN-LAST:event_BtnPaginaSiguiente1ActionPerformed


    private void BtnPelicula1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPelicula1ActionPerformed
        PeliculaDTO pelicula = peliculasCargadas.get(0);
        System.out.println(pelicula);
        FrmDetallesPelicula libroForm = new FrmDetallesPelicula(pelicula, peliculas, clienteNeg, cliente);
        libroForm.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_BtnPelicula1ActionPerformed

    private void BtnPelicula2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPelicula2ActionPerformed
        PeliculaDTO pelicula = peliculasCargadas.get(1);
        FrmDetallesPelicula libroForm = new FrmDetallesPelicula(pelicula, peliculas, clienteNeg, cliente);
        libroForm.setVisible(true);

    }//GEN-LAST:event_BtnPelicula2ActionPerformed

    private void BtnPelicula3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPelicula3ActionPerformed
        PeliculaDTO pelicula = peliculasCargadas.get(2);
        FrmDetallesPelicula libroForm = new FrmDetallesPelicula(pelicula, peliculas, clienteNeg, cliente);
        libroForm.setVisible(true);

    }//GEN-LAST:event_BtnPelicula3ActionPerformed

    private void BtnPelicula4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPelicula4ActionPerformed
        PeliculaDTO pelicula = peliculasCargadas.get(3);
        FrmDetallesPelicula libroForm = new FrmDetallesPelicula(pelicula, peliculas, clienteNeg, cliente);
        libroForm.setVisible(true);

    }//GEN-LAST:event_BtnPelicula4ActionPerformed

    private void BtnLittleLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLittleLogoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnLittleLogoActionPerformed

    private void lblAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAdminMouseClicked
        Forms.cargarForm(new FrmModoAdmin(peliculas, cliente, clienteNeg, pelicula), this);
    }//GEN-LAST:event_lblAdminMouseClicked

    private void estadoPagina() {
        String numPagina = String.valueOf(pagina);
        if (numPagina.length() == 1) {
            numPagina = "0" + numPagina;
        }
        LblNumeroPagina1.setText(numPagina);
        estatusBotonAtras();
        estatusBotonSiguiente();
    }

    private void estatusBotonAtras() {
        if (this.pagina > 1) {
            BtnPaginaAnterior1.setEnabled(true);
            return;
        }
        BtnPaginaAnterior1.setEnabled(false);
    }

    private void estatusBotonSiguiente() {

        try {
            BtnPaginaSiguiente1.setEnabled(true);
            if (this.peliculas.buscarPaginadoPeliculas(this.LIMITE, this.pagina + 1) == null
                    || this.peliculas.buscarPaginadoPeliculas(this.LIMITE, this.pagina + 1).isEmpty()) {
                BtnPaginaSiguiente1.setEnabled(false);
            }
        } catch (NegocioException ex) {
            System.out.println(ex);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnLittleLogo;
    private javax.swing.JButton BtnLocalizacion;
    private javax.swing.JButton BtnLogOut;
    private javax.swing.JButton BtnLogo;
    private javax.swing.JButton BtnPaginaAnterior1;
    private javax.swing.JButton BtnPaginaSiguiente1;
    private javax.swing.JButton BtnPelicula1;
    private javax.swing.JButton BtnPelicula2;
    private javax.swing.JButton BtnPelicula3;
    private javax.swing.JButton BtnPelicula4;
    private javax.swing.JButton BtnPerfil;
    private javax.swing.JLabel LblNumeroPagina1;
    private javax.swing.JLabel LblPelicula1;
    private javax.swing.JLabel LblPelicula2;
    private javax.swing.JLabel LblPelicula3;
    private javax.swing.JLabel LblPelicula4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblAdmin;
    // End of variables declaration//GEN-END:variables
}
