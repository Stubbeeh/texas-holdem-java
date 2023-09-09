package org.example.texasholdem.domain.use_cases.interactors.hand_value_calculators;

import org.example.texasholdem.domain.entities.Hand;
import org.example.texasholdem.domain.entities.HandValue;

public interface HandValueCalculator {

    HandValue calculate(Hand hand);
}
