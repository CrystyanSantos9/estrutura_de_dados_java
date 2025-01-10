package cryss.dev.estrutura_de_dados_java.patterns.observer.old;

import java.util.ArrayList;
import java.util.List;

public class ObserverOld {
    public static void main(String[] args) {
        var stockData = new StockData ();

        var consoleObserver = new ConsoleObserver ();
        var emailObserver = new EmailObserver ();
        var smsOberver = new SMSObserver ();

        stockData.addObserver (consoleObserver);
        stockData.addObserver (emailObserver);
        stockData.addObserver (smsOberver);

        stockData.newStockData ("AAPLS", 50L);
        stockData.newStockData ("ANNLS", 500L);
    }
}

interface Observer {
    void update(String stockName, double stockPrice);
}

class ConsoleObserver implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println ("Console Notification");
    }
}

class EmailObserver implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println ("Email Notification");
    }
}

class SMSObserver implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println ("SMS Notification");
    }
}

class StockData {
    private List<Observer> observers = new ArrayList<> ();
    private String stockName;
    private double stockPrice;

    public void addObserver(Observer observer){
        observers.add (observer);
    }

    public void removeObserver(Observer observer){
        observers.remove (observer);
    }

    public void newStockData(String stockName, double stockPrice){
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        notifyObservers ();
    }

    public void notifyObservers(){
        for(Observer observer: observers){
            observer.update (stockName, stockPrice);
        }
    }

}

