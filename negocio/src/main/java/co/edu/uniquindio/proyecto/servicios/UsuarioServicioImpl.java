package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.ComentarioRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private ComentarioRepo comentarioRepo;

    @Override
    public Usuario registrarUsuario(Usuario u) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findById(u.getCodigo());
        if (buscado.isPresent()){
            throw new Exception("El codigo del usuario ya existe");
        }

        buscado = usuarioRepo.findByEmail(u.getEmail());
        if (buscado.isPresent()){
            throw new Exception("El email del usuario ya existe");
        }
        u.setComentarios(new ArrayList<Comentario>());
        u.setCompras(new ArrayList<Compra>());
        u.setChats(new ArrayList<Chat>());
        u.setProductosCarrito(new ArrayList<Producto>());
        u.setProductos(new ArrayList<Producto>());
        u.setProductosFavoritos(new ArrayList<Producto>());
        u.setTelefono(new ArrayList<String>());

        return usuarioRepo.save(u);
    }

    @Override
    public Usuario actualizarUsuario(Usuario u) throws Exception {

        Optional<Usuario> buscado = usuarioRepo.findById(u.getCodigo());
        if (buscado.isEmpty()){
            throw new Exception("El codigo del usuario no existe");
        }

        return usuarioRepo.save(u);

    }

    @Override
    public void eliminarUsuario(String codigo) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findById(codigo);
        if (buscado.isEmpty()){
            throw new Exception("El codigo del usuario no existe");
        }
        System.out.println(buscado.get().getNombre());
        List<Comentario> comentarios = comentarioRepo.devolverComentariosPorUsuario(codigo);

        for (Comentario comentario : comentarios) {
            comentarioRepo.deleteById(comentario.getCodigo());
        }

        usuarioRepo.deleteById(codigo);
    }

    @Override
    public List<Usuario> listaUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public List<Usuario> listarNombre(String nombre) throws Exception {
        return usuarioRepo.listarUsuarioNombre(nombre);
    }

    @Override
    public Usuario obtenerUsuario(String codigo) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findById(codigo);

        if (buscado.isEmpty()){
            throw new Exception("El codigo del usuario no existe");
        }

        return  buscado.get();
    }

    @Override
    public Usuario obtenerUsuarioNombre(String nombre) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findByNombre(nombre);

        if (buscado.isEmpty()){
            throw new Exception("El nombre del usuario no existe");
        }

        return  buscado.get();
    }

    @Override
    public Usuario login(String email, String pasword) throws Exception {
        return  usuarioRepo.findByEmailAndAndPassword(email,pasword).orElseThrow(() -> new Exception("Datos Incorrectos"));
    }

    @Override
    public Usuario recuperarContraseña(Usuario u) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findByEmail(u.getEmail());

        if (buscado.isPresent()){
            throw new Exception("El correo del usuario no existe");
        }

        return  usuarioRepo.save(u);
    }

    @Override
    public List<Producto> listarProductos(String codigo)  {
        return usuarioRepo.listarProductos(codigo);
    }

    @Override
    public List<Compra> listarCompras(String codigo) {
        return usuarioRepo.listarCompras(codigo);
    }


}
