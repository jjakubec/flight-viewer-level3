package cz.cpost.flight.viewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Main application class for the Flight Viewer application.
 * This class serves as the entry point for the Spring Boot application.
 */
@SpringBootApplication
@EnableCaching
public class FlightViewerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightViewerApplication.class, args);
    }
}
