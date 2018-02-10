package bank;

import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable {

    /**
     * first
     */
    private static final long serialVersionUID = 1L;

    private int number;
    private double balance;
    ArrayList<String> customers = new ArrayList<>();

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<String> getCustomers() {
        return customers;
    }
    public void addCustomer(String customer) {
        customers.add(customer);
    }

    @Override
    public String toString() {
        return "Account{" +
               "number='" + number + '\'' +
               ", balance=" + balance +
               ", customers='" + customers + '\'' +
               '}';

    }

}
