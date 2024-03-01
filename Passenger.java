import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private String name;
    private String passengerNumber;
    private double balance;
    private PassengerType type; // Represents the type of passenger
    private int activitiesSignedUp;
    private List<Activity> activities;

    public Passenger(String name, String passengerNumber, double balance, PassengerType type) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.balance = balance;
        this.type = type;
        this.activities = new ArrayList<>();
        this.activitiesSignedUp = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(String passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public PassengerType getType() {
        return type;
    }

    public void setType(PassengerType type) {
        this.type = type;
    }

    public int getActivitiesSignedUp() {
        return activitiesSignedUp;
    }

    public void setActivitiesSignedUp(int activitiesSignedUp) {
        this.activitiesSignedUp = activitiesSignedUp;
    }

    public void signUpForActivity(Activity activity) {
        // Check if the activity is not full
        if (activity.getSignedUp() < activity.getCapacity()) {
            // Check if the passenger has sufficient balance or is premium
            if (type == PassengerType.PREMIUM || (type == PassengerType.GOLD && balance >= activity.getCost())
                    || (type == PassengerType.STANDARD && balance >= activity.getCost())) {
                if (type == PassengerType.GOLD) {
                    double discountedCost = activity.getCost() * 0.9; // Apply 10% discount for Gold passenger
                    balance -= discountedCost;
                } else if (type == PassengerType.STANDARD) {
                    balance -= activity.getCost();
                }
                activity.setSignedUp(activity.getSignedUp() + 1); // Increment signed up count for activity
                activitiesSignedUp++; // Increment signed up activities count for the passenger
                activities.add(activity);
                System.out.println(name + " signed up for activity: " + activity.getName());
            } else {
                System.out.println(
                        "Insufficient balance for " + name + " to sign up for activity: " + activity.getName());
            }
        } else {
            System.out.println("Sorry, " + activity.getName() + " is already full.");
        }
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
