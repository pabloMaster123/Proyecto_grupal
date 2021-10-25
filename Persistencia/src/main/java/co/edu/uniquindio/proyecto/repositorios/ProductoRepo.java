package co.edu.uniquindio.proyecto.repositorios;
import co.edu.uniquindio.proyecto.entidades.Comentario;
import co.edu.uniquindio.proyecto.entidades.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProductoRepo extends JpaRepository<Producto,String>{

    Page<Producto> findAll(Pageable paginador);

    @Query("select p.usuario.nombre from Producto p where p.usuario= :id")
    String obtenerNombreVendedor(String id);

    @Query("select p.nombre_producto,c from Producto p left join p.comentarios c")
    List<Object[]> listaProductosYComentario();

}
