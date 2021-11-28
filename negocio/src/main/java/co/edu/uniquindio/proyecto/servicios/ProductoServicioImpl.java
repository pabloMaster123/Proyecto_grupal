package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicioImpl implements ProductoServicio{

    @Autowired
    private ProductoRepo productoRepo;

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Override
    public Producto publicarProducto(Producto p) throws Exception {
        Optional<Producto> buscado = productoRepo.findById(p.getCodigo());
        if (buscado.isPresent()){
            throw new Exception("El codigo del producto ya existe");
        }

        return productoRepo.save(p);    }

    @Override
    public Producto modificarProducto(Producto p) throws Exception {
        Optional<Producto> buscado = productoRepo.findById(p.getCodigo());
        if (buscado.isPresent()){
            throw new Exception("El codigo del usuario no existe");
        }

        return productoRepo.save(p);
    }

    @Override
    public void eliminarProducto(String codigo) throws Exception {
        Optional<Producto> buscado = productoRepo.findById(codigo);
        if (buscado.isEmpty()){
            throw new Exception("El codigo del producto no existe");
        }

        productoRepo.deleteById(codigo);
    }

    @Override
    public Producto obtenerProducto(String codigo) throws Exception {
        Optional<Producto> buscado = productoRepo.findById(codigo);

        if (buscado.isEmpty()){
            throw new Exception("El codigo del producto no existe");
        }

        return  buscado.get();
    }

    @Override
    public List<Producto> listarProductos() {
        return productoRepo.findAll();
    }

    @Override
    public List<Object[]> listaProductosCategoria() {
       return null ;
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
    public List<Producto> BuscarProductos(String nombreProducto, String[] filtros) throws Exception {

        Optional<Producto> buscado = productoRepo.findByNombre_producto(nombreProducto);

        if (buscado.isEmpty()){
            throw new Exception("El codigo del producto no existe");
        }

        return null;
    }

    @Override
    public List<Object[]> listarProductosUsuario() throws Exception {
        return productoRepo.productosUsuario();
    }

}
