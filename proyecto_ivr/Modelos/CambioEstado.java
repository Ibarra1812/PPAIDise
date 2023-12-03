package Modelos;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CambioEstado {
    private LocalDateTime FechayHoraInicio;
    private Estado estado;

    public CambioEstado(LocalDateTime FechayHoraInicio, Estado estado) {
        this.FechayHoraInicio = FechayHoraInicio;
        this.estado = estado;
    }

    public LocalDateTime getFechayHoraInicio() {
        return FechayHoraInicio;
    }

    public Estado getEstado() {
        return estado;
    }
    
    
}
