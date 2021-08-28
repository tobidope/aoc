package de.tobiasbell.aoc.loader;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class FileLoaderTest {

    @Test
    void loadFromFile(@TempDir Path tempDir) throws IOException {
        // given
        final Path year = Files.createDirectory(tempDir.resolve("2015"));
        Files.writeString(year.resolve("day1"), "data", StandardCharsets.UTF_8);
        FileLoader l = FileLoader.withBaseDirectory(tempDir);
        // when
        final String result = l.loadInput(2015, 1);
        //then
        assertThat(result).isEqualTo("data");
    }

    @Test
    void saveInput(@TempDir Path tempDir) throws IOException {
        //given
        final Path base = tempDir.resolve("base");
        final FileLoader fileLoader = FileLoader.withBaseDirectory(base);
        // when
        fileLoader.saveInput(2020, 1, "input");
        //then
        assertThat(base.resolve("2020/day1")).hasContent("input");
    }


}