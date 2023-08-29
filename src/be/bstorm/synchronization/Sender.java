package be.bstorm.synchronization;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;

public class Sender implements Runnable{

    private DataExchange dataExchange;

    public Sender(DataExchange dataExchange) {
        this.dataExchange = dataExchange;
    }

    @Override
    public void run() {
        String[] packets = {
                "Premier paquet",
                "Deuxième paquet",
                "Troisième paquet",
                "Quatrième paquet",
                "END"
        };
        for (String packet : packets) {
            dataExchange.send(packet);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread INTERRUPTED");

            }
        }
    }
}
