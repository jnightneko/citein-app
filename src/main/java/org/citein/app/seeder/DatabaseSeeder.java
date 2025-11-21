package org.citein.app.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private ActividadSeeder actividadesSeeder;
    @Autowired
    private DetalleSeeder detalleSeeder;
    
    @Override
    public void run(String... args) throws Exception {
        for (String command : args) {
            if (command == null || command.isEmpty()) {
                continue;
            }
            
            if ("--migrate".equals(command)) {
                actividadesSeeder.run();
                detalleSeeder.run();
                break;
            }
        }
    }
}
