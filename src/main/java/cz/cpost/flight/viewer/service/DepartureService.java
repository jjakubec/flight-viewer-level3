package cz.cpost.flight.viewer.service;

import cz.cpost.flight.viewer.model.Departure;
import cz.cpost.flight.viewer.provider.DepartureProvider;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.util.List;

/**
 * Service for fetching flight departure data.
 * This service uses a DepartureProvider to retrieve data from the OpenSky Network API.
 */
@Service
public class DepartureService {

    private final DepartureProvider departureProvider;

    public DepartureService(DepartureProvider departureProvider) {
        this.departureProvider = departureProvider;
    }

    public Mono<List<Departure>> getDepartures(String airport, String begin, String end) {
        return departureProvider.getDepartures(airport, begin, end);
    }
}
