package org.citein.app.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.citein.app.dto.ActividadDto;
import org.citein.app.models.Actividad;
import org.citein.app.repository.AtividadRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActividadService {
    
    private final AtividadRepository repository;
    
    public List<ActividadDto> findAll() {
        return repository.findAll()
                .stream()
                .map((model) -> ActividadDto.valueOf(model))
                .toList();
    }
    
    public ActividadDto findById(Long id) {
        Actividad model = repository.findById(id).orElseThrow();
        return ActividadDto.valueOf(model);
    }
    
    public ActividadDto create(ActividadDto data) {       
        Actividad model = Actividad.builder()
                .favorito(Boolean.FALSE)
                .nombre(data.nombre())
                .build();
        
        return ActividadDto.valueOf(
                repository.save(model)
        );
    }
    
    public ActividadDto update(ActividadDto data, Long id) {
        Actividad model = repository.findById(id).orElseThrow();
        model.setFavorito(Boolean.FALSE);
        model.setNombre(data.nombre());        
        return ActividadDto.valueOf(
                repository.save(model)
        );
    }
    
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
