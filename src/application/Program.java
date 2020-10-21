package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.List; removido
import java.util.Locale;
import java.util.Scanner;

import entities.Client; //adicionado
import entities.Order;  //adicionado
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus; //adicionado

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();		
		System.out.print("Email: ");
		String email = sc.next();  //sc.nextLine(); //corrigido
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next()); //sc.nextLine(); //corrigido
		
		Client client = new Client(name, email, birthDate); //adicionado
				
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		//String status = sc.nextLine(); //removido
		//Order order = new Order(date, valueOf(OrderStatus), new Client(name)); //corrigido pela linha debaixo
		Order order = new Order(new Date(), status, client);
				
		System.out.println("How many items to this order?");
        int n = sc.nextInt();
        
        for (int i=1; i<=n; i++) {
        	
        	   System.out.println("Enter #"+i+"item data:");
        	   System.out.print("Product name: "); // corrigido println
        	   sc.nextLine(); //adicionado
        	   String productName = sc.nextLine();
        	   
        	   System.out.print("Product price: "); // corrigido println
        	   double productPrice = sc.nextDouble(); //corrigido Double
        	   Product product = new Product(productName, productPrice);        	   
        			   
        	   System.out.print("Quantity: "); // corrigido println
        	   int productQuantity = sc.nextInt();		         			   
        	          	   
        	   OrderItem orderItem = new OrderItem(productQuantity, productPrice, product);  
        	   
        	   order.addItem(orderItem);			
		}
        //adicionado
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);        
        
		sc.close();

	}
}
