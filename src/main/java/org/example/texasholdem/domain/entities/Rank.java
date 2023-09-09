package org.example.texasholdem.domain.entities;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {

    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("T"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
    AS("A");

    private final String code;

    Rank(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Optional<Rank> fromCode(String code) {
        return Arrays.stream(values())
                .filter(rank -> rank.getCode().equals(code))
                .findFirst();
    }
}
