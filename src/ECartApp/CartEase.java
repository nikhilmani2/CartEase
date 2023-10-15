package ECartApp;

import java.util.InputMismatchException;

public class CartEase {

	public static void main(String[] args){
		
		MainMenu m =new MainMenu();
	    try{
	    	m.menu_one();
	    }
	    catch(InputMismatchException e) {
	    	System.out.println("Input Mismatch");
	    }
	   
	}
}
