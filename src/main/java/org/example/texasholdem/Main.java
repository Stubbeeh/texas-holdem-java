package org.example.texasholdem;

import org.example.texasholdem.application.HandMapper;
import org.example.texasholdem.application.ParseGameFileAndCompute;
import org.example.texasholdem.domain.use_cases.ComputeGame;
import org.example.texasholdem.domain.use_cases.interactors.ComputeAndSetHandValue;
import org.example.texasholdem.domain.use_cases.interactors.RankHands;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ParseGameFileAndCompute parseGameFileAndCompute =
                new ParseGameFileAndCompute(
                        new ComputeGame(
                                new ComputeAndSetHandValue(),
                                new RankHands()),
                        new HandMapper());
        parseGameFileAndCompute.parseAndCompute(args[0]);
    }
}