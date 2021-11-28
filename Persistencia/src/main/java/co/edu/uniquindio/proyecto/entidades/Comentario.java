package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.persistence.ManyToOne;
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
    private  String mensaje;

    @Column(nullable = false)
    private String respuesta;

    @Column(nullable = false)
    private LocalDate fecha_comentario;

    @Column(nullable = true)
    private Integer calificacion;

}
