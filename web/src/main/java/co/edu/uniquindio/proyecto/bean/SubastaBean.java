package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.DetalleSubasta;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Subasta;
import co.edu.uniquindio.proyecto.entidades.Usuario;

import co.edu.uniquindio.proyecto.servicios.DetalleSubastaServicio;
import co.edu.uniquindio.proyecto.servicios.SubastaServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.util.List;

@Component
@ViewScoped
public class SubastaBean {

    @Getter
    @Setter
    private Producto producto;

    private final UsuarioServicio usuarioServicio;

    private final SubastaServicio subastaServicio;

    private final DetalleSubastaServicio detalleSubastaServicio;

    public SubastaBean(UsuarioServicio usuarioServicio,SubastaServicio subastaServicio,DetalleSubastaServicio detalleSubastaServicio) {
        this.usuarioServicio    = usuarioServicio;
        this.subastaServicio    = subastaServicio;
        this.detalleSubastaServicio     = detalleSubastaServicio;
    }

    @Value("#{seguridadBean.usuarioSesion}")
    private Usuario usuarioSesion;

    @Getter @Setter
    private Subasta subasta;

    @Getter @Setter
    private DetalleSubasta detalleSubasta;

    @Getter
    @Setter
    private List<Producto> listaProductos;

    @Getter
    @Setter
    private List<Subasta> listaSubastas;


    @PostConstruct
    public void inicializar() {
        producto = new Producto();
        subasta = new Subasta();
        detalleSubasta = new DetalleSubasta();
        this.listaProductos = usuarioServicio.listarProductos(usuarioSesion.getCodigo());
        this.listaSubastas = subastaServicio.listaSubastas();
    }

    public void publicarSubasta(){
        try {
            subastaServicio.publicarSubasta(subasta);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"alerta", "publicacion exitosa");
            FacesContext.getCurrentInstance().addMessage("msj-bean", msg);
        } catch (Exception e) {
            e.printStackTrace();
            FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_ERROR,"alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean", msg1);
        }
    }

    public void DetalleDeSubasta(){
        try {
            detalleSubastaServicio.agregarDetalleSubasata(detalleSubasta);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"alerta", "publicacion exitosa");
            FacesContext.getCurrentInstance().addMessage("msj-bean", msg);
        } catch (Exception e) {
            e.printStackTrace();
            FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_ERROR,"alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean", msg1);
        }
    }

}
