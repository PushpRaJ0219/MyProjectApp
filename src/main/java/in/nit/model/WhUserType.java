package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="whusertab")
public class WhUserType {
	@Id
	@GeneratedValue
	@Column(name="wuid")
	private Integer userId;
	@Column(name="wutype")	
	private String userType;
	@Column(name="wucode")	
	private String userCode; 
	/*
	 * @Column(name="userFor") private String userFor;
	 */
	@Column(name="wumail")	
	private String userMail; 
	@Column(name="wucontact")	
	private String userContact; 
	@Column(name="wuidtype")	
	private String userIdType; 
	@Column(name="wuoidtype")	
	private String otherIdType; 
	@Column(name="wuidnum")	
	private String idNumber;
	
	public WhUserType() {
		super();
	}

	public WhUserType(Integer userId) {
		super();
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserContact() {
		return userContact;
	}

	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

	public String getUserIdType() {
		return userIdType;
	}

	public void setUserIdType(String userIdType) {
		this.userIdType = userIdType;
	}

	public String getOtherIdType() {
		return otherIdType;
	}

	public void setOtherIdType(String otherIdType) {
		this.otherIdType = otherIdType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	@Override
	public String toString() {
		return "WhUserType [userId=" + userId + ", userType=" + userType + ", userCode=" + userCode + ", userMail="
				+ userMail + ", userContact=" + userContact + ", userIdType=" + userIdType + ", otherIdType="
				+ otherIdType + ", idNumber=" + idNumber + "]";
	}
	
	

	
	
	
	
}
