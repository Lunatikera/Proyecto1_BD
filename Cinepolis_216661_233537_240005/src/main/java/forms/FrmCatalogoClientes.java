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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        bSiguiente = new javax.swing.JButton();
        lblPagina = new javax.swing.JLabel();
        bRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(BtnLittleLogo)
                .addGap(221, 221, 221)
                .addComponent(BtnLogo)
                .addContainerGap(382, Short.MAX_VALUE))
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

        bSiguiente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bSiguiente.setText("Siguiente");
        bSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSiguienteActionPerformed(evt);
            }
        });

        lblPagina.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblPagina.setText("Pagina 1");

        bRegresar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bRegresar.setText("Regresar");
        bRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bRegresar)
                .addGap(352, 352, 352)
                .addComponent(lblPagina)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bSiguiente)
                .addGap(16, 16, 16))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bRegresar)
                    .addComponent(bSiguiente)
                    .addComponent(lblPagina))
                .addGap(20, 20, 20))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
        Forms.cargarForm(new FrmModoAdmin(peliculas, cliente, clienteNeg, pelicula), this);
    }//GEN-LAST:event_BtnLittleLogoActionPerformed

    private void bSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSiguienteActionPerformed
        this.pagina = this.pagina + 1;
        this.cargarClientesEnTabla();
        this.lblPagina.setText("Página " + this.pagina);
    }//GEN-LAST:event_bSiguienteActionPerformed

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPagina;
    private javax.swing.JTable tblClientes;
    // End of variables declaration//GEN-END:variables
}
