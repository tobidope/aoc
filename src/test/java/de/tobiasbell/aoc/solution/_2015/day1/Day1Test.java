package de.tobiasbell.aoc.solution._2015.day1;

import org.junit.jupiter.api.Test;

import static de.tobiasbell.aoc.TestConfig.testLoader;
import static org.assertj.core.api.Assertions.assertThat;

class Day1Test {
    private static final String INPUT = testLoader().loadInput(2015, 1);

    @Test
    void equalClosingAndOpeningBracesAreFloor0() {
        assertThat(Day1.solve1("(())")).isEqualTo(0);
        assertThat(Day1.solve1("(())")).isEqualTo(0);
    }

    @Test
    void aboveBasement() {
        assertThat(Day1.solve1("))(((((")).isEqualTo(3);
    }

    @Test
    void solveDay1_1() {
        assertThat(Day1.solve1(INPUT)).isEqualTo(138);
    }

    @Test
    void findeBasement() {
        assertThat(Day1.solve2(")")).isEqualTo(1);
        assertThat(Day1.solve2("()())")).isEqualTo(5);
    }

    @Test
    void solveDay1_2() {
        assertThat(Day1.solve2(INPUT)).isEqualTo(1771);
    }
}