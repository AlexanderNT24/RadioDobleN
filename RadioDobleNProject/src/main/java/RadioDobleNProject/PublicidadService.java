package RadioDobleNProject;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicidadService implements IPublicidadService {
    @Autowired
    private IPublicidad data;

    @Override
    public List<Publicidad> Listar() {
        return (List<Publicidad>) data.findAll(); //select * from
    }

    @Override
    public Optional<Publicidad> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(Publicidad p) {
        data.save(p);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<Publicidad> Buscar(String dato) {
        return data.buscarPorTodo(dato);
    }
    @Override
    public List<Publicidad> BuscarComentarioTipo(String dato) {
        return data.buscarPorTipo(dato);
    }
    @Override
    public List<Publicidad> BuscarComentarioIp(String dato) {
        return data.buscarPorIp(dato);
    }

    @Override
    public List<Publicidad> ListarAs() {
        return data.listarAs();
    }

    @Override
    public List<Publicidad> ListarDes() {
        return data.listarDes();
    }
    @Override
    public List<Publicidad> Reportar() {
        return data.reportar();
    }
}
