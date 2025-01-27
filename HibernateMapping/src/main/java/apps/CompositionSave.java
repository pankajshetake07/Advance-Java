package apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Address;
import entities.Student;

public class CompositionSave {

	public static void main(String[] args) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		
		//read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
									
		//actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
		
		Session session = sf.openSession();
		
		Student st = new Student();
		st.setName("Prathamesh");
		st.setAddress(new Address("Kothrud","Pune","411038"));
		
		Transaction tr = session.beginTransaction();
		session.save(st);
		tr.commit();
		System.out.println("Student inserted");
		
		session.close();
		
		sf.close();
		

	}

}
