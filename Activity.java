public class Activity {

    public String name;
    public String description;
    public double cost;
    public int capacity;
    public int signedUp = 0;
    private Destination destination;

    public Activity(String name, String description, double cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSignedUp() {
        return signedUp;
    }

    public void setSignedUp(int signedUp) {
        this.signedUp = signedUp;
    }

    public boolean signUp() {
        if (signedUp < capacity) {
            signedUp++;
            return true;
        } else
            return false;

    }

    public Destination getDestination() {
        return destination;
    }

}
