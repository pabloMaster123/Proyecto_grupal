package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Map;

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
    private Double precio_producto;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Compra compra;

    public DetalleCompra(String codigo, Producto codigo_producto, Integer unidades, Double precio_producto, Compra compra) {
        this.codigo = codigo;
        this.codigo_producto = codigo_producto;
        this.unidades = unidades;
        this.precio_producto = precio_producto;
        this.compra = compra;
    }
}
