package de.tobiasbell.aoc;

import de.tobiasbell.aoc.loader.Loader;
import org.jetbrains.annotations.NotNull;

public class TestConfig {

    private TestConfig() {
    }

    public static @NotNull Loader testLoader() {
        return Loader.defaultLoader(System.getenv("AOC_SAVEPATH"),
                System.getenv("AOC_SESSION"));
    }
}
