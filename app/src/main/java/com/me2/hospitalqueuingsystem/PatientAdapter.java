package com.me2.hospitalqueuingsystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.PatientViewHolder> {

    private List<Patient> patientList;

    // The Adapter needs the list of patients when it is created
    public PatientAdapter(List<Patient> patientList) {
        this.patientList = patientList;
    }

    // 1. This grabs our XML design (item_patient) and inflates it into the UI
    @NonNull
    @Override
    public PatientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_patient, parent, false);
        return new PatientViewHolder(view);
    }

    // 2. This maps the data from the Patient class to the UI elements in the XML
    @Override
    public void onBindViewHolder(@NonNull PatientViewHolder holder, int position) {
        Patient currentPatient = patientList.get(position);

        holder.nameText.setText(currentPatient.getName());
        holder.roomText.setText("Room: " + currentPatient.getRoomNumber());
        holder.statusText.setText(currentPatient.getStatus());
        holder.waitTimeText.setText(currentPatient.getWaitTime() + " Min");
    }

    // 3. Tells the system how many items to draw
    @Override
    public int getItemCount() {
        return patientList.size();
    }

    // This class links the Java code to the specific text fields in item_patient.xml
    public static class PatientViewHolder extends RecyclerView.ViewHolder {
        TextView nameText, roomText, statusText, waitTimeText;

        public PatientViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.textPatientName);
            roomText = itemView.findViewById(R.id.textRoomNumber);
            statusText = itemView.findViewById(R.id.textStatus);
            waitTimeText = itemView.findViewById(R.id.textWaitTime);
        }
    }
}