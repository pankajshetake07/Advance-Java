package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="peremp")
@PrimaryKeyJoinColumn(name = "eid")
public class PerEmp extends Emp {
	@Column
	float sal;
	
	@Column
	float bonus;

	public PerEmp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PerEmp(int empid, String ename,float sal,float bonus) {
		super(empid, ename);
		this.sal = sal;
		this.bonus = bonus;
	}

	public float getSal() {
		return sal;
	}

	public void setSal(float sal) {
		this.sal = sal;
	}

	public float getBonus() {
		return bonus;
	}

	public void setBonus(float bonus) {
		this.bonus = bonus;
	}
	
	
	
	
}
