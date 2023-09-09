package org.example.texasholdem.domain.use_cases.interactors;

import org.example.texasholdem.domain.entities.Card;
import org.example.texasholdem.domain.entities.Hand;
import org.example.texasholdem.domain.entities.HandValue;
import org.example.texasholdem.domain.entities.Rank;
import org.example.texasholdem.domain.entities.Suit;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ComputeAndSetHandValueUTest {

    private final ComputeAndSetHandValue computeAndSetHandValue = new ComputeAndSetHandValue();

    @Test
    void compute_should_compute_the_value_of_the_given_hand_and_set_it() {
        // Given
        Hand hand = new Hand(
                List.of(
                        new Card(Rank.AS, Suit.HEARTS),
                        new Card(Rank.AS, Suit.SPADES),
                        new Card(Rank.THREE, Suit.SPADES),
                        new Card(Rank.JACK, Suit.CLUBS),
                        new Card(Rank.FIVE, Suit.DIAMONDS),
                        new Card(Rank.EIGHT, Suit.DIAMONDS),
                        new Card(Rank.TEN, Suit.HEARTS)));

        // When
        computeAndSetHandValue.compute(hand);

        // Then
        assertEquals(hand.getHandValue(), HandValue.PAIR);
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