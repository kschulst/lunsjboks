package models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.db.jpa.Model;

@Entity
public class Card extends Model {
	public String cardNo;
	
	@OneToOne
	public User user;
	
	@ManyToOne
	public LunchAgreement lunchAgreement;
}
