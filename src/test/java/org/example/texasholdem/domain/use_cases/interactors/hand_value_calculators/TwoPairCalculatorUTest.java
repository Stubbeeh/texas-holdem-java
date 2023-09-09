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

class TwoPairCalculatorUTest {

    TwoPairCalculator twoPairCalculator = new TwoPairCalculator();

    @Test
    void calculate_should_return_TWO_PAIR_if_the_hand_contains_at_least_2_pairs() {
        // Given
        Hand hand = new Hand(
                List.of(
                        new Card(Rank.AS, Suit.CLUBS),
                        new Card(Rank.AS, Suit.HEARTS),
                        new Card(Rank.THREE, Suit.DIAMONDS),
                        new Card(Rank.THREE, Suit.CLUBS)));

        // When
        HandValue handValue = twoPairCalculator.calculate(hand);

        // Then
        assertEquals(handValue, HandValue.TWO_PAIR);
    }

    @Test
    void calculate_should_return_null_if_the_hand_does_not_contains_2_pairs() {
        // Given
        Hand hand = new Hand(
                List.of(
                        new Card(Rank.AS, Suit.CLUBS),
                        new Card(Rank.AS, Suit.HEARTS),
                        new Card(Rank.FOUR, Suit.DIAMONDS),
                        new Card(Rank.THREE, Suit.CLUBS)));

        // When
        HandValue handValue = twoPairCalculator.calculate(hand);

        // Then
        assertNull(handValue);
    }


}