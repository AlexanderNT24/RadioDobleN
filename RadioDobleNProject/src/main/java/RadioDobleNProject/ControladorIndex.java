
package RadioDobleNProject;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


@Controller
public class ControladorIndex {
    @Autowired
    private IComentarioService service;
     
    @GetMapping("/")
    public String Index(Model model)
    {
        List<Comentario> comentarios = service.ListarDes();
        model.addAttribute("comentarios",comentarios);

        return "index";
    }
    @PostMapping("/")
    public String RegistrarComentario(@RequestParam("ip") String ip,
                                      @RequestParam("tipo") String tipo,
                                      @RequestParam("nombre") String nombre,
                                      @RequestParam("contenido") String contenido,Model model)
    {
        if(!validateComment(contenido)){
            Comentario c=new Comentario();
            c.setIpUser(ip);
            c.setTipo(tipo);
            c.setNombre(nombre);
            c.setContenido(contenido);

            service.Guardar(c);
            return "redirect:/";
        }
        List<Comentario> comentarios = service.ListarDes();
        model.addAttribute("comentarios",comentarios);
        model.addAttribute("vulgaridad","True");
        return "index";


    }

    public boolean validateComment(String comentario){
        boolean retorno = false;
        try {
            String urlString = "http://192.168.1.96:8000/?sentence="+comentario;
            urlString=urlString.replace(" ","%20");
            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            String res=result+"";
            String charsToRemove = "{} \":";

            for (char c : charsToRemove.toCharArray()) {
                res = res.replace(String.valueOf(c), "");
            }
            res=palabraEliminar(res, "IsVulgarity");
            System.out.println("Vulgaridad:"+res);
            retorno=Boolean.parseBoolean(res);
        }catch (Exception e){
            System.out.println("Error:"+e.toString());
        }


        return retorno;

    }
    public static String  palabraEliminar(String oracion,String palabra) {
        if(oracion.contains(palabra))
            return oracion.replaceAll(palabra, "");
        return oracion;
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
