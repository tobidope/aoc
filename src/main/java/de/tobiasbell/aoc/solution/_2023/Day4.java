package de.tobiasbell.aoc.solution._2023;

import de.tobiasbell.aoc.solution._2023.util.ScratchCard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Day4 {

    public static ScratchCard parseCard(final String line) {
        final var split = line.split(":\\s+");
        final var id = Integer.parseInt(split[0].substring(5).trim());
        final var numberString = split[1].split("\\s+\\|\\s+");
        return new ScratchCard(id,
                parseNumbers(numberString[0]),
                parseNumbers(numberString[1]));
    }

    private static List<Integer> parseNumbers(String s) {
        return Stream.of(s.split("\\s+"))
                .map(Integer::parseInt)
                .toList();
    }

    public static long solve1(final String scratchCards) {
        return Stream.of(scratchCards.split("\\R"))
                .map(Day4::parseCard)
                .mapToLong(ScratchCard::points)
                .sum();
    }

    public static long solve2(final String scratchCards) {
        final var cards = Stream.of(scratchCards.split("\\R"))
                .map(Day4::parseCard)
                .toList();
        final Map<Integer, Integer> totalCards = new HashMap<>();

        for (int i = 0; i < cards.size(); i++) {
            var card = cards.get(i);
            totalCards.computeIfAbsent(card.id(), id -> 1);
            var point = card.points()
            if (point == 0) {
                continue;
            }
            for (int j= card.id()+1; j<=i+car
        }
    }
}
