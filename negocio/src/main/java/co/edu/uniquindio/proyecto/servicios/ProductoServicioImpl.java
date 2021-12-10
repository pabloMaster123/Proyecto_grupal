package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
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
    private CiudadRepo ciudadRepo;

    @Autowired
    private CompraRepo compraRepo;

    @Autowired
    private DetalleCompraRepo detalleCompraRepo;

    @Override
    public Producto publicarProducto(Producto p) throws Exception {
        Optional<Producto> buscado = productoRepo.findById(p.getCodigo());

        if (buscado.isPresent()){
            throw new Exception("El codigo del producto ya existe");
        }

        return productoRepo.save(p);
    }

    @Override
    public Producto modificarProducto(Producto p) throws Exception {
        Optional<Producto> buscado = productoRepo.findById(p.getCodigo());
        if (buscado.isEmpty()){
            throw new Exception("El codigo del usuario no existe");
        }
        System.out.println(p.toString());
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
    public List<Producto> listaProductosCategoria(Categoria categoria) {
       return productoRepo.listarProductoCategoria(categoria) ;
    }

    @Override
    public List<Producto> listarProductoNombre(String nombre) {
        return productoRepo.listarProductoNombre(nombre);
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
    public void Comentar(Comentario comentario) throws Exception {
        comentario.setFecha_comentario(LocalDate.now());
        comentarioRepo.save(comentario);
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

    @Override
    public List<Categoria> listarCategorias() {
        return Arrays.asList(Categoria.values());
    }

    @Override
    public Categoria obtenerCategoria(String categoria) throws Exception {
        return Categoria.valueOf(categoria);
    }

    @Override
    public List<Producto> listarPorCategoria(String categoria) {
        Categoria aux = Categoria.valueOf(categoria);
        return productoRepo.listarProductoCategoria(aux);
    }

    @Override
    public List<Producto> listarPorRangoDePrecio(String rango) {
        String[] precios = rango.split("-");
        Double precioMin = Double.valueOf(precios[0]);
        Double precioMax = Double.valueOf(precios[1]);
        return productoRepo.listarProductoRangoDePrecio(precioMin, precioMax);
    }

    @Override
    public List<Producto> listarPorLugar(String ciudad) throws Exception {

        Optional<Ciudad> aux = ciudadRepo.findByNombre(ciudad);

        if(aux.isEmpty()) {
            throw new Exception("No hay ciudades con ese nombre.");
        }

        return productoRepo.listarProductoPorCiudad(aux.get());
    }

    @Override
    public Integer devolverCantidadDeUnidadesPorId(String id) throws Exception {

        Optional<Producto> buscado = productoRepo.findById(id);

        if (buscado.isEmpty()) {
            throw new Exception("No existe un producto con el id indicado.");
        }

        return productoRepo.devolverCantidadDeUnidadesPorId(id);
    }

    @Override
    public Integer devolverDescuentoPorId(String id) throws Exception {

        Optional<Producto> buscado = productoRepo.findById(id);

        if (buscado.isEmpty()) {
            throw new Exception("No existe un producto con el id indicado.");
        }

        return productoRepo.devolverDescuentoPorId(id);
    }

    @Override
    public Compra realizarCompra(Usuario usuario, Producto producto, String medioPago, Integer unidades) throws Exception {
        Optional<Producto> buscado = productoRepo.findById(producto.getCodigo());

        if (buscado.isEmpty()) {
            throw new Exception("No existe un producto con el id indicado.");
        }
        if (unidades > buscado.get().getUnidades_producto()) {
            throw new Exception("No existen las unidades suficientes para su compra.");
        }
        buscado.get().setUnidades_producto(buscado.get().getUnidades_producto()-unidades);
        Producto auxP = productoRepo.save(buscado.get());
        Compra compra = new Compra(usuario, medioPago, LocalDate.now());
        System.out.println(compra.toString());
        Compra aux = compraRepo.save(compra);
        DetalleCompra detalleCompra = new DetalleCompra(aux.getCodigo(), auxP, unidades, producto.getPrecio_producto(), aux);
        detalleCompraRepo.save(detalleCompra);
        return aux;
    }


}
