package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class LunchAgreementType extends Model {

	public String name;

	public Double rate;

	public Boolean isCashAgreement;

}
