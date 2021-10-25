package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CiudadRepo extends JpaRepository<Ciudad,String> {
    Optional<Ciudad> findByNombre(String nombreCuidad);

    @Query("select c.usuaios from Ciudad c join c.usuaios where c.nombre = :nombre")
    List<Usuario> listarUsuarios(String nombre);

}
