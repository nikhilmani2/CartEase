package ECartApp;

public class Address {
	String Locality,City,State,Country;
	long pinCode;
	public Address(String string, String string2, String string3,String string4,long pc) {
		this.Locality=string;
		this.City=string2;;
		this.State=string3;
		this.Country=string4;
		this.pinCode=pc;
		}
}