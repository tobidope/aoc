package de.tobiasbell.aoc.loader;

import java.io.IOException;
import java.io.UncheckedIOException;

public class CachingLoader implements Loader {

    private final FileLoader fileLoader;
    private final WebLoader webLoader;

    public CachingLoader(FileLoader fileLoader, WebLoader webLoader) {
        this.fileLoader = fileLoader;
        this.webLoader = webLoader;
    }

    @Override
    public String loadInput(int year, int day) {
        if (fileLoader.hasInput(year, day)) {
            return fileLoader.loadInput(year, day);
        }
        final String input = webLoader.loadInput(year, day);
        try {
            fileLoader.saveInput(year, day, input);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return input;
    }

    @Override
    public boolean hasInput(int year, int day) {
        return fileLoader.hasInput(year, day) || webLoader.hasInput(year, day);
    }

}
