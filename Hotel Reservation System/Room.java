
class Room {
    int roomNumber;
    String category;
    boolean isAvailable;
    double pricePerNight;

    Room(int roomNumber, String category, boolean isAvailable, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isAvailable = isAvailable;
        this.pricePerNight = pricePerNight;
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNumber +
               "\nCategory: " + category +
               "\nAvailable: " + (isAvailable ? "Yes" : "No") +
               "\nPrice per Night: $" + pricePerNight;
    }
}