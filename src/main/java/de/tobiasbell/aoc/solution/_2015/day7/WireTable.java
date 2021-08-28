package de.tobiasbell.aoc.solution._2015.day7;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WireTable {
    private final Map<String, Wire> table = new HashMap<>();

    public Wire getWire(final String name) {
        return table.computeIfAbsent(name, Wire::new);
    }

    public Set<String> getWireNames() {
        return Collections.unmodifiableSet(table.keySet());
    }

    public void reset() {
        table.values().forEach(Wire::reset);
    }
}
