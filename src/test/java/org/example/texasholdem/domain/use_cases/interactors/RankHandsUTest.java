package org.example.texasholdem.domain.use_cases.interactors;

import org.example.texasholdem.domain.entities.Hand;
import org.example.texasholdem.domain.entities.HandValue;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RankHandsUTest {

    private final RankHands rankHands = new RankHands();

    @Test
    void rank_should_order_hands_based_on_their_handValue() {
        // Given
        Hand pairHand = new Hand(List.of());
        pairHand.setHandValue(HandValue.PAIR);

        Hand fullHouseHand = new Hand(List.of());
        fullHouseHand.setHandValue(HandValue.FULL_HOUSE);

        Hand royalFlushHand = new Hand(List.of());
        royalFlushHand.setHandValue(HandValue.ROYAL_FLUSH);

        Hand foldHand = new Hand(List.of());

        List<Hand> hands = List.of(fullHouseHand, royalFlushHand, pairHand, royalFlushHand, foldHand);

        // When
        List<Hand> rankedHands = rankHands.rank(hands);

        // Then
        assertTrue(rankedHands.get(1).isWinning());
        assertTrue(rankedHands.get(3).isWinning());
    }

}