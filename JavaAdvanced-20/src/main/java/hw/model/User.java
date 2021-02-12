package hw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="firstName")
	private String first_Name;
	
	@Column(name="lastName")
	private String last_Name;
	
	@Enumerated(EnumType.STRING)
	@Column(name="role")
	private Role role;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private Status status;
}
