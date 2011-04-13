package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Company extends Model {
	public String name;
	public Boolean isAccountEnabled;
	public Boolean isAccountDeleted = Boolean.FALSE;

	@OneToMany(mappedBy="company", cascade=CascadeType.ALL) // TODO: use something other than ALL here
	public List<User> users;
	
	@OneToMany(mappedBy="company", cascade=CascadeType.ALL) // TODO: use something other than ALL here
	public List<LunchAgreement> lunchAgreements;

	public Company(String name) {
		this.name = name;
	}
}
