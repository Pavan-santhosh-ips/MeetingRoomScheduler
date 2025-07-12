package com.scheduler.model;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoom {
    private String name;
    private List<Meeting> meetings;

    public MeetingRoom(String name) {
        this.name = name;
        this.meetings = new ArrayList<>();
    }

    public boolean isAvailable(TimeSlot timeSlot) {
        for (Meeting meeting : meetings) {
            if (meeting.getTimeSlot().overlaps(timeSlot)) {
                return false;
            }
        }
        return true;
    }

    public void addMeeting(Meeting meeting) {
        meetings.add(meeting);
    }

    public String getName() {
        return name;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    @Override
    public String toString() {
        return "Room: " + name + ", Meetings: " + meetings;
    }
}
