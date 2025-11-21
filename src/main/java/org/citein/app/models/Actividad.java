package org.citein.app.models;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Actividad")
@Table(name = "Actividad")
public class Actividad {
    @Id    
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Long idActividad;    
    private String nombre;    
    private Boolean favorito;
    
    @OneToMany(
        mappedBy = "actividad",
        cascade = CascadeType.ALL,
        fetch = FetchType.EAGER
    )
    private List<Detalle> detalles;
}
