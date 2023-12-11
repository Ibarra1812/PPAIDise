package Modelos;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CambioEstado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime FechayHoraInicio;
    @ManyToOne
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
