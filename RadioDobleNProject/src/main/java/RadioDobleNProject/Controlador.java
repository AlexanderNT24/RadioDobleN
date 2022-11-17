
package RadioDobleNProject;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlador {
    @Autowired
    private IComentarioService service;
     
    @GetMapping("/")
    public String Index(Model model)
    {
        List<Comentario> comentarios = service.Listar();
        model.addAttribute("comentarios",comentarios);

        return "index";
    }
    @PostMapping("/")
    public String RegistrarComentario(@RequestParam("ip") String ip,
                                      @RequestParam("tipo") String tipo,
                                      @RequestParam("nombre") String nombre,
                                      @RequestParam("contenido") String contenido)
    {
        Comentario c=new Comentario();
        c.setIpUser(ip);
        c.setTipo(tipo);
        c.setNombre(nombre);
        c.setContenido(contenido);

        service.Guardar(c);

        return "redirect:/";
    }
    @PostMapping("/editarComentario")
    public String ActualizarComentario(@RequestParam("id") int id,
                                       @RequestParam("ip") String ip,
                                       @RequestParam("tipo") String tipo,
                                       @RequestParam("nombre") String nombre,
                                       @RequestParam("contenido") String contenido)
    {
        Comentario c=new Comentario();

        c.setId(id);
        c.setIpUser(ip);
        c.setTipo(tipo);
        c.setNombre(nombre);
        c.setContenido(contenido);
        service.Guardar(c);

        return "redirect:/";
    }
    @GetMapping("/eliminarComentario")
    public String EliminarComentario(@RequestParam("id") int id)
    {
        service.Eliminar(id);
        return "redirect:/";
    }
    @PostMapping("/buscarComentario")
    public String BuscarComentario(@RequestParam("dato") String dato, Model model)
    {
        try {
            System.out.println(dato);
            List<Comentario> comentarios = service.Buscar(dato);
            model.addAttribute("comentarios",comentarios);
            return "index";

        } catch (Exception e) {
            return "index";

        }

    }
    @PostMapping("/buscarComentarioTipo")
    public String BuscarComentarioTipo(@RequestParam("dato") String dato, Model model)
    {
        try {
            System.out.println(dato);
            List<Comentario> comentarios = service.BuscarComentarioTipo(dato);
            model.addAttribute("comentarios",comentarios);
            return "index";

        } catch (Exception e) {
            return "index";

        }

    }
    @PostMapping("/buscarComentarioIp")
    public String BuscarComentarioIp(@RequestParam("dato") String dato, Model model)
    {
        try {
            System.out.println(dato);
            List<Comentario> comentarios = service.BuscarComentarioIp(dato);
            model.addAttribute("comentarios",comentarios);
            return "index";

        } catch (Exception e) {
            return "index";

        }

    }

}
