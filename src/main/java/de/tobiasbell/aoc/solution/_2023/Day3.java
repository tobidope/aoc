package de.tobiasbell.aoc.solution._2023;

import de.tobiasbell.aoc.solution._2023.util.Coordinate;
import de.tobiasbell.aoc.solution._2023.util.PartNumber;
import de.tobiasbell.aoc.solution._2023.util.Schematic;

import java.util.ArrayList;
import java.util.List;

public class Day3 {

    public static Schematic parseSchematic(final String plan) {
        final var lines = plan.split("\\R");
        final var schematic = new Schematic();
        for (int y = 0; y < lines.length; y++) {
            String line = lines[y];
            int x = 0;
            while (x < line.length()) {
                final var c = line.charAt(x);
                if (c == '.') {
                    x++;
                } else if (Character.isDigit(c)) {
                    int partNumber = 0;
                    int partStart = x;
                    List<Coordinate> coordinates = new ArrayList<>();
                    while (partStart < line.length() && Character.isDigit(line.charAt(partStart))) {
                        coordinates.add(new Coordinate(partStart, y));
                        partNumber *= 10;
                        partNumber += Character.getNumericValue(line.charAt(partStart));
                        partStart++;
                    }
                    x = partStart;
                    final var partNumber1 = new PartNumber(partNumber, coordinates);
                    for (var coordinate : coordinates) {
                        schematic.partNumbers().put(coordinate, partNumber1);
                    }

                } else {
                    schematic.symbols().put(new Coordinate(x, y), c);
                    x++;
                }
            }
        }
        return schematic;
    }

    public static long solve1(final String plan) {
        final var schematic = parseSchematic(plan);
        return schematic.extractPartNumbers().stream()
                .mapToInt(d -> d)
                .sum();

    }

    public static long solve2(String plan) {
        final var schematic = parseSchematic(plan);
        return schematic.extractGearRatios().stream().
                mapToInt(d -> d)
                .sum();
    }
}
