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
    private final GestorRtaOperador gestor;
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

    // CONSTRUCTOR
    public PantallaRtaOperador(GestorRtaOperador gestorRtaOperador){

        this.gestor = gestorRtaOperador;

        respuestaOperadorTxt.setEnabled(false);
        guardarButton.setEnabled(false);

        nombreClienteTxt.setEnabled(false);
        categoriaTxt.setEnabled(false);
        opcionTxt.setEnabled(false);
        subopcionTxt.setEnabled(false);

        validarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tomarIngresoDatoValidacion();
                //System.out.println("Los datos ingresados son correctos");
            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tomarRespuestaOperador();
            }

        });
        validacionCombo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tomarIngresoDatoValidacion();
            }
        });
    }
    public void habilitarVentana(){
        JFrame frame = new JFrame("PPAI");
        frame.setContentPane(pantallaJPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //Metodo encargado de mostrar en pantalla los datos de la llamas y validaciones
    public void mostrarDatosLlamadaYValidaciones(List<String> validaciones,
                                                 String cliente,
                                                 List<String> datosCategoriaOpcionSubopcion){
        this.habilitarVentana();
        this.nombreClienteTxt.setText(cliente);
        this.categoriaTxt.setText(datosCategoriaOpcionSubopcion.get(0));
        this.opcionTxt.setText(datosCategoriaOpcionSubopcion.get(1));
        this.subopcionTxt.setText(datosCategoriaOpcionSubopcion.get(2));


        // Carga de Validaciones en los Combos
        for (String validacion : validaciones) {
            //agrega el nombre de la validacion al combo.
            validacionCombo.addItem(validacion);
        }

    }

    //Metodo encargado de tomar el ingreso del dato de validacion.
    public void tomarIngresoDatoValidacion(){
        this.gestor.tomarDatoValidacion( validacionCombo.getSelectedIndex(), datoAValidarTxt.getText());
    }

    //Metodo encargado de permitir el ingreso de una respuesta por parte del operador.
    public void permitirIngresoDatoOperador(){
        //Habilita el campo de respuesta.
        respuestaOperadorTxt.setEnabled(true);
        guardarButton.setEnabled(true);

        // Deshabilita los campos de validación y dato a validar
        validacionCombo.setEnabled(false);
        datoAValidarTxt.setEnabled(false);
        validarButton.setEnabled(false);
    }

    //Metodo encargado de tomar la respuesta del operador.
    public void tomarRespuestaOperador() {
        this.gestor.tomarRtaOperador(respuestaOperadorTxt.getText());
    }


    //Metodo encargado de solicitar la confirmacion.
    public void solicitarConfirmacion() {
        //Creamos una variables respuesta, que despliega una ventana con la confirmacion del CU.
        int respuestaConfirmacion = JOptionPane.showConfirmDialog(this, "¿Deseas guardar los cambios?", "Confirmar", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);

        if (respuestaConfirmacion == JOptionPane.YES_OPTION) {
            tomarConfirmacion(respuestaConfirmacion);
        }
    }

    // Metodo encargado de tomar la confirmación en pantalla.
    public void tomarConfirmacion (int respuestaConfirmacion) {
        gestor.confirmar();
    }

    // Es un mensaje para informar si la accion se realizo, cuando recibimos el resultado del caso de uso
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