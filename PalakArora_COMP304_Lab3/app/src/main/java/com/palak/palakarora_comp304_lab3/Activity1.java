package com.palak.palakarora_comp304_lab3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity1 extends AppCompatActivity {

    String[] options = { "10", "20","30","40 "};

    private ImageView imageCanvas;
    private Bitmap imageBitmap;
    private Canvas canvas;
    private ImageButton imageButtonUp;
    private ImageButton imageButtonDown;
    private ImageButton imageButtonLeft;
    private ImageButton imageButtonRight;
    private TextView status;

    int currentX = 0;
    int currentY = 0;
    int sizeLine = 10;

    String size = options[0];
    String color = "";
    String direction = "down";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        imageCanvas = (ImageView) findViewById(R.id.imageCanvas);
        imageButtonUp = (ImageButton) findViewById(R.id.imageButtonUp);
        imageButtonDown = (ImageButton) findViewById(R.id.imageButtonDown);
        imageButtonLeft = (ImageButton) findViewById(R.id.imageButtonLeft);
        imageButtonRight = (ImageButton) findViewById(R.id.imageButtonRight);
        status = (TextView) findViewById(R.id.status);
        Spinner spin = (Spinner) findViewById(R.id.spinnerThickness);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                size = options[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                size = options[0];
            }
        });

        onCleanClicked(null);
    }

    public void onCleanClicked(View v){
        imageBitmap = Bitmap.createBitmap(400, 400,
                Bitmap.Config.ARGB_8888);
        imageCanvas.setImageBitmap(imageBitmap);
        canvas = new Canvas(imageBitmap);
        currentY = 110;
        currentX = 100;
    }

    public void onRadioButtonClicked(View v){
        boolean  checked = ((RadioButton) v).isChecked();
        switch(v.getId()){
            case R.id.radioButtonRed:
                if(checked)
                    color = "Red";
                break;
            case R.id.radioButtonCyan:
                if(checked)
                    color = "Cyan";
                break;
            case R.id.radioButtonYellow:
                if(checked)
                    color = "Yellow";
        }
    }

    public void onImageButtonClicked(View v) {
        if (v == imageButtonUp) {
            direction = "up";
        }else if (v == imageButtonDown){
            direction = "down";
        }else if (v==imageButtonRight){
            direction = "right";
        }
        else if (v==imageButtonLeft) {
            direction = "left";
        }
        if (!color.equals(""))
            draw();
        else
            Toast.makeText(this, "Please select a colour", Toast.LENGTH_SHORT).show();
    }

    public void draw() {
        Paint linePaint = new Paint();
        if (color.equals("Red"))
            linePaint.setColor(Color.RED);
        else if  (color.equals("Yellow"))
            linePaint.setColor(Color.YELLOW);
        else if  (color.equals("Cyan"))
            linePaint.setColor(Color.CYAN);
        linePaint.setStrokeWidth(Integer.valueOf(size));

        if (direction.equals("down" )){
            canvas.drawLine(currentX, currentY,currentX, currentY+sizeLine, linePaint);
            currentY += sizeLine;
        } else if (direction.equals("up" )){
            canvas.drawLine(currentX, currentY,currentX, currentY-sizeLine, linePaint);
            currentY -= sizeLine;
        } else if (direction.equals("left" )){
            canvas.drawLine(currentX, currentY,currentX-sizeLine, currentY, linePaint);
            currentX-=sizeLine;
        } else if (direction.equals("right" )){
            canvas.drawLine(currentX, currentY,currentX+sizeLine, currentY, linePaint);
            currentX+=sizeLine;
        }
        status.setText("X = " + String.valueOf(currentX  ) + "  Y = "+ String.valueOf(currentY ) );
    }
}
