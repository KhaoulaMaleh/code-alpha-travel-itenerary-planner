import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Travel Itinerary Planner!");
        System.out.print("Enter the number of destinations: ");
        int numDestinations = scanner.nextInt();
        scanner.nextLine(); 

        String[] destinations = new String[numDestinations];
        LocalDate[] dates = new LocalDate[numDestinations];

       
        for (int i = 0; i < numDestinations; i++) {
            System.out.print("Enter destination " + (i + 1) + ": ");
            destinations[i] = scanner.nextLine();
            System.out.print("Enter date for destination " + (i + 1) + " (DD/MM/YYYY): ");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String dateString = scanner.nextLine();
            dates[i] = LocalDate.parse(dateString, formatter);
        }

        System.out.print("Enter your total budget for the trip: ");
        double totalBudget = scanner.nextDouble();

       
        System.out.println("\nYour Travel Itinerary:");
        for (int i = 0; i < numDestinations; i++) {
            System.out.println("Destination: " + destinations[i] + ", Date: " + dates[i]);
        }

        
        long duration = calculateTripDuration(dates);
        System.out.println("Total Trip Duration: " + duration + " days");

      
        double remainingBudget = calculateRemainingBudget(totalBudget, numDestinations);
        System.out.println("Remaining Budget per destination: $" + remainingBudget);

        scanner.close();
    }

    private static long calculateTripDuration(LocalDate[] dates) {
        LocalDate earliestDate = dates[0];
        LocalDate latestDate = dates[dates.length - 1];
        return latestDate.toEpochDay() - earliestDate.toEpochDay() + 1;
    }

    private static double calculateRemainingBudget(double totalBudget, int numDestinations) {
        return totalBudget / numDestinations;
    }
}
