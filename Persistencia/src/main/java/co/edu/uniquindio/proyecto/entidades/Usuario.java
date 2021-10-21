package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario extends Persona implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Ciudad cuidad;

    @OneToMany(mappedBy = "codigo_usuario")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "codigo_usuario")
    private List<Compra>compras;

    @OneToMany(mappedBy = "codigo_usuario")
    private List<DetalleSubasta> detalleSubastas;

    @OneToMany(mappedBy = "codigo_usuario")
    private List<Chat> chats;

    @ManyToMany
    private List<Producto> productos;

    @ElementCollection
    private List<String> telefono;

}
