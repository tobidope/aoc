package de.tobiasbell.aoc.solution._2015.day3;


import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day3 {
    public static int visitedHouses(final @NotNull String directions) {
        final Set<Point> points = visitedHouseCoordinates(directions);
        return points.size();
    }

    public static int solve2(final @NotNull String directions) {
        String santaDirections = santaDirections(directions);
        String roboSantaDirections = roboSantaDirections(directions);
        final Set<Point> santaHouses = visitedHouseCoordinates(santaDirections);
        santaHouses.addAll(visitedHouseCoordinates(roboSantaDirections));

        return santaHouses.size();
    }

    private static @NotNull String roboSantaDirections(@NotNull String directions) {
        final StringBuilder builder = new StringBuilder();
        for (int i = 1; i < directions.length(); i += 2) {
            builder.append(directions.charAt(i));
        }
        return builder.toString();
    }

    private static @NotNull String santaDirections(@NotNull String directions) {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < directions.length(); i += 2) {
            builder.append(directions.charAt(i));
        }
        return builder.toString();
    }

    private static @NotNull Set<Point> visitedHouseCoordinates(@NotNull String directions) {
        final List<Move> moves = directions.chars()
                .mapToObj(c -> Move.of((char) c)).toList();
        final Iterator<Move> iterator = moves.iterator();
        return Stream.iterate(new Point(0, 0),
                        point -> point.add(iterator.next().getDirection()))
                .limit(moves.size() + 1)
                .collect(Collectors.toSet());
    }

    public enum Move {
        NORTH('^', Point.of(1, 0)),
        SOUTH('v', Point.of(-1, 0)),
        EAST('>', Point.of(0, 1)),
        WEST('<', Point.of(0, -1));

        private final char move;
        private final Point direction;

        Move(char move, Point direction) {
            this.move = move;
            this.direction = direction;
        }

        public static Move of(final char c) {
            return Arrays.stream(Move.values())
                    .filter(m -> m.move == c)
                    .findAny()
                    .orElseThrow(() -> new IllegalArgumentException("Unknown Move " + c));
        }

        public Point getDirection() {
            return direction;
        }
    }

    public record Point(int x, int y) {

        public static @NotNull Point of(int x, int y) {
            return new Point(x, y);
        }

        public @NotNull Point add(final @NotNull Point other) {
            return new Point(this.x + other.x(),
                    this.y + other.y());
        }
    }
}
