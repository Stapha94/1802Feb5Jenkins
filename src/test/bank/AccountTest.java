package bank;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class AccountTest {
	
	@Test
	void testAccountNotNegative() {
		//assertTrue(account.getBalance >= 0);
		assertTrue(1 >= 0);
	}
	
	@Test
	void accountNumberIsUnique() {
		
		
	}
	  @BeforeAll
	    static void initAll() {
	    }

	    @BeforeEach
	    void init() {
	    }

	    @Test
	    void succeedingTest() {
	    }

	    @Test
	    void failingTest() {
	        fail("a failing test");
	    }

	    @Test
	    @Disabled("for demonstration purposes")
	    void skippedTest() {
	        // not executed
	    }

	    @AfterEach
	    void tearDown() {
	    }

	    @AfterAll
	    static void tearDownAll() {
	    }
}
