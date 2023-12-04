package de.tobiasbell.aoc.solution._2023;

import de.tobiasbell.aoc.solution._2023.util.CubeGame;
import de.tobiasbell.aoc.solution._2023.util.CubeSet;

import java.util.stream.Stream;

public class Day2 {

    public static CubeSet parseCubeSet(String reveal) {
        int blue = 0;
        int green = 0;
        int red = 0;

        final var split = reveal.split("[, ]+");
        for (int i = 0; i < split.length; i += 2) {
            int amount = Integer.parseInt(split[i]);
            switch (split[i + 1]) {
                case "blue" -> blue = amount;
                case "red" -> red = amount;
                case "green" -> green = amount;
            }
        }

        return new CubeSet(blue, green, red);
    }

    public static CubeGame parseGame(String line) {
        final var split = line.split(": ");
        int id = Integer.parseInt(split[0].split(" ")[1]);
        final var list = Stream.of(split[1].split("; "))
                .map(Day2::parseCubeSet)
                .toList();

        return new CubeGame(id, list);
    }

    public static long solve1(final String games) {
        CubeSet bag = new CubeSet(14, 13, 12);
        return Stream.of(games.split("\\R"))
                .map(Day2::parseGame)
                .filter(cubeGame -> cubeGame.cubeSets().stream()
                        .allMatch(bag::revealIsPossible))
                .mapToInt(CubeGame::id)
                .sum();

    }

    public static long solve2(final String games) {
        return Stream.of(games.split("\\R"))
                .map(Day2::parseGame)
                .map(CubeGame::cubeSets)
                .map(sets -> sets.stream()
                        .reduce(new CubeSet(0, 0, 0),
                                CubeSet::minimalPossibleSet))
                .mapToInt(CubeSet::power)
                .sum();
    }
}
