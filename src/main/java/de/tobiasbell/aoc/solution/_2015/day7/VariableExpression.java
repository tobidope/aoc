package de.tobiasbell.aoc.solution._2015.day7;


public record VariableExpression(Wire w) implements Expression {
    @Override
    public int evaluate() {
        return w.signal();
    }
}
