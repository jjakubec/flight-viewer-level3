package cz.cpost.flight.viewer.config;

import cz.cpost.flight.viewer.provider.DatabaseDepartureProvider;
import cz.cpost.flight.viewer.provider.DepartureProvider;
import cz.cpost.flight.viewer.provider.ExcelDepartureProvider;
import cz.cpost.flight.viewer.provider.OpenSkyDepartureProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for setting up the DepartureProvider bean.
 * This class allows for different implementations of DepartureProvider to be used based on the configuration.
 */
@Configuration
public class ProviderConfig {

    @Value("${opensky.api.url}")
    private String apiUrl;

    @Bean
    public DepartureProvider departureProvider(@Value("${provider.type}") String providerType) {
        return switch (providerType.toLowerCase()) {
            case "excel" -> new ExcelDepartureProvider();
            case "database" -> new DatabaseDepartureProvider();
            default -> new OpenSkyDepartureProvider(apiUrl);
        };
    }
}