
package RadioDobleNProject;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService implements IComentarioService {
    @Autowired
    private IComentario data;
    
    @Override
    public List<Comentario> Listar() {
       return (List<Comentario>) data.findAll(); //select * from
    }
    
    @Override
    public Optional<Comentario> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(Comentario p) {
        data.save(p);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<Comentario> Buscar(String dato) {
       return data.buscarPorTodo(dato);
    }
    @Override
    public List<Comentario> BuscarComentarioTipo(String dato) {
        return data.buscarPorTipo(dato);
    }
    @Override
    public List<Comentario> BuscarComentarioIp(String dato) {
        return data.buscarPorIp(dato);
    }
    
    @Override
    public List<Comentario> ListarAs() {
       return data.listarAs();
    }
    
    @Override
    public List<Comentario> ListarDes() {
       return data.listarDes();
    }
     @Override
    public List<Comentario> Reportar() {
       return data.reportar();
    }
}
