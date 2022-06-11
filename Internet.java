/**
 * 
 * Singleton design pattern
 */
public class Internet implements IteratorInterface {

	private static Internet internet = new Internet();
	Airline airlines[];
	AirlineFactory factory;

	private Internet() {
		factory = new AirlineFactory();
		airlines = new Airline[3];
		airlines[0] = factory.getAirline("Etihad");
		airlines[1] = factory.getAirline("Emirates");
		airlines[2] = factory.getAirline("Airblue");
	}

	public Airline[] getAirlines() {
		return airlines;
	}

	public static Internet getInstance() {
		return internet;
	}

	@Override
	public Iterator getIterator() {
		return new AirlineIterator();
	}

	private class AirlineIterator implements Iterator {
		int index;

		@Override
		public boolean hasNext() {
			if (index < airlines.length) {
				return true;
			}
			return false;
		}

		@Override
		public Airline next() {
			if (this.hasNext()) {
				return airlines[index++];
			}
			return null;
		}
	}
}
