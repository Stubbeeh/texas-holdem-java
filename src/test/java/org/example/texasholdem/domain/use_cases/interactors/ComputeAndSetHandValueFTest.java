package org.example.texasholdem.domain.use_cases.interactors;

import org.example.texasholdem.domain.entities.Card;
import org.example.texasholdem.domain.entities.Hand;
import org.example.texasholdem.domain.entities.HandValue;
import org.example.texasholdem.domain.entities.Rank;
import org.example.texasholdem.domain.entities.Suit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ComputeAndSetHandValueFTest {

    private final ComputeAndSetHandValue computeAndSetHandValue = new ComputeAndSetHandValue();

    @Test
    void compute_should_compute_the_value_of_the_given_hand_and_set_it() {
        // Given
        List<Card> cards = new ArrayList<>(7);
        cards.add(new Card(Rank.AS, Suit.HEARTS));
        cards.add(new Card(Rank.AS, Suit.SPADES));
        cards.add(new Card(Rank.THREE, Suit.SPADES));
        cards.add(new Card(Rank.JACK, Suit.CLUBS));
        cards.add(new Card(Rank.FIVE, Suit.DIAMONDS));
        cards.add(new Card(Rank.EIGHT, Suit.DIAMONDS));
        cards.add(new Card(Rank.TEN, Suit.HEARTS));

        Hand hand = new Hand(cards);

        // When
        computeAndSetHandValue.compute(hand);

        // Then
        assertEquals(HandValue.PAIR, hand.getHandValue());
    }

    @Test
    void compute_should_not_compute_a_value_for_a_null_hand() {
        // Given
        Hand hand = new Hand(null);

        // When
        computeAndSetHandValue.compute(hand);

        // Then
        assertNull(hand.getHandValue());
    }

    @Test
    void compute_should_not_compute_a_value_for_an_incomplete_hand() {
        // Given
        Hand hand = new Hand(List.of());

        // When
        computeAndSetHandValue.compute(hand);

        // Then
        assertNull(hand.getHandValue());
    }
}