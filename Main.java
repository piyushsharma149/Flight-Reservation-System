import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Internet internet = Internet.getInstance();
		Scanner sc = new Scanner(System.in);
		String name;
		while (true) {
			System.out.println("Enter your name: ");
			name = sc.nextLine();
			if (name.matches(".*\\d.*") || name.isEmpty()) {
				System.out.println("Please Enter Your Name: ");
			} else {
				break;
			}
		}
		Customer customer = new ProxyCustomer(name);
		int option = -1;
		while (true) {
			System.out.println("\nChoose an option:" + "\n1. View all available flights." + "\n2. Buy ticket."
					+ "\n3. View your bill." + "\n4. Exit");
			option = Integer.parseInt(sc.nextLine());
			if (option == 1) {
				Airline airlines[] = internet.getAirlines();
				for (int i = 0; i < airlines.length; i++) {
					System.out.println(airlines[i].name);
					int index = 1;
					for (Flight f : airlines[i].getFlights()) {
						System.out.print("Flight ID " + index + ": ");
						System.out.println(f);
						index++;
					}
				}
			} else if (option == 2) {
				System.out.println("Enter Airline: ");

				String airline = sc.nextLine();
				int i = 0;
				for (Iterator iter = internet.getIterator(); iter.hasNext();) {
					if (iter.next().getName().equalsIgnoreCase(airline)) {
						break;
					}
					i++;

				}
				int index = 1;
				for (Flight f : internet.getAirlines()[i].getFlights()) {
					System.out.print("Flight ID " + index + ": ");
					System.out.println(f);
					index++;
				}
				System.out.println();
				System.out.println("Choose a flight (Enter flight id):");
				int flightID = Integer.parseInt(sc.nextLine()) - 1;
				customer.addFlight(internet.getAirlines()[i].getFlights().get(flightID));
				System.out.println(
						"Enter type of seat \nEconomy ($800 plus tax) \nBusiness ($1500 plus tax) \nFirst Class ($2000 plus tax) ");
				String typeOfSeat = sc.nextLine();
				System.out.println("How many tickets you want to buy? ");
				int tickets = Integer.parseInt(sc.nextLine());
				if (customer instanceof ProxyCustomer) {
					((ProxyCustomer) customer).customer.typeOfSeat = typeOfSeat;
					((ProxyCustomer) customer).customer.numberOfTickets = tickets;
					int c = internet.getAirlines()[i].getFlights()
							.get(flightID).remaining -= ((ProxyCustomer) customer).customer.numberOfTickets;
					if (c >= 0) {
						System.out.println("PURCHASE COMPLETED");
					} else {
						System.out.println("Couldnot Purchase the tickets");
						break;
					}
				}

			} else if (option == 3) {
				if (customer instanceof ProxyCustomer) {
					customer.calculateBill();
					customer.displayDetails();
				}
			} else if (option == 4) {
				break;
			} else {
				System.out.println("Please enter the correct number");
			}

		}
		sc.close();
	}
}
