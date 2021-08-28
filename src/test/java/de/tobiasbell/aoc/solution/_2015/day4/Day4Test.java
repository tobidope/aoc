package de.tobiasbell.aoc.solution._2015.day4;

import org.junit.jupiter.api.Test;

import static de.tobiasbell.aoc.TestConfig.testLoader;
import static org.assertj.core.api.Assertions.assertThat;

class Day4Test {
    private static final String INPUT = testLoader().loadInput(2015, 4);

    @Test
    void solve1() {
        assertThat(Day4.solve1("abcdef")).isEqualTo(609043);
        assertThat(Day4.solve1("pqrstuv")).isEqualTo(1048970);
        assertThat(Day4.solve1("yzbqklnj")).isEqualTo(282749);
    }

    @Test
    void solve2() {
        assertThat(Day4.solve2("yzbqklnj")).isEqualTo(9962624);
    }
}