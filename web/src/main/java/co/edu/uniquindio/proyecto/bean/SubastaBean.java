package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Subasta;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.CiudadServicio;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.faces.view.ViewScoped;
import java.util.List;

@Component
@ViewScoped
public class SubastaBean {

    @Getter
    @Setter
    private Producto producto;

    private final UsuarioServicio usuarioServicio;

    private final ProductoServicio productoServicio;

    public SubastaBean(UsuarioServicio usuarioServicio,ProductoServicio productoServicio) {
        this.usuarioServicio  = usuarioServicio;
        this.productoServicio = productoServicio;
    }

    @Value("#{seguridadBean.usuarioSesion}")
    private Usuario usuarioSesion;

    @Getter
    @Setter
    private List<Producto> listaProductos;

    @Getter
    @Setter
    private List<Subasta> listaSubastas;






}
