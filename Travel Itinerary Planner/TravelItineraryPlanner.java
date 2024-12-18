import java.util.ArrayList;
import java.util.Scanner; 

class TravelItineraryPlanner {
    private static final ArrayList<Destination> itinerary = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Travel Itinerary Planner!");

        while (running) {
            System.out.println("\nOptions:");
            System.out.println("1. Add a Destination");
            System.out.println("2. View Itinerary");
            System.out.println("3. Calculate Total Budget");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addDestination(scanner);
                    break;
                case 2:
                    viewItinerary();
                    break;
                case 3:
                    calculateTotalBudget();
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using the Travel Itinerary Planner!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void addDestination(Scanner scanner) {
        System.out.print("Enter destination name: ");
        String name = scanner.nextLine();
        System.out.print("Enter travel date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Enter preferences (e.g., sightseeing, food, adventure): ");
        String preferences = scanner.nextLine();
        System.out.print("Enter estimated budget: $");
        double budget = scanner.nextDouble();

        Destination destination = new Destination(name, date, preferences, budget);
        itinerary.add(destination);
        System.out.println("Destination added to the itinerary!");
    }

    private static void viewItinerary() {
        if (itinerary.isEmpty()) {
            System.out.println("Your itinerary is empty.");
        } else {
            System.out.println("\nYour Travel Itinerary:");
            for (int i = 0; i < itinerary.size(); i++) {
                System.out.println("\nDestination " + (i + 1) + ":");
                System.out.println(itinerary.get(i));
            }
        }
    }

    private static void calculateTotalBudget() {
        double totalBudget = 0;
        for (Destination destination : itinerary) {
            totalBudget += destination.budget;
        }
        System.out.println("Total estimated budget for your trip: $" + totalBudget);
    }
}
