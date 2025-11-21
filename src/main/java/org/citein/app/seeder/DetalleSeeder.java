package org.citein.app.seeder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.citein.app.dto.DetalleDto;
import org.springframework.beans.factory.annotation.Autowired;

import org.citein.app.service.ActividadService;
import org.citein.app.service.DetalleService;
import org.springframework.stereotype.Component;
import static org.citein.app.seeder.Command.*;

@Component
public class DetalleSeeder implements Seeder {
    private static final Logger LOGGER = Logger.getLogger(ActividadSeeder.class.getName());

    @Autowired
    private ActividadService actividadService;
    @Autowired
    private DetalleService service;

    @Override
    public void run() throws Exception {
        DetalleDto[] detalles = {
            new DetalleDto(NULL,
                "2F, 2G (sistemas)",
                "Ing. Carlos Méndez",
                "CyT: Laboratorio Electricidad",
                "Introducción a la IA, Llevar laptop, al menos por cada dos personas",
                now("18/11/2025 08:30:00"),
                now("18/11/2025 13:00:00"),
                actividadService.findById(1L)
            ),
            new DetalleDto(NULL,
                "4E, 4D (sistemas)",
                "Ing. Mynor Peñate Navenik",
                "CyT: Laboratorio Telecomunicaciones",
                "Llevar laptop, al menos por cada dos personas",
                now("18/11/2025 08:30:00"),
                now("18/11/2025 13:00:00"),
                actividadService.findById(2L)
            ),
            new DetalleDto(NULL,
                "4F (sisremas)",
                "Ing. Dhaby Xiloj",
                "Laboratorio Electrónica",
                "Llevar laptop, al menos por cada dos personas",
                now("18/11/2025 08:30:00"),
                now("18/11/2025 13:00:00"),
                actividadService.findById(3L)
            ),
            new DetalleDto(NULL,
                "6E_S",
                "Ing. Dennys Tezan",
                "CyT: Laboratorio Electricidad",
                "Llevar laptop",
                now("18/11/2025 08:30:00"),
                now("18/11/2025 13:00:00"),
                actividadService.findById(4L)
            ),
            new DetalleDto(NULL,
                "6D_S",
                "Ing. Eliud Colindres",
                "Aula E2-11",
                "Llevar laptop",
                now("18/11/2025 08:30:00"),
                now("18/11/2025 13:00:00"),
                actividadService.findById(5L)
            ),
            new DetalleDto(NULL,
                "8E_S",
                "Ing. Victor Hernandez Navenik",
                "Aula E2-9",
                "Llevar laptop",
                now("18/11/2025 08:30:00"),
                now("18/11/2025 13:00:00"),
                actividadService.findById(6L)
            )
        };

        for (DetalleDto dto : detalles) {
            service.create(dto);
            LOGGER.log(Level.INFO, () -> "Detalle creada: " + dto.toString());
        }
    }

    private LocalDateTime now(String horario) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return LocalDateTime.parse(horario, formatter);
    }
}
