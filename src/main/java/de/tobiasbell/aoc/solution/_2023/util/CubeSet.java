package de.tobiasbell.aoc.solution._2023.util;

public record CubeSet(int blue, int green, int red) {
    public boolean revealIsPossible(CubeSet other) {
        return blue >= other.blue
                && green >= other.green
                && red >= other.red;
    }

    public int power() {
        return blue * green * red;
    }

    public CubeSet minimalPossibleSet(CubeSet other) {
        return new CubeSet(
                Integer.max(blue, other.blue),
                Integer.max(green, other.green),
                Integer.max(red, other.red)
        );
    }
}
