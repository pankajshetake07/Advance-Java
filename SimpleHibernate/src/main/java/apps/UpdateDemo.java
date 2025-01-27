package apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Emp;

public class UpdateDemo {

	public static void main(String[] args) {
		//create the service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
								
		//read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
								
		//actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
				
		Session session = sf.openSession();	
		
		//reflects one record in the database
		Emp emp = session.get(Emp.class, 7698);
		
		Transaction tr = session.beginTransaction();
		
		//object modified
		emp.setComm(1000.0f);
		
		session.update(emp);
		
		tr.commit();
		
		System.out.println("Emp updated");
		
		session.close();
		
		sf.close();
		
		

	}

}
