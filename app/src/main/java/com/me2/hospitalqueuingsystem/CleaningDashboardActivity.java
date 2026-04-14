package com.me2.hospitalqueuingsystem;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CleaningDashboardActivity extends AppCompatActivity {

    private RecyclerView recyclerRoomsToClean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaning_dashboard);

        // Initialize the list view
        recyclerRoomsToClean = findViewById(R.id.recyclerRoomsToClean);
        recyclerRoomsToClean.setLayoutManager(new LinearLayoutManager(this));

        // TODO: Attach your custom UI Adapter here once designed
        // recyclerRoomsToClean.setAdapter(new RoomPrepAdapter(roomList));
    }

    /**
     * Triggered when a patient is moved to the "Discharge Lounge"
     */
    public void flagRoomForCleaning(String roomNumber, boolean isRequiredForEmergency) {
        // 1. Add room to the cleaning list
        // 2. If isRequiredForEmergency is TRUE, push this room to index 0 (top of the list)
        // 3. Update the UI: adapter.notifyDataSetChanged();
    }

    /**
     * Triggered when staff checks off a room on their UI
     */
    public void markRoomClean(String roomNumber) {
        // 1. Remove from the local cleaning list
        // 2. Send WebSocket signal back to the Central System so the Nurse Dashboard knows the room is available
    }
}