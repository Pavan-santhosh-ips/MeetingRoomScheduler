package com.scheduler.model;

public class Meeting {
    private String title;
    private TimeSlot timeSlot;

    public Meeting(String title, TimeSlot timeSlot) {
        this.title = title;
        this.timeSlot = timeSlot;
    }

    public String getTitle() {
        return title;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    @Override
    public String toString() {
        return "[" + title + "] at " + timeSlot;
    }
}
