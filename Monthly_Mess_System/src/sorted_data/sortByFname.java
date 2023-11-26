package sorted_data;

import java.util.Comparator;

import monthly_mess_system.Customer;

public class sortByFname implements Comparator<Customer>{
	@Override
	public int compare(Customer c1,Customer c2) {
		return c1.getFname().compareTo(c2.getFname());
	}

}
