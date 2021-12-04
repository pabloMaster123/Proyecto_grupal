package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
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
    @Length(min=9, max=9,message ="el codigo debe tener 9 caracteres")
    private String codigo;

    @Column(nullable = false)
    @Length(min=3, max=15,message ="el nombre debe tener entre 3 y 10 caracteres")
    @NotBlank
    private String nombre;

    @Column(nullable = false,unique = true,length = 150)
    @Length(min=10,max = 150,message = "el email debe tener entre 10 y 150 caracteres")
    @NotBlank
    @Email
    private String email;

    @Column(nullable = false)
    @NotBlank
    @Length(min=3, max=15,message ="el nombre de usuario debe tener entre 3 y 10 caracteres")
    private String username;

    @Column(nullable = false)
    @NotBlank
    @Length(min=5, max=15,message ="la contraseña  debe tener entre 5 y 10 caracteres")
    private String password;
}
