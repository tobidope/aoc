package de.tobiasbell.aoc.solution._2015.day2;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Stream;

public class Day2 {
    public static long solve1(final @NotNull String input) {
        return boxes(input)
                .mapToLong(Box::wrappingPaperNeeded)
                .sum();
    }

    private static @NotNull Stream<Box> boxes(@NotNull String input) {
        return Stream.of(input.split("\\R"))
                .map(Box::of);
    }

    public static long solve2(@NotNull String input) {
        return boxes(input)
                .mapToLong(Box::ribbonNeeded)
                .sum();
    }


    public record Box(long length, long height, long width) {
        public static @NotNull Box of(final @NotNull String input) {
            final List<Integer> dimensions = Stream.of(input.split("x"))
                    .map(Integer::parseInt).toList();
            return new Box(dimensions.get(0), dimensions.get(1), dimensions.get(2));
        }

        public long wrappingPaperNeeded() {
            return 2 * length * width
                    + 2 * width * height
                    + 2 * height * length
                    + Math.min(length * width, Math.min(width * height, height * length));
        }

        public long ribbonNeeded() {
            return volume()
                    + 2 * length
                    + 2 * width
                    + 2 * height
                    - 2 * Math.max(length, Math.max(height, width));
        }

        public long volume() {
            return length * width * height;
        }
    }
}
