package beans;

import java.util.List;

public class Emp {
	int empno;
	Name nm;
	Address address;
	Dept dept;
	List<String> emails;
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public Name getNm() {
		return nm;
	}
	public void setNm(Name nm) {
		this.nm = nm;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public List<String> getEmails() {
		return emails;
	}
	public void setEmails(List<String> emails) {
		this.emails = emails;
	}
	
	//business logic
	public String toString() {
		return "Emp [empno=" + empno + ", nm=" + nm + ", address=" + address + ", dept=" + dept + ", emails=" + emails
				+ "]";
	}
	
	
}
