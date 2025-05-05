package cz.cpost.flight.viewer.provider;

import cz.cpost.flight.viewer.model.Departure;
import reactor.core.publisher.Mono;
import java.util.List;

public interface DepartureProvider {
    Mono<List<Departure>> getDepartures(String airport, String begin, String end);
}

