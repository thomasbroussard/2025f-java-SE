import fr.epita.bank.datamodel.*;
import fr.epita.bank.services.AccountLogicService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {



    public static void main(String[] args) {

        System.out.println("Welcome to the bank !");

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("please enter the stock ticker :");

            Stock stock = new Stock();
            String tickerName = scanner.nextLine();
            stock.setTicker(tickerName);
            stock.setPrice(30000.0);

            stock = new Stock("GOLD", 30000.0);

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
            AccountLogicService.buyStockFromAccount(stock, quantity, investmentAccount);
            // then Quentin decides to open a savings account and to initialize the balance to 3000€

            SavingsAccount savingsAccount = new SavingsAccount();
            savingsAccount.setBalance(3000.0);


            // what will be the earned interest over 1 year if he doesn't change the balance
            AccountLogicService.computeInterests(savingsAccount);

            System.out.println("final balances : \n - investment " + investmentAccount.getBalance() + "\n - savings " + savingsAccount.getBalance());

        }


    }




}