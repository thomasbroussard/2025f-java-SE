import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.Stock;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();
        Stock stock = new Stock();

        stock.setTicker("GOLD");
        stock.setPrice(30000.0);

        //create a scenario where a customer called Quentin wants to buy 1 stock of GOLD,
        //create the required investment account with a sufficient balance
        // when the operation is created, the balance is updated (initial minus the cost of the operation)
        // then Quentin decides to open a savings account and to initialize the balance to 3000€
        // what will be the earned interest over 1 year if he doesn't change the balance




    }
}