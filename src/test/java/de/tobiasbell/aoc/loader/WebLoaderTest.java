package de.tobiasbell.aoc.loader;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

@WireMockTest
class WebLoaderTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        final String sessionId = "xxx";
        final WebLoader webLoader = WebLoader.withSession(sessionId);
        final String input = webLoader.loadInput(2020, 20);
        System.out.println(input);
    }

    @Test
    void callsCorrectUrl(WireMockRuntimeInfo wmRuntimeInfo) throws IOException, InterruptedException {
        // given
        final WebLoader webLoader = WebLoader.withBaseUrl(wmRuntimeInfo.getHttpBaseUrl(), "sessionId");
        // when
        webLoader.loadInput(2015, 1);
        //then
        verify(getRequestedFor(urlEqualTo("/2015/day/1/input")));
    }

    @Test
    void downloadsData(WireMockRuntimeInfo wmRuntimeInfo) throws IOException, InterruptedException {
        // given
        final WireMock wireMock = wmRuntimeInfo.getWireMock();
        final WebLoader webLoader = WebLoader.withBaseUrl(wmRuntimeInfo.getHttpBaseUrl(), "sessionId");
        wireMock.stubFor(WireMock.get(urlEqualTo("/2015/day/1/input"))
                .willReturn(ok("input")));
        // when
        final String result = webLoader.loadInput(2015, 1);
        //then
        assertThat(result).isEqualTo("input");
    }

    @Test
    void sendsAuthenticationCookie(WireMockRuntimeInfo wmRuntimeInfo) throws IOException, InterruptedException {
        // given
        final WireMock wireMock = wmRuntimeInfo.getWireMock();
        final WebLoader webLoader = WebLoader.withBaseUrl(wmRuntimeInfo.getHttpBaseUrl(), "sessionId");
        // when
        webLoader.loadInput(2015, 1);
        //then
        wireMock.verify(anyRequestedFor(anyUrl())
                .withCookie("session", matching("sessionId")));
    }
}