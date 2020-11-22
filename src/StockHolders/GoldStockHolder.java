package StockHolders;

import Observers.*;

public class GoldStockHolder implements Observer {

    private double GoldPrice;
    private static int observerIdTracker = 0;
    private int observerId;
    private Subject market;


    public GoldStockHolder(Subject market) {
        this.market = market;
        this.observerId = ++this.observerIdTracker;
        System.out.println("Novo observador de ouro, id: " + this.observerId);
        this.market.attach(this);
    }

    @Override
    public void update(double GoldPrice, double DollPrice, double SoyPrice) {
        this.GoldPrice = GoldPrice;
        this.BuyAndShell();
    }

    public void BuyAndShell() {
        System.out.println("Gold observer IDTrachar: " + this.observerId + " Cotação do Ouro(g) internamente: " + this.GoldPrice);

        if(this.GoldPrice >= 300){
            System.out.println("Selling Gold");
            return;
        }
        if(this.GoldPrice >250) {
            System.out.println("Buying Gold");
            return;
        }
        System.out.println("Holding position \n");
    }
}
