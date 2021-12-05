package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario,String> {

    List<Usuario> findAllByNombreContains(String nombre);

    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findByEmailAndAndPassword(String email, String password);

    Optional<Usuario> findByNombre(String nombre);

    Page<Usuario> findAll(Pageable paginador);

    @Query("select c from Usuario u INNER join u.chats c where u.codigo= :id")
    List<Chat> listarChats(String id);

    @Query("select u from Usuario u where u.nombre like concat('%' , :nombre, '%') ")
    List<Usuario> listarUsuarioNombre(String nombre);


    @Query("select p from Usuario u INNER join u.productos p where u.codigo= :id")
    List<Producto> listarProductos(String id);

    @Query("select c from Usuario u INNER join u.compras c where u.codigo= :id")
    List<Compra> listarCompras(String id);

}
