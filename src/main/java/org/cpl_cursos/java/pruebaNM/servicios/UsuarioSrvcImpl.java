package org.cpl_cursos.java.pruebaNM.servicios;

import org.cpl_cursos.java.pruebaNM.DAOs.IfxUsuarioDAO;
import org.cpl_cursos.java.pruebaNM.modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioSrvcImpl implements IfxUsuarioSrvc{
    @Autowired
    private IfxUsuarioDAO usuDAO;

    @Override
    public List<Usuario> listaUsuarios() {
        List<Usuario> listausus = usuDAO.findAll();
        return listausus;
    }

    @Override
    public List<Usuario> listaSeguidores(Long id) {
        Optional<Usuario> usu = usuDAO.findById(id);
        List<Usuario> lista = new ArrayList<>();
        if(usu.isPresent()) {
            lista = usu.get().getSeguidoPor();
        }
        return lista;
    }

    @Override
    public List<Usuario> listaSeguidos(Long id) {
        Optional<Usuario> usu = usuDAO.findById(id);
        List<Usuario> lista = new ArrayList<>();
        if(usu.isPresent()) {
            lista = usu.get().getSigueA();
        }
        return lista;
    }

    @Override
    public List<Usuario> listaOtros(Long id) {
        return new ArrayList<>();
    }

    @Override
    public Optional<Usuario> buscaId(Long id) {
        return usuDAO.findById(id);
    }
}
