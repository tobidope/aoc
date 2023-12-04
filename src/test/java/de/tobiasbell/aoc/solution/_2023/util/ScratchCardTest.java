package de.tobiasbell.aoc.solution._2023.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ScratchCardTest {

    @Test
    void points() {
        final var scratchCard = new ScratchCard(1, List.of(41, 48, 83, 86, 17), List.of(83, 86, 6, 31, 17, 9, 48, 53));

        assertThat(scratchCard.points()).isEqualTo(8);
    }
}