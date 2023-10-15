package ECartApp;

import java.util.InputMismatchException;
import java.util.Scanner;



public class MainMenu {
	Name n1= new Name("Nikhil","S","Mani");
	Address a1=new Address("Vidyapuri","Madhepura","Bihar","India",852113);
    ClubCust c1 = new ClubCust("c1",n1,"nimani.ext@deloitte.com","975453334",a1,"Club","cpass");
	
	
	Address a2=new Address("DB Road","Saharsa","Bihar","India",852121);
	Name n2=new Name("Raj","M","Kapoor");
	PrimeCust c2 = new PrimeCust("p1",n2,"raj34@gmail.com","975453334",a2,"Prime","ppass");
	
	
	Address a3=new Address("Panchsheel Park","Varanasi","Uttar Pradesh","India",456443);
	Name n3=new Name("Mayank","B","Mishra");
	GeneralCust c3 = new GeneralCust("g1",n3,"mmishra@gmail.com","975453335",a3,"General","gpass");
	void menu_one() {
		
		menu_two();
	}
	void menu_two()  {
		WelcomeScreen ws= new WelcomeScreen();
		ws.welcome();
		System.out.println();
		System.out.println("              LOGIN(0) / SIGN UP(1)             ");
		int str;
		Scanner sc =new Scanner(System.in);
		str=sc.nextInt();
			if(str==0) {
				login();
			}
			else if(str==1) {
				signup();
			}
			else {
				System.out.println("Wrong Input!!!");
				
			}
			 
		
	}
	void login() {
		    System.out.println("***************************************************");
	        System.out.println("                      Login to Cart Ease                   ");
	        System.out.println("***************************************************");
	        System.out.println("");
	        System.out.print("Customer ID: ");
	        String cusid;
			Scanner sc =new Scanner(System.in);
			cusid=sc.next();
			String password;
	        System.out.print("Password: ");
	        password=sc.next();

	        if (cusid.equals(c1.custId) && password.equals(c1.pass)) {
	            System.out.println("Login successful!");
	            productmenu(c1);
	        } 
	        else if(cusid.equals(c2.custId) && password.equals(c2.pass)) {
	            System.out.println("Login successful!");
	            productmenu(c2);
	        }
	        else if(cusid.equals(c3.custId) && password.equals(c3.pass)) {
	            System.out.println("Login successful!");
	            productmenu(c3);
	        }
	        else {
	            System.out.println("Invalid customer ID or password.");
	        }
	}
	void signup() {
		System.out.println("***************************************************");
        System.out.println("                      Sign Up to Cart Ease                   ");
        System.out.println("***************************************************");
        Name nametemp=new Name(null, null, null);
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter your First Name: ");
		nametemp.fName=sc.next();
		System.out.println("Enter your middle Name: ");
		nametemp.mName=sc.next();
		System.out.println("Enter your last name: ");
		nametemp.lName=sc.next();
		Address addresstemp=new Address(null, null, null, null, 0);
		System.out.println("Enter your locality: ");
		addresstemp.Locality=sc.next();
		System.out.println("Enter your City: ");
		addresstemp.City=sc.next();
		System.out.println("Enter your State: ");
		addresstemp.State=sc.next();
		System.out.println("Enter your Country: ");
		addresstemp.Country=sc.next();
		System.out.println("Enter your Pincode: ");
		addresstemp.pinCode=sc.nextLong();
		String phoneNum;
		System.out.println("Enter your phone number: ");
		phoneNum=sc.next();
		String email;
		System.out.println("Enter your email: ");
		email=sc.next();
		String custype="General";
		String passworda;
		System.out.println("Enter password: ");
		passworda=sc.next();
		String custidtoken="g";
		int gcount=1;
		String custid=custidtoken+ (Integer.toString(++gcount));
        GeneralCust gg= new GeneralCust( custid,nametemp,email,phoneNum,addresstemp,custype,passworda);
        System.out.println("Sign Up Successfull!!!!");
        productmenu(gg);
	}
	
	void productmenu(Customer c) {
		System.out.println("***************************************************");
        System.out.println("                      MENU                   ");
        System.out.println("***************************************************");
		String[] groceryItems = {"Rice", "Wheat", "Lentils", "Oil", "Salt", "Sugar", "Tea","Toothpaste"};
		double[] groceryItemPrices = {20, 30, 40, 50, 60, 70, 80, 50};
		System.out.println("**********Welcome to the Grocery Menu!**********");
		for (int i = 0; i < groceryItems.length; i++) {
		    System.out.println((i + 1) + ". " + groceryItems[i] + " - Rs " + groceryItemPrices[i]);
		}

		Cart cart = new Cart();
		System.out.println("Enter the item number to add to cart: ");
		Scanner sc =new Scanner(System.in);
		int choice=sc.nextInt();
		System.out.println("Enter the quantity: ");
		int quantity =sc.nextInt();
		cart.addItem(groceryItems[choice-1], quantity,(groceryItemPrices[choice-1]));
		System.out.println("              Added to cart successfully.             ");
		System.out.println("Do you want to add more item or proceed to billing ?");
		System.out.println("Enter 1 for adding more item: ");
		System.out.println("Enter 2 for billing: ");
		int corb=sc.nextInt();
		if(corb==1) {
			System.out.println("Enter the item number to add to cart: ");
			Scanner sce =new Scanner(System.in);
			int choicee=sce.nextInt();
			System.out.println("Enter the quantity: ");
			int quantityy =sce.nextInt();
			cart.addItem(groceryItems[choicee-1], quantityy,(groceryItemPrices[choicee-1]*quantityy));
			System.out.println("              Added to cart successfully.               ");
			System.out.println("               Initiating Billing....."              );
			double amounttot=0;
			cart.showFullMap();
			amounttot=cart.calculateTotalAmount();
			c.payBill(amounttot);

		}
		else if(corb==2) {
			
			double amounttot = 0;
			cart.showFullMap();
			amounttot=cart.calculateTotalAmount();
			c.payBill(amounttot);
		}
		else {
			System.out.println("Wrong Choice!!");
		}
		
		

	}
}
