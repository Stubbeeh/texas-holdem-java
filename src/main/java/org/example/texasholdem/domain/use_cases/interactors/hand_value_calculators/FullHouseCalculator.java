package org.example.texasholdem.domain.use_cases.interactors.hand_value_calculators;

import org.example.texasholdem.domain.entities.Card;
import org.example.texasholdem.domain.entities.Hand;
import org.example.texasholdem.domain.entities.HandValue;
import org.example.texasholdem.domain.entities.Rank;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class FullHouseCalculator implements HandValueCalculator {
    @Override
    public HandValue calculate(Hand hand) {
        Map<Rank, List<Card>> groupedCards = hand.getCards().stream().collect(groupingBy(Card::rank));

        List<Rank> listOfThreeOfAKind =
                groupedCards.entrySet().stream()
                        .filter(entry -> entry.getValue().size() > 2)
                        .map(Map.Entry::getKey).toList();

        if (listOfThreeOfAKind.size() > 1) {
            return HandValue.FULL_HOUSE;
        }
        List<Rank> listOfOtherPairs = groupedCards.entrySet().stream()
                .filter(entry -> !listOfThreeOfAKind.contains(entry.getKey()))
                .filter(entry -> entry.getValue().size() > 1)
                .map(Map.Entry::getKey).toList();

        if (!listOfOtherPairs.isEmpty()) {
            return HandValue.FULL_HOUSE;
        }
        return null;
    }
}
