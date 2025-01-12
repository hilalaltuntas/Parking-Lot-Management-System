// Ticket.java

import java.time.LocalDateTime;

public class Ticket {
    private int ticketId; 
    private String vehiclePlateNumber; 
    private String vehicleType; 
    private int parkingSlotNumber; 
    private LocalDateTime entryTime; 
    private LocalDateTime exitTime; 
    private double parkingFee; 
  
    public Ticket(int ticketId, String vehiclePlateNumber, String vehicleType, int parkingSlotNumber) {
        this.ticketId = ticketId;
        this.vehiclePlateNumber = vehiclePlateNumber;
        this.vehicleType = vehicleType;
        this.parkingSlotNumber = parkingSlotNumber;
        this.entryTime = LocalDateTime.now();
        this.exitTime = null;
        this.parkingFee = 0.0;
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getVehiclePlateNumber() {
        return vehiclePlateNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public int getParkingSlotNumber() {
        return parkingSlotNumber;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public double getParkingFee() {
        return parkingFee;
    }

    public void processExit() {
        if (exitTime != null) {
            throw new IllegalStateException("Exit has already been processed.");
        }
        this.exitTime = LocalDateTime.now();
        calculateParkingFee();
    }

    private void calculateParkingFee() {
        long hoursParked = java.time.Duration.between(entryTime, exitTime).toHours();
        double rate;
        switch (vehicleType.toLowerCase()) {
            case "car":
                rate = 10.0;
                break;
            case "motorcycle":
                rate = 5.0;
                break;
            case "truck":
                rate = 20.0;
                break;
            default:
                rate = 8.0;
        }
        this.parkingFee = hoursParked * rate;
    }

    public void displayTicketInfo() {
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("Vehicle Plate Number: " + vehiclePlateNumber);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Parking Slot Number: " + parkingSlotNumber);
        System.out.println("Entry Time: " + entryTime);
        if (exitTime != null) {
            System.out.println("Exit Time: " + exitTime);
            System.out.println("Parking Fee: $" + parkingFee);
        } else {
            System.out.println("Vehicle is still parked.");
        }
    }
}
