package de.tobiasbell.aoc.loader;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.anyRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.anyUrl;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.matching;
import static com.github.tomakehurst.wiremock.client.WireMock.ok;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.verify;
import static org.assertj.core.api.Assertions.assertThat;

@WireMockTest
class WebLoaderTest {

    public static void main(String[] args) {
        final String sessionId = "xxx";
        final WebLoader webLoader = WebLoader.withSession(sessionId);
        final String input = webLoader.loadInput(2020, 20);
        System.out.println(input);
    }

    @Test
    void callsCorrectUrl(@NotNull WireMockRuntimeInfo wmRuntimeInfo) {
        // given
        final WebLoader webLoader = WebLoader.withBaseUrl(wmRuntimeInfo.getHttpBaseUrl(), "sessionId");
        // when
        webLoader.loadInput(2015, 1);
        //then
        verify(getRequestedFor(urlEqualTo("/2015/day/1/input")));
    }

    @Test
    void downloadsData(@NotNull WireMockRuntimeInfo wmRuntimeInfo) {
        // given
        final WebLoader webLoader = WebLoader.withBaseUrl(wmRuntimeInfo.getHttpBaseUrl(), "sessionId");
        stubFor(WireMock.get(urlEqualTo("/2015/day/1/input"))
                .willReturn(ok("input")));
        // when
        final String result = webLoader.loadInput(2015, 1);
        //then
        assertThat(result).isEqualTo("input");
    }

    @Test
    void sendsAuthenticationCookie(@NotNull WireMockRuntimeInfo wmRuntimeInfo) {
        // given
        final WebLoader webLoader = WebLoader.withBaseUrl(wmRuntimeInfo.getHttpBaseUrl(), "sessionId");
        // when
        webLoader.loadInput(2015, 1);
        //then
        verify(anyRequestedFor(anyUrl())
                .withCookie("session", matching("sessionId")));
    }
}