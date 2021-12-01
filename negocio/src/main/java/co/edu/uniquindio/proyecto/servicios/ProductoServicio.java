package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.*;

import java.util.List;
import java.util.Optional;

public interface ProductoServicio {

    Producto publicarProducto(Producto p) throws Exception;

    Producto modificarProducto(Producto p) throws Exception;

    void eliminarProducto(String codigo) throws Exception;

    Producto obtenerProducto(String codigo) throws Exception;

    List<Producto> listarProductos();

    List<Producto> listaProductosCategoria(Categoria categoria);

    List<Producto> listarProductoNombre(String nombre);

    void ComentarProducto(String mensaje, Integer calificacion, Usuario usuario, Producto producto) throws Exception;

    void Comentar(Comentario comentario) throws Exception;

    void guardarProductoFavorito(Producto producto, Usuario usuario) throws Exception;

    void eliminarProductoFavorito(Producto producto, Usuario usuario) throws Exception;

    List<Producto> BuscarProductos(String nombreProducto, Object [] filtros) throws Exception;

    List<Object[]> listarProductosUsuario() throws Exception;

    List<Categoria> listarCategorias();

    Categoria obtenerCategoria(String codigo) throws Exception;
}
