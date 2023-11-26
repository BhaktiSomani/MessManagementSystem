package utils;

import java.util.HashMap;
import java.util.Map;

import exception.InvalidInputException;
import monthly_mess_system.Customer;

public class authenticateCustomer {
public static Customer authentication(String email,String password,Map<String,Customer> hsmap) throws InvalidInputException {
	if(!hsmap.containsKey(email))
		throw new InvalidInputException("Email does not exists!!");
	Customer c = hsmap.get(email);
	if(!c.getPassword().equals(password))
		throw new InvalidInputException("Password is incorrect !!");
	return c;
}
}
