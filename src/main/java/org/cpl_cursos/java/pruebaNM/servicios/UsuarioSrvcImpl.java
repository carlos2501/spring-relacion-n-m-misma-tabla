package org.cpl_cursos.java.pruebaNM.servicios;

import org.cpl_cursos.java.pruebaNM.DAOs.UsuarioDAO;
import org.springframework.stereotype.Service;

@Service
public class UsuarioSrvc {
    private final UsuarioDAO repo;

    public UsuarioSrvc(UsuarioDAO repo) {
        this.repo = repo;
    }
}
