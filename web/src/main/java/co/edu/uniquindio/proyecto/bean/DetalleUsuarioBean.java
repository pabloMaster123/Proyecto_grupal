package co.edu.uniquindio.proyecto.bean;


import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

@Component
@ViewScoped
public class DetalleUsuarioBean {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Value("#{param['usuario']}")
    public String codigoUsuario;

    @Getter
    @Setter
    private Usuario usuario;

    @PostConstruct
    public void inicializar() {
        if (codigoUsuario != null && !codigoUsuario.isEmpty()) {
            try {
                usuario = usuarioServicio.obtenerUsuario(codigoUsuario);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
