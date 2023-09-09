package org.example.texasholdem.domain.use_cases.interactors.hand_value_calculators;

import org.example.texasholdem.domain.entities.Card;
import org.example.texasholdem.domain.entities.Hand;
import org.example.texasholdem.domain.entities.HandValue;
import org.example.texasholdem.domain.entities.Rank;

import java.util.Comparator;

public class RoyalFlushCalculator implements HandValueCalculator {
    @Override
    public HandValue calculate(Hand hand) {
        hand.getCards().sort(Comparator.comparing(Card::rank).reversed());
        Card lastCard = hand.getCards().get(0);
        int numberOfCardsStraight = 1;
        int cardIndex = 1;
        int handSize = hand.getCards().size();

        while (cardIndex < handSize) {
            Card currentCard = hand.getCards().get(cardIndex);
            if (numberOfCardsStraight == 1 && lastCard.rank() != Rank.AS) {
                break;
            }
            if (currentCard.rank().ordinal() == lastCard.rank().ordinal() - 1
                    && lastCard.suit().equals(currentCard.suit())) {
                numberOfCardsStraight++;
            } else {
                numberOfCardsStraight = 1;
            }
            lastCard = currentCard;
            ++cardIndex;
        }
        if (numberOfCardsStraight == 5) {
            return HandValue.ROYAL_FLUSH;
        }
        return null;
    }
}
