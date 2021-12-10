package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.DetalleSubasta;

import java.util.List;

public interface DetalleSubastaServicio {

    DetalleSubasta agregarDetalleSubasata(DetalleSubasta detalleSubasta) throws Exception;

    DetalleSubasta actualizarSubasta(DetalleSubasta detalleSubasta) throws Exception;

    void eliminarDetalleSubasta(String codigo) throws Exception;

    List<DetalleSubasta> buscarSubasata();

}
