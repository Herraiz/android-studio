package roberherraiz.counter;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    public int counter;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = findViewById(R.id.counterText);
        counter = 0;

        resultText.setText("" + counter);

        KeyboardEvent keyboard = new KeyboardEvent();
        EditText nReset = findViewById(R.id.nReset);
        nReset.setOnEditorActionListener(keyboard);

    }

    /* Cuidado con el nombre de los métodos :) */

    /* Sustituimos bundle por sharedPreferences
    @Override
    public void onSaveInstanceState(Bundle state) {

        state.putInt("counter", counter);

        // Llamamos al método de la clase padre y le enviamos el bundle
        super.onSaveInstanceState(state);

    }

    @Override
    public void onRestoreInstanceState(Bundle state) {

        // Llamamos al método padre para recuperar el bundle. Posteriormente extraemos la info
        super.onRestoreInstanceState(state);
        counter = state.getInt("counter");
        resultText.setText("" + counter);

    }
    */

    /* sharedPreferences.xml sobrescribiendo los métodos onPause() y onResume() */

    @Override
    public void onPause(){
        super.onPause();

        SharedPreferences data = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor myEditor = data.edit();
        myEditor.putInt("counter", counter);
        myEditor.apply();
    }

    public void onResume(){
        super.onResume();

        SharedPreferences data = PreferenceManager.getDefaultSharedPreferences(this);
        counter = data.getInt("counter", 0);
        resultText.setText("" + counter);

    }

    /* Las funciones de lógica de eventos deben recibir el View, osea, el botón en estos casos */

    public void increaseCounter(View view) {
        counter++;
        resultText.setText(getString(R.string.counterText, counter));
    }

    public void decreaseCounter(View view) {
        counter--;
        if (counter < 0) {
            CheckBox negatives = findViewById(R.id.negativeCheckBox);
            if (!negatives.isChecked()) {
                counter = 0;
            }
        }
        resultText.setText(getString(R.string.counterText, counter));
    }

    public void resetCounter(View view) {
        EditText resetNumber = findViewById(R.id.nReset);

        try {
        counter = Integer.parseInt(resetNumber.getText().toString());
        } catch (Exception e) {
            counter = 0;
        }

        resetNumber.setText(""); // reseteamos el resetNumber
        resultText.setText(getString(R.string.counterText, counter));

        InputMethodManager myKeyboard = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        myKeyboard.hideSoftInputFromWindow(resetNumber.getWindowToken(), 0);

    }

    class KeyboardEvent implements TextView.OnEditorActionListener {

        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

            if (actionId == EditorInfo.IME_ACTION_DONE) {
                resetCounter(null);
            }

            return false;
        }
    }

}