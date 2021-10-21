package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class DetalleSubasta implements Serializable {

    /*
     Clase DetalleSubasta
     Esta pose un codigo,un codigo subasta,un codigo usuario ,el valor y la fecha de la subasta
     Las variables listadas aqui no se pueden dejar en null
     */

    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Subasta codigo_subasta;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario codigo_usuario;

    @Column(nullable = false)
    private Integer valor;

    @Column(nullable = false)
    private LocalDate fecha_subasta;

}
