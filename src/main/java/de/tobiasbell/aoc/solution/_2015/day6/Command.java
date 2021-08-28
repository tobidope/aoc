package de.tobiasbell.aoc.solution._2015.day6;

public enum Command implements LightCommand {
    TurnOn {
        @Override
        public Brightness evaluate(Brightness currentState) {
            return Brightness.On;
        }
    },
    TurnOff {
        @Override
        public Brightness evaluate(Brightness currentState) {
            return Brightness.Off;
        }
    },
    Toggle {
        @Override
        public Brightness evaluate(Brightness currentState) {
            return currentState.isOn()
                    ? Brightness.Off
                    : Brightness.On;
        }
    };

    public static Command of(final String command) {
        return switch (command) {
            case "turn on" -> Command.TurnOn;
            case "turn off" -> Command.TurnOff;
            case "toggle" -> Command.Toggle;
            default -> throw new IllegalArgumentException("Unknown command " + command);
        };
    }

}
