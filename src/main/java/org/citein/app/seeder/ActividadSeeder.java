package org.citein.app.seeder;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.citein.app.dto.ActividadDto;
import org.citein.app.service.ActividadService;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import static org.citein.app.seeder.Command.*;

@Component
public class ActividadSeeder implements Seeder {
    private static final Logger LOGGER = Logger.getLogger(ActividadSeeder.class.getName());

    @Autowired
    private ActividadService service;

    @Override
    public void run() throws Exception {
        String[] actividades = {
            "Inteligencia Artificial aplicada",
            "De la idea al producto, proceso para crear productos digitales",
            "Ingenieros que programan IA: la nueva ventaja competitiva",
            "Automatización de despliegues AWS",
            "Seguridad Informática en la nube",
            "Gestión efectiva de proyectos de software"
        };

        for (final String nombre : actividades) {
            service.create(new ActividadDto(NULL, nombre, Boolean.FALSE, null));
            LOGGER.log(Level.INFO, () -> "Actividad creada: " + nombre);
        }
    }
}
