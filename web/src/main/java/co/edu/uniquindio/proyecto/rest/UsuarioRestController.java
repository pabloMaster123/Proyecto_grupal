package co.edu.uniquindio.proyecto.rest;

import co.edu.uniquindio.proyecto.dto.Mensaje;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioRestController {

    @Autowired
    UsuarioServicio usuarioServicio;

    @GetMapping
    public List<Usuario> listar() {
        return usuarioServicio.listaUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> devolverUsuario (@PathVariable("id") String idUsuario) {
        try {
            Usuario usuario = usuarioServicio.obtenerUsuario(idUsuario);
            return ResponseEntity.status(200).body(usuario);
        } catch (Exception e) {
            return ResponseEntity.status(200).body(new Mensaje(e.getMessage()));
        }

    }

    @PostMapping
    public ResponseEntity<?> registrarUsuario (@RequestBody Usuario usuarioNuevo) {
        try {
            Usuario usuario = usuarioServicio.registrarUsuario(usuarioNuevo);
            return ResponseEntity.status(201).body(new Mensaje("El usuario se registro correctamente"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }

    }

    @PutMapping
    public ResponseEntity<?> actualizarUsuario(@RequestBody Usuario usuarioActualizar) {
        try {
            Usuario usuario =  usuarioServicio.actualizarUsuario(usuarioActualizar);
            return ResponseEntity.status(200).body(new Mensaje("El usuario se actualizo correctamente"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario (@PathVariable("id") String idUsuario) {
        try {
            usuarioServicio.eliminarUsuario(idUsuario);
            return ResponseEntity.status(200).body(new Mensaje("El usuario se elimino correctamente"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

}
