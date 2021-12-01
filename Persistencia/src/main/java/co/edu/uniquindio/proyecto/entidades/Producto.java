package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Future;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Producto implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @Column(nullable = false,length = 30)
    private String nombre_producto; //usted en e inex está llamando la propiedad nombre, pero acá se llama es nombre_producto. Ojo con eso.

    @Positive
    @Column(nullable = false)
    private Integer unidades_producto;

    @Column(nullable = false)
    private String descripsion_producto;

    @Positive
    @Column(nullable = false)
    private Double precio_producto;

    @Future
    @Column(nullable = false)
    private LocalDateTime fecha_limite;

    @Column(nullable = false)
    private Integer descuento;

    @ToString.Exclude
    @OneToMany(mappedBy = "producto")
    private List<Comentario> comentarios;

    @ToString.Exclude
    @OneToMany(mappedBy = "producto")
    private List<Subasta> subastas;

    @ToString.Exclude
    @ElementCollection
    private List<Categoria> categorias;

    @ManyToMany(mappedBy = "productos")
    private List<Usuario> usuarios;

    @JoinColumn(nullable = true)
    @ManyToOne
    private Ciudad ciudad;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Usuario usuario;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> ruta;

    public Producto(String codigo, String nombre_producto, Integer unidades_producto, String descripsion_producto, Double precio_producto, LocalDateTime fecha_limite, Integer descuento, Usuario usuario) {
        this.codigo = codigo;
        this.nombre_producto = nombre_producto;
        this.unidades_producto = unidades_producto;
        this.descripsion_producto = descripsion_producto;
        this.precio_producto = precio_producto;
        this.fecha_limite = fecha_limite;
        this.descuento = descuento;
        this.usuario = usuario;
    }

    /**
     * Es importante la palabra get al inicio, por eso sale error en el index.
     * @return
     */
    public String getImagenPrincipal(){
        if(ruta!= null && !ruta.isEmpty()){
            return ruta.get(0);
        }
        return "default.png";
    }


}

