package entities;

import java.sql.Date;

public class Emp implements Comparable<Emp>{
	//similar to columns 
	//names of columns and properties need not match
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private float sal, comm;
	private int deptno;
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emp(int empno, String ename, String job, int mgr, Date hiredate, float sal, float comm, int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
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
	@Override
	public int compareTo(Emp o) {
		// this and o 
		//return (int)(this.sal - o.sal);
		int diff = 0;
		if(this.sal > o.sal)
			diff = 1;
		else if(this.sal < o.sal)
			diff = -1;
		else if(this.sal == o.sal) {
			diff = this.empno - o.empno;
		}
		return diff;
	}
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", sal=" + sal + ", deptno=" + deptno + "]";
	}
	
	
	
	

}
