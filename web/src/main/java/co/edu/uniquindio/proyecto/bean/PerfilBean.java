package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.util.List;

@Component
@ViewScoped
public class PerfilBean {

    private final UsuarioServicio usuarioServicio;

    public PerfilBean(UsuarioServicio usuarioServicio){
        this.usuarioServicio = usuarioServicio;
    }

    @Getter
    @Setter
    private List<Producto> listaProductos;

    @Getter
    @Setter
    private List<Compra> listaCompra;

    @Value("#{seguridadBean.usuarioSesion}")
    private Usuario usuarioSesion;

    @PostConstruct
    public void inicializar(){
        this.listaProductos = usuarioServicio.listarProductos(usuarioSesion.getCodigo());
        this.listaCompra    = usuarioServicio.listarCompras(usuarioSesion.getCodigo());
    }

    public String irADetalle(String id){
        return "detalleProducto?faces-redirect=true&amp;producto="+id;
    }

}
