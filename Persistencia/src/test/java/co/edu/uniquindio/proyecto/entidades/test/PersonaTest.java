package co.edu.uniquindio.proyecto.entidades.test;
import co.edu.uniquindio.proyecto.entidades.Chat;
import co.edu.uniquindio.proyecto.entidades.Persona;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.PersonaRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.jdbc.Sql;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Test
    @Sql("classpath:datos.sql")
    public void filtrarNombreTest(){
        List<Persona> lista = personaRepo.findAllByNombreContains("Santiago");
        lista.forEach(u -> System.out.println(u));
    }

    @Test
    @Sql("classpath:datos.sql")
    public void filtrarEmailTest(){
        Optional<Persona> lista = personaRepo.findByEmail("santiago@gmail.com");
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

        Page<Persona> lista = personaRepo.findAll(paginador);
        System.out.println(lista.stream().collect(Collectors.toList()));
    }

    @Test
    @Sql("classpath:datos.sql")
    public void listarUsuariosChatTest(){
        List<Chat> chats = personaRepo.listarChats("1");
        chats.forEach(System.out::println);
        Assertions.assertEquals(3,chats.size());
    }

}