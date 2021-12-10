package co.edu.uniquindio.proyecto.repositorios;
import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
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

    @Query("select distinct p.usuario from Producto p group by p.usuario")
    List<Object[]> productosUsuario();

    @Query("select p.nombre_producto,c from Producto p left join p.comentarios c")
    List<Object[]> listaProductosYComentario();

    @Query("select distinct c.codigo_usuario from Producto p join  p.comentarios c where p.codigo= :id")
    List<Usuario> listarUsariosComentarios(String id);

    @Query("select p from Producto p where p.nombre_producto like concat('%' , :nombre, '%') ")
    List<Producto> listarProductoNombre(String nombre);

    @Query("select p from Producto p where :categoria member of p.categorias")
    List<Producto> listarProductoCategoria(Categoria categoria);

    @Query("select p from Producto p where p.precio_producto >= :precioMin and p.precio_producto <= :precioMax")
    List<Producto> listarProductoRangoDePrecio(Double precioMin, Double precioMax);

    @Query("select p from Producto p where p.ciudad = :ciudad")
    List<Producto> listarProductoPorCiudad(Ciudad ciudad);

    @Query("select p.unidades_producto from Producto p where p.codigo = :id")
    Integer devolverCantidadDeUnidadesPorId(String id);

    @Query("select p.descuento from Producto p where p.codigo = :id")
    Integer devolverDescuentoPorId(String id);


//    @Query("select p from Producto p, p.categorias cp where p.nombre_producto = :nombreProducto and cp = :categoria")
//    Optional<Producto> findByNombreProductoConCategoria(String nombreProducto, Categoria categoria);

//    @Query("select p from Producto p where p.nombre_producto = :nombreProducto and p.precio_producto = :precio")
//    Optional<Producto> findByNombreProductoConPrecio(String nombreProducto, Double precio);
//
//    @Query("select p from Producto p where p.nombre_producto = :nombreProducto and p.ciudad = :ciudad")
//    Optional<Producto> findByNombreProductoConCiudad(String nombreProducto, Ciudad ciudad);

//    @Query("select p from Producto p, p.comentarios pc where p.nombre_producto = :nombreProducto and pc.calificacion = :calificacion")
//    Optional<Producto> findByNombreProductoConCalificacion(String nombreProducto, Integer calificacion);

//    @Query("select p from Producto p, p.categorias cp where cp.codigo = :codigoCategoria and p.unidades_producto > 0")
//    List<Producto> listarProductoPorCategoria(String codigoCategoria);

//    @Query("select new co.edu.uniquindio.proyecto.dto.ProductoValido(p.nombre_producto,p.descripsion_producto,p.precio_producto,p.cuidad) from Producto p where  :fechaActual < p.fecha_limite")
//    List<ProductoValido> listarProductosValidos(LocalDate fechaActual);

//    @Query("select p from Producto p left join p.categorias")
//    List<Object[]> listaCategoria();


}
