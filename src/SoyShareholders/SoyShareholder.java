package SoyShareholders;

import Observers.*;
public class SoyShareholder implements Observer{
   
    private double SoyPrice;
    private static int observerIdTracker = 0;
    private int observerId;
    private Subject market;

    // Variaveis de controle de tomadas de decisão
    private double minimumPriceForSoybeanSales;
    private double minimumPriceForBuyingSoybeans;


    public SoyShareholder(Subject market, double minimumPriceForSoybeanSales, double minimumPriceForBuyingSoybeans) {
        this.market = market;
        this.observerId = ++this.observerIdTracker;
        System.out.println("Novo observador de soja cadastrado id: " + this.observerId);
        this.minimumPriceForBuyingSoybeans = minimumPriceForBuyingSoybeans;
        this.minimumPriceForSoybeanSales = minimumPriceForSoybeanSales;

        this.market.attach(this);
    }

    @Override
    public void update(double Doll, double Gold, double SoyPrice) {
        this.SoyPrice = SoyPrice;
        this.BuyAndShell();
    }

    public void BuyAndShell() {
        System.out.println("Soy observer ID: " + this.observerId + " Cotação da soja (USS) internamente: " + this.SoyPrice);

        if(this.SoyPrice >= minimumPriceForSoybeanSales){
            System.out.println("Vendendo soja");
            return;
        }
        if(this.SoyPrice >= minimumPriceForBuyingSoybeans) {
            System.out.println("Comprando soja");
            return;
        }
        System.out.println("Segurando posição \n");
    }
}
