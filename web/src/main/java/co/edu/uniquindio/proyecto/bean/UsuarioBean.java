package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class UsuarioBean implements Serializable {

    @Getter @Setter
    private Usuario usuario;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostConstruct
    public void inicializar(){
        usuario = new Usuario();
    }


    public void registarUusario(){
        try {
            usuarioServicio.registrarUsuario(usuario);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"alerta", "registro exitoso");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            e.printStackTrace();
            FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_ERROR,"alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg1);
        }
    }

}
