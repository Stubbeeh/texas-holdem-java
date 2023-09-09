package org.example.texasholdem.domain.use_cases.interactors.hand_value_calculators;

import org.example.texasholdem.domain.entities.Card;
import org.example.texasholdem.domain.entities.Hand;
import org.example.texasholdem.domain.entities.HandValue;
import org.example.texasholdem.domain.entities.Rank;
import org.example.texasholdem.domain.entities.Suit;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PairCalculatorUTest {

    PairCalculator pairCalculator = new PairCalculator();

    @Test
    void calculate_should_return_PAIR_if_the_hand_contains_a_pair() {
        // Given
        Hand hand = new Hand(List.of(new Card(Rank.AS, Suit.CLUBS), new Card(Rank.AS, Suit.HEARTS)));

        // When
        HandValue handValue = pairCalculator.calculate(hand);

        // Then
        assertEquals(handValue, HandValue.PAIR);
    }

    @Test
    void calculate_should_return_null_if_the_hand_does_not_contain_a_pair() {
        // Given
        Hand hand = new Hand(List.of(new Card(Rank.THREE, Suit.CLUBS), new Card(Rank.AS, Suit.HEARTS)));

        // When
        HandValue handValue = pairCalculator.calculate(hand);

        // Then
        assertNull(handValue);
    }

}