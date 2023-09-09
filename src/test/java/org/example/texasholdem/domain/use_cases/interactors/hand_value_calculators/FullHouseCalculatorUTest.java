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

class FullHouseCalculatorUTest {

    FullHouseCalculator fullHouseCalculator = new FullHouseCalculator();

    @Test
    void calculate_should_return_FULL_HOUSE_when_the_hand_contains_a_full_house() {
        // Given
        Hand hand = new Hand(List.of(
                new Card(Rank.TWO, Suit.CLUBS),
                new Card(Rank.TWO, Suit.DIAMONDS),
                new Card(Rank.TWO, Suit.HEARTS),
                new Card(Rank.FIVE, Suit.CLUBS),
                new Card(Rank.FIVE, Suit.SPADES)
        ));

        // When
        HandValue handValue = fullHouseCalculator.calculate(hand);

        // Then
        assertEquals(handValue, HandValue.FULL_HOUSE);
    }


    @Test
    void calculate_should_return_FULL_HOUSE_when_the_hand_contains_two_triples() {
        // Given
        Hand hand = new Hand(List.of(
                new Card(Rank.AS, Suit.DIAMONDS),
                new Card(Rank.AS, Suit.HEARTS),
                new Card(Rank.AS, Suit.SPADES),
                new Card(Rank.FIVE, Suit.SPADES),
                new Card(Rank.FIVE, Suit.HEARTS),
                new Card(Rank.FIVE, Suit.CLUBS)
        ));

        // When
        HandValue handValue = fullHouseCalculator.calculate(hand);

        // Then
        assertNull(handValue);
    }

    @Test
    void calculate_should_return_null_when_the_hand_does_not_contain_a_triple() {
        // Given
        Hand hand = new Hand(List.of(
                new Card(Rank.AS, Suit.DIAMONDS),
                new Card(Rank.THREE, Suit.HEARTS),
                new Card(Rank.FOUR, Suit.DIAMONDS),
                new Card(Rank.FIVE, Suit.SPADES),
                new Card(Rank.SIX, Suit.CLUBS)
        ));

        // When
        HandValue handValue = fullHouseCalculator.calculate(hand);

        // Then
        assertNull(handValue);
    }

    @Test
    void calculate_should_return_null_when_the_hand_does_not_contains_a_triple_but_no_pair() {
        // Given
        Hand hand = new Hand(List.of(
                new Card(Rank.AS, Suit.DIAMONDS),
                new Card(Rank.AS, Suit.HEARTS),
                new Card(Rank.AS, Suit.SPADES),
                new Card(Rank.FIVE, Suit.SPADES),
                new Card(Rank.SIX, Suit.CLUBS)
        ));

        // When
        HandValue handValue = fullHouseCalculator.calculate(hand);

        // Then
        assertNull(handValue);
    }
}