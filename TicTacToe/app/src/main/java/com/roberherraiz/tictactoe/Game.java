package com.roberherraiz.tictactoe;

import java.util.Random;

public class Game {

    public final int difficulty;
    public int player;
    private final int[] boxes;

    public Game(int difficulty) {

        this.difficulty = difficulty;
        player = 1;

        boxes = new int[9];

        for (int i = 0; i<9; i++) {

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

    public void turn() {
        player = player%2+1;
    }

}