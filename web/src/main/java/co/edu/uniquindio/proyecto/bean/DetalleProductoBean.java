package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Comentario;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class DetalleProductoBean implements Serializable {

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Value("#{param['producto']}")
    public String codigoProducto;

    @Getter @Setter
    private Producto producto;

    @Getter @Setter
    private Comentario nuevoComentario;

    @Getter @Setter
    private List<Comentario> comentarios;

    @Value("#{seguridadBean.usuarioSesion}")
    private Usuario usuarioSesion;

    @Getter @Setter
    private String unidades;

    @Getter @Setter
    private String medioDePago;

    @PostConstruct
    public void inicializar() {
        nuevoComentario = new Comentario();
        if (codigoProducto != null && !codigoProducto.isEmpty()) {
            try {
                producto = productoServicio.obtenerProducto(codigoProducto);
                this.comentarios = producto.getComentarios();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void nuevoComentario(){
        try{
            if(usuarioSesion != null) {
                nuevoComentario.setProducto(producto);
                nuevoComentario.setCodigo_usuario(usuarioSesion);
                productoServicio.Comentar(nuevoComentario);
                this.comentarios.add(nuevoComentario);
                nuevoComentario = new Comentario();
            }
        }catch (Exception e){

        }
    }

    public void realizarCompra() {
        System.out.println("entro aqui");
        if(usuarioSesion != null) {
            Integer auxUnidades = 1;
            medioDePago = "Tarjeta de Debito";
            try {
                System.out.println(usuarioSesion.toString());
                System.out.println(producto.toString());
                System.out.println(medioDePago);
                System.out.println(auxUnidades);
                productoServicio.realizarCompra(usuarioSesion, producto, medioDePago, auxUnidades);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
