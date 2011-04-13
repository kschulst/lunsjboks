package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.db.jpa.Model;

@Entity
public class LunchAgreement extends Model {

	@ManyToOne
	public Company company;

	@OneToOne
	public LunchAgreementType type;
	
	@OneToMany(mappedBy="lunchAgreement", cascade=CascadeType.ALL) // TODO: Fix cascading
	public List<Card> cards;

}
