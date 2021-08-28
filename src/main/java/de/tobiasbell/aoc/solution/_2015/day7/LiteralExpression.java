package de.tobiasbell.aoc.solution._2015.day7;


public record LiteralExpression(int value) implements Expression {
    @Override
    public int evaluate() {
        return value;
    }
}
