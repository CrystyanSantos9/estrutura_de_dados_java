package cryss.dev.estrutura_de_dados_java.patterns.observer.newapproach;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class ObserverNewApproach {
    public static void main(String[] args) {
        var stockData = new StockData ();

        //Add novos observer de forma funcional, no formato de lambda funciont BiFunction
        stockData.addObserver ((stockName, stockPrice)->
                System.out.println ("Console notification: " + stockName + ". Price: " + stockPrice));

        stockData.addObserver ((stockName, stockPrice)->
                System.out.println ("Emai notification: " + stockName + ". Price: " + stockPrice));

        stockData.newStockData ("APP", 500D);
        stockData.newStockData ("ACP", 550D);
    }
}


class StockData {
    private final List<BiConsumer<String, Double>> observers = new ArrayList<> ();

    public void addObserver(BiConsumer<String, Double> observer){
        observers.add (observer);
    }

    public void removeObserver(BiConsumer<String, Double> observer){
        observers.remove (observer);
    }

    public void newStockData(String stockName, Double stockPrice){
        observers.forEach (observer-> observer.accept (stockName, stockPrice));
    }

}