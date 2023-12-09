package de.tobiasbell.aoc.solution._2023.util;

import java.util.Set;

public record GameCard(int id, Set<Integer> winningNumbers, Set<Integer> numbers) {

    public long points() {
        final var count = matchingNumbers();
        return count > 0
                ? (long) Math.pow(2.0, count - 1)
                : count;
    }

    public long matchingNumbers() {
        return numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
