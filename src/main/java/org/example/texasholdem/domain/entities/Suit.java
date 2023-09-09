package org.example.texasholdem.domain.entities;

public enum Suit {
    CLUBS("c"),
    DIAMONDS("d"),
    HEARTS("h"),
    SPADES("s");

    private final String code;

    Suit(String code) {
        this.code = code;
    }
}
