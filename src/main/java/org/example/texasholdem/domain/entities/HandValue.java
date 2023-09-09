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

    HIGH_CARD(new HighCardCalculator(), "High Card"),
    PAIR(new PairCalculator(), "Pair"),
    TWO_PAIR(new TwoPairCalculator(), "Two Pair"),
    THREE_OF_A_KIND(new ThreeOfAKindCalculator(), "Three of a Kind"),
    STRAIGHT(new StraightCalculator(), "Straight"),
    FLUSH(new FlushCalculator(), "Flush"),
    FULL_HOUSE(new FullHouseCalculator(), "Full House"),
    FOUR_OF_A_KIND(new FourOfAKindCalculator(), "Four of a Kind"),
    STRAIGHT_FLUSH(new StraightFlushCalculator(), "Straight Flush"),
    ROYAL_FLUSH(new RoyalFlushCalculator(), "Royal Flush");

    private final HandValueCalculator calculator;
    private final String libelle;

    HandValue(HandValueCalculator calculator, String libelle) {
        this.calculator = calculator;
        this.libelle = libelle;
    }
    public HandValueCalculator getCalculator() {
        return calculator;
    }

    public String getLibelle() {
        return libelle;
    }
}
