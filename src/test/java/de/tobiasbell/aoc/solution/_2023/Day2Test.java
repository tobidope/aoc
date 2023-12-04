package de.tobiasbell.aoc.solution._2023;

import de.tobiasbell.aoc.solution._2023.util.CubeGame;
import de.tobiasbell.aoc.solution._2023.util.CubeSet;
import org.junit.jupiter.api.Test;

import java.util.List;

import static de.tobiasbell.aoc.TestConfig.testLoader;
import static org.assertj.core.api.Assertions.assertThat;

class Day2Test {

    public static final String EXAMPLE = """
            Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
            Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
            Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
            Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
            Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
            """;
    private static final String INPUT = testLoader().loadInput(2023, 2);

    @Test
    void parseCubeSet() {
        final var cubeSet = Day2.parseCubeSet("3 blue, 4 red");

        assertThat(cubeSet).isEqualTo(new CubeSet(3, 0, 4));
    }

    @Test
    void parseGame() {
        final var game = Day2.parseGame("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue");

        assertThat(game).isEqualTo(new CubeGame(2, List.of(
                new CubeSet(1, 2, 0),
                new CubeSet(4, 3, 1),
                new CubeSet(1, 1, 0)
        )));

    }

    @Test
    void solve1() {
        var solution = Day2.solve1(EXAMPLE);

        assertThat(solution).isEqualTo(8);

        solution = Day2.solve1(INPUT);

        assertThat(solution).isEqualTo(2268L);

    }

    @Test
    void solve2() {
        var solution = Day2.solve2(EXAMPLE);

        assertThat(solution).isEqualTo(2286);

        solution = Day2.solve2(INPUT);

        assertThat(solution).isEqualTo(63542L);
    }
}