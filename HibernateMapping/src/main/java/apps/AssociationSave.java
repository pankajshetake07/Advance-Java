package apps;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Order;
import entities.OrderItem;

public class AssociationSave {

	public static void main(String[] args) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		
		//read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
									
		//actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
		
		Session session = sf.openSession();		// TODO Auto-generated method stub
		
		//saving new order
		/*Order o1 = new Order("Mukta");
		Transaction tr = session.beginTransaction();
		session.save(o1);
		tr.commit();	*/
		
		//saving orderitem - existing order
		/*Order order= session.get(Order.class, 1);
		OrderItem oi1 = new OrderItem(2,4,order);
		Transaction tr = session.beginTransaction();
		session.save(oi1);
		tr.commit();*/
		
		//save master with multiple child
		/*OrderItem oii1 = new OrderItem(1,5);
		OrderItem oii2 = new OrderItem(3, 4);
		Set<OrderItem> items = new HashSet<>();
		items.add(oii1);
		items.add(oii2);
		//set this for orderitem instances as its master - constructors, setter
		Order oi2 = new Order("Meena");
		oi2.setItems(items);
		Transaction tr = session.beginTransaction();
		session.save(oi2);   //one entry master, 2 entries - child
		tr.commit();*/
		
		//saving new child with new master
		Order o3 = new Order("Swapna");
		OrderItem oii4 = new OrderItem(7, 2 , o3);
		Transaction tr = session.beginTransaction();
		session.save(oii4);   //one entry master, 2 entries - child
		tr.commit();
		
		
		session.close();
		
		sf.close();
		
		
		

	}

}
