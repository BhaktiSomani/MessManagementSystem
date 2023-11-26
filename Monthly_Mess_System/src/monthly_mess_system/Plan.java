package monthly_mess_system;

public enum Plan {
//	 Monthly (3000), Quarterly (11700), Half Year (17500), Yearly (32000)
	MONTHLY(3000),QUARTERLY(11700),HALFYEAR(17500),YEARLY(32000);
	private double messCharges;
	Plan(int messCharges) {
		this.messCharges=messCharges;
	}
	public double getMessCharges() {
		return messCharges;
	}
	public void setMessCharges(double messCharges) {
		this.messCharges = messCharges;
	}
	
	
}
