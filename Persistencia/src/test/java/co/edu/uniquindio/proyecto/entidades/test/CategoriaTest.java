package co.edu.uniquindio.proyecto.entidades.test;
import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.repositorios.CategoriaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class CategoriaTest {

    /*
     En este test
     se registran los datos
     se eliminan los datos
     se Actualizan los datos
     se buscan los datos
     */

    @Autowired
    private CategoriaRepo categoriaRepo;
    @Test
    @Sql("classpath:datos.sql")
    public void registrarTest() {

        List<Categoria> categorias = categoriaRepo.findAll();
        categorias.forEach(c -> System.out.println(c));
    }

    @Test
    @Sql("classpath:datos.sql")
    public void eliminarTest() {
        Categoria categoria = categoriaRepo.findById("1").orElse(null);
        categoriaRepo.delete(categoria);
        Categoria categoriaBuscada = categoriaRepo.findById("1").orElse(null);
        Assertions.assertNull(categoriaBuscada);
    }

    @Test
    @Sql("classpath:datos.sql")
    public void actualizarTest() {
        Categoria categoria = categoriaRepo.findById("1").orElse(null);
        categoria.setNombre("juguetes");
        Categoria categoriaBuscada = categoriaRepo.findById("1").orElse(null);
        System.out.println(categoriaBuscada.getNombre());
    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarTest() {

        categoriaRepo.findById("1").orElse(null);
        Assertions.assertEquals("1",  categoriaRepo.findById("1").orElse(null).getCodigo());
    }
}