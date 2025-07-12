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
        // we can create multiple rooms to assign particular team meetings like r1 ,r2 etc
        MeetingRoom r1 = new MeetingRoom("Room-A");
        MeetingRoom r2 = new MeetingRoom("Room-B");

        List<MeetingRoom> rooms = new ArrayList<>(Arrays.asList(r1, r2));

        // Strategy Scheduler :
        SchedulerService scheduler = new SchedulerService(rooms, new FirstAvailableRoomStrategy());

        // User inputs ..
        Scanner sc = new Scanner(System.in);
        System.out.println(" \uD83D\uDCC5\t Meeting Room Scheduler ");
        System.out.println("Type 'exit' as title to finish.\n");

        while (true) {
            System.out.print("📌 What’s the meeting about? (or type 'exit' to finish): ");
            String title = sc.nextLine().trim();
            if (title.equalsIgnoreCase("exit")) break;

            System.out.print("Start Time (HH:mm): ");
            String startStr = sc.nextLine();
            System.out.print("End Time (HH:mm): ");
            String endStr = sc.nextLine();

            if (startStr.matches("\\d{2}:\\d{2}") && endStr.matches("\\d{2}:\\d{2}")) {
                LocalTime start = LocalTime.parse(startStr);
                LocalTime end = LocalTime.parse(endStr);
                if (start.isBefore(end)) {
                    TimeSlot slot = new TimeSlot(start, end);
                    Meeting meeting = new Meeting(title, slot);
                    scheduler.scheduleMeeting(meeting);
                } else {
                    System.out.println("⚠\uFE0F Start time must be before end time ⚠\uFE0F");
                }
            } else {
                System.out.println("⚠\uFE0F Invalid time format. Please enter in HH:mm format ⚠\uFE0F ");
            }
        }

        // Schedulee..
        scheduler.printSchedule();
    }
}



