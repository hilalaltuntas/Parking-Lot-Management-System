// ParkingSlot.java

public class ParkingSlot {
    private int slotNumber; 
    private boolean isOccupied; 
    private String vehiclePlateNumber; 
    private String vehicleType; 
  
    public ParkingSlot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.isOccupied = false;
        this.vehiclePlateNumber = null;
        this.vehicleType = null;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public String getVehiclePlateNumber() {
        return vehiclePlateNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void parkVehicle(String plateNumber, String vehicleType) {
        if (isOccupied) {
            throw new IllegalStateException("Slot is already occupied.");
        }
        this.isOccupied = true;
        this.vehiclePlateNumber = plateNumber;
        this.vehicleType = vehicleType;
    }

    public void removeVehicle() {
        if (!isOccupied) {
            throw new IllegalStateException("Slot is already empty.");
        }
        this.isOccupied = false;
        this.vehiclePlateNumber = null;
        this.vehicleType = null;
    }

    public void displaySlotInfo() {
        System.out.println("Slot Number: " + slotNumber);
        System.out.println("Occupied: " + (isOccupied ? "Yes" : "No"));
        if (isOccupied) {
            System.out.println("Vehicle Plate Number: " + vehiclePlateNumber);
            System.out.println("Vehicle Type: " + vehicleType);
        }
    }
}
