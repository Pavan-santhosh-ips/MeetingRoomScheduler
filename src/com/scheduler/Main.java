package com.scheduler;

import com.scheduler.model.*;
import com.scheduler.service.SchedulerService;
import com.scheduler.strategy.FirstAvailableRoomStrategy;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Step 1: Create rooms
        MeetingRoom r1 = new MeetingRoom("Room-A");
        MeetingRoom r2 = new MeetingRoom("Room-B");

        List<MeetingRoom> rooms = new ArrayList<>(Arrays.asList(r1, r2));

        // Step 2: Create scheduler with a strategy
        SchedulerService scheduler = new SchedulerService(rooms, new FirstAvailableRoomStrategy());

        // Step 3: Take user input for meetings
        Scanner sc = new Scanner(System.in);
        System.out.println("📅 Meeting Room Scheduler");
        System.out.println("Type 'exit' as title to finish.\n");

        while (true) {
            System.out.print("Enter meeting title (or 'exit'): ");
            String title = sc.nextLine().trim();
            if (title.equalsIgnoreCase("exit")) break;

            System.out.print("Start Time (HH:mm): ");
            String startStr = sc.nextLine();
            System.out.print("End Time (HH:mm): ");
            String endStr = sc.nextLine();

            if (startStr.matches("\\d{2}:\\d{2}") && endStr.matches("\\d{2}:\\d{2}")) {
                LocalTime start = LocalTime.parse(startStr);
                if (start.isBefore(end)) {
                    TimeSlot slot = new TimeSlot(start, end);
                    Meeting meeting = new Meeting(title, slot);
                    scheduler.scheduleMeeting(meeting);
                } else {
                    System.out.println("❌ Start time must be before end time.");
                }
            } else {
                System.out.println("❌ Invalid time format. Please enter in HH:mm format.");
            }
        }

        // Step 4: Print schedule
        scheduler.printSchedule();
    }
}



