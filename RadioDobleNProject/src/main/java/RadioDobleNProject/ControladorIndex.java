
package RadioDobleNProject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorIndex {
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
        if(validateComment(contenido)){
            Comentario c=new Comentario();
            c.setIpUser(ip);
            c.setTipo(tipo);
            c.setNombre(nombre);
            c.setContenido(contenido);

            service.Guardar(c);
            return "redirect:/";
        }
        return "redirect:/";


    }

    public boolean validateComment(String comentario){
        comentario=comentario.toLowerCase();
        ArrayList<String> groserias = new ArrayList<String>();
        groserias.add("basofia");
        groserias.add("basura");
        groserias.add("mala");
        Iterator<String> iterador = groserias.iterator();
        while(iterador.hasNext()){
            String elemento = iterador.next();
            if(elemento.contains(comentario))
                return false;
        }

        return true;
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

    @GetMapping("/historia")
    public String Historia(Model model)
    {

        return "historia";
    }
    @GetMapping("/galeria")
    public String Galeria(Model model)
    {

        return "galeria";
    }
    @GetMapping("/patrocinadores")
    public String Patrocinadores(Model model)
    {

        return "patrocinadores";
    }
}
