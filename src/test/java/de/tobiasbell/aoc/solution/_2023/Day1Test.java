package de.tobiasbell.aoc.solution._2023;

import org.junit.jupiter.api.Test;

import static de.tobiasbell.aoc.TestConfig.testLoader;
import static org.assertj.core.api.Assertions.assertThat;

class Day1Test {

    private static final String INPUT = testLoader().loadInput(2023, 1);

    @Test
    void solve1() {
        final String example = """
                1abc2
                pqr3stu8vwx
                a1b2c3d4e5f
                treb7uchet
                """;
        assertThat(Day1.solve1(example))
                .isEqualTo(142);

        assertThat(Day1.solve1(INPUT))
                .isEqualTo(53974L);
    }

    @Test
    void solve2() {
        final String example = """
                two1nine
                eightwothree
                abcone2threexyz
                xtwone3four
                4nineeightseven2
                zoneight234
                7pqrstsixteen
                """;
        assertThat(Day1.solve2(example))
                .isEqualTo(281);

        assertThat(Day1.solve2(INPUT))
                .isEqualTo(52840L);

    }
}