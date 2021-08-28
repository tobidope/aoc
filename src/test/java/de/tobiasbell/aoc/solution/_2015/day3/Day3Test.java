package de.tobiasbell.aoc.solution._2015.day3;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static de.tobiasbell.aoc.TestConfig.testLoader;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Day3Test {
    private static final String INPUT = testLoader().loadInput(2015, 3);

    @Test
    void moveParsing() {
        assertThat(Day3.Move.of('^')).isEqualTo(Day3.Move.NORTH);
        assertThrows(IllegalArgumentException.class, () -> Day3.Move.of(' '));
    }

    @Test
    void addPoints() {
        assertThat(Day3.Point.of(0, 0).add(Day3.Point.of(1, 1)))
                .isEqualTo(Day3.Point.of(1, 1));
    }

    @Test
    void visitedHouses() {
        assertThat(Day3.visitedHouses(">")).isEqualTo(2);
        assertThat(Day3.visitedHouses("^>v<")).isEqualTo(4);
        assertThat(Day3.visitedHouses("^v^v^v^v^v")).isEqualTo(2);
    }

    @Test
    void solve1() throws IOException {
        assertThat(Day3.visitedHouses(INPUT)).isEqualTo(2565);
    }

    @Test
    void solve2() throws IOException {
        assertThat(Day3.solve2(INPUT)).isEqualTo(2639);
    }
}