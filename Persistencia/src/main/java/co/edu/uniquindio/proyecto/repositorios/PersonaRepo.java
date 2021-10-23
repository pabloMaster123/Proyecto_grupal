package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonaRepo extends JpaRepository<Persona,String>{

    List<Persona> findAllByNombreContains(String nombre);

    Optional<Persona> findByEmail(String email);

    Optional<Persona> findByEmailAndAndPassword(String email, String password);

    Page<Persona> findAll(Pageable paginador);

}
