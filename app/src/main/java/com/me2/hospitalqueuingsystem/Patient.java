package com.me2.hospitalqueuingsystem;

public class Patient {
    // These are the "properties" of your patient component
    private String name;
    private String roomNumber;
    private String status;
    private int waitTime;

    // This is the constructor (how we create a new patient in the code)
    public Patient(String name, String roomNumber, String status, int waitTime) {
        this.name = name;
        this.roomNumber = roomNumber;
        this.status = status;
        this.waitTime = waitTime;
    }

    // These Getters allow your UI to read the data
    public String getName() {
        return name;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getStatus() {
        return status;
    }

    public int getWaitTime() {
        return waitTime;
    }
}