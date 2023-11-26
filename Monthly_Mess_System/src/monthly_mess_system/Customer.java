package monthly_mess_system;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer implements Serializable {
	
//	Customer id(int) , first name(String), last name (String), email(String), password(String), 
	//Address String, RegisterDate(LocalDate), planEndDate(LocalDate), Address(String), 
	//Phone No(String),plan Enum, final_amount double
//	Messplan(Plan : enum) Plans Are as follows:-

	
	private int customerId;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private String address;
	private LocalDate registerDate;
	private LocalDate planEndDate;
	private String phoneNo;
	private Plan plan;
	private double final_amount;
	
	public Customer(int customerId, String fname, String lname, String email, String password, String address,
			 Plan plan,LocalDate registerDate, LocalDate planEndDate, String phoneNo, double final_amount) {
		super();
		this.customerId = customerId;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.address = address;
		this.plan = plan;
		this.registerDate = registerDate;
		this.planEndDate = planEndDate;
		this.phoneNo = phoneNo;
		this.final_amount = final_amount;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}
	public LocalDate getPlanEndDate() {
		return planEndDate;
	}
	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	public double getFinal_amount() {
		return final_amount;
	}
	public void setFinal_amount(double final_amount) {
		this.final_amount = final_amount;
	}
	
	@Override
	public boolean equals(Object o) {
		return this.email.equals(((Customer) o).getEmail());
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", address=" + address + ", registerDate=" + registerDate + ", planEndDate=" + planEndDate
				+ ", phoneNo=" + phoneNo + ", plan=" + plan + ", final_amount=" + final_amount + "]";
	}
	
	
	


}
