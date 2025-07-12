package com.scheduler.model;

import java.time.LocalTime;

public class TimeSlot {
    private LocalTime start;
    private LocalTime end;

    public TimeSlot(LocalTime start, LocalTime end) {
        if (start.isAfter(end) || start.equals(end)) {
            throw new IllegalArgumentException("Invalid TimeSlot: Start must be before End");
        }
        this.start = start;
        this.end = end;
    }

    public boolean overlaps(TimeSlot other) {
        return start.isBefore(other.end) && end.isAfter(other.start);
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return start + " to " + end;
    }
}

