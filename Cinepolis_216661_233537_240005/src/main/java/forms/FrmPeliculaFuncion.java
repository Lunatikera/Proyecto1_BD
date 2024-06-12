/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import dtos.ClienteDTO;
import dtos.PeliculaDTO;
import java.awt.Image;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import negocio.IClienteNegocio;
import negocio.IFuncionNegocio;
import negocio.IPeliculaNegocio;
import negocio.NegocioException;
import utilerias.Dias;
import static utilerias.Dias.obtenerDiaSiguiente;
import utilerias.Forms;
import utilerias.Utilidades;
import static utilerias.Utilidades.textoConSaltosLinea;

/**
 *
 * @author Usuario
 */
public class FrmPeliculaFuncion extends javax.swing.JFrame {
    IFuncionNegocio funcionNeg;
    IPeliculaNegocio peliculaNeg;
    private IClienteNegocio clienteNeg;
    private ClienteDTO cliente;
    PeliculaDTO pelicula;


    public FrmPeliculaFuncion(PeliculaDTO pelicula, IPeliculaNegocio peliculas, IClienteNegocio clienteNeg, ClienteDTO cliente) {
        initComponents();
        this.setLocationRelativeTo(this);
        this.pelicula = pelicula;
        this.peliculaNeg = peliculas;
        this.cliente = cliente;
        this.clienteNeg = clienteNeg;
        LblDia.setText(obtenerDiaActual());
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
        BtnPerfil = new javax.swing.JButton();
        BtnLocalizacion = new javax.swing.JButton();
        BtnLogOut = new javax.swing.JButton();
        BtnLogo = new javax.swing.JButton();
        BtnLittleLogo = new javax.swing.JButton();
        BtnPelicula1 = new javax.swing.JButton();
        LblTitulo = new javax.swing.JLabel();
        LblDuracion = new javax.swing.JLabel();
        LblPais = new javax.swing.JLabel();
        LblClasificacion = new javax.swing.JLabel();
        LblDia = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BtnAtras = new javax.swing.JButton();
        BtnSiguiente = new javax.swing.JButton();
        LblTrailer1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(5, 16, 42));

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

        BtnLogOut.setBackground(new java.awt.Color(187, 187, 187));
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
                .addGap(146, 146, 146)
                .addComponent(BtnLogo)
                .addGap(120, 120, 120)
                .addComponent(BtnLocalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnPerfil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addComponent(BtnLogOut)
                    .addGap(8, 8, 8))
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(BtnLogo)
                        .addComponent(BtnPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnLocalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(BtnLittleLogo))
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

        LblDia.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        LblDia.setForeground(new java.awt.Color(204, 204, 204));
        LblDia.setText("Lunes");
        jPanel1.add(LblDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 530, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Sala", "Hora Inicio", "Hora Final"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 490, 350));

        BtnAtras.setText("jButton1");
        BtnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(BtnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 530, -1, -1));

        BtnSiguiente.setText("jButton2");
        BtnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSiguienteActionPerformed(evt);
            }
        });
        jPanel1.add(BtnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 530, -1, -1));

        LblTrailer1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        LblTrailer1.setForeground(new java.awt.Color(204, 204, 204));
        LblTrailer1.setText("Trailer");
        jPanel1.add(LblTrailer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, -1, -1));

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

    private void cargarDetallesPelicula() {
        LblTitulo.setText(pelicula.getTitulo());
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
        LblDia.setText("<html><a href=\"" + pelicula.getLink_trailer() + "\">Ver Trailer</a></html>");
        LblDia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LblDia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    java.awt.Desktop.getDesktop().browse(new java.net.URI(pelicula.getLink_trailer()));
                } catch (java.io.IOException | java.net.URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void cargarFuncionesEnTabla() {
        try {
           String dia = LblDia.getText();
            List<FuncionesDTO> funcionesLista = this.funcionNeg.listaFuncionporDiaSucursalPelicula(LblDia.getText(),);
            this.llenarTablaAlumnos(alumnoLista);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
            pagina--;
        }
    }
    private void BtnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnPerfilActionPerformed

    private void BtnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLogOutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnLogOutActionPerformed

    private void BtnLittleLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLittleLogoActionPerformed
        Forms.cargarForm(new FrmCatalogo(peliculas, cliente, clienteNeg, pelicula), this);
    }//GEN-LAST:event_BtnLittleLogoActionPerformed

    private void BtnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAtrasActionPerformed
        LblDia.setText(Dias.obtenerDiaAnterior(LblDia.getText()));

    }//GEN-LAST:event_BtnAtrasActionPerformed

    private void BtnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSiguienteActionPerformed

        LblDia.setText(obtenerDiaSiguiente(LblDia.getText()));
        this.cargarFuncionesEnTabla();
    }//GEN-LAST:event_BtnSiguienteActionPerformed
    private String obtenerDiaActual() {
        LocalDate hoy = LocalDate.now();
        DayOfWeek dia = hoy.getDayOfWeek();
        String nombreDia = dia.getDisplayName(TextStyle.FULL, Locale.getDefault());
        String nombreDiaFormato = nombreDia.substring(0, 1).toUpperCase() + nombreDia.substring(1);
        return nombreDiaFormato;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAtras;
    private javax.swing.JButton BtnLittleLogo;
    private javax.swing.JButton BtnLocalizacion;
    private javax.swing.JButton BtnLogOut;
    private javax.swing.JButton BtnLogo;
    private javax.swing.JButton BtnPelicula1;
    private javax.swing.JButton BtnPerfil;
    private javax.swing.JButton BtnSiguiente;
    private javax.swing.JLabel LblClasificacion;
    private javax.swing.JLabel LblDia;
    private javax.swing.JLabel LblDuracion;
    private javax.swing.JLabel LblPais;
    private javax.swing.JLabel LblTitulo;
    private javax.swing.JLabel LblTrailer1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
