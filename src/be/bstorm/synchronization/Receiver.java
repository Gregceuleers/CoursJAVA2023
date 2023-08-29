package be.bstorm.synchronization;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable{

    private DataExchange dataExchange;

    public Receiver(DataExchange dataExchange) {
        this.dataExchange = dataExchange;
    }

    @Override
    public void run() {
        for(String receivedMessage = dataExchange.receive(); !"End".equals(receivedMessage); receivedMessage = dataExchange.receive()) {
            System.out.println(receivedMessage);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread INTERRUPTED");
            }
        }
    }
}
