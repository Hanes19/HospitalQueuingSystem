package com.me2.hospitalqueuingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the buttons from our XML design
        Button btnPatient = findViewById(R.id.btnPatient);
        Button btnAdmin = findViewById(R.id.btnAdmin);
        Button btnLabTech = findViewById(R.id.btnLabTech);
        Button btnCleaning = findViewById(R.id.btnCleaning);
        Button btnFlowRoom = findViewById(R.id.btnFlowRoom);
        Button btnKiosk = findViewById(R.id.btnKiosk);
        Button btnTriageDesk = findViewById(R.id.btnTriageDesk);

        // Set up "Intents" to open the corresponding dashboards when clicked
        btnPatient.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, VirtualWaitingRoomActivity.class)));
        btnAdmin.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AdminCommandCenterActivity.class)));
        btnLabTech.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, LabTechDashboardActivity.class)));
        btnCleaning.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CleaningDashboardActivity.class)));
        btnFlowRoom.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, FlowRoomDashboardActivity.class)));
        btnKiosk.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, KioskIntakeActivity.class)));
        btnTriageDesk.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, TriageDeskActivity.class)));
    }
}