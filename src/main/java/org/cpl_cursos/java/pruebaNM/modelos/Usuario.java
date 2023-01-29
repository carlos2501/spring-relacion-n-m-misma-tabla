package org.cpl_cursos.java.pruebaNM.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
// ver https://projectlombok.org/features/Data para la anotación siguiente
@Data
@NoArgsConstructor
@Table(name="Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String nombre;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name="seguidores",
        joinColumns=@JoinColumn(name="idSeguidor"),
        inverseJoinColumns = @JoinColumn(name="idSeguido"))
    private List<Usuario> sigueA;  // los que siguen al usuario

    @ManyToMany (mappedBy = "sigueA",fetch = FetchType.LAZY)
    private List<Usuario> seguidoPor;  // a los que sigue el usuario

    @Override
    public String toString() {
        return idUsuario + " - " + nombre;
    }

}
