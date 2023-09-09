package org.example.texasholdem.domain.use_cases.interactors.hand_value_calculators;

import org.example.texasholdem.domain.entities.Hand;
import org.example.texasholdem.domain.entities.HandValue;

public class HighCardCalculator implements HandValueCalculator {
    @Override
    public HandValue calculate(Hand hand) {
        return HandValue.HIGH_CARD;
    }
}
