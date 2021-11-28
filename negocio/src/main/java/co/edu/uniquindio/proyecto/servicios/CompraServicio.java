package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Compra;

import java.util.List;

public interface CompraServicio {

    Compra realizarCompra(Compra c) throws Exception;

    void eliminarCompra(String codigo) throws Exception;

    List<Compra> listaCompra();

    Compra obtenerCompra(String codigo) throws Exception;

    List<Object[]> comprasRealizadas();

}
