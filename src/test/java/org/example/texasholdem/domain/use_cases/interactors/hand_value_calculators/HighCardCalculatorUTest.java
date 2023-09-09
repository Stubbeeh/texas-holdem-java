package org.example.texasholdem.domain.use_cases.interactors.hand_value_calculators;

import org.example.texasholdem.domain.entities.HandValue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HighCardCalculatorUTest {

    @Test
    void calculate_should_return_HIGH_CARD() {
        // Given
        HighCardCalculator highCardCalculator = new HighCardCalculator();

        // When
        HandValue handValue = highCardCalculator.calculate(null);


        // Then
        assertEquals(handValue, HandValue.HIGH_CARD);
    }

}