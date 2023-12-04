package de.tobiasbell.aoc.solution._2015.day6;

import org.jetbrains.annotations.NotNull;

public record Coordinate(int x, int y) {
    public static @NotNull Coordinate parse(final @NotNull String coordinate) {
        final String[] split = coordinate.split(",");
        return new Coordinate(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }
}
