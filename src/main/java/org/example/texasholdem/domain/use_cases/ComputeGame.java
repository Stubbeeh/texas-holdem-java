package org.example.texasholdem.domain.use_cases;

import org.example.texasholdem.domain.entities.Card;
import org.example.texasholdem.domain.entities.Hand;

import java.util.List;

public class ComputeGame {

    public List<Hand> execute(List<Hand> entryHands) {
        Hand hand = entryHands.get(0);
        hand.setWinning(true);
        return entryHands;
    }
}
