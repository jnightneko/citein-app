package org.citein.app.dto;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDateTime;
import org.citein.app.models.Detalle;

public record DetalleDto(
    Long id,
    String titulo,
    String ponente,
    String salon,
    String descripcion,
    LocalDateTime horarioInicio,
    LocalDateTime horarioFin,
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    ActividadDto actividad
) {
    public static DetalleDto valueOf(Detalle model) {
        return new DetalleDto(
                model.getIdDetalle(),
                model.getTitulo(),
                model.getPonente(),
                model.getSalon(),
                model.getDescripcion(),
                model.getHorarioInicio(),
                model.getHorarioFin(),
                null
        );
    }
}
