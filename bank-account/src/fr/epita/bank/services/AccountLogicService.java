package fr.epita.bank.services;

import fr.epita.bank.datamodel.InvestmentAccount;
import fr.epita.bank.datamodel.SavingsAccount;
import fr.epita.bank.datamodel.Stock;
import fr.epita.bank.datamodel.StockOrder;

public class AccountLogicService {

    private static final double COMMISSION_RATE = 0.10;
    private static final double DEFAULT_INTEREST_RATE = 0.05;


    public static StockOrder buyStockFromAccount(Stock stock, Double quantity, InvestmentAccount investmentAccount) {
        Double price = stock.getPrice();
        Double commission = COMMISSION_RATE * quantity * price;

        investmentAccount.setBalance(investmentAccount.getBalance() - commission - quantity * price);
        StockOrder order = new StockOrder();
        order.setStock(stock);
        order.setInvestmentAccount(investmentAccount);
        order.setQuantity(quantity);
        order.setUnitPrice(price);

        order.setCommission(commission);
        return order;
    }

    public static void computeInterests(SavingsAccount savingsAccount) {
        Double interestRate = DEFAULT_INTEREST_RATE;
        savingsAccount.setInterestRate(interestRate);
        savingsAccount.setBalance(savingsAccount.getBalance() + interestRate * savingsAccount.getBalance());
    }
}
