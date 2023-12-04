package de.tobiasbell.aoc.solution._2023.util;

import java.util.ArrayList;
import java.util.List;

public record Coordinate(int x, int y) {

    public List<Coordinate> adjacent() {
        final var coordinates = new ArrayList<Coordinate>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                coordinates.add(new Coordinate(x + i, y + j));
            }
        }
        return coordinates;
    }
}
