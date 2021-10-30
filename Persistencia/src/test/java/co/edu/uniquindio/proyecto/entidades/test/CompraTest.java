package co.edu.uniquindio.proyecto.entidades.test;

import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.Persona;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
//no funciona aun

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class CompraTest {
    /*
     En este test
     se registran los datos
     se eliminan los datos
     se Actualizan los datos
     se buscan los datos
     */

    @Autowired
    private CompraRepo compraRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void registrarTest() {
        List<Compra> compras = compraRepo.findAll();
        compras.forEach(c -> System.out.println(c));
    }

    @Test
    @Sql("classpath:datos.sql")
    public void eliminarTest() {
        Compra compra = compraRepo.findById("1").orElse(null);
        compraRepo.delete(compra);
        Compra compraBuscar = compraRepo.findById("1").orElse(null);
        Assertions.assertNull(compraBuscar);
    }

    @Test
    @Sql("classpath:datos.sql")
    public void actualizarTest() {
        Compra compra = compraRepo.findById("1").orElse(null);
        compra.setCodigo("1");
        Compra compraBuscar = compraRepo.findById("1").orElse(null);
        System.out.println(compraBuscar.getCodigo_usuario());
    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarTest() {
        Compra compraBuscar = compraRepo.findById("1").orElse(null);
        System.out.println(compraBuscar.getCodigo_usuario());
    }

    @Test
    @Sql("classpath:datos.sql")
    public void filtrarMedioPago(){
        Long TotalMedioPago = compraRepo.filtrarMediosDePago("Efectivo");
        System.out.println("El total de medios de pago es ---> " + TotalMedioPago);
    }

}
