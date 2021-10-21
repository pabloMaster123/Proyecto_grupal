package co.edu.uniquindio.proyecto.entidades.test;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class ProductoTest {

    /*
     En este test
     se registran los datos
     se eliminan los datos
     se Actualizan los datos
     se buscan los datos
     */

    @Autowired
    private ProductoRepo productoRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void registrarTest() {
        List<Producto> productos = productoRepo.findAll();
        productos.forEach(c -> System.out.println(c));
    }

    @Test
    @Sql("classpath:datos.sql")
    public void eliminarTest() {
        Producto producto = productoRepo.findById("1").orElse(null);
        productoRepo.delete(producto);
        Producto productoBuscar = productoRepo.findById("1").orElse(null);
        Assertions.assertNull(productoBuscar);
    }

    @Test
    @Sql("classpath:datos.sql")
    public void actualizarTest() {
        Producto producto = productoRepo.findById("1").orElse(null);
        producto.setNombre_producto("juguete");
        Producto productoBuscar = productoRepo.findById("1").orElse(null);
        System.out.println(productoBuscar.getNombre_producto());
    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarTest() {

        productoRepo.findById("1").orElse(null);
        Assertions.assertEquals("1",  productoRepo.findById("1").orElse(null).getCodigo_producto());
    }

}
