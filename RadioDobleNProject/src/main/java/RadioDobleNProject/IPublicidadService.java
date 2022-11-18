
package RadioDobleNProject;

import java.util.List;
import java.util.Optional;

public interface IPublicidadService {
    public List<Publicidad> Listar();
    public Optional<Publicidad> ConsultarId(int id);
    public void Guardar(Publicidad c);
    public void Eliminar(int id);
    public List<Publicidad> Buscar(String dato);
    public List<Publicidad>BuscarComentarioTipo(String dato);

    public List<Publicidad> ListarAs();
    public List<Publicidad> ListarDes();
    public List<Publicidad> Reportar();
}
