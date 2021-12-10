package co.edu.uniquindio.proyecto.entidades.test;
import co.edu.uniquindio.proyecto.entidades.Chat;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.ChatRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class ChatTest {
    /*
     En este test
     se registran los datos
     se eliminan los datos
     se Actualizan los datos
     se buscan los datos
     */

    @Autowired
    private ChatRepo chatRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void registrarTest() {

        List<Chat> chats = chatRepo.findAll();
        chats.forEach(c -> System.out.println(c));

    }

    @Test
    @Sql("classpath:datos.sql")
    public void eliminarTest() {
        Chat chat = chatRepo.findByCodigo(1).orElse(null);
        chatRepo.delete(chat);
        Chat chatAux = chatRepo.findByCodigo(1).orElse(null);
        Assertions.assertNull(chatAux);
    }

    @Test
    @Sql("classpath:datos.sql")
    public void actualizarTest() {
        Chat chatAux = chatRepo.findByCodigo(1).orElse(null);
        if (chatAux == null)
        { System.out.println("No existe chat con el codigo 97");}
        Chat chat = chatRepo.findByCodigo(1).orElse(null);
        chat.setCodigo(97);
        Chat chatAux2 = chatRepo.findByCodigo(97).orElse(null);
        if (chatAux2 != null) { System.out.println("Si existe un chat con el codigo 97");}
        Assertions.assertNull(chatAux2);
    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarTest() {

        chatRepo.findByCodigo(1).orElse(null);
        Assertions.assertEquals("1",  chatRepo.findByCodigo(1).orElse(null).getCodigo());
    }




}
