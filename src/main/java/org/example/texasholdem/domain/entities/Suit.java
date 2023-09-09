package org.example.texasholdem.domain.entities;

import java.util.Arrays;
import java.util.Optional;

public enum Suit {
    CLUBS("c"),
    DIAMONDS("d"),
    HEARTS("h"),
    SPADES("s");

    private final String code;

    Suit(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Optional<Suit> fromCode(String code) {
        return Arrays.stream(values())
                .filter(suit -> suit.getCode().equals(code))
                .findFirst();
    }
}
