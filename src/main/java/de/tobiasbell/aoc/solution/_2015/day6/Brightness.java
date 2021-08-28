package de.tobiasbell.aoc.solution._2015.day6;


public record Brightness(int brightness) {
    public static final Brightness Off = new Brightness(0);
    public static final Brightness On = new Brightness(1);

    public Brightness {
        if (brightness < 0) {
            throw new IllegalArgumentException("Brightness can't be negative: " + brightness);
        }
    }

    public boolean isOn() {
        return brightness > 0;
    }
}
