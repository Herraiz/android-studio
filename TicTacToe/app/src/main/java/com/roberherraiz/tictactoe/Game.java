package com.roberherraiz.tictactoe;

import java.util.Random;

public class Game {

    public final int difficulty;
    private final int[] boxes;
    private final int[][] COMBINATIONS = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 5}
    };
    public int player;

    public Game(int difficulty) {

        this.difficulty = difficulty;
        player = 1;

        boxes = new int[9];

        for (int i = 0; i < 9; i++) {

            boxes[i] = 0;

        }

    }


    public boolean checkEmpty(int box) {

        if (boxes[box] != 0) {
            return false;
        } else {
            boxes[box] = player;
        }

        return true;

    }

    public int bestPlay(int player) {

        int box = -1;

        int togetherPlays = 0;

        for (int[] combination : COMBINATIONS) {

            for (int pos : combination) {

                if (boxes[pos] == player) togetherPlays++;

                if (boxes[pos] == 0) box = pos; // possible best play

            }

            if (togetherPlays == 2 && box != -1) return box;  // best play confirmed

            /* Didn't find best play, trying another possibility  */
            box = -1;
            togetherPlays = 0;

        }

        return -1;
    }

    public int ia() {

        int box;

        /* If IA gets two in a row, will try to win */
        box = bestPlay(2);
        if (box != -1) return box;

        /* Prevent player 1 from winning */
        if (difficulty > 0) {
            box = bestPlay(1);
            if (box != -1) return box;
        }
        /* In insane, the IA tries to win always the game */
        if (difficulty == 2) {
            if (boxes[0]==0) return 0;
            if (boxes[2]==0) return 2;
            if (boxes[6]==0) return 6;
            if (boxes[8]==0) return 8;
        }

        Random randomBox = new Random();

        box = randomBox.nextInt(9);

        return box;
    }

    public int turn() {

        boolean tie = true;
        boolean lastMove;


        for (int[] combination : COMBINATIONS) {

            lastMove = true;

            for (int pos : combination) {

                if (boxes[pos] != player) lastMove = false;

                if (boxes[pos] == 0) {
                    tie = false;
                }

            }

            if (lastMove) {
                System.out.println("Juego terminado gana " + player);
                return player;
            }


        }

        if (tie) {
            System.out.println("Empate");
            return 3;
        }

        player = player % 2 + 1;
        return 0;

    }
}