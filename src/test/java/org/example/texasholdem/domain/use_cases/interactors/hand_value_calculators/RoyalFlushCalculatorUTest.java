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

class RoyalFlushCalculatorUTest {

    RoyalFlushCalculator royalFlushCalculator = new RoyalFlushCalculator();

    @Test
    void calculate_should_return_ROYAL_FLUSH_when_the_hand_contains_5_following_cards_from_the_same_suit_starting_with_as() {
        // Given
        Hand hand = new Hand(List.of(
                new Card(Rank.AS, Suit.DIAMONDS),
                new Card(Rank.KING, Suit.DIAMONDS),
                new Card(Rank.QUEEN, Suit.DIAMONDS),
                new Card(Rank.JACK, Suit.DIAMONDS),
                new Card(Rank.TEN, Suit.DIAMONDS)
        ));

        // When
        HandValue handValue = royalFlushCalculator.calculate(hand);

        // Then
        assertEquals(handValue, HandValue.ROYAL_FLUSH);
    }

    @Test
    void calculate_should_return_null_when_the_hand_does_not_contain_5_following_cards_from_the_same_suit_starting_with_as() {
        // Given
        Hand hand = new Hand(List.of(
                new Card(Rank.TWO, Suit.DIAMONDS),
                new Card(Rank.THREE, Suit.DIAMONDS),
                new Card(Rank.FOUR, Suit.DIAMONDS),
                new Card(Rank.FIVE, Suit.DIAMONDS),
                new Card(Rank.SIX, Suit.DIAMONDS)
        ));

        // When
        HandValue handValue = royalFlushCalculator.calculate(hand);

        // Then
        assertNull(handValue);
    }

}