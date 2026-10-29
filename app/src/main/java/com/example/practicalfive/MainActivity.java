package com.example.practicalfive;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etMunicipality = findViewById(R.id.etMunicipality);

        etMunicipality.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_GO || actionId == EditorInfo.IME_ACTION_DONE) {
                String input = etMunicipality.getText().toString();
                String result = TextProcessor.processMunicipality(input);

                if (result == null) {
                    Toast.makeText(MainActivity.this, "Invalid municipality name!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, Municipality.class);
                    intent.putExtra("MUNICIPALITY_NAME", result);
                    startActivity(intent);
                }
                return true;
            }
            return false;
        });
    }
}