package de.tobiasbell.aoc.solution._2023;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Day1 {
    public static final Pattern DIGIT_PATTERN2 = Pattern.compile("\\d|one|two|three|four|five|six|seven|eight|nine");
    public static final Map<String, Long> CONVERSION = Map.ofEntries(
            Map.entry("one", 1L),
            Map.entry("two", 2L),
            Map.entry("three", 3L),
            Map.entry("four", 4L),
            Map.entry("five", 5L),
            Map.entry("six", 6L),
            Map.entry("seven", 7L),
            Map.entry("eight", 8L),
            Map.entry("nine", 9L)
    );
    public static Logger LOG = LoggerFactory.getLogger(Day1.class);

    public static long solve1(final @NotNull String document) {
        return Stream.of(document.split("\\R"))
                .map(Day1::simpleCalibrationValue)
                .mapToLong(d -> d)
                .sum();
    }

    public static long solve2(final @NotNull String document) {
        return Stream.of(document.split("\\R"))
                .map(Day1::calibrationValue)
                .mapToLong(d -> d)
                .sum();
    }

    private static long simpleCalibrationValue(final String line) {
        final var digits = line.chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .boxed()
                .toList();
        return digits.getFirst() * 10 + digits.getLast();
    }

    private static long calibrationValue(final String line) {
        final var matcher = DIGIT_PATTERN2.matcher(line);
        if (!matcher.find()) {
            throw new IllegalArgumentException("No calibration value found");
        }
        long lastMatch = extractDigit(matcher.group());
        long result = lastMatch * 10;
        for (int i = matcher.start() + 1; i < line.length(); i = matcher.start() + 1) {
            if (!matcher.find(i)) {
                break;
            }
            lastMatch = extractDigit(matcher.group());
        }
        LOG.info("{} - {}", line, result + lastMatch);
        return result + lastMatch;
    }

    public static Long extractDigit(final String value) {
        if (value.length() == 1) {
            return Long.parseLong(value);
        }
        return CONVERSION.get(value);
    }

}
