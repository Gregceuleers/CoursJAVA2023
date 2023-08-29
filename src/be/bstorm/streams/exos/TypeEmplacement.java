package be.bstorm.streams.exos;

public enum TypeEmplacement {
    TENTE(35.95),
    CARAVANE(60.50),
    BUNGALOW(120.95),
    MOBILEHOME(45.99);

    private double price;

    public double getPrice() {
        return price;
    }

    TypeEmplacement(double price) {
        this.price = price;
    }
}
