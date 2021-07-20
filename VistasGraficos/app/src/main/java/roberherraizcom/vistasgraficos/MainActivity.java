package roberherraizcom.vistasgraficos;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
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

           /* Forma de dibujar sin usar path
            Paint myBrush = new Paint();
            myBrush.setColor(Color.argb(185, 168, 155, 255));
            myBrush.setStrokeWidth(8);
            myBrush.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(175, 175, 100, myBrush);

            int myColor;
            myColor = ContextCompat.getColor(getContext(), R.color.circleFill);
            myBrush.setColor(myColor);
            myBrush.setStyle(Paint.Style.FILL);
            canvas.drawCircle(175, 175, 100, myBrush); */

            /* Dibujamos un círculo */
            Path myPath = new Path();
            myPath.addCircle(350, 350, 200, Path.Direction.CCW);
            Paint myBrush = new Paint();
            myBrush.setColor(Color.RED);
            myBrush.setStrokeWidth(8);
            myBrush.setStyle(Paint.Style.STROKE);
            canvas.drawPath(myPath, myBrush);

            /* Escribimos en el círculo */
            myBrush.setStrokeWidth(1);
            myBrush.setStyle(Paint.Style.FILL);
            myBrush.setTextSize(40);
            myBrush.setTypeface(Typeface.SANS_SERIF);
            canvas.drawTextOnPath("Curso Android Píldoras Informáticas", myPath,40, 100, myBrush);



        }

    }

}