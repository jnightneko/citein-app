package org.citein.app.system;

import java.util.Arrays;
import java.util.logging.Logger;
import lombok.RequiredArgsConstructor;
import org.citein.app.seeder.ActividadSeeder;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@RequiredArgsConstructor
public class WebSecurityConfig implements WebMvcConfigurer {
    private static final Logger LOGGER = Logger.getLogger(ActividadSeeder.class.getName());
    private final CORSHost corsHost;
        
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String[] hosts = corsHost.getHost().split(" ");
        for (int i = 0; i < hosts.length; i++) {
            hosts[i] = hosts[i].trim();
        }
        
        String[] methods = corsHost.getMethods().toArray(String[]::new);
        registry.addMapping("/**")
                .allowedMethods(methods)
                .allowedHeaders("*")
                .allowedOrigins(hosts);
        
        LOGGER.info(() -> "Hosts: " + Arrays.toString(hosts));
        LOGGER.info(() ->"Methods: " + Arrays.toString(methods));
    }
}
