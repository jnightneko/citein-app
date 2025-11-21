package org.citein.app.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.citein.app.dto.DetalleDto;
import org.citein.app.service.DetalleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detalle")
@RequiredArgsConstructor
public class DetalleController {

    private final DetalleService service;
    
    @GetMapping
    public List<DetalleDto> findAll() {
        return service.findAll();
    }
    
    @GetMapping("/{id}")
    public DetalleDto findById(@PathVariable Long id) {
        return service.findById(id);
    }
    
    @PostMapping
    public DetalleDto create(@RequestBody DetalleDto data) {       
        return service.create(data);
    }
    
    @PutMapping("/{id}")
    public DetalleDto update(@RequestBody DetalleDto data, @PathVariable Long id) {
        return service.update(data, id);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
