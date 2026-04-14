package com.me2.hospitalqueuingsystem;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LabTechDashboardActivity extends AppCompatActivity {

    private RecyclerView recyclerPendingLabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_tech_dashboard);

        // Initialize the list view
        recyclerPendingLabs = findViewById(R.id.recyclerPendingLabs);
        recyclerPendingLabs.setLayoutManager(new LinearLayoutManager(this));

        // TODO: Attach your custom UI Adapter here once designed
        // recyclerPendingLabs.setAdapter(new LabSampleAdapter(labList));
    }

    /**
     * Triggered by the "Handshake Protocol" when a Doctor hits "Send to Lab"
     */
    public void receiveNewLabRequest(String patientId, String priorityLevel, String testRequired) {
        // 1. Add the new request to your local data list
        // 2. Sort the list so "EMERGENCY" priority levels jump to the top
        // 3. Notify your adapter to refresh the UI visually: adapter.notifyDataSetChanged();
    }
}