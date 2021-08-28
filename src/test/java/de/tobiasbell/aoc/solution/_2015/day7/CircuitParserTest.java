package de.tobiasbell.aoc.solution._2015.day7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CircuitParserTest {

    @Test
    void parseExample() {
        final String input = """
                123 -> x
                456 -> y
                x AND y -> d
                x OR y -> e
                x LSHIFT 2 -> f
                y RSHIFT 2 -> g
                NOT x -> h
                NOT y -> i
                """;

        final WireTable wireTable = new CircuitParser().parse(Arrays.asList(input.split("\\R")));
        assertThat(wireTable.getWireNames())
                .hasSize(8)
                .containsExactlyInAnyOrder("d", "e", "f", "g", "h", "i", "x", "y");
        assertThat(wireTable.getWire("d").signal()).isEqualTo(72);
        assertThat(wireTable.getWire("e").signal()).isEqualTo(507);
        assertThat(wireTable.getWire("f").signal()).isEqualTo(492);
        assertThat(wireTable.getWire("g").signal()).isEqualTo(114);
        assertThat(wireTable.getWire("h").signal()).isEqualTo(65412);
        assertThat(wireTable.getWire("i").signal()).isEqualTo(65079);
        assertThat(wireTable.getWire("x").signal()).isEqualTo(123);
        assertThat(wireTable.getWire("y").signal()).isEqualTo(456);
    }
}