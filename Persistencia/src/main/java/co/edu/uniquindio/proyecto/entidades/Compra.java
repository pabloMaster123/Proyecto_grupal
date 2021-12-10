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
public class Compra implements Serializable {

        /*
     Clase Compra
     Esta pose un codigo,un codigo de usuario, un fecha de compra y una lista de detalles de compra
     El codigo tanto de la compra como del usuario y la fecha de compra no se pueden dejar en null
     La lista de detalles de compra  tiene una relacion de OneToMany con un mappedBy de nombre compra
     */

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue

    private String codigo;

    @JoinColumn(nullable = false)
    @ManyToOne
    @ToString.Exclude
    private Usuario codigo_usuario;

    @Column(nullable = false)
    private String medioPago;

    @Column(nullable = false)
    private LocalDate fecha_compra;

    @OneToMany(mappedBy = "compra")
    @ToString.Exclude
    private List<DetalleCompra> detalleCompras;


    public Compra(Usuario codigo_usuario, String medioPago, LocalDate fecha_compra) {
        this.codigo_usuario = codigo_usuario;
        this.medioPago = medioPago;
        this.fecha_compra = fecha_compra;
    }
}
