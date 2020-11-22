package StockHolders;

import Observers.*;
public class DollStockHolder implements Observer{
    
    private double DollPrice;
    private static int observerIdTracker = 0;
    private int observerId;
    private Subject market;


    public DollStockHolder(Subject market) {
        this.market = market;
        this.observerId = ++this.observerIdTracker;
        System.out.println("Novo observador de dolar, id: " + this.observerId);
        this.market.attach(this);
    }
    @Override
    public void update(double GoldPrice, double DollPrice, double SoyPrice) {
        this.DollPrice = DollPrice;
        this.BuyAndShell();
        
    }
    
    public void BuyAndShell() {
        System.out.println("Doll observer IDTrachar: " + this.observerId + " Cotação do Dolar (USS) internamente: " + this.DollPrice);

        if(this.DollPrice >= 5.70){
            System.out.println("Selling Doll");
            return;
        }
        if(this.DollPrice > 5) {
            System.out.println("Buying Doll");
            return;
        }
        System.out.println("Holding position \n");
    }
}
