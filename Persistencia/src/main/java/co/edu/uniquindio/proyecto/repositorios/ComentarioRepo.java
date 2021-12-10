package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepo  extends JpaRepository<Comentario,Integer>{

    @Query("select c from Comentario c where c.calificacion between :calificacionMenor and :calificacionMayor")
    List<Comentario> listaComentarioRango(int calificacionMenor, int calificacionMayor);

    @Query("select c.producto.nombre_producto,avg(c.calificacion) from Comentario c left join c.producto.categorias ca group by  ca order by c.calificacion desc ")
    List<Object[]> comentariosOrdenados();

    void deleteComentarioByMensaje(String mensaje);

    @Query("select c from Comentario c where c.codigo_usuario.codigo = :idUsuario")
    List<Comentario> devolverComentariosPorUsuario(String idUsuario);

}
