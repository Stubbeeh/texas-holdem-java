package org.example.texasholdem.domain.entities;

import java.util.List;

public class Hand {

    private final List<Card> cards;
    private HandValue handValue;
    private Boolean isWinning;

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public HandValue getHandValue() {
        return handValue;
    }

    public Hand setHandValue(HandValue handValue) {
        this.handValue = handValue;
        return this;
    }

    public Boolean isWinning() {
        return isWinning != null && isWinning;
    }

    public void hasWon(Boolean winning) {
        isWinning = winning;
    }
}
