import fr.epita.bank.datamodel.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final double COMMISSION_RATE = 0.10;
    public static final double DEFAULT_INTEREST_RATE = 0.05;

    public static void main(String[] args) {

        Stock stock = new Stock();

        stock.setTicker("GOLD");
        stock.setPrice(30000.0);

        //create a scenario where a customer called Quentin wants to buy 1 stock of GOLD,
        Customer customer = new Customer();
        customer.setName("Quentin");


        //create the required investment account with a sufficient balance
        InvestmentAccount investmentAccount = new InvestmentAccount();
        investmentAccount.setBalance(100000.0);
        investmentAccount.setAccountNumber("123456789");
        investmentAccount.setCustomer(customer);


        // when the operation is created, the balance is updated (initial minus the cost of the operation)

        Double quantity = 1.0;
        buyStockFromAccount(stock, quantity, investmentAccount);
        // then Quentin decides to open a savings account and to initialize the balance to 3000€

        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setBalance(3000.0);


        // what will be the earned interest over 1 year if he doesn't change the balance
        Double interestRate = DEFAULT_INTEREST_RATE;
        savingsAccount.setInterestRate(interestRate);
        savingsAccount.setBalance(savingsAccount.getBalance() + interestRate * savingsAccount.getBalance());

        System.out.println("final balances : \n - investment " + investmentAccount.getBalance() + "\n - savings " + savingsAccount.getBalance());



    }

    private static void buyStockFromAccount(Stock stock, Double quantity, InvestmentAccount investmentAccount) {
        Double price = stock.getPrice();
        Double commission = COMMISSION_RATE * quantity * price;

        investmentAccount.setBalance(investmentAccount.getBalance() - commission - quantity * price);
        StockOrder order = new StockOrder();
        order.setStock(stock);
        order.setInvestmentAccount(investmentAccount);
        order.setQuantity(quantity);
        order.setUnitPrice(price);

        order.setCommission(commission);
    }
}