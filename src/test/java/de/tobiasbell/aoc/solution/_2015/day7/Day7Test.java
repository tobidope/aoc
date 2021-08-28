package de.tobiasbell.aoc.solution._2015.day7;

import org.junit.jupiter.api.Test;

import static de.tobiasbell.aoc.TestConfig.testLoader;
import static org.assertj.core.api.Assertions.assertThat;

class Day7Test {
    private static final String INPUT = testLoader().loadInput(2015, 7);

    @Test
    void solve1() {
        final long result = Day7.solve1(INPUT);
        assertThat(result).isEqualTo(16076L);
    }

    @Test
    void solve2() {
        final long result = Day7.solve2(INPUT);
        assertThat(result).isEqualTo(2797L);
    }
}