package org.citein.app.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.citein.app.dto.ActividadDto;
import org.citein.app.service.ActividadService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actividad")
@RequiredArgsConstructor
public class ActividadController {
    
    private final ActividadService service;
    
    @GetMapping
    public List<ActividadDto> findAll() {
        return service.findAll();
    }
    
    @GetMapping("/{id}")
    public ActividadDto findById(@PathVariable Long id) {
        return service.findById(id);
    }
    
    @PostMapping
    public ActividadDto create(@RequestBody ActividadDto data) {       
        return service.create(data);
    }
    
    @PutMapping("/{id}")
    public ActividadDto update(@RequestBody ActividadDto data, @PathVariable Long id) {
        return service.update(data, id);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
