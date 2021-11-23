package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Usuario extends Persona implements Serializable {

    @ManyToOne
    private Ciudad cuidad;

    @OneToMany(mappedBy = "codigo_usuario")
    @ToString.Exclude
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "codigo_usuario")
    @ToString.Exclude
    private List<Compra>compras;

    @OneToMany(mappedBy = "codigo_usuario")
    @ToString.Exclude
    private List<DetalleSubasta> detalleSubastas;

    @OneToMany(mappedBy = "codigo_usuario")
    @ToString.Exclude
    private List<Chat> chats;

    @ManyToMany
    private List<Producto> productos;

    @ElementCollection
    private List<String> telefono;

    @Builder
    public Usuario(String codigo,String nombre,String email,String username,String pasword,Ciudad cuidad) {
        super(codigo,nombre,email,username,pasword);
        this.cuidad = cuidad;
    }


}
