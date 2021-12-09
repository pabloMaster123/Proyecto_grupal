package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.DetalleSubasta;
import co.edu.uniquindio.proyecto.repositorios.DetalleSubastaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleSubastaServicioImpl implements DetalleSubastaServicio {

    @Autowired
    private DetalleSubastaRepo detalleSubastaRepo;

    @Override
    public DetalleSubasta agregarDetalleSubasata(DetalleSubasta detalleSubasta) throws Exception {
        Optional<DetalleSubasta> buscado = detalleSubastaRepo.findById(detalleSubasta.getCodigo());
        if (buscado.isPresent()){
            throw new Exception("El codigo del Detalle ya existe");
        }
        return detalleSubastaRepo.save(detalleSubasta);
    }

    @Override
    public DetalleSubasta actualizarSubasta(DetalleSubasta detalleSubasta) throws Exception {
        Optional<DetalleSubasta> buscado = detalleSubastaRepo.findById(detalleSubasta.getCodigo());
        if (buscado.isPresent()){
            throw new Exception("El codigo del Detalle ya existe");
        }
        return detalleSubastaRepo.save(detalleSubasta);    }

    @Override
    public void eliminarDetalleSubasta(String codigo) throws Exception {
        Optional<DetalleSubasta> buscado = detalleSubastaRepo.findById(codigo);
        if (buscado.isEmpty()){
            throw new Exception("El codigo del Detalle no existe");
        }

        detalleSubastaRepo.deleteById(codigo);

    }

    @Override
    public List<DetalleSubasta> buscarSubasata() {
        return detalleSubastaRepo.findAll();
    }
}
