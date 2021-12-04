package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.util.List;

@Component
@ViewScoped
public class BuscarUsuariosBean {

    @Getter
    @Setter
    private String busqueda;

    @Getter @Setter
    @Value("#{param['busqueda']}")
    private String busquedaParametro;

    @Getter @Setter
    private List<Usuario> usuarios;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostConstruct
    public void inicializar(){
        if (busquedaParametro != null && !busquedaParametro.isEmpty()){
            try {
                usuarios = usuarioServicio.listarNombre(busquedaParametro);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String buscar(){
        return "resultado-cliente?faces-redirect=true&busqueda="+busqueda;
    }

}
