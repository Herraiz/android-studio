package com.roberherraiz.tictactoe;

import java.util.Random;

public class Game {

    public final int difficulty;
    public int player;

    public Game(int difficulty) {

        this.difficulty = difficulty;
        player = 1;

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