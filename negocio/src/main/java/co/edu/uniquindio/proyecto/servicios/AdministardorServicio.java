package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Administrador;
import co.edu.uniquindio.proyecto.entidades.Usuario;

public interface AdministardorServicio {

    Administrador login(String email, String pasword) throws Exception;



}
