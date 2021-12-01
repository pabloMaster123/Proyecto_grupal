package co.edu.uniquindio.proyecto.conventer;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.io.Serializable;

@Component
public class CategoriaConverter implements Converter<Categoria>, Serializable {

    @Autowired
    private ProductoServicio productoServicio;

    @Override
    public Categoria getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Categoria categoria = null;
        try {
            categoria = productoServicio.obtenerCategoria(s);
            return categoria;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Categoria categoria) {
        if (categoria != null){
            return categoria.toString();
        }
        return "";
    }

}
