package dto;

public class Household {
	private int number;
	private String date;
	private int income;
	private int spending;
	private int balanceg;
	private String type;
	
	public Household(){
		
	}

	public Household(int number, String date, int income, int spending, int balanceg, String type) {
		this.number = number;
		this.date = date;
		this.income = income;
		this.spending = spending;
		this.balanceg = balanceg;
		this.type = type;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public int getSpending() {
		return spending;
	}

	public void setSpending(int spending) {
		this.spending = spending;
	}

	public int getBalanceg() {
		return balanceg;
	}

	public void setBalanceg(int balanceg) {
		this.balanceg = balanceg;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
