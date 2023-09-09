package org.example.texasholdem.domain.use_cases.interactors.hand_value_calculators;

import org.example.texasholdem.domain.entities.Card;
import org.example.texasholdem.domain.entities.Hand;
import org.example.texasholdem.domain.entities.HandValue;
import org.example.texasholdem.domain.entities.Rank;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class PairCalculator implements HandValueCalculator {
    @Override
    public HandValue calculate(Hand hand) {
        Map<Rank, List<Card>> groupedCards = hand.getCards().stream().collect(groupingBy(Card::rank));

        if (groupedCards.entrySet().stream().anyMatch(entry -> entry.getValue().size() == 2)) {
            return HandValue.PAIR;
        }
        return null;
    }
}
