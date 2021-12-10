package co.edu.uniquindio.proyecto.entidades.test;
import co.edu.uniquindio.proyecto.entidades.Mensaje;
import co.edu.uniquindio.proyecto.repositorios.MensajeRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MensajeTest {

    /*
     En este test
     se registran los datos
     se eliminan los datos
     se Actualizan los datos
     se buscan los datos
     */

    @Autowired
    private MensajeRepo mensajeRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void registrarTest() {

        List<Mensaje> mensajes = mensajeRepo.findAll();
        mensajes.forEach(c -> System.out.println(c));

    }

    @Test
    @Sql("classpath:datos.sql")
    public void eliminarTest() {
        Mensaje mensaje = mensajeRepo.findByCodigo(1).orElse(null);
        mensajeRepo.delete(mensaje);
        Mensaje mensajeBuscar = mensajeRepo.findByCodigo(1).orElse(null);
        Assertions.assertNull(mensajeBuscar);
    }

    @Test
    @Sql("classpath:datos.sql")
    public void actualizarTest() {
        Mensaje mensaje = mensajeRepo.findByCodigo(1).orElse(null);
        mensaje.setMensaje("Cambio mensaje");
        Mensaje mensajeBuscar = mensajeRepo.findByCodigo(1).orElse(null);
        System.out.println(mensajeBuscar.getMensaje());
    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarTest() {

        mensajeRepo.findByCodigo(1).orElse(null);
        Assertions.assertEquals("1",  mensajeRepo.findByCodigo(1).orElse(null).getCodigo());
    }


}
