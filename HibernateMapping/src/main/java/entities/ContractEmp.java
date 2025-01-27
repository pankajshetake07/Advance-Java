package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="conemp")
@PrimaryKeyJoinColumn(name="eid")
public class ContractEmp extends Emp {

	@Column
	float extraHours;
	
	@Column
	float chargesPerHour;

	public ContractEmp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContractEmp(int empid, String ename, float extraHours, float chargesPerHour) {
		super(empid, ename);
		this.extraHours = extraHours;
		this.chargesPerHour = chargesPerHour;
	}

	public float getExtraHours() {
		return extraHours;
	}

	public void setExtraHours(float extraHours) {
		this.extraHours = extraHours;
	}

	public float getChargesPerHour() {
		return chargesPerHour;
	}

	public void setChargesPerHour(float chargesPerHour) {
		this.chargesPerHour = chargesPerHour;
	}
	
	
	
}
