package be.bstorm.streams.exos;

public enum TailleEmplacement {
    S(2,5),
    M(5,8),
    L(8,15),
    XL(15,40);

    private int min;

    private int max;

    TailleEmplacement(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
