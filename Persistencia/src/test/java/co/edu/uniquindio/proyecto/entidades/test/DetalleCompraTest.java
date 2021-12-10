package co.edu.uniquindio.proyecto.entidades.test;

import co.edu.uniquindio.proyecto.entidades.DetalleCompra;
import co.edu.uniquindio.proyecto.repositorios.DetalleCompraRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DetalleCompraTest {

    /*
     En este test
     se registran los datos
     se eliminan los datos
     se Actualizan los datos
     se buscan los datos
     */

    @Autowired
    private DetalleCompraRepo detalleCompraRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void registrarTest() {

        List<DetalleCompra> detalles = detalleCompraRepo.findAll();
        detalles.forEach(c -> System.out.println(c));

    }

    @Test
    @Sql("classpath:datos.sql")
    public void eliminarTest() {
        DetalleCompra detalleCompra = detalleCompraRepo.findById("1").orElse(null);
        detalleCompraRepo.delete(detalleCompra);
        DetalleCompra detalleCompraBuscar = detalleCompraRepo.findById("1").orElse(null);
        Assertions.assertNull(detalleCompraBuscar);
    }

    @Test
    @Sql("classpath:datos.sql")
    public void actualizarTest() {
        DetalleCompra detalleCompra = detalleCompraRepo.findById("1").orElse(null);
        detalleCompra.setPrecio_producto(189900.0);
        DetalleCompra detalleCompraBuscar = detalleCompraRepo.findById("1").orElse(null);
        System.out.println(detalleCompraBuscar.getPrecio_producto());
    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarTest() {

        detalleCompraRepo.findById("1").orElse(null);
        Assertions.assertEquals("1",  detalleCompraRepo.findById("1").orElse(null).getCodigo());
    }
}
