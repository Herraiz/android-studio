package roberherraiz.segundaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ImageView img1 = findViewById(R.id.editIcon);
//
//        img1.setImageResource(android.R.drawable.ic_menu_edit);

        TextView text1 = findViewById(R.id.cancelText);
        text1.setText(android.R.string.cancel);


    }
}