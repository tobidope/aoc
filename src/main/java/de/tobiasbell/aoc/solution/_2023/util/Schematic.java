package de.tobiasbell.aoc.solution._2023.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public record Schematic(Map<Coordinate, Character> symbols, Map<Coordinate, PartNumber> partNumbers) {
    public Schematic() {
        this(new HashMap<>(), new HashMap<>());
    }

    private static Set<PartNumber> getAdjacentPartNumbers(Coordinate coordinate, Map<Coordinate, PartNumber> partNumbers) {
        final Set<PartNumber> validNumbers = new HashSet<>();
        for (var adjacent : coordinate.adjacent()) {
            if (partNumbers.containsKey(adjacent)) {
                validNumbers.add(partNumbers.get(adjacent));
            }
        }
        return validNumbers;
    }

    public List<Integer> extractGearRatios() {
        return symbols.entrySet().stream()
                .filter(e -> e.getValue() == '*')
                .map(Map.Entry::getKey)
                .map(c -> getAdjacentPartNumbers(c, partNumbers))
                .filter(numbers -> numbers.size() == 2)
                .map(numbers -> numbers.stream()
                        .mapToInt(PartNumber::partNumber)
                        .reduce(1, (a, b) -> a * b))
                .toList();
    }


    public List<Integer> extractPartNumbers() {
        final Set<PartNumber> validNumbers = new HashSet<>();
        for (var symbol : symbols.keySet()) {
            validNumbers.addAll(getAdjacentPartNumbers(symbol, partNumbers));
        }
        return validNumbers.stream()
                .map(PartNumber::partNumber)
                .toList();
    }
}