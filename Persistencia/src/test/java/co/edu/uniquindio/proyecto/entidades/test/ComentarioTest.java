package co.edu.uniquindio.proyecto.entidades.test;

import co.edu.uniquindio.proyecto.entidades.Comentario;
import co.edu.uniquindio.proyecto.repositorios.ComentarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ComentarioTest {
    /*
     En este test
     se registran los datos
     se eliminan los datos
     se Actualizan los datos
     se buscan los datos
     */

    @Autowired
    private ComentarioRepo comentarioRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void registrarTest() {

        List<Comentario> comentarios = comentarioRepo.findAll();
        comentarios.forEach(c -> System.out.println(c));

    }

    @Test
    @Sql("classpath:datos.sql")
    public void eliminarTest() {
        Comentario comentario = comentarioRepo.findById("1").orElse(null);
        comentarioRepo.delete(comentario);
        Comentario comentarioBuscar = comentarioRepo.findById("1").orElse(null);
        Assertions.assertNull(comentarioBuscar);
    }

    @Test
    @Sql("classpath:datos.sql")
    public void actualizarTest() {
        Comentario comentario = comentarioRepo.findById("1").orElse(null);
        comentario.setMensaje("Cambio mensaje");
        Comentario comentarioBuscar = comentarioRepo.findById("1").orElse(null);
        System.out.println(comentarioBuscar.getMensaje());
    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarTest() {
        Comentario comentarioBuscar =comentarioRepo.findById("1").orElse(null);
        System.out.println(comentarioBuscar.getMensaje());
    }
}

