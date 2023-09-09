package org.example.texasholdem.application;

import org.example.texasholdem.domain.entities.Card;
import org.example.texasholdem.domain.entities.Hand;
import org.example.texasholdem.domain.entities.HandValue;
import org.example.texasholdem.domain.entities.Rank;
import org.example.texasholdem.domain.entities.Suit;
import org.example.texasholdem.domain.use_cases.ComputeGame;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class ParseGameFileAndComputeITest {

    public static final String EXPECTED_RESULT_GAME_1 = "expected_results/game_1";

    @InjectMocks
    private ParseGameFileAndCompute parseGameFileAndCompute;
    @Mock
    private ComputeGame computeGame;
    @Mock(answer = Answers.CALLS_REAL_METHODS)
    private HandMapper handMapper;
    @Captor
    private ArgumentCaptor<List<Hand>> listHandsArgumentCaptor;

    @Test
    void parseAndCompute_should_read_the_given_file_write_the_output_to_a_new_file() throws IOException {
        // Given
        String gameFile = "game_1";
        URL resource = getClass().getClassLoader().getResource(EXPECTED_RESULT_GAME_1);
        String expectedFile = Files.readString(Path.of(resource.getPath()));
        List<Card> cardsHand1 =
                List.of(
                        new Card(Rank.KING, Suit.SPADES),
                        new Card(Rank.QUEEN, Suit.CLUBS),
                        new Card(Rank.THREE, Suit.DIAMONDS),
                        new Card(Rank.THREE, Suit.SPADES),
                        new Card(Rank.AS, Suit.HEARTS),
                        new Card(Rank.EIGHT, Suit.DIAMONDS),
                        new Card(Rank.FIVE, Suit.SPADES)
                );
        List<Card> cardsHand2 =
                List.of(
                        new Card(Rank.SEVEN, Suit.CLUBS),
                        new Card(Rank.THREE, Suit.SPADES)
                );
        Hand hand1 = new Hand(cardsHand1);
        hand1.setHandValue(HandValue.PAIR);
        hand1.hasWon(true);

        Hand hand2 = new Hand(cardsHand2);
        List<Hand> expectedParsedHands = List.of(hand1, hand2);

        doReturn(expectedParsedHands).when(computeGame).execute(listHandsArgumentCaptor.capture());

        // When
        parseGameFileAndCompute.parseAndCompute(gameFile);

        // Then
        List<Hand> parsedHands = listHandsArgumentCaptor.getValue();

        assertThat(parsedHands).usingRecursiveFieldByFieldElementComparatorIgnoringFields("handValue", "isWinning").isEqualTo(expectedParsedHands);
        URL output = getClass().getClassLoader().getResource("game_1");
        Path outputPath = Path.of(output.getPath() + "_out");
        String generatedFile = Files.readString(outputPath);
        assertEquals(expectedFile, generatedFile);
        Files.delete(outputPath);
    }

}