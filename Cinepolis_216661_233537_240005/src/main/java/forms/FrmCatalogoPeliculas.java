/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import dtos.ClienteDTO;
import dtos.PeliculaDTO;
import dtos.SucursalDTO;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import negocio.ICiudadNegocio;
import negocio.IClienteNegocio;
import negocio.IPaisNegocio;
import negocio.IPeliculaNegocio;
import negocio.ISucursalNegocio;
import negocio.NegocioException;
import utilerias.Forms;
import static utilerias.Utilidades.textoConSaltosLinea;

/**
 *
 * @author Chris
 */
public class FrmCatalogoPeliculas extends javax.swing.JFrame {

    private JPopupMenu menuDesplegable;
    private int pagina = 1;
    private final int LIMITE = 4;
    private JButton[] botones;
    private JLabel[] labels;
    private IClienteNegocio clienteNeg;
    private IPeliculaNegocio peliculaNeg;
    private ICiudadNegocio ciudadNeg;
    private ISucursalNegocio sucursalNeg;
    private IPaisNegocio paisNeg;
    private PeliculaDTO pelicula;
    private ClienteDTO cliente;
    public SucursalDTO sucursal;
    private List<PeliculaDTO> peliculasCargadas;

    public FrmCatalogoPeliculas(IPeliculaNegocio peliculaNeg, ClienteDTO cliente, IClienteNegocio clienteNeg, PeliculaDTO pelicula,
            SucursalDTO sucursal, ICiudadNegocio ciudadNeg, ISucursalNegocio sucursalNeg, IPaisNegocio paisNeg) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(this);
        this.peliculaNeg = peliculaNeg;
        this.cliente = cliente;
        this.clienteNeg = clienteNeg;
        this.pelicula = pelicula;
        this.sucursal = sucursal;
        this.ciudadNeg = ciudadNeg;
        this.sucursalNeg = sucursalNeg;
        this.paisNeg = paisNeg;
        botones = new JButton[]{BtnPelicula1, BtnPelicula2, BtnPelicula3, BtnPelicula4};
        labels = new JLabel[]{LblPelicula1, LblPelicula2, LblPelicula3, LblPelicula4};
        this.peliculasCargadas = new ArrayList<>();

        this.cargarMetodosIniciales();

    }

    private void cargarMetodosIniciales() {
        this.cargarPeliculas();
        this.estadoPagina();
    }

    public void cargarPeliculas() {
        try {
            List<PeliculaDTO> peliculasLista = this.peliculaNeg.buscarPaginadoPeliculas(LIMITE, pagina);

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
            if (this.peliculaNeg.buscarPaginadoPeliculas(this.LIMITE, this.pagina + 1) == null
                    || this.peliculaNeg.buscarPaginadoPeliculas(this.LIMITE, this.pagina + 1).isEmpty()) {
                BtnPaginaSiguiente1.setEnabled(false);
            }
        } catch (NegocioException ex) {
            System.out.println(ex);
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

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        BtnLogo = new javax.swing.JButton();
        BtnLittleLogo = new javax.swing.JButton();
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

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(5, 16, 42));

        BtnLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO.png"))); // NOI18N
        BtnLogo.setBorderPainted(false);
        BtnLogo.setContentAreaFilled(false);

        BtnLittleLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/undo (1).png"))); // NOI18N
        BtnLittleLogo.setBorderPainted(false);
        BtnLittleLogo.setContentAreaFilled(false);
        BtnLittleLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLittleLogoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(BtnLittleLogo)
                .addGap(260, 260, 260)
                .addComponent(BtnLogo)
                .addContainerGap(383, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnLogo)
                    .addComponent(BtnLittleLogo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        jLabel1.setText("Peliculas en cartelera");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, -1, 54));

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
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 9, Short.MAX_VALUE)
                    .addComponent(BtnPaginaAnterior1)
                    .addGap(0, 131, Short.MAX_VALUE)))
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

    private void BtnLittleLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLittleLogoActionPerformed
        Forms.cargarForm(new FrmModoAdmin(peliculaNeg, cliente, clienteNeg, pelicula,sucursal,ciudadNeg,sucursalNeg,paisNeg), this);
    }//GEN-LAST:event_BtnLittleLogoActionPerformed

    private void BtnPelicula4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPelicula4ActionPerformed
        PeliculaDTO pelicula1 = peliculasCargadas.get(3);
        Object[] opciones = {"Editar", "Eliminar"};
        int opcionSeleccionada = JOptionPane.showOptionDialog(
                this,
                "¿Qué desea hacer con la película seleccionada?",
                "Seleccionar acción",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (opcionSeleccionada == 0) {
            FrmEditarPelicula peliculaForm = new FrmEditarPelicula(this,peliculaNeg, cliente, clienteNeg, pelicula,sucursal,ciudadNeg,sucursalNeg,paisNeg);
            this.dispose();
            peliculaForm.setVisible(true);
            cargarPeliculas();
        } else if (opcionSeleccionada == 1) {
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar esta película?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                try {
                    peliculaNeg.eliminarPelicula(pelicula.getId());

                    if (this.peliculaNeg.buscarPaginadoPeliculas(this.LIMITE, this.pagina) == null || this.peliculaNeg.buscarPaginadoPeliculas(this.LIMITE, this.pagina).isEmpty()) {
                        this.BtnPaginaAnterior1ActionPerformed(null);
                    } else {
                        cargarPeliculas();
                    }
                } catch (NegocioException ex) {
                    Logger.getLogger(FrmCatalogoPeliculas.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(this, "Película eliminada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_BtnPelicula4ActionPerformed

    private void BtnPelicula1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPelicula1ActionPerformed
        PeliculaDTO pelicula2 = peliculasCargadas.get(0);
        Object[] opciones = {"Editar", "Eliminar"};
        int opcionSeleccionada = JOptionPane.showOptionDialog(
                this,
                "¿Qué desea hacer con la película seleccionada?",
                "Seleccionar acción",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (opcionSeleccionada == 0) {
            FrmEditarPelicula peliculaForm = new FrmEditarPelicula(this,peliculaNeg, cliente, clienteNeg, pelicula,sucursal,ciudadNeg,sucursalNeg,paisNeg);
            this.dispose();
            peliculaForm.setVisible(true);
            cargarPeliculas();

        } else if (opcionSeleccionada == 1) {
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar esta película?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                try {
                    peliculaNeg.eliminarPelicula(pelicula.getId());

                    // Error handling for the deletion operation
                    if (this.peliculaNeg.buscarPaginadoPeliculas(this.LIMITE, this.pagina) == null || this.peliculaNeg.buscarPaginadoPeliculas(this.LIMITE, this.pagina).isEmpty()) {
                        this.BtnPaginaAnterior1ActionPerformed(null);
                    } else {
                        cargarPeliculas();
                    }
                    JOptionPane.showMessageDialog(this, "Película eliminada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } catch (NegocioException ex) {
                    Logger.getLogger(FrmCatalogoPeliculas.class.getName()).log(Level.SEVERE, null, ex);
                    // Optionally, show an error message to the user
                    JOptionPane.showMessageDialog(this, "Error al eliminar la película.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_BtnPelicula1ActionPerformed

    private void BtnPelicula2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPelicula2ActionPerformed
        PeliculaDTO pelicula3 = peliculasCargadas.get(1);
        Object[] opciones = {"Editar", "Eliminar"};
        int opcionSeleccionada = JOptionPane.showOptionDialog(
                this,
                "¿Qué desea hacer con la película seleccionada?",
                "Seleccionar acción",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (opcionSeleccionada == 0) {
            FrmEditarPelicula peliculaForm = new FrmEditarPelicula(this,peliculaNeg, cliente, clienteNeg, pelicula,sucursal,ciudadNeg,sucursalNeg,paisNeg);
            this.dispose();
            peliculaForm.setVisible(true);
            cargarPeliculas();

        } else if (opcionSeleccionada == 1) {
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar esta película?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                try {
                    peliculaNeg.eliminarPelicula(pelicula.getId());

                    // Error handling for the deletion operation
                    if (this.peliculaNeg.buscarPaginadoPeliculas(this.LIMITE, this.pagina) == null || this.peliculaNeg.buscarPaginadoPeliculas(this.LIMITE, this.pagina).isEmpty()) {
                        this.BtnPaginaAnterior1ActionPerformed(null);
                    } else {
                        cargarPeliculas();
                    }
                    JOptionPane.showMessageDialog(this, "Película eliminada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } catch (NegocioException ex) {
                    Logger.getLogger(FrmCatalogoPeliculas.class.getName()).log(Level.SEVERE, null, ex);
                    // Optionally, show an error message to the user
                    JOptionPane.showMessageDialog(this, "Error al eliminar la película.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_BtnPelicula2ActionPerformed

    private void BtnPelicula3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPelicula3ActionPerformed
        PeliculaDTO pelicula4 = peliculasCargadas.get(2);
        Object[] opciones = {"Editar", "Eliminar"};
        int opcionSeleccionada = JOptionPane.showOptionDialog(
                this,
                "¿Qué desea hacer con la película seleccionada?",
                "Seleccionar acción",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (opcionSeleccionada == 0) {
            FrmEditarPelicula peliculaForm = new FrmEditarPelicula(this,peliculaNeg, cliente, clienteNeg, pelicula,sucursal,ciudadNeg,sucursalNeg,paisNeg);
            this.dispose();
            peliculaForm.setVisible(true);
            cargarPeliculas();
        } else if (opcionSeleccionada == 1) {
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar esta película?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                try {
                    peliculaNeg.eliminarPelicula(pelicula.getId());

                    // Error handling for the deletion operation
                    if (this.peliculaNeg.buscarPaginadoPeliculas(this.LIMITE, this.pagina) == null || this.peliculaNeg.buscarPaginadoPeliculas(this.LIMITE, this.pagina).isEmpty()) {
                        this.BtnPaginaAnterior1ActionPerformed(null);
                    } else {
                        cargarPeliculas();
                    }
                    JOptionPane.showMessageDialog(this, "Película eliminada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } catch (NegocioException ex) {
                    Logger.getLogger(FrmCatalogoPeliculas.class.getName()).log(Level.SEVERE, null, ex);
                    // Optionally, show an error message to the user
                    JOptionPane.showMessageDialog(this, "Error al eliminar la película.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_BtnPelicula3ActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnLittleLogo;
    private javax.swing.JButton BtnLogo;
    private javax.swing.JButton BtnPaginaAnterior1;
    private javax.swing.JButton BtnPaginaSiguiente1;
    private javax.swing.JButton BtnPelicula1;
    private javax.swing.JButton BtnPelicula2;
    private javax.swing.JButton BtnPelicula3;
    private javax.swing.JButton BtnPelicula4;
    private javax.swing.JLabel LblNumeroPagina1;
    private javax.swing.JLabel LblPelicula1;
    private javax.swing.JLabel LblPelicula2;
    private javax.swing.JLabel LblPelicula3;
    private javax.swing.JLabel LblPelicula4;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
