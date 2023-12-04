package de.tobiasbell.aoc.solution._2015.day6;

import org.jetbrains.annotations.NotNull;

public enum Command implements LightCommand {
    TurnOn {
        @Override
        public @NotNull Brightness evaluate(Brightness currentState) {
            return Brightness.On;
        }
    },
    TurnOff {
        @Override
        public @NotNull Brightness evaluate(Brightness currentState) {
            return Brightness.Off;
        }
    },
    Toggle {
        @Override
        public @NotNull Brightness evaluate(@NotNull Brightness currentState) {
            return currentState.isOn()
                    ? Brightness.Off
                    : Brightness.On;
        }
    };

    public static @NotNull Command of(final @NotNull String command) {
        return switch (command) {
            case "turn on" -> Command.TurnOn;
            case "turn off" -> Command.TurnOff;
            case "toggle" -> Command.Toggle;
            default -> throw new IllegalArgumentException("Unknown command " + command);
        };
    }

}
