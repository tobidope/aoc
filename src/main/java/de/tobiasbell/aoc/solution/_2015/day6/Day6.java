package de.tobiasbell.aoc.solution._2015.day6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day6 {
    static Map<Coordinate, Brightness> createGrid(List<Instruction> instructions) {
        final Map<Coordinate, Brightness> grid = new HashMap<>();
        for (var instruction : instructions) {
            final Coordinate from = instruction.from();
            final Coordinate to = instruction.to();
            for (int i = from.x(); i <= to.x(); i++) {
                for (int j = from.y(); j <= to.y(); j++) {
                    final Coordinate current = new Coordinate(i, j);
                    final Brightness brightness = grid.getOrDefault(current, Brightness.Off);
                    final Brightness newBrightness = instruction.command().evaluate(brightness);
                    grid.put(current, newBrightness);
                }
            }
        }
        return grid;
    }

    public static long solve1(final String input) {
        final List<Instruction> instructions = Stream.of(input.split("\\R"))
                .map(s -> Instruction.parse(s, Command::of))
                .collect(Collectors.toList());
        final Map<Coordinate, Brightness> grid = createGrid(instructions);
        return grid.values().stream()
                .filter(l -> l.equals(Brightness.On))
                .count();
    }

    public static long solve2(final String input) {
        final List<Instruction> instructions = Stream.of(input.split("\\R"))
                .map(s -> Instruction.parse(s, NewCommand::of))
                .collect(Collectors.toList());
        final Map<Coordinate, Brightness> grid = createGrid(instructions);
        return grid.values().stream()
                .mapToLong(Brightness::brightness)
                .sum();
    }
}


