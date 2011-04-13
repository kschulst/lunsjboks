import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class ModelTest extends UnitTest {

	@Before
	public void setup() {
		Fixtures.deleteAll();
	}
	
	@Test
	public void validateFixturesSmokeTest() {
		Fixtures.load("data.yml");

		Company udp = Company.find("byName", "UDP AS").first();
	    assertNotNull(udp);
	    assertEquals(3, udp.users.size());

		User kenneth = User.find("byUsername", "kenneth.leine.schulstad").first();
	    assertNotNull(kenneth);
	    assertNotNull(kenneth.card);
	    assertEquals("4700", kenneth.card.cardNo);

	    List<LunchAgreement> udpAgreements = LunchAgreement.find("byCompany", udp).fetch();
	    LunchAgreement udpAgreementStandard = udpAgreements.get(0);
	    assertEquals("Standard", udpAgreementStandard.type.name);
	    LunchAgreement udpAgreementCash = udpAgreements.get(1);
	    assertEquals("Kontant", udpAgreementCash.type.name);
	    
	    assertEquals(udpAgreementStandard, kenneth.card.lunchAgreement);
	    assertEquals(new Double(50), kenneth.card.lunchAgreement.type.rate);
	}
	
	@Test
	public void createAndRetrieveUser() {
		new User("donald", "passord").save();
	    User user = User.find("byUsername", "donald").first();
	    
	    assertNotNull(user);
	    assertEquals("passord", user.password);
	}
	
	@Test
	public void checkCashTransactions() {
		Fixtures.load("data.yml");

		User espen = User.find("byUsername", "espen.schulstad").first();
	    assertNotNull(espen);
	    
	    assertEquals(new Double(875), espen.cashBalance);
	    assertEquals(3, espen.cashTransactions.size());
	    
	    Double balance = 0d;
	    for (CashTransaction tx : espen.cashTransactions) {
	    	balance += tx.amount;
	    }
	    assertEquals(balance, espen.cashBalance);
	}

}
