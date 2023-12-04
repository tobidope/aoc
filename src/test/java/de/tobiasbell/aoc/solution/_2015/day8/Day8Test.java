package de.tobiasbell.aoc.solution._2015.day8;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static de.tobiasbell.aoc.TestConfig.testLoader;
import static org.assertj.core.api.Assertions.assertThat;

class Day8Test {
    private static final String INPUT = testLoader().loadInput(2015, 8);

    @ParameterizedTest(name = "{index}: {0} length {1} in memory length {2}")
    @CsvSource({
            "\"\",            2, 0",
            "\"abc\",         5, 3",
            "\"aaa\\\"aaa\", 10, 7",
            "\"\\\",          3, 1",
            "\"\\x27\",       6, 1"
    })
    void inMemoryString(final @NotNull String input, int length, int inMemoryLength) {
        assertThat(input.length()).isEqualTo(length);
        assertThat(Day8.inMemoryString(input).length()).isEqualTo(inMemoryLength);
    }

    @ParameterizedTest(name = "{index}: {0} length {1} encoded length {2}")
    @CsvSource({
            "\"\",            2, 6",
            "\"abc\",         5, 9",
            "\"aaa\\\"aaa\", 10, 16",
            "\"\\x27\",       6, 11"
    })
    void encodedString(final @NotNull String input, int length, int encodedLength) {
        assertThat(input.length()).isEqualTo(length);
        assertThat(Day8.encodedStringLength(input)).isEqualTo(encodedLength);
    }

    @Test
    void solve1() {
        assertThat(Day8.solve1(INPUT)).isEqualTo(1350L);
    }

    @Test
    void solve2() {
        assertThat(Day8.solve2(INPUT)).isEqualTo(2085L);
    }
}