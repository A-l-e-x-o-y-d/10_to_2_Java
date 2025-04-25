package com.example.dec2bin;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import java.lang.Math;

public class MainActivity extends Activity implements OnClickListener {

    private Button btnConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConvert = (Button) findViewById(R.id.btnConvert);

        btnConvert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (btnConvert.equals(v)) {
            int dec = -1;
            EditText decText = (EditText) findViewById(R.id.decText);
            if (decText.isFocused()) {
                String decStr = decText.getText().toString();
                if (decStr.length() > 0 && decStr.length() < 9)
                    dec = Integer.parseInt(decStr);
                if (dec >= 0) {
                    String bin = "";
                    while (dec != 0) {
                        if (dec % 2 == 0)
                            bin = "0" + bin;
                        else
                            bin = "1" + bin;
                        dec = dec / 2;
                    }
                    EditText binText = (EditText) findViewById(R.id.binText);
                    binText.setText(bin);
                }
            }
        }

        if (btnConvert.equals(v)) {
            int dec = 0;
            EditText binText = (EditText) findViewById(R.id.binText);
            if (binText.isFocused()) {
                String binStr = binText.getText().toString();
                for (int i = 0, j = binStr.length() - 1; i < binStr.length(); i++) {
                    char symbol = binStr.charAt(i);
                    if (symbol == '1')
                        dec = (int) (dec + Math.pow(2, j));
                    j--;
                }
                EditText decText = (EditText) findViewById(R.id.decText);
                String decString = Integer.toString(dec);
                decText.setText(decString);
            }
        }

    }
}