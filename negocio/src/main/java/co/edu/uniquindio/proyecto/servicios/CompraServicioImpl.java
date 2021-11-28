package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraServicioImpl implements CompraServicio{

    @Autowired
    CompraRepo compraRepo;

    @Override
    public Compra realizarCompra(Compra c) throws Exception {
        Optional<Compra> buscado = compraRepo.findById(c.getCodigo());

        if (buscado.isPresent()){
            throw new Exception("El codigo de la compra ya existe");
        }

        return compraRepo.save(c);
    }

    @Override
    public void eliminarCompra(String codigo) throws Exception {
        Optional<Compra> buscado = compraRepo.findById(codigo);

        if (buscado.isEmpty()){
            throw new Exception("El codigo de la compra ya existe");
        }

         compraRepo.deleteById(codigo);
    }

    @Override
    public List<Compra> listaCompra() {
        return compraRepo.findAll();
    }

    @Override
    public Compra obtenerCompra(String codigo) throws Exception {
        Optional<Compra> buscado = compraRepo.findById(codigo);

        if (buscado.isEmpty()){
            throw new Exception("El codigo de la compra no existe");
        }

        return  buscado.get();
    }

    @Override
    public List<Object[]> comprasRealizadas() {
        return compraRepo.filtrarUsuarios();
    }

}
