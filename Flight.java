import java.util.Date;
import java.util.Random;

public class Flight {
	int capacity;
	int remaining;
	Date departureDate;
	String departureCity, destinationCity;
	Seat seats[];
	int date, month, year;

	public Flight(int capacity, int date, int month, int year, String departureCity, String destinationCity) {

		this.capacity = capacity;

		this.departureCity = departureCity;
		this.destinationCity = destinationCity;
		this.remaining = capacity;
		seats = new Seat[capacity];
		this.date = date;
		this.month = month;
		this.year = year;

		Random r = new Random();
		for (int i = 0; i < capacity; i++) {
			int random = r.nextInt(3);
			if (random == 0) {
				seats[i] = new EconomyClass();
				seats[i].setPrice(800);
			} else if (random == 1) {
				seats[i] = new BusinessClass();
				seats[i].setPrice(1500);
			} else if (random == 2) {
				seats[i] = new FirstClass();
				seats[i].setPrice(2500);
			}
			seats[i].setSeatNumber(i);
		}
	}

	@Override
	public String toString() {
		return "capacity=" + capacity + ", remaining=" + remaining + ", departureDate= " + month + "/" + date + "/"
				+ year + ", departureCity='" + departureCity + '\'' + ", destinationCity='" + destinationCity + "'";
	}
}
