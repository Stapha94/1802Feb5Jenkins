package bank;

import java.io.IOException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//logger.fatal("msg") | error | warn | info | debug | trace | all | off
//logger.log(TRANS, "a transaction has been performed")

/**
 * Presents a login interface to the user.
 */
public class Main {


	/**
	 * A custom log level to differentiate transactions from other log messages.
	 */
	final Level TRANS = Level.forName("TRANS", 450);
	static Logger logger = LogManager.getLogger();

	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

		User user = new User();

	}
	
}
