package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Administrador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdministradorRepo extends JpaRepository<Administrador,String> {

    List<Administrador> findAllByNombreContains(String nombre);

    Optional<Administrador> findByEmail(String email);

    Page<Administrador> findAll(Pageable paginador);

    Optional<Administrador> findByEmailAndAndPassword(String email, String password);


}
