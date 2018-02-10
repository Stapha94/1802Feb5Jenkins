package bank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Random; 
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
*/

public class User implements Serializable {

	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;

	String name;
	String email;
	char[] hash;
	char[] salt;

	
	public User() throws ClassNotFoundException, IOException, InterruptedException {
		Menu menu = new Menu();
		login(menu);
	}
	
	public String getEmail() {
		return email;

	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char[] getHash() {
		return hash;
	}

	public void setPassword(char[] password) {
		/*
		byte[] salt = new byte[16];
		SecureRandom random = new SecureRandom();
		random.nextBytes(salt);
		KeySpec spec = new PBEKeySpec("password".toCharArray(), salt, 65536, 128);
		SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
		byte[] hash = f.generateSecret(spec).getEncoded();
		Base64.Encoder enc = Base64.getEncoder();
		System.out.printf("salt: %s%n", enc.encodeToString(salt));
		System.out.printf("hash: %s%n", enc.encodeToString(hash));
		*/
		
		write(this.email, "hash", password.toString());
		this.hash = password;

	}

	
	public static boolean authenticate(String email, char[] password) throws IOException {
		
		//if (read(email, "password").toCharArray() == password) {
			//return true;
		//}

		return false;
	}
	
	
	public void login(Menu menu) throws IOException, InterruptedException, ClassNotFoundException {
		String password = "";
		do {
			setEmail(menu.prompt("login"));
		
			if (!this.exists(email)) {
				menu.printMessage("new user");
				setPassword(menu.prompt("password").toCharArray());
				break;
			}
			setPassword(menu.prompt("password").toCharArray());
		} while (!User.authenticate(email, password.toCharArray()));
		
		/*// The console won't echo passwords but I cannot get it to work
		Console cons;
		char[] passwd;
		if ((cons = System.console()) != null &&
				(passwd = cons.readPassword("[%s]", "Password:")) != null) {
			
			java.util.Arrays.fill(passwd, ' ');
		 }
		 */
	}
	
	public boolean exists(String email) throws IOException, ClassNotFoundException {
		
		if(read(email, "email") != null) {
			return true;
		}
		return false;
	}
	
	public User read(String email, String info) throws IOException, ClassNotFoundException {
		
		ObjectInputStream reader = null;

		try {
			reader = new ObjectInputStream(new FileInputStream("resources/users/" + email));
		} catch (FileNotFoundException e) {
			return null;
			//e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(reader != null) {
				reader.close();
			}
		}
		return (User)reader.readObject(); // TODO: change

	}

	public void write(String email, String label, String info) {
		
		ObjectOutputStream out = null;

		try {
			out = new ObjectOutputStream(new FileOutputStream("resources/users/" + email));
			out.writeObject(this);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	

	@Override
	public String toString() {
		return "User{" +
                "email='" + email + '\'' +
                ", hash=" + hash.toString() +
                ", salt='" + salt.toString() + '\'' +
                '}';

	}

}