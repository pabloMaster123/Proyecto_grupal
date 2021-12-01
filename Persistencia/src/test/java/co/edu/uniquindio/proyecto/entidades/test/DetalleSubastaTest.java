package co.edu.uniquindio.proyecto.entidades.test;

import co.edu.uniquindio.proyecto.entidades.DetalleSubasta;
import co.edu.uniquindio.proyecto.repositorios.DetalleSubastaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DetalleSubastaTest {

    /*
     En este test
     se registran los datos
     se eliminan los datos
     se Actualizan los datos
     se buscan los datos
     */

    @Autowired
    private DetalleSubastaRepo detalleSubastaRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void registrarTest() {

        List<DetalleSubasta> detalles = detalleSubastaRepo.findAll();
        detalles.forEach(c -> System.out.println(c));

    }


    @Test
    @Sql("classpath:datos.sql")
    public void eliminarTest() {
        DetalleSubasta categoria = detalleSubastaRepo.findById("1").orElse(null);
        detalleSubastaRepo.delete(categoria);
        DetalleSubasta categoriaBuscada = detalleSubastaRepo.findById("1").orElse(null);
        Assertions.assertNull(categoriaBuscada);
    }

    @Test
    @Sql("classpath:datos.sql")
    public void actualizarTest() {
        DetalleSubasta detalle = detalleSubastaRepo.findById("1").orElse(null);
        detalle.setCodigo("1");
        DetalleSubasta detalleBuscada = detalleSubastaRepo.findById("1").orElse(null);
        System.out.println(detalleBuscada.getCodigo());
    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarTest() {

        detalleSubastaRepo.findById("1").orElse(null);
        Assertions.assertEquals("1",  detalleSubastaRepo.findById("1").orElse(null).getCodigo());
    }


}