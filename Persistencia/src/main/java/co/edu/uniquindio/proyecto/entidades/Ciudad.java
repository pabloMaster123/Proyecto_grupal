package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Ciudad implements Serializable {

    /*
     Clase Ciudad
     Esta pose un codigo,un nombre y una lista de usuarios
     El codigo y el nombre no se puede dejar en null
     La lista de usuarios  tiene una relacion de OneToMany con un mappedBy de nombre cuidad
     */

    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "cuidad")
    @ToString.Exclude
    private List<Usuario> usuaios;

}
