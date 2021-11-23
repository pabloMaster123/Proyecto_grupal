package co.edu.uniquindio.proyecto.repositorios;
import co.edu.uniquindio.proyecto.dto.ProductoValido;
import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Subasta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SubastaRepo extends JpaRepository<Subasta,String>{

    @Query("select  c.nombre,count(c) from Subasta s left join s.producto.categorias c group by c")
    List<Object[]> obtenerProductoCategoria();

    @Query("select distinct c.nombre from Subasta s left join s.producto.categorias c where :fechaActual < s.fecha_limite")
    List<Object[]> listaCategoriasValidas(LocalDate fechaActual);

}
