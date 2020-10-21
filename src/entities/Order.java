package entities;

import java.text.SimpleDateFormat; //adicionado
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import entities.enums.OrderStatus;

public class Order {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //adicionado
	
	private Date moment; 
	private OrderStatus status;
	
	private Client client;	
	private List<OrderItem> items = new ArrayList<OrderItem>();//yoytube

	
	//public Order() { //removido
	//}

	public Order(Date moment, OrderStatus status, Client client /*adicionado*/) {
		this.moment = moment;
		this.status = status;
		this.client = client; //adicionado
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	//public List<OrderItem> getItems() { //youtube
	//	return items;
	//}
	
	public void addItem( OrderItem item) {
		items.add(item);
	}
	
	public void removeItem( OrderItem item) {
		items.remove(item);
	}
	
	public double total() { //adicionado
		double sum = 0.0;
		for (OrderItem item : items) {
			sum += item.subTotal();
		}
		return sum;
	}

@Override	
	public String toString() { //corrigido toStringBuilder()
	   StringBuilder sb = new StringBuilder();
     //  sb.append( "ORDER SUMMARY: \n"); //removido
       sb.append("Order moment: "); //+ getMoment()); //corrigido
       sb.append(sdf.format (moment) + "\n"); //adicionado
       sb.append("Order status: "); //+ getStatus()); //corrigido
       sb.append(status + "\n");//adicionado
       sb.append("Client: "); //+ getProduct(name)+" "+getProduct(data)+" - "+getProduct(email)); //corrigido
       //adicionado
		sb.append(client + "\n");
		sb.append("Order items:\n");
		for (OrderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();

	}
}











