package de.tobiasbell.aoc.solution._2023;

import de.tobiasbell.aoc.solution._2023.util.Coordinate;
import org.junit.jupiter.api.Test;

import static de.tobiasbell.aoc.TestConfig.testLoader;
import static org.assertj.core.api.Assertions.assertThat;

class Day3Test {
    public static final String EXAMPLE = """
            467..114..
            ...*......
            ..35..633.
            ......#...
            617*......
            .....+.58.
            ..592.....
            ......755.
            ...$.*....
            .664.598..
            """;
    private static final String INPUT = testLoader().loadInput(2023, 3);

    @Test
    void parseSchematic() {
        final var schematic = Day3.parseSchematic(EXAMPLE);
        assertThat(schematic.symbols())
                .hasSize(6)
                .containsKey(new Coordinate(3, 1));
    }

    @Test
    void extractePartNumbers() {
        final var schematic = Day3.parseSchematic(EXAMPLE);
        final var partNumbers = schematic.extractPartNumbers();
        assertThat(partNumbers)
                .contains(467, 35)
                .doesNotContain(114, 58);
    }

    @Test
    void solve1() {
        assertThat(Day3.solve1(EXAMPLE)).isEqualTo(4361);
        assertThat(Day3.solve1(INPUT)).isEqualTo(536576L);
    }

    @Test
    void solve2() {
        assertThat(Day3.solve2(EXAMPLE)).isEqualTo(467835);
        assertThat(Day3.solve2(INPUT)).isEqualTo(75741499L);
    }
}