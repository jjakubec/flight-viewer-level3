package cz.cpost.flight.viewer.provider;

import cz.cpost.flight.viewer.model.Departure;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.Arrays;
import java.util.List;

/**
 * Implementation of DepartureProvider that fetches flight departure data from the OpenSky Network API.
 * This class uses WebClient for making HTTP requests and caching the results.
 */
@Component
public class OpenSkyDepartureProvider implements DepartureProvider {

    private final WebClient webClient;

    public OpenSkyDepartureProvider(@Value("${opensky.api.url}") String apiUrl) {
        this.webClient = WebClient.builder()
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(10485760))
                .baseUrl(apiUrl)
                .build();
    }

    /**
     * Fetches flight departure data from the OpenSky Network API using WebClient.
     * This method is cached to improve performance.
     *
     * @param airport The airport code for which to fetch departure data.
     * @param begin   The start time for the data range (in seconds since epoch).
     * @param end     The end time for the data range (in seconds since epoch).
     * @return A Mono containing a list of Departure objects.
     */
    @Override
    @Cacheable(value = "departuresCache", key = "#airport + #begin + #end")
    public Mono<List<Departure>> getDepartures(String airport, String begin, String end) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.queryParam("airport", airport)
                        .queryParam("begin", begin)
                        .queryParam("end", end)
                        .build())
                .retrieve()
                .bodyToMono(Departure[].class)
                .map(Arrays::asList);
    }
}