package com.scheduler.service;

import com.scheduler.interfaces.ISchedulingStrategy;
import com.scheduler.model.Meeting;
import com.scheduler.model.MeetingRoom;

import java.util.List;

public class SchedulerService {
    private List<MeetingRoom> rooms;
    private ISchedulingStrategy strategy;

    public SchedulerService(List<MeetingRoom> rooms, ISchedulingStrategy strategy) {
        this.rooms = rooms;
        this.strategy = strategy;
    }

    public boolean scheduleMeeting(Meeting meeting) {
        MeetingRoom room = strategy.selectMeetingRoom(rooms, meeting);
        if (room != null) {
            room.addMeeting(meeting);
            System.out.println("✅ Meeting '" + meeting.getTitle() + "' scheduled in Room: " + room.getName());
            return true;
        } else {
            System.out.println("❌ No available room for meeting '" + meeting.getTitle() + "'");
            return false;
        }
    }

    public void printSchedule() {
        System.out.println("\n📋 Room-wise Schedule:");
        for (MeetingRoom room : rooms) {
            System.out.println("Room: " + room.getName());
            for (Meeting m : room.getMeetings()) {
                System.out.println(" - " + m.getTitle() + " at " + m.getTimeSlot());
            }
        }
    }
}
