package co.edu.uniquindio.proyecto.entidades.test;

import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {

    @Autowired
    private UsuarioRepo usuarioRepo;


    @Test
    @Sql("classpath:datos.sql")
    public void registrarTest() {

        List<Usuario> usuarios = usuarioRepo.findAll();
        usuarios.forEach(p -> System.out.println(p));

    }

    @Test
    @Sql("classpath:datos.sql")
    public void actualizarTest() {
        Usuario usuarioBuscar = usuarioRepo.findById("1").orElse(null);

        usuarioBuscar.setNombre("Juancho");

        usuarioRepo.save(usuarioBuscar);

        List<Usuario> lista = usuarioRepo.findAll();

        lista.forEach(u -> System.out.println(u));
    }

    @Test
    @Sql("classpath:datos.sql")
    public void elimninarTest() {
        usuarioRepo.deleteById("1");
        Assertions.assertNull( usuarioRepo.findById("1").orElse(null));
    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarTest() {

        usuarioRepo.findById("1").orElse(null);
        Assertions.assertEquals("sebastian",  usuarioRepo.findById("1").orElse(null).getNombre());
    }

    @Test
    @Sql("classpath:datos.sql")
    public void filtrarNombreTest(){
        List<Usuario> lista = usuarioRepo.findAllByNombreContains("Santiago");
        lista.forEach(u -> System.out.println(u));
    }

    @Test
    @Sql("classpath:datos.sql")
    public void filtrarEmailTest(){
        Optional<Usuario> lista = usuarioRepo.findByEmail("santiago@gmail.com");
        if (lista.isPresent()){
            System.out.println(lista);
        }else{
            System.out.println("No existe el correo");
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void paginarListaTest(){

        Pageable paginador = PageRequest.of(1,2);

        Page<Usuario> lista = usuarioRepo.findAll(paginador);
        System.out.println(lista.stream().collect(Collectors.toList()));
    }
}
