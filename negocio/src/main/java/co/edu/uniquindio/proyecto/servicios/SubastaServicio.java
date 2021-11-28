package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Subasta;

import java.util.List;

public interface SubastaServicio {

    Subasta publicarSubasta(Subasta s) throws  Exception;

    Subasta actualizarSubasta(Subasta u) throws Exception;

    void eliminarSubasta(String codigo) throws Exception;

    List<Subasta> listaUsuarios();


}
