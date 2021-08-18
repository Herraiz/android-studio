package com.roberherraiz.tictactoe;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

    private int players;
    private int[] boxes;
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* We start the boxes array to identify each box */

        boxes = new int[9];

        boxes[0] = R.id.a1;
        boxes[1] = R.id.a2;
        boxes[2] = R.id.a3;

        boxes[3] = R.id.b1;
        boxes[4] = R.id.b2;
        boxes[5] = R.id.b3;

        boxes[6] = R.id.c1;
        boxes[7] = R.id.c2;
        boxes[8] = R.id.c3;

    }

    public void playNow(View view) {
        ImageView blankBox;
        for (int box: boxes) {
            blankBox = findViewById(box);
            blankBox.setImageResource(R.drawable.box);
        }

        /* Number of players */

        players = 1;

        if(view.getId() == R.id.multiplayer) {
            players = 2;
        }

        /* Difficulty level */

        RadioGroup configDifficulty = findViewById(R.id.difficultyGroup);

        int id = configDifficulty.getCheckedRadioButtonId();

        int difficulty = 0;

        if (id == R.id.normal) {
            difficulty = 1;
        } else if (id == R.id.insane) {
            difficulty = 2;
        }

        game = new Game(difficulty);

        /* Deactivating the buttons */

        showButtons(false);

    }

    private void showButtons(boolean b) {
        findViewById(R.id.singleplayer).setEnabled(b);
        findViewById(R.id.multiplayer).setEnabled(b);
        // findViewById(R.id.difficultyGroup).setAlpha(0);  // Así los ponemos todos en "desactivado"
        findViewById(R.id.easy).setEnabled(b);
        findViewById(R.id.normal).setEnabled(b);
        findViewById(R.id.insane).setEnabled(b);
    }

    public void tap(View view) {

        if (game == null) {
         return;
        }

        int box = 0;

        for (int i=0; i<9; i++) {
            if (boxes[i] == view.getId()) {
                box = i;
                break;
            }
        }

        /* Playing */
        if (!game.checkEmpty(box)) {
            return;
        }

        mark(box);

        int result = game.turn();

        if (result > 0) {

            finish(result);
            return;

        }

        if (players == 1) {

            box = game.ia();

            while (!game.checkEmpty(box)) {
                box = game.ia();
            }

            mark(box);

            result = game.turn();

            if (result > 0) {

                finish(result);

            }
        }

    }

    private void finish(int result) {

        String msg;

        if (result == 1) msg = "Gana el Jugador 1";
        else if (result == 2) msg = "Gana el Jugador 2";
        else msg = "Empate";

        sendToast(this, msg, 2);
        game = null;
        showButtons(true);


    }

    private void mark(int box) {

        ImageView boxImage = findViewById(boxes[box]);

        if (game.player == 1) {
            boxImage.setImageResource(R.drawable.circle);
        } else {
            boxImage.setImageResource(R.drawable.cross);
        }


    }

    public void sendToast(Context context, CharSequence text, int duration) {
        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

}