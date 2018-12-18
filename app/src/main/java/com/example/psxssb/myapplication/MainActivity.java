package com.example.psxssb.myapplication;
/**
 * @author Sudha Susarita Balaguru
 *
 */
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final int ACTIVITY_TWO_REQUEST_CODE = 1;
    private static final int ACTIVITY_THREE_REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Launch activity from Downloads*/
        FingerSketchView fingerSketchView = findViewById(R.id.view2);
        fingerSketchView.load(getIntent().getData());
    }

    /*
      Choosing Brush Type
     * @param v
     */

    public void onBrushType(View v) {
        Intent intent = new Intent(MainActivity.this, BrushPicker.class);
        Bundle bundle = new Bundle();
        FingerSketchView fingerSketchView = findViewById(R.id.view2);
        bundle.putString("shape", fingerSketchView.getBrush().toString());
        bundle.putInt("size", fingerSketchView.getBrushWidth());
        intent.putExtras(bundle);
        startActivityForResult(intent, 2);
    }

    /**
     * Choosing color from Color palette
     * @param v -view object
     */
    public void onChooseColor(View v) {

        Intent intent = new Intent(MainActivity.this, ColorPickerActivity.class);
        Bundle bundle = new Bundle();
        FingerSketchView fingerSketchView = findViewById(R.id.view2);
        bundle.putInt("Color", fingerSketchView.getColour());
        intent.putExtras(bundle);
        startActivityForResult(intent, 1);
    }

    /**
     * Handling return response from corresponding activities
     * @param requestCode -request code to receive response
     * @param resultCode -result code to receive response
     * @param data -data to get response
     */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == ACTIVITY_TWO_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Bundle bundle = data.getExtras();
                int colorId=0;
                if(bundle!=null){
                colorId = bundle.getInt("Color");}
                FingerSketchView fingerSketchView = findViewById(R.id.view2);
                fingerSketchView.setColour(colorId);

            } else if (resultCode == RESULT_CANCELED) {
//cancelled
            }
        } else if (requestCode == ACTIVITY_THREE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Bundle bundle = data.getExtras();
                if(bundle!=null) {
                    Paint.Cap brushShape = (Paint.Cap) bundle.get("shape");
                    FingerSketchView fingerSketchView = findViewById(R.id.view2);
                    int brushSize = bundle.getInt("size");
                    fingerSketchView.setBrush(brushShape);
                    fingerSketchView.setBrushWidth(brushSize);
                }
            } else if (resultCode == RESULT_CANCELED) {

            }
        }
    }

    /**
     * Closes the application
     * @param v view object
     */
    public void onExit(View v) {
        finish();
    }
}
