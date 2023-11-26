package utils;
import java.time.LocalDate;
import java.util.Map;

import exception.InvalidInputException;
import monthly_mess_system.Customer;
import monthly_mess_system.Plan;
public class validateAllInput {
	
	public static void validateEmail(String email) throws InvalidInputException {
		String regex="[a-zA-z0-9]+@[a-z]+\\.(com|in)";
		if(!email.matches(regex))
			throw new InvalidInputException("Invalid Email Id!");
	}
	
	public static Plan validatePlanAndRegisterAmount(String plan,double final_amount) throws InvalidInputException {
		if(Plan.valueOf(plan.toUpperCase()) == null)
			throw new InvalidInputException("Invalid Plan!");
		Plan validated_plan=Plan.valueOf(plan.toUpperCase());
		if(validated_plan.getMessCharges()!=final_amount)
			throw new InvalidInputException("Invalid Plan Amount!");
		return validated_plan;
	}
	
	private static LocalDate validateRegisterDate(String registerDate) throws InvalidInputException {
		LocalDate valid_register_date=LocalDate.parse(registerDate);
		if(valid_register_date.isBefore(LocalDate.now()))
			throw new InvalidInputException("Registration date should be today's date of future date");
		return valid_register_date;
	}
	
	public static LocalDate setPlanEndDate(Plan valid_plan,LocalDate register_date) {
		LocalDate plan_date = null;
		if(valid_plan.equals(Plan.MONTHLY)) {
			plan_date = register_date.plusDays(30);
		}
		else if(valid_plan.equals(Plan.QUARTERLY)) {
			plan_date = register_date.plusDays(90);
		}
		else if(valid_plan.equals(Plan.HALFYEAR)) {
			plan_date = register_date.plusDays(180);
		}
		else if(valid_plan.equals(Plan.YEARLY)) {
			plan_date = register_date.plusDays(365);
		}
		return plan_date ;
	}
	
	public static void checkDuplicateCustomer(String email,Map<String,Customer> cmap) throws InvalidInputException {
		if(cmap.containsKey(email))
			throw new InvalidInputException("Duplicate email id!!");
	}
	
	public static void validatePhoneNo(String phoneNo) throws InvalidInputException {
		String regex="\\d{10}";
		if(!phoneNo.matches(regex))
			throw new InvalidInputException("Invalid phone number");
	}
	
	public static Customer validateAllInput(int customerId, String fname, String lname, String email, String password, String address,
			 String plan,String registerDate, String phoneNo, double final_amount,Map<String,Customer> map) throws InvalidInputException {
		checkDuplicateCustomer(email,map);
		validateEmail(email);
		Plan validated_plan=validatePlanAndRegisterAmount( plan, final_amount);
		LocalDate validated_registerDate=validateRegisterDate(registerDate);
		LocalDate plan_end_date=setPlanEndDate(validated_plan,validated_registerDate);
		validatePhoneNo(phoneNo);
		return new Customer(customerId,fname,lname,email,password,address,validated_plan,validated_registerDate,plan_end_date,phoneNo,final_amount);
	}
}
