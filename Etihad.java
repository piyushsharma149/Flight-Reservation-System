import java.util.ArrayList;
import java.util.Random;

public class Etihad extends Airline {
	public Etihad() {
		name = "Etihad";
		Random random = new Random();
		noOfFlights = random.nextInt(6) + 1;
		flights = new ArrayList<>();

		ArrayList<String> cities = new ArrayList<String>();
		cities.add("New York");
		cities.add("Istanbul");
		cities.add("Athens");
		cities.add("Delhi");
		cities.add("London");
		cities.add("Rome");
		cities.add("Mumbai");
		cities.add("Dubai");
		cities.add("Seoul");
		cities.add("Amsterdam");

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
			Flight f = new Flight(random.nextInt(60) + 10, date, month, year, departureCity, arrivalCity);
			flights.add(f);
		}
	}
}
