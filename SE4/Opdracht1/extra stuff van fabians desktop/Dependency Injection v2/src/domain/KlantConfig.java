package domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
public class KlantConfig {
    @Bean String setVerhuurderNaam() {
        return "Verhuuder - Nieuwe naam";
    }

    @Bean String setHuurderNaam() {
        return "Huurder - Nieuwe naam";
    }
}
