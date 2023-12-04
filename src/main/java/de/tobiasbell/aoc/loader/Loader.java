package de.tobiasbell.aoc.loader;

import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

public interface Loader {
    static @NotNull Loader defaultLoader(final @NotNull String savePath, final String sessionId) {
        return new CachingLoader(FileLoader.withBaseDirectory(Path.of(savePath)), WebLoader.withSession(sessionId));
    }

    String loadInput(int year, int day);

    boolean hasInput(int year, int day);
}
