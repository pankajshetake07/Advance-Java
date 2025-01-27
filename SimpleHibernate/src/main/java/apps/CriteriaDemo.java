package apps;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import entities.Emp;

public class CriteriaDemo {

	public static void main(String[] args) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		
		//read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
									
		//actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
		
		Session session = sf.openSession();	
		
		//select * from emp, from Emp
		/*CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Emp> cquery = builder.createQuery(Emp.class);
		//from clause
		Root<Emp> root= cquery.from(Emp.class);
		cquery.select(root);
		Query q = session.createQuery(cquery);
		List<Emp> emps = q.getResultList();
		for(Emp e : emps) {
			System.out.println(e);
		}*/
		
		//select empid,ename from emp where deptno = 30
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> cquery = builder.createQuery(Object[].class);
		//from clause
		Root<Emp> root= cquery.from(Emp.class);
		cquery.multiselect(root.get("empid"),root.get("ename"));
		cquery.where(builder.equal(root.get("deptno"),30));
		Query q = session.createQuery(cquery);
		List<Object[]> emps = q.getResultList();
		for(Object[] e : emps) {
			System.out.println(e[0]+" : "+e[1]);
		}
		
		session.close();
		
		sf.close();
	}

}
