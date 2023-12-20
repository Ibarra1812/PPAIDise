package org.grupoppai;

import org.grupoppai.Controlador.GestorRtaOperador;
import org.grupoppai.Vista.PantallaRtaOperador;

public class Test {
    public static void main(String []args){
        GestorRtaOperador gestorRtaOperador = new GestorRtaOperador();
        PantallaRtaOperador pantallaRtaOperador = new PantallaRtaOperador(gestorRtaOperador);
        gestorRtaOperador.setPantalla(pantallaRtaOperador);
        gestorRtaOperador.nuevaRespuestaOperador();
    }
}
