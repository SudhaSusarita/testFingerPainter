package com.example.psxssb.myapplication;
/**
 * @author Sudha Susarita Balaguru
 *
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Defines and handles the color palette
 */
public class ColorPickerActivity extends AppCompatActivity {
    Button r1, r2, r3, g1, g2, g3, b1, b2, b3;
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);
        displayCurrentElements();

    }

    /**
     * Displays current elements
     */
    private void displayCurrentElements() {
        Bundle bundle = getIntent().getExtras();
        int colorCode=0;
        if(bundle!=null){
            colorCode = bundle.getInt("Color");}
        Toast.makeText(getApplicationContext(), "The Current Color is displayed", Toast.LENGTH_SHORT).show();
        Button colorButton = findViewById(R.id.btCurrentColor);
        colorButton.setBackgroundColor(colorCode);
    }

    /**
     * Destroys the activity
     * @param v-view object
     */
    public void onCancel(View v) {
        finish();
    }

    /**
     * Picks color based on selection
     * @param v -view object
     */
    public void onChooseColor(View v) {
        r1 =  findViewById(R.id.buttonRed1);
        r2 =  findViewById(R.id.buttonRed2);
        r3 =  findViewById(R.id.buttonRed3);
        g1 =  findViewById(R.id.buttonGreen1);
        g2 =  findViewById(R.id.buttonGreen2);
        g3 =  findViewById(R.id.buttonGreen3);
        b1 =  findViewById(R.id.buttonBlue1);
        b2 =  findViewById(R.id.buttonBlue2);
        b3 =  findViewById(R.id.buttonBlue3);
               switch (v.getId()) {
            case R.id.buttonRed1:
                colorHighlighter(r1);
                break;
            case R.id.buttonRed2:
                colorHighlighter(r2);
                break;
            case R.id.buttonRed3:
                colorHighlighter(r3);
                break;
            case R.id.buttonGreen1:
                colorHighlighter(g1);
                break;
            case R.id.buttonGreen2:
                colorHighlighter(g2);
                break;
            case R.id.buttonGreen3:
                colorHighlighter(g3);
                break;
            case R.id.buttonBlue1:
                colorHighlighter(b1);
                break;
            case R.id.buttonBlue2:
                colorHighlighter(b2);
                break;
            case R.id.buttonBlue3:
                colorHighlighter(b3);
                break;
        }
    }

    /**
     * Defining onClick operation of color palette
     * @param b button object
     */
    private void colorHighlighter(Button b) {
        ColorDrawable buttonColor = (ColorDrawable) b.getBackground();
        int colorId = buttonColor.getColor();
        Intent result = new Intent();
        result.putExtra("Color", colorId);
        setResult(Activity.RESULT_OK, result);
        finish();
    }
}