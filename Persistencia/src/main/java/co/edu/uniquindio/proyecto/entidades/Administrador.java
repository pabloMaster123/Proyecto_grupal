package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Administrador extends Persona implements Serializable {

    /*
     Clase administrador
     Esta pose un string para obtener su codigo
     Este tiene una longitud de 10 caracteres
     */

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String codigo;

}
