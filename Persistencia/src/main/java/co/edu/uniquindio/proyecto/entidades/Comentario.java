package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Comentario implements Serializable {

    /*
     Clase Comentario
     Esta pose un codigo,un codigo producto, un codigo usuario,Un mensaje, una respuesta  y una fecha de creacion
     Las variables listadas aqui no se pueden dejar en null
     */

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(nullable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private Usuario codigo_usuario;

    @Column(nullable = false)
    @NotBlank
    private  String mensaje;

    @Column(nullable = true)
    private String respuesta;

    @Column(nullable = false)
    private LocalDate fecha_comentario;

    @Column(nullable = true)
    @Positive
    private Integer calificacion;

    public Comentario(Producto producto, Usuario codigo_usuario, String mensaje, String respuesta, LocalDate fecha_comentario, Integer calificacion) {
        this.producto = producto;
        this.codigo_usuario = codigo_usuario;
        this.mensaje = mensaje;
        this.respuesta = respuesta;
        this.fecha_comentario = fecha_comentario;
        this.calificacion = calificacion;
    }
}
