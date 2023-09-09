package org.example.texasholdem.domain.use_cases;

import org.example.texasholdem.domain.entities.Hand;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class ComputeGameUTest {

    @InjectMocks
    private ComputeGame computeGame;

    @Test
    void execute_should_return_the_list_of_entryHands_with_the_winning_one() {
        // Given
        Hand losingHand = new Hand(List.of());
        Hand winningHand = new Hand(List.of());

        List<Hand> entryHands = List.of(losingHand, winningHand);
        // When
        List<Hand> hands = computeGame.execute(entryHands);

        // Then
        assertSame(hands, entryHands);
        assertTrue(winningHand.getWinning());
    }
}