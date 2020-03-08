package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="uomtab")
public class Uom {
	@Id
	@GeneratedValue
	@Column(name="umid")
	private Integer id;
	@Column(name="utype")
	private String uomType;
	@Column(name="umodel")
	private String uomModel;
	@Column(name="udesc")
	private String uomDesc;
	
	public Uom() {
		super();
	}
	
	

	public Uom(Integer id) {
		super();
		this.id = id;
	}



	public Integer getid() {
		return id;
	}



	public void setid(Integer id) {
		this.id = id;
	}



	public String getUomType() {
		return uomType;
	}



	public void setUomType(String uomType) {
		this.uomType = uomType;
	}



	public String getUomModel() {
		return uomModel;
	}



	public void setUomModel(String uomModel) {
		this.uomModel = uomModel;
	}



	public String getUomDesc() {
		return uomDesc;
	}



	public void setUomDesc(String uomDesc) {
		this.uomDesc = uomDesc;
	}



	@Override
	public String toString() {
		return "Uom [id=" + id + ", uomType=" + uomType + ", uomModel=" + uomModel + ", uomDesc=" + uomDesc + "]";
	}

	
}
