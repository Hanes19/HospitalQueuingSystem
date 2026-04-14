package com.me2.hospitalqueuingsystem;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TriageDeskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triage_desk);

        RadioGroup radioGroupPriority = findViewById(R.id.radioGroupPriority);
        Button btnAdmitPatient = findViewById(R.id.btnAdmitPatient);

        btnAdmitPatient.setOnClickListener(v -> {
            int selectedId = radioGroupPriority.getCheckedRadioButtonId();

            if (selectedId == -1) {
                // The nurse tried to admit without selecting a priority
                Toast.makeText(this, "Please select a priority level first.", Toast.LENGTH_SHORT).show();
            } else {
                String priorityLevel = "Standard";

                // Determine which button was checked
                if (selectedId == R.id.radioEmergency) {
                    priorityLevel = "Emergency";
                } else if (selectedId == R.id.radioUrgent) {
                    priorityLevel = "Urgent";
                }

                // Simulate saving to the database and clearing the screen
                Toast.makeText(this, "Patient Admitted with " + priorityLevel + " Priority.", Toast.LENGTH_LONG).show();
                finish(); // Closes the triage screen, returning the nurse to their main view
            }
        });
    }
}