package de.tobiasbell.aoc.solution._2015.day7;


public record LeftShiftExpression(Wire w, int shift) implements Expression {
    @Override
    public int evaluate() {
        return w.signal() << shift;
    }
}
