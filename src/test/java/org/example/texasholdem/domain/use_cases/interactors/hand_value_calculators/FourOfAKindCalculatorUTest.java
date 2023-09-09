package org.example.texasholdem.domain.use_cases.interactors.hand_value_calculators;

import org.example.texasholdem.domain.entities.Card;
import org.example.texasholdem.domain.entities.Hand;
import org.example.texasholdem.domain.entities.HandValue;
import org.example.texasholdem.domain.entities.Rank;
import org.example.texasholdem.domain.entities.Suit;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FourOfAKindCalculatorUTest {

    FourOfAKindCalculator fourOfAKindCalculator = new FourOfAKindCalculator();

    @Test
    void calculate_should_return_FOUR_OF_A_KIND_if_the_hand_contains_4_cards_with_the_same_rank() {
        // Given
        Hand hand = new Hand(
                List.of(
                        new Card(Rank.AS, Suit.CLUBS),
                        new Card(Rank.AS, Suit.HEARTS),
                        new Card(Rank.AS, Suit.SPADES),
                        new Card(Rank.AS, Suit.DIAMONDS)));

        // When
        HandValue handValue = fourOfAKindCalculator.calculate(hand);

        // Then
        assertEquals(handValue, HandValue.FOUR_OF_A_KIND);
    }

    @Test
    void calculate_should_return_null_if_the_hand_does_not_contains_4_cards_with_the_same_rank() {
        // Given
        Hand hand = new Hand(
                List.of(
                        new Card(Rank.AS, Suit.CLUBS),
                        new Card(Rank.AS, Suit.DIAMONDS),
                        new Card(Rank.AS, Suit.HEARTS)));

        // When
        HandValue handValue = fourOfAKindCalculator.calculate(hand);

        // Then
        assertNull(handValue);
    }

}