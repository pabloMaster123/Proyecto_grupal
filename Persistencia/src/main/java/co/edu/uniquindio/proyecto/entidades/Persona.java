package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
@AllArgsConstructor
public class Persona implements Serializable {

     /*
     Clase Persona
     Esta pose un codigo,un nombre,una email y una password
     Las variables listadas aqui no se pueden dejar en null
     */

    @Id
    @EqualsAndHashCode.Include
    @NotBlank
    private String codigo;

    @Column(nullable = false)
    @NotBlank
    private String nombre;

    @Column(nullable = false,unique = true,length = 150)
    @Length(max = 150)
    @NotBlank
    private String email;

    @Column(nullable = false)
    @NotBlank
    private String username;

    @Column(nullable = false)
    @NotBlank
    private String password;
}
