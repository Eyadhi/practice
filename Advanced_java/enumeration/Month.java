package enumeration;

public enum Month {
	JAN(1),FEB(2),MAR(3),APR(4),MAY,JUN,JUL,AUG,SEP,OCT,NOV,DEC;
	private int rupees=0;
    public int getRupees() {
		return rupees;
	}
	public void setRupees(int rupees) {
		this.rupees = rupees;
	}
	Month(int rupees){
		System.out.println("Month");
		this.rupees=rupees;
	}
	Month(){
		System.out.println("Month created");
	}
}
