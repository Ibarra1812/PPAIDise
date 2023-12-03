
public class pantallaPrueba extends javax.swing.JFrame {
    private GestorRtaOperador gestor;
    
    public pantallaPrueba(GestorRtaOperador gestor) {
        this.gestor = gestor;
        initComponents();
    }

    
    public void habilitarVentana(){
        this.setVisible(true);
        
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        txtOpcion = new javax.swing.JTextField();
        txtSubOpcion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboMensajesValidacion = new javax.swing.JComboBox<>();
        btnValidar = new javax.swing.JButton();
        txtDatoaValidar = new javax.swing.JTextField();
        txtRtaOperador = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre Cliente:");

        txtNombreCliente.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNombreCliente.setEnabled(false);
        txtNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreClienteActionPerformed(evt);
            }
        });

        txtCategoria.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCategoria.setEnabled(false);
        txtCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoriaActionPerformed(evt);
            }
        });

        txtOpcion.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtOpcion.setEnabled(false);
        txtOpcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOpcionActionPerformed(evt);
            }
        });

        txtSubOpcion.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtSubOpcion.setEnabled(false);
        txtSubOpcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubOpcionActionPerformed(evt);
            }
        });

        jLabel2.setText("Categoria:");

        jLabel3.setText("Opcion:");

        jLabel4.setText("SubOpcion: ");

        comboMensajesValidacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboMensajesValidacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMensajesValidacionActionPerformed(evt);
            }
        });

        btnValidar.setText("Validar");
        btnValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarActionPerformed(evt);
            }
        });

        txtDatoaValidar.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDatoaValidar.setEnabled(false);
        txtDatoaValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatoaValidarActionPerformed(evt);
            }
        });

        txtRtaOperador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRtaOperadorActionPerformed(evt);
            }
        });

        jLabel5.setText("Respuesta: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtDatoaValidar)
                                    .addGap(18, 18, 18)
                                    .addComponent(comboMensajesValidacion, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(26, 26, 26)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnValidar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSubOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(490, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtRtaOperador, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRtaOperador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboMensajesValidacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDatoaValidar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnValidar)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreClienteActionPerformed
    }//GEN-LAST:event_txtNombreClienteActionPerformed

    private void txtCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoriaActionPerformed

    private void txtOpcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOpcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOpcionActionPerformed

    private void txtSubOpcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubOpcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubOpcionActionPerformed

    private void comboMensajesValidacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMensajesValidacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboMensajesValidacionActionPerformed

    private void txtDatoaValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatoaValidarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDatoaValidarActionPerformed

    private void btnValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarActionPerformed
        
    }//GEN-LAST:event_btnValidarActionPerformed

    private void txtRtaOperadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRtaOperadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRtaOperadorActionPerformed

    /**
     * @param args the command line arguments
     */
    public void mostrarDatosLlamadayValidaciones(){
        String[] datos = gestor.obtenerDatosLlamada();
        txtNombreCliente.setText(datos[0]);
        txtCategoria.setText(datos[1]);
        txtOpcion.setText(datos[2]);
        txtSubOpcion.setText(datos[3]);
        
        tomarIngresoDatoValidacion();
    
    }
    
    public String tomarIngresoDatoValidacion(){
        String fechasNacimiento[] = new String[4];
        comboMensajesValidacion.removeAllItems();
        
        fechasNacimiento[0]="04/08/1999";
        fechasNacimiento[1]="25/09/2000";
        fechasNacimiento[2]="05/3/2001";
        fechasNacimiento[3]="13/07/2002";
        
        comboMensajesValidacion.addItem("04/08/1999");
        comboMensajesValidacion.addItem("25/09/2000");
        comboMensajesValidacion.addItem("05/3/2001");
        comboMensajesValidacion.addItem("13/07/2002");
        
        
        txtDatoaValidar.setText(gestor.buscarValidaciones());
        
        
        
        return "04/08/1999";
    
    }
    
    public void permitirIngresoDatoOperador(){
        txtRtaOperador.setEnabled(false);
        
        if (gestor.validarInformacionCliente()==true){
            txtRtaOperador.setEnabled(true);
        }
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnValidar;
    private javax.swing.JComboBox<String> comboMensajesValidacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtDatoaValidar;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtOpcion;
    private javax.swing.JTextField txtRtaOperador;
    private javax.swing.JTextField txtSubOpcion;
    // End of variables declaration//GEN-END:variables
}
