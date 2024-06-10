/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import dtos.ClienteDTO;
import dtos.PeliculaDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import negocio.IClienteNegocio;
import negocio.IPeliculaNegocio;
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
    private IPeliculaNegocio peliculas;
    private PeliculaDTO pelicula;
    private ClienteDTO cliente;

    /**
     * Creates new form FrmCatalogoClientes
     */
    public FrmCatalogoClientes(IClienteNegocio clienteNeg, IPeliculaNegocio peliculas, PeliculaDTO pelicula, ClienteDTO cliente) {
        initComponents();
        this.setLocationRelativeTo(this);
        this.clienteNeg = clienteNeg;
        this.peliculas = peliculas;
        this.pelicula = pelicula;
        this.cliente = cliente;
        this.cargarMetodosIniciales();
    }

    private void cargarMetodosIniciales() {
        this.cargarConfiguracionInicialTablaCliente();
        this.cargarClientesEnTabla();
    }

    private void cargarConfiguracionInicialTablaCliente() {
        ActionListener onEliminarClickListener = new ActionListener() {
            final int columnald = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                eliminar();
            }
        };

        int indiceColumnaEliminar = 6;
        TableColumnModel modeloColumnas = this.tblClientes.getColumnModel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        bRegresar = new javax.swing.JButton();
        bSiguiente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtFiltroNombre = new javax.swing.JTextField();
        txtFiltroCorreo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        BtnLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO.png"))); // NOI18N
        BtnLogo.setContentAreaFilled(false);
        BtnLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLogoActionPerformed(evt);
            }
        });

        BtnLittleLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/littlelogo.png"))); // NOI18N
        BtnLittleLogo.setContentAreaFilled(false);
        BtnLittleLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLittleLogoActionPerformed(evt);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnLittleLogo)
                    .addComponent(BtnLogo))
                .addContainerGap())
        );

        tblClientes.setAutoCreateRowSorter(true);
        tblClientes.setBackground(new java.awt.Color(0, 0, 102));
        tblClientes.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tblClientes.setForeground(new java.awt.Color(0, 153, 153));
        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido P.", "Apellido M.", "Correo", "Fecha de nacimiento", "Eliminar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Pagina 1");

        txtFiltroNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroNombreActionPerformed(evt);
            }
        });

        txtFiltroCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroCorreoActionPerformed(evt);
            }
        });

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
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 351, Short.MAX_VALUE)
                .addComponent(bSiguiente)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(txtFiltroNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtFiltroCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFiltroNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFiltroCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bRegresar)
                    .addComponent(bSiguiente)
                    .addComponent(jLabel1))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLogoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnLogoActionPerformed

    private void bRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bRegresarActionPerformed

    private void txtFiltroNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroNombreActionPerformed

    private void txtFiltroCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroCorreoActionPerformed

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
        Forms.cargarForm(new FrmModoAdmin(peliculas, cliente, clienteNeg,pelicula), this);
    }//GEN-LAST:event_BtnLittleLogoActionPerformed

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
    private javax.swing.JButton BtnLogo;
    private javax.swing.JButton bRegresar;
    private javax.swing.JButton bSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtFiltroCorreo;
    private javax.swing.JTextField txtFiltroNombre;
    // End of variables declaration//GEN-END:variables
}
