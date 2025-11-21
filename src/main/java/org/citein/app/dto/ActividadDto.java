package org.citein.app.dto;

import java.util.ArrayList;
import java.util.List;
import org.citein.app.models.Actividad;
import org.citein.app.models.Detalle;

public record ActividadDto(
    Long id,
    String nombre,
    Boolean favorito,
    List<DetalleDto> detalles
) {

    public static ActividadDto valueOf(Actividad model) {
        List<Detalle> listModels = model.getDetalles();
        List<DetalleDto> list = new ArrayList<>();
        
        if (listModels != null && !listModels.isEmpty()) {
            list.addAll(listModels.stream()
                    .map((value) -> DetalleDto.valueOf(value))
                    .toList());
        }
        return new ActividadDto(model.getIdActividad(), model.getNombre(), model.getFavorito(), list);
    }
}
