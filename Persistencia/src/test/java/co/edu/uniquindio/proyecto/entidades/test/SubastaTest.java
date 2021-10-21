package co.edu.uniquindio.proyecto.entidades.test;

        import co.edu.uniquindio.proyecto.entidades.Subasta;
        import co.edu.uniquindio.proyecto.repositorios.SubastaRepo;
        import org.junit.jupiter.api.Assertions;
        import org.junit.jupiter.api.Test;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
        import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
        import org.springframework.test.context.jdbc.Sql;
        import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SubastaTest {
    /*
     En este test
     se registran los datos
     se eliminan los datos
     se Actualizan los datos
     se buscan los datos
     */

    @Autowired
    private SubastaRepo subastaRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void registrarTest() {
        List<Subasta> subastas = subastaRepo.findAll();
        subastas.forEach(p -> System.out.println(p));
    }

    @Test
    @Sql("classpath:datos.sql")
    public void eliminarTest() {
        Subasta subasta = subastaRepo.findById("1").orElse(null);
        subastaRepo.delete(subasta);
        Subasta productoBuscar = subastaRepo.findById("1").orElse(null);
        Assertions.assertNull(productoBuscar);
    }

    @Test
    @Sql("classpath:datos.sql")
    public void actualizarTest() {
        Subasta subasta = subastaRepo.findById("1").orElse(null);
        subasta.setCodigo("1");
        Subasta subastaBuscar = subastaRepo.findById("1").orElse(null);
        System.out.println(subastaBuscar.getCodigo());
    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarTest() {

        subastaRepo.findById("1").orElse(null);
        Assertions.assertEquals("1",  subastaRepo.findById("1").orElse(null).getCodigo());
    }

}
