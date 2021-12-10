package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Comentario;

public interface ComentarioServicio {

    Comentario realizarComentario(Comentario c) throws Exception;

    void calificarComentario(String id) throws Exception;

    void eliminarComentario(String mensaje) throws Exception;

}
