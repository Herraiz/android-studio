package roberherraiz.asteroids;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* Creamos un método con la intención que ejecutará nuestra nueva actividad */
    public void run_about(View view) {
        Intent i = new Intent(this, AboutActivity.class);
        startActivity(i);

    }

}