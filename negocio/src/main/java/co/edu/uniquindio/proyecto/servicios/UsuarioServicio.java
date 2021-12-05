package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;

import java.util.List;

public interface UsuarioServicio {

    Usuario registrarUsuario(Usuario u) throws Exception;

    Usuario actualizarUsuario(Usuario u) throws Exception;

    void eliminarUsuario(String codigo) throws Exception;

    List<Usuario> listaUsuarios();

    List<Usuario> listarNombre(String nombre) throws Exception;

    Usuario obtenerUsuario(String codigo) throws Exception;

    Usuario obtenerUsuarioNombre(String nombre) throws Exception;

    Usuario login(String email, String pasword) throws Exception;

    Usuario recuperarContraseña(Usuario u) throws Exception;

    List<Producto> listarProductos(String codigo);

    List<Compra> listarCompras(String codigo);

}
