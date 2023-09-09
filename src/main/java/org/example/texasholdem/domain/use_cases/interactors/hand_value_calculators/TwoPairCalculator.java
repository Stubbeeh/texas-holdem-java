package org.example.texasholdem.domain.use_cases.interactors.hand_value_calculators;

import org.example.texasholdem.domain.entities.Card;
import org.example.texasholdem.domain.entities.Hand;
import org.example.texasholdem.domain.entities.HandValue;
import org.example.texasholdem.domain.entities.Rank;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class TwoPairCalculator implements HandValueCalculator {
    @Override
    public HandValue calculate(Hand hand) {
        Map<Rank, List<Card>> groupedCards = hand.getCards().stream().collect(groupingBy(Card::rank));

        List<Map.Entry<Rank, List<Card>>> pairs =
                groupedCards.entrySet().stream()
                        .filter(entry -> entry.getValue().size() == 2)
                        .toList();

        if (pairs.size() > 1) {
            return HandValue.TWO_PAIR;
        }
        return null;
    }
}
