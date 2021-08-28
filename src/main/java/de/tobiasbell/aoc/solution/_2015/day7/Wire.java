package de.tobiasbell.aoc.solution._2015.day7;


public class Wire {
    private static final int MAX_SIGNAL = 65_535;
    private final String name;
    private Integer signal;
    private Expression inputExpression;

    public Wire(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public void reset() {
        signal = null;
    }

    public int signal() {
        if (signal == null) {
            signal = inputExpression.evaluate();
        }
        return signal & MAX_SIGNAL;
    }

    public void setInput(Expression inputExpression) {
        this.inputExpression = inputExpression;
    }
}
