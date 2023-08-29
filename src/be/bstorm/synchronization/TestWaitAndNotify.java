package be.bstorm.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Emetteur - Recepteur Synchronisation
 *
 * - L'Emetteur est supposé envoyer un paquet de donnée au Récepteur
 *
 * - Le Récepteur ne doit pas traiter la donnée tant que l'Emetteur n'a
 *   pas fini de l'envoyer
 *
 * - Similairement, l'Emetteur ne devrait pas tenter d'envoyer un autre paquet
 *   à moins que le Récepteur n'ait déjà traité le paquet précédent
 */
public class TestWaitAndNotify {

    public static void main(String[] args) {
        DataExchange dataExchange = new DataExchange();
        Thread sender = new Thread(new Sender(dataExchange));
        Thread receiver = new Thread(new Receiver(dataExchange));

        sender.start();
        receiver.start();
    }
}
