package org.example.texasholdem.domain.use_cases.interactors.hand_value_calculators;

import org.example.texasholdem.domain.entities.Card;
import org.example.texasholdem.domain.entities.Hand;
import org.example.texasholdem.domain.entities.HandValue;
import org.example.texasholdem.domain.entities.Rank;
import org.example.texasholdem.domain.entities.Suit;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlushCalculatorUTest {

    FlushCalculator flushCalculator = new FlushCalculator();

    @Test
    void calculate_should_return_FLUSH_when_the_hand_contains_5_cars_with_the_same_suit() {
        // Given
        Hand hand = new Hand(List.of(
                new Card(Rank.TWO, Suit.CLUBS),
                new Card(Rank.KING, Suit.CLUBS),
                new Card(Rank.TEN, Suit.CLUBS),
                new Card(Rank.FIVE, Suit.CLUBS),
                new Card(Rank.EIGHT, Suit.CLUBS)
        ));

        // When
        HandValue handValue = flushCalculator.calculate(hand);

        // Then
        assertEquals(handValue, HandValue.FLUSH);
    }

    @Test
    void calculate_should_return_null_when_the_hand_does_not_contain_5_cards_with_the_same_suit() {
        // Given
        Hand hand = new Hand(List.of(
                new Card(Rank.AS, Suit.DIAMONDS),
                new Card(Rank.THREE, Suit.HEARTS),
                new Card(Rank.FOUR, Suit.DIAMONDS),
                new Card(Rank.FIVE, Suit.SPADES),
                new Card(Rank.SIX, Suit.CLUBS)
        ));

        // When
        HandValue handValue = flushCalculator.calculate(hand);

        // Then
        assertNull(handValue);
    }
}