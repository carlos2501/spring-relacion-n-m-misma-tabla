package modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Usuario {

    @Id
    private Long id;

    @ManyToMany
    List<Usuario> seguidores;

    @ManyToMany
    List<Usuario> seguidos;
}
