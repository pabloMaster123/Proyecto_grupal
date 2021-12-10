package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.util.List;

@Component
@ViewScoped
public class ChatearUsuarioBean {

    @Autowired
    private ProductoServicio productoServicio;

    @Getter
    @Setter
    private List<Producto> productos;

    @PostConstruct
    public void inizializar(){
        this.productos = productoServicio.listarProductos();
    }

    public String chat(String id){
        return "chat?faces-redirect=true&amp;producto="+id;
    }

}
