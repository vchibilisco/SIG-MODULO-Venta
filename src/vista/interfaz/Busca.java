package vista.interfaz;

import vista.recursos.ModeloTabla;
import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import vista.Controlador_S_MV;

public class Busca extends javax.swing.JDialog {

    private int returnStatus;
    private DefaultTableModel modelo = new ModeloTabla();
    private JTable tablaDatos = new JTable();
    private TableRowSorter filtroDatos;

    public Busca(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Dimension ventana = this.getSize();//Ubica el Frame
        setLocation(ventana.width - 470, ventana.height + 100);
        cargarTabla();//Carga tabla
        filtroDatos = new TableRowSorter(tablaDatos.getModel());//Filtrado
        tablaDatos.setRowSorter(filtroDatos);
        tablaDatos.getTableHeader().setReorderingAllowed(false);
        tablaDatos.getTableHeader().setResizingAllowed(false);
    }

    public int getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(int returnStatus) {
        this.returnStatus = returnStatus;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(ModeloTabla modelo) {
        this.modelo = modelo;
    }

    public JTable getTablaDatos() {
        return tablaDatos;
    }

    public void setTablaDatos(JTable tablaDatos) {
        this.tablaDatos = tablaDatos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane(tablaDatos);
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/OK.png"))); // NOI18N
        btnAgregar.setToolTipText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/Cancel.png"))); // NOI18N
        btnCerrar.setToolTipText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscar:");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(20, 20, 20)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 262, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAgregar)
                                .addGap(18, 18, 18)
                                .addComponent(btnCerrar)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar)
                    .addComponent(btnAgregar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //evento de boton cerrar
    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    //Evento de boton agregar
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        agregar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        filtro(0);
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void agregar() {
        try {
            Integer cup = (Integer) modelo.getValueAt(tablaDatos.getSelectedRow(), 0);
            Integer stock = (Integer) modelo.getValueAt(tablaDatos.getSelectedRow(), 2);
            Integer cant = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese la Cantidad: ", "Cantidad a llevar", JOptionPane.INFORMATION_MESSAGE));
            if (cant < stock) {
                Controlador_S_MV.cargarProducto(cup, cant);
            } else {
                JOptionPane.showMessageDialog(this, "No posee esa cantidad de STOCK en estos momentos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un valor numerico entero.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    //Grupo de botones que filtra la tabla
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    //Metodo que carga Tabla
    private void cargarTabla() {
        modelo.addColumn("Codigo");
        modelo.addColumn("Descripcion/Producto");
        modelo.addColumn("Stock Actual");
        modelo.addColumn("Precio Unitario");
        Controlador_S_MV.completarTablaBuscar(modelo);
        tablaDatos.setModel(modelo);
        TableColumn columCodigo = tablaDatos.getColumn("Codigo");
        columCodigo.setMinWidth(60);
        columCodigo.setMaxWidth(60);
        TableColumn columDesc = tablaDatos.getColumn("Descripcion/Producto");
        columDesc.setMinWidth(270);
        columDesc.setMaxWidth(270);
        TableColumn columStock = tablaDatos.getColumn("Stock Actual");
        columStock.setMinWidth(100);
        columStock.setMaxWidth(100);
        TableColumn columPrecUn = tablaDatos.getColumn("Precio Unitario");
        columPrecUn.setMinWidth(100);
        columPrecUn.setMaxWidth(100);                
    }

    //Metodo que filtra
    private void filtro(int colum) {
        filtroDatos.setRowFilter(RowFilter.regexFilter(txtBuscar.getText().toUpperCase(), colum));
    }
}
