package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class ProductoServicioTest {

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    public void publicarProductoTest(){
        try {
            Usuario vendedor = usuarioServicio.obtenerUsuario("2");
            LocalDateTime tiempoFuturo = LocalDateTime.of(2021,11,30,23,59);
            Producto producto =
                    new Producto("123","Cuchillo",12,"Este producto corta",17000.0, tiempoFuturo,12,vendedor);
            Producto publicado = productoServicio.publicarProducto(producto);
            Assertions.assertNotNull(publicado);
        } catch (Exception e) {
            Assertions.assertTrue(false,e.getMessage());
        }
    }


    @Test
    public void eliminarTest() {
        try {
            Usuario vendedor = usuarioServicio.obtenerUsuario("2");
            LocalDateTime tiempoFuturo = LocalDateTime.of(2021,11,30,23,59);
            Producto producto = new Producto("123","Cuchillo",12,"Este producto corta",17000.0, tiempoFuturo,12,vendedor);
            productoServicio.publicarProducto(producto);

            productoServicio.eliminarProducto("123");
            Assertions.assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.assertTrue(false);
        }
    }


    @Test
    public void listarProductosTest() {
        List<Producto> lista = productoServicio.listarProductos();
        lista.forEach(System.out::println);
    }

    @Test
    public void actualizarProductoTest() {

        try {

            Producto producto = productoServicio.obtenerProducto("123");
            producto.setUnidades_producto(11);
            productoServicio.modificarProducto(producto);

            Producto productoModificado = productoServicio.obtenerProducto("123");
            Assertions.assertEquals(11, productoModificado.getUnidades_producto());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
