
package RadioDobleNProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ControladorPublicidad{
    @Autowired
    private IPublicidadService servicePublicidad;

    @GetMapping("/admin/publicidad")
    public String IndexPublicidad(Model model)
    {
        List<Publicidad> publicidades = servicePublicidad.Listar();
        model.addAttribute("publicidades",publicidades);


        return "adminPublicidad";
    }
    @PostMapping("/admin/publicidad")
    public String RegistrarPublicidad(@RequestParam("empresa") String empresa,
                                      @RequestParam("lema") String lema,
                                      @RequestParam("coste") String coste,
                                      @RequestParam("imagen") String imagen)
    {
        Publicidad p=new Publicidad();

        p.setEmpresa(empresa);
        p.setLema(lema);
        p.setCoste(Double.parseDouble(coste));
        p.setImagenUrl(imagen);


        servicePublicidad.Guardar(p);
        return "redirect:/admin/publicidad";


    }
    @PostMapping("/admin/editarPublicidad")
    public String ActualizarComentario(@RequestParam("id") int id,
                                       @RequestParam("empresa") String empresa,
                                       @RequestParam("lema") String lema,
                                       @RequestParam("coste") String coste,
                                       @RequestParam("imagen") String imagen)
    {
        Publicidad p=new Publicidad();

        p.setId(id);
        p.setEmpresa(empresa);
        p.setLema(lema);
        p.setCoste(Double.parseDouble(coste));
        p.setImagenUrl(imagen);
        servicePublicidad.Guardar(p);

        return "redirect:/admin/tableAdmin";
    }
    @GetMapping("/publicidad")
    public String ListarPublicidad(Model model)
    {
        List<Publicidad> publicidades = servicePublicidad.Listar();
        model.addAttribute("publicidades",publicidades);


        return "publicidad";
    }
    @GetMapping("/admin/eliminarPublicidad")
    public String EliminarComentario(@RequestParam("id") int id)
    {
        servicePublicidad.Eliminar(id);
        return "redirect:/admin/publicidad";
    }

}
