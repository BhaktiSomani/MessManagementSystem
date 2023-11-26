package tester;

import static utils.IO_operaions.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static utils.validateAllInput.*;
import monthly_mess_system.Customer;
import monthly_mess_system.Plan;
import sorted_data.sortByFname;
import sorted_data.sortByPlan;
import sorted_data.sortByRegistrationDate;
import utils.authenticateCustomer;
import utils.validateAllInput;
import static utils.populateCustomerData.*;
import static utils.authenticateCustomer.*;
public class test_mess_system {

	public static void main(String[] args) {
		Map<String,Customer> cmap =  populateData();
		boolean exit=false;
		String filename="CustomerData.txt";
		System.out.println("Details from the file: ");
		Map<String,Customer> file_data = retriveDetails(filename);
		file_data.values().stream().forEach(System.out::println);
		try(Scanner sc=new Scanner(System.in)){
			try {
			while(!exit) {
				System.out.println("\n1:Sign up Customer 2:Sign In 3:Change password\n"
						+ "4:Sort Customers 5:Unscuscribe customer 6:Display all customers\n"
						+"7:Modify customers first name to uppercase 8:Customers registered in January\n"
						+ "9:Count of Monthly Customers 10:Customer who lived in Akurdi\n"
						+ "11:20% discount to the customers who have selected plan for 1 year."
						+"0: Exit\n");
				
				switch(sc.nextInt()) {
				case 1:
					System.out.println("Enter customer details:customerId,fname,lname,email,password,"
							+ "address,validated_plan,validated_registerDate,phoneNo,final_amount ");
					Customer customer = validateAllInput(sc.nextInt(),sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),cmap);
					cmap.put(customer.getEmail(), customer);
					System.out.println("Customer details added successfully!!");
					break;
				case 2:
					System.out.println("Enter email id and password: ");
					authentication(sc.next(),sc.next(),cmap);
					System.out.println("Sign In Successful !!");
					break;
				case 3:
					//3. Change Password  
					System.out.println("Enter email id and password: ");
					Customer c=authentication(sc.next(),sc.next(),cmap);
					System.out.println("Enter new password: ");
					c.setPassword(sc.next());
					System.out.println("Password updated successfully !!");
					break;
				case 4:
					/*
					 * . Sort Customer as per 
							A) First name 
							B) According to plan
							C) According to date of registration
					 */
				System.out.println("Sort customers as per A)First name\n"
						+ "B) According to plan\n"
						+ "C) According to date of registration"); 
					switch(sc.next().charAt(0)) {
					case 'A':
						System.out.println("Sorted data as per first name: ");
						ArrayList<Customer> custList = new ArrayList<>(cmap.values());
						Collections.sort(custList, new sortByFname());
						for(Customer c1:custList)
							System.out.println(c1);
						break;
						case 'B':
							System.out.println("Sorted data as per plan: ");
							custList = new ArrayList<>(cmap.values());
							Collections.sort(custList, new sortByPlan());
							for(Customer c1:custList)
								System.out.println(c1);
							break;
						case 'C':
							System.out.println("Sorted data as per registration date: ");
							custList = new ArrayList<>(cmap.values());
							Collections.sort(custList, new sortByRegistrationDate());
							for(Customer c1:custList)
								System.out.println(c1);
							break;
					}
					break;
				case 5:
					System.out.println("Enter plan duration to unsubscribe: ");
					int duration = sc.nextInt();
					for(Customer c1:cmap.values()) {
						if(duration==1 && c1.getPlan().equals(Plan.MONTHLY))
							cmap.remove(c1);
						else if(duration==3 && c1.getPlan().equals(Plan.QUARTERLY))
							cmap.remove(c1);
						else if(duration==6 && c1.getPlan().equals(Plan.HALFYEAR))
							cmap.remove(c1);
						else if(duration==12 && c1.getPlan().equals(Plan.YEARLY))
							cmap.remove(c1);
					}
					System.out.println("Customers has been unbuscribed. Available customers are : ");
					for(Customer c1:cmap.values())
						System.out.println(c1);
					break;
				case 6:
			
					System.out.println("All customer details: ");
					for(Customer c1:cmap.values())
						System.out.println(c1);
					break;
				case 8:
					System.out.println("Customers registered in January: ");
					cmap.values().stream().filter(c1->c1.getRegisterDate().getMonthValue()==1).forEach(System.out::println);
					break;
				case 9:
					long cnt=cmap.values().stream().filter(c1-> c1.getPlan().name().equals("MONTHLY")).count();
					System.out.println("Count of monthly customers: "+cnt);
					break;
				case 0:
					storeDetails(filename,cmap);
					System.out.println("Customer details has been saved to file");
					exit=true;
				}
				
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}



}

//10 bhakti somani abc@gmail.com abcd pune monthly 2023-11-11 9427350121 3000.00
