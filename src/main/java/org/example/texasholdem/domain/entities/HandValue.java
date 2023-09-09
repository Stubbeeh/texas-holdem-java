package org.example.texasholdem.domain.entities;

import org.example.texasholdem.domain.use_cases.interactors.hand_value_calculators.FlushCalculator;
import org.example.texasholdem.domain.use_cases.interactors.hand_value_calculators.FourOfAKindCalculator;
import org.example.texasholdem.domain.use_cases.interactors.hand_value_calculators.FullHouseCalculator;
import org.example.texasholdem.domain.use_cases.interactors.hand_value_calculators.HandValueCalculator;
import org.example.texasholdem.domain.use_cases.interactors.hand_value_calculators.HighCardCalculator;
import org.example.texasholdem.domain.use_cases.interactors.hand_value_calculators.PairCalculator;
import org.example.texasholdem.domain.use_cases.interactors.hand_value_calculators.RoyalFlushCalculator;
import org.example.texasholdem.domain.use_cases.interactors.hand_value_calculators.StraightCalculator;
import org.example.texasholdem.domain.use_cases.interactors.hand_value_calculators.StraightFlushCalculator;
import org.example.texasholdem.domain.use_cases.interactors.hand_value_calculators.ThreeOfAKindCalculator;
import org.example.texasholdem.domain.use_cases.interactors.hand_value_calculators.TwoPairCalculator;

public enum HandValue {

    HIGH_CARD(new HighCardCalculator()),
    PAIR(new PairCalculator()),
    TWO_PAIR(new TwoPairCalculator()),
    THREE_OF_A_KIND(new ThreeOfAKindCalculator()),
    STRAIGHT(new StraightCalculator()),
    FLUSH(new FlushCalculator()),
    FULL_HOUSE(new FullHouseCalculator()),
    FOUR_OF_A_KIND(new FourOfAKindCalculator()),
    STRAIGHT_FLUSH(new StraightFlushCalculator()),
    ROYAL_FLUSH(new RoyalFlushCalculator());

    private final HandValueCalculator calculator;

    HandValue(HandValueCalculator calculator) {
        this.calculator = calculator;
    }

    public HandValueCalculator getCalculator() {
        return calculator;
    }
}
