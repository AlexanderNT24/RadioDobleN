
package RadioDobleNProject;

import java.util.List;
import java.util.Optional;

public interface IComentarioService {
    public List<Comentario> Listar();
    public Optional<Comentario> ConsultarId(int id);
    public void Guardar(Comentario c);
    public void Eliminar(int id);
    public List<Comentario> Buscar(String dato);
    public List<Comentario>BuscarComentarioTipo(String dato);
    public List<Comentario>BuscarComentarioIp(String dato);
    public List<Comentario> ListarAs();
    public List<Comentario> ListarDes();
    public List<Comentario> Reportar();
}
