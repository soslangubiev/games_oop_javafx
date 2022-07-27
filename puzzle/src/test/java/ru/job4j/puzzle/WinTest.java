package ru.job4j.puzzle;

import org.junit.Test;

import static ru.job4j.puzzle.Win.*;
import static org.junit.Assert.*;

public class WinTest {

    @Test
    public void whenVerticalWin() {
        int[][] input = {
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
        };
        boolean result = check(input);
        assertTrue(result);
    }

    @Test
    public void whenHorizontalWin() {
        int[][] input = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };
        boolean result = check(input);
        assertTrue(result);
    }

    @Test
    public void whenNotWin() {
        int[][] input = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0},
        };
        boolean result = check(input);
        assertFalse(result);
    }

    @Test
    public void whenNotWinL() {
        int[][] input = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 1, 1, 0},
        };
        boolean result = check(input);
        assertFalse(result);
    }
}