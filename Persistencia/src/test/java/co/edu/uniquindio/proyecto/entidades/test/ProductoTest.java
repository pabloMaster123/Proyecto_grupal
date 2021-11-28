package co.edu.uniquindio.proyecto.entidades.test;
import co.edu.uniquindio.proyecto.dto.ProductoValido;
import co.edu.uniquindio.proyecto.entidades.Persona;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
        Assertions.assertEquals("1",  productoRepo.findById("1").orElse(null).getCodigo());
    }

    @Test
    @Sql("classpath:datos.sql")
    public void paginadorProducto(){
        Pageable paginador = PageRequest.of(0,2);

        Page<Producto> lista = productoRepo.findAll(paginador);
        System.out.println(lista.stream().collect(Collectors.toList()));
    }

    @Test
    @Sql("classpath:datos.sql")
    public void listarProductosYComentarios(){
        List<Object[]> respuesta = productoRepo.listaProductosYComentario();
        respuesta.forEach(objects -> System.out.println(objects[0] + " --- " + objects[1]));
        Assertions.assertEquals(4,respuesta.size());
    }

    @Test
    @Sql("classpath:datos.sql")
    public void listarUsuarioComentarioTest(){
        List<Usuario> usuarios = productoRepo.listarUsariosComentarios("1");
        usuarios.forEach(System.out::println);
        Assertions.assertEquals(2,usuarios.size());
    }

//    @Test
//    @Sql("classpath:datos.sql")
//    public void listarProductosValidos(){
//        List<ProductoValido> productos = productoRepo.listarProductosValidos(LocalDate.now());
//        productos.forEach(System.out::println);
//    }

}
