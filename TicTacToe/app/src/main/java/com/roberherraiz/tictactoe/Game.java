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

    public int ia() {

        int box;

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