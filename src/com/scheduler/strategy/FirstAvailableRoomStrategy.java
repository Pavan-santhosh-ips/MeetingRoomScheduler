package com.scheduler.strategy;

import com.scheduler.interfaces.ISchedulingStrategy;
import com.scheduler.model.Meeting;
import com.scheduler.model.MeetingRoom;

import java.util.List;

public class FirstAvailableRoomStrategy implements ISchedulingStrategy {
    @Override
    public MeetingRoom selectMeetingRoom(List<MeetingRoom> rooms, Meeting meeting) {
        for (MeetingRoom room : rooms) {
            if (room.isAvailable(meeting.getTimeSlot())) {
                return room;
            }
        }
        return null; // No available room
    }
}
