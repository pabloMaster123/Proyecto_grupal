package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Subasta;
import co.edu.uniquindio.proyecto.repositorios.SubastaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubastaServicioImpl implements SubastaServicio{

    @Autowired
    private SubastaRepo subastaRepo;


    @Override
    public Subasta publicarSubasta(Subasta s) throws Exception {
        Optional<Subasta> buscado = subastaRepo.findById(s.getCodigo());
        if (buscado.isPresent()){
            throw new Exception("El codigo de la subasta ya existe");
        }

        return subastaRepo.save(s);
    }

    @Override
    public Subasta actualizarSubasta(Subasta s) throws Exception {

        Optional<Subasta> buscado = subastaRepo.findById(s.getCodigo());
        if (buscado.isPresent()){
            throw new Exception("El codigo de la subasta no existe");
        }

        return subastaRepo.save(s);
    }

    @Override
    public void eliminarSubasta(String codigo) throws Exception {
        Optional<Subasta> buscado = subastaRepo.findById(codigo);
        if (buscado.isEmpty()){
            throw new Exception("El codigo del usuario no existe");
        }
        subastaRepo.deleteById(codigo);
    }

    @Override
    public List<Subasta> listaSubastas() {
        return subastaRepo.findAll();
    }
}
