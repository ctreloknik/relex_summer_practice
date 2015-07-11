package ru.relex.summer_practice.db;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Person")
public class Person {

	@Id
	@Column(name = "PersonID")
	@GeneratedValue
	private Long id;
	
	@Column(name = "FullName")
	private String fullname;
	
	@Column(name = "Login")
	private String login;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "PhoneNumber")
	private String phoneNumber;
	
	@Column(name = "Email")
	private String email;

	//
	@OneToMany(mappedBy = "person")
	private Set<PersonTicket> personTicket = new HashSet<PersonTicket>();

	@OneToMany(mappedBy = "person")
	private Set<Founders> founders = new HashSet<Founders>();

	@OneToMany(mappedBy = "person")
	private Set<PersonLectureRole> personLectureRole = new HashSet<PersonLectureRole>();

	public Set<PersonTicket> getPersonTickets() {
		return personTicket;
	}

	public Set<Founders> getFounders() {
		return founders;
	}

	public Set<PersonLectureRole> getPersonLectureRole() {
		return personLectureRole;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}	
}
