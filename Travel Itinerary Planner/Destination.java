class Destination {
    String name;
    String date;
    String preferences;
    double budget;

    Destination(String name, String date, String preferences, double budget) {
        this.name = name;
        this.date = date;
        this.preferences = preferences;
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Destination: " + name + "\nDate: " + date +
               "\nPreferences: " + preferences + "\nBudget: $" + budget;
    }
}