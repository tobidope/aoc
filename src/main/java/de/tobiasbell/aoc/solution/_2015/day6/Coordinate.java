package de.tobiasbell.aoc.solution._2015.day6;

public record Coordinate(int x, int y) {
    public static Coordinate parse(final String coordinate) {
        final String[] split = coordinate.split(",");
        return new Coordinate(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }
}
