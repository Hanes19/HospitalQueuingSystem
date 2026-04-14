package com.me2.hospitalqueuingsystem;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AdminCommandCenterActivity extends AppCompatActivity {

    // Metrics UI
    private TextView metricThroughput, metricArrival, metricWaitTime;

    // Heat Map UI
    private LinearLayout heatMapTriage, heatMapDiagnostics;
    private TextView triageQueueCount, diagQueueCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_command_center);

        // 1. Initialize Metric Views
        metricThroughput = findViewById(R.id.metricThroughput);
        metricArrival = findViewById(R.id.metricArrival);
        metricWaitTime = findViewById(R.id.metricWaitTime);

        // 2. Initialize Heat Map Views
        heatMapTriage = findViewById(R.id.heatMapTriage);
        heatMapDiagnostics = findViewById(R.id.heatMapDiagnostics);
        triageQueueCount = findViewById(R.id.triageQueueCount);
        diagQueueCount = findViewById(R.id.diagQueueCount);

        // Initial Data Load (Mock Data)
        updateMetrics(15, 45); // e.g., 15 patients/hr arrival, 45 mins wait
        updateDepartmentHeat("Diagnostics", 15, 10); // 15 in queue, 10 is the safe threshold
    }

    /**
     * Calculates Throughput (L) using Little's Law: L = λ * W
     * (Note: Ensure time units match. Here we use hours for the final display)
     */
    public void updateMetrics(double arrivalRatePerHour, double waitTimeMinutes) {
        // Convert wait time to hours for the formula
        double waitTimeHours = waitTimeMinutes / 60.0;

        // L = λ * W
        double throughput = arrivalRatePerHour * waitTimeHours;

        // Update UI
        metricArrival.setText(String.format("%.1f /Hr", arrivalRatePerHour));
        metricWaitTime.setText(String.format("%.0f Mins", waitTimeMinutes));
        metricThroughput.setText(String.format("%.1f Pts", throughput));
    }

    /**
     * Updates the Heat Map colors based on department queue thresholds
     */
    public void updateDepartmentHeat(String department, int currentQueue, int safeThreshold) {
        LinearLayout targetLayout = null;
        TextView targetText = null;

        if (department.equals("Triage")) {
            targetLayout = heatMapTriage;
            targetText = triageQueueCount;
        } else if (department.equals("Diagnostics")) {
            targetLayout = heatMapDiagnostics;
            targetText = diagQueueCount;
        }

        if (targetLayout != null) {
            targetText.setText("Queue: " + currentQueue);

            // Change background color if threshold is exceeded
            if (currentQueue > safeThreshold) {
                targetLayout.setBackgroundColor(Color.parseColor("#EF9A9A")); // Alert Red
            } else if (currentQueue > (safeThreshold * 0.7)) {
                targetLayout.setBackgroundColor(Color.parseColor("#FFE082")); // Warning Yellow
            } else {
                targetLayout.setBackgroundColor(Color.parseColor("#A5D6A7")); // Safe Green
            }
        }
    }
}