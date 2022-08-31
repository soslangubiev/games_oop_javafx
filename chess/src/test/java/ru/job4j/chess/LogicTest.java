package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.black.*;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static ru.job4j.chess.firuges.Cell.*;

public class LogicTest {
    @Test
    public void moveShouldThrowExceptionWhenNoFigureInCell() {
        Logic logic = new Logic();
        assertThatExceptionOfType(FigureNotFoundException.class)
                .isThrownBy(() -> logic.move(A1, B2));
    }

    @Test
    public void moveShouldThrowExceptionWhenWayIsNotFree() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(F8));
        logic.add(new PawnBlack(G7));
        assertThatExceptionOfType(OccupiedCellException.class)
                .isThrownBy(() -> logic.move(F8, G7));
    }

    @Test
    public void moveShouldThrowExceptionWhenMovieIsImpossible() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(C8));
        assertThatExceptionOfType(ImpossibleMoveException.class)
                .isThrownBy(() -> logic.move(C8, C7));
    }
}