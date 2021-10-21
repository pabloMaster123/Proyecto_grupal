package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Mensaje implements Serializable {

      /*
     Clase Mensaje
     Esta pose un codigo,un mensaje,una fecha y el codigo de los chats
     Las variables listadas aqui no se pueden dejar en null
     */

    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @Column(nullable = false)
    private String mensaje;

    @Column(nullable = false)
    private LocalDate fecha;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(nullable = false)
    private Chat chats;

}
