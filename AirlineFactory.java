/**
 * Factory design pattern
 */
public class AirlineFactory {

	public Airline getAirline(String name) {
		Airline returning;
		
			if (name.equalsIgnoreCase("Etihad")) {
				returning = new Etihad();
				return returning;
				
			} else if (name.equalsIgnoreCase("Emirates")) {
				returning = new Emirates();
				return returning;

			} else if (name.equalsIgnoreCase("Airblue")) {
				returning = new Airblue();
				return returning;
			
			} else {
				System.out.println("Please enter the correct airline:");
				return null;
			}
		
		
	}
}
