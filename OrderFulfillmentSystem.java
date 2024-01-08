import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class OrderFulfillmentSystem {
    public static void main(String[] args) {
        EnhancedOrderFulfillmentSystem system = new EnhancedOrderFulfillmentSystem(5); // Example: 5 worker threads

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Place Order");
            System.out.println("2. Check Availability");
            System.out.println("3. Add Item to Inventory");
            System.out.println("4. Update Inventory");
            System.out.println("5. View Inventory");
            System.out.println("6. Exit");
            System.out.print("Select Option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter item name: ");
                    String itemName = scanner.next();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();

                    Map<String, Integer> items = new HashMap<>();
                    items.put(itemName, quantity);
                    Order order = new Order(items);
                    system.placeOrder(order);
                    System.out.println("Order placed! Order ID: " + order.getOrderId());
                    break;
                case 2:
                    System.out.print("Enter item name to check availability: ");
                    String checkItem = scanner.next();
                    int availableQuantity = system.checkInventoryAvailability(checkItem);
                    System.out.println("Available quantity for item '" + checkItem + "': " + availableQuantity);
                    break;
                case 3:
                    System.out.print("Enter item name to add to inventory: ");
                    String newItemName = scanner.next();
                    System.out.print("Enter quantity to add: ");
                    int newQuantity = scanner.nextInt();
                    system.addItemToInventory(newItemName, newQuantity);
                    System.out.println("Item added to inventory!");
                    break;
                case 4:
                    System.out.print("Enter item name to update inventory: ");
                    String updateItemName = scanner.next();
                    System.out.print("Enter new quantity: ");
                    int updatedQuantity = scanner.nextInt();
                    system.updateInventory(updateItemName, updatedQuantity);
                    System.out.println("Inventory updated!");
                    break;
                case 5:
                    system.printInventory();
                    break;
                case 6:
                    system.shutdown();
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}