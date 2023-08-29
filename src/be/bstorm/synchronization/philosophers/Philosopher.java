package be.bstorm.synchronization.philosophers;

public class Philosopher implements Runnable{

    private final Object leftFork;
    private final Object rightFork;

    private PhilosopherState state = PhilosopherState.THINKING;

    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        try {
            while (state != PhilosopherState.FINISHING) {
                doAction(System.nanoTime() + ": Pense");
                synchronized (leftFork) {
                    doAction(System.nanoTime() + ": Attrape sa fourchette gauche");
                    synchronized (rightFork) {
                        doAction(System.nanoTime() + ": Attrape sa fourchette droite et mange ...");
                        state = PhilosopherState.EATING;
                        doAction(System.nanoTime() + ": Dépose sa fourchette droite");
                    }
                    doAction(System.nanoTime() + ": Dépose sa fourchette gauche et recommence à penser");
                    state = PhilosopherState.FINISHING;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(
                Thread.currentThread().getName() + " " + action
        );
        Thread.sleep((int) (Math.random() * 100));
    }
}

enum PhilosopherState {
    THINKING,
    EATING,
    FINISHING
}
