package org.citein.app.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.citein.app.dto.ActividadDto;
import org.citein.app.dto.DetalleDto;
import org.citein.app.models.Actividad;
import org.citein.app.models.Detalle;
import org.citein.app.repository.AtividadRepository;
import org.citein.app.repository.DetalleRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetalleService {
    
    private final DetalleRepository repository;
    private final AtividadRepository atividadRepository;
    
    public List<DetalleDto> findAll() {
        return repository.findAll()
                .stream()
                .map((model) -> DetalleDto.valueOf(model))
                .toList();
    }
    
    public DetalleDto findById(Long id) {
        Detalle model = repository.findById(id).orElseThrow();
        return DetalleDto.valueOf(model);
    }
    
    public DetalleDto create(DetalleDto data) {
        Actividad actividad = atividadRepository.findById(data.actividad().id()).orElseThrow();        
        Detalle model = Detalle.builder()
                .actividad(actividad)
                .descripcion(data.descripcion())
                .horarioInicio(data.horarioInicio())
                .horarioFin(data.horarioFin())
                .ponente(data.ponente())
                .salon(data.salon())
                .titulo(data.titulo())
                .build();
        
        return DetalleDto.valueOf(
                repository.save(model)
        );
    }
    
    public DetalleDto update(DetalleDto data, Long id) {
        Detalle model = repository.findById(id).orElseThrow();
        
        ActividadDto rawAct = data.actividad();
        if (rawAct != null) {
            Actividad actividad = atividadRepository.findById(data.actividad().id()).orElseThrow(); 
            model.setActividad(actividad);
        }
        
        model.setDescripcion(data.descripcion());
        model.setHorarioInicio(data.horarioInicio());
        model.setHorarioFin(data.horarioFin());
        model.setPonente(data.ponente());
        model.setSalon(data.salon());
        model.setTitulo(data.titulo());
        
        return DetalleDto.valueOf(
                repository.save(model)
        );
    }
    
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
