package StockHolders;

import Observers.*;
import java.util.ArrayList;

public class StockExchange implements Subject {

    private ArrayList<Observer> observers;
    private double GoldPrice;
    private double DollPrice;
    private double SoyPrice;

    public StockExchange() {
        this.observers = new ArrayList<Observer>();
    }

    public void setState(double doll, double gold, double SoyPrice) {

        this.GoldPrice = gold;
        this.DollPrice = doll;
        this.SoyPrice = SoyPrice;
        this.notifyObservers();
    }

    public double getDoll() {
        return this.DollPrice;
    }

    public double getSoyPrice() {
        return SoyPrice;
    }

    public double getGold() {
        return this.GoldPrice;
    }

    @Override
    public void attach(Observer obs) {
        this.observers.add(obs);
    }

    @Override
    public void detach(Observer obs) {
        int indexOBS = -1;

        indexOBS = this.observers.indexOf(obs);

        if(indexOBS > 0) {
            System.out.println("Removendo objeto na posição "+ indexOBS);
            this.observers.remove(indexOBS);
        } else {
            System.out.println("Objeto não encontrado: "+ indexOBS);
        }
        
    }

    @Override
    public void notifyObservers() {
        this.observers.forEach(obs -> {
            obs.update(this.DollPrice, this.GoldPrice, this.SoyPrice);
        });
    }
    
}
