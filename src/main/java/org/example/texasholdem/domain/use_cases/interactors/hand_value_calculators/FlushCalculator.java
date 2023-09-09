package org.example.texasholdem.domain.use_cases.interactors.hand_value_calculators;

import org.example.texasholdem.domain.entities.Card;
import org.example.texasholdem.domain.entities.Hand;
import org.example.texasholdem.domain.entities.HandValue;
import org.example.texasholdem.domain.entities.Rank;
import org.example.texasholdem.domain.entities.Suit;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class FlushCalculator implements HandValueCalculator{
    @Override
    public HandValue calculate(Hand hand) {
        Map<Suit, List<Card>> groupedCards = hand.getCards().stream().collect(groupingBy(Card::suit));

        if (groupedCards.entrySet().stream().anyMatch(entry -> entry.getValue().size() >= 5)) {
            return HandValue.FLUSH;
        }

        return null;
    }
}
