// Main.java

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<ParkingSlot> parkingSlots = new ArrayList<>();
        ArrayList<Ticket> tickets = new ArrayList<>();
        int ticketCounter = 1; // To generate unique ticket IDs

        for (int i = 1; i <= 10; i++) {
            parkingSlots.add(new ParkingSlot(i));
        }

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== Parking Lot Management System =====");
            System.out.println("1. Park a Vehicle");
            System.out.println("2. Remove a Vehicle");
            System.out.println("3. Display Parking Slots");
            System.out.println("4. Display Ticket Details");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: 
                    System.out.print("Enter Vehicle Plate Number: ");
                    String plateNumber = scanner.next();
                    System.out.print("Enter Vehicle Type (car/motorcycle/truck): ");
                    String type = scanner.next();

                    boolean parked = false;
                    for (ParkingSlot slot : parkingSlots) {
                        if (!slot.isOccupied()) {
                            slot.parkVehicle(plateNumber, type);
                            Ticket ticket = new Ticket(ticketCounter++, plateNumber, type, slot.getSlotNumber());
                            tickets.add(ticket);
                            System.out.println("Vehicle parked successfully in Slot " + slot.getSlotNumber());
                            parked = true;
                            break;
                        }
                    }

                    if (!parked) {
                        System.out.println("No available parking slots.");
                    }
                    break;

                case 2: 
                    System.out.print("Enter Vehicle Plate Number: ");
                    String removePlate = scanner.next();

                    boolean found = false;
                    for (Ticket ticket : tickets) {
                        if (ticket.getVehiclePlateNumber().equals(removePlate) && ticket.getExitTime() == null) {
                            ticket.processExit();
                            for (ParkingSlot slot : parkingSlots) {
                                if (slot.getSlotNumber() == ticket.getParkingSlotNumber()) {
                                    slot.removeVehicle();
                                    System.out.println("Vehicle removed. Parking Fee: $" + ticket.getParkingFee());
                                    found = true;
                                    break;
                                }
                            }
                        }
                    }

                    if (!found) {
                        System.out.println("Vehicle not found or already removed.");
                    }
                    break;

                case 3: 
                    System.out.println("\nCurrent Parking Slot Status:");
                    for (ParkingSlot slot : parkingSlots) {
                        slot.displaySlotInfo();
                        System.out.println("-------------------------");
                    }
                    break;

                case 4: 
                    System.out.println("\nTicket Details:");
                    for (Ticket ticket : tickets) {
                        ticket.displayTicketInfo();
                        System.out.println("-------------------------");
                    }
                    break;

                case 5: 
                    running = false;
                    System.out.println("Exiting Parking Lot Management System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
