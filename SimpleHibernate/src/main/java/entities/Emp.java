package entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="emp")

@NamedQuery(name = "getEmpsFromDept",query = "from Emp where deptno = ?1")
public class Emp {
	@Id
	@Column(name="EMPNO")
	int empid;
	
	@Column(name="ENAME")
	String ename;
	
	@Column(name="JOB")
	String job;
	
	@Column(name="MGR")
	Integer mgr;
	
	@Column(name="HIREDATE")
	Date hiredate;
	
	@Column(name="SAL")
	Float sal;
	
	@Column(name="COMM")
	Float comm;
	
	@Column(name="DEPTNO")
	Integer deptno;

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public float getSal() {
		return sal;
	}

	public void setSal(float sal) {
		this.sal = sal;
	}

	public float getComm() {
		return comm;
	}

	public void setComm(float comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(int empid, String ename, String job, int mgr, Date hiredate, float sal, float comm, int deptno) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "Emp [empid=" + empid + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate=" + hiredate
				+ ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}
	
	
	

}
