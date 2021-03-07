package com.example.tehtava1ja2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this.testfunction();
        text = findViewById(R.id.textView);

    }

    public void testfunction (View v) {
        System.out.println("Hello world!");
        text.setText("Hello world!");
    }
}