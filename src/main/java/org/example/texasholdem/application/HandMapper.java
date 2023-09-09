package org.example.texasholdem.application;

import org.example.texasholdem.domain.entities.Card;
import org.example.texasholdem.domain.entities.Hand;
import org.example.texasholdem.domain.entities.Rank;
import org.example.texasholdem.domain.entities.Suit;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HandMapper {

    public Hand toHand(String parsedHand) {
        List<String> parsedCards = List.of(parsedHand.split(" "));
        List<Card> cards = new ArrayList<>();
        for (String card : parsedCards) {
            if (card.length() != 2) {
                continue;
            }

            Optional<Rank> rank = Rank.fromCode(card.substring(0, 1));
            Optional<Suit> suit = Suit.fromCode(card.substring(1, 2));
            if (rank.isEmpty() || suit.isEmpty()) {
                continue;
            }
            cards.add(new Card(rank.get(), suit.get()));
        }
        return new Hand(cards);
    }

    public String toString(Hand hand) {
        StringBuilder stringBuilder = new StringBuilder();
        hand.getCards().stream()
                .map(card -> card.rank().getCode() + card.suit().getCode() + " ")
                .forEach(stringBuilder::append);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        if (hand.getHandValue() != null) {
            stringBuilder.append(" ").append(hand.getHandValue().getLibelle());
        }
        if (hand.isWinning()) {
            stringBuilder.append(" (winner)");
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
