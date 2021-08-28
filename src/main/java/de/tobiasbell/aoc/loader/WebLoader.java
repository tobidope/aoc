package de.tobiasbell.aoc.loader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Objects;

public class WebLoader implements Loader {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebLoader.class);
    private final String baseUrl;
    private final String sessionId;
    private final HttpClient httpClient;

    private WebLoader(String sessionId) {
        this("https://adventofcode.com", sessionId);
    }

    private WebLoader(String baseUrl, String sessionId) {
        this.baseUrl = baseUrl;
        this.sessionId = sessionId;
        this.httpClient = HttpClient.newHttpClient();
    }

    public static WebLoader withSession(String sessionId) {
        return new WebLoader(Objects.requireNonNull(sessionId));
    }

    public static WebLoader withBaseUrl(String baseUrl, String sessionId) {
        return new WebLoader(baseUrl, sessionId);
    }

    private HttpRequest createRequest(int year, int day, final String method) {
        final URI uri = URI.create(baseUrl + "/" + year + "/day/" + day + "/input");
        return HttpRequest.newBuilder(uri)
                .timeout(Duration.ofSeconds(10))
                .method(method, HttpRequest.BodyPublishers.noBody())
                .setHeader("Cookie", "session=" + sessionId)
                .build();
    }

    @Override
    public String loadInput(int year, int day) {
        final HttpRequest request = createRequest(year, day, "GET");
        LOGGER.info("Calling URL {}", request.uri());
        try {
            final HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
            return response.body();
        } catch (final IOException e) {
            throw new UncheckedIOException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean hasInput(int year, int day) {
        final HttpRequest request = createRequest(year, day, "HEAD");
        LOGGER.info("Calling URL {}", request.uri());
        try {
            final HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
            return response.statusCode() == HttpURLConnection.HTTP_OK;
        } catch (final IOException e) {
            throw new UncheckedIOException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
