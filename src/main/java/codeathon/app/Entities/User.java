package codeathon.app.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	private String password;
	private String role;
	private String fullname;
	
	public User() {
		super();
	}

	public User(String email, String password, String role, String fullname) {
		
		this.email = email;
		this.password = password;
		this.role = role;
		this.fullname = fullname;
	}
	
 }

