package in.nit.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ordertab")
public class OrderMethod {

	@Id
	@GeneratedValue(generator="omidgen")
	@GenericGenerator(name="omidgen",strategy = "increment")
	@Column(name="omid")
	private Integer orderId;
	@Column(name="ommode")
	private String orderMode;
	@Column(name="omcode")
	private String orderCode;
	@Column(name="ommethod")
	private String orderMethod;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="omacpttab",joinColumns=@JoinColumn(name="omid"))
	@OrderColumn(name="pos")
	@Column(name="ocpt")
	private List<String> orderAccept;
	@Column(name="omdesc")
	private String orderDesc;

	//0-param constructor
	public OrderMethod() {
		super();
	}
	

	public OrderMethod(Integer orderId) {
		super();
		this.orderId = orderId;
	}


	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public List<String> getOrderAccept() {
		return orderAccept;
	}


	public void setOrderAccept(List<String> orderAccept) {
		this.orderAccept = orderAccept;
	}


	public String getOrderMode() {
		return orderMode;
	}

	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOrderMethod() {
		return orderMethod;
	}

	public void setOrderMethod(String orderMethod) {
		this.orderMethod = orderMethod;
	}

	

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	@Override
	public String toString() {
		return "OrderMethod [orderId=" + orderId + ", orderMode=" + orderMode + ", orderCode=" + orderCode + ", orderMethod="
				+ orderMethod + ", orderAccept=" + orderAccept + ", orderDesc=" + orderDesc + "]";
	}
	
	
	



}
