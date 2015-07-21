package ru.relex.summer_practice.db;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PERSON")
public class Person {

	@Id
	@GeneratedValue
	@Column(name = "PERSON_ID")
	private Long id;
	
	@Column(name = "FULLNAME")
	private String fullname;

	@Column(name="ROLE")
	private String role;

	@Column(name = "LOGIN")
	private String login;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "PHONENUMBER")
	private String phoneNumber;
	
	@Column(name = "EMAIL")
	private String email;

	@Column(name = "CONFIRMED")
	private Boolean confirmed;
	@Column(name = "BALANCE")
	private Integer balance;


	@OneToMany(mappedBy = "person")
	private transient Set<PersonTicket> personTicket = new HashSet<PersonTicket>();

	@OneToMany(mappedBy = "person")
	private transient Set<Founders> founders = new HashSet<Founders>();

	@OneToMany(mappedBy = "person")
	private transient Set<PersonLectureRole> personLectureRole = new HashSet<PersonLectureRole>();

	public Set<PersonTicket> getPersonTickets() {
		return personTicket;
	}

	public Set<Founders> getFounders() {
		return founders;
	}

	public Set<PersonLectureRole> getPersonLectureRole() {
		return personLectureRole;
	}

	@OneToMany(mappedBy = "questioner")
	private transient Set<Question> questions = new HashSet<Question>();

	@OneToMany(mappedBy = "person")
	private transient Set<Rating> ratings = new HashSet<Rating>();

	// GETTERS AND SETTERS
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

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Set<Rating> getRatings() {
		return ratings;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}
}
