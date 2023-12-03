import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CambioEstado {
    private String fechayHora;
    private Estado estado;

    public CambioEstado(String fechayHora, Estado estado) {
        this.fechayHora = fechayHora;
        this.estado = estado;
    }

    public String getFechayHora() {
        return fechayHora;
    }
    
    
}
