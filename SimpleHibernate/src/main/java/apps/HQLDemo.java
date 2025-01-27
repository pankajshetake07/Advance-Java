package apps;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import entities.Emp;

public class HQLDemo {

	public static void main(String[] args) {
		//create the service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
										
		//read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
									
		//actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
						
		Session session = sf.openSession();	
				
		/*Query<Emp>  q = session.createQuery("from Emp", Emp.class);
		List<Emp> emps = q.getResultList();
		for(Emp e : emps) {
			System.out.println(e);
		}*/
		
		/*Query<Object[]> q = session.createQuery("select empid,ename from Emp where deptno = 30", Object[].class);
		List<Object[]> emps = q.getResultList();
		for(Object[] e : emps) {
			System.out.println(e[0]+" : "+e[1]);
		}*/
		
		/*Query<Object[]> q = session.createQuery("select empid,ename,sal from Emp where sal between ?1 and ?2",Object[].class);
		q.setParameter(1, 3000.0f);
		q.setParameter(2, 5000.0f);
		List<Object[]> emps = q.getResultList();
		for(Object[] e : emps) {
			System.out.println(e[0]+" : "+e[1]+" : "+e[2]);
		}*/
		
		/*Query<Object[]> q = session.createQuery("select empid,ename,sal from Emp where sal between :min and :max",Object[].class);
		q.setParameter("min", 3000.0f);
		q.setParameter("max", 5000.0f);
		List<Object[]> emps = q.getResultList();
		for(Object[] e : emps) {
			System.out.println(e[0]+" : "+e[1]+" : "+e[2]);
		}*/
		
		//no need to specify the result type explicitly
		/*NativeQuery q= session.createNativeQuery("select e.empno,e.ename,d.deptno,d.dname from emp e,dept d where e.deptno = d.deptno");
		List<Object[]> emps = q.getResultList();
		for(Object[] e : emps) {
			System.out.println(e[0]+" : "+e[1]+" : "+e[2]+" : "+e[3]);
		}*/
		
		/*Query q = session.createQuery("update Emp set comm = ?1 where empid = ?2");
		q.setParameter(1, 999.0f);
		q.setParameter(2, 7900);
		Transaction tr = session.beginTransaction(); 
		int n = q.executeUpdate();
		tr.commit();
		System.out.println(n+ " records updated"); 
		*/
		
		//count - long
		//min,max,avg,sum - double
		/*Query q = session.createQuery("select avg(sal) from Emp");
		double f = (Double)q.uniqueResult();
		System.out.println("Avg sal : "+f);*/
		
		Query<Emp> q = session.createNamedQuery("getEmpsFromDept",Emp.class);
		q.setParameter(1, 30);
		List<Emp> emps = q.getResultList();
		for(Emp e : emps) {
			System.out.println(e);
		}
		
		session.close();
		
		sf.close();
		
	}

}
