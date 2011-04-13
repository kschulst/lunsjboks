package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class CashTransaction extends Model {

	@ManyToOne
	public User user;

	public Double amount;

	public Double balance;

	public Date timestamp;
}
