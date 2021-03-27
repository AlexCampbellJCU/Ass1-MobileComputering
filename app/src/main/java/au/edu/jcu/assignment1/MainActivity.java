package au.edu.jcu.assignment1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
                Intent intent = getIntent();
                positionToShowToSpinner = intent.getIntExtra("position", 1);
                Converter converter = new Converter(positionToShowToSpinner);
                double result = converter.convert(measurement);
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

    public void openSettings(){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
}
