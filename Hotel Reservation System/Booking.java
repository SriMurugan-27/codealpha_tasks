
class Booking {
    String customerName;
    int roomNumber;
    int numberOfNights;
    double totalCost;

    Booking(String customerName, int roomNumber, int numberOfNights, double totalCost) {
        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.numberOfNights = numberOfNights;
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Customer Name: " + customerName +
               "\nRoom Number: " + roomNumber +
               "\nNumber of Nights: " + numberOfNights +
               "\nTotal Cost: $" + totalCost;
    }
}