package de.tobiasbell.aoc.solution._2015.day7;


public record AndExpression(Expression w, Expression v) implements Expression {
    @Override
    public int evaluate() {
        return w.evaluate() & v.evaluate();
    }
}
