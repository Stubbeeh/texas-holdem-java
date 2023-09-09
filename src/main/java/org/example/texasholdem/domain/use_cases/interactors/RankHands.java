package org.example.texasholdem.domain.use_cases.interactors;

import org.example.texasholdem.domain.entities.Hand;
import org.example.texasholdem.domain.entities.HandValue;

import java.util.Comparator;
import java.util.List;

public class RankHands {
    public List<Hand> rank(List<Hand> hands) {
        List<Hand> rankedHands = hands.stream().sorted(Comparator.comparing(Hand::getHandValue).reversed()).toList();
        HandValue highestHandValue = rankedHands.get(0).getHandValue();
        rankedHands.stream()
                .filter(hand -> highestHandValue.equals(hand.getHandValue()))
                .forEach(hand -> hand.setWinning(true));

        return rankedHands;
    }
}
