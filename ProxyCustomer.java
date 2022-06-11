/**
 * Proxy design pattern
 */
public class ProxyCustomer implements Customer {
	RealCustomer customer;
	String name;
	
	public String getCustomerName(){
		return name;
	}
	
	public ProxyCustomer(String name) {
		this.name = name;
	}

	@Override
	public void addFlight(Flight flight) {
		if (customer == null) {
			customer = new RealCustomer(name);
			customer.addFlight(flight);
		} else {
			customer.addFlight(flight);
		}
	}

	@Override
	public double calculateBill() {
		if (customer == null) {
			customer = new RealCustomer(name);
			return customer.calculateBill();
		} else {
			return customer.calculateBill();
		}
	}

	@Override
	public void displayDetails() {
		if (customer == null) {
			customer = new RealCustomer(name);
			customer.displayDetails();
		} else {
			customer.displayDetails();
		}
	}

}
