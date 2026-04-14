package com.me2.hospitalqueuingsystem;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FlowRoomDashboardActivity extends AppCompatActivity {

    // UI Components
    private RecyclerView recyclerTriage, recyclerDiagnostic, recyclerTreatment, recyclerDischarge;
    private TextView heatMapAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_room_dashboard);

        // 1. Initialize Views
        heatMapAlert = findViewById(R.id.heatMapAlert);

        recyclerTriage = findViewById(R.id.recyclerTriage);
        recyclerDiagnostic = findViewById(R.id.recyclerDiagnostic);
        recyclerTreatment = findViewById(R.id.recyclerTreatment);
        recyclerDischarge = findViewById(R.id.recyclerDischarge);

        // 2. Setup RecyclerView Managers (Vertical lists inside the horizontal columns)
        recyclerTriage.setLayoutManager(new LinearLayoutManager(this));
        recyclerDiagnostic.setLayoutManager(new LinearLayoutManager(this));
        recyclerTreatment.setLayoutManager(new LinearLayoutManager(this));
        recyclerDischarge.setLayoutManager(new LinearLayoutManager(this));

        // Note: You will need to create a custom RecyclerView.Adapter for the patient tiles later
        // e.g., recyclerTriage.setAdapter(new PatientTileAdapter(triageList));
    }

    /**
     * Toggles the top-level Heat Map warning if a specific queue exceeds safe levels.
     */
    public void updateHeatMapAlert(boolean isCritical, String departmentName) {
        if (isCritical) {
            heatMapAlert.setText("⚠️ " + departmentName + " Queue Critical");
            heatMapAlert.setVisibility(View.VISIBLE);
        } else {
            heatMapAlert.setVisibility(View.GONE);
        }
    }

    /**
     * THE HANDSHAKE PROTOCOL: Executes when a doctor finishes a consultation.
     * This pushes the patient data to the "Staff Pocket" views.
     */
    public void executeHandshakeProtocol(String patientId, String destinationQueue) {
        if (destinationQueue.equals("LAB")) {
            // Logic to transmit patient data to the Lab UI's "Pending Samples"
            // System.out.println("Patient " + patientId + " added to Lab queue.");
        } else if (destinationQueue.equals("CLEANING")) {
            // Logic to notify Cleaning Staff UI that the current room is empty
            // System.out.println("Room emptied by Patient " + patientId + ". Alerting Cleaning Staff.");
        }
    }
}