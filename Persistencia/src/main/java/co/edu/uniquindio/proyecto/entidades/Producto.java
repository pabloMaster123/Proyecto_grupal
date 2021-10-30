package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.time.LocalDate;
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
    private String nombre_producto;

    @Column(nullable = false)
    private Integer unidades_producto;

    @Column(nullable = false)
    private String descripsion_producto;

    @Column(nullable = false)
    private Integer precio_producto;

    @Column(nullable = false)
    private LocalDate fecha_limite;

    @Column(nullable = false)
    private Integer descuento;

    @ToString.Exclude
    @OneToMany(mappedBy = "producto")
    private List<Comentario> comentarios;

    @ToString.Exclude
    @OneToMany(mappedBy = "producto")
    private List<Subasta> subastas;

    @ToString.Exclude
    @ManyToMany(mappedBy = "productos")
    private List<Categoria> categorias;

    @ManyToMany(mappedBy = "productos")
    private List<Usuario> usuarios;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Ciudad cuidad;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Usuario usuario;

    @ElementCollection
    private List<String> ruta;
}

