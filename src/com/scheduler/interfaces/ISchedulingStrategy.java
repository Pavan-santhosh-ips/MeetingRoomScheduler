package com.scheduler.interfaces;

import com.scheduler.model.Meeting;
import com.scheduler.model.MeetingRoom;

import java.util.List;

public interface ISchedulingStrategy {
    MeetingRoom selectMeetingRoom(List<MeetingRoom> rooms, Meeting meeting);
}
