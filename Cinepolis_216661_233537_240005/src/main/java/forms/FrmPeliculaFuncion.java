/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import dtos.ClienteDTO;
import dtos.FuncionDTO;
import dtos.PeliculaDTO;
import dtos.SalaDTO;
import dtos.SucursalDTO;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import negocio.ICiudadNegocio;
import negocio.IClienteNegocio;
import negocio.IFuncionNegocio;
import negocio.IPaisNegocio;
import negocio.IPeliculaNegocio;
import negocio.ISalaNegocio;
import negocio.ISucursalNegocio;
import negocio.NegocioException;
import utilerias.Dias;
import static utilerias.Dias.obtenerDiaActual;
import static utilerias.Dias.obtenerDiaAnterior;
import static utilerias.Dias.obtenerDiaSiguiente;
import utilerias.Forms;
import utilerias.JButtonCellEditor;
import utilerias.JButtonRenderer;
import utilerias.Utilidades;
import static utilerias.Utilidades.textoConSaltosLinea;

/**
 *
 * @author Usuario
 */
public class FrmPeliculaFuncion extends javax.swing.JFrame {

    private ICiudadNegocio ciudadNeg;
    private IPaisNegocio paisNeg;
    private IFuncionNegocio funcionNeg;
    private IPeliculaNegocio peliculaNeg;
    private ISucursalNegocio sucursalNeg;
    private ISalaNegocio salaNeg;
    private IClienteNegocio clienteNeg;
    private ClienteDTO cliente;
    PeliculaDTO pelicula;
    SucursalDTO sucursal;

    public FrmPeliculaFuncion(PeliculaDTO pelicula, IFuncionNegocio funcionNeg, IPeliculaNegocio peliculaNeg, IClienteNegocio clienteNeg,
            ISalaNegocio salaNeg, ClienteDTO cliente, SucursalDTO sucursal, IPaisNegocio paisNeg, ICiudadNegocio ciudadNeg) {
        initComponents();
        this.setLocationRelativeTo(this);
        this.pelicula = pelicula;
        this.peliculaNeg = peliculaNeg;
        this.cliente = cliente;
        this.sucursal = sucursal;
        this.funcionNeg = funcionNeg;
        this.clienteNeg = clienteNeg;
        this.ciudadNeg = ciudadNeg;
        this.paisNeg = paisNeg;
        this.salaNeg = salaNeg;
        LblDia.setText(obtenerDiaActual());
        cargarDetallesPelicula();
        cargarConfiguracionInicialTablaAlumnos();
        cargarFuncionesEnTabla();
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
        tblFunciones = new javax.swing.JTable();
        BtnAtras = new javax.swing.JButton();
        BtnSiguiente = new javax.swing.JButton();
        LblTrailer1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cinepolis - Funciones por Pelicula");

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(5, 16, 42));

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
                .addGap(252, 252, 252)
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
                    .addComponent(BtnLogo)))
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

        LblDia.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 22)); // NOI18N
        LblDia.setForeground(new java.awt.Color(204, 204, 204));
        LblDia.setText("Lunes");
        jPanel1.add(LblDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 530, 70, -1));

        tblFunciones.setBackground(new java.awt.Color(153, 153, 153));
        tblFunciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Sala", "Hora Inicio", "Hora Final", "Editar", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblFunciones);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 490, 350));

        BtnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flechaIzq.png"))); // NOI18N
        BtnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(BtnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 530, 40, 30));

        BtnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flechaDer.png"))); // NOI18N
        BtnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSiguienteActionPerformed(evt);
            }
        });
        jPanel1.add(BtnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 530, 40, 30));

        LblTrailer1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        LblTrailer1.setForeground(new java.awt.Color(204, 204, 204));
        LblTrailer1.setText("Trailer");
        jPanel1.add(LblTrailer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, -1, -1));

        jButton1.setBackground(new java.awt.Color(18, 28, 53));
        jButton1.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setText("Agregar Funcion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 530, 160, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 899, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
        LblTrailer1.setText("<html><a href=\"" + pelicula.getLink_trailer() + "\">Ver Trailer</a></html>");
        LblTrailer1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LblTrailer1.addMouseListener(new java.awt.event.MouseAdapter() {
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
            List<FuncionDTO> funcionesLista = this.funcionNeg.listaFuncionporDiaSucursalPelicula(dia, sucursal.getId(), pelicula.getId());
            this.llenarTablaAlumnos(funcionesLista);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarConfiguracionInicialTablaAlumnos() {
        ActionListener onEditarClickListener = new ActionListener() {
            final int columnaId = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                //Metodo para editar un alumno
                editar();

            }
        };
        int indiceColumnaEditar = 4;
        TableColumnModel modeloColumnas = this.tblFunciones.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellRenderer(new JButtonRenderer("Editar"));
        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellEditor(new JButtonCellEditor("Editar",
                        onEditarClickListener));

        ActionListener onEliminarClickListener = new ActionListener() {
            final int columnaId = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                //Metodo para eliminar un alumno
                eliminar();
            }
        };
        int indiceColumnaEliminar = 5;
        modeloColumnas = this.tblFunciones.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellEditor(new JButtonCellEditor("Eliminar",
                        onEliminarClickListener));
    }

    private void llenarTablaAlumnos(List<FuncionDTO> funcionLista) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblFunciones.getModel();

        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }
        if (funcionLista != null) {
            funcionLista.forEach(row
                    -> {
                Object[] fila = new Object[5];
                fila[0] = row.getId();
                try {
                    fila[1] = salaNeg.obtenerSalaPorID(row.getIdSala()).getNombre();
                } catch (NegocioException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
                }
                fila[2] = row.getHora();
                fila[3] = row.getHoraFinal();

                modeloTabla.addRow(fila);
            });
        }
    }

    private int getIdSeleccionadoTablaFunciones() {
        int indiceFilaSeleccionada = this.tblFunciones.getSelectedRow();
        if (indiceFilaSeleccionada != -1 && this.tblFunciones.getRowCount() > 0) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblFunciones.getModel();
            int indiceColumnaId = 0;
            int idSocioSeleccionado = (int) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return idSocioSeleccionado;
        } else {
            return 0;
        }
    }

    private void editar() {

        try {
            int id = this.getIdSeleccionadoTablaFunciones();
            if (id == 0) {
                throw new NegocioException("Por favor seleccione una funcion");
            }
            FuncionDTO funcionDTO = funcionNeg.buscarPorIdFuncion(id);
            SalaDTO sala = salaNeg.obtenerSalaPorID(funcionDTO.getIdSala());
            DlgEditarFuncion editarFuncion = new DlgEditarFuncion(this, true, salaNeg, funcionNeg, sucursalNeg, sucursal, pelicula, funcionDTO, sala);
            editarFuncion.setVisible(true);
            System.out.println(funcionDTO);
            System.out.println(sala);

            cargarFuncionesEnTabla();

        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminar() {

        try {
            int id = this.getIdSeleccionadoTablaFunciones();
            if (id == 0) {
                throw new NegocioException("Por favor seleccione una funcion");
            }

            int confirmacion = JOptionPane.showOptionDialog(this,
                    "¿Está seguro de que desea eliminar este alumno?",
                    "Confirmación de eliminación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"Confirmar", "Cancelar"},
                    "Confirmar");

            // Si el usuario selecciona "Cancelar", no se hace nada
            if (confirmacion != JOptionPane.YES_OPTION) {
                return;
            }
            funcionNeg.eliminarFuncion(funcionNeg.buscarPorIdFuncion(id));
            cargarFuncionesEnTabla();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void BtnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLogOutActionPerformed
        int response = JOptionPane.showConfirmDialog(
                this,
                "¿Desea Continuar a Cerrar Sesion?",
                "Cerrar Sesion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        // Verificar la respuesta del usuario
        if (response == JOptionPane.YES_OPTION) {
            for (Window window : Window.getWindows()) {
                window.dispose();
            }
            FrmInicio newFrame = new FrmInicio(clienteNeg, peliculaNeg, ciudadNeg, paisNeg, sucursalNeg, funcionNeg, salaNeg);
            newFrame.setVisible(true);
        }    }//GEN-LAST:event_BtnLogOutActionPerformed

    private void BtnLittleLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLittleLogoActionPerformed
        Forms.cargarForm(new FrmCatalogoSucursalFuncion(funcionNeg, peliculaNeg, cliente, clienteNeg, pelicula, sucursal, ciudadNeg, sucursalNeg, paisNeg, salaNeg), this);
    }//GEN-LAST:event_BtnLittleLogoActionPerformed

    private void BtnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAtrasActionPerformed
        LblDia.setText(obtenerDiaAnterior(LblDia.getText()));
        this.cargarFuncionesEnTabla();

    }//GEN-LAST:event_BtnAtrasActionPerformed

    private void BtnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSiguienteActionPerformed

        LblDia.setText(obtenerDiaSiguiente(LblDia.getText()));
        this.cargarFuncionesEnTabla();
    }//GEN-LAST:event_BtnSiguienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DlgAgregarFuncion agregarFuncion = new DlgAgregarFuncion(this, true, salaNeg, funcionNeg, sucursalNeg, sucursal, pelicula);
        agregarFuncion.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAtras;
    private javax.swing.JButton BtnLittleLogo;
    private javax.swing.JButton BtnLogOut;
    private javax.swing.JButton BtnLogo;
    private javax.swing.JButton BtnPelicula1;
    private javax.swing.JButton BtnSiguiente;
    private javax.swing.JLabel LblClasificacion;
    private javax.swing.JLabel LblDia;
    private javax.swing.JLabel LblDuracion;
    private javax.swing.JLabel LblPais;
    private javax.swing.JLabel LblTitulo;
    private javax.swing.JLabel LblTrailer1;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFunciones;
    // End of variables declaration//GEN-END:variables
}