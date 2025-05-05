package cz.cpost.flight.viewer.provider;

import cz.cpost.flight.viewer.model.Departure;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Implementation of DepartureProvider that fetches flight departure data from a database.
 * This class is a placeholder and should be implemented with actual database access logic.
 */
@Component
public class DatabaseDepartureProvider implements DepartureProvider{

    /**
     * Fetches flight departure data from a database.
     * This method is a placeholder and should be implemented with actual database access logic.
     *
     * @param airport The airport code for which to fetch departure data.
     * @param begin   The start time for the data range (in seconds since epoch).
     * @param end     The end time for the data range (in seconds since epoch).
     * @return A Mono containing a list of Departure objects.
     */
    @Override
    public Mono<List<Departure>> getDepartures(String airport, String begin, String end) {
        // Implementation for reading from database
        return Mono.just(List.of(new Departure(/* Data from database */)));
    }
}
