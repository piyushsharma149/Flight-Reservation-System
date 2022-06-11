
public class RealCustomer implements Customer {
	String name;
	Flight f;
	String typeOfSeat;
	double totalBill;
	int numberOfTickets;
	double tax;
	double flightPrice;

	public RealCustomer(String name) {
		this.name = name;
		totalBill = 0;
		numberOfTickets = 0;
		tax = 0;
		flightPrice = 0;
	}

	@Override
	public void addFlight(Flight flight) {
		f = flight;
	}

	@Override
	public double calculateBill() {
		if (typeOfSeat.equalsIgnoreCase("Economy")) {
			flightPrice = 800 * numberOfTickets;
			tax = flightPrice * .075;
			totalBill = flightPrice + tax;
			return totalBill;

		} else if (typeOfSeat.equalsIgnoreCase("Business")) {
			flightPrice = 1500 * numberOfTickets;
			tax = flightPrice * .075;
			totalBill = flightPrice + tax;
			return totalBill;

		} else if (typeOfSeat.equalsIgnoreCase("First Class")) {
			flightPrice = 2000 * numberOfTickets;
			tax = flightPrice * .075;
			totalBill = flightPrice + tax;
			return totalBill;
		}
		return 0;
	}

	@Override
	public void displayDetails() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "Name: " + name + "\nFlight: " + f.toString() + "\nType of Seat: " + typeOfSeat + "\nNumber of tickets: "
				+ numberOfTickets + "\nCost of seats: $" + flightPrice + "\nTotal Tax: $" + tax + "\nTotal Bill: $"
				+ totalBill;
	}
}
