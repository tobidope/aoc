package de.tobiasbell.aoc.solution._2015.day6;

import org.jetbrains.annotations.NotNull;

public enum NewCommand implements LightCommand {
    TurnOn {
        @Override
        public @NotNull Brightness evaluate(@NotNull Brightness currentState) {
            return new Brightness(currentState.brightness() + 1);
        }
    },
    TurnOff {
        @Override
        public @NotNull Brightness evaluate(@NotNull Brightness currentState) {
            return currentState.equals(Brightness.Off)
                    ? currentState
                    : new Brightness(currentState.brightness() - 1);
        }
    },
    Toggle {
        @Override
        public @NotNull Brightness evaluate(@NotNull Brightness currentState) {
            return new Brightness(currentState.brightness() + 2);
        }
    };

    public static @NotNull LightCommand of(final @NotNull String command) {
        return switch (command) {
            case "turn on" -> NewCommand.TurnOn;
            case "turn off" -> NewCommand.TurnOff;
            case "toggle" -> NewCommand.Toggle;
            default -> throw new IllegalArgumentException("Unknown command " + command);
        };
    }
}

