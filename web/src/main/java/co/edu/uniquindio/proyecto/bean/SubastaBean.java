package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
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



    @Value("#{seguridadBean.usuarioSesion}")
    private Usuario usuarioSesion;

    @Getter
    @Setter
    private List<Producto> listaProductos;




}
