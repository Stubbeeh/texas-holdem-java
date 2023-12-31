package org.example.texasholdem.domain.use_cases.interactors;

import org.example.texasholdem.domain.entities.Hand;
import org.example.texasholdem.domain.entities.HandValue;

import static java.util.Arrays.stream;

public class ComputeAndSetHandValue {

    public static final int CORRECT_HAND_SIZE = 7;

    public void compute(Hand hand) {
        if (hand == null || hand.getCards() == null || hand.getCards().size() != CORRECT_HAND_SIZE) {
            return;
        }
        stream(HandValue.values()).forEach(
                handValue -> computeAndReplace(hand, handValue)
        );
    }

    private void computeAndReplace(Hand hand, HandValue handValue) {
        HandValue computedHandValue = handValue.getCalculator().calculate(hand);
        if (computedHandValue != null
            && (hand.getHandValue() == null
                || computedHandValue.ordinal() > hand.getHandValue().ordinal())) {
            hand.setHandValue(computedHandValue);
        }
    }
}
