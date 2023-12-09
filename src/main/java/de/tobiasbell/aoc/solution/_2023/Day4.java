package de.tobiasbell.aoc.solution._2023;

import de.tobiasbell.aoc.solution._2023.util.GameCard;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day4 {
    public static long solve1(final String cards) {
        return Stream.of(cards.split("\\R"))
                .map(Day4::parseCard)
                .mapToLong(GameCard::points)
                .sum();
    }

    private static GameCard parseCard(String line) {
        final var parts = line.split(":\\s+");
        int id = Integer.parseInt(parts[0].split("\\s+")[1]);
        final var numbers = parts[1].split("\\s+\\|\\s+");
        return new GameCard(id,
                parseNumbers(numbers[0]),
                parseNumbers(numbers[1]));
    }

    private static Set<Integer> parseNumbers(String numbers) {
        return Stream.of(numbers.split("\\s+"))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    public static long solve2(String cards) {
        final var gameCards = Stream.of(cards.split("\\R"))
                .map(Day4::parseCard)
                .toList();
        final var resultList = createResultList(gameCards.size());
        for (int i = 0; i < gameCards.size(); i++) {
            final var matching = gameCards.get(i).matchingNumbers();
            final var multiplier = resultList.get(i);
            for (int j = i + 1; j < resultList.size() && j <= i + matching; j++) {
                var nextCard = resultList.get(j);
                nextCard += multiplier;
                resultList.set(j, nextCard);
            }
        }
        return resultList.stream()
                .mapToLong(l ->l)
                .sum();
    }

    private static List<Long> createResultList(int size) {
        final Long[] result = new Long[size];
        Arrays.fill(result, 1L);
        return Arrays.asList(result);
    }
}
