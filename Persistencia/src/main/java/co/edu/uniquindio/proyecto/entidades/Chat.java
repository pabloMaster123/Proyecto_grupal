package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Chat implements Serializable {

    /*
     Clase Chat
     Esta pose un codigo,un codigo de usuario, un codigo de producto y una lista de mensajes
     El codigo de usuario y el del producto no se puede dejar en null
     La lista de mensajes  tiene una relacion de OneToMany con un mappedBy de nombre chats
     */

    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Usuario codigo_usuario;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Producto producto;

    @OneToMany(mappedBy = "chats")
    private List<Mensaje> mensajes;


}
