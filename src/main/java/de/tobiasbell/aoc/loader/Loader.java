package de.tobiasbell.aoc.loader;

import java.nio.file.Path;

public interface Loader {
    public static Loader defaultLoader(final String savePath, final String sessionId) {
        return new CachingLoader(FileLoader.withBaseDirectory(Path.of(savePath)), WebLoader.withSession(sessionId));
    }

    String loadInput(int year, int day);

    boolean hasInput(int year, int day);
}
