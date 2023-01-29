package org.cpl_cursos.java.pruebaNM.servicios;

import org.cpl_cursos.java.pruebaNM.modelos.Usuario;

import java.util.List;
import java.util.Optional;

public interface IfxUsuarioSrvc {
    List<Usuario> listaUsuarios();
    List<Usuario> listaSeguidores(Long id);
    List<Usuario> listaSeguidos(Long id);
    List<Usuario> listaOtros(Long id);
    Optional<Usuario> buscaId(Long id);
}
