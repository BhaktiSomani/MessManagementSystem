package sorted_data;
import java.util.Comparator;
import monthly_mess_system.Customer;

public class sortByPlan implements Comparator<Customer> {

@Override
public int compare(Customer o1, Customer o2) {
	return o1.getPlan().name().compareTo(o2.getPlan().name());
}
}