package co.edu.uniquindio.proyecto.entidades.test;

        import co.edu.uniquindio.proyecto.dto.ProductoValido;
        import co.edu.uniquindio.proyecto.entidades.Categoria;
        import co.edu.uniquindio.proyecto.entidades.Chat;
        import co.edu.uniquindio.proyecto.entidades.Subasta;
        import co.edu.uniquindio.proyecto.repositorios.SubastaRepo;
        import org.junit.jupiter.api.Assertions;
        import org.junit.jupiter.api.Test;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
        import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
        import org.springframework.test.context.jdbc.Sql;

        import java.time.LocalDate;
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

    @Test
    @Sql("classpath:datos.sql")
    public void productoCategoriaTest(){
        List<Object[]> categorias = subastaRepo.obtenerProductoCategoria();
        categorias.forEach(objects -> System.out.println(objects[0]+", "+objects[1]));
    }

    @Test
    @Sql("classpath:datos.sql")
    public void listarProductosValidos(){
        List<Object[]> respuesta = subastaRepo.listaCategoriasValidas(LocalDate.now());
        respuesta.forEach(objects -> System.out.println(objects[0]));
        Assertions.assertEquals(1,respuesta.size());
    }


}
