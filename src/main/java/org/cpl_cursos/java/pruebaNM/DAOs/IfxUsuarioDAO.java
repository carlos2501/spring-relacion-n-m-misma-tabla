package org.cpl_cursos.java.pruebaNM.DAOs;

import org.cpl_cursos.java.pruebaNM.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IfxUsuarioDAO extends JpaRepository<Usuario, Long> {
}
