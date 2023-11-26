package utils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import monthly_mess_system.*;

public class populateCustomerData {
	public static 	HashMap<String,Customer> populateData(){
	HashMap<String,Customer> cmap = new HashMap<>();
	//customerId,fname,lname,email,password,address,
	//validated_plan,validated_registerDate,plan_end_date,phoneNo,final_amount
	cmap.put("ram@gmail.com",new Customer(1001,"ram","Panday","ram@gmail.com","ram123","Pune",Plan.YEARLY,LocalDate.parse("2023-01-06"),LocalDate.parse("2023-05-06"),"94234518",32000.00));
	cmap.put("sham@gmail.com",new Customer(1001,"sham","Panday","sham@gmail.com","ram123","Pune",Plan.MONTHLY,LocalDate.parse("2020-01-06"),LocalDate.parse("2023-05-06"),"94234518",3000.00));
	cmap.put("ramesh@gmail.com",new Customer(1001,"ramesh","Panday","ramesh@gmail.com","ram123","Akurdi",Plan.HALFYEAR,LocalDate.parse("2021-01-06"),LocalDate.parse("2023-05-06"),"94234518",32000.00));
	cmap.put("suresh@gmail.com",new Customer(1001,"suresh","Panday","suresh@gmail.com","ram123","Pune",Plan.MONTHLY,LocalDate.parse("2023-05-06"),LocalDate.parse("2023-05-06"),"94234518",3000.00));
	cmap.put("raj@gmail.com",new Customer(1001,"raj","Panday","raj@gmail.com","ram123","Akurdi",Plan.QUARTERLY,LocalDate.parse("2022-01-06"),LocalDate.parse("2023-05-06"),"94234518",32000.00));

	return cmap;
	}
}
