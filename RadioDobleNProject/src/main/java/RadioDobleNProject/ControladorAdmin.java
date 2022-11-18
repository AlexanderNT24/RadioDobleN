
package RadioDobleNProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorAdmin {
    @Autowired
    private IComentarioService service;

    @GetMapping("/admin")
    public String IndexAdmin(Model model)
    {
        return "signInAdmin";
    }
    @PostMapping ("/admin")
    public String LogAdmin(Model model)
    {
        List<Comentario> comentarios = service.Listar();
        model.addAttribute("comentarios",comentarios);

        return "redirect:/admin/tableAdmin";
    }

    @GetMapping("/admin/tableAdmin")
    public String IndexAdminTable(Model model)
    {
        List<Comentario> comentarios = service.Listar();
        model.addAttribute("comentarios",comentarios);

        return "admin";
    }
    @PostMapping("/admin/editarComentario")
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

        return "redirect:/admin/tableAdmin";
    }
    @GetMapping("/admin/eliminarComentario")
    public String EliminarComentario(@RequestParam("id") int id)
    {
        service.Eliminar(id);
        return "redirect:/admin/tableAdmin";
    }
    @PostMapping("/admin/buscarComentarioTipo")
    public String BuscarComentarioTipoAdmin(@RequestParam("dato") String dato, Model model)
    {
        try {
            System.out.println(dato);
            List<Comentario> comentarios = service.BuscarComentarioTipo(dato);
            model.addAttribute("comentarios",comentarios);
            return "admin";

        } catch (Exception e) {
            return "admin";

        }

    }
    @PostMapping("/admin/buscarComentario")
    public String BuscarComentario(@RequestParam("dato") String dato, Model model)
    {
        try {
            System.out.println(dato);
            List<Comentario> comentarios = service.Buscar(dato);
            model.addAttribute("comentarios",comentarios);
            return "admin";

        } catch (Exception e) {
            return "admin";

        }

    }
    @GetMapping("/listarComentarioAs")
    public String ComentarioAs(Model model)
    {
        List<Comentario> comentarios = service.ListarAs();
        model.addAttribute("comentarios",comentarios);
        return "admin";
    }
    @GetMapping("/listarComentarioDes")
    public String ComentarioDes(Model model)
    {
        List<Comentario> comentarios = service.ListarDes();
        model.addAttribute("comentarios",comentarios);
        return "admin";
    }


}
