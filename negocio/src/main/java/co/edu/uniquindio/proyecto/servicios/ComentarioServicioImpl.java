package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Comentario;
import co.edu.uniquindio.proyecto.repositorios.ComentarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioServicioImpl implements ComentarioServicio{

    @Autowired
    ComentarioRepo comentarioRepo;

    @Override
    public Comentario realizarComentario(Comentario c) throws Exception {
        return null;
    }

    @Override
    public void calificarComentario(String id) throws Exception {

    }

    @Override
    public void eliminarComentario(String mensaje) throws Exception {
        comentarioRepo.deleteComentarioByMensaje(mensaje);
    }


}
