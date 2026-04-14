package com.me2.hospitalqueuingsystem;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class KioskIntakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_intake);

        // Find the buttons
        Button btnIllness = findViewById(R.id.btnSymptomIllness);
        Button btnInjury = findViewById(R.id.btnSymptomInjury);
        Button btnCheckup = findViewById(R.id.btnSymptomCheckup);
        Button btnOther = findViewById(R.id.btnSymptomOther);

        // Define what happens when a button is clicked
        btnIllness.setOnClickListener(v -> handleIntake("Fever/Illness"));
        btnInjury.setOnClickListener(v -> handleIntake("Injury/Pain"));
        btnCheckup.setOnClickListener(v -> handleIntake("Checkup/Labs"));
        btnOther.setOnClickListener(v -> handleIntake("Other"));
    }

    private void handleIntake(String reason) {
        // In a real app, this is where we would send the patient data to the database
        // For now, we show a success message and "reset" the screen
        Toast.makeText(this, "Added to Queue for: " + reason + ". Please take a seat.", Toast.LENGTH_LONG).show();

        // We close this screen so the next patient sees a fresh start
        finish();
    }
}