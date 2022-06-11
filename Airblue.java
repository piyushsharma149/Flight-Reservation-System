import java.util.ArrayList;
import java.util.Random;

public class Airblue extends Airline {

	public Airblue() {
		name = "Airblue";
		Random random = new Random();

		noOfFlights = random.nextInt(5) + 1;

		flights = new ArrayList<>();
		// Date date = new Date();
		ArrayList<String> cities = new ArrayList<String>();
		cities.add("New York");
		cities.add("Bali");
		cities.add("Tokyo");
		cities.add("Hong Kong");
		cities.add("london");
		cities.add("Singapore");
		cities.add("Paris");
		cities.add("Dubai");
		for (int i = 0; i < noOfFlights; i++) {
			String departureCity = cities.get(random.nextInt(cities.size()));
			String arrivalCity = cities.get(random.nextInt(cities.size()));
			while (true) {
				if (departureCity.equalsIgnoreCase(arrivalCity)) {
					departureCity = cities.get(random.nextInt(cities.size()));
				} else {
					break;
				}
			}
			date = random.nextInt(29) + 1;
			month = random.nextInt(11) + 1;
			year = 2022;
			Flight f = new Flight(random.nextInt(100) + 10, date, month, year, departureCity, arrivalCity);
			flights.add(f);

		}
	}
}
