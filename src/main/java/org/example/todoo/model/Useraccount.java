package org.example.todoo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Data;



@Entity
@Table ( name ="useraccount" )
@Data
public class Useraccount  implements Serializable {

	private static final long serialVersionUID =  7164732300148137851L;

	@Id
   	@Column(name = "user_id")
	private Long userId;

   	@Column(name = "user_email")
	private String userEmail;

   	@Column(name = "user_password")
	private String userPassword;

   	@Column(name = "user_name")
	private String userName;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
