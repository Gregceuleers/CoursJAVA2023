package be.bstorm.synchronization.philosophers;

public class DiningPhilosophers {

    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];
        Object[] forks = new Object[philosophers.length];

        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < philosophers.length; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];

            // Impasse peut se produire si les 5 philosophes attrapent tous leurs fourchettes gauches
//            philosophers[i] = new Philosopher(leftFork, rightFork);

            // Evite l'impasse
            if (i == philosophers.length - 1) {
                philosophers[i] = new Philosopher(rightFork, leftFork);
            } else {
                philosophers[i] = new Philosopher(leftFork, rightFork);
            }

            Thread t = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();

        }
    }
}
