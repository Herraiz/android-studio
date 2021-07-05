package roberherraiz.counter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    public int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count = 0;
        showCounter();
    }

    /* Las funciones de lógica de eventos deben recibir el View, osea, el botón en estos casos */

    public void increaseCounter(View view) {
        count++;
        showCounter();
    }

    public void decreaseCounter(View view) {
        count--;
        showCounter();
    }

    public void resetCounter(View view) {
        count = 0;
        showCounter();
    }

    public void showCounter() {

        TextView counterText = findViewById(R.id.counterTextView);
        counterText.setText("" + count);

    }

}