package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

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
    private String codigo;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Producto codigo_producto;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario codigo_usuario;

    @Column(nullable = false)
    private  String mensaje;

    @Column(nullable = false)
    private String respuesta;

    @Column(nullable = false)
    private LocalDate fecha_comentario;

    @Column(nullable = false)
    private Integer calificacion;

}
