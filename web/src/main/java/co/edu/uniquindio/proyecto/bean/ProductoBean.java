package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class ProductoBean implements Serializable {

    @Getter
    @Setter
    private Producto producto;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private ProductoServicio productoServicio;

    @PostConstruct
    public void inicializar(){
        producto = new Producto();
    }


    public String registarProducto(){
        try {
            Usuario usuario = usuarioServicio.obtenerUsuario("313");
            producto.setUsuario(usuario);
            productoServicio.publicarProducto(producto);
            return "ProductoCreado?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_ERROR,"alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg1);
        }
        return null;
    }

    public void subirImagenes(FileUploadEvent event){
        UploadedFile imagen = event.getFile();
    }

}
