package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Usuario;

import java.util.List;

public interface UsuarioServicio {

    Usuario registrarUsuario(Usuario u) throws Exception;

    Usuario actualizarUsuario(Usuario u) throws Exception;

    void eliminarUsuario(String codigo) throws Exception;

    List<Usuario> listaUsuarios();

    Usuario obtenerUsuario(String codigo) throws Exception;

    Usuario Login(String email, String pasword) throws Exception;

    Usuario recuperarContraseña(String username,String pasword) throws Exception;

}
