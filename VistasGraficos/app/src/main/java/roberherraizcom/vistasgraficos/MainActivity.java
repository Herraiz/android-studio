package roberherraizcom.vistasgraficos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiPropiaVista(this));
    }

    public class MiPropiaVista extends View {

        public MiPropiaVista(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            Paint myBrush = new Paint();
            myBrush.setColor(Color.BLUE);
            myBrush.setStrokeWidth(8);
            myBrush.setStyle(Paint.Style.STROKE);

            canvas.drawCircle(175, 175, 100, myBrush);
        }

    }

}