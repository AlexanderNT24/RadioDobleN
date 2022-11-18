
package RadioDobleNProject;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPublicidad extends CrudRepository<Publicidad, Integer> {
    @Query(value="SELECT * FROM comentario "
            + "WHERE ip_user LIKE %?1% "
            + "OR nombre LIKE %?1% "
            + "OR contenido LIKE %?1%",nativeQuery=true)
    List<Publicidad> buscarPorTodo(String dato);
    @Query(value="SELECT * FROM comentario "
            + "WHERE tipo LIKE %?1% ",nativeQuery=true)
    List<Publicidad> buscarPorTipo(String dato);

    @Query(value="SELECT * FROM comentario "
            + "WHERE ip_user LIKE %?1% ",nativeQuery=true)
    List<Publicidad> buscarPorIp(String dato);

    @Query(value="SELECT * FROM mascota "
            + "ORDER BY Id ASC; ",nativeQuery=true)
    List<Publicidad> listarAs();
    @Query(value="SELECT * FROM mascota "
            + "ORDER BY Id DESC; ",nativeQuery=true)
    List<Publicidad> listarDes();
    @Query(value="SELECT count(id) as id,'' as nombre,sum(precio) as precio, '' as servicio FROM mascota "
            ,nativeQuery=true)
    List<Publicidad> reportar();
}
