/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forms;

import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;
import com.github.lgooddatepicker.optionalusertools.TimeVetoPolicy;
import dtos.FuncionDTO;
import dtos.PeliculaDTO;
import dtos.SalaDTO;
import dtos.SucursalDTO;
import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import negocio.IFuncionNegocio;
import negocio.ISalaNegocio;
import negocio.ISucursalNegocio;
import negocio.NegocioException;
import utilerias.DiasEnum;

/**
 *
 * @author Usuario
 */
public class DlgAgregarFuncion extends javax.swing.JDialog {

    FrmPeliculaFuncion peliculaFuncion;
    boolean modoEstreno = false;
    SucursalDTO sucursal;
    PeliculaDTO pelicula;
    ISalaNegocio salaNeg;
    IFuncionNegocio funcionNeg;
    ISucursalNegocio sucursalNeg;
    List<DiasEnum> listaDias;
    List<SalaDTO> listaSalas;

    public DlgAgregarFuncion(java.awt.Frame parent, boolean modal, ISalaNegocio salaNeg, IFuncionNegocio funcionNeg, ISucursalNegocio sucursalNeg,
            SucursalDTO sucursal, PeliculaDTO pelicula) {
        super(parent, modal);
        initComponents();
        peliculaFuncion = (FrmPeliculaFuncion) parent;
        this.sucursal = sucursal;
        this.pelicula = pelicula;
        this.funcionNeg = funcionNeg;
        this.salaNeg = salaNeg;
        this.funcionNeg = funcionNeg;
        listaDias = DiasEnum.obtenerTodoslosDias();
        aplicarConfiguracionTiempo();
        metodosIniciales();
        llenarComboBoxCiudad();
        lblSucursal.setText(this.sucursal.getNombre());

    }

    private void metodosIniciales() {
        this.llenarComboBoxDia();
    }

    private void aplicarConfiguracionTiempo() {
        // Obtener los TimePickerSettings actuales
        TimePickerSettings configuracion = timePicker.getSettings();

        // Configurar el formato de 24 horas
        configuracion.use24HourClockFormat();

        // Definir los límites de tiempo
        LocalTime tiempoMin = LocalTime.of(9, 0);  // 9 AM
        LocalTime tiempoMax = LocalTime.of(23, 59);  // 11:59 PM

        // Aplicar una política de veto para limitar el rango de tiempo
        configuracion.setVetoPolicy(new TimeVetoPolicy() {
            @Override
            public boolean isTimeAllowed(LocalTime time) {
                return !time.isBefore(tiempoMin) && !time.isAfter(tiempoMax);
            }
        });

        configuracion.generatePotentialMenuTimes(TimePickerSettings.TimeIncrement.FifteenMinutes, tiempoMin, tiempoMax);

        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LocalTime hora = timePicker.getTime();
                if (hora != null) {
                    System.out.println("Hora seleccionada: " + hora);
                    // Aquí puedes hacer lo que necesites con la hora seleccionada
                } else {
                    System.out.println("No se ha seleccionado una hora válida.");
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
        lblSucursal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        RbtnEstreno = new javax.swing.JRadioButton();
        btnAgregar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        timePicker = new com.github.lgooddatepicker.components.TimePicker();
        cbSala2 = new javax.swing.JComboBox<>();
        cbDia = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Funcion");
        setAlwaysOnTop(true);

        jPanel1.setBackground(new java.awt.Color(5, 16, 42));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(252, 207, 4));

        lblSucursal.setBackground(new java.awt.Color(5, 16, 42));
        lblSucursal.setForeground(new java.awt.Color(5, 16, 42));
        lblSucursal.setText("lblSucursal");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(lblSucursal))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/littlelogoMedium.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 55, -1, -1));

        RbtnEstreno.setBackground(new java.awt.Color(5, 16, 42));
        RbtnEstreno.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        RbtnEstreno.setForeground(new java.awt.Color(204, 204, 204));
        RbtnEstreno.setText("Estreno (Media Noche)");
        RbtnEstreno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbtnEstrenoActionPerformed(evt);
            }
        });
        jPanel1.add(RbtnEstreno, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 212, -1));

        btnAgregar.setBackground(new java.awt.Color(252, 207, 4));
        btnAgregar.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(5, 16, 42));
        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 120, 32));

        jPanel3.setBackground(new java.awt.Color(5, 16, 42));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(timePicker, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addComponent(timePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        timePicker.getAccessibleContext().setAccessibleParent(jPanel1);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));

        jPanel1.add(cbSala2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 190, 30));

        jPanel1.add(cbDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 190, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void llenarComboBoxCiudad() {
        try {
            listaSalas = salaNeg.listaSalasporSucursal(sucursal.getId());

            for (SalaDTO sala : listaSalas) {
                cbSala2.addItem(sala);
            }
        } catch (NegocioException ex) {
            Logger.getLogger(DlgElegirSucursal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void llenarComboBoxDia() {
        for (DiasEnum dia : listaDias) {
            cbDia.addItem(dia.name());
        }
    }

    private void RbtnEstrenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbtnEstrenoActionPerformed
        this.modoEstreno = !modoEstreno;

        if (modoEstreno) {
            jPanel3.setVisible(false);// Deshabilitar el TimePicker
        } else {
            jPanel3.setVisible(true); // Deshabilitar el TimePicker
        }

        // Actualizar la interfaz gráfica para reflejar el estado actual de modoEstreno
        SwingUtilities.invokeLater(() -> {
            // Repintar y revalidar el contenedor del TimePicker (si es necesario)
            Container parent = timePicker.getParent();
            if (parent instanceof JComponent) {
                ((JComponent) parent).revalidate();
                ((JComponent) parent).repaint();
            } else {
                timePicker.revalidate();
                timePicker.repaint();
            }
        });


    }//GEN-LAST:event_RbtnEstrenoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String dia = cbDia.getSelectedItem() != null ? cbDia.getSelectedItem().toString() : "";
        SalaDTO sala = cbSala2.getSelectedItem() instanceof SalaDTO ? (SalaDTO) cbSala2.getSelectedItem() : null;
        if (dia.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un dia.", "Dia no seleccionado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (sala == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una sala.", "Sala no seleccionada", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (modoEstreno) {
            try {
                LocalTime medianoche = LocalTime.of(0, 0);
                FuncionDTO funcion = new FuncionDTO(dia, medianoche, sala.getId(), pelicula.getId());
                funcionNeg.agregarFuncion(funcion);
                peliculaFuncion.cargarFuncionesEnTabla();
                JOptionPane.showMessageDialog(this, "Funcion agregada exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (NegocioException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo agregar la pelicula: Verifica las demas funciones ", "Error al agregar la pelicula", JOptionPane.ERROR_MESSAGE);

            }
        }
        if (!modoEstreno) {
            LocalTime hora = timePicker.getTime();
            try {
                if (hora == null) {
                    JOptionPane.showMessageDialog(this, "Por favor, seleccione una hora.", "hora no seleccionada", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                System.out.println(hora);
                FuncionDTO funcion = new FuncionDTO(dia, hora, sala.getId(), pelicula.getId());
                funcionNeg.agregarFuncion(funcion);
                peliculaFuncion.cargarFuncionesEnTabla();
                JOptionPane.showMessageDialog(this, "Funcion agregada exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (NegocioException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo agregar la pelicula: Verifica las demas funciones ", "Error al agregar la pelicula", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RbtnEstreno;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox<String> cbDia;
    private javax.swing.JComboBox<SalaDTO> cbSala2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblSucursal;
    private com.github.lgooddatepicker.components.TimePicker timePicker;
    // End of variables declaration//GEN-END:variables
}
