package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.CiudadServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class UsuarioBean implements Serializable {

    @Getter @Setter
    private Usuario usuario;

    private final UsuarioServicio usuarioServicio;

    private final CiudadServicio ciudadServicio;

    @Getter @Setter
    private List<Ciudad> ciudaes;

    public UsuarioBean(CiudadServicio ciudadServicio,UsuarioServicio usuarioServicio) {
        this.ciudadServicio = ciudadServicio;
        this.usuarioServicio = usuarioServicio;
    }

    @PostConstruct
    public void inicializar(){
        usuario = new Usuario();
        this.ciudaes = ciudadServicio.listarCuidad();
    }

    public void registarUusario(){
        try {
            usuarioServicio.registrarUsuario(usuario);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"alerta", "registro exitoso");
            FacesContext.getCurrentInstance().addMessage("msj-bean", msg);
        } catch (Exception e) {
            e.printStackTrace();
            FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_ERROR,"alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean", msg1);
        }
    }
}
