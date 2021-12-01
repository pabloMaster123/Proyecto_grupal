package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.repositorios.CiudadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadServicioImpl implements CiudadServicio {

    @Autowired
    private CiudadRepo ciudadRepo;

    @Override
    public List<Ciudad> listarCuidad() {
        return ciudadRepo.findAll();
    }

    @Override
    public Ciudad obtenerCuidad(String id) throws Exception {
        return ciudadRepo.findById(id).orElseThrow( () -> new Exception("La cuidad no existe") );
    }
}
