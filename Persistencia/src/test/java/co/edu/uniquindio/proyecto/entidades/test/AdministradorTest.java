package co.edu.uniquindio.proyecto.entidades.test;

import co.edu.uniquindio.proyecto.entidades.Administrador;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.AdministradorRepo;
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
public class AdministradorTest {
    @Autowired
    private AdministradorRepo administradorRepo;


    @Test
    @Sql("classpath:datos.sql")
    public void registrarTest() {

        List<Administrador> administradores = administradorRepo.findAll();
        administradores.forEach(p -> System.out.println(p));

    }

    @Test
    @Sql("classpath:datos.sql")
    public void actualizarTest() {
        Administrador administradorBuscar = administradorRepo.findById("123").orElse(null);

        administradorBuscar.setNombre("Juacho");

        administradorRepo.save(administradorBuscar);

        List<Administrador> lista = administradorRepo.findAll();

        lista.forEach(u -> System.out.println(u));
    }

    @Test
    @Sql("classpath:datos.sql")
    public void elimninarTest() {
        administradorRepo.deleteById("123");
        Assertions.assertNull( administradorRepo.findById("123").orElse(null));
    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarTest() {

        administradorRepo.findById("123").orElse(null);
        Assertions.assertEquals("santiago",  administradorRepo.findById("123").orElse(null).getNombre());
    }

    @Test
    @Sql("classpath:datos.sql")
    public void filtrarNombreTest(){
        List<Administrador> lista = administradorRepo.findAllByNombreContains("Santiago");
        lista.forEach(u -> System.out.println(u));
    }

    @Test
    @Sql("classpath:datos.sql")
    public void filtrarEmailTest(){
        Optional<Administrador> lista = administradorRepo.findByEmail("santiago@gmail.com");
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

        Page<Administrador> lista = administradorRepo.findAll(paginador);
        System.out.println(lista.stream().collect(Collectors.toList()));
    }

}
