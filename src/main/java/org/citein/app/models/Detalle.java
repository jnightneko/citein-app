package org.citein.app.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Detalle")
@Table(name = "Detalle")
public class Detalle {
    @Id    
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Long idDetalle;    
    private String titulo;    
    private String ponente;
    private String salon;
    private String descripcion;
    
    private LocalDateTime horarioInicio;
    private LocalDateTime horarioFin;
    
    @ManyToOne
    @JoinColumn(name = "idActividad", referencedColumnName = "idActividad")
    private Actividad actividad;    
}
