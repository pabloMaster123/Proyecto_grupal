package co.edu.uniquindio.proyecto.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Usuario extends Persona implements Serializable {

    @ManyToOne
    @NotNull
    private Ciudad cuidad; //OJO con los nombres de las variables, debe usar las variables como se llaman en SU proyecto. NO en el mío.

    @OneToMany(mappedBy = "codigo_usuario")
    @ToString.Exclude
    @JsonIgnore
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "codigo_usuario")
    @ToString.Exclude
    @JsonIgnore
    private List<Compra>compras;

    @OneToMany(mappedBy = "codigo_usuario")
    @ToString.Exclude
    @JsonIgnore
    private List<DetalleSubasta> detalleSubastas;

    @OneToMany(mappedBy = "codigo_usuario")
    @ToString.Exclude
    @JsonIgnore
    private List<Chat> chats;



    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    @JsonIgnore
    private List<Producto> productos;

    @ManyToMany
    @ToString.Exclude
    @JsonIgnore
    private List<Producto> productosFavoritos;

    @ManyToMany
    @ToString.Exclude
    @JsonIgnore
    private List<Producto> productosCarrito;

    @ElementCollection
    private List<String> telefono;

    @Builder
    public Usuario(String codigo,String nombre,String email,String username,String pasword,Ciudad cuidad) {
        super(codigo,nombre,email,username,pasword);
        this.cuidad = cuidad;
    }


}
