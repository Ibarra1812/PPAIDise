package org.grupoppai.Vista;

import org.grupoppai.Controlador.GestorRtaOperador;
import org.grupoppai.Modelos.Validacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;


public class PantallaRtaOperador extends Component {

    // Referencia al gestor.
    private final GestorRtaOperador gestor;

    // Atributos por referencia de la pantalla. Corresponden a componentes gráficos.
    private JButton validarButton;
    private JTextField respuestaOperadorTxt;
    private JButton guardarButton;
    private JComboBox validacionCombo;
    private JLabel cliente;
    private JLabel opcion;
    private JLabel subopcion;
    private JLabel categoria;
    private JLabel datoAValidar;
    private JLabel respuesta;
    private JLabel validacion;
    private JPanel pantallaJPanel;
    private JTextField nombreClienteTxt;
    private JTextField categoriaTxt;
    private JTextField opcionTxt;
    private JTextField subopcionTxt;
    private JLabel accionJLabel;
    private JTextField datoAValidarTxt;

    // Constructor de la pantalla. Recibe al gestor como parámetro.
    public PantallaRtaOperador(GestorRtaOperador gestorRtaOperador){

        this.gestor = gestorRtaOperador;

        // Setea el text de la respuesta del operador y el botón de guardar como desactivados.
        respuestaOperadorTxt.setEnabled(false);
        guardarButton.setEnabled(false);

        // Setea los texts de los datos obtenidos por el gestor como desactivados. Son únicamente para mostrar información.
        nombreClienteTxt.setEnabled(false);
        categoriaTxt.setEnabled(false);
        opcionTxt.setEnabled(false);
        subopcionTxt.setEnabled(false);

        // ActionListener del botón para validar el dato ingresado por el usuario.
        validarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tomarIngresoDatoValidacion();
            }
        });

        // ActionListener del botón para guardar la respuesta del operador.
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tomarRespuestaOperador();
            }

        });
    }

    // Método para habilitar la ventana de la pantalla.
    private void habilitarVentana(){
        JFrame frame = new JFrame("PPAI - Registrar respuesta de operador");
        frame.setContentPane(pantallaJPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    // Método encargado de mostrar en pantalla los datos de la llamadas y las validaciones.
    public void mostrarDatosLlamadaYValidaciones(List<String> validaciones,
                                                 String cliente,
                                                 List<String> datosCategoriaOpcionSubopcion){
        this.habilitarVentana();
        this.nombreClienteTxt.setText(cliente);
        this.categoriaTxt.setText(datosCategoriaOpcionSubopcion.get(0));
        this.opcionTxt.setText(datosCategoriaOpcionSubopcion.get(1));
        this.subopcionTxt.setText(datosCategoriaOpcionSubopcion.get(2));


        // Carga de las validaciones en los combos.
        for (String validacion : validaciones) {
            validacionCombo.addItem(validacion);
        }
    }

    // Método encargado de tomar el ingreso del dato de validacion.
    public void tomarIngresoDatoValidacion(){
        // Se pasa el dato al gestor.
        this.gestor.tomarDatoValidacion( validacionCombo.getSelectedIndex(), datoAValidarTxt.getText());
    }

    // Método encargado de permitir el ingreso de una respuesta por parte del operador.
    public void permitirIngresoDatoOperador(){

        // Se habilitan el campo de respuesta del operador y el botón de guardar.
        respuestaOperadorTxt.setEnabled(true);
        guardarButton.setEnabled(true);

        // Se deshabilitan los campos de validación y dato a validar y el botón de validar.
        validacionCombo.setEnabled(false);
        datoAValidarTxt.setEnabled(false);
        validarButton.setEnabled(false);
    }

    // Método encargado de tomar la respuesta del operador.
    public void tomarRespuestaOperador() {
        // Se pasa el dato al gestor.
        this.gestor.tomarRtaOperador(respuestaOperadorTxt.getText());
    }


    // Método encargado de solicitar la confirmación.
    public void solicitarConfirmacion() {
        // Creamos una variables respuesta, que despliega una ventana con la confirmación del CU.
        int respuestaConfirmacion = JOptionPane.showConfirmDialog(this, "¿Deseas guardar los cambios?", "Confirmar", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);

        if (respuestaConfirmacion == JOptionPane.YES_OPTION) {
            // Se pasa la confirmación al gestor.
            tomarConfirmacion();
        }
    }

    // Metodo encargado de tomar la confirmación en pantalla.
    public void tomarConfirmacion () {
        this.gestor.confirmar();
    }

    // Método para informar si la accion se realizo, cuando recibimos el resultado del caso de uso.
    public void informarAccionRegistrada(){
        guardarButton.setEnabled(false);
        respuestaOperadorTxt.setEnabled(false);
        JOptionPane.showMessageDialog(null, "Se registró la acción correctamente");
    }

    // FLUJO ALTERNATIVO: El dato de la validación es incorrecto.
    public void mostrarDatoValidacionIncorrecto() {
        JOptionPane.showMessageDialog(null, "El dato a validar es incorrecto.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
    }

    // FLUJO ALTERNATIVO: El CU 28 no se ejecuta con éxito
    public void mostrarCUNoSeEjecutoConExito() {
        JOptionPane.showMessageDialog(null, "El CU 28 Registrar acción no se ejecutó con éxito.", "Error de Ejecución", JOptionPane.ERROR_MESSAGE);
    }
}