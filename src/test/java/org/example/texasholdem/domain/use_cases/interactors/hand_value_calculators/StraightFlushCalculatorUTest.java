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

class StraightFlushCalculatorUTest {

    StraightFlushCalculator straightFlushCalculator = new StraightFlushCalculator();

    @Test
    void calculate_should_return_STRAIGHT_FLUSH_when_the_hand_contains_5_following_cards_from_the_same_suit() {
        // Given
        Hand hand = new Hand(List.of(
                new Card(Rank.JACK, Suit.DIAMONDS),
                new Card(Rank.TEN, Suit.DIAMONDS),
                new Card(Rank.NINE, Suit.DIAMONDS),
                new Card(Rank.EIGHT, Suit.DIAMONDS),
                new Card(Rank.SEVEN, Suit.DIAMONDS)
        ));

        // When
        HandValue handValue = straightFlushCalculator.calculate(hand);

        // Then
        assertEquals(handValue, HandValue.STRAIGHT_FLUSH);
    }

    @Test
    void calculate_should_return_null_when_the_hand_does_not_contain_5_following_cards_from_the_same_suit() {
        // Given
        Hand hand = new Hand(List.of(
                new Card(Rank.TWO, Suit.DIAMONDS),
                new Card(Rank.THREE, Suit.HEARTS),
                new Card(Rank.FOUR, Suit.DIAMONDS),
                new Card(Rank.FIVE, Suit.SPADES),
                new Card(Rank.SIX, Suit.CLUBS)
        ));

        // When
        HandValue handValue = straightFlushCalculator.calculate(hand);

        // Then
        assertNull(handValue);
    }
}