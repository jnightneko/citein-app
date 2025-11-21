package org.citein.app.repository;

import org.citein.app.models.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleRepository extends JpaRepository<Detalle, Long> {
    
}
