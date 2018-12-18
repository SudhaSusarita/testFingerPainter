package com.example.psxssb.myapplication;
/**
 * @author Sudha Susarita Balaguru
 *
 */
import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Handles Brush type and Brush size
 */
public class BrushPicker extends AppCompatActivity {
    private Spinner spinner1, spinner2;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brush);
        addListenerOnButton();
        displayCurrentElements();
    }

    /**
     * Displays current elements
     */
    private void displayCurrentElements() {
        Spinner brushShape = findViewById(R.id.spinner1);
        Spinner brushWidth = findViewById(R.id.spinner2);
        Bundle bundle = getIntent().getExtras();
        int brushSize = 0;
        if(bundle!=null){
            brushSize = bundle.getInt("size");}
        String brushType = bundle.getString("shape");
        Toast.makeText(getApplicationContext(), "Brush shape is " + brushType+" and Brush size is " + brushSize, Toast.LENGTH_SHORT).show();

        for (int i = 0; i < brushWidth.getCount(); i++) {
            if (brushSize == Integer.parseInt(brushWidth.getItemAtPosition(i).toString()))
                brushWidth.setSelection(i);
            if (brushType!=null && brushType.equalsIgnoreCase(brushShape.getItemAtPosition(i).toString()))
                brushShape.setSelection(i);
        }
    }

    /**
     * Handles the selected items from the dropdown
     */
    private void addListenerOnButton() {

        spinner1 =  findViewById(R.id.spinner1);
        spinner2 =  findViewById(R.id.spinner2);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String shape = String.valueOf(spinner1.getSelectedItem());
                int size = Integer.parseInt(String.valueOf(spinner2.getSelectedItem()));
                Log.d("shape", shape);
                Intent result = new Intent();
                if (shape.equalsIgnoreCase("Butt")) {
                    result.putExtra("shape", Paint.Cap.BUTT);

                } else if (shape.equalsIgnoreCase("Round")) {
                    result.putExtra("shape", Paint.Cap.ROUND);

                } else {
                    result.putExtra("shape", Paint.Cap.SQUARE);

                }
                result.putExtra("size", size);
                setResult(Activity.RESULT_OK, result);
                finish();
            }
        });
    }

}