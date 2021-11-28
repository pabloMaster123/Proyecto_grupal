package co.edu.uniquindio.proyecto.repositorios;
import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepo extends JpaRepository<Producto,String>{

    Page<Producto> findAll(Pageable paginador);

    @Query("select p.usuario.nombre from Producto p where p.usuario= :id")
    String obtenerNombreVendedor(String id);

    @Query("select distinct p.usuario from Producto p group by p.usuario")
    List<Object[]> productosUsuario();

    @Query("select p.nombre_producto,c from Producto p left join p.comentarios c")
    List<Object[]> listaProductosYComentario();

    @Query("select distinct c.codigo_usuario from Producto p join  p.comentarios c where p.codigo= :id")
    List<Usuario> listarUsariosComentarios(String id);

    @Query("select p from Producto p where p.nombre_producto = :nombreProducto")
    Optional<Producto> findByNombreProducto(String nombreProducto);

    @Query("select cp.productos from Producto p, p.categorias cp where cp.codigo = :codigoCategoria")
    List<Producto> listarProductoPorCategoria(String codigoCategoria);

//    @Query("select new co.edu.uniquindio.proyecto.dto.ProductoValido(p.nombre_producto,p.descripsion_producto,p.precio_producto,p.cuidad) from Producto p where  :fechaActual < p.fecha_limite")
//    List<ProductoValido> listarProductosValidos(LocalDate fechaActual);

//    @Query("select p from Producto p left join p.categorias")
//    List<Object[]> listaCategoria();


}
