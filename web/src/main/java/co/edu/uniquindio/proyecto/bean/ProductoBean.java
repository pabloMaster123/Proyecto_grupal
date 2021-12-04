package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.CiudadServicio;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.*;
import java.util.*;

@Component
@ViewScoped
public class ProductoBean implements Serializable {

    @Getter
    @Setter
    private Producto producto;

    private final UsuarioServicio usuarioServicio;

    private final CiudadServicio ciudadServicio;

    private final ProductoServicio productoServicio;

    public ProductoBean(CiudadServicio ciudadServicio,UsuarioServicio usuarioServicio,ProductoServicio productoServicio) {
        this.ciudadServicio   = ciudadServicio;
        this.usuarioServicio  = usuarioServicio;
        this.productoServicio = productoServicio;
    }

    private ArrayList<String> imagenes;

    @Getter @Setter
    private List<Categoria> categorias;

    @Getter @Setter
    private List<Ciudad> ciudaes;

    @Value("${upload.url}")
    private String urlUpload;

    @Value("#{seguridadBean.usuarioSesion}")
    private Usuario usuarioSesion;

    @PostConstruct
    public void inicializar() {
        producto = new Producto();
        this.imagenes = new ArrayList<>();
        this.categorias = productoServicio.listarCategorias();
        this.ciudaes = ciudadServicio.listarCuidad();
    }


    public void registarProducto() {
        try {
            if (!imagenes.isEmpty()) {
                Usuario usuario = usuarioServicio.obtenerUsuario(usuarioSesion.getCodigo());
                producto.setUsuario(usuario);
                producto.setRuta(imagenes);
                productoServicio.publicarProducto(producto);
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "alerta", "Producto creado satisfactoriamente");
                FacesContext.getCurrentInstance().addMessage("msj-bean", msg);
            }else{
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "alerta", "Es necesario una imagen");
                FacesContext.getCurrentInstance().addMessage("msj-bean", msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_ERROR, "alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean", msg1);
        }
    }

    public void subirImagenes(FileUploadEvent event) {
        UploadedFile imagen = event.getFile();
        String nombreImagen = subirImagen(imagen);
        if (nombreImagen != null) {
            imagenes.add(nombreImagen);
        }
    }

    public String subirImagen(UploadedFile imagen) {

        try {
            File archivo = new File(urlUpload + "/" + imagen.getFileName());
            OutputStream outputStream;
            outputStream = new FileOutputStream(archivo);
            IOUtils.copy(imagen.getInputStream(), outputStream);
            return imagen.getFileName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
