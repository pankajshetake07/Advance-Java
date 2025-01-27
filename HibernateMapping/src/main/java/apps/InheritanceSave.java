package apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.ContractEmp;
import entities.Emp;
import entities.PerEmp;

public class InheritanceSave {

	public static void main(String[] args) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		
		//read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
									
		//actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
		
		Session session = sf.openSession();		// TODO Auto-generated method stub
		
		PerEmp pemp = new PerEmp();
		pemp.setEname("Bakul");
		pemp.setSal(10000.0f);
		pemp.setBonus(890.0f);
		
		ContractEmp cemp = new ContractEmp();
		cemp.setEname("Vaibhav");
		cemp.setExtraHours(23.5f);
		cemp.setChargesPerHour(980.0f);
		
		Transaction tr = session.beginTransaction();
		session.save(pemp);
		session.save(cemp);
		tr.commit();
		
		System.out.println("emps saved");
		
		session.close();
		
		sf.close();
		
		

	}

}
