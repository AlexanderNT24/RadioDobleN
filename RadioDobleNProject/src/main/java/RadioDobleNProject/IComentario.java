
package RadioDobleNProject;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComentario extends CrudRepository<Comentario, Integer> {
   @Query(value="SELECT * FROM comentario "
           + "WHERE ip_user LIKE %?1% "
           + "OR nombre LIKE %?1% "
           + "OR contenido LIKE %?1%",nativeQuery=true)
   List<Comentario> buscarPorTodo(String dato);
   @Query(value="SELECT * FROM comentario "
           + "WHERE tipo LIKE %?1% ",nativeQuery=true)
   List<Comentario> buscarPorTipo(String dato);

   @Query(value="SELECT * FROM comentario "
           + "WHERE ip_user LIKE %?1% ",nativeQuery=true)
   List<Comentario> buscarPorIp(String dato);

   @Query(value="SELECT * FROM comentario "
           + "ORDER BY Id ASC; ",nativeQuery=true)
   List<Comentario> listarAs();
   @Query(value="SELECT * FROM comentario "
           + "ORDER BY Id DESC; ",nativeQuery=true)
   List<Comentario> listarDes();
   @Query(value="SELECT COUNT(id) AS id,'' AS contenido, ip_user, '' AS nombre,'' as tipo FROM `comentario` GROUP BY ip_user; "
           ,nativeQuery=true)
   List<Comentario> reportar();
}
