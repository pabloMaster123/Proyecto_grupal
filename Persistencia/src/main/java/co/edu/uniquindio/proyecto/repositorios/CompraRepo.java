package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepo extends JpaRepository<Compra,String>{

    @Query("select distinct c.medioPago,count(c) from Compra c group by c.medioPago")
    List<Object[]> filtrarMediosDePago();

    @Query("select distinct c.codigo_usuario,count(c) from Compra c group by c.codigo_usuario")
    List<Object[]> filtrarUsuarios();


}
