package au.edu.jcu.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Settings extends AppCompatActivity {
    public static int SETTINGS_REQUEST = 420;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner_to = findViewById(R.id.spinner_to);
        Spinner spinner_from = findViewById(R.id.spinner_from);

        spinner_to.setAdapter(adapter);
        spinner_from.setAdapter(adapter);

        String to_spinner = (String) spinner_to.getSelectedItem();
        String from_spinner = (String) spinner_from.getSelectedItem();

        Intent intent = new Intent();
        intent.putExtra("position1", to_spinner);
        intent.putExtra("position2", from_spinner);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void buttonSubmit(View view) {

        finish();
    }
}