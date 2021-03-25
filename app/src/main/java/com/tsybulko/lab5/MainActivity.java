package com.tsybulko.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public final static String EXTRA_MESSAGE = "MESSAGE";

    Button btn;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.textEdit);
        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        String message = editText.getText().toString();
        if (!message.equals("")) {
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    R.string.toast, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}