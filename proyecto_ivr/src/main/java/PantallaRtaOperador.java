import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

public class PantallaRtaOperador  extends JFrame{
    private GestorRtaOperador gestor;
    private JLabel lblNombreCliente;
    private JTextField txtNombreCliente;
    private JLabel lblCatOpSub;
    private JTextField txtCatOpSub;
    private JLabel lblValidacion;
    private JTextField txtRespuesta;
    private JLabel lblRespuesta;
    private JTextField txtDatoValidacion;
    private JButton btnConfirmacion;
    
    
    public void iniciarComponentes(){
        this.lblNombreCliente = new JLabel("Cliente: ");
        this.txtNombreCliente = new JTextField(25);
        this.lblCatOpSub = new JLabel("Descripcion: ");
        this.txtCatOpSub = new JTextField(50);
        this.lblValidacion = new JLabel("Dato a validar: ");
        this.txtDatoValidacion = new JTextField(25);
        this.lblRespuesta = new JLabel("Respuesta: ");
        this.txtRespuesta = new JTextField(25);
        this.btnConfirmacion = new JButton("Validar");
                
        
    }
    
    public void configurarDiseno(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // accion por defecto del boton cerrar
        setTitle("Respuesta operador"); // titulo

        JPanel panel = new JPanel();
        // revisar de haber importado java.awt.*
        panel.setLayout(new GridLayout(8, 10, 10, 10)); // disposicion de elementos

        // agregamos los componentes a la pantalla
        panel.add(lblNombreCliente);
        panel.add(txtNombreCliente);
        panel.add(lblCatOpSub);
        panel.add(txtCatOpSub);
        panel.add(lblValidacion);
        panel.add(txtDatoValidacion);
        panel.add(lblRespuesta);
        panel.add(txtRespuesta);
        panel.add(btnConfirmacion);

        add(panel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null); // centrar en la pantalla
        setResizable(false);
    }
    
    
     

    public PantallaRtaOperador(GestorRtaOperador gestor) {
        this.gestor = gestor;
        iniciarComponentes();
        configurarDiseno();
    }

  
    
    
    public void habilitarVentana(){
        this.setVisible(true);
        
    
    }
    
    
    
    public void mostrarDatosLlamadayValidaciones(){
    
    
    }
    public void tomarDatoValidacion(){}
    public void permitirIngresoRtaOperador(){}
    public void tomarIngresoRespuesta(){}
    public void tomarConfirmacion(){}
    public void informarAccionRequerida(){}

    
    
}
