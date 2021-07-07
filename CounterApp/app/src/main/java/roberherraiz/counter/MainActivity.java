package roberherraiz.counter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    public int count;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = (TextView) findViewById(R.id.counterText);
        count = 0;
    }

    /* Las funciones de lógica de eventos deben recibir el View, osea, el botón en estos casos */

    public void increaseCounter(View view) {
        count++;
        resultText.setText("" + count);
    }

    public void decreaseCounter(View view) {
        count--;
        if (count < 0) {
            CheckBox negatives = (CheckBox)findViewById(R.id.negativeCheckBox);
            if (!negatives.isChecked()) {
                count = 0;
            }
        }
        resultText.setText("" + count);
    }

    public void resetCounter(View view) {
        EditText resetNumber = (EditText)findViewById(R.id.nReset);

        try {
        count = Integer.parseInt(resetNumber.getText().toString());
        } catch (Exception e) {
            count = 0;
        }

        resetNumber.setText(""); // reseteamos el resetNumber
        resultText.setText("" + count);
    }



}