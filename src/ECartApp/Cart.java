package ECartApp;

import java.util.HashMap;
import java.util.Map;

public class Cart {

	 private Map<String, Item> items;

	    public Cart() {
	        items = new HashMap<>();
	    }

	    public void addItem(String itemName, int quantity, double price) {
	        Item item = new Item(itemName, quantity, price);
	        if (items.containsKey(itemName)) {
	            Item existingItem = items.get(itemName);
	            existingItem.quantity += quantity;
	        } else {
	            items.put(itemName, item);
	        }
	    }

	    public Item getItem(String itemName) {
	        return items.get(itemName);
	    }
	    public void showFullMap() {
	    	System.out.println(" ");
	        System.out.println("Your Cart Items:");
	        for (Map.Entry<String, Item> entry : items.entrySet()) {
	            String itemName = entry.getKey();
	            Item item = entry.getValue();

	            System.out.println("Item Name: " + itemName);
	            System.out.println("Quantity: " + item.quantity);
	            System.out.println("Price: " + item.price);
	            System.out.println("--------------------------------------");
	        }
	    }

	    public void removeItem(String itemName) {
	        items.remove(itemName);
	    }

	    public Map<String, Item> getItems() {
	        return items;
	    }
	    public double calculateTotalAmount() {
	        double totalAmount = 0.0;
	        for (Map.Entry<String, Item> entry : items.entrySet()) {
	            Item item = entry.getValue();
	            totalAmount += item.quantity * item.price;
	        }
	        return totalAmount;
	    }

	    private static class Item {
	        private String itemName;
	        private int quantity;
	        private double price;

	        public Item(String itemName, int quantity, double price) {
	            this.itemName = itemName;
	            this.quantity = quantity;
	            this.price = price;
	        }

	        public String getItemName() {
	            return itemName;
	        }

	        public int getQuantity() {
	            return quantity;
	        }

	        public double getPrice() {
	            return price;
	        }

	        public void setQuantity(int quantity) {
	            this.quantity = quantity;
	        }

	        public void setPrice(double price) {
	            this.price = price;
	        }
	        
	    }
}

