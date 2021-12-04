package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Usuario;
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
public class AdministradorBean {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Getter @Setter
    private List<Usuario> usuarios;

    @PostConstruct
    public void inizializar(){
        this.usuarios = usuarioServicio.listaUsuarios();
    }

    public String irADetalle(String id){
        return "detalleUsuario?faces-redirect=true&amp;usuario="+id;
    }

}
