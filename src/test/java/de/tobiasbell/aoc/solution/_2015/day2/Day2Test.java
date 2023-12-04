package de.tobiasbell.aoc.solution._2015.day2;

import org.junit.jupiter.api.Test;

import static de.tobiasbell.aoc.TestConfig.testLoader;
import static org.assertj.core.api.Assertions.assertThat;

class Day2Test {
    private static final String INPUT = testLoader().loadInput(2015, 2);

    @Test
    void boxParsing() {
        assertThat(Day2.Box.of("2x3x4"))
                .isEqualTo(new Day2.Box(2, 3, 4));
    }

    @Test
    void surfaceArea() {
        final Day2.Box box = Day2.Box.of("2x3x4");
        assertThat(box.wrappingPaperNeeded()).isEqualTo(58);
    }

    @Test
    void solve1() {
        assertThat(Day2.solve1(INPUT)).isEqualTo(1598415);
    }

    @Test
    void ribbonLength() {
        assertThat(Day2.Box.of("2x3x4").ribbonNeeded()).isEqualTo(34);
        assertThat(Day2.Box.of("1x1x10").ribbonNeeded()).isEqualTo(14);
    }

    @Test
    void solve2() {
        assertThat(Day2.solve2(INPUT)).isEqualTo(3812909L);
    }
}