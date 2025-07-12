### Meeting Room Scheduler – Java LLD Project

Welcome to the **Meeting Room Scheduler**, a project that simulates how companies manage room bookings — minus the chaos of double-bookings or conflicts.

This was built as part of my hands-on practice with **Low-Level Design (LLD)** and **Object-Oriented Principles**.  
It’s fully interactive via the command line, designed using the **Strategy Design Pattern**, and keeps things simple yet scalable.

---

##  What Problem Does It Solve?

Imagine you're managing multiple meetings across different rooms in an office.

 How do you ensure two meetings don’t overlap in the same room?  
 That’s exactly what this scheduler does — it finds the first available room where a new meeting can fit without clashing with existing ones.

---

## Key Features

-  Take user input interactively (meeting title, start and end time)
-  Automatically assigns an available meeting room
-  Prevents overlapping/conflicting meetings
-  Displays a final clean schedule grouped by room
-  Built with extensibility in mind (plug in more strategies)

---

##  Why I Built This

As someone preparing for top company placements, I wanted to go beyond just solving Leetcode and DSA.  
This project helped me practice:

- Writing clean modular code
- Using design patterns effectively
- Thinking about system extensibility
- Structuring a Java application the way real teams do

---

##  Design Pattern: Strategy Pattern

Room allocation is handled via the **Strategy Pattern**, allowing dynamic switching of the scheduling logic.

**Implemented Strategy:**
- `FirstAvailableRoomStrategy`: Assigns the first room with no conflicts

**Interfaces:**
- `ISchedulingStrategy`: Enables future strategies like:
  - `LeastUsedRoomStrategy`
  - `PriorityBasedStrategy`
  - `CostOptimizedStrategy`

---

##  Project Structure
com.scheduler
├── model // TimeSlot, Meeting, MeetingRoom
├── interfaces // ISchedulingStrategy (strategy contract)
├── strategy // FirstAvailableRoomStrategy
├── service // SchedulerService (business logic)
└── Main.java // Entry point (user interaction)

## Dry run 

 📅	 Meeting Room Scheduler 
Type 'exit' as title to finish.

📌 What’s the meeting about? (or type 'exit' to finish): Team alpha
Start Time (HH:mm): 10:00
End Time (HH:mm): 11:30
✅ Meeting 'Team alpha' scheduled in Room: Room-A
📌 What’s the meeting about? (or type 'exit' to finish): Team Beta
Start Time (HH:mm): 10:45
End Time (HH:mm): 13:00
✅ Meeting 'Team Beta' scheduled in Room: Room-B
📌 What’s the meeting about? (or type 'exit' to finish): Team Gamma
Start Time (HH:mm): 12:00
End Time (HH:mm): 16:00
✅ Meeting 'Team Gamma' scheduled in Room: Room-A
📌 What’s the meeting about? (or type 'exit' to finish): Team Delta
Start Time (HH:mm): 20:00
End Time (HH:mm): 23:15
✅ Meeting 'Team Delta' scheduled in Room: Room-A
📌 What’s the meeting about? (or type 'exit' to finish): exit

📋 Room-wise Schedule:
Room: Room-A
 - Team alpha at 10:00 to 11:30
 - Team Gamma at 12:00 to 16:00
 - Team Delta at 20:00 to 23:15
Room: Room-B
 - Team Beta at 10:45 to 13:00

Process finished with exit code 0


