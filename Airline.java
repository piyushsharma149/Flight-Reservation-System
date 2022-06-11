import java.util.ArrayList;

public abstract class Airline {
	String name;
	ArrayList<Flight> flights;
	int noOfFlights;
	int date, month, year;

	public void addFlight(Flight f) {
		flights.add(f);
	}

	public String getName() {
		return name;
	}

	public ArrayList<Flight> getFlights() {
		return flights;
	}
}
