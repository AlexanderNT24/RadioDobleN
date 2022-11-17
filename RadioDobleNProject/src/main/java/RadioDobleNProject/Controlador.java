
package RadioDobleNProject;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
                                      @RequestParam("contenido") String contenido,
                                      Model model)
    {
        Comentario c=new Comentario();
        c.setIpUser(ip);
        c.setTipo(tipo);
        c.setNombre(nombre);
        c.setContenido(contenido);

        service.Guardar(c);

        System.out.println("crear"+c);
        return "redirect:/";
    }
    @PostMapping("/editarComentario")
    public String ActualizarComentario(@RequestParam("id") int id,
                                       @RequestParam("ip") String ip,
                                       @RequestParam("tipo") String tipo,
                                       @RequestParam("nombre") String nombre,
                                       @RequestParam("contenido") String contenido,
                                       Model model)
    {
        Comentario c=new Comentario();

        c.setId(id);
        c.setIpUser(ip);
        c.setTipo(tipo);
        c.setNombre(nombre);
        c.setContenido(contenido);
        System.out.println("editar"+c);
        service.Guardar(c);

        return "redirect:/";
    }
    @GetMapping("/eliminarComentario")
    public String EliminarComentario(@RequestParam("id") int id, Model model)
    {
        service.Eliminar(id);
        return "redirect:/";
    }

}
