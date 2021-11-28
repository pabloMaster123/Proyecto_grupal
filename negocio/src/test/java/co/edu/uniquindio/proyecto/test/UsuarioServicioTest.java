package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class UsuarioServicioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    public void registarTest() {
        Usuario u = new Usuario("1", "sebastian", "sebastian@gmail.com", "usuario1", "contrasenia", null);
        try {
            Usuario respuesta = usuarioServicio.registrarUsuario(u);
 //           Assertions.assertNotNull(respuesta);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void eliminarTest() {
        try {
            usuarioServicio.eliminarUsuario("2");
            Assertions.assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void obtenerUsuario(){
        try {
            Usuario usuarioBuscado = usuarioServicio.obtenerUsuario("2");
            Assertions.assertNotNull(usuarioBuscado);
        } catch (Exception e) {
            Assertions.assertTrue(false,e.getMessage());
        }
    }

    @Test
    public void listarTest() {
        Usuario u = new Usuario("3", "Pablo", "pallo@gmail.com", "usuario2", "fokakjd56", null);
        try {
            usuarioServicio.registrarUsuario(u);
            Assertions.assertNotNull(u);
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.assertTrue(false);
        }
        List<Usuario> lista = usuarioServicio.listaUsuarios();
        lista.forEach(System.out::println);
    }

    @Test
    public void actualizarTest() {

        try {
            Usuario usuario = usuarioServicio.obtenerUsuario("1");
            usuario.setPassword("rt61883");
            usuarioServicio.actualizarUsuario(usuario);

            Usuario usuarioModificado = usuarioServicio.obtenerUsuario("1");
            Assertions.assertEquals("rt61883", usuarioModificado.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void LoginTest(){
        try {
            Usuario usuario = usuarioServicio.Login("usuario2", "fokakjd56");
            Assertions.assertNotNull(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.assertTrue(false, e.getMessage());
        }
    }

}
