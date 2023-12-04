package de.tobiasbell.aoc.solution._2023.util;

import java.util.HashSet;
import java.util.List;

public record ScratchCard(int id, List<Integer> winningNumbers, List<Integer> numbers) {
    public long points() {
        final var wins = new HashSet<>(winningNumbers);
        wins.retainAll(numbers);
        if (!wins.isEmpty()) {
            return (long) Math.pow(2.0, wins.size() - 1.0);
        }
        return 0;
    }

}
