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

    public List<Producto> listarPorCategoria(String categoria);

    public List<Producto> listarPorRangoDePrecio(String rango) throws Exception;

    public List<Producto> listarPorLugar(String ciudad) throws Exception;

    public Integer devolverCantidadDeUnidadesPorId(String id) throws Exception;

    public Integer devolverDescuentoPorId(String id) throws Exception;

    public Compra realizarCompra(Usuario usuario, Producto producto, String medioPago, Integer unidades) throws Exception;
}
