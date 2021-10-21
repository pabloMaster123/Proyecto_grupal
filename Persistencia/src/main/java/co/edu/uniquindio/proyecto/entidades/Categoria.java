package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Categoria implements Serializable {

    /*
     Clase Categoria
     Esta pose un codigo un nombre y una lista de productos
     El codigo tiene una longitud de 10 caracteres
     El nombre no se puede dejar en null y tiene una longitud de 50 caracteres
     La lista de productos tiene una relacion de ManyToMany
     */

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String codigo;

    @Column(nullable = false,length = 50)
    private String nombre;

    @ManyToMany
    private List<Producto> productos;

}
