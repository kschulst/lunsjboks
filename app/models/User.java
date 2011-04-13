package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

import play.db.jpa.Model;

@Entity
public class User extends Model {

	public String username;

	public String password;

	public String firstName;

	public String lastName;

	public String email;

	public String sms;
	
	@ManyToOne
	public Company company;
	
	@OneToOne(mappedBy="user")
	public Card card;

	public Boolean isAccountEnabled;

	public Boolean isAccountDeleted = Boolean.FALSE;

	@Enumerated(EnumType.STRING) 
	public Role role;

	public Double cashBalance;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL) // TODO: Fix cascade
	public List<CashTransaction> cashTransactions;
	
	public enum Role {
		Admin, 
		Superuser, 
		User 
	}
}
