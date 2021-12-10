package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Chat;
import co.edu.uniquindio.proyecto.entidades.Comentario;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.util.List;

@Component
@ViewScoped
public class ChatBean {

    @Getter
    @Setter
    private Comentario nuevoComentario;

    @Getter
    @Setter
    private Chat chat;

    @Value("#{seguridadBean.usuarioSesion}")
    private Usuario usuarioSesion;

    @Getter @Setter
    private Producto producto;

    @Getter @Setter
    private List<Comentario> comentarios;

    @PostConstruct
    public void inicializar() {

    }



}
