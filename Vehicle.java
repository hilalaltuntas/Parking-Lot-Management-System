// Vehicle.java

public class Vehicle {
    
    private String plateNumber; 
    private String type;        
    private String ownerName;   

    public Vehicle(String plateNumber, String type, String ownerName) {
        this.plateNumber = plateNumber;
        this.type = type;
        this.ownerName = ownerName;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void printVehicleInfo() {
        System.out.println("Plate Number: " + plateNumber);
        System.out.println("Type: " + type);
        System.out.println("Owner Name: " + ownerName);
    }

    public double calculateParkingFee(int hours) {
        double rate; 
        switch (type.toLowerCase()) {
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
        return rate * hours;
    }
}
