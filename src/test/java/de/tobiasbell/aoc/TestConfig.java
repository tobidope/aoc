package de.tobiasbell.aoc;

import de.tobiasbell.aoc.loader.Loader;

public class TestConfig {

    private TestConfig() {
    }

    public static Loader testLoader() {
        return Loader.defaultLoader(System.getenv("AOC_SAVEPATH"),
                System.getenv("AOC_SESSION"));
    }
}
