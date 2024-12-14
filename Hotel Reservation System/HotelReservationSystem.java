import java.util.ArrayList;
import java.util.Scanner;

class HotelReservationSystem {
    private static final ArrayList<Room> rooms = new ArrayList<>();
    private static final ArrayList<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        initializeRooms();

        System.out.println("Welcome to the Hotel Reservation System!");

        while (running) {
            System.out.println("\nOptions:");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewAvailableRooms();
                    break;
                case 2:
                    makeReservation(scanner);
                    break;
                case 3:
                    viewBookings();
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using the Hotel Reservation System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void initializeRooms() {
        rooms.add(new Room(101, "Single", true, 50.0));
        rooms.add(new Room(102, "Single", true, 50.0));
        rooms.add(new Room(201, "Double", true, 75.0));
        rooms.add(new Room(202, "Double", true, 75.0));
        rooms.add(new Room(301, "Suite", true, 120.0));
        rooms.add(new Room(302, "Suite", true, 120.0));
    }

    private static void viewAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable) {
                System.out.println("\n" + room);
            }
        }
    }

    private static void makeReservation(Scanner scanner) {
        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter desired room number: ");
        int roomNumber = scanner.nextInt();
        System.out.print("Enter number of nights: ");
        int numberOfNights = scanner.nextInt();

        Room roomToBook = null;
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber && room.isAvailable) {
                roomToBook = room;
                break;
            }
        }

        if (roomToBook == null) {
            System.out.println("Room not available or does not exist. Please try again.");
            return;
        }

        double totalCost = roomToBook.pricePerNight * numberOfNights;
        roomToBook.isAvailable = false;

        Booking booking = new Booking(customerName, roomNumber, numberOfNights, totalCost);
        bookings.add(booking);

        System.out.println("Reservation confirmed!");
        System.out.println("Total Cost: $" + totalCost);
    }

    private static void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
        } else {
            System.out.println("\nBookings:");
            for (Booking booking : bookings) {
                System.out.println("\n" + booking);
            }
        }
    }
}
