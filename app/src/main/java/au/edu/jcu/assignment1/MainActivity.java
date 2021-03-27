package au.edu.jcu.assignment1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String position1;
    private String position2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button cbutton;
        Button sbutton;
        final EditText measurement;
        final TextView textView;

        sbutton = (Button) findViewById(R.id.settingsButton);
        cbutton = (Button) findViewById(R.id.convertButton);
        measurement = (EditText) findViewById(R.id.measurement);
        textView = (TextView) findViewById(R.id.textView);

        cbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double input = Double.parseDouble(measurement.getText().toString());
                Unit fromUnit = Unit.valueOf(position1.toUpperCase());
                Unit toUnit = Unit.valueOf(position2.toUpperCase());

                Converter converter = new Converter(fromUnit,toUnit);
                double result = converter.convert(input);
                textView.setText(String.valueOf(result));

            }
        });

        sbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Settings.SETTINGS_REQUEST) {
            if (resultCode == RESULT_OK) {
                position1 = data.getStringExtra("position1");
                position2 = data.getStringExtra("position2");
            }
        }
    }

    public void openSettings(){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
}
