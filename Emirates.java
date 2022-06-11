import java.util.ArrayList;
import java.util.Random;

public class Emirates extends Airline {
	public Emirates() {
		name = "Emirates";
		Random random = new Random();
		// int
		noOfFlights = random.nextInt(6) + 1;
		flights = new ArrayList<>();
		// Date date = new Date();

		// Time t=new Time(d.getTime());

		ArrayList<String> cities = new ArrayList<String>();
		cities.add("Miami");
		cities.add("Las Vegas");
		cities.add("Shanghai");
		cities.add("Barcelona");
		cities.add("Los Angeles");
		cities.add("Berlin");
		cities.add("Moscow");
		cities.add("Madrid");
		cities.add("Dublin");
		cities.add("Stockholm");

//		date.setDate(random.nextInt(30));
//		date.setMonth(random.nextInt(11));
//		date.setYear(2022);
		// int date, month, year;

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
