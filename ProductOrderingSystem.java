import java.util.HashMap;
import java.util.Scanner;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.ArrayList;

class Customer { //Customer Class
    private String Name;
    private String Phone_No;
    private String Address;
    private String Email;

    public Customer(String Name, String Phone_No, String Address, String Email) {  //Default Constructor
        this.Name = Name;
        this.Phone_No = Phone_No;
        this.Address = Address;
        this.Email = Email;
    }
    
    // Getter and Setter Methods
    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getAddress() {
        return Address;
    }

    public String getPhoneNumber() {
        return Phone_No;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setPhoneNumber(String Phone_No) {
        this.Phone_No = Phone_No;
    }
}

class Product {
    private String Id;
    private String Name;
    private double Price;
    private int Quantity;

    public Product(String Id, String Name, double Price, int Quantity) {
        this.Id = Id;
        this.Name = Name;
        this.Price = Price;
        this.Quantity = Quantity;
    }

    //Getters and setter methods
    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public double getPrice() {
        return Price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
}

class Order {
    private String OrderId;
    private String Customer_Name;
    private String Product_Id;
    private int Quantity;
    private double Total_Price;

    public Order(String OrderId, String Customer_Name, String Product_Id, int Quantity, double Total_Price) {
        this.OrderId = OrderId;
        this.Customer_Name = Customer_Name;
        this.Product_Id = Product_Id;
        this.Quantity = Quantity;
        this.Total_Price = Total_Price;
    }

    //Getter and Setter methods
    public String getId() {
        return OrderId;
    }

    public String getCustomerName() {
        return Customer_Name;
    }

    public String getProductId() {
        return Product_Id;
    }

    public int getQuantity() {
        return Quantity;
    }

    public double getTotalPrice() {
        return Total_Price;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public void setTotalPrice(double Total_Price) {
        this.Total_Price = Total_Price;
    }
}

public class ProductOrderingSystem {
    //Decalration of the Multiple Datastructures for the application
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static HashMap<String, Customer> customerMap = new HashMap<>();
    private static ArrayList<Product> products = new ArrayList<>();
    private static HashMap<String, Product> productMap = new HashMap<>();
    private static ArrayList<Order> orders = new ArrayList<>();
    private static TreeSet<Order> orderTreeSet = new TreeSet<>((order1, order2) -> order1.getId().compareTo(order2.getId()));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n");
            System.out.println("Ordering System");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Product");
            System.out.println("3. Add Order");
            System.out.println("4. Update Customer Details");
            System.out.println("5. Retrieve Customer Details");
            System.out.println("6. Modify Product Details");
            System.out.println("7. Place Order");
            System.out.println("8. Modify Order");
            System.out.println("9. Generate Billing Information");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addCustomer(scanner);
                    break;
                case 2:
                    addProduct(scanner);
                    break;
                case 3:
                    addOrder(scanner);
                    break;
                case 4:
                    updateCustomerDetails(scanner);
                    break;
                case 5:
                    retrieveCustomerDetails(scanner);
                    break;
                case 6:
                    modifyProductDetails(scanner);
                    break;
                case 7:
                    placeOrder(scanner);
                    break;
                case 8:
                    modifyOrder(scanner);
                    break;
                case 9:
                    generateBill();
                    break;
                case 10:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    // Adding Customers to the database
    private static void addCustomer(Scanner scanner) {
        System.out.print("Enter customer name: ");
        String customerName = scanner.next();
        System.out.print("Enter customer email: ");
        String customerEmail = scanner.next();
        System.out.print("Enter customer Address: ");
        String customerAddress = scanner.next();
        System.out.print("Enter customer Phone Number: ");
        String customerPhoneNumber = scanner.next();

        Customer newCustomer = new Customer(customerName, customerPhoneNumber, customerAddress, customerEmail);
        customers.add(newCustomer);
        customerMap.put(newCustomer.getEmail(), newCustomer);

        System.out.println("Customer added successfully.");
    }

    // Function to add products and the details of it
    private static void addProduct(Scanner scanner) {
        System.out.print("Enter product ID: ");
        String productID = scanner.next();
        System.out.print("Enter product name: ");
        String productName = scanner.next();
        System.out.print("Enter product price: ");
        double productPrice = scanner.nextDouble();
        System.out.print("Enter product quantity: ");
        int productQuantity = scanner.nextInt();

        Product newProduct = new Product(productID, productName, productPrice, productQuantity);
        products.add(newProduct);
        productMap.put(newProduct.getId(), newProduct);

        System.out.println("Product added successfully.");
    }

    // Function to add orders and the details of the order
    private static void addOrder(Scanner scanner) {
        System.out.print("Enter order ID: ");
        String orderID = scanner.next();
        System.out.print("Enter customer name for the order: ");
        String orderCustomerName = scanner.next();
        System.out.print("Enter product ID for the order: ");
        String orderProductID = scanner.next();
        System.out.print("Enter order quantity: ");
        int orderQuantity = scanner.nextInt();
    
        Product orderedProduct = productMap.get(orderProductID);
    
        if (orderedProduct != null) {
            double orderPrice = orderedProduct.getPrice() * orderQuantity;
    
            Order newOrder = new Order(orderID, orderCustomerName, orderProductID, orderQuantity, orderPrice);
            orders.add(newOrder);
            orderTreeSet.add(newOrder);
    
            System.out.println("Order added successfully.");
        } else {
            System.out.println("Error: Product not found for the given ID.");
        }
    }

    // Function for updating Customer details
    private static void updateCustomerDetails(Scanner scanner) {
        System.out.print("Enter customer email to update details: ");
        String updateCustomerEmail = scanner.next();
        Customer existingCustomer = customerMap.get(updateCustomerEmail);

        if (existingCustomer != null) {
            System.out.print("Enter new customer name: ");
            String newCustomerName = scanner.next();
            System.out.print("Enter new customer address: ");
            String newCustomerAddress = scanner.next();
            System.out.print("Enter new customer phone number: ");
            String newCustomerPhoneNumber = scanner.next();

            existingCustomer.setName(newCustomerName);
            existingCustomer.setAddress(newCustomerAddress);
            existingCustomer.setPhoneNumber(newCustomerPhoneNumber);

            System.out.println("Customer details updated successfully.");
        } else {
            System.out.println("Customer not found.");
        }
    }

    // Information retrieval method for customer 
    private static void retrieveCustomerDetails(Scanner scanner) {
        System.out.print("Enter customer email to retrieve details: ");
        String retrieveCustomerEmail = scanner.next();
        Customer retrievedCustomer = customerMap.get(retrieveCustomerEmail);

        if (retrievedCustomer != null) {
            System.out.println("Customer Details:");
            System.out.println("Name: " + retrievedCustomer.getName());
            System.out.println("Address: " + retrievedCustomer.getAddress());
            System.out.println("Phone Number: " + retrievedCustomer.getPhoneNumber());
        } else {
            System.out.println("Customer not found.");
        }
    }

    // Product Details Modification Function
    private static void modifyProductDetails(Scanner scanner) {
        System.out.print("Enter product ID to modify details: ");
        String modifyProductID = scanner.next();
        Product existingProduct = productMap.get(modifyProductID);

        if (existingProduct != null) {
            System.out.print("Enter new product name: ");
            String modifiedProductName = scanner.next();
            System.out.print("Enter new product price: ");
            double modifiedProductPrice = scanner.nextDouble();
            System.out.print("Enter new product quantity: ");
            int modifiedProductQuantity = scanner.nextInt();

            existingProduct.setName(modifiedProductName);
            existingProduct.setPrice(modifiedProductPrice);
            existingProduct.setQuantity(modifiedProductQuantity);

            System.out.println("Product details modified successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    //Order Placing and Confirmation function
    private static void placeOrder(Scanner scanner) {
        System.out.print("Enter order ID: ");
        String orderID = scanner.next();
        System.out.print("Enter customer name for the order: ");
        String orderCustomerName = scanner.next();
        System.out.print("Enter product ID for the order: ");
        String orderProductID = scanner.next();
        System.out.print("Enter order quantity: ");
        int orderQuantity = scanner.nextInt();

        Order newOrder = new Order(orderID, orderCustomerName, orderProductID, orderQuantity,
                productMap.get(orderProductID).getPrice() * orderQuantity);
        orders.add(newOrder);
        orderTreeSet.add(newOrder);

        System.out.println("Order placed successfully.");
    }

    // order modification function
    private static void modifyOrder(Scanner scanner) {
        System.out.print("Enter order ID to modify: ");
        String modifyOrderID = scanner.next();
        Order existingOrder = getOrderById(modifyOrderID);

        if (existingOrder != null) {
            System.out.print("Enter new order quantity: ");
            int newQuantity = scanner.nextInt();

            existingOrder.setQuantity(newQuantity);
            existingOrder.setTotalPrice(existingOrder.getQuantity() * productMap.get(existingOrder.getProductId()).getPrice());

            System.out.println("Order modified successfully.");
        } else {
            System.out.println("Order not found.");
        }
    }

    // Order Retrieval function
    private static Order getOrderById(String orderId) {
        for (Order order : orders) {
            if (order.getId().equals(orderId)) {
                return order;
            }
        }
        return null;
    }

    private static void generateBill() {
        System.out.println("----- Bill Details -----");
    
        for (Order order : orderTreeSet) {
            System.out.println("Order ID: " + order.getId());
            System.out.println("Customer Name: " + order.getCustomerName());
    
            Product orderedProduct = productMap.get(order.getProductId());
    
            if (orderedProduct != null) {
                System.out.println("Product ID: " + orderedProduct.getId());
                System.out.println("Product Name: " + orderedProduct.getName());
                System.out.println("Quantity: " + order.getQuantity());
                System.out.println("Price per Unit: Rs" + orderedProduct.getPrice());
                System.out.println("Total Price: Rs" + order.getTotalPrice());
                System.out.println("------------------------");
            } else {
                System.out.println("Error: Product not found for the order.");
            }
        }
    }
    
}