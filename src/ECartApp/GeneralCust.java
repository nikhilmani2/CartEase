package ECartApp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class GeneralCust extends Customer implements BillingInterface {
	
	private double deliveryCharge=50;

	public GeneralCust(String custId, Name name, String email, String phoneNumber, Address address, String custType,
			String pass) {
		super(custId, name, email, phoneNumber, address, custType, pass);
	}
	public void payBill(double amount) {
		LocalDate date=LocalDate.now();
    	LocalTime time=LocalTime.now();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    	String formattedTime = time.format(formatter);
    	System.out.println("                  Bill                 ");
    	System.out.println("---------------------------------------");
    	System.out.println("|               CartEase              |");
    	System.out.println("|           GSTIN:TYUISB6475N         |");
    	System.out.println("|Time: "+formattedTime+"        "+"Date:"+date+"|");
    	System.out.println("|Buyer Name: "+this.name.fName+"                   |");
    	System.out.println("---------------------------------------");
    	System.out.println("Total amount: "+amount);
    	System.out.println("Delivery Charge: "+deliveryCharge);
    	amount+=deliveryCharge;
    	System.out.println("Amount Paid: "+amount);
    	System.out.println();
		System.out.println("Guest customer "+this.name.fName+" "+this.name.mName+" "+this.name.lName+" paid " + amount+" after adding the delivery charge");
        System.out.println();
		System.out.println("To get big discounts on every order please become our Prime member!!!");
        System.out.println();
		System.out.println("Thank You for shopping with us !");


	}
}
