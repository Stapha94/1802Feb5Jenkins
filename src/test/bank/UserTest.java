package bank;

import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.Test;

public class UserTest {
	
	@Test
	void testCanReadDatabase() {
		assertAll(User.read("mail@domain.tld", email));
		
	}
	
	

}
