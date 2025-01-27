package apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.ContractEmp;
import entities.PerEmp;

public class InehritanceFetch {

	public static void main(String[] args) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		
		//read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
									
		//actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
		
		Session session = sf.openSession();		// TODO Auto-generated method stub
	
		PerEmp pemp = session.get(PerEmp.class, 1);
		if(pemp != null) {
			System.out.println(pemp.getEname()+" : "+pemp.getSal());
		}
		
		ContractEmp cemp =session.get(ContractEmp.class, 2);
		if(cemp != null) {
			System.out.println(cemp.getEname()+" : "+cemp.getExtraHours());
		}
		
		session.close();
		
		sf.close();
	}

}
