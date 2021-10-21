package co.edu.uniquindio.proyecto.entidades.test;
import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.repositorios.CiudadRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)


public class CiudadTest {

    /*
     En este test
     se registran los datos
     se eliminan los datos
     se Actualizan los datos
     se buscan los datos
     */

    @Autowired
    private CiudadRepo ciudadRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void registrarTest() {

        List<Ciudad> ciudades = ciudadRepo.findAll();
        ciudades.forEach(c -> System.out.println(c));

    }
    @Test
    @Sql("classpath:datos.sql")
    public void eliminarTest() {
        Ciudad ciudad = ciudadRepo.findById("1").orElse(null);
        ciudadRepo.delete(ciudad);
        Ciudad ciudadBuscada = ciudadRepo.findById("1").orElse(null);
        Assertions.assertNull(ciudadBuscada);
    }

    @Test
    @Sql("classpath:datos.sql")
    public void actualizarTest() {
        Ciudad ciudad = ciudadRepo.findById("1").orElse(null);
        ciudad.setNombre("Riohacha");
        Ciudad ciudadBuscada = ciudadRepo.findById("1").orElse(null);
        System.out.println(ciudadBuscada.getNombre());
    }
    @Test
    @Sql("classpath:datos.sql")
    public void buscarTest() {

        ciudadRepo.findById("1").orElse(null);
        Assertions.assertEquals("1",  ciudadRepo.findById("1").orElse(null).getCodigo());
    }

}
