import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TravelPlanner {
    Scanner sc = new Scanner(System.in);

    public TravelPackage planTravel() {
        System.out.println("Select A Travel Plan:");
        System.out.println("1. USA");
        System.out.println("2. Japan");
        System.out.println("3. UK");
        System.out.println("4. Canada");

        String planName = "";
        int passengerCapacity = 0;
        List<Destination> itinerary = new ArrayList<>();
        List<Passenger> passengers = new ArrayList<>();

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                planName = "USA";
                passengerCapacity = 5;
                Destination newYork = new Destination("New York");
                newYork.addActivity(new Activity("Sightseeing", "Visit famous landmarks", 50.0, 10, newYork));
                newYork.addActivity(new Activity("Shopping", "Shop till you drop", 0.0, 20, newYork));
                Destination losAngeles = new Destination("Los Angeles");
                losAngeles.addActivity(
                        new Activity("Hollywood Tour", "Explore the movie industry", 80.0, 15, losAngeles));
                losAngeles.addActivity(new Activity("Beach Day", "Relax on the sandy shores", 0.0, 30, losAngeles));
                Destination lasVegas = new Destination("Las Vegas");
                lasVegas.addActivity(new Activity("Casino Night", "Try your luck at the tables", 100.0, 20, lasVegas));
                lasVegas.addActivity(new Activity("Magic Show", "Witness breathtaking illusions", 75.0, 15, lasVegas));
                itinerary.add(newYork);
                itinerary.add(losAngeles);
                itinerary.add(lasVegas);
                break;
            case 2:
                planName = "Japan";
                passengerCapacity = 5;
                Destination tokyo = new Destination("Tokyo");
                tokyo.addActivity(
                        new Activity("Imperial Palace Visit", "Explore the historical Imperial Palace", 60.0, 10,
                                tokyo));
                tokyo.addActivity(
                        new Activity("Sushi Making Class", "Learn to make authentic Japanese sushi", 120.0, 15, tokyo));
                Destination kyoto = new Destination("Kyoto");
                kyoto.addActivity(
                        new Activity("Kiyomizu-dera Temple Tour", "Visit the iconic Kiyomizu-dera Temple", 70.0, 20,
                                kyoto));
                kyoto.addActivity(new Activity("Tea Ceremony Experience",
                        "Participate in a traditional Japanese tea ceremony", 90.0, 15, kyoto));
                Destination osaka = new Destination("Osaka");
                osaka.addActivity(
                        new Activity("Osaka Castle Visit", "Explore the majestic Osaka Castle", 80.0, 20, osaka));
                osaka.addActivity(new Activity("Dotonbori Street Food Tour",
                        "Indulge in delicious street food at Dotonbori", 50.0, 25, osaka));
                itinerary.add(tokyo);
                itinerary.add(kyoto);
                itinerary.add(osaka);

                break;
            case 3:
                planName = "UK";
                passengerCapacity = 5;
                Destination london = new Destination("London");
                london.addActivity(
                        new Activity("British Museum Tour", "Explore artifacts from around the world", 40.0, 15,
                                london));
                london.addActivity(
                        new Activity("West End Show", "Experience a spectacular theater production", 100.0, 20,
                                london));
                Destination edinburgh = new Destination("Edinburgh");
                edinburgh.addActivity(
                        new Activity("Edinburgh Castle Visit", "Discover the historic Edinburgh Castle", 60.0, 25,
                                edinburgh));
                edinburgh.addActivity(
                        new Activity("Whisky Tasting Tour", "Sample Scotland's finest whiskies", 80.0, 15, edinburgh));
                Destination bath = new Destination("Bath");
                bath.addActivity(
                        new Activity("Roman Baths Tour", "Explore ancient Roman baths and ruins", 50.0, 20, bath));
                bath.addActivity(
                        new Activity("Afternoon Tea", "Indulge in a traditional British afternoon tea", 30.0, 30,
                                bath));
                itinerary.add(london);
                itinerary.add(edinburgh);
                itinerary.add(bath);

                break;
            case 4:
                planName = "Canada";
                passengerCapacity = 5;
                Destination toronto = new Destination("Toronto");
                toronto.addActivity(
                        new Activity("CN Tower Tour", "Enjoy panoramic views of Toronto", 60.0, 20, toronto));
                toronto.addActivity(
                        new Activity("Toronto Islands Cruise", "Experience the beauty of Toronto Islands", 50.0, 25,
                                toronto));
                Destination vancouver = new Destination("Vancouver");
                vancouver.addActivity(
                        new Activity("Stanley Park Bike Tour", "Explore the scenic Stanley Park by bike", 70.0, 15,
                                vancouver));
                vancouver.addActivity(new Activity("Granville Island Market Visit",
                        "Browse through artisan shops and fresh produce markets", 0.0, 30, vancouver));
                Destination banff = new Destination("Banff");
                banff.addActivity(
                        new Activity("Lake Louise Hike", "Hike around the stunning Lake Louise", 40.0, 20, banff));
                banff.addActivity(new Activity("Banff Gondola Ride",
                        "Ascend to breathtaking views on the Banff Gondola", 80.0, 15, banff));
                itinerary.add(toronto);
                itinerary.add(vancouver);
                itinerary.add(banff);

                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        System.out.println("Enter the number of passengers:");
        int numPassengers = sc.nextInt();
        for (int i = 0; i < numPassengers; i++) {
            System.out.println("Enter passenger name:");
            String passengerName = sc.next();
            System.out.println("Enter passenger number:");
            String passengerNumber = sc.next();
            System.out.println("Enter passenger balance:");
            double balance = sc.nextDouble();
            System.out.println("Enter passenger type (STANDARD, GOLD, PREMIUM):");
            PassengerType type = PassengerType.valueOf(sc.next().toUpperCase());

            // Create passenger and add to the list
            Passenger passenger = new Passenger(passengerName, passengerNumber, balance, type);
            passengers.add(passenger);

            System.out.println("You can sign up for the following activities:");

            for (Destination destination : itinerary) {
                System.out.println("Destination: " + destination.getName());
                System.out.println("Activities:");

                for (Activity activity : destination.getActivities()) {
                    if (activity.getSignedUp() < activity.getCapacity()
                            && passenger.getBalance() >= activity.getCost()) {
                        System.out.println("- " + activity.getName() + ": " + activity.getDescription() + " (Cost: "
                                + activity.getCost() + ")");
                    }
                }
            }

            // Sign up for activities until balance allows
            while (true) {
                System.out.println("Enter activity destination (or type 'done' to finish signing up):");
                String activityDestination = sc.nextLine().trim(); // Convert to uppercase and trim spaces

                if (activityDestination.equalsIgnoreCase("done")) {
                    break; // Finish signing up for activities
                }

                System.out.println("Enter activity name:");
                String activityName = sc.nextLine().trim();

                boolean activityExists = false;
                for (Destination destination : itinerary) {
                    if (destination.getName().equalsIgnoreCase(activityDestination)) {
                        // Activity destination found
                        for (Activity activity : destination.getActivities()) {
                            if (activity.getName().equalsIgnoreCase(activityName)) {
                                // Activity found, check capacity and sign up
                                if (activity.getSignedUp() < activity.getCapacity()
                                        && passenger.getBalance() >= activity.getCost()) {
                                    // Sign up for activity
                                    activity.signUp();
                                    // Increment activities signed up for the passenger
                                    passenger.signUpForActivity(activity);
                                    activityExists = true;
                                    System.out.println(
                                            "You have successfully signed up for the activity: " + activity.getName());
                                    break;
                                } else {
                                    if (activity.getSignedUp() >= activity.getCapacity()) {
                                        System.out.println("Sorry, the activity " + activity.getName() + " at "
                                                + destination.getName() + " is already at full capacity.");
                                    } else {
                                        System.out.println(
                                                "Sorry, you do not have sufficient balance to sign up for the activity: "
                                                        + activity.getName());
                                    }
                                    activityExists = true;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (!activityExists) {
                    System.out.println(
                            "Sorry, the activity " + activityName + " does not exist at the specified destination.");
                }
            }
        }

        // Print the passenger list
        System.out.println("Travel Package Name: " + planName);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers Enrolled: " + passengers.size());
        System.out.println("Passenger List:");
        for (Passenger passenger : passengers) {
            System.out.println("- Name: " + passenger.getName() + "\nNumber: " + passenger.getPassengerNumber()
                    + "\nActivities:");
            List<Activity> signedUpActivities = passenger.getActivities();

            if (!signedUpActivities.isEmpty()) {
                for (Activity activity : signedUpActivities) {
                    // Display the signed up activity
                    System.out.println("    - " + activity.getName());
                }
            } else {
                System.out.println("    No activities signed up.");
            }
        }

        TravelPackage travelPackage = new TravelPackage(planName, passengerCapacity, itinerary, passengers);
        return travelPackage;
    }

    // Function to print the itinerary of the travel package
    public void printItinerary(TravelPackage travelPackage) {
        System.out.println("Travel Package Name: " + travelPackage.getName());
        System.out.println("Itinerary:");
        for (Destination destination : travelPackage.getDestinations()) {
            System.out.println("Destination: " + destination.getName());
            System.out.println("Activities:");
            for (Activity activity : destination.getActivities()) {
                System.out.println("- " + activity.getName() + ": " + activity.getDescription());
                System.out.println("  Cost: " + activity.getCost());
                System.out.println("  Capacity: " + activity.getCapacity());
            }
        }
    }

    // Function to print the passenger list of the travel package
    public void printPassengerList(TravelPackage travelPackage) {
        System.out.println("Travel Package Name: " + travelPackage.getName());
        System.out.println("Passenger Capacity: " + travelPackage.getPassengerCapacity());
        System.out.println("Number of Passengers Enrolled: " + travelPackage.getPassengers().size());
        System.out.println("Passenger List:");
        for (Passenger passenger : travelPackage.getPassengers()) {
            System.out.println("- Name: " + passenger.getName());
            System.out.println("  Number: " + passenger.getPassengerNumber());
        }
    }

    public void printPassengerDetails(Passenger passenger) {
        System.out.println("Passenger Details:");
        System.out.println("- Name: " + passenger.getName());
        System.out.println("- Passenger Number: " + passenger.getPassengerNumber());
        if (passenger.getBalance() >= 0) {
            System.out.println("- Balance: $" + passenger.getBalance());
        } else {
            System.out.println("- Balance: N/A");
        }
        List<Activity> signedUpActivities = passenger.getActivities();
        System.out.println("- Activities Signed Up:");

        if (!signedUpActivities.isEmpty()) {
            for (Activity activity : signedUpActivities) {
                System.out.println("  - Activity: " + activity.getName());
                System.out.println("    - Destination: " + activity.getDestination().getName());
                System.out.println("    - Price: $" + activity.getCost());
            }
        } else {
            System.out.println("  No activities signed up.");
        }
    }

    public void printAvailableActivities(List<Destination> itinerary) {
        System.out.println("Activities with Available Spaces:");
        for (Destination destination : itinerary) {
            System.out.println("Destination: " + destination.getName());
            System.out.println("Available Activities:");
            for (Activity activity : destination.getActivities()) {
                int availableSpaces = activity.getCapacity() - activity.getSignedUp();
                if (availableSpaces > 0) {
                    System.out.println("  - Activity: " + activity.getName());
                    System.out.println("    - Available Spaces: " + availableSpaces);
                }
            }
        }
    }

    public static void main(String[] args) {
        TravelPlanner planner = new TravelPlanner();
        try (Scanner scanner = new Scanner(System.in)) { // Use try-with-resources to automatically close the Scanner
            TravelPackage selectedPackage = null; // Initialize selectedPackage outside the loop
            while (true) {
                System.out.println("Enter your choice:");
                System.out.println("1. Plan Travel");
                System.out.println("2. Print Itinerary");
                System.out.println("3. Print Passenger List");
                System.out.println("4. Print Passenger Details");
                System.out.println("5. Print Available Activities");
                System.out.println("0. Exit");

                // Input validation
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Consume the invalid input
                }
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        selectedPackage = planner.planTravel();
                        break;
                    case 2:
                        if (selectedPackage != null) {
                            planner.printItinerary(selectedPackage);
                        } else {
                            System.out.println("Please plan a travel package first.");
                        }
                        break;
                    case 3:
                        if (selectedPackage != null) {
                            planner.printPassengerList(selectedPackage);
                        } else {
                            System.out.println("Please plan a travel package first.");
                        }
                        break;
                    case 4:
                        if (selectedPackage != null) {
                            System.out.println("Enter passenger number:");
                            String passengerNumber = scanner.next();
                            boolean found = false;
                            for (Passenger passenger : selectedPackage.getPassengers()) {
                                if (passenger.getPassengerNumber().equals(passengerNumber)) {
                                    planner.printPassengerDetails(passenger);
                                    found = true;
                                    break;
                                }
                            }
                            if (!found) {
                                System.out.println("Passenger not found.");
                            }
                        } else {
                            System.out.println("Please plan a travel package first.");
                        }
                        break;

                    case 5:
                        if (selectedPackage != null) {
                            planner.printAvailableActivities(selectedPackage.getDestinations());
                        } else {
                            System.out.println("Please plan a travel package first.");
                        }
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        return; // Exit the program
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

}
