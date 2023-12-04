package de.tobiasbell.aoc.solution._2015.day7;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Day7 {
    public static long solve1(@NotNull String input) {
        final WireTable table = new CircuitParser().parse(Arrays.asList(input.split("\\R")));
        return table.getWire("a").signal();
    }

    public static long solve2(@NotNull String input) {
        final WireTable table = new CircuitParser().parse(Arrays.asList(input.split("\\R")));
        final int signal = table.getWire("a")
                .signal();
        table.getWire("b")
                .setInput(new LiteralExpression(signal));
        table.reset();
        return table.getWire("a")
                .signal();
    }
}
