package com.example.tehtava5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    TextView errorText, fileName;
    EditText inputText;
    String textString;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputText = findViewById(R.id.textView);
        fileName = findViewById(R.id.fileName);
        errorText = findViewById(R.id.errorText);
        context = MainActivity.this;

        System.out.println(context.getFilesDir());

    }
    public void readFile(View v){
        try {
            InputStream input = context.openFileInput(fileName.getText().toString());
            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            String s = "";
            String output = "";
            while ((s=br.readLine()) != null) {
                output = output + s;
            }
            inputText.setText(output);
            br.close();
            errorText.setVisibility(View.INVISIBLE);
        } catch (IOException e) {
            Log.e("IOExpection", "Error occurred reading file ");
            errorText.setTextColor(Color.RED);
            errorText.setText("File not found");
            errorText.setVisibility(View.VISIBLE);
        }
    };
    public void writeFile(View v){
        try {
            OutputStreamWriter outputter = new OutputStreamWriter(context.openFileOutput(fileName.getText().toString(), Context.MODE_PRIVATE));
            String s = inputText.getText().toString();
            outputter.write(s);
            outputter.close();
            errorText.setTextColor(Color.GREEN);
            errorText.setText("Text was saved to file");
            errorText.setVisibility(View.VISIBLE);
        } catch (IOException e) {
            Log.e("IOExpection", "Error occurred writing file ");
            errorText.setTextColor(Color.RED);
            errorText.setText("Something went wrong");
            errorText.setVisibility(View.VISIBLE);
        }
    };
}