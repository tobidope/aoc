package de.tobiasbell.aoc.solution._2015.day7;

public record NotExpression(Expression w) implements Expression {
    @Override
    public int evaluate() {
        return ~w.evaluate();
    }
}
