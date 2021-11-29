package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.CategoriaRepo;
import co.edu.uniquindio.proyecto.repositorios.ComentarioRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicioImpl implements ProductoServicio{

    @Autowired
    private ProductoRepo productoRepo;

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private ComentarioRepo comentarioRepo;

    @Autowired
    private CategoriaRepo categoriaRepo;

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
    public List<Producto> listaProductosCategoria() {
       return null ;
    }

    @Override
    public void ComentarProducto(String mensaje, Integer calificacion, Usuario usuario, Producto producto) throws Exception {
        Optional<Producto> buscado = productoRepo.findById(producto.getCodigo());

        if (buscado.isEmpty()) {
            throw new Exception("No existe producto con el codigo ingresado.");
        }

        if (mensaje.equals(null) || mensaje.equals("")) {
            throw new Exception("No existe mensaje para comentar.");
        }

        Producto aux = productoRepo.getById(producto.getCodigo());

        Comentario comentario = new Comentario(aux, usuario, mensaje, null, LocalDate.now(), calificacion);

        aux.getComentarios().add(comentario);

        comentarioRepo.save(comentario);

        productoRepo.save(aux);
    }

    @Override
    public void guardarProductoFavorito(Producto producto, Usuario usuario) throws Exception {
        Optional<Producto> buscado = productoRepo.findById(producto.getCodigo());
        if (buscado.isEmpty()) {
            throw new Exception("El codigo del producto a añadir no esta registrado en la base de datos.");
        }
        Producto aux = productoRepo.getById(producto.getCodigo());
        Usuario aux2 = usuarioRepo.getById(usuario.getCodigo());
        aux2.getProductosFavoritos().add(aux);
        productoRepo.save(aux);
        usuarioRepo.save(aux2);
    }

    @Override
    public void eliminarProductoFavorito(Producto producto, Usuario usuario) throws Exception {
        Optional<Producto> buscado = productoRepo.findById(producto.getCodigo());
        if (buscado.isEmpty()) {
            throw new Exception("El codigo del producto a eliminar no esta registrado en la base de datos.");
        }
        Producto aux = productoRepo.getById(producto.getCodigo());
        Usuario aux2 = usuarioRepo.getById(usuario.getCodigo());
        aux2.getProductosFavoritos().remove(aux);
        productoRepo.delete(aux);
        usuarioRepo.save(aux2);
    }


    @Override
        public List<Producto> BuscarProductos(String nombreProducto, Object[] filtros) throws Exception {

            Categoria categoria = (Categoria) filtros[0];
            Double precio = (Double) filtros[1];
            Ciudad ciudad = (Ciudad) filtros[2];
            Integer calificacion = (Integer) filtros[3];

      //  Optional<Producto> buscado = productoRepo.findByNombre(nombreProducto, categoria, precio, ciudad, calificacion);

//        if (buscado.isEmpty()){
//            throw new Exception("El codigo del producto no existe");
//        }

        return null;
    }

    @Override
    public List<Object[]> listarProductosUsuario() throws Exception {
        return productoRepo.productosUsuario();
    }

}
