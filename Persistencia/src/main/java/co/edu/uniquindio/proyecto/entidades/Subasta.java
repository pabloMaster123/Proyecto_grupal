package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Subasta implements Serializable {

      /*
     Clase Subasta
     Esta pose un codigo,un fecha limite,una producto y una lista de subastas
     Las variables listadas aqui no se pueden dejar en null
     La lista esta con la relacion OneToMany
     */

    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @Column(nullable = false)
    private LocalDate fecha_limite;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Producto producto;

    @ToString.Exclude
    @OneToMany
    private List<DetalleSubasta> detalleSubastas;

}
