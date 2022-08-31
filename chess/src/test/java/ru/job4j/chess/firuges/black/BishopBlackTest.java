package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static ru.job4j.chess.firuges.Cell.*;

public class BishopBlackTest {
    @Test
    public void positionShouldReturnPosition() {
        Figure bishop = new BishopBlack(A1);
        assertThat(bishop.position()).isEqualTo(A1);
    }

    @Test
    public void copyShouldReturnNewBishopWithDestPosition() {
        Figure bishop = new BishopBlack(F8);
        Figure bishopDest = bishop.copy(H6);
        assertThat(bishopDest.position()).isEqualTo(H6);
    }

    @Test
    public void wayShouldReturnCellArrayWhenMoveIsDiagonal() {
        Figure bishop = new BishopBlack(C1);
        Cell[] actual = bishop.way(G5);
        Cell[] expected = new Cell[]{D2, E3, F4, G5};
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void wayShouldThrowExceptionWhenMoveIsNotDiagonal() {
        Figure bishop = new BishopBlack(F8);
        assertThatExceptionOfType(ImpossibleMoveException.class)
                .isThrownBy(() -> bishop.way(F7))
                .withMessage("Could not move by diagonal from F8 to F7");
    }
}