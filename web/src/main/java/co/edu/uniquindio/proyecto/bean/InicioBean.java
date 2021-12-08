package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class InicioBean implements Serializable {

    @Autowired
    private ProductoServicio productoServicio;

    @Getter @Setter
    private List<Producto> listaProductos;

    @Getter @Setter
    private Producto producto;

    @PostConstruct
    public void inicializar(){
        this.listaProductos = productoServicio.listarProductos();
    }

    public String irADetalle(String id){
        try {
            this.producto = productoServicio.obtenerProducto(id);
            System.out.println(this.producto.getNombre_producto());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "detalleProducto?faces-redirect=true&amp;producto="+id;
    }

}
