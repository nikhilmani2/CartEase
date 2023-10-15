package ECartApp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ClubCust extends Customer implements BillingInterface {

	private double loyaltyPoints;

	private double discountPercentage=0.35;
	public ClubCust(String custId, Name name, String email, String phoneNumber, Address address, String custType,
			String pass) {
		super(custId, name, email, phoneNumber, address, custType, pass);
	}
	 public double getDiscountPercentage() {
	        return discountPercentage;
	    }

	    public void setDiscountPercentage(double discountPercentage) {
	        this.discountPercentage = discountPercentage;
	    }
	    public double getLoyaltyPoints() {
	        return loyaltyPoints;
	    }

	    public void addLoyaltyPoints(double loyaltyPoints) {
	        this.loyaltyPoints += loyaltyPoints;
	    }
	    @Override
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
	    	System.out.println("Discount Percentage: "+(discountPercentage*100));
	        double discountAmount = amount * discountPercentage;
	        amount -= discountAmount;
	        double loyalityadd=amount*0.2;
	        addLoyaltyPoints(loyalityadd);
	        System.out.println("Your loyality points: "+getLoyaltyPoints());
	    	System.out.println("Amount Paid: "+amount);
	    	System.out.println();
	        System.out.println("Club customer "+this.name.fName+" "+this.name.mName+" "+this.name.lName+" paid "+ amount +" after a discount of "+ discountAmount);
	        System.out.println();
	        System.out.println("Thank You for shopping with us !");

	        
	    }
}
