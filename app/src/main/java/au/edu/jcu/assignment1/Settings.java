package au.edu.jcu.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Settings extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

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

        spinner_to.setOnItemSelectedListener(this);
        spinner_from.setOnItemSelectedListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void buttonSubmit(View view) {

        Intent intent = new Intent(this, Settings.class);
        intent.putExtra("text", spinner_to.getSelectedItem().toString());
                finish();
    }
}