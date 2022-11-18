
package RadioDobleNProject;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPublicidad extends CrudRepository<Publicidad, Integer> {
    @Query(value="SELECT * FROM publicidad "
            + "WHERE id LIKE %?1% "
            + "OR empresa LIKE %?1% "
            + "OR lema LIKE %?1%",nativeQuery=true)
    List<Publicidad> buscarPorTodo(String dato);
    @Query(value="SELECT * FROM publicidad "
            + "WHERE empresa LIKE %?1% ",nativeQuery=true)
    List<Publicidad> buscarPorTipo(String dato);

    @Query(value="SELECT * FROM publicidad "
            + "ORDER BY Id ASC; ",nativeQuery=true)
    List<Publicidad> listarAs();
    @Query(value="SELECT * FROM publicidad "
            + "ORDER BY Id DESC; ",nativeQuery=true)
    List<Publicidad> listarDes();
    @Query(value="SELECT count(id) as id, sum(coste) as coste ,'' as empresa, '' as imagen_url,'' as lema FROM publicidad ORDER BY Id DESC;",nativeQuery=true)
    List<Publicidad> reportarPublicidad();
}
