package ECartApp;

public class Customer {
	public String custId;
	protected Name name;
	private String email;
	private String phoneNumber;
	private Address address;
	private String custType;
	String pass;
	
	
	public Customer(String custId, Name name,String email,String phoneNumber, Address address,String custType,String pass) {
		this.custId=custId;
		this.name=name;
		this.email=email;
		this.phoneNumber=phoneNumber;
		this.address=address;
		this.custType=custType;
		this.pass=pass;
		
	}
	void displayData(){
		System.out.println(this.custId);
		System.out.println(this.name.fName+" "+this.name.mName+" "+this.name.lName);
		System.out.println(this.email);
		System.out.println(this.phoneNumber);
		System.out.println(this.address.Locality+", "+this.address.City+", "+this.address.State+", "+this.address.Country+", "+this.address.pinCode);
		System.out.println(this.custType);
	}
	public void payBill(double amount) {
        System.out.println("Customer "+this.name.fName+" "+this.name.mName+" "+ this.name.lName+" paid " + amount);

	}
	
}
