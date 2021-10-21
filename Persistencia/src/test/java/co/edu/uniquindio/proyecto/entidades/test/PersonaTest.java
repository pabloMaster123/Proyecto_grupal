package co.edu.uniquindio.proyecto.entidades.test;
import co.edu.uniquindio.proyecto.entidades.Persona;
import co.edu.uniquindio.proyecto.repositorios.PersonaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PersonaTest {
    /*
     En este test
     se registran los datos
     se eliminan los datos
     se Actualizan los datos
     se buscan los datos
     */

    @Autowired
    private PersonaRepo personaRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void registrarTest() {

        List<Persona> personas = personaRepo.findAll();
        personas.forEach(p -> System.out.println(p));

    }

    @Test
    @Sql("classpath:datos.sql")
    public void actualizarTest() {
        Persona clienteBuscado = personaRepo.findById("1").orElse(null);

        clienteBuscado.setNombre("Juancho");

        personaRepo.save(clienteBuscado);

        List<Persona> lista = personaRepo.findAll();

        lista.forEach(u -> System.out.println(u));
    }

    @Test
    @Sql("classpath:datos.sql")
    public void elimninarTest() {
        personaRepo.deleteById("1");
        Assertions.assertNull( personaRepo.findById("1").orElse(null));
    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarTest() {

        personaRepo.findById("1").orElse(null);
        Assertions.assertEquals("sebastian",  personaRepo.findById("1").orElse(null).getNombre());
    }


}