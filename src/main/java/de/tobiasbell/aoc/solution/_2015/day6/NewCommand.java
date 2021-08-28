package de.tobiasbell.aoc.solution._2015.day6;

public enum NewCommand implements LightCommand {
    TurnOn {
        @Override
        public Brightness evaluate(Brightness currentState) {
            return new Brightness(currentState.brightness() + 1);
        }
    },
    TurnOff {
        @Override
        public Brightness evaluate(Brightness currentState) {
            return currentState.equals(Brightness.Off)
                    ? currentState
                    : new Brightness(currentState.brightness() - 1);
        }
    },
    Toggle {
        @Override
        public Brightness evaluate(Brightness currentState) {
            return new Brightness(currentState.brightness() + 2);
        }
    };

    public static LightCommand of(final String command) {
        return switch (command) {
            case "turn on" -> NewCommand.TurnOn;
            case "turn off" -> NewCommand.TurnOff;
            case "toggle" -> NewCommand.Toggle;
            default -> throw new IllegalArgumentException("Unknown command " + command);
        };
    }
}

