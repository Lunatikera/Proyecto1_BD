/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import dtos.ClienteDTO;
import dtos.PeliculaDTO;
import java.awt.Image;
import javax.swing.ImageIcon;
import negocio.IClienteNegocio;
import negocio.IPeliculaNegocio;
import utilerias.Forms;
import static utilerias.Utilidades.textoConSaltosLinea;

/**
 *
 * @author Chris
 */
public class FrmModificarPelicula extends javax.swing.JFrame {

    IPeliculaNegocio peliculas;
    private IClienteNegocio clienteNeg;
    private ClienteDTO cliente;
    PeliculaDTO pelicula;

    public FrmModificarPelicula(PeliculaDTO pelicula, IPeliculaNegocio peliculas, IClienteNegocio clienteNeg, ClienteDTO cliente) {
        initComponents();
        this.setLocationRelativeTo(this);
        this.pelicula = pelicula;
        this.peliculas = peliculas;
        this.cliente = cliente;
        this.clienteNeg = clienteNeg;
        cargarDetallesPelicula();
    }

    private void cargarDetallesPelicula() {
        LblTitulo.setText(pelicula.getTitulo());
        LblSinopsis.setText(textoConSaltosLinea(pelicula.getSinopsis(), 8));
        LblPais.setText("Pais de Origen: " + pelicula.getPais());
        configurarTrailer();
        LblDuracion.setText("Duracion: " + pelicula.getDuracion() + " minutos");
        LblClasificacion.setText("Clasificacion: " + pelicula.getClasificacion());

        //Cargar Cartel Pelicula
        ImageIcon icon = new ImageIcon(pelicula.getCartel());
        Image scaledImage = icon.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH);
        BtnPelicula1.setIcon(new ImageIcon(scaledImage));
    }

    private void configurarTrailer() {
        LblTrailer.setText("<html><a href=\"" + pelicula.getLink_trailer() + "\">Ver Trailer</a></html>");
        LblTrailer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LblTrailer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    java.awt.Desktop.getDesktop().browse(new java.net.URI(pelicula.getLink_trailer()));
                } catch (java.io.IOException | java.net.URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
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
        jPanel3 = new javax.swing.JPanel();
        BtnLogo = new javax.swing.JButton();
        BtnLittleLogo = new javax.swing.JButton();
        BtnPelicula1 = new javax.swing.JButton();
        LblTitulo = new javax.swing.JLabel();
        LblSinopsis = new javax.swing.JLabel();
        LblDuracion = new javax.swing.JLabel();
        LblPais = new javax.swing.JLabel();
        LblClasificacion = new javax.swing.JLabel();
        LblTrailer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(5, 16, 42));

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(BtnLittleLogo)
                .addGap(228, 228, 228)
                .addComponent(BtnLogo)
                .addContainerGap(335, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(BtnLittleLogo)
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnLogo)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 90));
        jPanel1.add(BtnPelicula1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 163, 210));

        LblTitulo.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 36)); // NOI18N
        LblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        LblTitulo.setText("Titulo");
        jPanel1.add(LblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, -1, -1));

        LblSinopsis.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        LblSinopsis.setForeground(new java.awt.Color(204, 204, 204));
        LblSinopsis.setText("Sinopsis");
        jPanel1.add(LblSinopsis, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, -1, -1));

        LblDuracion.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        LblDuracion.setForeground(new java.awt.Color(204, 204, 204));
        LblDuracion.setText("Duracion(min)");
        jPanel1.add(LblDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, -1));

        LblPais.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        LblPais.setForeground(new java.awt.Color(204, 204, 204));
        LblPais.setText("Pais");
        jPanel1.add(LblPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        LblClasificacion.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        LblClasificacion.setForeground(new java.awt.Color(204, 204, 204));
        LblClasificacion.setText("Clasificacion:");
        jPanel1.add(LblClasificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        LblTrailer.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        LblTrailer.setForeground(new java.awt.Color(204, 204, 204));
        LblTrailer.setText("Trailer");
        jPanel1.add(LblTrailer, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnLittleLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLittleLogoActionPerformed
        Forms.cargarForm(new FrmCatalogoPeliculas(peliculas, cliente, clienteNeg, pelicula), this);
    }//GEN-LAST:event_BtnLittleLogoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnLittleLogo;
    private javax.swing.JButton BtnLogo;
    private javax.swing.JButton BtnPelicula1;
    private javax.swing.JLabel LblClasificacion;
    private javax.swing.JLabel LblDuracion;
    private javax.swing.JLabel LblPais;
    private javax.swing.JLabel LblSinopsis;
    private javax.swing.JLabel LblTitulo;
    private javax.swing.JLabel LblTrailer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
