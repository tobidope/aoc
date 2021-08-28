package de.tobiasbell.aoc.loader;

import com.github.tomakehurst.wiremock.client.WireMock;
import de.mkammerer.wiremock.WireMockExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

class WebLoaderTest {
    @RegisterExtension
    WireMockExtension wireMock = new WireMockExtension();

    public static void main(String[] args) throws IOException, InterruptedException {
        final String sessionId = "xxx";
        final WebLoader webLoader = WebLoader.withSession(sessionId);
        final String input = webLoader.loadInput(2020, 20);
        System.out.println(input);
    }

    @Test
    void callsCorrectUrl() throws IOException, InterruptedException {
        // given
        final WebLoader webLoader = WebLoader.withBaseUrl(wireMock.baseUrl(), "sessionId");
        // when
        webLoader.loadInput(2015, 1);
        //then
        wireMock.verify(getRequestedFor(urlEqualTo("/2015/day/1/input")));
    }

    @Test
    void downloadsData() throws IOException, InterruptedException {
        // given
        final WebLoader webLoader = WebLoader.withBaseUrl(wireMock.baseUrl(), "sessionId");
        wireMock.stubFor(WireMock.get(urlEqualTo("/2015/day/1/input"))
                .willReturn(ok("input")));
        // when
        final String result = webLoader.loadInput(2015, 1);
        //then
        assertThat(result).isEqualTo("input");
    }

    @Test
    void sendsAuthenticationCookie() throws IOException, InterruptedException {
        // given
        final WebLoader webLoader = WebLoader.withBaseUrl(wireMock.baseUrl(), "sessionId");
        // when
        webLoader.loadInput(2015, 1);
        //then
        wireMock.verify(anyRequestedFor(anyUrl())
                .withCookie("session", matching("sessionId")));
    }
}