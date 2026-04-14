package com.me2.hospitalqueuingsystem;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class VirtualWaitingRoomActivity extends AppCompatActivity {

    // UI Components
    private TextView greetingText, queueIdText, statusText, waitTimeText, alertMessageText;
    private View priorityColorBadge;
    private LinearLayout alertBanner;

    // State Variables
    private int currentWaitTimeMinutes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virtual_waiting_room);

        // 1. Initialize Views
        greetingText = findViewById(R.id.greetingText);
        queueIdText = findViewById(R.id.queueIdText);
        statusText = findViewById(R.id.statusText);
        waitTimeText = findViewById(R.id.waitTimeText);
        priorityColorBadge = findViewById(R.id.priorityColorBadge);
        alertBanner = findViewById(R.id.alertBanner);
        alertMessageText = findViewById(R.id.alertMessageText);

        // 2. Load Initial Patient Data (This would eventually come from an Intent or Database)
        initializePatientData("Jane Doe", "A-104", "STANDARD", "Awaiting Triage", 45);

        // Example: Simulating an emergency after a delay could be done here
        // triggerEmergencyOverride(15);
    }

    /**
     * Sets up the initial state of the waiting room
     */
    private void initializePatientData(String name, String queueId, String priorityLevel, String status, int waitTime) {
        greetingText.setText("Hello, " + name);
        queueIdText.setText("Queue # " + queueId);
        statusText.setText(status);

        setWaitTime(waitTime);
        setPriorityColor(priorityLevel);
    }

    /**
     * Updates the wait time text on the UI
     */
    private void setWaitTime(int minutes) {
        this.currentWaitTimeMinutes = minutes;
        waitTimeText.setText(minutes + " Minutes");
    }

    /**
     * Changes the priority badge color based on triage level
     */
    private void setPriorityColor(String level) {
        switch (level.toUpperCase()) {
            case "EMERGENCY":
                priorityColorBadge.setBackgroundColor(Color.parseColor("#D32F2F")); // Red
                break;
            case "URGENT":
                priorityColorBadge.setBackgroundColor(Color.parseColor("#F57C00")); // Orange
                break;
            case "STANDARD":
            default:
                priorityColorBadge.setBackgroundColor(Color.parseColor("#388E3C")); // Green
                break;
        }
    }

    /**
     * Triggers the "Code Red" logic, revealing the banner and adding time
     */
    public void triggerEmergencyOverride(int addedTimeMinutes) {
        // Recalculate time
        int newWaitTime = currentWaitTimeMinutes + addedTimeMinutes;
        setWaitTime(newWaitTime);

        // Update and show alert banner
        alertMessageText.setText("An emergency case has arrived. Your estimated wait time has been updated by +" + addedTimeMinutes + " minutes.");
        alertBanner.setVisibility(View.VISIBLE);
    }

    /**
     * Advances the patient to the next "Flow Room"
     */
    public void updateStatus(String newStatus) {
        statusText.setText(newStatus);
        // Optional: Hide the alert banner when they move to a new room
        alertBanner.setVisibility(View.GONE);
    }
}