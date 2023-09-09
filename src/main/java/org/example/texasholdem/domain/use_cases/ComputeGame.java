package org.example.texasholdem.domain.use_cases;

import org.example.texasholdem.domain.entities.Hand;
import org.example.texasholdem.domain.use_cases.interactors.ComputeAndSetHandValue;
import org.example.texasholdem.domain.use_cases.interactors.RankHands;

import java.util.List;

public class ComputeGame {
    private final ComputeAndSetHandValue computeAndSetHandValue;
    private final RankHands rankHands;

    public ComputeGame(ComputeAndSetHandValue computeAndSetHandValue, RankHands rankHands) {
        this.computeAndSetHandValue = computeAndSetHandValue;
        this.rankHands = rankHands;
    }

    public List<Hand> execute(List<Hand> hands) {
        hands.forEach(computeAndSetHandValue::compute);
        hands = rankHands.rank(hands);
        return hands;
    }
}
