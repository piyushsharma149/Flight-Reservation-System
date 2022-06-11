import static org.junit.Assert.*;

import org.junit.Test;

public class UnitTests {
	
	@Test
	public void testInternetSingleton() {
		Internet instance1 = Internet.getInstance();
		Internet instance2 = Internet.getInstance();
		assertEquals(instance1, instance2);

	}
	
	@Test
	public void testInternetSingleton2() {
		Internet instance1 = Internet.getInstance();
		String [] ar =  new String[3];
		assertNotEquals(instance1.airlines,ar);

	}

	@Test
	public void testAirlineFactory() {
		AirlineFactory factory = new AirlineFactory();
		Airline airline = factory.getAirline("Etihad");
		assertTrue(airline instanceof Etihad);
	}

	@Test
	public void testAirlineFactory2() {
		AirlineFactory factory = new AirlineFactory();
		Airline airline = factory.getAirline("airblue");
		assertTrue(airline instanceof Airblue);
	}


	@Test
	public void testTemplate() {
		Flight flight = new Flight(5, 1,2,2022, "New Delhi", "New York");
		flight.seats[2].setSeatNumber(102);
		//Seat seatNum = flight.seats[2];
		assertEquals(102, flight.seats[2].seatNumber);
	}
	
	@Test
	public void testTemplate2() {
		Flight flight = new Flight(5, 1,2,2022, "New Delhi", "New York");
		flight.seats[3].setPrice(800);
		assertEquals (800, flight.seats[3].price);
	}
	
	@Test
	public void testProxy() {
		RealCustomer customer = new RealCustomer("Oliver");
		Customer proxy = customer;
		assertEquals(customer, proxy);
	}
	

}
