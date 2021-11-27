package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicioImpl implements ProductoServicio{


    @Override
    public Producto publicarProducto(Producto p) throws Exception {
        return null;
    }

    @Override
    public Producto modificarProducto(Producto p) throws Exception {
        return null;
    }

    @Override
    public void eliminarProducto(String codigo) throws Exception {

    }

    @Override
    public Producto obtenerProducto(String codigo) throws Exception {
        return null;
    }

    @Override
    public List<Producto> listaProductos(Categoria categoria) {
        return null;
    }

    @Override
    public void ComentarProducto(String mensaje, Integer calificacion, Usuario usuario, Producto producto) throws Exception {

    }

    @Override
    public void guardarProductoFavorito(Producto producto, Usuario usuario) throws Exception {

    }

    @Override
    public void eliminarProductoFavorito(Producto producto, Usuario usuario) throws Exception {

    }

    @Override
    public void comparProducto(Compra compra) throws Exception {

    }

    @Override
    public List<Producto> BuscarProductos(String nombreProducto, String[] filtros) {
        return null;
    }

    @Override
    public List<Producto> listarProductos(String CodigoUsuario) throws Exception {
        return null;
    }
}
