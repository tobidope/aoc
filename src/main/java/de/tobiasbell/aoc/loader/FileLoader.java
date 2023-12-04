package de.tobiasbell.aoc.loader;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileLoader implements Loader {
    private final Path baseDirectory;

    private FileLoader(Path baseDirectory) {
        this.baseDirectory = baseDirectory;
    }

    public static @NotNull FileLoader withBaseDirectory(final Path baseDirectory) {
        return new FileLoader(baseDirectory);
    }

    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings("NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE")
    public void saveInput(int year, int day, @NotNull String input) throws IOException {
        final Path path = createPath(year, day);
        Files.createDirectories(path.getParent());
        Files.writeString(path, input, StandardCharsets.UTF_8);
    }

    @Override
    public boolean hasInput(int year, int day) {
        return Files.exists(createPath(year, day));
    }

    @Override
    public String loadInput(int year, int day) {
        final Path path = createPath(year, day);
        try {
            return Files.readString(path);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private @NotNull Path createPath(int year, int day) {
        return baseDirectory.resolve(String.valueOf(year)).resolve("day" + day);
    }
}
