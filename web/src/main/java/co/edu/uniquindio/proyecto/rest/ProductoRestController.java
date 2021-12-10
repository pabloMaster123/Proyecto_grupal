package co.edu.uniquindio.proyecto.rest;

import co.edu.uniquindio.proyecto.dto.Mensaje;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/productos")
public class ProductoRestController {

    @Autowired
    ProductoServicio productoServicio;

    @GetMapping
    public ResponseEntity<?> listar() {

        List<Producto> productos = productoServicio.listarProductos();

        if (productos.size() > 0) {
            return ResponseEntity.status(200).body(productos);
        }else {
            return ResponseEntity.status(500).body(new Mensaje("No hay productos"));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity devolverProductoSegunId(@PathVariable("id") String idProducto) {

        try {
            Producto producto = productoServicio.obtenerProducto(idProducto);
            return ResponseEntity.status(200).body(producto);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<?> registrarProducto(@RequestBody Producto productoNuevo) {
        System.out.println(productoNuevo.toString());
        try {
            Producto producto = productoServicio.publicarProducto(productoNuevo);
            return ResponseEntity.status(201).body(new Mensaje("Se ha agregado correctamente el producto"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @PutMapping
    public ResponseEntity<?> actualizarProducto(@RequestBody Producto productoNuevo) {
        System.out.println(productoNuevo.toString());
        try {
            Producto producto = productoServicio.modificarProducto(productoNuevo);
            return ResponseEntity.status(200).body(new Mensaje("Se ha actuualizado correctamente el producto"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarProductoSegunId(@PathVariable("id") String idProducto) {

        try {
            productoServicio.eliminarProducto(idProducto);
            return ResponseEntity.status(200).body(new Mensaje("Se ha eliminado correctamente el producto"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @GetMapping("/filtrados/categoria/{categoria}")
    public ResponseEntity devolverProductoSegunCategoria (@PathVariable("categoria") String categoriaAux) {

        try {
            List<Producto> productos = productoServicio.listarPorCategoria(categoriaAux);
            return ResponseEntity.status(200).body(productos);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @GetMapping("/filtrados/precios/{precios}")
    public ResponseEntity devolverProductoSegunRangoDePrecios (@PathVariable("precios") String preciosAux) {

        try {
            List<Producto> productos = productoServicio.listarPorRangoDePrecio(preciosAux);
            return ResponseEntity.status(200).body(productos);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @GetMapping("/filtrados/ciudad/{ciudad}")
    public ResponseEntity devolverProductoSegunCiudad (@PathVariable("ciudad") String ciudadAux) {

        try {
            List<Producto> productos = productoServicio.listarPorLugar(ciudadAux);
            return ResponseEntity.status(200).body(productos);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @GetMapping("/unidades/{id}")
    public ResponseEntity devolverCantidadDeUnidades (@PathVariable("id") String idProducto) {

        try {
            Integer cantidadUnidades = productoServicio.devolverCantidadDeUnidadesPorId(idProducto);
            return ResponseEntity.status(200).body(new Mensaje("La cantidad de unidades del producto indicado es: " + cantidadUnidades));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @GetMapping("/descuento/{id}")
    public ResponseEntity devolverDescuentoDeProducto (@PathVariable("id") String idProducto) {

        try {
            Integer descuento = productoServicio.devolverDescuentoPorId(idProducto);
            return ResponseEntity.status(200).body(new Mensaje("El descuento del producto indicado es: " + descuento));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }
}
