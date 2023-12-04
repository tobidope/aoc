package de.tobiasbell.aoc.solution._2015.day5;

import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

public class Day5 {

    public static boolean isNiceString(final @NotNull String input) {
        return atLeastThreeVowels(input)
                && twiceInRow(input)
                && doesNotHave(input, "ab", "cd", "pq", "xy");
    }

    public static boolean isNewNiceString(final @NotNull String input) {
        return hasNonOverlappingPair(input)
                && hasRepeatingLetterWithLetterBetween(input);
    }

    private static boolean hasRepeatingLetterWithLetterBetween(@NotNull String input) {
        for (int i = 0; i < input.length() - 2; i++) {
            if (input.charAt(i) == input.charAt(i + 2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasNonOverlappingPair(@NotNull String input) {
        for (int i = 0; i < input.length() - 3; i++) {
            String firstPair = input.substring(i, i + 2);
            for (int j = i + 2; j < input.length() - 1; j++) {
                String secondPair = input.substring(j, j + 2);
                if (firstPair.equals(secondPair)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean doesNotHave(@NotNull String input, String @NotNull ... nots) {
        for (String not : nots) {
            if (input.contains(not)) {
                return false;
            }
        }
        return true;
    }

    private static boolean twiceInRow(@NotNull String input) {
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    private static boolean atLeastThreeVowels(@NotNull String input) {
        int vowelCount = 0;
        for (int i = 0; i < input.length(); i++) {
            final char c = input.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelCount++;
            }
            if (vowelCount == 3) {
                return true;
            }
        }
        return false;
    }

    public static long solve1(@NotNull String input) {
        return Stream.of(input.split("\\R"))
                .filter(Day5::isNiceString)
                .count();
    }

    public static long solve2(@NotNull String input) {
        return Stream.of(input.split("\\R"))
                .filter(Day5::isNewNiceString)
                .count();
    }
}
