package Vista;


import Controlador.GestorRtaOperador;
import Modelos.Validacion;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;


public class PantallaRtaOperador extends javax.swing.JFrame {
    private GestorRtaOperador gestor;
    public PantallaRtaOperador(GestorRtaOperador gestor) {
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
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        txtOpcion = new javax.swing.JTextField();
        txtSubOpcion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboValidaciones = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        comboMensajesValidacion = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnValidar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtRtaOperador = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jCheckBox1.setText("jCheckBox1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

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

        comboValidaciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboValidaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboValidacionesActionPerformed(evt);
            }
        });

        jLabel6.setText("Validacion: ");

        comboMensajesValidacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboMensajesValidacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMensajesValidacionActionPerformed(evt);
            }
        });

        jLabel7.setText("Dato a validar: ");

        btnValidar.setText("Validar");
        btnValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCategoria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnValidar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(comboValidaciones, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSubOpcion, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addComponent(comboMensajesValidacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboValidaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboMensajesValidacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnValidar)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel5.setText("Respuesta: ");

        txtRtaOperador.setEnabled(false);
        txtRtaOperador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRtaOperadorActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                btnGuardarComponentAdded(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtRtaOperador, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(btnGuardar)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRtaOperador, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addContainerGap(36, Short.MAX_VALUE))
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
    //Se instancia cuando el boton validar es apretado, y va instanciar el metodo validarInformacionCliente
    // y si es instnacias validas, se permite el ingreso de informacion por parte del operador
    private void btnValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarActionPerformed
        permitirIngresoDatoOperador();
    }//GEN-LAST:event_btnValidarActionPerformed

    private void txtRtaOperadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRtaOperadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRtaOperadorActionPerformed
    //Se instancia cuando el operador ingrea una respuesta, y guarda y toma la confirmacion
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        tomarConfirmacion();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_btnGuardarComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarComponentAdded

    private void comboValidacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboValidacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboValidacionesActionPerformed

    //Metodo encargado de mostrar en pantalla los datos de la llamas y validaciones
    public void mostrarDatosLlamadayValidaciones(ArrayList<Validacion> cad){
        //Creamos un Array que contenga los datos de la llamada.
        String[] datos = gestor.obtenerDatosLlamada();
        
        txtNombreCliente.setText(datos[0]); //Setteamos el nombre del cliente.
        txtCategoria.setText(datos[1]); //Setteamos la categoria de la llamada.
        txtOpcion.setText(datos[2]); //Setteamos la opcion de la llamada.
        txtSubOpcion.setText(datos[3]); // Setteamos la subOpcion de la llamada.
        
        //Limpiamos los combo box de valicaiones y opciones de validacion.
        comboMensajesValidacion.removeAllItems();
        comboValidaciones.removeAllItems();

        //Ciclo encargado de cargar las validaciones en los combos.
        for(int i = 0 ; i<cad.size();i++){
            //agrega el nombre de la validacion al combo.
            comboValidaciones.addItem(cad.get(i).getMensajeValidacion());
            
        }
        
        //Ciclo encargado de cargar las opciones de validaciones correspondientes a la validacion.
        for(int i=0 ; i<cad.size();i++){
            //Condicionar que verifica que el nombre de la validacion seleccionada en el combo box anterior
            //sea igual a las que son traidas por el nuevo ciclo.
            if(cad.get(i).getMensajeValidacion() == comboValidaciones.getSelectedItem()){
                
                //Una vez que es igual procede a traer todas las opciones de validacion correspondientes a la validacion.
                for(int j=0;j<cad.get(i).getOpcionValidacion().size();j++){
                    //Carga en el combo box las opciones de validaciones.
                    comboMensajesValidacion.addItem(cad.get(i).getOpcionValidacion().get(j).getDescripcion());
                }
            }
        }
        
        
        
       
    
    }
    
    //Metodo encargado de tomar el ingreso del dato de validacion.
    public String tomarIngresoDatoValidacion(){
        
        //Devuelve la opcion seleccionada en el combo box.
        return (String)comboMensajesValidacion.getSelectedItem();
    
    }    
      
    //Metodo encargado de permitir el ingreso de una respuesta por parte del operador.
    public void permitirIngresoDatoOperador(){
        //Habilita el campo de respuesta.
        txtRtaOperador.setEnabled(true);
        //Tomamos la respuesta ingresada por el operador.
        tomarRespuestaOperador();

    }
    
    //Metodo encargado de tomar la respuesta del operador.
    public String tomarRespuestaOperador(){
        return txtRtaOperador.getText();
        
    }
     
      
    //Metodo encargadp de solicitar la confirmacion.
    public int solicitarConfirmacion(){
        //Creamos una variables respuesta, que despliega una ventana con la confirmacion del CU.
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Deseas guardar los cambios?", "Confirmar", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE );
        return respuesta;
    }
    /*
    Metodo #33
    Instancia la toma de confirmacion en el gestor
    */
    public void tomarConfirmacion(){
        
        if (solicitarConfirmacion() == JOptionPane.YES_OPTION) {
            gestor.confirmar();
        }
    }
    // Es un mensaje para informar si la accion se realizo, cuando recibimos el resultado del caso de uso
    public void informarAccionRegistrada(){
        JOptionPane.showMessageDialog(null, "¡Se cumplió!");
    }
        /*
    Metodo #35
    Informa al operador que la accion fue registrada
    */
    public void InformarAccionRegistrada(){
        Random num = new Random();
        boolean validacionAccion = num.nextBoolean();
        if(validacionAccion == true){
            JOptionPane.showMessageDialog(this,"AccionRegistrada");
        }else{
            JOptionPane.showMessageDialog(this,"No se pudo registrar la accion");
        }
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnValidar;
    private javax.swing.JComboBox<String> comboMensajesValidacion;
    private javax.swing.JComboBox<String> comboValidaciones;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtOpcion;
    private javax.swing.JTextField txtRtaOperador;
    private javax.swing.JTextField txtSubOpcion;
    // End of variables declaration//GEN-END:variables
}
