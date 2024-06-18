/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import dtos.ClienteDTO;
import dtos.PeliculaDTO;
import dtos.SucursalDTO;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import negocio.ICiudadNegocio;
import negocio.IClienteNegocio;
import negocio.IFuncionNegocio;
import negocio.IPaisNegocio;
import negocio.IPeliculaNegocio;
import negocio.ISalaNegocio;
import negocio.ISucursalNegocio;
import negocio.NegocioException;
import utilerias.Forms;
import utilerias.JButtonCellEditor;
import utilerias.JButtonRenderer;

/**
 *
 * @author Chris
 */
public class FrmCatalogoClientes extends javax.swing.JFrame {

    private int pagina = 1;
    private final int limite = 10;
    private IClienteNegocio clienteNeg;
    private IPeliculaNegocio peliculaNeg;
    private IPaisNegocio paisNeg;
    private ISucursalNegocio sucursalNeg;
    private ICiudadNegocio ciudadNeg;
    private IFuncionNegocio funcionNeg;
    private ISalaNegocio salaNeg;
    private PeliculaDTO pelicula;
    private ClienteDTO cliente;
    private SucursalDTO sucursal;

    /**
     * Creates new form FrmCatalogoClientes
     */
    public FrmCatalogoClientes(ISalaNegocio salaNeg, IFuncionNegocio funcionNeg,IPaisNegocio paisNeg, ISucursalNegocio sucursalNeg, ICiudadNegocio ciudadNeg, IClienteNegocio clienteNeg, IPeliculaNegocio peliculas, PeliculaDTO pelicula, ClienteDTO cliente, SucursalDTO sucursal) {
        initComponents();
        this.setLocationRelativeTo(this);
        this.clienteNeg = clienteNeg;
        this.paisNeg=paisNeg;
        this.ciudadNeg=ciudadNeg;
        this.funcionNeg=funcionNeg;
        this.sucursalNeg=sucursalNeg;
        this.salaNeg=salaNeg;
        this.peliculaNeg = peliculas;
        this.pelicula = pelicula;
        this.cliente = cliente;
        this.sucursal=sucursal;
        this.cargarMetodosIniciales();
    }

    private void cargarMetodosIniciales() {
        this.cargarConfiguracionInicialTablaCliente();
        this.cargarClientesEnTabla();
    }

    private void cargarConfiguracionInicialTablaCliente() {
        ActionListener onEditarClickListener = new ActionListener() {
            final int columnaId = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                editar();
            }
        };
        int indiceColumnaEditar = 6;
        TableColumnModel modeloColumnas = this.tblClientes.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEditar).setCellRenderer(new JButtonRenderer("Editar"));
        modeloColumnas.getColumn(indiceColumnaEditar).setCellEditor(new JButtonCellEditor("Editar", onEditarClickListener));

        ActionListener onEliminarClickListener = new ActionListener() {
            final int columnald = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                eliminar();
            }
        };

        int indiceColumnaEliminar = 7;
        modeloColumnas = this.tblClientes.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEliminar).setCellRenderer(new JButtonRenderer("Eliminar"));

        modeloColumnas.getColumn(indiceColumnaEliminar).setCellEditor(new JButtonCellEditor("Eliminar", onEliminarClickListener));
    }

    private int getIdSeleccionadoTabla() {
        int indiceFilaSeleccionada = this.tblClientes.getSelectedRow();

        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblClientes.getModel();
            int indiceColumnaId = 0;
            int idSocioSeleccionado = (int) modelo.getValueAt(indiceFilaSeleccionada, indiceColumnaId);

            return idSocioSeleccionado;
        } else {
            return 0;
        }
    }

    private void editar() {
        int id = this.getIdSeleccionadoTabla();

        try {
            ClienteDTO cliente = clienteNeg.buscarClientePorId(id);

            if (cliente != null) {
                JTextField nuevoNombre = new JTextField(cliente.getNombre());
                JTextField nuevoApellidoPA = new JTextField(cliente.getApellidoPA());
                JTextField nuevoApellidoMA = new JTextField(cliente.getApellidoMA());
                JTextField nuevoCorreo = new JTextField(cliente.getCorreo());

                Object[] message = {
                    "Nuevo Nombre:", nuevoNombre,
                    "Nuevo Apellido Paterno:", nuevoApellidoPA,
                    "Nuevo Apellido Materno:", nuevoApellidoMA,
                    "Nuevo Correo:", nuevoCorreo
                };

                int option = JOptionPane.showConfirmDialog(this, message, "Editar Cliente", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.OK_OPTION) {
                    cliente.setNombre(nuevoNombre.getText());
                    cliente.setApellidoPA(nuevoApellidoPA.getText());
                    cliente.setApellidoMA(nuevoApellidoMA.getText());
                    cliente.setCorreo(nuevoCorreo.getText());

                    clienteNeg.actualizarCliente(cliente);
                    this.actualizarTabla();
                    JOptionPane.showMessageDialog(this, "Cliente actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Cliente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminar() {
        int id = this.getIdSeleccionadoTabla();

        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar al cliente?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                clienteNeg.eliminarCliente(id);
                actualizarTabla();
                JOptionPane.showMessageDialog(this, "Cliente eliminado exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (NegocioException e) {
                Logger.getLogger(FrmCatalogoClientes.class.getName()).log(Level.SEVERE, null, e);
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void llenarTablaClientes(List<ClienteDTO> listaCliente) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblClientes.getModel();

        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }

        if (listaCliente != null) {
            listaCliente.forEach(row -> {
                Object[] fila = new Object[6];
                fila[0] = row.getId();
                fila[1] = row.getNombre();
                fila[2] = row.getApellidoPA();
                fila[3] = row.getApellidoMA();
                fila[4] = row.getCorreo();
                fila[5] = row.getFechaNacimiento();

                modeloTabla.addRow(fila);
            });
        }
    }

    private void cargarClientesEnTabla() {
        try {
            List<ClienteDTO> clientes = this.clienteNeg.buscarClientes(limite, pagina);
            this.llenarTablaClientes(clientes);
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Informacion", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarTabla() {
        try {
            List<ClienteDTO> listaClientes = clienteNeg.buscarClientes(limite, pagina);
            DefaultTableModel model = (DefaultTableModel) this.tblClientes.getModel();
            model.setRowCount(0);

            for (ClienteDTO cliente : listaClientes) {
                Object[] fila = {
                    cliente.getId(),
                    cliente.getNombre(),
                    cliente.getApellidoPA(),
                    cliente.getApellidoMA(),
                    cliente.getCorreo(),
                    cliente.getFechaNacimiento()
                };
                model.addRow(fila);
            }
        } catch (NegocioException e) {
            Logger.getLogger(FrmCatalogoClientes.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        jPanel1 = new javax.swing.JPanel();
        BtnLogo = new javax.swing.JButton();
        BtnLittleLogo = new javax.swing.JButton();
        BtnPerfil = new javax.swing.JButton();
        BtnLogOut = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        bRegresar = new javax.swing.JButton();
        bSiguiente = new javax.swing.JButton();
        lblPagina = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cinepolis - Catalogo Clientes");
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(5, 16, 42));

        BtnLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO.png"))); // NOI18N
        BtnLogo.setContentAreaFilled(false);
        BtnLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLogoActionPerformed(evt);
            }
        });

        BtnLittleLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/undo (1).png"))); // NOI18N
        BtnLittleLogo.setContentAreaFilled(false);
        BtnLittleLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLittleLogoActionPerformed(evt);
            }
        });

        BtnPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/perfil.PNG"))); // NOI18N
        BtnPerfil.setBorder(null);
        BtnPerfil.setBorderPainted(false);
        BtnPerfil.setContentAreaFilled(false);
        BtnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPerfilActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(BtnLittleLogo)
                .addGap(221, 221, 221)
                .addComponent(BtnLogo)
                .addGap(197, 197, 197)
                .addComponent(BtnPerfil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(BtnLogOut)
                            .addGap(7, 7, 7))
                        .addComponent(BtnPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BtnLittleLogo)
                        .addComponent(BtnLogo)))
                .addContainerGap())
        );

        tblClientes.setAutoCreateRowSorter(true);
        tblClientes.setBackground(new java.awt.Color(0, 0, 102));
        tblClientes.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tblClientes.setForeground(new java.awt.Color(0, 153, 153));
        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido P.", "Apellido M.", "Correo", "Fecha de nacimiento", "Editar", "Eliminar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        bRegresar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bRegresar.setText("Regresar");
        bRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegresarActionPerformed(evt);
            }
        });

        bSiguiente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bSiguiente.setText("Siguiente");
        bSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSiguienteActionPerformed(evt);
            }
        });

        lblPagina.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblPagina.setText("Pagina 1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(bRegresar)
                .addGap(352, 352, 352)
                .addComponent(lblPagina)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 351, Short.MAX_VALUE)
                .addComponent(bSiguiente)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bRegresar)
                    .addComponent(bSiguiente)
                    .addComponent(lblPagina))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLogoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnLogoActionPerformed

    private void bRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegresarActionPerformed
        this.pagina = this.pagina - 1;
        this.cargarClientesEnTabla();
        this.lblPagina.setText("Página " + this.pagina);
    }//GEN-LAST:event_bRegresarActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        int col = tblClientes.columnAtPoint(evt.getPoint());
        String name = tblClientes.getColumnName(col);

        switch (name) {
            case "Nombre":
                ordenarPorColumna(1);
                break;
            case "Apellido Paterno":
                ordenarPorColumna(2);
                break;
            case "Apellido Materno":
                ordenarPorColumna(3);
                break;
        }
    }//GEN-LAST:event_tblClientesMouseClicked

    private void BtnLittleLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLittleLogoActionPerformed
        this.dispose();
    }//GEN-LAST:event_BtnLittleLogoActionPerformed

    private void bSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSiguienteActionPerformed
        this.pagina = this.pagina + 1;
        this.cargarClientesEnTabla();
        this.lblPagina.setText("Página " + this.pagina);
    }//GEN-LAST:event_bSiguienteActionPerformed

    private void BtnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPerfilActionPerformed
        Forms.cargarForm(new FrmModoAdmin(funcionNeg, peliculaNeg, sucursalNeg, clienteNeg, paisNeg, ciudadNeg, salaNeg, pelicula, cliente, sucursal), this);
    }//GEN-LAST:event_BtnPerfilActionPerformed

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
        }
        // Si
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnLogOutActionPerformed

    private void ordenarPorColumna(int columnIndexToSort) {
        TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) tblClientes.getRowSorter();

        if (sorter != null) {
            List<RowSorter.SortKey> sortKeys = new ArrayList<>();
            SortOrder sortOrder = SortOrder.ASCENDING;

            List<RowSorter.SortKey> currentSortKeys = (List<RowSorter.SortKey>) sorter.getSortKeys();
            if (!currentSortKeys.isEmpty() && currentSortKeys.get(0).getColumn() == columnIndexToSort) {
                SortOrder currentOrder = currentSortKeys.get(0).getSortOrder();
                sortOrder = currentOrder == SortOrder.ASCENDING ? SortOrder.DESCENDING : SortOrder.ASCENDING;
            }

            sortKeys.add(new RowSorter.SortKey(columnIndexToSort, sortOrder));
            sorter.setSortKeys(sortKeys);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnLittleLogo;
    private javax.swing.JButton BtnLogOut;
    private javax.swing.JButton BtnLogo;
    private javax.swing.JButton BtnPerfil;
    private javax.swing.JButton bRegresar;
    private javax.swing.JButton bSiguiente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPagina;
    private javax.swing.JTable tblClientes;
    // End of variables declaration//GEN-END:variables
}
