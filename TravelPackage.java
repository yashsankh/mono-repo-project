import java.util.List;

public class TravelPackage {
    public String name;
    public int passengerCapacity;
    public int currentCapacity=0;
    public List<Destination> destinations;
    public List<Passenger> passengers;

    
    public TravelPackage(String name, int passengerCapacity, List<Destination> destinations,
            List<Passenger> passengers) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.destinations = destinations;
        this.passengers = passengers;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPassengerCapacity() {
        return passengerCapacity;
    }
    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
    public List<Destination> getDestinations() {
        return destinations;
    }
    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }
    public List<Passenger> getPassengers() {
        return passengers;
    }
    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public boolean addpassenger() {
        if(currentCapacity<passengerCapacity){
            return true;
        }
        else{
            return false;
        }
    }
    
}
