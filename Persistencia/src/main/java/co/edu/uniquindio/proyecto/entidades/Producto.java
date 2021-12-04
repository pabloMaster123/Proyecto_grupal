package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
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
    @NotBlank
    private String codigo;
    @Length(min=1, max=5,message ="el codigo debe tener entre 1 y 5 caracteres")


    @Column(nullable = false,length = 30)
    @NotBlank
    @Length(min=3, max=15,message ="el nombre debe tener entre 3 y 15 caracteres")
    private String nombre_producto; //usted en e inex está llamando la propiedad nombre, pero acá se llama es nombre_producto. Ojo con eso.

    @Column(nullable = false)
    @Positive
    private Integer unidades_producto;

    @Column(nullable = false)
    @NotBlank(message = "debe contener una descripcion")
    private String descripsion_producto;

    @Positive(message = "debe ser un numero positivo")
    @Column(nullable = false)
    private Double precio_producto;

    @Future
    @Column(nullable = false)
    private LocalDateTime fecha_limite;

    @Column(nullable = false)
    @Positive
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

    @ManyToMany
    private List<Usuario> usuarios;

    @JoinColumn(nullable = false)
    @ManyToOne
    @NotNull
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
    @NotNull
    public String getImagenPrincipal(){
        if(ruta!= null && !ruta.isEmpty()){
            return ruta.get(0);
        }
        return "default.png";
    }


}

