package org.example.texasholdem.application;

import org.example.texasholdem.domain.entities.Hand;
import org.example.texasholdem.domain.use_cases.ComputeGame;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ParseGameFileAndCompute {

    private final ComputeGame computeGame;
    private final HandMapper handMapper;

    public ParseGameFileAndCompute(ComputeGame computeGame, HandMapper handMapper) {
        this.computeGame = computeGame;
        this.handMapper = handMapper;
    }

    public void parseAndCompute(String file) throws IOException {
        URL pathIn = getClass().getClassLoader().getResource(file);
        List<String> parsedHands = Files.readAllLines(Path.of(pathIn.getPath()));
        List<Hand> hands = parsedHands.stream().map(handMapper::toHand).toList();
        hands = computeGame.execute(hands);

        String pathOut = getClass().getClassLoader().getResource(file).getPath();
        Path result = Files.createFile(Path.of(pathOut + "_out"));
        hands.stream().map(handMapper::toString)
                .forEach(hand -> {
                    try {
                        Files.writeString(result, hand, StandardOpenOption.APPEND);
                        System.out.print(hand);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
