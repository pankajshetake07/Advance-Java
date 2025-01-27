package apps;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Emp;

public class SaveDemo {

	public static void main(String[] args) {
		//create the service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
						
		//read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
						
		//actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
		
		Session session = sf.openSession();
		
		//transient
		Emp e = new Emp(1000,"Rajesh","MANAGER",7521,null,13400.0f, 900.0f, 20);
		
		Transaction tr = session.beginTransaction();
		//insert query
		session.save(e);
		
		tr.commit();
		
		session.close();
		
		sf.close();
		

	}

}
