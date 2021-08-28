package de.tobiasbell.aoc.solution._2015.day2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day2 {
    public static long solve1(final String input) {
        return boxes(input)
                .mapToLong(Box::wrappingPaperNeeded)
                .sum();
    }

    private static Stream<Box> boxes(String input) {
        return Stream.of(input.split("\\R"))
                .map(Box::of);
    }

    public static long solve2(String input) {
        return boxes(input)
                .mapToLong(Box::ribbonNeeded)
                .sum();
    }


    public static record Box(long length, long height, long width) {
        public static Box of(final String input) {
            final List<Integer> dimensions = Stream.of(input.split("x"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
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
