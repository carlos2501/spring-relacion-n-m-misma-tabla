package org.cpl_cursos.java.pruebaNM.controladores;

import org.cpl_cursos.java.pruebaNM.modelos.Usuario;
import org.cpl_cursos.java.pruebaNM.servicios.UsuarioSrvcImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class UsuarioCtrl {

    @Autowired
    private UsuarioSrvcImpl usuSrvc;

    @GetMapping({"","/","/home"})
    public String inicio(Model modelo) {
        modelo.addAttribute("titulo", "Página de inicio de relaciones N:M");
        return "index";
    }

    @GetMapping({"{id}","/{id}","home/{id}"})
    public String inicio2(@PathVariable(value="id") Long id, Model modelo) {
        Usuario usuario = null;
        if(id>0) {
            Optional<Usuario> usu = usuSrvc.buscaId(id);
            if (usu.isPresent()) {
                usuario = usu.get();
            } else
                usuario = usuSrvc.buscaId(1L).get();
        } else {
            return "redirect:/";
        }
        modelo.addAttribute("titulo", "Página de inicio de relaciones N:M");
        modelo.addAttribute("seguidores", usuSrvc.listaSeguidores(id));
        modelo.addAttribute("usuactivo", usuario);
        modelo.addAttribute("seguidos", usuSrvc.listaSeguidos(id));
        return "index";
    }

    @PostMapping("/buscaUsuario")
    public String buscaUsuario( @RequestParam("idusuario") Long id, Model modelo) {

        System.out.println("El usuarios a buscar es el "+id);
        return "redirect:/" + id;
    }

}
