package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Chat;
import co.edu.uniquindio.proyecto.entidades.Persona;
import co.edu.uniquindio.proyecto.entidades.Usuario;
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

    Page<Usuario> findAll(Pageable paginador);


    @Query("select c from Usuario u INNER join u.chats c where u.codigo= :id")
    List<Chat> listarChats(String id);
}
