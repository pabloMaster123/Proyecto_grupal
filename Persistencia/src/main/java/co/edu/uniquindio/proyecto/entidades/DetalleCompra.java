package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class DetalleCompra implements Serializable {

      /*
     Clase DetalleCompra
     Esta pose un codigo,un codigo producto, unidades a comprar , el precio y el codigo de la compra
     Las variables listadas aqui no se pueden dejar en null
     */

    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Producto codigo_producto;

    @Column(nullable = false)
    private Integer unidades;

    @Column(nullable = false)
    private Integer precio_producto;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Compra compra;

}
