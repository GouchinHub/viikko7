package com.example.tehtava3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    EditText inputText;
    String textString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.outputText);
        inputText = findViewById(R.id.inputText);

    }
    public void clickButtom(View v){
        textString = inputText.getText().toString();
        text.setText(textString);
    }
}