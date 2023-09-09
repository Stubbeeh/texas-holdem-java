package org.example.texasholdem.domain.use_cases.interactors.hand_value_calculators;

import org.example.texasholdem.domain.entities.Card;
import org.example.texasholdem.domain.entities.Hand;
import org.example.texasholdem.domain.entities.HandValue;

import java.util.Comparator;

public class StraightFlushCalculator implements HandValueCalculator {
    @Override
    public HandValue calculate(Hand hand) {
        hand.getCards().sort(Comparator.comparing(card -> card.rank().ordinal()));
        Card lastCard = hand.getCards().get(0);
        int numberOfCardsStraight = 1;
        int cardIndex = 1;
        int handSize = hand.getCards().size();

        while (cardIndex < handSize) {
            Card currentCard = hand.getCards().get(cardIndex);
            if (currentCard.rank().ordinal() == lastCard.rank().ordinal() + 1
                    && lastCard.suit().equals(currentCard.suit())) {
                numberOfCardsStraight++;
            } else {
                numberOfCardsStraight = 1;
            }
            lastCard = currentCard;
            ++cardIndex;
        }
        if (numberOfCardsStraight == 5) {
            return HandValue.STRAIGHT_FLUSH;
        }
        return null;
    }
}
