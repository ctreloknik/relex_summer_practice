package ru.relex.summer_practice.db;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PERSON")
public class Person {

	@Id
	@GeneratedValue
	@Column(name = "PERSONE_ID")
	private Long id;
	
	@Column(name = "FULLNAME")
	private String fullname;
	
	@Column(name = "LOGIN")
	private String login;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "PHONENUMBER")
	private String phoneNumber;
	
	@Column(name = "EMAIL")
	private String email;

	@OneToMany(mappedBy = "questioner")
	private Set<Question> questions = new HashSet<Question>();

	@OneToMany(mappedBy = "person")
	private Set<Rating> ratings = new HashSet<Rating>();

	public Person(){}

	public Person (String fullName, String phoneNumber, String email, String login, String password){
		this.fullname = fullName;
		this.password = password;
		this.email = email;
		this.login = login;
		this.phoneNumber = phoneNumber;
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

	public Set<Rating> getRatings() {
		return ratings;
	}

	public Set<Question> getQuestions() {
		return questions;
	}
}
