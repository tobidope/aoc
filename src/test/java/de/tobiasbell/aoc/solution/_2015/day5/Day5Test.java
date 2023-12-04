package de.tobiasbell.aoc.solution._2015.day5;

import org.junit.jupiter.api.Test;

import static de.tobiasbell.aoc.TestConfig.testLoader;
import static org.assertj.core.api.Assertions.assertThat;

class Day5Test {
    private static final String INPUT = testLoader().loadInput(2015, 5);

    @Test
    void isNiceString() {
        assertThat(Day5.isNiceString("ugknbfddgicrmopn")).isTrue();
        assertThat(Day5.isNiceString("aaa")).isTrue();
        assertThat(Day5.isNiceString("jchzalrnumimnmhp")).isFalse();
        assertThat(Day5.isNiceString("haegwjzuvuyypxyu")).isFalse();
        assertThat(Day5.isNiceString("dvszwmarrgswjxmb")).isFalse();
    }

    @Test
    void solve1() {
        assertThat(Day5.solve1(INPUT)).isEqualTo(238L);
    }

    @Test
    void isNewNiceString() {
        assertThat(Day5.isNewNiceString("qjhvhtzxzqqjkmpb")).isTrue();
        assertThat(Day5.isNewNiceString("xxyxx")).isTrue();
        assertThat(Day5.isNewNiceString("uurcxstgmygtbstg")).isFalse();
        assertThat(Day5.isNewNiceString("ieodomkazucvgmuy")).isFalse();
    }

    @Test
    void solve2() {
        assertThat(Day5.solve2(INPUT)).isEqualTo(69L);
    }
}