package de.tobiasbell.aoc.solution._2015.day7;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CircuitParser {
    final WireTable table = new WireTable();

    public @NotNull WireTable parse(@NotNull List<String> circuits) {
        for (var circuit : circuits) {
            final String[] elements = circuit.split(" ");
            switch (elements.length) {
                case 3 -> {
                    final Wire target = table.getWire(elements[2]);
                    final String input = elements[0];
                    target.setInput(parseExpression(input));
                }
                case 4 -> {
                    final Wire target = table.getWire(elements[3]);
                    final Expression not = parseExpression(elements[1]);
                    final var inputExpression = new NotExpression(not);
                    target.setInput(inputExpression);
                }
                case 5 -> parseBinaryOperator(elements);
                default -> throw new IllegalArgumentException("Unknown circuit expression: " + circuit);
            }
        }
        return table;
    }

    private void parseBinaryOperator(String @NotNull [] elements) {
        final String operator = elements[1];
        final Wire target = table.getWire(elements[4]);
        switch (operator) {
            case "AND" -> target.setInput(
                    new AndExpression(
                            parseExpression(elements[0]),
                            parseExpression(elements[2])
                    )
            );
            case "OR" -> target.setInput(
                    new OrExpression(
                            parseExpression(elements[0]),
                            parseExpression(elements[2])
                    )
            );
            case "LSHIFT" -> target.setInput(
                    new LeftShiftExpression(
                            table.getWire(elements[0]),
                            Integer.parseInt(elements[2])
                    )
            );
            case "RSHIFT" -> target.setInput(
                    new RightShiftExpression(
                            table.getWire(elements[0]),
                            Integer.parseInt(elements[2])
                    )
            );
            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    private @NotNull Expression parseExpression(@NotNull String input) {
        if (input.matches("\\d+")) {
            return new LiteralExpression(Integer.parseInt(input));
        }
        return new VariableExpression(table.getWire(input));
    }
}

