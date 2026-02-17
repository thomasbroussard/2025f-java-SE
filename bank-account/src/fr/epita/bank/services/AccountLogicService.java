package fr.epita.bank.services;

import fr.epita.bank.datamodel.InvestmentAccount;
import fr.epita.bank.datamodel.Stock;
import fr.epita.bank.datamodel.StockOrder;

public class AccountLogicService {

    private static final double COMMISSION_RATE = 0.10;

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
}
