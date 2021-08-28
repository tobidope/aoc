package de.tobiasbell.aoc.solution._2015.day6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;

import static de.tobiasbell.aoc.TestConfig.testLoader;
import static org.assertj.core.api.Assertions.assertThat;

class Day6Test {
    private static final String INPUT = testLoader().loadInput(2015, 6);

    @Test
    void parseInstruction() {
        assertThat(Instruction.parse("turn on 0,0 through 999,999", Command::of))
                .isEqualTo(new Instruction(
                        Command.TurnOn,
                        new Coordinate(0, 0),
                        new Coordinate(999, 999)));
    }

    @Test
    void evaluateBrightness() {
        assertThat(Command.TurnOn.evaluate(Brightness.Off))
                .isEqualTo(Brightness.On);
        assertThat(Command.Toggle.evaluate(Brightness.Off))
                .isEqualTo(Brightness.On);
        assertThat(Command.Toggle.evaluate(Brightness.On))
                .isEqualTo(Brightness.Off);
    }

    @Test
    void createGrid() {
        final Instruction instruction = Instruction.parse("turn on 0,0 through 2,2", Command::of);
        final Map<Coordinate, Brightness> grid = Day6.createGrid(Collections.singletonList(instruction));

        Assertions.assertThat(grid)
                .hasSize(9)
                .allSatisfy((coordinate, brightness) -> assertThat(brightness).isEqualTo(Brightness.On));
    }

    @Test
    void solve1() {
        assertThat(Day6.solve1(INPUT)).isEqualTo(543903L);
    }

    @Test
    void solve2() {
        assertThat(Day6.solve2(INPUT)).isEqualTo(14687245L);
    }

}