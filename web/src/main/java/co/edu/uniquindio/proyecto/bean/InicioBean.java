package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Subasta;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.SubastaServicio;
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

    @Autowired
    private SubastaServicio subastaServicio;

    @Getter @Setter
    private List<Producto> listaProductos;

    @Getter @Setter
    private List<Subasta> listaSubastas;

    @PostConstruct
    public void inicializar(){
        this.listaProductos = productoServicio.listarProductos();
        this.listaSubastas = subastaServicio.listaSubastas();
    }

    public String irADetalle(String id){
        return "detalleProducto?faces-redirect=true&amp;producto="+id;
    }

}
