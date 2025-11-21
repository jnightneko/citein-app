package org.citein.app.repository;

import org.citein.app.models.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtividadRepository extends JpaRepository<Actividad, Long> {
    
}
