package au.edu.jcu.assignment1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String POS1 = "position1";
    private static final String POS2 = "position2";
    private String position1;
    private String position2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button covertButton;
        Button settingsButton;
        final TextView to_convert;
        final TextView from_convert;
        final EditText measurementInput;
        final TextView textView;

        to_convert = (TextView) findViewById(R.id.to_convert);
        from_convert = (TextView) findViewById(R.id.from_convert);
        settingsButton = (Button) findViewById(R.id.settingsButton);
        covertButton = (Button) findViewById(R.id.convertButton);
        measurementInput = (EditText) findViewById(R.id.measurement);
        textView = (TextView) findViewById(R.id.textView);

        if (savedInstanceState != null) {
            position1 = savedInstanceState.getString(POS1);
            position2 = savedInstanceState.getString(POS2);
            from_convert.setText(position2);
            to_convert.setText(position1);
        }
        else {
            position1 = "Inch";
            position2 = "Inch";
        }

        covertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (measurementInput.getText().toString().isEmpty()) {
                    textView.setError("Please enter a number");
                } else {
                    double input = Double.parseDouble(measurementInput.getText().toString());
                    Unit fromUnit = Unit.valueOf(position1.toUpperCase());
                    Unit toUnit = Unit.valueOf(position2.toUpperCase());

                    Converter converter = new Converter(fromUnit, toUnit);
                    double result = converter.convert(input);
                    textView.setText(String.valueOf(result));
                    from_convert.setText(position2);
                    to_convert.setText(position1);
                }
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();

            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(POS1, position1);
        outState.putString(POS2, position2);
    }

    public void openSettings(){
        Intent intent = new Intent(this, Settings.class);
        startActivityForResult(intent, Settings.SETTINGS_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Settings.SETTINGS_REQUEST) {
            if (resultCode == RESULT_OK) {
                assert data != null;
                position1 = data.getStringExtra("position1");
                position2 = data.getStringExtra("position2");
            }
        }
    }
}
