package Modelos;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int idEstado;
    private String nombre;

    public Estado( String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Metodo booleano para comprar si el estado obtenido es "En Curso".
    public boolean esEnCurso(Estado estado){
        return "EnCurso".equals(estado.getNombre());
    }

    //Metodo booleano para comprar si el estado obtenido es "Finalizada".
    public boolean esFinalizado(Estado estadoComparacion) {
        return "Finalizada".equals(estadoComparacion.getNombre());
    }
    
    //Metodo booleano para comprar si el estado obtenido es "Cancelada".
    public boolean esCancelado(Estado estadoComparacion){
        return "Cancelada".equals(estadoComparacion.getNombre());
    }
    
    
}
